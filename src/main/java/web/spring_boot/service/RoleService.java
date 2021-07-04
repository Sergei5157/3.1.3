package web.spring_boot.service;


import web.spring_boot.models.Role;
import web.spring_boot.models.User;

import java.util.List;

public interface RoleService {
    Role getOne(long id);
    List<Role> getAll();
    void relation(User user, long [] roleId);

}
