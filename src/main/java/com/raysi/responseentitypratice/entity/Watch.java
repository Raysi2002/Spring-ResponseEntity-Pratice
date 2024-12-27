package com.raysi.responseentitypratice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Data // Lombok annotation to generate getters, setters, equals, hashCode, and toString methods
@AllArgsConstructor // Generates a constructor with all fields as parameters
@NoArgsConstructor // Generates a no-args constructor
@ToString // Generates a toString method
@Table(name = "watch") // Specifies the table name in the database
public class Watch {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE, // Sequence-based ID generation strategy
            generator = "watch_seq" // References the sequence generator
    )
    @SequenceGenerator(
            name = "watch_seq", // Name of the sequence generator
            sequenceName = "watch_sequence", // Database sequence name
            allocationSize = 116 // Increments the sequence by 116 for optimization
    )
    private Long id; // Primary key for the Watch entity

    @NotNull // Ensures the name field cannot be null
    private String name; // Name of the watch

    @NotNull // Ensures the type field cannot be null
    private String type; // Type of the watch (e.g., analog, digital)
}