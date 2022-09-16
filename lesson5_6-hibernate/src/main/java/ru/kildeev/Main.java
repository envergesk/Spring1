package ru.kildeev;

import org.hibernate.cfg.Configuration;
import ru.kildeev.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class Main {

    public static void main(String[] args) {
//        EntityManagerFactory entityManagerFactory = new Configuration()
//                .configure("hibernate.cfg.xml")
//                .buildSessionFactory();

//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        **SQL**INSERT**OPERATION**
//        entityManager.getTransaction().begin();
//
//        entityManager.persist(new User("User1", "1@mail.ru", "pass1"));
//        entityManager.persist(new User("User2", "2@mail.ru", "pass2"));
//        entityManager.persist(new User("User3", "3@mail.ru", "pass3"));
//
//        entityManager.getTransaction().commit();

        //Select
//        User user = entityManager.find(User.class, 1L);
//        System.out.println(user.toString());

        //JPQL, HQL
//        List<User> users = entityManager.createQuery("select u from User u", User.class)
//                .getResultList();
//        for (User userFromDb : users) {
//            System.out.println(userFromDb);
//        }


        //UPDATE
//        entityManager.getTransaction().begin();
//        User user = entityManager.find(User.class, 1L);
//        user.setUsername("new UserNAME");
//        entityManager.getTransaction().commit();

//       entityManager.getTransaction().begin();
//       User user = new User ("User2New", "2@mail.ru", "pass2");
//       user.setId(2L);
//       entityManager.merge(user);
//       entityManager.getTransaction().commit();

        //DELETE
//        entityManager.getTransaction().begin();

//        entityManager.createQuery("delete from User u where u.id = 4").executeUpdate();
//       User user = entityManager.find(User.class, 3L);
//       entityManager.remove(user);
//       entityManager.getTransaction().commit();

//        entityManager.close();
//        entityManagerFactory.close();
    }
}
