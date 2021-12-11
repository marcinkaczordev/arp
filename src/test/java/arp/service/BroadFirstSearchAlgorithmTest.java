package arp.service;

import arp.dto.GridConstants;
import arp.search.BroadFirstSearchAlgorithm;
import arp.search.State;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

import static arp.service.Utils.createTableOfValue;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BroadFirstSearchAlgorithmTest {

    @Test
    public void shouldAddPv() {
        // given
        double consumption = 1.0;

        GridConstants gridConstants = createGridConstants();
        gridConstants.pvCost = 2.0d;
        gridConstants.windCost = 3.0d;
        gridConstants.storagePowerCost = 10.0d;
        gridConstants.electrolizerCost = 5.0d;
        gridConstants.storageHydrogenCost = 10.0d;

        Storage storage = new Storage();
        storage.maxCapacity = 0.0;

        Data data = new Data();
        data.gridConstants = gridConstants;
        data.summaryStorage = storage;
        data.vehiclesConsumption = createTableOfValue(consumption);

        // when
        double cost = calculate(data);

        // then
        double expectedCost = 7.0d;
        assertEquals(expectedCost, cost);
    }

    private double calculate(Data data) {
        BroadFirstSearchAlgorithm broadFirstSearchAlgorithm = new BroadFirstSearchAlgorithm(data);
        State state  = broadFirstSearchAlgorithm.calculate();
        System.out.println(state);
        return state.totalCost;
    }

    private GridConstants createGridConstants() {
        GridConstants gridConstants = new GridConstants();
        gridConstants.hydrogenTransportLoss = 0.d;
        gridConstants.storageLoss = 0.d;
        gridConstants.transmissionLoss = 0.d;
        gridConstants.pvDailyProduction = createTableOfValue(1.0);
        gridConstants.windDailyProduction = createTableOfValue(1.0);
        gridConstants.electrolizerEfficiency = 1.0;
        return gridConstants;
    }
}