package com.mytrackmysql.services;

import com.mytrackmysql.DTO.YardDTO;
import com.mytrackmysql.model.YardDTORepository;
import com.mytrackmysql.model.YardRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class YardServices {

    YardRepository yardRepository;
    YardDTORepository yardDTORepository;
    public List<YardDTO> getTrackBlock(){

        return yardDTORepository.getTrackBlock();
    }
}
