package com.zjh.everydaymessageserverboot.dingdong.handel;
import cn.hutool.json.JSONUtil;
import com.zjh.everydaymessageserverboot.dingdong.entity.AncientPoetry;
import com.zjh.everydaymessageserverboot.dingdong.entity.Friend;
import com.zjh.everydaymessageserverboot.dingdong.entity.TemplateDataBuilder;
import com.zjh.everydaymessageserverboot.dingdong.entity.WeatherInfo;
import com.zjh.everydaymessageserverboot.dingdong.utils.ConfigConstants;
import com.zjh.everydaymessageserverboot.dingdong.utils.GaodeUtil;
import com.zjh.everydaymessageserverboot.dingdong.utils.Utils;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;


/**
 * @Description:  消息处理工厂类
 * @Param:
 * @return:
 * @Author:  cole.zhou
 * @Date:  2022/8/26 上午 10:11
 */
public class MessageFactory {

    private static final Logger logger = LoggerFactory.getLogger(MessageFactory.class);


    /**
     * @Description:  根据类型返回对应的封装数据
     * @Param:  [friend, msgType]
     * @return:  java.util.List<me.chanjar.weixin.mp.bean.template.WxMpTemplateData>
     * @Author:  cole.zhou
     * @Date:  2022/8/26 下午 2:00
     */
    public static List<WxMpTemplateData> getTemplateData(Friend friend, String msgType) {
        if (ConfigConstants.EVERY_DAY_TEMPLATE.equals(msgType)) {
            return everyDayTemplate(friend);
        } else if (ConfigConstants.MORNING_TEMPLATE.equals(msgType)) {
            return morningTemplateData(friend);
        } else if (ConfigConstants.NOON_TEMPLATE.equals(msgType)) {
            return noonTemplateData(friend);
        } else if (ConfigConstants.AFTERNOON_TEMPLATE.equals(msgType)) {
            return afternoonTemplateData(friend);
        } else if (ConfigConstants.NIGHT_TEMPLATE.equals(msgType)) {
            return nightTemplateData(friend);
        } else if (ConfigConstants.DEFAULT_TEMPLATE.equals(msgType)) {
            return defaultTemplateData(friend.getFullName());
        }
        logger.error("模板均未匹配上,返回默认错误模板...{},{}", JSONUtil.toJsonStr(friend), msgType);
        return Collections.emptyList();
    }

    /**
     *
     * {@code {{xxxx.DATA}}} xxxx就是一个变量名，消息中设置变量 然后传递时传递变量即可
     * <br/>
     * 色彩取值可以从这里挑选 https://arco.design/palette/list
     *
     */

    /**
     * @Description:  每日提醒
     * @Param:  [friend]
     * @return:  java.util.List<me.chanjar.weixin.mp.bean.template.WxMpTemplateData>
     * @Author:  cole.zhou
     * @Date:  2022/8/26 上午 9:55
     */
    public static List<WxMpTemplateData> everyDayTemplate(Friend friend) {
        /*获取天气信息*/
        WeatherInfo weather = GaodeUtil.getNowWeatherInfo(GaodeUtil.getAdcCode(friend.getProvince(), friend.getCity()));
        /*获取随机古诗*/
        AncientPoetry ancientPoetry = Utils.getNext();

        ArrayList<WxMpTemplateData> wxMpTemplateData = new ArrayList<>();


        wxMpTemplateData.add(TemplateDataBuilder.builder().name("friendName").value(friend.getFullName() + " 早上好").color("#F53F3F").build());
        wxMpTemplateData.add(TemplateDataBuilder.builder().name("todayDate").value(Utils.getTodayOfDate(new Date())).color("#F77234").build());
        wxMpTemplateData.add(TemplateDataBuilder.builder().name("howOld").value(friend.getHowOld().toString()).color("#FF9A2E").build());
        wxMpTemplateData.add(TemplateDataBuilder.builder().name("howLongLived").value(friend.getHowLongLived()).color("#F9CC45").build());
        wxMpTemplateData.add(TemplateDataBuilder.builder().name("nextBirthday").value(friend.getNextBirthdayDays()).color("#FADC19").build());

        wxMpTemplateData.add(TemplateDataBuilder.builder().name("nextMemorialDay").value(friend.getNextMemorialDay()).color("#9FDB1D").build());
        wxMpTemplateData.add(TemplateDataBuilder.builder().name("province").value(friend.getProvince()).color("#4CD263").build());
        wxMpTemplateData.add( TemplateDataBuilder.builder().name("city").value(friend.getCity()).color("#4CD263").build());
        wxMpTemplateData.add(TemplateDataBuilder.builder().name("weather").value(weather.getWeather()).color("#37D4CF").build());

        wxMpTemplateData.add(TemplateDataBuilder.builder().name("temperature").value(weather.getTemperature()+"℃").color("#37D4CF").build());
        wxMpTemplateData.add(TemplateDataBuilder.builder().name("winddirection").value(weather.getWinddirection()+"风").color("#57A9FB").build());
        wxMpTemplateData.add(TemplateDataBuilder.builder().name("windpower").value(weather.getWindpower()+"级").color("#57A9FB").build());
        wxMpTemplateData.add(TemplateDataBuilder.builder().name("humidity").value(weather.getHumidity()+"%").color("#4080FF").build());

        /*特殊天气提示*/
        if(weather.getWeather().contains("云") || weather.getWeather().contains("晴")){
            wxMpTemplateData.add(TemplateDataBuilder.builder().name("weatherTips").value("今日天气感觉不错,要保持好心情哦!").color("#8D4EDA").build());
        }else if(weather.getWeather().contains("雨")){
            wxMpTemplateData.add(TemplateDataBuilder.builder().name("weatherTips").value("今日可能有雨,记得带伞哦,宝!").color("#8D4EDA").build());
        }else if(weather.getWeather().contains("雪")){
            wxMpTemplateData.add(TemplateDataBuilder.builder().name("weatherTips").value("宝贝!下雪啦,要穿暖和出门看你喜欢的雪花!").color("#8D4EDA").build());
        }
        wxMpTemplateData.add(TemplateDataBuilder.builder().name("author").value(ancientPoetry.getAuthor()).color("#4e5969").build());
        wxMpTemplateData.add(TemplateDataBuilder.builder().name("origin").value(ancientPoetry.getOrigin()).color("#4e5969").build());
        wxMpTemplateData.add(TemplateDataBuilder.builder().name("content").value(ancientPoetry.getContent()).color("#4e5969").build());
        return wxMpTemplateData;
    }



    /**
     * @Description:  上午提醒
     * @Param:  []
     * @return:  java.util.List<me.chanjar.weixin.mp.bean.template.WxMpTemplateData>
     * @Author:  cole.zhou
     * @Date:  2022/8/26 上午 9:55
     */
    public static List<WxMpTemplateData> morningTemplateData(Friend friend){

        AncientPoetry ancientPoetry = Utils.getNext();


        ArrayList<WxMpTemplateData> wxMpTemplateData = new ArrayList<>();


        wxMpTemplateData.add(TemplateDataBuilder.builder().name("wenhouyu").value("上午好呀," +friend.getFullName()).color("#F53F3F").build());
        wxMpTemplateData.add(TemplateDataBuilder.builder().name("msg1").value("如果此时的我没有跟你发消息").color("#F77234").build());
        wxMpTemplateData.add(TemplateDataBuilder.builder().name("msg2").value("并不代表不想你").color("#FF9A2E").build());
        wxMpTemplateData.add(TemplateDataBuilder.builder().name("msg3").value("恰恰是我一直在想你哦").color("#F9CC45").build());
        wxMpTemplateData.add(TemplateDataBuilder.builder().name("msg4").value("上午的时光总是很短暂").color("#FADC19").build());

        wxMpTemplateData.add(TemplateDataBuilder.builder().name("msg5").value("就像和你在一起的日子一样").color("#FCF26B").build());
        wxMpTemplateData.add(TemplateDataBuilder.builder().name("msg6").value("过的飞快,稍不留神").color("#9FD4FD").build());
        wxMpTemplateData.add(TemplateDataBuilder.builder().name("msg7").value("便悄然成了过往...").color("#A871E3").build());
        wxMpTemplateData.add(TemplateDataBuilder.builder().name("msg8").value("好在每个新的一天").color("#9FDB1D").build());
        wxMpTemplateData.add(TemplateDataBuilder.builder().name("msg9").value("你都能在我的身边").color("#AFF0B5").build());
        wxMpTemplateData.add(TemplateDataBuilder.builder().name("msg10").value("我们,一起!").color("#F53F3F").build());

        wxMpTemplateData.add(TemplateDataBuilder.builder().name("msg11").value("爱你呀!(恭喜你发现隐藏秘密!!!)").color("#f2f3f5").build()); //灰色 很隐蔽

        wxMpTemplateData.add(TemplateDataBuilder.builder().name("tips1").value("记得喝水水").color("#FF7D00").build());
        wxMpTemplateData.add(TemplateDataBuilder.builder().name("tips2").value("记得也想我").color("#FF7D00").build());
        wxMpTemplateData.add(TemplateDataBuilder.builder().name("tips3").value("记得稍微运动").color("#FF7D00").build());

        wxMpTemplateData.add(TemplateDataBuilder.builder().name("content").value(ancientPoetry.getContent()).color("#F53F3F").build());


        return wxMpTemplateData;

    }


    /**
     * @Description:  中午提醒数据
     * @Param:  []
     * @return:  java.util.List<me.chanjar.weixin.mp.bean.template.WxMpTemplateData>
     * @Author:  cole.zhou
     * @Date:  2022/8/26 上午 9:55
     */
    public static List<WxMpTemplateData> noonTemplateData(Friend friend){
        ArrayList<WxMpTemplateData> wxMpTemplateData = new ArrayList<>();
        String  content =
                friend.getFullName()+" 中午好呀!\n"
                + "中午是我们能在一起的时间最少的时候 \n"
                + "因为清晨能伴你醒来 \n"
                + "晚上能陪你入睡 \n"
                + "所以啊,我不在的时候你要记得吃饭 \n"
                + "照顾好自己 \n"
                + "这个中午也是爱你的中午! \n"
                ;
        wxMpTemplateData.add(TemplateDataBuilder.builder().name("MSG").value(content).build());
        return wxMpTemplateData;
    }

    /**
     * @Description:  下午提醒数据
     * @Param:  []
     * @return:  java.util.List<me.chanjar.weixin.mp.bean.template.WxMpTemplateData>
     * @Author:  cole.zhou
     * @Date:  2022/8/26 上午 9:55
     */
    public static List<WxMpTemplateData> afternoonTemplateData(Friend friend){
        ArrayList<WxMpTemplateData> wxMpTemplateData = new ArrayList<>();
        String  content =
                        friend.getFullName()+ " 下午好呀!\n"
                        + " 喝水\n"
                        + " 活动\n"
                        + " 眺望\n"
                        + " 休息\n"
                        + " 提醒4连...\n"
                ;
        wxMpTemplateData.add(TemplateDataBuilder.builder().name("MSG").value(content).build());
        return wxMpTemplateData;

    }


    /**
     * @Description:  晚上提醒数据
     * @Param:  []
     * @return:  java.util.List<me.chanjar.weixin.mp.bean.template.WxMpTemplateData>
     * @Author:  cole.zhou
     * @Date:  2022/8/26 上午 9:55
     */
    public static List<WxMpTemplateData> nightTemplateData(Friend friend){

        ArrayList<WxMpTemplateData> wxMpTemplateData = new ArrayList<>();
        wxMpTemplateData.add(TemplateDataBuilder.builder().name("wenhouyu").value("晚上好呀," +friend.getFullName()).color("#F53F3F").build());
        wxMpTemplateData.add(TemplateDataBuilder.builder().name("msg1").value("此时此刻的你应该正在享受这美好的夜晚").color("#F77234").build());
        wxMpTemplateData.add(TemplateDataBuilder.builder().name("msg2").value("此时此刻的星星像是在为我们布置一场浪漫的荧幕").color("#FF9A2E").build());
        wxMpTemplateData.add(TemplateDataBuilder.builder().name("msg3").value("我多希望现在的我能够在你身边").color("#F9CC45").build());
        wxMpTemplateData.add(TemplateDataBuilder.builder().name("msg4").value("和你躺在一起").color("#FADC19").build());
        wxMpTemplateData.add(TemplateDataBuilder.builder().name("msg5").value("要知道,每一个夜晚").color("#9FDB1D").build());
        wxMpTemplateData.add(TemplateDataBuilder.builder().name("msg6").value("都是月亮和星星相遇的时候").color("#4CD263").build());
        wxMpTemplateData.add(TemplateDataBuilder.builder().name("msg7").value("就像我们,如此一样").color("#37D4CF").build());
        wxMpTemplateData.add(TemplateDataBuilder.builder().name("msg8").value("今天已成过往,明天依旧晴朗").color("#57A9FB").build());
        wxMpTemplateData.add(TemplateDataBuilder.builder().name("msg9").value("今日与明朝都是爱你的一整天").color("#4080FF").build());
        wxMpTemplateData.add(TemplateDataBuilder.builder().name("msg10").value("早早入睡,保持好心情").color("#8D4EDA").build());
        wxMpTemplateData.add(TemplateDataBuilder.builder().name("msg11").value("晚安,我的宝! ♥").color("#F5319D").build());
        return wxMpTemplateData;

    }


    /**
     * @Description:  自定义消息
     * @Param:  [content]
     * @return:  java.util.List<me.chanjar.weixin.mp.bean.template.WxMpTemplateData>
     * @Author:  cole.zhou
     * @Date:  2022/8/26 下午 2:01
     */
    public static List<WxMpTemplateData> defaultTemplateData(String content){
        ArrayList<WxMpTemplateData> wxMpTemplateData = new ArrayList<>();
        wxMpTemplateData.add(TemplateDataBuilder.builder().name("MSG").value(content).build());
        return wxMpTemplateData;
    }


}
