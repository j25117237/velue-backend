package com.velue.services;

import java.util.List;

import com.velue.dto.Permission;
import com.velue.dto.Role;

public interface RoleService {
  //roles

  public Role addRole(Role role);

  public List<Role> getAllRoles();

  public List<Permission> getAllPermission();

  public Role editRole(Role role);

  public void deleteRole(Long id);
}
