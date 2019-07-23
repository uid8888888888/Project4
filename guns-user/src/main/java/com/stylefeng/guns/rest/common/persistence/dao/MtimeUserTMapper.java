package com.stylefeng.guns.rest.common.persistence.dao;

import com.stylefeng.guns.rest.common.persistence.model.MtimeUserT;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author yangshuo
 * @since 2019-07-16
 */
@Component
public interface MtimeUserTMapper extends BaseMapper<MtimeUserT> {

    int countByUsername(@Param("username") String username);

    int countByUsernameAndPassword(@Param("username") String userName, @Param("password") String password);

    MtimeUserT selectByUsername(@Param("username") String usernameFromToken);

    String getPasswordByUsername(@Param("username")String username);

    Integer getUseridByName(@Param("username")String username);
}
