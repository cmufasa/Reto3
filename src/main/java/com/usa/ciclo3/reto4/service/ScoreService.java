package com.usa.ciclo3.reto4.service;

import com.usa.ciclo3.reto4.entity.Score;
import com.usa.ciclo3.reto4.entity.Score;
import com.usa.ciclo3.reto4.repository.ScoreRepository;
import java.util.List;
import java.util.Optional;
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

    public Score update(Score score) {
        if (score.getId() != null) {
            Optional<Score> scoreId = scoreRepository.findById(score.getId());

            if (!scoreId.isEmpty()) {
                Score scoreBd = scoreId.get();

                scoreBd.setMsgText(score.getMsgText());
                scoreBd.setValueScore(score.getValueScore());
                scoreBd.setReservation(score.getReservation());

                return scoreRepository.save(scoreBd);

            } else {

                return score;
            }
        }
        return score;
    }

    public void delete(Long id) {
        scoreRepository.deleteById(id);
    }

}
