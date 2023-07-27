package com.mytrackmysql.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "yardView")
@Table(name = "yard_view")
public class YardDTO {
    @Id
    @Column(name = "BLOCK_ID")
    private Long blockId;
    @Column(name = "TRACK_ID")
    private Long track;

    @Column(name = "TRAIN_SYMBOL")
    private String trainSymbol;

    @Column(name = "CAR_COUNT")
    private Integer carCount;


    @Override
    public String toString() {
        return "YardDTO{" +
                "blockId=" + blockId +
                ", track=" + track +
                ", trainSymbol='" + trainSymbol + '\'' +
                ", carCount=" + carCount +
                '}';
    }
}
