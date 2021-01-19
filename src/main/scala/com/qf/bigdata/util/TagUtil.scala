package com.qf.bigdata.util

import org.apache.spark.sql.Row

object TagUtil {
  // 获取用户唯一不为空ID
  def getUserId(row: Row) = {
    row match {
      case t if t.getAs("imei")!="" => "IM: "+t.getAs("imei")
      case t if t.getAs("mac")!="" => "MC: "+t.getAs("mac")
      case t if t.getAs("idfa")!="" => "ID: "+t.getAs("idfa")
      case t if t.getAs("openudid")!="" => "OD: "+t.getAs("openudid")
      case t if t.getAs("androidid")!="" => "AD: "+t.getAs("androidid")
    }
  }

}
