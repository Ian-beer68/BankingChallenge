package org.ian.banking.challenge.domain;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class Address {
    @NotNull
    @NotEmpty
    private String addressLine1;
    private String addressLine2;
    @NotNull
    @NotEmpty
    private String city;
    @NotNull
    @NotEmpty
    private String country;

    public Address(@NotNull @NotEmpty String addressLine1,
                   String addressLine2,
                   @NotNull @NotEmpty String city,
                   @NotNull @NotEmpty String country) {
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.country = country;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
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
