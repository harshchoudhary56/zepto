package org.example.controller;

import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.models.warehouse.Warehouse;
import org.example.models.warehouse.WarehouseSelectionStrategy;

@Data
@AllArgsConstructor
public class WarehouseController {

    private List<Warehouse> warehouses;
    private WarehouseSelectionStrategy warehouseSelectionStrategy;

    public boolean addWarehouse(Warehouse warehouse) throws Exception {
        if (warehouses.stream().noneMatch(w -> w.getId() == warehouse.getId())) {
            warehouses.add(warehouse);
            return true;
        } else {
            throw new Exception();
        }
    }

    public boolean deleteWarehouse(int warehouseId) throws Exception {
        Optional<Warehouse> warehouseToBeDeleted = warehouses.stream().filter(w -> w.getId() == warehouseId).findFirst();
        if (warehouseToBeDeleted.isPresent()) {
            warehouses.remove(warehouseToBeDeleted.get());
            return true;
        } else {
            throw new Exception();
        }
    }

    public Warehouse selectWarehouse(WarehouseSelectionStrategy warehouseSelectionStrategy) {
        this.warehouseSelectionStrategy = warehouseSelectionStrategy;
        return this.warehouseSelectionStrategy.selectWarehouse(warehouses);
    }
}
