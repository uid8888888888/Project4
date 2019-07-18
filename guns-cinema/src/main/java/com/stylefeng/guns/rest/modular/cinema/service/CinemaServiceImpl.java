package com.stylefeng.guns.rest.modular.cinema.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.stylefeng.guns.rest.common.persistence.dao.MtimeAreaDictTMapper;
import com.stylefeng.guns.rest.common.persistence.dao.MtimeBrandDictTMapper;
import com.stylefeng.guns.rest.common.persistence.dao.MtimeCinemaTMapper;
import com.stylefeng.guns.rest.common.persistence.dao.MtimeHallDictTMapper;
import com.stylefeng.guns.rest.common.persistence.model.MtimeAreaDictT;
import com.stylefeng.guns.rest.common.persistence.model.MtimeBrandDictT;
import com.stylefeng.guns.rest.common.persistence.model.MtimeCinemaT;
import com.stylefeng.guns.rest.common.persistence.model.MtimeHallDictT;
import com.stylefeng.guns.rest.modular.cinema.service.vo.Area;
import com.stylefeng.guns.rest.modular.cinema.service.vo.Brand;
import com.stylefeng.guns.rest.modular.cinema.service.vo.CinemaVo;
import com.stylefeng.guns.rest.modular.cinema.service.vo.Halltype;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service(interfaceClass = CinemaService.class)
@Component
public class CinemaServiceImpl implements CinemaService {

    @Autowired
    private  MtimeCinemaTMapper cinemaTMapper;

    @Autowired
    private MtimeBrandDictTMapper brandDictTMapper;

    @Autowired
    private MtimeHallDictTMapper dictTMapper;

    @Autowired
    private MtimeAreaDictTMapper areaDictTMapper;

    @Override
    public List<CinemaVo> getCinemas(Integer brandId, Integer districtId, Integer hallType, Integer pageSize, Integer nowPage) {
        List<CinemaVo> cinemaVos = new ArrayList<>();
        EntityWrapper<MtimeCinemaT> entityWrapper = new EntityWrapper<>();
        if(brandId != null && brandId != 99){
            entityWrapper.eq("brand_id",brandId);
        }
        if(hallType != null && hallType != 99){
            entityWrapper.like("hall_ids","%" + hallType + "%");
        }
        if(districtId != null && districtId != 99){
            entityWrapper.eq("area_id",districtId);
        }
        Page page = new Page(1, 12);
        if(pageSize != null){
            page.setSize(pageSize);
        }
        if(nowPage != null){
            page.setCurrent(nowPage);
        }
        List<MtimeCinemaT> mtimeCinemaTS = cinemaTMapper.selectPage(page, entityWrapper);
        if(CollectionUtils.isEmpty(mtimeCinemaTS)){
            return null;
        }
        for (MtimeCinemaT mtimeCinemaT : mtimeCinemaTS) {
            CinemaVo cinemaVo = new CinemaVo();
            cinemaVo.setUuid(mtimeCinemaT.getUuid());
            cinemaVo.setMinimumPrice(mtimeCinemaT.getMinimumPrice());
            cinemaVo.setAddress(mtimeCinemaT.getCinemaAddress());
            cinemaVo.setCinemaName(mtimeCinemaT.getCinemaName());
            cinemaVos.add(cinemaVo);
        }
        return cinemaVos;
    }

    @Override
    public int getCinemasCount(Integer brandId, Integer districtId, Integer hallType) {
        EntityWrapper<MtimeCinemaT> entityWrapper = new EntityWrapper<>();
        if(brandId != null && brandId != 99){
            entityWrapper.eq("brand_id",brandId);
        }
        if(hallType != null && hallType != 99){
            entityWrapper.like("hall_ids",hallType + "");
        }
        if(districtId != null && districtId != 99){
            entityWrapper.eq("area_id",districtId);
        }
        Integer count = cinemaTMapper.selectCount(entityWrapper);
        return count;
    }

    @Override
    public List<Brand> getBrands(Integer brandId) {
        ArrayList<Brand> brands = new ArrayList<>();
        EntityWrapper<MtimeBrandDictT> entityWrapper = new EntityWrapper<>();
        if(brandId != null && brandId != 99){
            entityWrapper.eq("UUID", brandId);
        }
        List<MtimeBrandDictT> brandDictTS = brandDictTMapper.selectList(entityWrapper);
        if(CollectionUtils.isEmpty(brandDictTS)){
            return null;
        }
        for (MtimeBrandDictT brandDictT : brandDictTS) {
            Brand brand = new Brand();
            brand.setBrandId(brandDictT.getUuid());
            brand.setBrandName(brandDictT.getShowName());
            brand.setActive(false);
            if(brandDictT.getUuid() == brandId){
                brand.setActive(true);
            }
            brands.add(brand);
        }
        return brands;
    }

    @Override
    public List<Area> getAreas(Integer areaId) {
        ArrayList<Area> areas = new ArrayList<>();
        EntityWrapper<MtimeAreaDictT> entityWrapper = new EntityWrapper<>();
        if(areaId != null && areaId != 99){
            entityWrapper.eq("UUID",areaId);
        }
        List<MtimeAreaDictT> areaDictTS = areaDictTMapper.selectList(entityWrapper);
        if (CollectionUtils.isEmpty(areaDictTS)){
            return null;
        }
        for (MtimeAreaDictT areaDictT : areaDictTS) {
            Area area = new Area();
            area.setAreaId(areaDictT.getUuid());
            area.setAreaName(areaDictT.getShowName());
            area.setActive(false);
            if(areaDictT.getUuid() == areaId){
                area.setActive(true);
            }
            areas.add(area);
        }
        return areas;
    }

    @Override
    public List<Halltype> getHalltype(Integer hallType) {
        ArrayList<Halltype> halltypes = new ArrayList<>();
        EntityWrapper<MtimeHallDictT> entityWrapper = new EntityWrapper<>();
        if(hallType != null && hallType != 99){
            entityWrapper.eq("UUID",hallType);
        }
        List<MtimeHallDictT> mtimeHallDictTS = dictTMapper.selectList(entityWrapper);
        if (CollectionUtils.isEmpty(mtimeHallDictTS)){
            return null;
        }
        for (MtimeHallDictT hallDictT : mtimeHallDictTS) {
            Halltype halltype = new Halltype();
            halltype.setHalltypeId(hallDictT.getUuid());
            halltype.setHalltypeName(hallDictT.getShowName());
            halltype.setActive(false);
            if(hallDictT.getUuid() == hallType){
                halltype.setActive(true);
            }
            halltypes.add(halltype);
        }
        return halltypes;
    }
}
