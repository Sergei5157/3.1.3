package web.spring_boot.service;

import web.spring_boot.models.User;

import java.util.List;

public interface UserService {
    User findByUserEmail(String email);

    List<User> getAll();

    User getOne(long id);

    User add(User user);

    void remove(Long id);


}
