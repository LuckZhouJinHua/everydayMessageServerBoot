package com.zjh.everydaymessageserverboot.dingdong.task;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.zjh.everydaymessageserverboot.dingdong.entity.WeatherInfo;
import com.zjh.everydaymessageserverboot.dingdong.handel.SendMsg;
import com.zjh.everydaymessageserverboot.dingdong.utils.GaodeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import static com.zjh.everydaymessageserverboot.dingdong.utils.GaodeUtil.getAdcCode;

/**
 *@filename: SchedulerTask.java
 *@Describe:
 *@Author: Cole.zhou
 *@Date: 2022-08-24 13:26
 */
@Component
public class SchedulerTask {

    private static final Logger logger = LoggerFactory.getLogger(SchedulerTask.class);

    /**
     * @Description: 每天早上7:30执行一次
     * @Param: []
     * @return: void
     * @Author: cole.zhou
     * @Date: 2022/8/24 下午 1:39
     */
    @Scheduled(cron = "0 * * * * ?")
    public void morningTask() {
        WeatherInfo weather = GaodeUtil.getNowWeatherInfo(getAdcCode("湖北省", "武汉市"));
        logger.info("=====>>>>>使用cron1执行定时任务");
        logger.info("返回数据{}", JSONUtil.toJsonStr(weather));
    }

    /**
     * @Description: 每天中午12:00执行一次
     * @Param: []
     * @return: void
     * @Author: cole.zhou
     * @Date: 2022/8/24 下午 1:39
     */
    @Scheduled(cron = "0 * * * * ?")
    public void noonTask() {
        WeatherInfo weather = GaodeUtil.getNowWeatherInfo(getAdcCode("湖北省", "武汉市"));
        logger.info("=====>>>>>使用cron1执行定时任务");
        logger.info("返回数据{}", JSONUtil.toJsonStr(weather));
    }

    /**
     * @Description: 每天下午15:30执行一次
     * @Param: []
     * @return: void
     * @Author: cole.zhou
     * @Date: 2022/8/24 下午 1:39
     */
    @Scheduled(cron = "0 * * * * ?")
    public void afternoonTask() {
        WeatherInfo weather = GaodeUtil.getNowWeatherInfo(getAdcCode("湖北省", "武汉市"));
        logger.info("=====>>>>>使用cron1执行定时任务");
        logger.info("返回数据{}", JSONUtil.toJsonStr(weather));
    }

    /**
     * @Description: 每天晚上10:30执行一次
     * @Param: []
     * @return: void
     * @Author: cole.zhou
     * @Date: 2022/8/24 下午 1:39
     */
    @Scheduled(cron = "0 * * * * ?")
    public void nightTask() {
        SendMsg.send();
        logger.info("=====>>>>>使用cron2执行定时任务");
    }
}
