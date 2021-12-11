package arp.service;

import arp.dto.grid.Accumulator;
import arp.dto.grid.Storage;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Data
public class Step {
    private int hour;
    private Map<Accumulator, AcumulatorState> acumulatorsStates = new HashMap<>();
    private Map<Storage, StorageState> storageStates = new HashMap<>();
    private double overflowHydrogenProduction;
    private double overflowPowerProduction;

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("[hour=" + hour + ", electorizersStates=");
        b.append(acumulatorsStates.entrySet().stream()
                .map(e -> e.getKey() + " => " + toString(e.getValue().getAccumulatorCurrentLevel()))
                .collect(Collectors.joining(", ", "{", "},")));
        b.append(storageStates.entrySet().stream()
                .map(e -> e.getKey() + " => " + toString(e.getValue().getCurrentLevel()))
                .collect(Collectors.joining(", ", "{", "},")));
        b.append("setOverflowHydrogenProduction(" + toString(overflowHydrogenProduction) + ",");
        b.append("setOverflowPowerProduction(" + toString(overflowPowerProduction) + "]");
        return b.toString();
    }

    public String toString(double value) {
        return String.format("%.2f", value);
    }
}
