package com.stylefeng.guns.rest.common.persistence.dao;

import com.stylefeng.guns.rest.common.persistence.model.MtimeHallDictT;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.stylefeng.guns.rest.modular.cinema.service.vo.HallInfo;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 地域信息表 Mapper 接口
 * </p>
 *
 * @author liyan
 * @since 2019-07-17
 */
public interface MtimeHallDictTMapper extends BaseMapper<MtimeHallDictT> {

    HallInfo getHallInfo(@Param("id") String fieldId);

}
