package org.example.task.service.warehouse_management;

import org.example.task.persistence.player.Player;
import org.example.task.persistence.warehouse.Warehouse;

public interface WarehouseManagementServiceInterface {

     public Player addWarehosueToPlayer(Long playerId);

    public Warehouse addMaterial(Long warehouseId, Long materialId, Integer quantity);

    public Warehouse subtractMaterial(Long warehouseId, Long materialId, Integer quantity);

    public Warehouse moveMaterial(Long sourceWarehouseId, Long destinationWarehouseId,
                                  Long materialId, Integer quantity);

    public Warehouse moveAllMaterial(Long sourceWarehouseId, Long destinationWarehouseId, Long materialId);

}
