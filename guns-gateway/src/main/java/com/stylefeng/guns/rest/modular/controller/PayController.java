package com.stylefeng.guns.rest.modular.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.cskaoyan.commonbean.ErrResponseVo;
import com.cskaoyan.filmmodule14.ResponseVo4FilmModule1N4;
import com.cskaoyan.pay.PayService;
import com.cskaoyan.pay.PayVo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PayController {

    @Reference(interfaceClass = PayService.class,check = false)
    PayService payService;

    @RequestMapping(value = "order/getPayInfo",method = RequestMethod.POST)
    public Object getPayInfo(String orderId){
        PayVo qrCode = payService.getQRCode(orderId);
        if(null != qrCode){
            return ResponseVo4FilmModule1N4.ok(qrCode);
        }
        return ErrResponseVo.tranErr("订单支付失败，请稍后再试");
    }


    @RequestMapping(value = "order/getPayResult",method = RequestMethod.POST)
    public Object getPayResult(String orderId,int tryNums){
        PayVo payStatus = payService.getPayStatus(orderId);
        if(null != payStatus){
            return ResponseVo4FilmModule1N4.ok(payStatus);
        }
        if(tryNums >= 3) {
            return ErrResponseVo.tranErr("订单支付失败，请稍后再试");
        }
        return null;
    }

}
