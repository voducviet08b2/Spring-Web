package com.example.demo.service.impl;

import com.example.demo.model.Note;
import com.example.demo.repository.NoteRepository;
import com.example.demo.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    private NoteRepository noteRepository;

    @Override
    public List<Note> findAll() {
        return noteRepository.findAll();
    }
}
