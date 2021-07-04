package web.spring_boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.spring_boot.models.Role;
import web.spring_boot.models.User;
import web.spring_boot.repository.RoleRepository;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RoleServiceImp implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role getOne(long id) {
        return roleRepository.getById(id);
    }

    @Override
    public List<Role> getAll() {
        return roleRepository.findAll();
    }

    @Override
    public void relation(User user, long[] roleId) {
        Set<Role> role = new HashSet<>();
        for (Long id : roleId) {
            role.add(getOne(id));
        }
        user.setRoles(role);
    }

}
