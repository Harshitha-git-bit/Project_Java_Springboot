package com.example.AmazonWebToolClone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AmazonWebToolClone.entities.UserAccounts;
import com.example.AmazonWebToolClone.repository.NewAccountRepository;

@Service
public class NewAccountServiceImpl implements NewAccountService {
   
	@Autowired
	public NewAccountRepository nr;
	@Override
	public UserAccounts saveaccount(UserAccounts saveacc) {
		nr.save(saveacc);
		return null;
	}

	@Override
	public UserAccounts updateaccount(UserAccounts updateacc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteaccount(UserAccounts deleteacc) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<UserAccounts> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserAccounts> findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String findByEmail(String email) {
		return nr.findByemail(email);
		
	}

	@Override
	public String findByMobile(String mobile) {
		// TODO Auto-generated method stub
		return nr.findByMobile(mobile);
	}

	@Override
	public String findPasswordByEmail(String email) {
		// TODO Auto-generated method stub
		return nr.findPasswordByEmail(email);
	}

	@Override
	public String findPasswordByMobile(String mobile) {
		// TODO Auto-generated method stub
		return nr.findPasswordByMobile(mobile);
	}

}
