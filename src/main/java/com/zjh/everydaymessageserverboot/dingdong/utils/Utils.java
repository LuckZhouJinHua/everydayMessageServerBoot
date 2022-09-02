package com.zjh.everydaymessageserverboot.dingdong.utils;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.zjh.everydaymessageserverboot.dingdong.entity.AncientPoetry;
import com.zjh.everydaymessageserverboot.dingdong.entity.TianXingInnerData;
import com.zjh.everydaymessageserverboot.dingdong.entity.TianXingRespData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *@filename: Utils.java
 *@Describe:
 *@Author: Cole.zhou
 *@Date: 2022-08-24 10:32
 */
public class Utils {

    private static final Logger logger = LoggerFactory.getLogger(Utils.class);


    public static TianXingInnerData gethualihushao(String type) {
        String  result = null;
        TianXingInnerData tianXingInnerData = null;
        if(type.equals("1")){
            result = sendPost(ConfigConstants.caihonhpi);
        }else if(type.equals("2")){
            result = sendPost(ConfigConstants.qinghua);
        } else if(type.equals("3")){
            result = sendPost(ConfigConstants.zaoan);
        }
        if(result == null){
            logger.error("请求出错了吧!返回了空数据");
            return tianXingInnerData;
        }
        TianXingRespData tianXingRespData = JSON.parseObject(result, TianXingRespData.class);
         tianXingInnerData = tianXingRespData.getNewslist().get(0);
        return tianXingInnerData;
    }


    private static String sendPost(String sendUrl)  {
        StringBuilder sbf = new StringBuilder();
        String result ;
        BufferedReader reader;
        try {
            URL url = new URL(sendUrl);
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
        } catch (IOException e) {
            logger.error("发送请求异常,获取天行接口数据失败:{}" , JSONUtil.toJsonStr(e));
            return null;
        }
        result = sbf.toString();
        return result;
    }

    public static void main(String[] args) {
        TianXingInnerData gethualihushao = gethualihushao("3");
        System.out.println("caiHongPi = " + JSON.toJSONString(gethualihushao));



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
