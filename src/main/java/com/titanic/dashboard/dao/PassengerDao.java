package com.titanic.dashboard.dao;

import com.titanic.dashboard.entity.Passenger;

import java.util.List;

public interface PassengerDao {

    List<Passenger> findAll();

    Passenger savePassenger(Passenger passenger);

    Passenger findById(int id);

    void deletePassenger(int passengerId);

}
