package com.titanic.dashboard.dao.impl;

import com.titanic.dashboard.dao.PassengerDao;
import com.titanic.dashboard.entity.Passenger;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class PassengerDaoImpl implements PassengerDao {

    private EntityManager entityManager;

    @Autowired
    public PassengerDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Passenger> findAll() {
        Session session = entityManager.unwrap(Session.class);
        Query<Passenger> query = session.createQuery("from Passenger", Passenger.class);
        List<Passenger> list = query.getResultList();
        return list;
    }

    @Override
    public Passenger savePassenger(Passenger passenger) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(passenger);
        int id = passenger.getId();
        Passenger new_passenger = session.get(Passenger.class, id);
        return new_passenger;
    }


    @Override
    public Passenger findById(int id) {
        Session session = entityManager.unwrap(Session.class);
        Passenger passenger = session.get(Passenger.class, id);
        return passenger;
    }

    @Override
    public void deletePassenger(int passengerId) {
        Session session = entityManager.unwrap(Session.class);
        Query<Passenger> query = session.createQuery("delete from Passenger where id=:pId");
        query.setParameter("pId", passengerId);
        query.executeUpdate();
    }

}
