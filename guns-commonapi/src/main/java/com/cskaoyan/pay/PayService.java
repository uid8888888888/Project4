package com.cskaoyan.pay;

public interface PayService {

    PayVo getQRCode(String orderId);

    PayVo getPayStatus(String orderId);
}
