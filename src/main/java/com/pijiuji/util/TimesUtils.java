package com.pijiuji.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimesUtils {

    public static String stampToDate(long lt){
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }

    public static void main(String[] args) {

    }

}
