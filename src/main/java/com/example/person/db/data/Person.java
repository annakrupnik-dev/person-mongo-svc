package com.example.person.db.data;

import com.example.person.annotation.env.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Document(collection = "persons")
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

    @Transient
    public static final String SEQUENCE_NAME = "person_sequence";

    @Id
    private long personId;

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
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime createDate;
}
