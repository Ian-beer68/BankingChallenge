package org.ian.banking.challenge.domain;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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
    private String Country;

    public Address(@NotNull @NotEmpty String addressLine1,
                   String addressLine2,
                   @NotNull @NotEmpty String city,
                   @NotNull @NotEmpty String country) {
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        Country = country;
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
        return Country;
    }
}
