package com.qf.bigdata.util

object ADUtil {
    def req(requestmode:Int,processnode:Int)={
        //判断请求的类型
        if (requestmode == 1 && processnode == 1 )
            List[Double](1,0,0)
        else if (requestmode == 1 && processnode == 2)
            List[Double](1,1,0)
        else if (requestmode == 1 && processnode ==3)
            List[Double](1,1,1)
        else
            List[Double](0,0,0)
    }

    def isBid(iseffective:Int,isbilling: Int, isbid: Int, iswin: Int, adorderid: Int, winprice: Double, adpayment: Double)={
        //判断竞价
        if (iseffective == 1 && isbilling == 1 && isbid ==1)
            if ( iseffective == 1 && isbilling == 1 && iswin == 1 && adorderid != 0)
                List(1,1,winprice/1000,adpayment/1000)
            else
                List(1,0,0.0,0.0)
        else
        List(1,0,0.0,0.0)
    }

    def click(requestmode:Int,iseffective:Int)={
        //判断点击
        if (requestmode == 2 && iseffective ==1 )
            List[Double](1,0)
        else if ( requestmode == 3 && iseffective ==1)
            List[Double](1,1)
        else
            List[Double](0,0)
    }
}
