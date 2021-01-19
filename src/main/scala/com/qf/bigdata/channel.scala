package com.qf.bigdata

import org.apache.spark.sql.{DataFrame, SparkSession}

object channel {
    def main(args: Array[String]): Unit = {
        System.setProperty("hadoop.home.dir","H://hadoop-common")
        val session: SparkSession = SparkSession.builder().appName("network").master("local").getOrCreate()
        val frame: DataFrame = session.read.load("output/rs")
        frame.select("long","lat").show()
    }
}
