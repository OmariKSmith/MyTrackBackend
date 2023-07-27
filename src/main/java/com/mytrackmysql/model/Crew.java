package com.mytrackmysql.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@ToString
@Getter
@Setter
@Entity(name = "CREWS")
@Table(name = "crews")
public class Crew {
    @Id
    @SequenceGenerator(
            name = "crew_sequence",
            sequenceName = "crew_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(name = "CREW_ID")
    private Long id;

    private String engineer;
    private String conductor;
    private String switchPerson;
    private LocalDateTime crewCallDateTime;
    private LocalDateTime crewExpireDateTime;
    @ManyToOne( cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    @JoinColumn(
            name = "TRAIN_ID",
            referencedColumnName = "TRAIN_ID",
            foreignKey = @ForeignKey(
                    name = "crew_train_fk"
            )
    )
    private Train train;

    @ManyToOne( cascade = {CascadeType.PERSIST,CascadeType.REMOVE,CascadeType.MERGE})
    @JoinColumn(
            name = "YARD_ID",
            referencedColumnName = "YARD_ID",
            foreignKey = @ForeignKey(
                    name = "yard_crew_fk"
            )
    )
    private Yard yard;

}
