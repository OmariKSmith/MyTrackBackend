package com.mytrackmysql.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Yard")
@Table(name = "yard")
public class Yard {
    @Id
    @SequenceGenerator(
            name = "yard_sequence",
            sequenceName = "yard_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(name = "YARD_ID")
    private Long id;

    @OneToMany(mappedBy = "yard",
            orphanRemoval = true,fetch = FetchType.EAGER,
            cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    private List<Crew> crewList = new ArrayList<>();

    //THE MANY SIDE TO TRACK ENTITY
    @OneToMany(mappedBy = "yard",
    orphanRemoval = true,fetch = FetchType.EAGER,
    cascade = {CascadeType.PERSIST,CascadeType.REMOVE,CascadeType.MERGE})
    private List<Track> trackList = new ArrayList<>();

    public Yard(int numberOfTracks){
        for (int i = 0; i < numberOfTracks; i++) {
            trackList.add(new Track());
            trackList.get(i).setYard(this);
            trackList.get(i).setTrackNumber(i+1);
        }
    }

    public void addCarsToTrack(int trackNumber, List<Car> cars){
        Track track = getTrackList().get(trackNumber-1);
        track.addCarsToTrack(cars);
    }

}
