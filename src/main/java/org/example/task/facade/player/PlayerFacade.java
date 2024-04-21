package org.example.task.facade.player;

import org.example.task.converter.PlayerConverter;
import org.example.task.facade.player.model.PlayerRequestModel;
import org.example.task.facade.player.model.PlayerResponseModel;
import org.example.task.persistence.player.Player;
import org.example.task.service.player.PlayerServiceInterface;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PlayerFacade {
    private final PlayerServiceInterface playerService;
    private final PlayerConverter playerConverter;

    public PlayerFacade(PlayerServiceInterface playerService, PlayerConverter playerConverter) {
        this.playerService = playerService;
        this.playerConverter = playerConverter;
    }

    public PlayerResponseModel getPlayer(Long id) {
        Player player = playerService.getPlayer(id);
        return playerConverter.playerToResponse(player);
    }

    public List<PlayerResponseModel> getAllPlayers() {
        List<Player> players = playerService.getPlayers();
        return playerConverter.playersToResponsList(players);
    }

    public PlayerResponseModel addPlayer(PlayerRequestModel request) {
        Player player = playerConverter.requestToPlayer(request);
        Player addedPlayer = playerService.addPlayer(player);
        return playerConverter.playerToResponse(addedPlayer);
    }

    public PlayerResponseModel updatePlayer(Long id, PlayerRequestModel request) {
        Player player = playerConverter.requestToPlayer(request);
        Player updatedPlayer = playerService.updatePlayer(id, player);
        return playerConverter.playerToResponse(updatedPlayer);
    }

    public void deletePlayer(Long id) {
        playerService.deletePlayer(id);
    }

}
