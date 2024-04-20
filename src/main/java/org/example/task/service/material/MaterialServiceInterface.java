package org.example.task.service.material;

import org.example.task.persistence.materials.Material;

import java.util.List;

public interface MaterialServiceInterface {
    Material getMaterial(Long id);
    List<Material> getAllMaterials();
    Material addMaterial(Material material);
    Material updateMaterial(Long id, Material material);
    void deleteMaterial(Long id);
}
