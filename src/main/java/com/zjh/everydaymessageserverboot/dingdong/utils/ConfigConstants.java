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

    /*天行接口key*/
    public static final String TIAN_XING = "b9609d80cfdf734dfb3503f8bda81992";

    //彩虹屁接口 每天100次免费
    public static final String caihonhpi = "http://api.tianapi.com/caihongpi/index?key="+ConfigConstants.TIAN_XING;
    //土味情话接口
    public static final String qinghua = "http://api.tianapi.com/saylove/index?key="+ConfigConstants.TIAN_XING;
    //早安心语
    public static final String zaoan = "http://api.tianapi.com/zaoan/index?key="+ConfigConstants.TIAN_XING;

    //晚安心语
    public static final String wanan = "http://api.tianapi.com/wanan/index?key="+ConfigConstants.TIAN_XING;




    /*微信模板id*/
    public static final String WX_TEMPLATE_ID_EVERY_DAY = "WGZwwDbpApR2yttaaCTaZ7M9126v0xcREVGOlLq9wgE";
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
