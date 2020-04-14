package com.demo.rewardsprogram.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.rewardsprogram.exception.ResourceNotFoundException;
import com.demo.rewardsprogram.model.Customer;
import com.demo.rewardsprogram.model.Transaction;
import com.demo.rewardsprogram.model.TransactionRequest;
import com.demo.rewardsprogram.model.TransactionResponse;
import com.demo.rewardsprogram.repository.CustomerRepository;
import com.demo.rewardsprogram.repository.TransactionRepository;


@Service
public class TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;

	@Autowired
	private CustomerRepository customerRepository;

	public List<Transaction> getAllTransactions() {
		return transactionRepository.findAll();
	}

	public Transaction createTransaction(@Valid TransactionRequest transactionRequest) {
		Customer customer=customerRepository.findById(transactionRequest.getCustomerId())
				.orElseThrow(() -> new ResourceNotFoundException("Customer", "id",transactionRequest.getCustomerId()));
		Transaction transaction = new Transaction();
		transaction.setItemName(transactionRequest.getItemName());
		transaction.setItemCost(transactionRequest.getItemCost());
		transaction.setTransactionDate(new Date());
		transaction.setCreatedTimestamp(new Date());
		transaction.setUpdatedTimestamp(new Date());
		transaction.setRewardPoints(calculateRewardPoints(transactionRequest.getItemCost()));
		transaction.setCustomer(customer);
		return transactionRepository.save(transaction);
	}

	private Long calculateRewardPoints(Long itemCost) {
		Long rewardPoints = 0L;
		if (itemCost > 100) {
			rewardPoints = ((50) * 1) + ((itemCost - 100) * 2);
		} else if (itemCost > 50 && itemCost < 100) {
			rewardPoints = (itemCost - 50) * 1;
		}
		return rewardPoints;
	}

	public Optional<Transaction> getTransactionById(Long transactionId) {
		return transactionRepository.findById(transactionId);
	}

	public void deleteTransaction(Long transactionId) {
		Transaction transaction = getTransactionById(transactionId)
				.orElseThrow(() -> new ResourceNotFoundException("Transaction", "id", transactionId));
		transactionRepository.delete(transaction);

	}

	public Transaction updateTransaction(Long transactionId, @Valid TransactionRequest transactionRequest) {
		Customer customer=customerRepository.findById(transactionRequest.getCustomerId())
				.orElseThrow(() -> new ResourceNotFoundException("Customer", "id", transactionRequest.getCustomerId()));
		Transaction transaction = getTransactionById(transactionId)
				.orElseThrow(() -> new ResourceNotFoundException("Transaction", "id", transactionId));
		transaction.setItemName(transactionRequest.getItemName());
		transaction.setItemCost(transactionRequest.getItemCost());
		transaction.setUpdatedTimestamp(new Date());
		transaction.setTransactionDate(new Date());
		transaction.setRewardPoints(calculateRewardPoints(transactionRequest.getItemCost()));
		transaction.setCustomer(customer);
		return transactionRepository.save(transaction);
	}

	public List<Transaction> getRewardsInrange(Long CustomerId, String fromDate, String toDate) throws ParseException {
		SimpleDateFormat format=new SimpleDateFormat("MM-dd-yyyy");
		
		List<Transaction> trans=transactionRepository.getRewardsInrange(CustomerId,format.parse(fromDate),format.parse(toDate));
		return trans;
	}

	public TransactionResponse getTotalRewardsInrange(Long customerId, String fromDate, String toDate) throws ParseException {
		Customer customer=customerRepository.findById(customerId)
				.orElseThrow(() -> new ResourceNotFoundException("Customer", "id", customerId));
		List<Transaction> trans=getRewardsInrange(customerId,fromDate,toDate);
		
		TransactionResponse rewardResponse=new TransactionResponse();
		rewardResponse.setTotalTransactionAmount(trans.stream().mapToLong(transaction-> transaction.getItemCost()).sum());
		rewardResponse.setTotalRewardPoints(trans.stream().mapToLong(transaction-> transaction.getRewardPoints()).sum());
		rewardResponse.setCustomerId(customerId);
		rewardResponse.setCustomerName(customer.getCustomerName());
		return rewardResponse;
	}

}