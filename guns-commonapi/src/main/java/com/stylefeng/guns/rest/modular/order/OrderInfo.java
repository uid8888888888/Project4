package com.stylefeng.guns.rest.modular.order;

import lombok.Data;

import java.io.Serializable;
import java.time.Period;

@Data
public class OrderInfo implements Serializable {

    private static final long serialVersionUID = -990007822360857479L;

    private String orderId;

    private String filmName;

    private String fieldTime;

    private String cinemaName;

    private String seatsName;

    private double orderPrice;

    private String orderTimestamp;
}
