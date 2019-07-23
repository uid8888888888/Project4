package com.stylefeng.guns.rest.common.persistence.dao;

import org.apache.ibatis.annotations.Param;

public interface OrderMapper {

    Double getOrderPriceByOid(@Param("oid") String oid);
}
