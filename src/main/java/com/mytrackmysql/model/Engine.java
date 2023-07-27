package com.mytrackmysql.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@Entity(name = "Engines")
@Table(name = "engines")
public class Engine {
    @Id
    @SequenceGenerator(
            name = "engines_sequence",
            sequenceName = "engines_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(name = "ENGINE_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(
            name = "YARD_ID",
            referencedColumnName = "YARD_ID",
            foreignKey = @ForeignKey(
                    name = "yar_engine_fk"
            )
    )
    private Yard yard;

    @ManyToOne
    @JoinColumn(
            name = "TRAIN_ID",
            referencedColumnName = "TRAIN_ID",
            foreignKey = @ForeignKey(
                    name = "yard_engine_fk"
            )
    )
    private Train train;
}
