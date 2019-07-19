package com.stylefeng.guns.rest.modular.cinema.service.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class HallInfo implements Serializable {

    private static final long serialVersionUID = -1722847415539755211L;

    private String hallFieldId;

    private String hallName;

    private double price;

    private String seatFile;

    private String soldSeats;

}
