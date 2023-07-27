package com.mytrackmysql.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalDate;

@Getter
@Setter
@Entity(name = "carView")
@Table(name = "car_view")
public class CarDTO {
    @Id
    @Column(name = "CAR_ID")
    private Long id;
    @Column(name = "TRACK_SEQ")
    private Integer trackSeq;
    @Column(name = "OWNER_ID")
    private String ownerID;
    @Column(name = "SERIES_CODE")
    private Integer seriesCode;
    @Column(name = "TYPE_CODE")
    private String typeCode;
    @Column(name = "BUILD_DATE")
    private LocalDate buildDate;
    @Column(name = "LENGTH")
    private Integer carLength;
    @Column(name = "HEALTH_CODE")
    private String healthCode;
    @Column(name = "block_id")
    private Long blockID;
    @Column(name = "track_id")
    private Long track;
    @Column(name = "OUT_BLOCK")
    private String outboundBlock;

    @Override
    public String toString() {
        return "CarDTO{" +
                "id=" + id +
                ", trackSeq=" + trackSeq +
                ", ownerID='" + ownerID + '\'' +
                ", seriesCode=" + seriesCode +
                ", typeCode='" + typeCode + '\'' +
                ", buildDate=" + buildDate +
                ", carLength=" + carLength +
                ", healthCode='" + healthCode + '\'' +
                ", blockID=" + blockID +
                ", track=" + track +
                ", outboundBlock='" + outboundBlock + '\'' +
                '}';
    }
}
