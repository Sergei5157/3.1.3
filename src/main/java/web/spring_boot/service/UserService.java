package web.spring_boot.service;

import web.spring_boot.models.User;

import java.util.List;

public interface UserService {
    User findByUserEmail(String login_name);

    List<User> getAll();

    User getOne(long id);

    void add(User user);

    void remove(long id);

    void update(long id, User user);
}
