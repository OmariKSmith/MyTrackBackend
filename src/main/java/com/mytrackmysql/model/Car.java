package com.mytrackmysql.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Getter
@Setter
@Entity(name = "Car")
@Table(name = "car_list")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="id")
public class Car {
    private static Integer carCount =1;// used for faker
    public static final Integer MEMBER_COUNT = 9;// used for Excel file export

    @Id
    @SequenceGenerator(
            name = "car_sequence",
            sequenceName = "car_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
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

    @Column(name = "OUT_BLOCK")
    private String outboundBlock;


    @ManyToOne( cascade = {CascadeType.REMOVE, CascadeType.MERGE})
    @JoinColumn(
            name = "TRACK_ID",
            referencedColumnName = "TRACK_ID",
            foreignKey = @ForeignKey(
                    name = "car_track_fk"
            )
    )
    private Track track;
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "BLOCK_ID",
            referencedColumnName = "BLOCK_ID",
            foreignKey = @ForeignKey(
                    name = "car_block_fk"
            )

    )
    private Block block;

    public Car() {

    }

    //Build Populated Car Object
    public Car build(){

        List<String> ownerIds = new ArrayList<>(
                Arrays.asList("CSX","UP","CN","CP")
        );
        List<String> typeCodes = new ArrayList<>(
                Arrays.asList("GON","FLT","TNK","BOX")
        );
        List<String> healthCodes = new ArrayList<>(
                Arrays.asList("A","U","B")
        );

        this.trackSeq = 0;
        this.ownerID =ownerIds.get(new Random().nextInt(ownerIds.size()));
        this.seriesCode = new Random().nextInt(200000,500000);
        this.typeCode =typeCodes.get(new Random().nextInt(4));
        this.buildDate = LocalDate.now();
        this.buildDate = LocalDate.now().minusYears(new Random().nextLong(30));
        this.healthCode =healthCodes.get(new Random().nextInt(3));
        this.carLength = 10;//new Random().nextInt(15,45);

        return this;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", trackSeq=" + trackSeq +
                ", ownerID='" + ownerID + '\'' +
                ", seriesCode=" + seriesCode +
                ", typeCode='" + typeCode + '\'' +
                ", buildDate=" + buildDate +
                ", carLength=" + carLength +
                ", healthCode='" + healthCode + '\'' +
                ", track=" + track.getId() +
                ", block=" + 1 +
                '}';
    }
}
