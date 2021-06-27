package web.spring_boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.spring_boot.models.Role;
import web.spring_boot.models.User;
import web.spring_boot.repository.UserRepository;


import java.util.List;
import java.util.Set;

@Service
@Transactional
public class UserServiceImp implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getOne(long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public void add(User user) {
        userRepository.save(user);
    }

    @Override
    public void remove(User user) {
        userRepository.delete(user);
    }

    @Override
    public User findByUserEmail(String name) {
        return userRepository.findByEmail(name);

    }
}
