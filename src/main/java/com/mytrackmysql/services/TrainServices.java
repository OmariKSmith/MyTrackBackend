package com.mytrackmysql.services;

import com.mytrackmysql.DTO.TrainDTO;
import com.mytrackmysql.model.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class TrainServices {
    private TrainRepository trainRepository;
    private TrackRepository trackRepository;

    private CarRepository carRepository;

    private BlockRepository blockRepository;

    public List<TrainDTO> findAllTrains(){
        List<Train> trains = trainRepository.findAll();
        return getTrainDTOs(trains);
    }

    private static List<TrainDTO> getTrainDTOs(List<Train> trains) {
        List<TrainDTO> trainDTOS = new ArrayList<>();
        trains.forEach(car -> trainDTOS.add(new TrainDTO()));

        for (int i = 0; i < trainDTOS.size(); i++) {
            TrainDTO trainDTO =  trainDTOS.get(i);
            Train train =  trains.get(i);
            trainDTO.setId(train.getId());
            trainDTO.setTrainSymbol(train.getTrainSymbol());
            trainDTO.setDepartYardCode(train.getDepartYardCode());
            trainDTO.setDepartureDate(train.getDepartureDate());
            trainDTO.setDepartureTime(train.getDepartureTime());
            trainDTO.setDestinationYardCode(train.getDestinationYardCode());
            trainDTO.setTrainLength(train.getTrainLength());
            trainDTO.setEot(train.getEot());

            //System.out.println("trains.get(i) " + trains.get(i));
        }
        return trainDTOS;
    }

    public void addTrain(Train train){

        train.setTrainSymbol(train.getTrainSymbol() +"-"+ train.getDepartureDate().getDayOfMonth());
        train.setTrainLength(0);
        train.setDepartureTime(train.getDepartureTime().substring(11,16));

        trainRepository.save(train);
    }

    public void updateTrain(String trainSymbol){
        trainRepository.updateTrain(trainSymbol.substring(1, trainSymbol.length()-1));
    }

    public void deleteTrainById(Long id){
        trainRepository.deleteTrainById(id);
    }

// --Commented out by Inspection START (7/27/2023 11:45 AM):
//    public void setCarsToTrack(Train train, int destTrack){
//
//        List<Block> blocks = train.getBlockList();
//
//        Track dstTrack = trackRepository
//                .findTrackByTrackNumber(destTrack);
//
//        blocks.forEach(block -> block
//                .getCars()
//                .forEach(dstTrack::addCarToTrack));
//
//
//        train.removeBlocks(blocks);
//
//        blockRepository.saveAll(blocks);
//
//        trainRepository.save(train);
//    }
// --Commented out by Inspection STOP (7/27/2023 11:45 AM)

}
