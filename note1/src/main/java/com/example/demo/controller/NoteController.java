package com.example.demo.controller;

import com.example.demo.model.Note;
import com.example.demo.service.NoteService;
import com.example.demo.service.impl.NoteServiceImpl;
import com.opencsv.CSVWriter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

@Controller
public class NoteController {
    @Autowired
    private NoteService noteService;
    private String PATH=".\\src\\main\\java\\com\\example\\demo\\controller";
    @GetMapping("/note")
    @ResponseBody
    public List<Note> getEmployee(){
        List<Note> noteList=noteService.findAll();
        return noteList;
    }
    @GetMapping("/create")
    public String givenUsingFile_whenCreatingFile_thenCorrect() throws IOException {
        try {
            File file = new File(PATH,"employees.json");

            if (file.createNewFile()) {
                System.out.println("A new File is created!");
            } else {
                System.out.println("This file already exists.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "index";

    }

    @GetMapping("/write")
    public String writeFile() throws IOException {
        FileWriter fileWriter=new FileWriter(".\\src\\main\\java\\com\\example\\demo\\controller\\employees.json");
        try{
            fileWriter.write("abc");

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(fileWriter!=null){
                try{
                    fileWriter.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        return "index";
    }
    @GetMapping("/json")
    public String getJson(){
        List<Note> noteList=noteService.findAll();
        JSONObject noteDetails;
        JSONObject noteObject;
        JSONArray noteJsonList=new JSONArray();
        for (Note note:
             noteList) {
            noteDetails=new JSONObject();
            noteDetails.put("id",note.getId());
            noteDetails.put("name",note.getName());
            noteDetails.put("content",note.getContent());
            noteDetails.put("note_type",note.getNoteType().getName());
            noteObject=new JSONObject();
            noteObject.put("Note",noteDetails);
            noteJsonList.add(noteObject);

        }

        //Write JSON file
        try (FileWriter file = new FileWriter(".\\src\\main\\java\\com\\example\\demo\\controller\\employees.json")) {

            file.write(noteJsonList.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "index";
    }


}
