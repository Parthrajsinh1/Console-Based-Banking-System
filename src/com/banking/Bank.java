package com.banking;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Account> accounts = new ArrayList<>();
    private int nextAccountId = 1001; // Starting ID

    public void createAccount(String accountHolderName, double initialBalance) {
        Account newAccount = new Account(nextAccountId++, accountHolderName, initialBalance);
        accounts.add(newAccount);
        System.out.println("Account created! ID: " + newAccount.getAccountId() + ", Name: " + accountHolderName);
    }

    public Account findAccount(int accountId) {
        for (Account acc : accounts) {
            if (acc.getAccountId() == accountId) {
                return acc;
            }
        }
        return null;
    }
}
