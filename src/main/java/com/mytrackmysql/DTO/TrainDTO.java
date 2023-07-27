package com.mytrackmysql.DTO;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
@Getter
@Setter
public class TrainDTO {

    private Long id;
    private String trainSymbol;
    private String departYardCode;
    private LocalDate departureDate;
    private String departureTime;
    private String destinationYardCode;
    private LocalDate arrivalDate;
    private LocalTime arrivalTime;
    private Integer trainLength;
    private String eot;

}
