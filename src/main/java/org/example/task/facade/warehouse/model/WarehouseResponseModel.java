package org.example.task.facade.warehouse.model;
import org.example.task.facade.material.model.MaterialResponseModel;

import java.util.Map;

public class WarehouseResponseModel {
    private Long id;
    private Map<MaterialResponseModel, Integer> materialContainer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Map<MaterialResponseModel, Integer> getMaterialContainer() {
        return materialContainer;
    }

    public void setMaterialContainer(Map<MaterialResponseModel, Integer> materialContainer) {
        this.materialContainer = materialContainer;
    }
}
