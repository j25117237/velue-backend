package com.velue.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.velue.dao.PermissionRepository;
import com.velue.dao.RoleRepository;
import com.velue.dto.Permission;
import com.velue.dto.Role;

@Service
public class RoleServiceImpl implements RoleService {

  private RoleRepository roleRepository;

  @Autowired
  private PermissionRepository permissionRepository;

  @Autowired
  public RoleServiceImpl(RoleRepository roleRepository) {
    this.roleRepository = roleRepository;
  }

  @Override
public List<Role> getAllRoles() {
    return roleRepository.findAll();
  }

  @Override
public List<Permission> getAllPermission() {
    return permissionRepository.findAll();
  }

  @Override
public Role addRole(Role role) {
    return roleRepository.save(role);
  }

  public Role getRoleById(Long id) {
    Role role = roleRepository
      .findById(id)
      .orElseThrow(() -> new RuntimeException("Role not found with id " + id));
    return role;
  }

  @Override
public Role editRole(Role role) {
    return roleRepository.save(role);
  }

  @Override
public void deleteRole(Long id) {
    roleRepository.deleteById(id);
  }
}
