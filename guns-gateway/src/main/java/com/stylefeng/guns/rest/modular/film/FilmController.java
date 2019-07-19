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
    @Reference(interfaceClass = FilmService.class,check = false)
    FilmService service ;

    @RequestMapping("/getConditionList")
    public ConditionListResult getConditionList(int catId, int sourceId, int yearId ){
        ConditionListResult conditionListResult = new ConditionListResult();
        try{
            ArrayList<CatInfo> catInfos = service.getcatInfoByCatId(catId);
            ArrayList<SourceInfo> sourceInfos = service.getsourceInfoByCatId(sourceId);
            ArrayList<YearInfo> yearInfos = service.getyearInfoByCatId(yearId);
            ConditionListVO conditionListVO = new ConditionListVO();
            conditionListVO.setCatInfo(catInfos);
            conditionListVO.setSourceInfo(sourceInfos);
            conditionListVO.setYearInfo(yearInfos);
            if(null != catInfos && catInfos.size()!=0 ||
            null != sourceInfos && sourceInfos.size()!=0 ||
            null != yearInfos && yearInfos.size()!=0 ){
                conditionListResult.setStatus(0);
                conditionListResult.setData(conditionListVO);
            }else{
                conditionListResult.setStatus(1);
                conditionListResult.setMsg("查询失败，无条件可加载");
            }
        }catch(Exception e){
            e.printStackTrace();
            conditionListResult.setStatus(999);
            conditionListResult.setMsg("系统出现异常，请联系管理员");
        }
        return conditionListResult;
    }

    @RequestMapping("/getFilms")
    public Page<FilmInfo> getFilms(FilmRequestVO filmRequest){
        Page<FilmInfo> films = service.getFilms(filmRequest);

        return films;
    }
}
