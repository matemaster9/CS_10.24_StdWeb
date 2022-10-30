package es8.service;

import cs.matemaster.tech.es8.model.BankAccount;

/**
 * @author matemaster
 */
public interface BankAccountService {

    BankAccount getAccountByDocId(String docId);
}
