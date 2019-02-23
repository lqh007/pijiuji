package com.pijiuji.util;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 通用的方法
 * @author Administrator
 */
public class ComnUtil {

    public static final int PAGE_SIZE = 50;
    // 地球半径
    private static double EARTH_RADIUS = 6371.393;
    private static SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");

    /**
     * 生成随机数范围（A-Z,0-9,a-z）
     *
     * @param length 生成随机数的长度
     * @return
     */
    public static String getRandomString(int length) {
        String base = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        int number = 0;
        for (int i = 0; i < length; i++) {
            number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    /**
     * 生成随机数范围（0-9）
     *
     * @param length 生成随机数的长度
     * @return
     */
    public static String getnumberString(int length) {
        String base = "0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        int number = 0;
        for (int i = 0; i < length; i++) {
            number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    /**
     * list根据经纬度排序
     * @param list
     */
    public static void sort(List<Map<String, Object>> list){
        Collections.sort(list, new Comparator<Map<String, Object>>() {
            @Override
            public int compare(Map<String, Object> o1, Map<String, Object> o2) {
                boolean b = Double.valueOf(String.valueOf(o1.get("jwd"))) > Double.valueOf(String.valueOf(o2.get("jwd")));
                if(b){
                    return 1;
                }
                return -1;
            }
        });
    }

    /**
     * list根据收入排序
     * @param list
     */
    public static void sortMoney(List<Map<String, String>> list){
        Collections.sort(list, new Comparator<Map<String, String>>() {
            @Override
            public int compare(Map<String, String> o1, Map<String, String> o2) {
                boolean b = Double.valueOf(String.valueOf(o1.get("ticheng"))) > Double.valueOf(String.valueOf(o2.get("ticheng")));
                if(b){
                    return -1;
                }
                return 1;
            }
        });
    }

    /**
     * 计算两个坐标间的距离
     *
     * @param bonusesplace  自己坐标的经纬度
     * @param publishplace  目标地址的经纬度
     * @return  返回两点距离(直线)
     */
    public static double latAndLnt(String bonusesplace, String publishplace) {
        DecimalFormat df = new DecimalFormat("######0.00");
        String[] latLng = bonusesplace.split(",");
        String[] latLng2 = publishplace.split(",");
        Double lat2 = Double.parseDouble(latLng[0]);
        Double lng2 = Double.parseDouble(latLng[1]);
        Double lat1 = Double.parseDouble(latLng[0]);
        Double lng1 = Double.parseDouble(latLng2[1]);
        double radLat1 = rad(lat1);
        double radLat2 = rad(lat2);
        double a = radLat1 - radLat2;
        double b = rad(lng1) - rad(lng2);
        double km = 2 * Math.asin(Math.sqrt(
                Math.pow(Math.sin(a / 2), 2) + Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(b / 2), 2)));
        km = km * EARTH_RADIUS;
        String km2 = df.format(km);
        double d = Double.parseDouble(km2);
        return d;

    }

    private static double rad(double d) {
        return d * Math.PI / 180.0;
    }

}
