package com.devinicius.dslist.services;

import com.devinicius.dslist.DTO.GameDTO;
import com.devinicius.dslist.DTO.GameMinDTO;
import com.devinicius.dslist.entities.Game;
import com.devinicius.dslist.repositories.GameRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {

    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Transactional(readOnly = true)
    public GameDTO findById(Long id) {
        /*
        Game result = gameRepository.findById(id).get();
        return new GameDTO(result);
        */

        Optional<Game> game = gameRepository.findById(id);
        return game.map(GameDTO::new).orElse(null);
    }
    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll(){
       List<Game> result = gameRepository.findAll();
       return result.stream().map(GameMinDTO::new).toList();
    }
}
