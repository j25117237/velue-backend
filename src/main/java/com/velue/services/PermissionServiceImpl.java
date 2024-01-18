package com.velue.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.velue.dao.PermissionRepository;
import com.velue.dto.Permission;

@Service
public class PermissionServiceImpl implements PermissionService {

  @Autowired
  private PermissionRepository permissionRepository;

  @Autowired
  public PermissionServiceImpl(PermissionRepository permissionRepository) {
    this.permissionRepository = permissionRepository;
  }

  public List<Permission> getAllPermissions() {
    return permissionRepository.findAll();
  }

  @Override
public List<Permission> getAllPermission() {
    return permissionRepository.findAll();
  }

  @Override
public Permission addPermission(Permission permission) {
    return permissionRepository.save(permission);
  }

  public Permission getPermissionById(Long id) {
    Permission permission = permissionRepository
      .findById(id)
      .orElseThrow(() ->
        new RuntimeException("Permission not found with id " + id)
      );
    return permission;
  }

  @Override
public Permission editPermission(Permission permission) {
    return permissionRepository.save(permission);
  }

  @Override
public void deletePermission(Long id) {
    permissionRepository.deleteById(id);
  }
}
