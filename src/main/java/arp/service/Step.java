package arp.service;

import arp.dto.Electrolyzer;
import arp.dto.Storage;

import java.util.Map;

public class Step {
    public int hour;
    public Map<Electrolyzer, ElectrolyzerState> electorizersStates;
    public Map<Storage, StorageState> storageStates;
}