package ru.kildeev.persist;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class UserRepository {

    private final Map<Long, User> userMap = new ConcurrentHashMap<>();

    private final AtomicLong identity = new AtomicLong(0);

    public List<User> findAll(){
        return new ArrayList<>(userMap.values());
    }

    public void insert(User user){
        long id = identity.incrementAndGet();
        user.setId(id);
        userMap.put(id, user);
    }

    public void update(User user){
        userMap.put(user.getId(), user);
    }

    public void delete(User user){
        userMap.remove(user.getId());
    }
    public void delete(Long id){
        userMap.remove(id);
    }
}
