package com.stylefeng.guns.rest.modular.order;

public interface OrderService {

    OrderInfo buyTickets(String fieldId, String soldSeats, String seatsName, String username);
}
