package cn.yang.store.common;

import java.util.Random;

public class NumberBuilder {
	
    /**
     * 返回长度为strLength的随机数，在前面补0
     * @param strLength 长度
     * @return 随机数
     */
    public static String getFixLengthNumberToString(int strLength) {

        Random rm = new Random();

        // 获得随机数
        double pross = (1 + rm.nextDouble()) * Math.pow(10, strLength);

        // 将获得的获得随机数转化为字符串
        String fixLengthString = String.valueOf(pross);

        // 返回固定的长度的随机数
        return fixLengthString.substring(1, strLength + 1);
    }
}
