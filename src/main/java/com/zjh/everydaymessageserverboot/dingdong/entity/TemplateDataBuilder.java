package com.zjh.everydaymessageserverboot.dingdong.entity;

import cn.hutool.core.util.StrUtil;
import com.zjh.everydaymessageserverboot.dingdong.handel.MessageFactory;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;

/**
 *@filename: TemplateDataBuilder.java
 *@Describe:
 *@Author: Cole.zhou
 *@Date: 2022-08-26 10:02
 */
public class TemplateDataBuilder {

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
