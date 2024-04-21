package org.example.task.facade.warehouse.model;
import org.example.task.facade.material.model.MaterialResponseModel;
import org.example.task.persistence.materials.Material;

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

    @Override
    public String toString(){
        StringBuilder s = new StringBuilder("Warehouse " + id + ":\n");
        for(MaterialResponseModel i: materialContainer.keySet()){
            s.append(i).append("/").append(materialContainer.get(i));
        }
        return s.toString();
    }
}
