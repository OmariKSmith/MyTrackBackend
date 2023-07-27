package com.mytrackmysql.services;

import com.mytrackmysql.DTO.CarDTO;
import com.mytrackmysql.model.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CarServices {
    CarRepository carRepository;
    CarDTORepository carDTORepository;
    CarDTORepository tempCarRepository;

    public void createBlock(List<CarDTO> cars, String trainSymbol) {

        carDTORepository.saveAll(cars);
        carDTORepository.updateCarOutBlock(trainSymbol);
    }
    public List<CarDTO> findCarsByTrack(Long trackNumber){
        List<Car> carsByTrackId = carRepository.findCarsByTrack(trackNumber);
        return getCarDTOs(carsByTrackId);
    }



    public List<CarDTO> getCarList(){
        return carDTORepository.getCarList();
    }


    private static List<CarDTO> getCarDTOs(List<Car> cars) {
        List<CarDTO> carDTOs = new ArrayList<>();
        cars.forEach(car -> carDTOs.add(new CarDTO()));

        for (int i = 0; i < carDTOs.size(); i++) {
            CarDTO carDTO =  carDTOs.get(i);
            Car car =  cars.get(i);
            carDTO.setId(car.getId());
            carDTO.setTrackSeq(car.getTrackSeq());
            carDTO.setOwnerID(car.getOwnerID());
            carDTO.setSeriesCode(car.getSeriesCode());
            carDTO.setTypeCode(car.getTypeCode());
            carDTO.setHealthCode(car.getHealthCode());
            carDTO.setCarLength(car.getCarLength());
            carDTO.setBuildDate(car.getBuildDate());
            carDTO.setOutboundBlock(car.getOutboundBlock());
            carDTO.setTrack(car.getTrack().getId());
        }
        return carDTOs;
    }


}
