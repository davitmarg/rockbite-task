package org.example.task.service.player;

import org.example.task.persistence.player.Player;

import java.util.List;

public interface PlayerServiceInterface {
    Player getPlayer(Long id);
    List<Player> getPlayers();
    Player addPlayer(Player player);
    Player updatePlayer(Long id, Player player);
    void deletePlayer(Long id);
}
