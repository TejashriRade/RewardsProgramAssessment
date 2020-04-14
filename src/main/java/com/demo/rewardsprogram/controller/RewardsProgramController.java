package com.demo.rewardsprogram.controller;

import java.text.ParseException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.rewardsprogram.exception.ResourceNotFoundException;
import com.demo.rewardsprogram.model.Transaction;
import com.demo.rewardsprogram.model.TransactionRequest;
import com.demo.rewardsprogram.model.TransactionResponse;
import com.demo.rewardsprogram.service.TransactionService;

@RestController
@RequestMapping("/api")
public class RewardsProgramController {

	 	@Autowired
	    TransactionService transactionService;

	    @GetMapping(value="/transaction",produces=MediaType.APPLICATION_JSON_VALUE)
	    @ResponseBody 
	    public List<Transaction> getAllTransactions() {
	        return transactionService.getAllTransactions();
	    }
	    
	    @GetMapping(value="/rewards/{customerId}/{fromDate}/{toDate}",produces=MediaType.APPLICATION_JSON_VALUE)
	    @ResponseBody 
	    public TransactionResponse getTotalRewardsInrange(@PathVariable Long customerId,@PathVariable String fromDate,@PathVariable String toDate) throws ParseException {
	        return transactionService.getTotalRewardsInrange(customerId,fromDate,toDate);
	    }
	    
	    @GetMapping(value="/transaction/{customerId}/{fromDate}/{toDate}",produces=MediaType.APPLICATION_JSON_VALUE)
	    @ResponseBody 
	    public List<Transaction> getRewardsInrange(@PathVariable Long customerId,@PathVariable String fromDate,@PathVariable String toDate) throws ParseException {
	        return transactionService.getRewardsInrange(customerId,fromDate,toDate);
	    }
	    
	    

	    @PostMapping(value="/transaction",produces=MediaType.APPLICATION_JSON_VALUE)
	    @ResponseBody
	    public Transaction createTransaction(@Valid @RequestBody TransactionRequest transactionRequest) {
	        return transactionService.createTransaction(transactionRequest);
	    }

	    @GetMapping(value="/transaction/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	    @ResponseBody 
	    public Transaction getTransactionById(@PathVariable(value = "id") Long transactionId) {
	        return transactionService.getTransactionById(transactionId)
	                .orElseThrow(() -> new ResourceNotFoundException("Transaction", "id", transactionId));
	    }

	    @PutMapping(value="/transaction/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	    @ResponseBody 
	    public Transaction updateTransaction(@PathVariable(value = "id") Long transactionId,
	                                           @Valid @RequestBody TransactionRequest transactionDetails) {

	        Transaction updatedTransaction = transactionService.updateTransaction(transactionId,transactionDetails);
	        return updatedTransaction;
	    }

	    @DeleteMapping(value="/transaction/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	    @ResponseBody
	    public ResponseEntity<?> deleteTransaction(@PathVariable(value = "id") Long transactionId) {
	        transactionService.deleteTransaction(transactionId);

	        return ResponseEntity.ok().build();
	    }
}