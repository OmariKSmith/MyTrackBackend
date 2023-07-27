package com.mytrackmysql.controllers;

import com.mytrackmysql.DTO.CarDTO;
import com.mytrackmysql.services.*;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@RestController
@RequestMapping(path = "api/v1")

public class CarController {

    CarServices carServices;
    @GetMapping("/getCarList")
    public List<CarDTO> getCarList(){
        List<CarDTO> carList = carServices.getCarList();
        System.out.println("getCarList " + carList);
        return carList;
    }
    @GetMapping(path = "/getCarsByTrack/{trackId}")
    public List<CarDTO> getCarsByTrack(@PathVariable Long trackId){
        return carServices.findCarsByTrack(trackId);
    }
    @PostMapping("/createBlock/{trainSymbol}")
    public void createBlock(@RequestBody List<CarDTO> cars,  @PathVariable String trainSymbol) {
        List<CarDTO> temp = new ArrayList<>();
        int breakIndex  = 0;

        for (int i = 0; i < cars.size(); i++) {

            for (int j = breakIndex; j < cars.size() - 1; j++) {

                CarDTO car = cars.get(j);
                CarDTO nextCar = cars.get(j + 1);
                temp.add(car);

                if (car.getTrackSeq() != (nextCar.getTrackSeq()-1)) {
                    breakIndex = j+1;
                    carServices.createBlock(temp,trainSymbol);
                    temp.clear();
                    break;
                }
            }
            if(i==cars.size()-1){
                System.out.println("breakIndex = " + breakIndex);
                break;
            }
        }
        temp.clear();

        for (int i = breakIndex; i <cars.size() ; i++) {
            temp.add(cars.get(i));
        }
        carServices.createBlock(temp,trainSymbol);

    }


}
