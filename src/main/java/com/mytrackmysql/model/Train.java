package com.mytrackmysql.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "train")
@Entity(name = "Train")

public class Train {

    private static Integer carCount = 0;// used for faker
    @Id
    @SequenceGenerator(
            name = "train_sequence",
            sequenceName = "train_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(name = "TRAIN_ID")
    private Long id;
    @Column(name = "TRAIN_SYMBOL")
    private String trainSymbol;
    @Column(name = "DEPART_YARD")
    private String departYardCode;
    @Column(name = "DEST_YARD")
    private String destinationYardCode;
    @Column(name = "DEPART_DATE")
    private LocalDate departureDate;

    @Column(name = "DEPART_TIME")
    private String departureTime;
    @Column(name = "ARRIVAL_DATE")

    private LocalDate arrivalDate;
    @Column(name = "ARRIVAL_TIME")
    private LocalTime arrivalTime;

    @Column(name = "LENGTH")
    private Integer trainLength;

    @OneToMany(mappedBy = "id",
            orphanRemoval = true, fetch = FetchType.EAGER,
            cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Crew> crewList = new ArrayList<>();

    @OneToMany(mappedBy = "id",cascade = CascadeType.ALL)
    private List<Engine> engineList = new ArrayList<>();
    @Column(name = "EOT")
    private String eot;

    @OneToMany(mappedBy = "id",
             fetch = FetchType.EAGER,
            cascade = {CascadeType.REMOVE,CascadeType.MERGE})
    private List<Block> blockList = new ArrayList<>();

    @Override
    public String toString() {
        return "Train{" +
                "id=" + id +
                ", trainSymbol='" + trainSymbol + '\'' +
                ", departYardCode='" + departYardCode + '\'' +
                ", destinationYardCode='" + destinationYardCode + '\'' +
                ", departureDate=" + departureDate +
                ", departureTime='" + departureTime + '\'' +
                ", arrivalDate=" + arrivalDate +
                ", arrivalTime=" + arrivalTime +
                ", trainLength=" + trainLength +
                ", crewList=" + crewList +
                ", engineList=" + engineList +
                ", eot='" + eot + '\'' +
                ", blockList=" + blockList +
                '}';
    }

//    public Train buildTrain(){
//        List<String> trainCallNames = Arrays.asList("YCGT","CNYC","NSYC","YCNS","IYC");
//        List<String> departYardCodes = Arrays.asList("MA018","MA027","MA056");
//        List<String> destinationYardCodes = Arrays.asList("MA101","MA154","MA125");
//        List<String> crewList = Arrays.asList("Mark Williams","Michel Peters","Paul Wang");
//        List<String> engineList = Arrays.asList("UP4589","UP9876","CN625");
//
//        this.trainSymbol = trainCallNames.get(new Random().nextInt(5))+new Random().nextInt(20,25);
//        this.departYardCode = departYardCodes.get(new Random().nextInt(3));
//        this.destinationYardCode = destinationYardCodes.get(new Random().nextInt(3));
//        this.departureDate = LocalDate.now();
//        this.departureTime = LocalTime.now().toString();
//        this.arrivalDate = LocalDate.now().plusDays(2);
//        this.arrivalTime = LocalTime.now().plusHours(3);
//        this.eot = "UP000000";
//
//        return  this;
//    }
}
