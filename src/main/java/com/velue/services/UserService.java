package com.velue.services;

import java.util.List;
import java.util.Optional;

import com.velue.dto.UserDetails;
import com.velue.dto.UserSalaryDetails;

public interface UserService {
  //	public List<User> getAllUsers();
  //
  public Optional<UserDetails> getUserById(Long userId);

  public List<UserDetails> getUserByName(String name);

  public UserDetails addUser(UserDetails userDetails);

  public UserSalaryDetails addUserSalary(UserSalaryDetails userSalaryDetails);

  //	public User updateUser(User user);
  //
  public void deleteUser(Long id);

  //
  //	public User disableUser(User user) ;
  public List<UserDetails> getAllUsers();

  public UserDetails ModifyUserById(UserDetails users);

  public UserDetails ModifyUserByRole(UserDetails users);

  public UserDetails updateUserStatus(UserDetails users);

  public UserDetails validateLoginDetails(String email, String password);

  public UserSalaryDetails ModifyUserSalaryDetailsById(
    UserSalaryDetails userSalary
  );
}
