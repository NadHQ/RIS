package com.main.Entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

public class MainRepository implements IMainRepository {
    private static IMainRepository repository;

    public static IMainRepository getInstance() {
        if (repository == null) repository = new MainRepository();
        return repository;
    }

    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ejb");

    @PersistenceContext(unitName = "EntityBean")
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Override
    public MainEntity findById(int id) {
        MainEntity customer;
        try {
            entityManager.getTransaction().begin();
            customer = entityManager.find(MainEntity.class, id);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return customer;
    }
}
