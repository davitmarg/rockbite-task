package org.example.task.service.player.implementation;

import org.example.task.persistence.player.Player;
import org.example.task.persistence.player.PlayerRepository;
import org.example.task.service.player.PlayerServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService implements PlayerServiceInterface {

    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public Player getPlayer(Long id) {
        return playerRepository.findById(id).orElse(null);
    }

    @Override
    public List<Player> getPlayers() {
        return playerRepository.findAll();
    }

    @Override
    public Player addPlayer(Player player) {
        return playerRepository.save(player);
    }

    @Override
    public Player updatePlayer(Long id, Player player) {
        Player playerById = playerRepository.findById(id).orElse(null);
        if (playerById != null) {
            playerById.setName(player.getName());
            return playerRepository.save(playerById);
        }
        return null;
    }

    @Override
    public void deletePlayer(Long id) {
        playerRepository.deleteById(id);
    }
}
