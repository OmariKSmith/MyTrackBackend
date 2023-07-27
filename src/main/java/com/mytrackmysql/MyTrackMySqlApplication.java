package com.mytrackmysql;

import com.mytrackmysql.model.*;
import com.mytrackmysql.services.CarServices;
import com.mytrackmysql.services.TrackServices;
import com.mytrackmysql.services.TrainServices;
import com.mytrackmysql.services.YardServices;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class MyTrackMySqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyTrackMySqlApplication.class, args);
    }
    @Bean
    CommandLineRunner lineRunner(
            YardRepository yardRepository,
            YardDTORepository yardDTORepository,
            CarRepository carRepository,
            TrainRepository trainRepository,
            TrackRepository trackRepository,
            CarServices carServices,
            TrackServices trackServices,
            TrainServices trainServices,
            BlockRepository blockRepository,
            CarDTORepository carDTORepository,
            YardServices yardServices

    ){
        return args  -> {
          buildYard(yardRepository);
          //System.out.println("complete  "+ yardServices.getTrackBlock());
        };
}
    private void buildYard(YardRepository yardRepository) {
        Yard yard = new Yard(10);
        List<Car> cars1 = carList(10);
        List<Car> cars2 = carList(10);
        List<Car> cars3 = carList(10);
        yard.addCarsToTrack(1,cars1);
        yard.addCarsToTrack(2,cars2);
        yard.addCarsToTrack(3,cars3);
        yardRepository.save(yard);
    }

    public List<Car> carList(int listSize){
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < listSize; i++) {
            cars.add(new Car().build());
        }
        return cars;
    }
}
