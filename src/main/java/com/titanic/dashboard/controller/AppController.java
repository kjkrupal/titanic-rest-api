package com.titanic.dashboard.controller;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.titanic.dashboard.entity.Passenger;
import com.titanic.dashboard.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;


@RestController
@RequestMapping("/titanic")
public class AppController {

    private PassengerService passengerService;

    @Autowired
    public AppController(PassengerService passengerService) {
        this.passengerService = passengerService;
    }

    @RequestMapping(value = "/passengers", method = RequestMethod.GET)
    public List<Passenger> findAll() {
        return passengerService.findAll();
    }

    @RequestMapping(value = "/passenger/{id}", method = RequestMethod.GET)
    public Passenger getPassenger(@PathVariable int id) {

        Passenger passenger = passengerService.findById(id);

        if(passenger == null) {
            throw new RuntimeException(("Employee id not found: " + id));
        }

        return passenger;
    }

    @RequestMapping(value = "/passenger", method = RequestMethod.PUT)
    public Passenger updatePassenger(@RequestBody Passenger passenger) {
        return passengerService.save(passenger);

    }

    @RequestMapping(value = "/passenger", method = RequestMethod.POST)
    public Passenger addNewPassenger(@RequestBody Passenger passenger) {
        return passengerService.save(passenger);

    }

    @RequestMapping(value = "/passenger/{id}", method = RequestMethod.DELETE)
    public void deletePassenger(@PathVariable int id) {

        Passenger passenger = passengerService.findById(id);

        if(passenger == null) {
            throw new RuntimeException("Passenger not present for id: " +id);
        }

        passengerService.deleteById(id);
    }

    @RequestMapping(value = "/passengers", method = RequestMethod.POST)
    public String uploadCSV(@RequestParam("file") MultipartFile file) throws Exception{

        passengerService.uploadCSV(file);

        return "";


    }


}
