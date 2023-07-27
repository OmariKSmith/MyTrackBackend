package com.mytrackmysql.controllers;

import com.mytrackmysql.DTO.YardDTO;
import com.mytrackmysql.model.YardRepository;
import com.mytrackmysql.services.YardServices;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "api/v1")
public class YardController {

    YardRepository yardRepository;
    YardServices yardServices;

    @GetMapping("/getYardBlocks")
    public List<YardDTO> getYardBlocks(){

        List<YardDTO> yardServ = yardServices.getTrackBlock();
        System.out.println("get Yard Blocks " + yardServ);
        return yardServ;
    }
}
