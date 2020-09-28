package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name="note_type")
public class NoteType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
