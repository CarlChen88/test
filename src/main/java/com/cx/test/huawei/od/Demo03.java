package com.cx.test.huawei.od;

import java.util.Scanner;

/**
 * @author chenxiang
 * @vesion 1.0
 * @Description 密码输入检测
 * @createTime 2024-03-16 09:31:31
 * 输入：ABC<c89%000<
 * 输出：ABc89%00,true
 * 输入：AB3<cAFFAcD%
 * 输出：ABcAFFAcD%,false
 */
public class Demo03 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input_str = in.nextLine();
        // 包含大写字母个数
        int contains_big_char = 0;
        // 包含小写字母个数
        int contains_small_char = 0;
        // 包含数字个数
        int contains_number = 0;
        // 包含特殊字符个数
        int contains_special_char = 0;
        int i = 0;
        String real_passwd = "";
        int index = 0;
        //获取退格后的字符串
        while (true) {
            if (i >= input_str.length()) {
                break;
            } else {
                if (input_str.charAt(i) != '<') {
                    real_passwd += input_str.charAt(i);
                    index += 1;
                } else {
                    if (index > 0) {
                        index -= 1;
                    }
                    real_passwd = index > 0 ? real_passwd.substring(0, index) : real_passwd;
                }
            }
            i += 1;
        }
        //判断密码
        char[] chars = real_passwd.toCharArray();
        for(char ch : chars){
            if (Character.isDigit(ch)) {
                contains_number = 1;
            } else if (Character.isLowerCase(ch)){
                contains_small_char = 1;
            } else if (Character.isUpperCase(ch)) {
                contains_big_char = 1;
            } else if (!Character.isDigit(ch) && !Character.isLowerCase(ch) && !Character.isUpperCase(ch) && ch != ' ') {
                contains_special_char = 1;
            }
        }
        if (contains_number == 1 && contains_small_char == 1 && contains_big_char == 1 && contains_special_char == 1 && real_passwd.length() >= 8) {
            System.out.println(real_passwd + ",true");
        } else {
            System.out.println(real_passwd + ",false");
        }
    }
}
