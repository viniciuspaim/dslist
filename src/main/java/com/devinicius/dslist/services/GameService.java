package com.devinicius.dslist.services;

import com.devinicius.dslist.DTO.GameMinDTO;
import com.devinicius.dslist.entities.Game;
import com.devinicius.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<GameMinDTO> findAll(){
       List<Game> result = gameRepository.findAll();
       return result.stream().map(GameMinDTO::new).toList();
    }
}
