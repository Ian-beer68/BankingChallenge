package org.ian.banking.challenge.domain;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class TxAccount {
    @NotNull @NotEmpty
    private String accountNumber;
    @NotNull @NotEmpty
    private String sortCode;

    public TxAccount(@NotNull @NotEmpty String accountNumber,
                     @NotNull @NotEmpty String sortCode) {
        this.accountNumber = accountNumber;
        this.sortCode = sortCode;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getSortCode() {
        return sortCode;
    }

    @Override
    public String toString() {
        return Objects.toString(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TxAccount txAccount = (TxAccount) o;
        return Objects.equals(accountNumber, txAccount.accountNumber) &&
                Objects.equals(sortCode, txAccount.sortCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber, sortCode);
    }
}
