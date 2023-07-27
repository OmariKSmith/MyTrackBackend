package com.mytrackmysql.services;

import com.mytrackmysql.DTO.TrackDTO;
import com.mytrackmysql.model.Car;
import com.mytrackmysql.model.CarRepository;
import com.mytrackmysql.model.Track;
import com.mytrackmysql.model.TrackRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class TrackServices {
    TrackRepository trackRepository;
    CarRepository carRepository;



    public List<TrackDTO> findAllTracks(){
        List<TrackDTO> trackDTOS = new ArrayList<>();
        List<Track> tracks = trackRepository.findAllTracks();
        tracks.forEach(track -> trackDTOS.add(new TrackDTO()));

        for (int i = 0; i < trackDTOS.size(); i++) {
            TrackDTO trackDTO = trackDTOS.get(i);
            Track track = tracks.get(i);
            trackDTO.setId(track.getId());
            trackDTO.setTrackNumber(track.getTrackNumber());
            trackDTO.setYard(track.getYard().getId());

        }

        return trackDTOS;
    }

    public void switchCar(Car car, int destTrack){
        Track srcTrack = car.getTrack();

        Track dstTrack = trackRepository
                .findTrackByTrackNumber(destTrack);

        srcTrack.removeCar(car);

        dstTrack.addCarToTrack(car);
        trackRepository.save(dstTrack);
    }
// --Commented out by Inspection START (7/27/2023 11:43 AM):
//    public void switchCars(List<Car> cars, int destTrack){
//        Track dstTrack = trackRepository
//                .findTrackByTrackNumber(destTrack);
//        Track track = cars.get(0).getTrack();
//        track.removeCarsFromTrack(cars);
//
//        for (Car c:cars) {
//            dstTrack.addCarToTrack(c);
//        }
//        trackRepository.save(dstTrack);
//    }
// --Commented out by Inspection STOP (7/27/2023 11:43 AM)
    public void insertCar(Car car,int trackNumber,int carSequence){
        //insert car in list
        //sequence carList
        Track track = trackRepository
                .findTrackByTrackNumber(trackNumber);
        List<Car>  carList = track.getCarList();
        carList.add(carSequence,car);
    }
}
