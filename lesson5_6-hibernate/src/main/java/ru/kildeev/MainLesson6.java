package ru.kildeev;

import org.hibernate.cfg.Configuration;
import ru.kildeev.model.Contact;
import ru.kildeev.model.ContactType;
import ru.kildeev.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainLesson6 {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = new Configuration()
                .configure(("hibernate.cfg.xml"))
                .buildSessionFactory();

        Contact mobile = new Contact(ContactType.MOBILE_PHONE, "89161197974");
        Contact email = new Contact(ContactType.HOME_EMAIL, "mail@mail.ru");
        List<Contact> contacts = Arrays.asList(mobile, email);

        Contact mobile2 = new Contact(ContactType.MOBILE_PHONE, "89162003030");
        Contact email2 = new Contact(ContactType.HOME_EMAIL, "mail2@mail.ru");
        List<Contact> contacts2 = Arrays.asList(mobile2, email2);

        EntityManager entityManager = entityManagerFactory.createEntityManager();
//
//        entityManager.getTransaction().begin();
//        User user = new User("Sergey", contacts, "123");
//        User user2 = new User("Andrew", contacts2, "123");
//        contacts.forEach(contact -> contact.setUser(user));
//        contacts2.forEach(contact -> contact.setUser(user2));
//        entityManager.persist(user2);
//        entityManager.getTransaction().commit();

        List<User> users = entityManager.createNamedQuery("findAllUsers", User.class).getResultList();
        for (User user : users) {
            user.getContacts().forEach(System.out::println);
        }

        entityManager.close();
        entityManagerFactory.close();
    }
}
