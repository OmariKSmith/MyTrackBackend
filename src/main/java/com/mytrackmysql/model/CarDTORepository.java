package com.mytrackmysql.model;

import com.mytrackmysql.DTO.CarDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CarDTORepository extends JpaRepository<CarDTO,Long> {
    @Modifying
    @Transactional
    @Query(value = "CALL `mytrackdb`.`getCarList`()", nativeQuery = true)
    List<CarDTO> getCarList();

    @Modifying
    @Transactional
    @Query(value = "CALL `mytrackdb`.`updateCarOutBlock`(?)", nativeQuery = true)
    void updateCarOutBlock(String trainSymbol);
}
