package com.titanic.dashboard.service;

import com.titanic.dashboard.entity.Passenger;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface PassengerService {

    List<Passenger> findAll();

    Passenger findById(int id);

    Passenger save(Passenger passenger);

    void deleteById(int id);

    void uploadCSV(MultipartFile file) throws Exception;

}
