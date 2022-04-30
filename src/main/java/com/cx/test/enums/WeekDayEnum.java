package com.cx.test.enums;

/**
 * @author chenxiang
 * @vesion 1.0
 * @Description 星期枚举类
 * @createTime 2022-04-30 13:52:52
 */
public enum WeekDayEnum {
    MONDAY(1),TUESTDAY(2),WEDNESDAY(3),THURSDAY(4),FRIDAY(5),STATURDAY(6),SUNDAY(7);

    private int code;

    WeekDayEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static WeekDayEnum getWeekDayEnum(int code){
        for (WeekDayEnum weekDayEnum: WeekDayEnum.values()) {
            if(weekDayEnum.getCode()== code){
                return weekDayEnum;
            }
        }
        return null;
    }
}
