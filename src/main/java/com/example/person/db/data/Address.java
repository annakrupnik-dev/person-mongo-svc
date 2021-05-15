package com.example.person.db.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

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
    @Id
    @Field("_id")
    private String id;

    private String street;

    private String city;

    @NotNull(message = "State cannot be null")
    private String state;

    private Integer zipcode;
}