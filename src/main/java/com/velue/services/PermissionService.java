package com.velue.services;

import java.util.List;

import com.velue.dto.Permission;

public interface PermissionService {
  //roles

  public Permission addPermission(Permission permission);

  public List<Permission> getAllPermission();

  public Permission editPermission(Permission permission);

  public void deletePermission(Long id);
}
