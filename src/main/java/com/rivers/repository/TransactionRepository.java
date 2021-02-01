package com.rivers.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.rivers.entity.TransactionDetails;

public interface TransactionRepository extends PagingAndSortingRepository<TransactionDetails, Long> {

	@Query("Select T from TransactionDetails T where T.accountDetails.accountNumber =?1 and T.transactionTs >= CURRENT_DATE()-(?2+0) ")
	public List<TransactionDetails> getByRange(String accountNumber, Integer range,Pageable paging);

	@Query("Select T from TransactionDetails T where T.accountDetails.accountNumber =?1 and T.transactionTs >= CURRENT_DATE()-(?2+0) AND T.type = ?3")
	public List<TransactionDetails> getByRange(String accountNumber, Integer range, String type,Pageable paging);

	@Query("Select T from TransactionDetails T where T.accountDetails.accountNumber =?1 and T.transactionTs BETWEEN ?2 AND ?3 ")
	public List<TransactionDetails> getByRange(String accountNumber, Date fromDate, Date toDate,Pageable paging);

	@Query("Select T from TransactionDetails T where T.accountDetails.accountNumber =?1 and T.transactionTs BETWEEN ?3 AND ?4  AND T.type = ?2")
	public List<TransactionDetails> getByRange(String accountNumber, String type, Date fromDate, Date toDate,Pageable paging);

}
