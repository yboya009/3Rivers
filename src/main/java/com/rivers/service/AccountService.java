package com.rivers.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.rivers.entity.TransactionDetails;
import com.rivers.repository.AccountRepository;
import com.rivers.repository.TransactionRepository;

@Service
public class AccountService {

	@Autowired
	private AccountRepository accountRepo;

	@Autowired
	private TransactionRepository transactionRepo;

	public double getBalance(String accountNumber) {

		return accountRepo.findById(accountNumber).get().getBalance();
	}

	public List<TransactionDetails> getTransaction(String accountNumber, String range, String type, String fromDate,
			String toDate, int pageNumber, int pageSize) throws Exception {
		List<TransactionDetails> transactionDetails = null;
		isValid(range, fromDate, toDate);
		PageRequest paging = PageRequest.of(pageNumber, pageSize);
		if (range != null) {
			if (type == null)
				transactionDetails = transactionWithOutType(accountNumber, range, paging);
			else
				transactionDetails = transactionWithType(accountNumber, range, type, paging);
		} else {
			Date start = Date.valueOf(fromDate);
			Date end = Date.valueOf(toDate);
			if (type != null)
				transactionDetails = transactionRepo.getByRange(accountNumber, type, start, end, paging);
			else
				transactionDetails = transactionRepo.getByRange(accountNumber, start, end, paging);
		}

		return transactionDetails;
	}

	private boolean isValid(String range,String fromDate,String toDate) throws Exception {
		if(ObjectUtils.isEmpty(range)){
			if(ObjectUtils.isEmpty(toDate)  && ObjectUtils.isEmpty(fromDate)){
				throw  new Exception("Either provide range or provide from and to Date");
			}
		}
		else{
			if (!ObjectUtils.isEmpty(toDate)  || !ObjectUtils.isEmpty(fromDate)){
				throw  new Exception("Either provide range or provide from and to Date only");
			}
		}
		if((ObjectUtils.isEmpty(toDate)  && ObjectUtils.isEmpty(fromDate)) && ObjectUtils.isEmpty(range)  )
		{
			throw new Exception("Either provide range or provide from and to Date");
		}

		return true;
	}

	private List<TransactionDetails> transactionWithType(String accountNumber, String range, String type,
			PageRequest paging) {
		List<TransactionDetails> transactionDetails;
		switch (range.toLowerCase()) {
		case "today":
			transactionDetails = transactionRepo.getByRange(accountNumber, 1, type, paging);
			break;
		case "last_week":
			transactionDetails = transactionRepo.getByRange(accountNumber, 7, type, paging);
			break;
		case "last_month":
			transactionDetails = transactionRepo.getByRange(accountNumber, 30, type, paging);
			break;
		default:
			transactionDetails = null;
			break;
		}
		return transactionDetails;
	}

	private List<TransactionDetails> transactionWithOutType(String accountNumber, String range, PageRequest paging) {
		List<TransactionDetails> transactionDetails;
		switch (range.toLowerCase()) {
		case "today":
			transactionDetails = transactionRepo.getByRange(accountNumber, 1, paging);
			break;
		case "last_week":
			transactionDetails = transactionRepo.getByRange(accountNumber, 7, paging);
			break;
		case "last_month":
			transactionDetails = transactionRepo.getByRange(accountNumber, 30, paging);
			break;
		default:
			transactionDetails = null;
			break;
		}
		return transactionDetails;
	}

}
