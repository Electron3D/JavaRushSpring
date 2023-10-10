package com.electron3d.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(schema = "todo", name = "task")
@Data
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    @Enumerated(EnumType.ORDINAL)
    private Status status;
}
