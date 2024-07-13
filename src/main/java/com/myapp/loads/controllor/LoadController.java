package com.myapp.loads.controllor;
import com.myapp.loads.entity.Load;
import com.myapp.loads.service.LoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/load")
public class LoadController {

    @Autowired
    private LoadService loadService;

    @PostMapping
    public ResponseEntity<String> createLoad(@RequestBody Load load) {
        loadService.saveLoad(load);
        return ResponseEntity.ok("Load details added successfully");
    }

    @GetMapping("/allLoads")
    public ResponseEntity<List<Load>> allLoads() {
        List<Load> loads = loadService.getAllLoads();
        return ResponseEntity.ok(loads);
    }

    @GetMapping
    public ResponseEntity<List<Load>> getLoadsByShipperId(@RequestParam UUID shipperId) {
        List<Load> loads = loadService.getLoadsByShipperId(shipperId);
        return ResponseEntity.ok(loads);
    }

    @GetMapping("/{loadId}")
    public ResponseEntity<Load> getLoadById(@PathVariable UUID loadId) {
        Optional<Load> load = loadService.getLoadById(loadId);
        return load.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{loadId}")
    public ResponseEntity<Load> updateLoad(@PathVariable UUID loadId, @RequestBody Load loadDetails) {
        Optional<Load> loadOptional = loadService.getLoadById(loadId);
        if (loadOptional.isPresent()) {
            Load load = loadOptional.get();
            load.setLoadingPoint(loadDetails.getLoadingPoint());
            load.setUnloadingPoint(loadDetails.getUnloadingPoint());
            load.setProductType(loadDetails.getProductType());
            load.setTruckType(loadDetails.getTruckType());
            load.setNoOfTrucks(loadDetails.getNoOfTrucks());
            load.setWeight(loadDetails.getWeight());
            load.setComment(loadDetails.getComment());
            load.setDate(loadDetails.getDate());
            Load updatedLoad = loadService.saveLoad(load);
            return ResponseEntity.ok(updatedLoad);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{loadId}")
    public ResponseEntity<Void> deleteLoad(@PathVariable UUID loadId) {
        loadService.deleteLoadById(loadId);
        return ResponseEntity.noContent().build();
    }
}

