package com.example.demo.controller;

import com.example.demo.model.Note;
import com.example.demo.service.NoteService;
import com.example.demo.service.impl.NoteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class NoteController {
   @Autowired
   private NoteService noteService;

    @GetMapping("/note")
    public ResponseEntity<List<Note>> getEmployee(){
        List<Note> noteList=noteService.findAll();
        return new ResponseEntity<>(noteList, HttpStatus.OK);
    }

}
