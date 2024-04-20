package org.example.task.persistence.warehouse;
import jakarta.persistence.*;
import org.example.task.persistence.materials.Material;
import org.example.task.persistence.player.Player;

import java.util.HashMap;
import java.util.Map;

@Entity
public class Warehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection
    private Map<Material, Integer> materialContainer = new HashMap<>();

    public Long getId() {
        return id;
    }

    public Map<Material, Integer> getMaterialContainer() {
        return materialContainer;
    }

    public void setMaterialContainer(Map<Material, Integer> materialContainer) {
        this.materialContainer = materialContainer;
    }

    @Override
    public String toString(){
        StringBuilder s = new StringBuilder("Warehouse " + id + ":\n");
        for(Material i: materialContainer.keySet()){
            s.append(i).append("/").append(materialContainer.get(i));
        }
        return s.toString();
    }

}
