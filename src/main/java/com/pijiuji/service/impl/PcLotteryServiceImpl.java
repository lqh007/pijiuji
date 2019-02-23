package com.pijiuji.service.impl;

import com.pijiuji.bean.Lottery;
import com.pijiuji.mapper.LotteryMapper;
import com.pijiuji.service.PcLotteryService;
import com.pijiuji.service.exception.ServiceException;
import com.pijiuji.util.BASE64DecodedMultipartFile;
import com.pijiuji.util.ImageUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class PcLotteryServiceImpl implements PcLotteryService {

    @Autowired
    private LotteryMapper lotteryMapper;
    @Value("${lottery.url}")
    private String address;

    /**
     * 查询所有奖品
     * @return
     */
    @Override
    public List<Map<String,Object>> selectLotteryAll() {
        List<Map<String,Object>> list = lotteryMapper.selectLotteryAll();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (Map<String, Object> map : list) {
            String time = map.get("time").toString();
            Timestamp time1 = Timestamp.valueOf(time);
            Date date = new Date(time1.getTime());
            String s = simpleDateFormat.format(date);
            map.put("time",s);
            String img = map.get("img").toString();
            map.put("img",address + img);
            if(map.get("type").toString().equals("0")){
                map.put("lotteryType","优惠劵");
            }else if(map.get("type").toString().equals("1")){
                map.put("lotteryType","毫升数");
            }else if(map.get("type").toString().equals("2")){
                map.put("lotteryType","再来一杯");
            }else{
                map.put("lotteryType","谢谢参与");
            }
        }
        return list;
    }

    /**
     * 修改奖品
     * @param request
     */
    @Override
    public void updateLottery(HttpServletRequest request) {
        String lotteryId = request.getParameter("lotteryId");
        if(StringUtils.isEmpty(lotteryId)){
            throw new ServiceException("标识不允许为空");
        }
        String lotteryName = request.getParameter("lotteryName");
        if(StringUtils.isEmpty(lotteryName)){
            throw new ServiceException("奖品名称不予许为空");
        }
        String lotteryGailv = request.getParameter("lotteryGailv");
        if(StringUtils.isEmpty(lotteryGailv)){
            throw new ServiceException("奖品概率不允许为空");
        }
        try {
            Integer.valueOf(lotteryGailv);
        } catch (NumberFormatException e) {
            throw new ServiceException("奖品概率需要为整数类型");
        }
        String lotteryType = request.getParameter("lotteryType");
        if(StringUtils.isEmpty(lotteryType)){
            throw new ServiceException("奖品类型不允许为空");
        }
        String lotteryTypeDetail = request.getParameter("lotteryTypeDetail");
        if(!lotteryType.equals("3") && !lotteryType.equals("2")){
            if(StringUtils.isEmpty(lotteryTypeDetail)){
                throw new ServiceException("奖品面值描述不允许为空");
            }
        }
        Lottery lottery = new Lottery();
        String lotteryUrl = request.getParameter("lotteryUrl");
        if(StringUtils.isNotEmpty(lotteryUrl)){
            MultipartFile lotteryUrl1 = BASE64DecodedMultipartFile.base64ToMultipart(lotteryUrl);
            //保存后 的图片路径地址
            String s = ImageUtil.uploadFileImage(lotteryUrl1);
            lottery.setLotteryImg(s);
        }
        lottery.setLotteryId(Integer.valueOf(lotteryId));
        lottery.setLotteryGailv(Integer.valueOf(lotteryGailv));
        lottery.setLotteryName(lotteryName);
        lottery.setLotteryType(lotteryType);
        lottery.setLotteryTypedetail(lotteryTypeDetail);
        int i = lotteryMapper.updateByPrimaryKeySelective(lottery);
        if(i <= 0){
            throw new ServiceException("网络异常,修改失败");
        }
    }
}
