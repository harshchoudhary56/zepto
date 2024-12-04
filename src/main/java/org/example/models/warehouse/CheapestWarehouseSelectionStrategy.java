package org.example.models.warehouse;

import java.util.List;

public class CheapestWarehouseSelectionStrategy extends WarehouseSelectionStrategy {


    @Override
    public Warehouse selectWarehouse(List<Warehouse> warehouses) {
        return warehouses.getFirst();
    }
}
