package org.ian.banking.challenge.domain;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class Client {
    private String id;
    @NotNull @NotEmpty
    private String name;
    @NotNull @NotEmpty
    private String surname;
    @NotNull
    private Address primaryAddress;
    @NotNull
    private Address secondaryAddress;
    @Email
    private String email;
    @NotNull @NotEmpty
    private String telephone;

    public Client(String id,
                  @NotNull @NotEmpty String name,
                  @NotNull @NotEmpty String surname,
                  @NotNull Address primaryAddress,
                  @NotNull Address secondaryAddress,
                  @Email String email,
                  @NotNull @NotEmpty String telephone) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.primaryAddress = primaryAddress;
        this.secondaryAddress = secondaryAddress;
        this.email = email;
        this.telephone = telephone;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Address getPrimaryAddress() {
        return primaryAddress;
    }

    public Address getSecondaryAddress() {
        return secondaryAddress;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephone() {
        return telephone;
    }

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
