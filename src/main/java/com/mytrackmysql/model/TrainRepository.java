package com.mytrackmysql.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface TrainRepository extends JpaRepository<Train,Long> {

    @Modifying
    @Transactional
    @Query(value = "CALL `mytrackdb`.`updateTrain`(?)", nativeQuery = true)
    void updateTrain(String trainSymbol);

    @Modifying
    @Transactional
    @Query(value = "CALL `mytrackdb`.`deleteTrain`(?)", nativeQuery = true)
    void deleteTrainById(Long id);

}
