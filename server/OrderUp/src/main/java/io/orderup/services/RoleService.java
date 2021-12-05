package io.orderup.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;


@Service
@Transactional
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

 public List<Roles> getAllRoles(){
        List<Roles> roles = new ArrayList<>();
        roleRepository.findAll()
                .forEach(roles::add);
        return roles;
    }
 
  public Optional<Roles> getRole(String id){
            return roleRepository.findById(id);
    }

  public void addRole(Roles role){
        roleRepository.save(role);
    }

    public void updateRole(String id, Roles role){
        roleRepository.save(role);
    }

    public void deleteRole(String id){
        roleRepository.deleteById(id);
    }
