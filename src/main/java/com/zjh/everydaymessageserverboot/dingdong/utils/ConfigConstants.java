package com.zjh.everydaymessageserverboot.dingdong.utils;

/**
 *@filename: Constens.java
 *@Describe: 配置类
 *@Author: Cole.zhou
 *@Date: 2022-08-24 10:43
 */
public class ConfigConstants {

    /*公众号APPID*/
    public static final String WX_APP_ID = "wx901077ec177a4dea";

    /*公众号秘钥*/
    public static final String WX_SECRET = "c65d0d06d022c1afbdeec4a441981975";

    /*微信模板id*/
    public static final String WX_TEMPLATE_ID = "HTvbEz22O-f_lRiVdV5Rh-KX_ECTB1nybpCRPCXihTg";

    /*高德地图秘钥*/
    public static final String GAODE_KEY = "5f69460257bc787951c5da939769fb21";

    /*高德地图api*/
    public static final String GAODE_API = "https://restapi.amap.com/v3/geocode/geo?key=%s&address=%s&city=%s";

    /*获取天气api*/
    public static final String WEATHER_API = "https://restapi.amap.com/v3/weather/weatherInfo?key=%s&city=%d&extensions=%s";

    /*获取随机古诗api*/
    public static final String MSG_GUSHI = "https://v1.jinrishici.com/shuqing/aiqing";
}
