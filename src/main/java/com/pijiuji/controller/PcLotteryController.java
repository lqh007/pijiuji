package com.pijiuji.controller;

import com.pijiuji.bean.ResponseResult;
import com.pijiuji.service.PcLotteryService;
import com.pijiuji.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/lottery")
public class PcLotteryController {

    @Autowired
    private PcLotteryService pcLotteryServiceImpl;

    /**
     * 查询所有奖品
     * @return
     */
    @ResponseBody
    @RequestMapping("/selectLotteryAll")
    public ResponseResult<List<Map<String,Object>>> selectLotteryAll(){
        ResponseResult<List<Map<String,Object>>> result = null;
        try {
            List<Map<String,Object>> list = pcLotteryServiceImpl.selectLotteryAll();
            result = new ResponseResult<List<Map<String,Object>>>(200,"查询成功",list);
        } catch (ServiceException e) {
            result = new ResponseResult<List<Map<String,Object>>>(500,e.getMessage());
        }
        return result;
    }

    /**
     * 修改奖品
     * @return
     */
    @ResponseBody
    @RequestMapping("/updateLottery")
    public ResponseResult<Void> updateLottery(HttpServletRequest request){
        ResponseResult<Void> result = null;
        try {
            pcLotteryServiceImpl.updateLottery(request);
            result = new ResponseResult<Void>(200,"修改成功");
        } catch (ServiceException e) {
            result = new ResponseResult<Void>(500,e.getMessage());
        }
        return result;
    }

}
