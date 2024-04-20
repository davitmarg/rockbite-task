package org.example.task.controller;

import org.example.task.facade.player.PlayerFacade;
import org.example.task.facade.player.model.PlayerRequestModel;
import org.example.task.facade.player.model.PlayerResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlayerController {

    private final PlayerFacade playerFacade;

    @Autowired
    public PlayerController(PlayerFacade playerFacade) {
        this.playerFacade = playerFacade;
    }

    @GetMapping("/player/{id}")
    public ResponseEntity<PlayerResponseModel> getPlayer(@PathVariable Long id) {
        return ResponseEntity.ok(playerFacade.getPlayer(id));
    }

    @GetMapping("/players")
    public ResponseEntity<List<PlayerResponseModel>> getPlayers() {
        return ResponseEntity.ok(playerFacade.getAllPlayers());
    }

    @PostMapping("/player")
    public ResponseEntity<PlayerResponseModel> addPlayer(@RequestBody PlayerRequestModel playerRequestModel) {
        return ResponseEntity.ok(playerFacade.addPlayer(playerRequestModel));
    }

    @PutMapping("/player/{id}")
    public ResponseEntity<PlayerResponseModel> updatePlayer(@PathVariable Long id,
                                                            @RequestBody PlayerRequestModel player) {
        return ResponseEntity.ok(playerFacade.updatePlayer(id, player));
    }

    @DeleteMapping("/player/{id}")
    public void deletePlayer(@PathVariable Long id) {
        playerFacade.deletePlayer(id);
    }
}
