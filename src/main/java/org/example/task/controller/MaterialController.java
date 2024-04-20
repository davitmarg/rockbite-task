package org.example.task.controller;

import org.example.task.facade.material.MaterialFacade;
import org.example.task.facade.material.model.MaterialRequestModel;
import org.example.task.facade.material.model.MaterialResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MaterialController {

    private final MaterialFacade materialFacade;

    @Autowired
    public MaterialController(MaterialFacade materialFacade) {
        this.materialFacade = materialFacade;
    }

    @GetMapping("/material/{id}")
    public ResponseEntity<MaterialResponseModel> getMaterial(@PathVariable Long id) {
        return ResponseEntity.ok(materialFacade.get(id));
    }

    @GetMapping("/material")
    public ResponseEntity<List<MaterialResponseModel>> getAllMaterial() {
        return ResponseEntity.ok(materialFacade.getAll());
    }

    @PostMapping("/material")
    public ResponseEntity<MaterialResponseModel> addMaterial(@RequestBody MaterialRequestModel materialRequestModel) {
        return ResponseEntity.ok(materialFacade.add(materialRequestModel));
    }

    @PutMapping("/material/{id}")
    public ResponseEntity<MaterialResponseModel> updateMaterial(
            @PathVariable Long id,
            @RequestBody MaterialRequestModel materialRequestModel) {

        return ResponseEntity.ok(materialFacade.update(id, materialRequestModel));
    }

    @DeleteMapping("/material/{id}")
    public void deleteMaterial(@PathVariable Long id) {
        materialFacade.delete(id);
    }

}
