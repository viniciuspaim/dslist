package com.devinicius.dslist.controllers;

import com.devinicius.dslist.DTO.GameListDTO;
import com.devinicius.dslist.DTO.GameMinDTO;
import com.devinicius.dslist.DTO.ReplacementDTO;
import com.devinicius.dslist.services.GameListService;
import com.devinicius.dslist.services.GameService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    private final GameListService gameListService;
    private final GameService gameService;

    public GameListController(GameListService gameListService, GameService gameService) {
        this.gameListService = gameListService;
        this.gameService = gameService;
    }

    @GetMapping
    public List<GameListDTO> findAll(){
        return gameListService.findAll();
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findByList(@PathVariable Long listId){
        return gameService.findByList(listId);
    }

    @PostMapping(value = "/{listId}/replacement")
    public void move(@PathVariable Long listId, @RequestBody ReplacementDTO body){
        gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
    }
}
