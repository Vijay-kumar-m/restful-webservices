package com.in28minutes.rest.webservices.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDAOService {
    private static List<User> users= new ArrayList<>();

    private static int user_Count=0;

    static {
        users.add(new User(++user_Count, "Adam", LocalDate.now().minusYears(30)));
        users.add(new User(++user_Count, "Eve", LocalDate.now().minusYears(35)));
        users.add(new User(++user_Count, "Jim", LocalDate.now().minusYears(25)));
    }

    public List<User> findAll(){
        return users;
    }

    public User findOne(int id) {
        return users.stream().filter(user -> user.getId()==id).findFirst().orElse(null);
    }

    public User save(User user) {
        user.setId(++user_Count);
        users.add(user);
        return user;
    }

    public void deleteById(int id){
          users.removeIf(user -> user.getId() == id);
    }
}
