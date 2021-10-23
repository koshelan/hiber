package com.example.hiber;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class DaoRepo {

    @PersistenceContext
    private EntityManager entityManager;


    public List<Persons> getPersonsByCity(String city) {
        Query query = entityManager
                .createQuery("select p from Persons p where lower(p.cityOfLiving) = lower(:city)", Persons.class);
        query.setParameter("city", city);
        return query.getResultList();
    }

    @Transactional
    public void prepare(Persons p) {
        System.out.println(p);
        entityManager.persist(p);
    }

}
