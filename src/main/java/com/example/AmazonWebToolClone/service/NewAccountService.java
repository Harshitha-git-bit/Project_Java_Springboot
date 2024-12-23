package com.example.AmazonWebToolClone.service;

import java.util.List;

import com.example.AmazonWebToolClone.entities.UserAccounts;

public interface NewAccountService {
   public UserAccounts saveaccount(UserAccounts saveacc);
   public UserAccounts updateaccount(UserAccounts updateacc);
   public void deleteaccount(UserAccounts deleteacc);
   public List<UserAccounts> findAll();
   public List<UserAccounts> findById(int id);
   public String findByEmail(String email);
   public String findByMobile(String mobile);
   public String findPasswordByEmail(String email);
   public String findPasswordByMobile(String mobile);
}
