package com.stylefeng.guns.rest.modular.film.vo;

import java.io.Serializable;

/**
 * @Author IL-M
 * @Date:2019/7/16 16:46
 */
public class SourceInfo  implements Serializable {
   private static final long serialVersionUID = 1968050023724557567L;
   private int sourceId;
   private String sourceName;
   private boolean isActive;

   public static long getSerialVersionUID() {
      return serialVersionUID;
   }

   public int getSourceId() {
      return sourceId;
   }

   public void setSourceId(int sourceId) {
      this.sourceId = sourceId;
   }

   public String getSourceName() {
      return sourceName;
   }

   public void setSourceName(String sourceName) {
      this.sourceName = sourceName;
   }

   public boolean isActive() {
      return isActive;
   }

   public void setActive(boolean active) {
      isActive = active;
   }
}
