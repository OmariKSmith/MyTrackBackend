package com.mytrackmysql.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity(name = "Block")
@Table(name = "block_list")

@AllArgsConstructor
@NoArgsConstructor
public class Block {
    @Id
    @SequenceGenerator(
            name = "block_sequence",
            sequenceName = "block_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(name = "BLOCK_ID")
    private Long id;

    @Column(name = "TRAIN_SYMBOL")
    private String trainSymbol;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(
            name = "TRAIN_ID",
            referencedColumnName = "TRAIN_ID",
            foreignKey = @ForeignKey(
                    name = "block_train_fk"
            )
    )
    private Train train;

    @ManyToOne
    @JoinColumn(
            name = "TRACK_ID",
            referencedColumnName = "TRACK_ID",
            foreignKey = @ForeignKey(
                    name = "block_track_fk"
            )
    )
    private Track track;
    @Column(name = "CAR_COUNT")
    private int carCount;

    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @OneToMany(
            mappedBy = "block",
            fetch = FetchType.EAGER,
            cascade = {CascadeType.MERGE}
    )
    List<Car> cars = new ArrayList<>();

    @Override
    public String toString() {
        return "Block{" +
                "id=" + id +
                ", trainSymbol='" + trainSymbol + '\'' +
                ", train=" + train.getId() +
                ", track=" + track.getId() +
                ", carCount=" + carCount +
                ", cars=" + cars +
                '}';
    }
}
