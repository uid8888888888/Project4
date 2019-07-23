package com.stylefeng.guns.rest.modular.order;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.rest.config.properties.JwtProperties;
import com.stylefeng.guns.rest.modular.auth.util.JwtTokenUtil;
import com.stylefeng.guns.rest.modular.cinema.vo.CinemaRequestVo;
import com.stylefeng.guns.rest.modular.order.vo.OrderResult;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("order")
public class OrderController {

    @Reference(interfaceClass = OrderService.class, check = false)
    private OrderService orderService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtProperties jwtProperties;

    @RequestMapping("buyTickets")
    public OrderResult buyTickets(HttpServletRequest request, Integer fieldId, String soldSeats, String seatsName) {
        final String requestHeader = request.getHeader(jwtProperties.getHeader());
        String authToken = null;
        if (requestHeader != null && requestHeader.startsWith("Bearer ")) {
            authToken = requestHeader.substring(7);
        }
        String username = jwtTokenUtil.getUsernameFromToken(authToken);
        OrderInfo orderInfo = orderService.buyTickets(fieldId + "", soldSeats, seatsName, username);
        OrderResult<Object> result = new OrderResult<>();
        result.setData(orderInfo);
        result.setMsg("");
        result.setStatus(0);
        return result;
    }

    @RequestMapping("getOrderInfo")
    public OrderResult getOrderInfo(HttpServletRequest request,Integer nowPage, Integer pageSize) {
        final String requestHeader = request.getHeader(jwtProperties.getHeader());
        String authToken = null;
        if (requestHeader != null && requestHeader.startsWith("Bearer ")) {
            authToken = requestHeader.substring(7);
        }
        String username = jwtTokenUtil.getUsernameFromToken(authToken);
        List<UserOrderInfo> orderInfos = orderService.getOrderInfo(nowPage + "", pageSize + "", username);
        OrderResult<Object> result = new OrderResult<>();
        result.setData(orderInfos);
        result.setMsg("");
        result.setStatus(0);
        return result;
    }
}
