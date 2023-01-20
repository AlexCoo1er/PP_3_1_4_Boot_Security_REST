package ru.kata.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.dao.RoleDao;
import ru.kata.spring.boot_security.demo.model.Role;

import javax.transaction.Transactional;
import java.util.List;

@Service

public class RoleServiceImpl implements RoleService {

    private final RoleDao roleDao;

    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public Role getRole(int id) {
        return roleDao.getRole(id);
    }

    @Override
    public List<Role> getList() {
        return roleDao.getList();
    }

    @Override
    @Transactional
    public void deleteRole(int id) {
        roleDao.deleteRole(id);
    }

    @Override
    @Transactional
    public void editRole(Role role) {
        roleDao.editRole(role);
    }

    @Override
    public List<Role> listByName(List<String> name) {
        return roleDao.listByName(name);
    }

    @Override
    @Transactional
    public void addRole(Role role) {
        roleDao.addRole(role);
    }
}
