package com.example.security.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

	@Autowired
//	AccountRepository accountRep;
	AccountService accountService;
	
	@GetMapping("/create")
	public Account create() {
		Account account = new Account();
		account.setEmail("syacorn@gmail.com");
		account.setPassword("password");
		
//		return accountRep.save(account);
		return accountService.save(account);
	}
}
