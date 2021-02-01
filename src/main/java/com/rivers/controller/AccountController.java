package com.rivers.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rivers.entity.TransactionDetails;
import com.rivers.service.AccountService;

@RestController
public class AccountController {
	@Autowired
	private AccountService accountService;

	@GetMapping("/balance/{accountNumber}")
	public double accountBalance(@PathVariable String accountNumber) {

		return accountService.getBalance(accountNumber);
	}

	@GetMapping("/transaction/{accountNumber}")
	public List<TransactionDetails> getTransaction(@PathVariable String accountNumber,
			@RequestParam(required =  false) String range, @RequestParam(name = "fromdate" , required =  false) String fromDate,
			@RequestParam(name = "todate",required =  false) String toDate, @RequestParam(name = "type" , required = false) String type, 
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size) throws Exception {
		return accountService.getTransaction(accountNumber, range, type,fromDate,toDate, page, size);
	}

}
