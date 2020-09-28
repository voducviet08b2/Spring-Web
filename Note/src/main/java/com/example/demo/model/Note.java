package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name="note")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String content;
    @ManyToOne
    @JoinColumn(name = "id_note_type")
    private NoteType noteType;
}
