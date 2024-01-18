package com.velue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.velue.dto.Permission;
import com.velue.services.PermissionService;

@RestController
@RequestMapping("/permission/")
public class PermissionController {

  private PermissionService permissionService;

  @Autowired
  public PermissionController(PermissionService permissionService) {
    this.permissionService = permissionService;
  }

  @PostMapping("/add")
  public Permission addPermission(@RequestBody Permission permission) {
    return permissionService.addPermission(permission);
  }

  @GetMapping("/getAllPermission")
  public List<Permission> findAllPermission() {
    return permissionService.getAllPermission();
  }

  @PutMapping("/edit")
  public Permission editPermission(@RequestBody Permission permission) {
    return permissionService.editPermission(permission);
  }

  @DeleteMapping("/delete/{id}")
  public void deletePermission(@PathVariable Long id) {
    permissionService.deletePermission(id);
  }
}
