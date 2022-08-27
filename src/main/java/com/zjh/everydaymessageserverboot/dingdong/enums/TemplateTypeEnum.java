package com.zjh.everydaymessageserverboot.dingdong.enums;

import com.zjh.everydaymessageserverboot.dingdong.handel.MessageFactory;
import com.zjh.everydaymessageserverboot.dingdong.utils.ConfigConstants;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;

import java.util.List;

/**
 *@filename: TemplateTypeEnum.java
 *@Describe:
 *@Author: Cole.zhou
 *@Date: 2022-08-26 09:11
 */
public enum TemplateTypeEnum {

    EVERY_DAY_TEMPLATE_TYPE("0", ConfigConstants.WX_TEMPLATE_ID_EVERY_DAY), /*每日模板类型*/
    MORNING_TEMPLATE_TYPE("1", ConfigConstants.WX_TEMPLATE_ID_MORNING), /*上午模板类型*/
    NOON_TEMPLATE_TYPE("2", ConfigConstants.WX_TEMPLATE_ID_NOON), /*中午模板类型*/
    AFTERNOON_TEMPLATE_TYPE("3", ConfigConstants.WX_TEMPLATE_ID_AFTERNOON), /*下午模板类型*/
    NIGHT_TEMPLATE_TYPE("4", ConfigConstants.WX_TEMPLATE_ID_NIGHT);/*晚间模板类型*/

    private String type;

    private String templateType;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTemplateType() {
        return templateType;
    }

    public void setTemplateType(String templateType) {
        this.templateType = templateType;
    }

    TemplateTypeEnum(String type, String templateType) {
        this.type = type;
        this.templateType = templateType;
    }


    public static String getTemplateType(String type) {
        TemplateTypeEnum[] values = TemplateTypeEnum.values();
        for (TemplateTypeEnum clazzEnum : values) {
            if (type.equals(clazzEnum.type)) {
                return clazzEnum.templateType;
            }
        }
        return null;
    }

}
