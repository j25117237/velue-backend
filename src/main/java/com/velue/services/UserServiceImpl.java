package com.velue.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.velue.dao.UserDetailsRepository;
import com.velue.dao.UserSalaryDetailsRepository;
import com.velue.dto.UserDetails;
import com.velue.dto.UserSalaryDetails;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserDetailsRepository userDetailsRepository;

  @Autowired
  private UserSalaryDetailsRepository userSalaryDetailsRepository;

  @Override
public UserDetails addUser(UserDetails userDetails) {
    UserDetails users = null;
    if (userDetails != null) {
      userDetails.setStatus("Enable");
      users = userDetailsRepository.save(userDetails);
    }
    return users;
  }

  @Override
public UserSalaryDetails addUserSalary(UserSalaryDetails userSalaryDetails) {
    UserDetails users = null;
    if (userSalaryDetails != null) {
      userSalaryDetails = userSalaryDetailsRepository.save(userSalaryDetails);
    }
    return userSalaryDetails;
  }

  @Override
  public Optional<UserDetails> getUserById(Long userId) {
    Optional<UserDetails> users = null;
    if (userId != null) {
      users = userDetailsRepository.findById(userId);
    }
    return users;
  }

  @Override
  public List<UserDetails> getAllUsers() {
    List<UserDetails> listUsers = null;
    try {
      listUsers = userDetailsRepository.findAll();
    } catch (Exception e) {}
    return listUsers;
  }

  @Override
  public UserDetails ModifyUserById(UserDetails users) {
    // UserDetails user = null;
    try {
      userDetailsRepository.save(users);
    } catch (Exception e) {
      System.out.printf("Failed to update based on Id", e);
    }
    return null;
  }

  @Override
  public UserSalaryDetails ModifyUserSalaryDetailsById(
    UserSalaryDetails userSalary
  ) {
    Long id = userSalary.getEmpReferenceId();

    Optional<UserSalaryDetails> existingSalaryDetails = userSalaryDetailsRepository.findById(
      id
    );
    if (existingSalaryDetails.isPresent()) {
      UserSalaryDetails filteredSalary = existingSalaryDetails.get();
      org.springframework.beans.BeanUtils.copyProperties(
        userSalary,
        filteredSalary
      );
      filteredSalary.setEmpReferenceId(id);
      return userSalaryDetailsRepository.save(userSalary);
    } else {
      throw new RuntimeException("User salary not found with id " + id);
    }
  }

  @Override
  public UserDetails ModifyUserByRole(UserDetails users) {
    UserDetails user = null;
    try {
      user = userDetailsRepository.getOne(users.getUserId());
      //user.setRole(users.getRole());
      user.setRoleId(users.getRoleId());
      user.setPassword(users.getPassword());
      user.setDateOfJoining(users.getDateOfJoining());
      userDetailsRepository.save(user);
    } catch (Exception e) {
      System.out.printf("Failed to update user Role based on Id", e);
    }
    return null;
  }

  @Override
  public UserDetails updateUserStatus(UserDetails users) {
    UserDetails user = null;
    try {
      user = userDetailsRepository.getOne(users.getUserId());
      user.setStatus(users.getStatus());
      userDetailsRepository.save(user);
    } catch (Exception e) {
      System.out.printf("Failed to update user Role based on Id", e);
    }
    return null;
  }

  // public User updateUser(User user) {
  // return userRepository.save(user);
  // }
  //
  // public User disableUser(User user) {
  // return userRepository.save(user);
  // }
  //
  @Override
public void deleteUser(Long id) {
    userDetailsRepository.deleteById(id);
  }

  //
  // public List<User> searchUsers() {
  // return userRepository.findAll();
  // }

  @Override
  public UserDetails validateLoginDetails(String email, String password) {
    return userDetailsRepository.findByEmailAddressAndPassword(email, password);
  }

  @Override
public List<UserDetails> getUserByName(String name) {
    return userDetailsRepository.findByUserName(name);
  }
}
