package com.example.person.db.data;

import com.example.person.annotation.env.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@NoArgsConstructor
public class Person {

    public Person(@NotBlank(message = "Name cannot be null") @Size(max = 100) String name, @NotNull(message = "Age cannot be null") @Max(value = 150, message = "Age should not be greater than 150") Integer age, @NotBlank(message = "Gender cannot be null") String gender, Integer height, Integer weight) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
    }

    @Id
    private Integer id;

    @NotBlank(message = "Name cannot be null")
    @Size(max = 100)
    private String name;

    @NotNull(message = "Age cannot be null")
    @Max(value = 150, message = "Age should not be greater than 150")
    private Integer age;

    @NotBlank(message = "Gender cannot be null")
    private String gender;

    private Integer height;

    private Integer weight;

    private Address address;

    @CreatedDate
    @JsonFormat(pattern = DateTimeFormat.TARGET_DEFAULT_FORMAT)
    private LocalDateTime createDate;
}
