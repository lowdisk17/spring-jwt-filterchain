package com.jwt.jwt.controller;

import org.springframework.web.bind.annotation.RestController;

import com.jwt.jwt.configuration.JwtUtil;
import com.jwt.jwt.dto.LoginRequest;
import com.jwt.jwt.service.MainService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;


@RestController
public class MainController {

  @Autowired
  private MainService service;

  @GetMapping("/service")
  public String getMethodName(@RequestHeader("Authorization") String authorization) {
      return service.process();
  }

  @PostMapping("/login")
  public String login(@RequestBody LoginRequest request) {
      // You can authenticate the user using your processing or database checking (e.g., using Spring Security's authentication manager)
      // If authentication is successful, generate a JWT
      // For the sake of testing we need to check if username is admin

      if (!"admin".equals(request.getUsername())) {
        return "Invalid User";
      }

      String token = JwtUtil.generateToken(request.getUsername());
      return token;
  }
  
}
