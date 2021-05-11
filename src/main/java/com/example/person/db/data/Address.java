package com.example.person.db.data;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@NoArgsConstructor
public class Address {

    public Address(String street, String city, @NotNull(message = "State cannot be null") String state, Integer zipcode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
    }

    private String street;

    private String city;

    @NotNull(message = "State cannot be null")
    private String state;

    private Integer zipcode;
}