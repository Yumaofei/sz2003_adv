package com.qf.bigdata


import com.alibaba.fastjson.{JSON, JSONArray, JSONObject}

import scala.io.Source

object LongAndLat2Addr {
    def main(args: Array[String]): Unit = {
        val url: String = "https://restapi.amap.com/v3/geocode/regeo?location=113.502904,23.278063&key=28278778585e159620cdabfe18286ad6&radius=3000"
        val fileContent: String = Source.fromURL(url, "utf-8").mkString
        val jSONObject: JSONObject = JSON.parseObject(fileContent)
        val businessname: JSONArray = jSONObject.getJSONObject("regeocode").getJSONObject("addressComponent").getJSONArray("businessAreas")
        println(businessname)
        println(fileContent)
    }
}
