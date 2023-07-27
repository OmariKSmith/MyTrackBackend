package com.mytrackmysql.controllers;

import com.mytrackmysql.model.Train;
import com.mytrackmysql.DTO.TrainDTO;
import com.mytrackmysql.services.TrainServices;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@AllArgsConstructor
@RestController
@RequestMapping(path = "api/v1")
public class TrainController {

    TrainServices trainServices;
    @GetMapping("/getAllTrains")
    public List<TrainDTO> getAllTrains(){
        return trainServices.findAllTrains();
    }
    @CrossOrigin
    @PostMapping("/addTrain")
    public void addTrain(@RequestBody Train train) {
        trainServices.addTrain(train);
    }
    @PostMapping("/updateTrain")
    public void updateTrain(@RequestBody String trainSymbol){
        trainServices.updateTrain(trainSymbol);
    }
    @DeleteMapping(path = "deleteTrainById/{id}")
    public void deleteTrainById(@PathVariable("id") Long id){
        trainServices.deleteTrainById(id);
    }

}
