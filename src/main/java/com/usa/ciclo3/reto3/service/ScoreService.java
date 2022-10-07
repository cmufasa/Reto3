package com.usa.ciclo3.reto3.service;

import com.usa.ciclo3.reto3.entity.Score;
import com.usa.ciclo3.reto3.repository.ScoreRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    public List<Score> getList() {
        return scoreRepository.findAll();
    }

    public Score getById(Long id) {
        return scoreRepository.findById(id).get();
    }

    public Score save(Score score) {
        return scoreRepository.save(score);
    }

    public void delete(Long id) {
        scoreRepository.deleteById(id);
    }

}
