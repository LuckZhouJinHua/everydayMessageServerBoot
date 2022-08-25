package com.zjh.everydaymessageserverboot.dingdong.handel;

import cn.hutool.core.util.StrUtil;

import com.zjh.everydaymessageserverboot.dingdong.entity.AncientPoetry;
import com.zjh.everydaymessageserverboot.dingdong.entity.Friend;
import com.zjh.everydaymessageserverboot.dingdong.entity.WeatherInfo;
import com.zjh.everydaymessageserverboot.dingdong.utils.ConfigConstants;
import com.zjh.everydaymessageserverboot.dingdong.utils.GaodeUtil;
import com.zjh.everydaymessageserverboot.dingdong.utils.RandomAncientPoetry;
import com.zjh.everydaymessageserverboot.dingdong.utils.Utils;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.springframework.beans.factory.annotation.Value;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static com.zjh.everydaymessageserverboot.dingdong.utils.GaodeUtil.getAdcCode;

/**
 * @author DokiYolo
 * Date 2022-08-22
 */
public class MessageFactory {



    public static WxMpTemplateMessage resolveMessage(Friend friend) {
        return WxMpTemplateMessage.builder()
                .url("https://ofpp.cn") // 点击后的跳转链接 可自行修改 也可以不填
                .toUser(friend.getUserId())
                .templateId(StrUtil.emptyToDefault(friend.getTemplateId(), ConfigConstants.WX_TEMPLATE_ID))
                .data(buildData(friend))
                .build();
    }

    /**
     *
     * {@code {{xxxx.DATA}}} xxxx就是一个变量名，消息中设置变量 然后传递时传递变量即可
     * <br/>
     * 色彩取值可以从这里挑选 https://arco.design/palette/list
     *
     *  <p>
     *      你叫{{friendName.DATA}}
     *      今年{{howOld.DATA}}
     *      距离下一次生日{{nextBirthday.DATA}}天
     *      具体我们的下一次纪念日{{nextMemorialDay.DATA}}天
     *      现在在{{province.DATA}}{{city.DATA}}
     *      当前天气{{weather.DATA}}
     *      当前气温{{temperature.DATA}}
     *      风力描述{{winddirection.DATA}}
     *      风力级别{{windpower.DATA}}
     *      空气湿度{{humidity.DATA}}
     *      {{author.DATA}}
     *      {{origin.DATA}}
     *      {{content.DATA}}
     *  </p>
     */
    private static List<WxMpTemplateData> buildData(Friend friend) {
        WeatherInfo weather = GaodeUtil.getNowWeatherInfo(getAdcCode(friend.getProvince(), friend.getCity()));
        AncientPoetry ancientPoetry = RandomAncientPoetry.getNext();
        ArrayList<WxMpTemplateData> wxMpTemplateData = new ArrayList<>();

        wxMpTemplateData.add(TemplateDataBuilder.builder().name("todayDate").value(Utils.getTodayOfDate(new Date())).color("#771F06").build());
        wxMpTemplateData.add(TemplateDataBuilder.builder().name("friendName").value(friend.getFullName()).color("#D91AD9").build());
        wxMpTemplateData.add(TemplateDataBuilder.builder().name("howOld").value(friend.getHowOld().toString()).color("#F77234").build());
        wxMpTemplateData.add(TemplateDataBuilder.builder().name("howLongLived").value(friend.getHowLongLived()).color("#437004").build());
        wxMpTemplateData.add(TemplateDataBuilder.builder().name("nextBirthday").value(friend.getNextBirthdayDays()).color("#771F06").build());
        wxMpTemplateData.add(TemplateDataBuilder.builder().name("nextMemorialDay").value(friend.getNextMemorialDay()).color("#551DB0").build());
        wxMpTemplateData.add(TemplateDataBuilder.builder().name("province").value(friend.getProvince()).color("#F53F3F").build());
        wxMpTemplateData.add( TemplateDataBuilder.builder().name("city").value(friend.getCity()).color("#FADC19").build());
        wxMpTemplateData.add(TemplateDataBuilder.builder().name("weather").value(weather.getWeather()).color("#00B42A").build());

        wxMpTemplateData.add(TemplateDataBuilder.builder().name("temperature").value(weather.getTemperature()+"℃").color("#722ED1").build());
        wxMpTemplateData.add(TemplateDataBuilder.builder().name("winddirection").value(weather.getWinddirection()+"风").color("#F5319D").build());
        wxMpTemplateData.add(TemplateDataBuilder.builder().name("windpower").value(weather.getWindpower()+"级").color("#3491FA").build());
        wxMpTemplateData.add(TemplateDataBuilder.builder().name("humidity").value(weather.getHumidity()+"%").color("#F77234").build());

        /*特殊天气提示*/
        if(weather.getWeather().contains("云") || weather.getWeather().contains("晴")){
            wxMpTemplateData.add(TemplateDataBuilder.builder().name("weatherTips").value("今日天气感觉不错,要保持好心情哦!").color("#F77234").build());
        }else if(weather.getWeather().contains("雨")){
            wxMpTemplateData.add(TemplateDataBuilder.builder().name("weatherTips").value("今日可能有雨,记得带伞哦,宝!").color("#F77234").build());
        }else if(weather.getWeather().contains("雪")){
            wxMpTemplateData.add(TemplateDataBuilder.builder().name("weatherTips").value("宝贝!下雪啦,要穿暖和出门看你喜欢的雪花!").color("#F77234").build());
        }
        wxMpTemplateData.add(TemplateDataBuilder.builder().name("author").value(ancientPoetry.getAuthor()).color("#F53F3F").build());
        wxMpTemplateData.add(TemplateDataBuilder.builder().name("origin").value(ancientPoetry.getOrigin()).color("#F53F3F").build());
        wxMpTemplateData.add(TemplateDataBuilder.builder().name("content").value(ancientPoetry.getContent()).color("#F53F3F").build());
        return wxMpTemplateData;
    }




    static class TemplateDataBuilder {
        private String name;
        private String value;
        private String color;

        public static TemplateDataBuilder builder() {
            return new TemplateDataBuilder();
        }
        public TemplateDataBuilder name(String name) {
            this.name = name;
            return this;
        }
        public TemplateDataBuilder value(String value) {
            this.value = value;
            return this;
        }
        public TemplateDataBuilder color(String color) {
            this.color = color;
            return this;
        }
        public WxMpTemplateData build() {
            if (StrUtil.hasEmpty(name, value)) {
                throw new IllegalArgumentException("参数不正确");
            }
            WxMpTemplateData data = new WxMpTemplateData();
            data.setName(name);
            data.setValue(value);
            data.setColor(color);
            return data;
        }
    }

}
