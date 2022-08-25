package com.zjh.everydaymessageserverboot.dingdong.utils;

import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.zjh.everydaymessageserverboot.dingdong.entity.WeatherInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * <a href="https://lbs.amap.com">使用的高德</a>
 * @author DokiYolo
 * Date 2022-08-22
 */
@Component
public class GaodeUtil {

    public static Integer getAdcCode(String province, String city) {
        HttpResponse response = HttpUtil.createGet(String.format(ConfigConstants.GAODE_API, ConfigConstants.GAODE_KEY, province, city))
                .setConnectionTimeout(3000)
                .setReadTimeout(4000)
                .execute();
        return JSONUtil.parseObj(JSONUtil.parseObj(response.body()).getJSONArray("geocodes").get(0)).getInt("adcode");
    }

    public static   WeatherInfo getNowWeatherInfo(Integer adcCode) {
        HttpResponse response = HttpUtil.createGet(String.format(ConfigConstants.WEATHER_API, ConfigConstants.GAODE_KEY, adcCode, "base"))
                .setConnectionTimeout(3000)
                .setReadTimeout(4000)
                .execute();
        List<WeatherInfo> lives =
                JSONUtil.parseObj(response.body()).getJSONArray("lives").toList(WeatherInfo.class);
        return lives.get(0);
    }

}
