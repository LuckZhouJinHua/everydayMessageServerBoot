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


    /*高德地图秘钥*/
    public static final String GAODE_KEY = "5f69460257bc787951c5da939769fb21";

    /*高德地图api*/
    public static final String GAODE_API = "https://restapi.amap.com/v3/geocode/geo?key=%s&address=%s&city=%s";

    /*获取天气api*/
    public static final String WEATHER_API = "https://restapi.amap.com/v3/weather/weatherInfo?key=%s&city=%d&extensions=%s";

    /*获取随机古诗api*/
    public static final String MSG_GUSHI = "https://v1.jinrishici.com/shuqing/aiqing";


    /*微信模板id*/
    public static final String WX_TEMPLATE_ID_EVERY_DAY = "isir7UNk8Ryg9eupHVJXGqJZKtfi3XAOxrO_f2f4uBc";
    public static final String WX_TEMPLATE_ID_MORNING = "UnI7TjIvku2Hp_dMdUE3YYLIsZL5Dc4irO8ts0EhNwg";
    public static final String WX_TEMPLATE_ID_NOON = "LjrxIax22WgKiBDX18BH2cUn6zqNfRVthY3_ntlOVUA";
    public static final String WX_TEMPLATE_ID_AFTERNOON = "LjrxIax22WgKiBDX18BH2cUn6zqNfRVthY3_ntlOVUA";
    public static final String WX_TEMPLATE_ID_NIGHT = "cXu_Q1bBpKzBoyuFvsIWA7GyPpzy2m_M7dbsLw0FioQ";


    /*每日模板类型*/
    public static final String EVERY_DAY_TEMPLATE = "0";

    /*上午模板类型*/
    public static final String MORNING_TEMPLATE = "1";

    /*中午模板类型*/
    public static final String NOON_TEMPLATE = "2";

    /*下午模板类型*/
    public static final String AFTERNOON_TEMPLATE = "3";

    /*晚间模板类型*/
    public static final String NIGHT_TEMPLATE = "4";

    /*自定义模板类型*/
    public static final String DEFAULT_TEMPLATE = "666";

}
