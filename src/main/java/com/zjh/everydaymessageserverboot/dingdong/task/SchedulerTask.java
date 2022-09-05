package com.zjh.everydaymessageserverboot.dingdong.task;

import com.zjh.everydaymessageserverboot.dingdong.entity.GirlFriend;
import com.zjh.everydaymessageserverboot.dingdong.handel.SendMsg;
import com.zjh.everydaymessageserverboot.dingdong.utils.ConfigConstants;
import com.zjh.everydaymessageserverboot.dingdong.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


/**
 *@filename: SchedulerTask.java
 *@Describe:
 *@Author: Cole.zhou
 *@Date: 2022-08-24 13:26
 */
@Component
public class SchedulerTask {

    private static final Logger logger = LoggerFactory.getLogger(SchedulerTask.class);

    static String xiaofei = "o_st-57nd9HXV8Br8ZbloAvCVpS8";

    static String my = "o_st-5_rt_OAIBr3S6dPeECurmOc";

    private static final GirlFriend girlFriend = new GirlFriend(Utils.getRandomName(), "湖北省", "武汉市", "1998-09-27", "2020-01-05", xiaofei);

    /**
     * @Description: 每天早上7:30执行一次
     * @Param: []
     * @return: void
     * @Author: cole.zhou
     * @Date: 2022/8/24 下午 1:39
     */
    @Scheduled(cron = "0 30 7 * * ?")
    public void everyDayTask() {
        SendMsg.send(girlFriend, ConfigConstants.EVERY_DAY_TEMPLATE);
        logger.info("=====>>>>>everyDayTask执行定时任务成功.");
    }

    /**
     * @Description: 上午10:30执行
     * @Param: []
     * @return: void
     * @Author: cole.zhou
     * @Date: 2022/8/26 下午 2:56
     */
    @Scheduled(cron = "0 30 10 * * ?")
    public void morningTask() {
        SendMsg.send(girlFriend, ConfigConstants.MORNING_TEMPLATE);
        logger.info("=====>>>>>morningTask执行定时任务成功.");
    }

    /**
     * @Description: 每天中午12:00执行一次
     * @Param: []
     * @return: void
     * @Author: cole.zhou
     * @Date: 2022/8/24 下午 1:39
     */
    @Scheduled(cron = "0 00 12 * * ?")
    public void noonTask() {
        SendMsg.send(girlFriend, ConfigConstants.NOON_TEMPLATE);
        logger.info("=====>>>>>noonTask执行定时任务成功.");
    }

    /**
     * @Description: 每天下午15:30执行一次
     * @Param: []
     * @return: void
     * @Author: cole.zhou
     * @Date: 2022/8/24 下午 1:39
     */
    @Scheduled(cron = "0 30 15 * * ?")
    public void afternoonTask() {
        SendMsg.send(girlFriend, ConfigConstants.AFTERNOON_TEMPLATE);
        logger.info("=====>>>>>afternoonTask执行定时任务成功.");
    }

    /**
     * @Description: 每天晚上10:30执行一次
     * @Param: []
     * @return: void
     * @Author: cole.zhou
     * @Date: 2022/8/24 下午 1:39
     */
    @Scheduled(cron = "0 30 22 * * ?")
    public void nightTask() {
        SendMsg.send(girlFriend, ConfigConstants.NIGHT_TEMPLATE);
        logger.info("=====>>>>>nightTask执行定时任务成功.");
    }



//    @Scheduled(cron = "0 53,54,55,56,57,58,59 2 * * ?")
//    public void test() {
//        GirlFriend girlFriend = new GirlFriend(Utils.getRandomName(), "湖北省", "武汉市", "1998-09-27", "2020-01-05", my);
//        SendMsg.send(girlFriend, ConfigConstants.MORNING_TEMPLATE);
////        SendMsg.send(girlFriend, ConfigConstants.NIGHT_TEMPLATE);
//        logger.info("=====>>>>>nightTask执行定时任务成功111111111111111111111111.");
//    }


    public static void main(String[] args) {

        GirlFriend girlFriend = new GirlFriend(Utils.getRandomName(), "湖北省", "武汉市", "1998-09-02", "2020-01-05", my);
        SendMsg.send(girlFriend, ConfigConstants.NIGHT_TEMPLATE);
    }


}
