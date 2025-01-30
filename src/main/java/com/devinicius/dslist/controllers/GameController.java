package com.devinicius.dslist.controllers;

import com.devinicius.dslist.DTO.GameDTO;
import com.devinicius.dslist.DTO.GameMinDTO;
import com.devinicius.dslist.services.GameService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping(value = "/{id}")
    public GameDTO findById(@PathVariable Long id) {
        return gameService.findById(id);
    }

    @GetMapping
    public List<GameMinDTO> findAll() {
        return gameService.findAll();
    }
}
