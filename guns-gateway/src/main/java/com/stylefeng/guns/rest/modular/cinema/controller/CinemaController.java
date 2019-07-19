package com.stylefeng.guns.rest.modular.cinema.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.rest.modular.cinema.service.CinemaService;
import com.stylefeng.guns.rest.modular.cinema.service.vo.*;
import com.stylefeng.guns.rest.modular.cinema.vo.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("cinema")
public class CinemaController {

    @Reference(interfaceClass = CinemaService.class, check = false)
    private CinemaService cinemaService;

    @RequestMapping(value = "getCinemas", method = RequestMethod.GET)
    public CinemaResultVo getCinemas(CinemaRequestVo requestVo){
        List<CinemaVo> cinemas = cinemaService.getCinemas(requestVo.getBrandId(), requestVo.getDistrictId(), requestVo.getHallType(), requestVo.getPageSize(), requestVo.getNowPage());
        int count = cinemaService.getCinemasCount(requestVo.getBrandId(), requestVo.getDistrictId(), requestVo.getHallType());
        int totalPage = count % requestVo.getPageSize() == 0 ? count / requestVo.getPageSize() : count / requestVo.getPageSize() + 1;
        CinemaResultVo<List<CinemaVo>> cinemaResultVo = new CinemaResultVo<>();
        cinemaResultVo.setData(cinemas);
        cinemaResultVo.setNowPage(requestVo.getNowPage());
        cinemaResultVo.setTotalPage(totalPage);
        cinemaResultVo.setStatus(0);
        return cinemaResultVo;
    }

    @RequestMapping(value = "getCondition", method = RequestMethod.GET)
    public ConditionResultVo getCondition(ConditionRequestVo requestVo){
        List<Brand> brands = cinemaService.getBrands(requestVo.getBrandId());
        List<Area> areas = cinemaService.getAreas(requestVo.getAreaId());
        List<Halltype> halltype = cinemaService.getHalltype(requestVo.getHallType());
        ConditionVo conditionVo = new ConditionVo();
        conditionVo.setAreaList(areas);
        conditionVo.setBrandList(brands);
        conditionVo.setHalltypeList(halltype);
        ConditionResultVo<ConditionVo> resultVo = new ConditionResultVo<>();
        resultVo.setData(conditionVo);
        resultVo.setStatus(0);
        return resultVo;
    }

    @RequestMapping("getFields")
    public FieldResultVo getFields(Integer cinemaId){
        FResultVo fields = cinemaService.getFields(cinemaId);
        FieldResultVo<Object> resultVo = new FieldResultVo<>();
        resultVo.setData(fields);
        resultVo.setImgPre("com.cskaoyan");
        resultVo.setStatus(0);
        return  resultVo;
    }

    @RequestMapping("getFieldInfo")
    public FieldResultVo getFieldInfo(Integer cinemaId, Integer fieldId){
        NewFieldInfo fieldInfo = cinemaService.getFieldInfo(cinemaId, fieldId);
        FieldResultVo<Object> resultVo = new FieldResultVo<>();
        resultVo.setData(fieldInfo);
        resultVo.setImgPre("com.cskaoyan");
        resultVo.setStatus(0);
        return  resultVo;
    }


}
