package com.usa.ciclo3.reto3.controller;

import com.usa.ciclo3.reto3.entity.Score;
import com.usa.ciclo3.reto3.service.ScoreService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/Score")
public class ScoreController {
    
    @Autowired
    private ScoreService scoreService;
    
    @GetMapping("/all")
    public List<Score> getScoreList(){
        return scoreService.getList();
    }
    
    @GetMapping("/{id}")
    public Score getScoreById(@PathVariable("id") Long id){
        return scoreService.getById(id);
    }
    
    @PostMapping("/save")
    public ResponseEntity insertScore(@RequestBody Score score){
       scoreService.save(score);
       return ResponseEntity.status(201).build();
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteScore(@PathVariable("id") Long id){
       scoreService.delete(id);
       return ResponseEntity.status(204).build();
    }
    
}
