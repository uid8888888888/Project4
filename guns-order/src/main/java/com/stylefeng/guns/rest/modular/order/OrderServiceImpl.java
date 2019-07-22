package com.stylefeng.guns.rest.modular.order;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.stylefeng.guns.rest.common.persistence.dao.MtimeCinemaTMapper;
import com.stylefeng.guns.rest.common.persistence.dao.MtimeFieldTMapper;
import com.stylefeng.guns.rest.common.persistence.dao.MtimeHallFilmInfoTMapper;
import com.stylefeng.guns.rest.common.persistence.dao.MtimeUserTMapper;
import com.stylefeng.guns.rest.common.persistence.model.*;
import com.stylefeng.guns.rest.modular.cinema.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service(interfaceClass = OrderService.class)
@Component
public class OrderServiceImpl implements OrderService {

    @Autowired
    private MtimeFieldTMapper fieldTMapper;

    @Autowired
    private MtimeHallFilmInfoTMapper filmInfoTMapper;

    @Autowired
    private MtimeCinemaTMapper cinemaTMapper;

    @Autowired
    MtimeUserTMapper userTMapper;

    @Override
    public OrderInfo buyTickets(String fieldId, String soldSeats, String seatsName, String username) {
        MtimeFieldT fieldInfo = fieldTMapper.selectById(fieldId);
        Integer filmId = fieldInfo.getFilmId();
        MtimeHallFilmInfoT filmInfo = filmInfoTMapper.selectById(fieldId);
        Integer cinemaId = fieldInfo.getCinemaId();
        MtimeCinemaT cinemaInfo = cinemaTMapper.selectById(cinemaId);
        EntityWrapper<MtimeUserT> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("user_name", username);
        List<MtimeUserT> userTS = userTMapper.selectList(entityWrapper);
        MtimeUserT userInfo = userTS.get(0);
        MoocOrderT order = insertOrder(filmInfo, fieldInfo, cinemaInfo, userInfo, soldSeats, seatsName);
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setOrderId(order.getUuid());
        orderInfo.setFilmName(filmInfo.getFilmName());
        orderInfo.setFieldTime("今天 9月8号 " + fieldInfo.getBeginTime());
        orderInfo.setCinemaName(cinemaInfo.getCinemaName());
        orderInfo.setSeatsName(seatsName);
        orderInfo.setOrderPrice(order.getOrderPrice());
        orderInfo.setOrderTimestamp("1589754126");
        return orderInfo;
    }

    private MoocOrderT insertOrder(MtimeHallFilmInfoT filmInfo, MtimeFieldT fieldInfo, MtimeCinemaT cinemaInfo, MtimeUserT userInfo,String soldSeats, String seatsName) {
        MoocOrderT order = new MoocOrderT();
        UUID uuid = UUID.randomUUID();
        String s = uuid.toString().replaceAll(",", "");
        order.setUuid(s);
        order.setCinemaId(cinemaInfo.getUuid());
        order.setFieldId(fieldInfo.getUuid());
        order.setFilmId(filmInfo.getFilmId());
        order.setSeatsIds(soldSeats);
        order.setSeatsName(seatsName);
        double filmPrice = 0;
        String[] split = soldSeats.split(",");
        order.setFilmPrice((double) (fieldInfo.getPrice()));
        order.setOrderPrice((double) (fieldInfo.getPrice() * split.length));
        order.setOrderTime(new Date());
        order.setOrderUser(userInfo.getUuid());
        order.setOrderStatus(0);
        return order;
    }
}
