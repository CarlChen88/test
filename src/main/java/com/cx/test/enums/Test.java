package com.cx.test.enums;

/**
 * @author chenxiang
 * @vesion 1.0
 * @Description TODO
 * @createTime 2022-04-09 09:27:27
 */
public class Test {
    public static void main(String[] args) {
        String getsss = ProcessEnum.INSTANCE.getsss("11");
        System.out.println(getsss);
        System.out.println(WeekDayEnum.getWeekDayEnum(1).name());
        ProfitItemType profitItemType = ProfitItemType.getProfitItemType(ProfitItemType.CASH, ProfitItemType.COUPON);
        System.out.println(profitItemType.getItemType());
    }
}
