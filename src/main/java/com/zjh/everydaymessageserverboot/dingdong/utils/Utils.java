package com.zjh.everydaymessageserverboot.dingdong.utils;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.zjh.everydaymessageserverboot.dingdong.entity.AncientPoetry;
import com.zjh.everydaymessageserverboot.dingdong.entity.TianXingRespData;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static org.apache.logging.log4j.message.MapMessage.MapFormat.JSON;

/**
 *@filename: Utils.java
 *@Describe:
 *@Author: Cole.zhou
 *@Date: 2022-08-24 10:32
 */
public class Utils {


    public static String getCaiHongPi() {
        //彩虹屁接口 每天100次免费
        String httpUrl = "http://api.tianapi.com/caihongpi/index?key=b9609d80cfdf734dfb3503f8bda81992";
        //土味情话接口
        String qinghua = "http://api.tianapi.com/saylove/index?key=b9609d80cfdf734dfb3503f8bda81992";
        BufferedReader reader = null;
        String result = null;
        StringBuffer sbf = new StringBuffer();

        try {
            URL url = new URL(qinghua);
            HttpURLConnection connection = (HttpURLConnection) url
                    .openConnection();
            connection.setRequestMethod("GET");
            InputStream is = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
            String strRead = null;
            while ((strRead = reader.readLine()) != null) {
                sbf.append(strRead);
                sbf.append("\r\n");
            }
            reader.close();
            result = sbf.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }

        JSONObject jsonObject = JSONUtil.parseObj(result);
        JSONArray newslist = jsonObject.getJSONArray("newslist");
        JSONObject content = newslist.getJSONObject(0);
        String content1 = (String) content.get("content");
        return content1;
    }

    public static void main(String[] args) {
        String caiHongPi = getCaiHongPi();
        System.out.println("caiHongPi = " + caiHongPi);
    }


    /**
     * 获取臭猪随机称呼
     * @return
     */
    public static String getRandomName(){

        int index = (int)(Math.random()*5);

        String[] LovelyNikeName = {"亲爱的小费老师!","最爱的宝贝猪!","正在努力的臭宝!","每天放屁的航航!","可爱动人的臭猪"};

        return LovelyNikeName[index];

    }



    public static String getTodayOfDate(Date dt) {
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;
        String format = new SimpleDateFormat("yyyy年MM月dd").format(dt);
        return format +" " + weekDays[w];
    }


    public static AncientPoetry getNext() {
        String res = HttpUtil.get(ConfigConstants.MSG_GUSHI, 4000);
        return JSONUtil.parseObj(res).toBean(AncientPoetry.class);
    }

}
