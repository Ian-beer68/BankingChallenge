package org.ian.banking.challenge.domain;

import org.apache.tomcat.util.descriptor.tld.TaglibXml;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Objects;

public class Transaction {
    private String id;
    @NotNull
    private TxAccount debitAccount;
    @NotNull
    private TxAccount creditAccount;
    private LocalDate createDate;
    private String message;



    @Override
    public String toString() {
        return Objects.toString(this);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this);
    }

    @Override
    public boolean equals(Object o) {
        return Objects.equals(this, o);
    }


}
