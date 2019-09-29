package org.ian.banking.challenge.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class Account {
    private enum BalanceStatus{DR, CR};
    private String id;
    private int number;
    private int sortCode;
    private BalanceStatus balanceStatus;
    private LocalDate dateCreated;
    private BigDecimal balance;
    private AccountType accountType;

    public Account(String id, int number, int sortCode,
                   BalanceStatus balanceStatus, LocalDate dateCreated,
                   BigDecimal balance, AccountType accountType) {
        this.id = id;
        this.number = number;
        this.sortCode = sortCode;
        this.balanceStatus = balanceStatus;
        this.dateCreated = dateCreated;
        this.balance = balance;
        balance = balance.setScale(2, RoundingMode.CEILING);
        this.accountType = accountType;
    }

    public String getId() {
        return id;
    }

    public int getNumber() {
        return number;
    }

    public int getSortCode() {
        return sortCode;
    }

    public BalanceStatus getBalanceStatus() {
        return balanceStatus;
    }

    public LocalDate getDateCreated() {
        return  LocalDate.of(dateCreated.getYear(),
                dateCreated.getMonth(),
                dateCreated.getDayOfMonth());
    }

    public BigDecimal getBalance() {
        return BigDecimal.valueOf(balance.doubleValue());
    }

    public AccountType getAccountType() {
        return accountType;
    }
}
