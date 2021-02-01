package com.rivers.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rivers.entity.AccountDetails;
import com.rivers.entity.TransactionDetails;
import com.rivers.repository.AccountRepository;

@Service
public class KafkaService {

	private AccountRepository accountRepo;

	@Autowired
	private ObjectMapper objectMapper;

	public void receive(ConsumerRecord<String, String> record) throws JsonMappingException, JsonProcessingException {

		String jsonStr = record.value();
		AccountDetails accountDetails = null;
		TransactionDetails transaction = null;
		if (jsonStr.contains("type")) {
			transaction = objectMapper.readValue(jsonStr, TransactionDetails.class);
			accountDetails = accountRepo.findById(transaction.getAccountDetails().getAccountNumber()).get();
			if (transaction.getType().equalsIgnoreCase("deposit")) {
				accountDetails.setBalance(accountDetails.getBalance() + transaction.getAmount());
			} else {
				accountDetails.setBalance(accountDetails.getBalance() - transaction.getAmount());
			}
			accountDetails.getTransactionDetails().add(transaction);

		} else {
			accountDetails = objectMapper.readValue(jsonStr, AccountDetails.class);

		}
		accountRepo.save(accountDetails);
	}
}