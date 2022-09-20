package ru.kildeev.persist;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class InMemoryUserRepository{

    private final Map<Long, User> userMap = new ConcurrentHashMap<>();

    private final AtomicLong identity = new AtomicLong(0);

    @PostConstruct
    public void init() {
        this.insert(new User("Andrew"));
        this.insert(new User("John"));
        this.insert(new User("Georgy"));
        this.insert(new User("Vladimir"));
        this.insert(new User("Bogdan"));
    }

    public List<User> findAll() {
        return new ArrayList<>(userMap.values());
    }

    public Optional<User> findById(Long id) {
        return Optional.ofNullable(userMap.get(id));
    }

    public void insert(User user) {
        long id = identity.incrementAndGet();
        user.setId(id);
        userMap.put(id, user);
    }

    public User update(User user) {
        if (user.getId() == null) {
            user.setId(identity.incrementAndGet());
        }
        userMap.put(user.getId(), user);
        return user;
    }

    public User save(User user) {
        if (user.getId() == null) {
            user.setId(identity.incrementAndGet());
        }
        userMap.put(user.getId(), user);
        return user;
    }

    public void deleteById(Long id) {
        userMap.remove(id);
    }

}
