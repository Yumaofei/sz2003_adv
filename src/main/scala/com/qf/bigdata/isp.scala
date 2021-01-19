package com.qf.bigdata

import com.qf.bigdata.util.ADUtil
import org.apache.spark.sql.{DataFrame, SparkSession}

object isp {
    def main(args: Array[String]): Unit = {
        System.setProperty("hadoop.home.dir","H://hadoop-common")
        val session: SparkSession = SparkSession.builder().appName("isp").master("local").getOrCreate()
        val frame: DataFrame = session.read.load("output/rs")
        frame.rdd.map(row=>{
            val requestmode: Int = row.getAs[Int]("requestmode")
            val processnode: Int = row.getAs[Int]("processnode")
            val iseffective: Int = row.getAs[Int]("iseffective")
            val isbilling: Int = row.getAs[Int]("isbilling")
            val isbid: Int = row.getAs[Int]("isbid")
            val iswin: Int = row.getAs[Int]("iswin")
            val adorderid: Int = row.getAs[Int]("adorderid")
            val winprice: Double = row.getAs[Double]("winprice")
            val adpayment: Double = row.getAs[Double]("adpayment")
            val doubles: List[Double] = ADUtil.req(requestmode, processnode)
            val doubles1: List[Double] = ADUtil.isBid(iseffective, isbilling, isbid, iswin, adorderid, winprice, adpayment)
            val doubles2: List[Double] = ADUtil.click(requestmode, iseffective)
            val doubles3: List[Double] = doubles ++ doubles1 ++ doubles2
            var str:String = row.getAs[String]("ispname")
            if (str.equals("未知"))
                str="其他"
            (str,doubles3)
        }).reduceByKey((l1,l2)=>{
            l1.zip(l2).map(x=>x._1+x._2)
        }).foreach(println)
    }
}
