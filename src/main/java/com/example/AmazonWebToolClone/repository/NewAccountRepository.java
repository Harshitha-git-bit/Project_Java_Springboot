package com.example.AmazonWebToolClone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.AmazonWebToolClone.entities.UserAccounts;

public interface NewAccountRepository extends JpaRepository<UserAccounts,Integer>{
	 @Query(value="select Email from useraccounts where email=:email",nativeQuery=true)
     public String findByemail(String email);
	 
	 @Query(value="select mobile from useraccounts where mobile=:mobile",nativeQuery=true)
	 public String findByMobile(String mobile);
	 
	 @Query(value="select password from useraccounts where email=:email",nativeQuery=true)
	 public String findPasswordByEmail(String email);
	 
	 @Query(value="select password from useraccounts where mobile=:mobile",nativeQuery=true)
	 public String findPasswordByMobile(String mobile);
	 
	 
}
