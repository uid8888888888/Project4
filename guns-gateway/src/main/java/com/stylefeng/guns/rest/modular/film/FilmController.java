package com.stylefeng.guns.rest.modular.film;


import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.rest.modular.film.vo.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * @Author IL-M
 * @Date:2019/7/16 17:04
 */
@RestController
@RequestMapping("/film")
public class FilmController {
    @Reference
    FilmService service ;

    @RequestMapping("/getConditionList")
    public ConditionListResult getConditionList(int catId, int sourceId, int yearId ){
        //调用服务
        //查询各列表
        ArrayList<CatInfo> catInfos = service.getcatInfoByCatId(catId);
        ArrayList<SourceInfo> sourceInfos = service.getsourceInfoByCatId(sourceId);
        ArrayList<YearInfo> yearInfos = service.getyearInfoByCatId(yearId);
        //封装返回值data
        ConditionListVO conditionListVO = new ConditionListVO();
        conditionListVO.setCatInfo(catInfos);
        conditionListVO.setSourceInfo(sourceInfos);
        conditionListVO.setYearInfo(yearInfos);

        ConditionListResult conditionListResult = new ConditionListResult();
        conditionListResult.setStatus(0);
        conditionListResult.setData(conditionListVO);
        return conditionListResult;
    }

    @RequestMapping("/getFilms")
    public
}
