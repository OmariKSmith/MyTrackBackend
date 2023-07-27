package com.mytrackmysql.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarRepository extends JpaRepository<Car,Long> {

    @Query(value = "CALL `mytrackdb`.`findCarsByTrack`(?)", nativeQuery = true)
    List<Car> findCarsByTrack(Long trackNumber);




}
