package com.cx.test.enums;

import java.util.Objects;

/**
 * @author chenxiang
 * @vesion 1.0
 * @Description 权益类型
 * @createTime 2022-04-30 14:00:00
 */
public enum ProfitItemType {

    COUPON("2-1","卡券"), GIFT("2-2","礼包"),
    CASH("2-3","现金"),POINT("2-4","积分"),
    CASH_COUPON(CASH,COUPON,"2-5","现金+卡券"),
    CASH_POINT(CASH,POINT,"2-6","现金+积分");


    ;
    private String itemType;
    private String desc;
    private ProfitItemType profitItemTypeOne;
    private ProfitItemType profitItemTypeTwo;

    public String getItemType() {
        return itemType;
    }

    public String getDesc() {
        return desc;
    }

    ProfitItemType(String itemType, String desc) {
        this.itemType = itemType;
        this.desc = desc;
    }

    ProfitItemType(ProfitItemType profitItemTypeOne, ProfitItemType profitItemTypeTwo,String itemType, String desc) {
        this.itemType = itemType;
        this.desc = desc;
        this.profitItemTypeOne = profitItemTypeOne;
        this.profitItemTypeTwo = profitItemTypeTwo;
    }

    public static ProfitItemType getProfitItemTypeByTwo(ProfitItemType one,ProfitItemType two){
        for (ProfitItemType profitItemType: ProfitItemType.values()) {
            if(one !=null && two !=null
                    &&((profitItemType.profitItemTypeTwo ==one && profitItemType.profitItemTypeOne ==two) || (profitItemType.profitItemTypeTwo ==two && profitItemType.profitItemTypeOne ==one))){
                return profitItemType;
            }
        }
        return null;
    }

    public static ProfitItemType getProfitItemTypeByItemType(String itemType){
        if(Objects.isNull(itemType)) {
            return null;
        }
        for (ProfitItemType profitItemType: ProfitItemType.values()) {
            if(profitItemType.getItemType().equals(itemType)){
                return profitItemType;
            }
        }
        return null;
    }
}
