package ru.kildeev.repository;

import lombok.NoArgsConstructor;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@NoArgsConstructor
public class L6EntityManagerFactory {

    private static final EntityManagerFactory emFactory;

    static {
        emFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
    }

//    @PostConstruct
//    public void init() {
//        emFactory = new Configuration()
//                .configure("hibernate.cfg.xml")
//                .buildSessionFactory();
//    }

    public EntityManager getEntityManager(){
        return emFactory.createEntityManager();
    }


}
