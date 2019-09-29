package org.ian.banking.challenge.domain;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class Transaction {
    private String id;
    @NotNull
    private Account debitAccount;
    @NotNull
    private Account creditAccount;
    private LocalDate createDate;
    private String message;


}
