package org.example.springpirate.model;

import lombok.Builder;
import lombok.With;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Students")
@Builder
public record Student(String id,
                      String name,
                      int age) {
}
