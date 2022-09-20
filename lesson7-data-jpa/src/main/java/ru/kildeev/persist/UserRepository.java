package ru.kildeev.persist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAllByUsernameLike(String usernameFilter);

    @Query(value = """
           select * from users u 
           where (:usernameFilter is null or u.username like :usernameFilter )
           """, nativeQuery = true)
    List<User> userByUsername(String usernameFilter);
}
