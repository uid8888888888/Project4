package com.stylefeng.guns.rest.modular.film.vo;

import java.io.Serializable;

/**
 * @Author IL-M
 * @Date:2019/7/17 21:20
 */
public class FilmRequestVO implements Serializable {
   private static final long serialVersionUID = 4009311810407554942L;
   private Integer showType = 1;
   private Integer sortId = 1;
   private Integer sourceId = 99;
   private Integer catId = 99;
   private Integer yearId = 99;
   private Integer nowPage = 1;
   private Integer pageSize = 18;

   public Integer getShowType() {
      return showType;
   }

   public void setShowType(Integer showType) {
      this.showType = showType;
   }

   public Integer getSortId() {
      return sortId;
   }

   public void setSortId(Integer sortId) {
      this.sortId = sortId;
   }

   public Integer getSourceId() {
      return sourceId;
   }

   public void setSourceId(Integer sourceId) {
      this.sourceId = sourceId;
   }

   public Integer getCatId() {
      return catId;
   }

   public void setCatId(Integer catId) {
      this.catId = catId;
   }

   public Integer getYearId() {
      return yearId;
   }

   public void setYearId(Integer yearId) {
      this.yearId = yearId;
   }

   public Integer getNowPage() {
      return nowPage;
   }

   public void setNowPage(Integer nowPage) {
      this.nowPage = nowPage;
   }

   public Integer getPageSize() {
      return pageSize;
   }

   public void setPageSize(Integer pageSize) {
      this.pageSize = pageSize;
   }

   public FilmRequestVO() {
   }

   public FilmRequestVO(Integer showType, Integer sortId, Integer sourceId, Integer catId, Integer yearId, Integer nowPage, Integer pageSize) {
      this.showType = showType;
      this.sortId = sortId;
      this.sourceId = sourceId;
      this.catId = catId;
      this.yearId = yearId;
      this.nowPage = nowPage;
      this.pageSize = pageSize;
   }

   @Override
   public String toString() {
      return "FilmRequestVO{" +
              "showType=" + showType +
              ", sortId=" + sortId +
              ", sourceId=" + sourceId +
              ", catId=" + catId +
              ", yearId=" + yearId +
              ", nowPage=" + nowPage +
              ", pageSize=" + pageSize +
              '}';
   }
}
