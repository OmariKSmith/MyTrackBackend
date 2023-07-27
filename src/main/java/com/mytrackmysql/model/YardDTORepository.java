package com.mytrackmysql.model;

import com.mytrackmysql.DTO.YardDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface YardDTORepository extends JpaRepository<YardDTO, Long> {

    @Transactional
    @Query(value = "CALL `mytrackdb`.`getTrackBlock`()", nativeQuery = true)
    List<YardDTO> getTrackBlock();

}
