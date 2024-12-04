package org.example.models.warehouse;

import java.util.List;

public class NearestWarehouseSelectionStrategy extends WarehouseSelectionStrategy {

    @Override
    public Warehouse selectWarehouse(List<Warehouse> warehouses) {
        return warehouses.getFirst();
    }
}
