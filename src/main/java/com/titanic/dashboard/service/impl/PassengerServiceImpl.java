package com.titanic.dashboard.service.impl;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.titanic.dashboard.dao.PassengerDao;
import com.titanic.dashboard.entity.Passenger;
import com.titanic.dashboard.service.PassengerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Iterator;
import java.util.List;

@Service
public class PassengerServiceImpl implements PassengerService {

    private PassengerDao passengerDao;

    public PassengerServiceImpl(PassengerDao passengerDao) {
        this.passengerDao = passengerDao;
    }

    @Override
    @Transactional
    public List<Passenger> findAll() {
        return passengerDao.findAll();
    }

    @Override
    @Transactional
    public Passenger findById(int id) {
        return passengerDao.findById(id);
    }

    @Override
    @Transactional
    public Passenger save(Passenger passenger) {
        return passengerDao.savePassenger(passenger);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        passengerDao.deletePassenger(id);
    }

    @Override
    public void uploadCSV(MultipartFile file) throws Exception {

        Reader reader = new InputStreamReader(file.getInputStream());

        CsvToBean<Passenger> csvToBean = new CsvToBeanBuilder(reader)
                .withType(Passenger.class)
                .withIgnoreLeadingWhiteSpace(true)
                .build();

        Iterator<Passenger> iterator = csvToBean.iterator();

        while (iterator.hasNext()) {
            Passenger passenger = iterator.next();
            passengerDao.savePassenger(passenger);
        }


    }
}
