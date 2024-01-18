package com.velue.controller;

import java.io.File;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.velue.dto.UserDetails;
import com.velue.dto.UserSalaryDetails;
import com.velue.services.UserService;

/*
Get all users: GET /api/users
Get a specific user by ID: GET /api/users/{userId}
Create a new user: POST /api/users
Update a user by ID: PUT /api/users/{userId}
Delete a user by ID: DELETE /api/users/{userId}
Search users by name or email: GET /api/users?name={name}&email={email}
 */
@RestController
@RequestMapping("/user/")
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping("/{id}")
  public Optional<UserDetails> getuserById(@PathVariable Long id) {
    return userService.getUserById(id);
  }

  @GetMapping("/getAllUsers")
  public List<UserDetails> getAllUserDetails() {
    List<UserDetails> listUsers = null;
    try {
      listUsers = userService.getAllUsers();
    } catch (Exception e) {
      // TODO: handle exception
    }
    return listUsers;
  }

  @PostMapping(
    value = "/saveUsers",
    consumes = MediaType.MULTIPART_FORM_DATA_VALUE
  )
  public ResponseEntity<?> saveUsers(
    @RequestParam("user") String userDetails,
    @RequestParam(value = "profile", required = false) MultipartFile profile,
    @RequestParam(value = "pan", required = false) MultipartFile pan,
    @RequestParam(value = "aadhar", required = false) MultipartFile aadhar
  ) {
    ObjectMapper obj = new ObjectMapper();
    UserDetails userDetail = new UserDetails();
    try {
      userDetail = obj.readValue(userDetails, UserDetails.class);
    } catch (JsonProcessingException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    if (userDetails != null) {
      UserSalaryDetails userSalary = userDetail.getUserSalaryDetails();

      userSalary = userService.addUserSalary(userSalary);

      Long id = userSalary.getEmpReferenceId();
      userDetail.setEmpReferenceId(id);

      userDetail = userService.addUser(userDetail);

      try {
        if (profile != null) {
          String profileFileName = profile.getOriginalFilename();
          profile.transferTo(
            new File("D:\\projects\\Github\\velue\\public\\" + profileFileName)
          );
        }
        if (pan != null) {
          String panFileName = pan.getOriginalFilename();
          pan.transferTo(
            new File("D:\\projects\\Github\\velue\\public\\" + panFileName)
          );
        }

        if (aadhar != null) {
          String aadharFileName = aadhar.getOriginalFilename();
          aadhar.transferTo(
            new File("D:\\projects\\Github\\velue\\public\\" + aadharFileName)
          );
        }
      } catch (Exception e) {
        return null;
      }
    }
    return null;
  }

  @GetMapping("/search/name/{name}")
  public List<UserDetails> getUserByName(@PathVariable String name) {
    return userService.getUserByName(name);
  }

  @PutMapping("/modifySalaryById")
  public UserSalaryDetails updateUserSalaryDetails(
    @RequestParam("userSalary") String userSalary
  ) {
    ObjectMapper obj = new ObjectMapper();
    UserSalaryDetails userSalaryDetails = new UserSalaryDetails();
    try {
      userSalaryDetails = obj.readValue(userSalary, UserSalaryDetails.class);
    } catch (JsonProcessingException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return userService.ModifyUserSalaryDetailsById(userSalaryDetails);
  }

  @PutMapping("/modifiybasicdetailsbyId")
  public UserDetails UpdateUserBasicDetails(
    @RequestParam("user") String userDetails,
    @RequestParam(value = "profile", required = false) MultipartFile profile,
    @RequestParam(value = "pan", required = false) MultipartFile pan,
    @RequestParam(value = "aadhar", required = false) MultipartFile aadhar
  ) {
    ObjectMapper obj = new ObjectMapper();
    UserDetails userDetail = new UserDetails();
    try {
      userDetail = obj.readValue(userDetails, UserDetails.class);
    } catch (JsonProcessingException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    if (userDetails != null) {
      userService.ModifyUserById(userDetail);

      try {
        if (profile != null) {
          String profileFileName = profile.getOriginalFilename();
          profile.transferTo(
            new File("D:\\projects\\Github\\velue\\public\\" + profileFileName)
          );
        }
        if (pan != null) {
          String panFileName = pan.getOriginalFilename();
          pan.transferTo(
            new File("D:\\projects\\Github\\velue\\public\\" + panFileName)
          );
        }

        if (aadhar != null) {
          String aadharFileName = aadhar.getOriginalFilename();
          aadhar.transferTo(
            new File("D:\\projects\\Github\\velue\\public\\" + aadharFileName)
          );
        }
      } catch (Exception e) {
        return null;
      }
    }
    return null;
  }

  @PutMapping("/modifyuserRole")
  public UserDetails updateUserRole(@RequestBody UserDetails users) {
    return userService.ModifyUserByRole(users);
  }

  @PutMapping("/editstatus")
  public UserDetails UpdateUserStatus(@RequestBody UserDetails users) {
    return userService.updateUserStatus(users);
  }

  // @PutMapping("ModifyUserSalaryDetails")
  // public UserSalaryDetails updateUserSalaryDetails(@RequestBody
  // UserSalaryDetails salaryDetails) {
  //
  // }
  @DeleteMapping("/delete/{id}")
  public void deleteUser(@PathVariable Long id) {
    userService.deleteUser(id);
  }

  @GetMapping("/login")
  public UserDetails validateLoginDetails(
    @RequestParam String email,
    @RequestParam String password
  ) {
    return userService.validateLoginDetails(email, password);
  }
}
