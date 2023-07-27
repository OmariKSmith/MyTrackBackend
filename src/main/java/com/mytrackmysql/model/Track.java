package com.mytrackmysql.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Track")
@Table(name = "track")

public class Track  {
    @Id
    @SequenceGenerator(
            name = "track_sequence",
            sequenceName = "track_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(name = "TRACK_ID")
    private Long id;

    //THE ONE SIDE TO YARD ENTITY
    @ManyToOne
    @JoinColumn(
            name = "YARD_ID",
            referencedColumnName = "YARD_ID",
            foreignKey = @ForeignKey(
                    name = "yard_track_fk"
            )
    )
    private Yard yard;




    //THE MANY SIDE TO CAR ENTITY
    @OneToMany(mappedBy = "track",
    orphanRemoval = true, fetch = FetchType.EAGER,
    cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Car> carList = new ArrayList<>();

    private Integer trackNumber;

    public void addCarToTrack(Car car){
        carList.add(car);
        car.setTrackSeq(this.carList.size());
        car.setTrack(this);
    }

    public void addCarsToTrack(List<Car> cars){
        cars.forEach(this::addCarToTrack);
    }

    public void addCarToTrackAtSequence(Car car, int sequenceNumber){
        carList.add(sequenceNumber,car);
        car.setTrack(this);
        resequenceTrack();
    }
// --Commented out by Inspection START (7/27/2023 11:52 AM):
//    public void addCarsToTrackAtSequence(List<Car> cars, int sequenceNumber){
//        carList.addAll(sequenceNumber,cars);
//        carList.forEach(car -> car.setTrack(this));
//        resequenceTrack();
//    }
// --Commented out by Inspection STOP (7/27/2023 11:52 AM)

    private void resequenceTrack() {
        for (int i = 0; i < carList.size(); i++) {
            carList.get(i).setTrackSeq(i+1);
        }
    }
    
    



  

    /*NOTE: Cars must be set to another track
            in production build. TRACK CANNOT BE NULL*/
    public void removeCar(Car car){
            carList.remove(car);
            car.setTrack(null);
    }

// --Commented out by Inspection START (7/27/2023 11:52 AM):
//    public void removeCarsFromTrack(List<Car> cars){
//        if(!new HashSet<>(this.carList).containsAll(cars)){
//            this.carList.removeAll(cars);
//            cars.forEach(car -> car.setTrack(null));
//        }
//    }
// --Commented out by Inspection STOP (7/27/2023 11:52 AM)

    @Override
    public String toString() {
        return "Track{" +
                "id=" + id +
                ", yard=" + yard +
                ", carList=" + carList +
                ", trackNumber=" + trackNumber +
                '}';
    }
}
