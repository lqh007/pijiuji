package com.pijiuji.admin.service.impl;

import com.pijiuji.admin.service.PcProductService;
import com.pijiuji.bean.Product;
import com.pijiuji.mapper.ProductMapper;
import com.pijiuji.mapper.SpecificationMapper;
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
import java.util.UUID;

@Service
public class PcProductServiceImpl implements PcProductService {

    @Autowired
    private ProductMapper productMapper;
    @Value("${lottery.url}")
    private String address;
    @Autowired
    private SpecificationMapper specificationMapper;

    /**
     * 添加商品
     * @param request
     */
    @Override
    public void add(HttpServletRequest request) {
        String productName = request.getParameter("productName");
        if(StringUtils.isEmpty(productName)){
            throw new ServiceException("商品名称不允许为空");
        }
        String productUrl1 = request.getParameter("productUrl");
        if(StringUtils.isEmpty(productUrl1)){
            throw new ServiceException("请上传图片");
        }
        MultipartFile productUrl = BASE64DecodedMultipartFile.base64ToMultipart(productUrl1);
        //保存后 的图片路径地址
        String s = ImageUtil.uploadFileImage(productUrl);
        Product product = new Product();
        product.setProductId(UUID.randomUUID().toString().replace("-",""));
        product.setProductUrl(s);
        product.setProductName(productName);
        int i = productMapper.insertSelective(product);
        if(i <= 0){
            throw new ServiceException("添加商品失败");
        }
    }

    /**
     * 删除商品
     * @param request
     */
    @Override
    public void delete(HttpServletRequest request) {
        String productId = request.getParameter("productId");
        if(StringUtils.isEmpty(productId)){
            throw new ServiceException("商品标识不允许为空");
        }
        Product product = productMapper.selectByPrimaryKey(productId);
        if(product == null){
            throw new ServiceException("商品标识错误");
        }
        int i = productMapper.deleteByPrimaryKey(productId);
        //因为添加了商品，对应的规格是可以没有的，所以不需要判断规格有没有删除数据
        specificationMapper.deleteSpeByProductId(productId);
        if(i <= 0){
            throw new ServiceException("删除失败");
        }
    }

    /**
     * 查询商品列表
     * @param request
     * @return
     */
    @Override
    public List<Map<String, Object>> list(HttpServletRequest request) {
        List<Map<String, Object>> list = productMapper.selectAll();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (Map<String, Object> map : list) {
            String url = map.get("url").toString();
            map.put("url",address+url);
            String status = map.get("status").toString();
            map.put("productStatus",status);
            if(status.equals("0")){
                map.put("status","上架");
            }else{
                map.put("status","下架");
            }
            String time = map.get("time").toString();
            Timestamp time1 = Timestamp.valueOf(time);
            Date date = new Date(time1.getTime());
            String s = simpleDateFormat.format(date);
            map.put("time",s);
        }
        return list;
    }

    /**
     * 查询单独的每个商品信息
     * @param request
     * @return
     */
    @Override
    public Map<String, Object> selectProduct(HttpServletRequest request) {
        String productId = request.getParameter("productId");
        if(StringUtils.isEmpty(productId)){
            throw new ServiceException("商品标识不允许为空");
        }
        Map<String, Object> map = productMapper.selectProduct(productId);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String url = map.get("url").toString();
        map.put("url",address+url);
        String time = map.get("time").toString();
        Timestamp time1 = Timestamp.valueOf(time);
        Date date = new Date(time1.getTime());
        String s = simpleDateFormat.format(date);
        map.put("time",s);
        return map;
    }

    /**
     * 修改商品
     * @param request
     */
    @Override
    public void update(HttpServletRequest request) {
        String productId = request.getParameter("productId");
        if(StringUtils.isEmpty(productId)){
            throw new ServiceException("商品标识不允许为空");
        }
        String productName = request.getParameter("productName");
        if(StringUtils.isEmpty(productName)){
            throw new ServiceException("商品名称不允许为空");
        }
        //根据商品id查询商品
        Product product = productMapper.selectByPrimaryKey(productId);
        if(product == null){
            throw new ServiceException("商品id错误");
        }
        String productUrl1 = request.getParameter("productUrl");
        if(StringUtils.isNotEmpty(productUrl1)){
            MultipartFile productUrl = BASE64DecodedMultipartFile.base64ToMultipart(productUrl1);
            //保存后 的图片路径地址
            String s = ImageUtil.uploadFileImage(productUrl);
            product.setProductUrl(s);
        }
        product.setProductName(productName);
        int i = productMapper.updateByPrimaryKeySelective(product);
        if(i <= 0){
            throw new ServiceException("修改失败");
        }
    }

    /**
     * 商品的上下架修改
     * @param request
     */
    @Override
    public void updateStatus(HttpServletRequest request) {
        String productId = request.getParameter("productId");
        if(StringUtils.isEmpty(productId)){
            throw new ServiceException("商品标识不允许为空");
        }
        String status = request.getParameter("status");
        if(StringUtils.isEmpty(status)){
            throw new ServiceException("商品状态不允许为空");
        }
        if(!status.equals("0") && !status.equals("1")){
            throw new ServiceException("商品状态错误");
        }
        Product product = productMapper.selectByPrimaryKey(productId);
        if(product == null){
            throw new ServiceException("商品标识错误");
        }
        product.setProductStatus(status);
        int i = productMapper.updateByPrimaryKeySelective(product);
        if(i <= 0 ){
            throw new ServiceException("修改失败");
        }
    }


}
