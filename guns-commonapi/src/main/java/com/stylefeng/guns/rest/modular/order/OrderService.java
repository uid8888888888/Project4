package com.stylefeng.guns.rest.modular.order;

import java.util.List;

public interface OrderService {

    OrderInfo buyTickets(String fieldId, String soldSeats, String seatsName, String username);

    List<UserOrderInfo> getOrderInfo(String nowPage, String pageSize, String username);
}
