package com.banking.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.banking.beans.Account;
import com.banking.beans.TransactionBean;
import com.banking.dao.TransactionDao;


public class TransactionService {
	
	TransactionDao dao = new TransactionDao();
	Account account = null;

	public List<Account> searchAccountBasedOnCustomerId(String customerId) {
		
		List<Account> accounts = new ArrayList<Account>();
		accounts = dao.searchAccountBasedOnCustomerId(customerId);
		return accounts;
	}
	
	
	/***
	 * 
	 * @param aCCOUNT_ID
	 * @return
	 */
	public List<Account> searchAccountBasedOnAccountId(String aCCOUNT_ID) {
		
		List<Account> accounts = new ArrayList<Account>();
		accounts = dao.searchAccountBasedOnAccountId(aCCOUNT_ID);
		return accounts;
	}


	public boolean depositMoney(String accountId, int depositAmount, String accountType) throws SQLException {
		boolean isAmountdeposited =  false;
		isAmountdeposited = dao.depositMoney(accountId,depositAmount,accountType);
		return isAmountdeposited;
	}


	public boolean withdrawMoney(String accountId, int depositAmount, String accountType) {
		boolean isAmountwithdrawed =  false;
		isAmountwithdrawed = dao.withdrawMoney(accountId,depositAmount,accountType);
		return isAmountwithdrawed;
	}


	public boolean transferMoney(String customerId, String sourceAccountType, String targetaccountType,
			int transferAmount) {
		boolean isAmountTransfered = false;
		isAmountTransfered = dao.transferMoney(customerId,sourceAccountType,targetaccountType,transferAmount);
		return isAmountTransfered;
	}


	public List<TransactionBean> getTrasaction(String accountId) {
		 List<TransactionBean> listOfTransaction = dao.getTransaction(accountId);
		return listOfTransaction;
	}

}
