package io.orderup.services;

import io.orderup.models.Role;
import io.orderup.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public List<Role> getAllRoles() {
        List<Role> roles = new ArrayList<>();
        roleRepository.findAll()
                .forEach(roles::add);
        return roles;
    }

    public Optional<Role> getRole(String id) {
        return roleRepository.findById(id);
    }

    public void addRole(Role role) {
        roleRepository.save(role);
    }

    public void updateRole(String id, Role role) {
        roleRepository.save(role);
    }

    public void deleteRole(String id) {
        roleRepository.deleteById(id);
    }
}
