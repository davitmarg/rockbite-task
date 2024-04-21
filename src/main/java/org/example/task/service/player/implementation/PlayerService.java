package org.example.task.service.player.implementation;

import org.example.task.persistence.player.Player;
import org.example.task.persistence.player.PlayerRepository;
import org.example.task.service.player.PlayerServiceInterface;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PlayerService implements PlayerServiceInterface {

    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    @Transactional
    public Player getPlayer(Long id) {
        return playerRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public List<Player> getPlayers() {
        return playerRepository.findAll();
    }

    @Override
    @Transactional
    public Player addPlayer(Player player) {
        return playerRepository.save(player);
    }

    @Override
    @Transactional
    public Player updatePlayer(Long id, Player player) {
        Player playerById = playerRepository.findById(id).orElse(null);
        if (playerById != null) {
            playerById.setName(player.getName());
            return playerRepository.save(playerById);
        }
        return null;
    }

    @Override
    @Transactional
    public void deletePlayer(Long id) {
        playerRepository.deleteById(id);
    }
}
