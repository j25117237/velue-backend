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
import com.velue.dto.Role;
import com.velue.services.RoleService;

@RestController
@RequestMapping("/role/")
public class RoleController {

  private RoleService roleService;

  @Autowired
  public RoleController(RoleService roleService) {
    this.roleService = roleService;
  }

  @PostMapping("/add")
  public Role addRole(@RequestBody Role role) {
    return roleService.addRole(role);
  }

  @GetMapping("/getAllRoles")
  public List<Role> findAllRoles() {
    return roleService.getAllRoles();
  }

  @GetMapping("/getAllPermission")
  public List<Permission> findAllPermission() {
    return roleService.getAllPermission();
  }

  @PutMapping("/edit")
  public Role editRole(@RequestBody Role role) {
    return roleService.editRole(role);
  }

  @DeleteMapping("/delete/{id}")
  public void deleteRole(@PathVariable Long id) {
    roleService.deleteRole(id);
  }
}
