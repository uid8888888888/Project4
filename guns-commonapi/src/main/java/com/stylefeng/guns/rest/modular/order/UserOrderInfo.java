package com.stylefeng.guns.rest.modular.order;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserOrderInfo implements Serializable {

    private static final long serialVersionUID = 7428767081376204506L;

    private String orderId;

    private String filmName;

    private String fieldTime;

    private String cinemaName;

    private String seatsName;

    private double orderPrice;

    private String orderStatus;
}
