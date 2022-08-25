package com.zjh.everydaymessageserverboot.dingdong.utils;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.zjh.everydaymessageserverboot.dingdong.entity.AncientPoetry;
import org.springframework.beans.factory.annotation.Value;

/**
 * 随机爱情古诗
 * @author DokiYolo
 * Date 2022-08-22
 */
public class RandomAncientPoetry {



    public static AncientPoetry getNext() {
        String res = HttpUtil.get(ConfigConstants.MSG_GUSHI, 4000);
        return JSONUtil.parseObj(res).toBean(AncientPoetry.class);
    }
}
