package org.example.task.facade.player.model;
import org.example.task.facade.warehouse.model.WarehouseResponseModel;
import org.example.task.persistence.warehouse.Warehouse;

import java.util.List;

public class PlayerResponseModel {
    private Long id;
    private String name;
    private List<WarehouseResponseModel> warehouses;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<WarehouseResponseModel> getWarehouses() {
        return warehouses;
    }

    public void setWarehouses(List<WarehouseResponseModel> warehouses) {
        this.warehouses = warehouses;
    }
}
