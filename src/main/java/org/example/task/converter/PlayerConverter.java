package org.example.task.converter;

import org.springframework.stereotype.Service;
import org.example.task.facade.player.model.PlayerRequestModel;
import org.example.task.facade.player.model.PlayerResponseModel;
import org.example.task.persistence.player.Player;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerConverter {

    private final WarehouseConverter warehouseConverter;

    public PlayerConverter(WarehouseConverter warehouseConverter) {
        this.warehouseConverter = warehouseConverter;
    }

    public Player requestToPlayer(PlayerRequestModel request){
        Player player = new Player();
        player.setName(request.getName());
        player.setWarehouses(List.of());
        return player;
    }

    public PlayerResponseModel playerToResponse(Player player){
        PlayerResponseModel response = new PlayerResponseModel();
        response.setId(player.getId());
        response.setName(player.getName());
        response.setWarehouses(warehouseConverter.warehousesToResponseList(player.getWarehouses()));
        return response;
    }

    public List<PlayerResponseModel> playersToResponsList(List<Player> players){
        List<PlayerResponseModel> responseList = new ArrayList<>();
        for(Player player : players){
            responseList.add(playerToResponse(player));
        }
        return responseList;
    }

}
