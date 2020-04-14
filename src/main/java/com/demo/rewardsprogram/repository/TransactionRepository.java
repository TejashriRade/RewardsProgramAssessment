package com.demo.rewardsprogram.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.rewardsprogram.model.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

	@Query(value = "SELECT * FROM TRANSACTION where CUSTOMER_ID=:customerId and TRANSACTION_DATE between :fromDate and :toDate", nativeQuery = true)
	List<Transaction> getRewardsInrange(Long customerId, @Param("fromDate") Date fromDate, @Param("toDate") Date toDate);

}