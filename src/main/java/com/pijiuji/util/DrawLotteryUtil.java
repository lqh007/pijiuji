package com.pijiuji.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * 抽奖工具类<br/>
 * 整体思想：
 * 奖品集合 + 概率比例集合
 * 将奖品按集合中顺序概率计算成所占比例区间，放入比例集合。并产生一个随机数加入其中，排序。</br>
 * 排序后，随机数落在哪个区间，就表示那个区间的奖品被抽中。</br>
 * 返回的随机数在集合中的索引，该索引就是奖品集合中的索引。</br>
 * 比例区间的计算通过概率相加获得。
 * @author irving
 * @since 2017年7月23日 下午9:48:23
 * @version MARK 0.0.1
 */
public class DrawLotteryUtil {

    public static int drawGift(List<Map<String,Object>> giftList){

        if(null != giftList && giftList.size()>0){
            List<Double> orgProbList = new ArrayList<Double>(giftList.size());
            for(Map<String,Object> gift:giftList){
                //按顺序将概率添加到集合中
                orgProbList.add(Double.valueOf(gift.get("lotteryGailv")+""));
            }
            return draw(orgProbList);
        }
        return -1;
    }

    public static int draw(List<Double> giftProbList){

        List<Double> sortRateList = new ArrayList<Double>();

        // 计算概率总和
        Double sumRate = 0D;
        for(Double prob : giftProbList){
            sumRate += prob;
        }

        if(sumRate != 0){
            double rate = 0D;   //概率所占比例
            for(Double prob : giftProbList){
                rate += prob;
                // 构建一个比例区段组成的集合(避免概率和不为1)
                sortRateList.add(rate / sumRate);
            }
            // 随机生成一个随机数，并排序
            double random = Math.random();
            sortRateList.add(random);
            Collections.sort(sortRateList);
            // 返回该随机数在比例集合中的索引
            return sortRateList.indexOf(random);
        }
        return -1;
    }
}