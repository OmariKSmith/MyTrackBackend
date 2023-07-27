package com.mytrackmysql.controllers;

import com.mytrackmysql.DTO.TrackDTO;
import com.mytrackmysql.services.TrackServices;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1")
@AllArgsConstructor
public class TrackController {

    TrackServices trackServices;
    @GetMapping("/findAllTracks")
    public List<TrackDTO> findAllTracks(){

        return trackServices.findAllTracks();
    }
}
