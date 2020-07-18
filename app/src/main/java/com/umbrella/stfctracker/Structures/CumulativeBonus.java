package com.umbrella.stfctracker.Structures;

import android.util.Log;

import androidx.annotation.NonNull;

import com.umbrella.stfctracker.DataTypes.Enums.BonusType;
import com.umbrella.stfctracker.DataTypes.Enums.Faction;
import com.umbrella.stfctracker.DataTypes.Enums.Material;
import com.umbrella.stfctracker.DataTypes.Enums.ShipClass;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

public class CumulativeBonus {
    private static final CumulativeBonus mInstance = new CumulativeBonus();
    private Map<String, Integer> map = new HashMap<>();

    public static CumulativeBonus getInstance() {
        return mInstance;
    }

    private CumulativeBonus() {
    }

    public void init(@NonNull Map<String, Integer> map) {
        this.map = map;
    }

    public Map<String, Integer> deInit() {
        return map;
    }

    public Integer getValue(@NonNull BonusType bonusType) {
        return map.getOrDefault(bonusType.name(), 0);
    }

    public void setValue(@NonNull BonusType bonusType, Integer newValue) {
        map.put(bonusType.name(), newValue);
    }

    public long applyBonus(long baseValue, int totalBonus) {
        return new BigDecimal(baseValue).divide(new BigDecimal(Float.toString(1f + (totalBonus / 100f))), RoundingMode.HALF_DOWN).longValue();
    }

    //Uses @{long applyBonus() }
    public int applyBonus(int baseValue, int totalBonus) {
        return Long.valueOf(applyBonus(Integer.valueOf(baseValue).longValue(), totalBonus)).intValue();
    }

    public int applySpecificBonus(BonusType bonusType) {
        switch (bonusType) {
            case PARSTEEL_PRODUCTION:           return getParsteelGenerationBonus();
            case TRITANIUM_PRODUCTION:          return getTritaniumGenerationBonus();
            case DILITHIUM_PRODUCTION:          return getDilithiumGenerationBonus();
            case PARSTEEL_STORAGE:              return getParsteelGeneratorStorageBonus();
            case TRITANIUM_STORAGE:             return getTritaniumGeneratorStorageBonus();
            case DILITHIUM_STORAGE:             return getDilithiumGeneratorStorageBonus();
            case PARSTEEL_CAPACITY:             return getParsteelStorageBonus();
            case TRITANIUM_CAPACITY:            return getTritaniumStorageBonus();
            case DILITHIUM_CAPACITY:            return getDilithiumStorageBonus();
            case PARSTEEL_VAULT_PROTECTION:     return getParsteelProtectionBonus();
            case TRITANIUM_VAULT_PROTECTION:    return getTritaniumProtectionBonus();
            case DILITHIUM_VAULT_PROTECTION:    return getDilithiumProtectionBonus();
            default:                            return 0;
        }
    }

    //region [Specific getters]
    public int getBuildSpeedBonus() {
        return getValue(BonusType.BUILD_SPEED) +
                getValue(BonusType.BASE_CONSTRUCTION_SPEED_BUILDINGS);
    }

    public int getResearchSpeedBonus() {
        return getValue(BonusType.RESEARCH_SPEED) +
                getValue(BonusType.BASE_RESEARCH_SPEED) +
                getValue(BonusType.SPEED_RESEARCH);
    }

    public int getBuildingCostEfficiencyBonus() {
        return getValue(BonusType.BUILDING_COST_EFFICIENCY_RSS);
    }

    public int getResearchBaseCostEfficiencyBonus() {
        return getValue(BonusType.RESEARCH_COST_EFFICIENCY) +
                getValue(BonusType.RESEARCH_COST_EFFICIENCY_RSS);
    }

    public int getParsteelGenerationBonus() {
        return getValue(BonusType.PARSTEEL_GENERATION_SPEED) +
                getValue(BonusType.PARSTEEL_GENERATION_SPEED_II) +
                getValue(BonusType.BASE_RESOURCE_GENERATION_SPEED);
    }

    public int getTritaniumGenerationBonus() {
        return getValue(BonusType.TRITANIUM_GENERATION_SPEED) +
                getValue(BonusType.TRITANIUM_GENERATION_SPEED_II) +
                getValue(BonusType.BASE_RESOURCE_GENERATION_SPEED);
    }

    public int getDilithiumGenerationBonus() {
        return getValue(BonusType.DILITHIUM_GENERATION_SPEED) +
                getValue(BonusType.DILITHIUM_GENERATION_SPEED_II) +
                getValue(BonusType.BASE_RESOURCE_GENERATION_SPEED);
    }

    public int getParsteelStorageBonus() {
        return getValue(BonusType.PARSTEEL_STORAGE_SIZE) +
                getValue(BonusType.PARSTEEL_STORAGE_SIZE_II);
    }

    public int getTritaniumStorageBonus() {
        return getValue(BonusType.TRITANIUM_STORAGE_SIZE) +
                getValue(BonusType.TRITANIUM_STORAGE_SIZE_II);
    }

    public int getDilithiumStorageBonus() {
        return getValue(BonusType.DILITHIUM_STORAGE_SIZE) +
                getValue(BonusType.DILITHIUM_STORAGE_SIZE_II);
    }

    public int getParsteelProtectionBonus() {
        return getValue(BonusType.PARSTEEL_PROTECTION) +
                getValue(BonusType.PARSTEEL_PROTECTION_II) +
                getValue(BonusType.BASE_RESOURCE_PROTECTION);
    }

    public int getTritaniumProtectionBonus() {
        return getValue(BonusType.TRITANIUM_PROTECTION) +
                getValue(BonusType.TRITANIUM_PROTECTION_II) +
                getValue(BonusType.BASE_RESOURCE_PROTECTION);
    }

    public int getDilithiumProtectionBonus() {
        return getValue(BonusType.DILITHIUM_PROTECTION) +
                getValue(BonusType.DILITHIUM_PROTECTION_II) +
                getValue(BonusType.BASE_RESOURCE_PROTECTION);
    }

    public int getParsteelGeneratorStorageBonus() {
        return getValue(BonusType.PARSTEEL_GENERATOR_STORAGE);
    }

    public int getTritaniumGeneratorStorageBonus() {
        return getValue(BonusType.TRITANIUM_GENERATOR_STORAGE);
    }

    public int getDilithiumGeneratorStorageBonus() {
        return getValue(BonusType.DILITHIUM_GENERATOR_STORAGE);
    }
    //endregion

    //region [Ship buffers]
    public int getShipConstructionSpeedBonus() {
        return getValue(BonusType.SHIP_CONSTRUCTION_SPEED_BUILDING) +
                getValue(BonusType.SHIP_CONSTRUCTION_SPEED_RESEARCH);
    }

    public int getShipTierUpBonus() {
        return getValue(BonusType.TIER_UP_SPEED) +
                getValue(BonusType.SPEED_TIER_UP);
    }

    public int getShipScrapSpeedBonus() {
        return getValue(BonusType.SHIP_SCRAPPING_SPEED);
    }

    public int getShipRepairSpeedBonus(Faction faction, ShipClass shipClass) {
        int temp = 0;

        temp += getValue(BonusType.BASE_REPAIR_SPEED) + getValue(BonusType.REPAIR_SPEED) + getValue(BonusType.SHIP_REPAIR_SPEED);

        switch (faction) {
            case FEDERATION: temp += getValue(BonusType.FEDERATION_REPAIR_SPEED);
                break;
            case KLINGON: temp += getValue(BonusType.KLINGON_REPAIR_SPEED);
                break;
            case ROMULAN: temp += getValue(BonusType.ROMULAN_REPAIR_SPEED);
                break;
        }

        switch (shipClass) {
            case BATTLESHIP: temp += getValue(BonusType.REPAIR_SPEED_BATTLESHIPS);
                break;
            case EXPLORER: temp += getValue(BonusType.REPAIR_SPEED_EXPLORERS);
                break;
            case INTERCEPTOR: temp += getValue(BonusType.REPAIR_SPEED_INTERCEPTORS);
                break;
            case SURVEY: temp += getValue(BonusType.SURVEY_REPAIR_SPEED);
                break;
        }

        return temp;
    }

    public int getShipRepairCostEfficiencyBonus(Faction faction, ShipClass shipClass) {
        int temp = 0;

        temp += getValue(BonusType.BASE_REPAIR_COST_EFFICIENCY) + getValue(BonusType.REPAIR_COST_EFFICIENCY);

        switch (faction) {
            case FEDERATION: temp += getValue(BonusType.FEDERATION_COST_EFFICIENCY_REPAIR);
                break;
            case KLINGON: temp += getValue(BonusType.KLINGON_COST_EFFICIENCY_REPAIR);
                break;
            case ROMULAN: temp+= getValue(BonusType.ROMULAN_COST_EFFICIENCY_REPAIR);
                break;
        }

        if (shipClass.equals(ShipClass.SURVEY)) temp += getValue(BonusType.SURVEY_REPAIR_COST_EFFICIENCY);

        return temp;
    }

    public int getShipCostEfficiencyBonus(Faction faction, Material material) {
        int temp = 0;

        switch (faction) {
            case FEDERATION: temp += getValue(BonusType.FEDERATION_COST_EFFICIENCY_RSS);
                break;
            case KLINGON: temp += getValue(BonusType.KLINGON_COST_EFFICIENCY_RSS);
                break;
            case ROMULAN: temp += getValue(BonusType.ROMULAN_COST_EFFICIENCY_RSS);
                break;
        }

        switch (material) {
            case TRITANIUM: temp += getValue(BonusType.TRITANIUM_COST_EFFICIENCY_COMPONENTS);
                break;
            case DILITHIUM: temp += getValue(BonusType.DILITHIUM_COST_EFFICIENCY_COMPONENTS);
                break;
        }

        return temp;
    }

    public int getShipMaterialCostEfficiencyBonus(Faction faction, Material material) {
        int temp = 0;

        switch (material) {
            case GAS:
                temp += getValue(BonusType.COST_EFFICIENCY_GAS);
                if (faction.equals(Faction.FEDERATION)) temp += getValue(BonusType.COST_EFFICIENCY_GAS_FEDERATION);
                break;
            case ORE:
                temp += getValue(BonusType.COST_EFFICIENCY_ORE);
                if (faction.equals(Faction.ROMULAN)) temp += getValue(BonusType.COST_EFFICIENCY_ORE_ROMULANS);
                break;
            case CRYSTAL:
                temp += getValue(BonusType.COST_EFFICIENCY_CRYSTAL);
                if (faction.equals(Faction.KLINGON)) temp += getValue(BonusType.COST_EFFICIENCY_CRYSTAL_KLINGONS);
                break;
        }

        return temp;
    }

    public int getShipPartsCostEfficiencyBonus(ShipClass shipClass) {
        switch (shipClass) {
            case BATTLESHIP: return getValue(BonusType.COST_EFFICIENCY_PARTS_BATTLESHIPS);
            case EXPLORER: return getValue(BonusType.COST_EFFICIENCY_PARTS_EXPLORERS);
            case INTERCEPTOR: return getValue(BonusType.COST_EFFICIENCY_PARTS_INTERCEPTORS);
            default: return 0;
        }
    }

    public int getShipWarpRangeBonus() {
        return getValue(BonusType.WARP_RANGE);
    }

    public int getShipWarpSpeedBonus(ShipClass shipClass) {
        int temp = 0;

        temp += getValue(BonusType.WARP_SPEED);

        switch (shipClass) {
            case BATTLESHIP: temp += getValue(BonusType.WARP_SPEED_BATTLESHIPS);
                break;
            case EXPLORER: temp += getValue(BonusType.WARP_SPEED_EXPLORERS);
                break;
            case INTERCEPTOR: temp += getValue(BonusType.WARP_SPEED_INTERCEPTORS);
                break;
            case SURVEY: temp += getValue(BonusType.WARP_SPEED_SURVEYS);
                break;
        }

        return temp;
    }

    public int getProtectedCargoBonus(ShipClass shipClass) {
        if (shipClass.equals(ShipClass.SURVEY)) {
            return getValue(BonusType.PROTECTED_CARGO_SURVEYS);
        } else return 0;
    }
    //endregion

    @NonNull
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        map.forEach((key, val) -> builder.append(key).append(" -> ").append(val).append("\n"));
        return builder.toString();
    }
}
