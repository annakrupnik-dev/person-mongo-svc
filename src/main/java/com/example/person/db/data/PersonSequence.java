package com.example.person.db.data;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document(collection = "person_sequence")
public class PersonSequence {
    @Id
    private String id;

    private long seq;
}
