package com.umbrella.stfctracker.Structures;

import android.util.Log;

import androidx.annotation.NonNull;

import com.umbrella.stfctracker.DataTypes.Enums.BonusType;
import com.umbrella.stfctracker.DataTypes.Enums.Faction;
import com.umbrella.stfctracker.DataTypes.Enums.Grade;
import com.umbrella.stfctracker.DataTypes.Enums.Material;
import com.umbrella.stfctracker.DataTypes.Enums.Rarity;
import com.umbrella.stfctracker.DataTypes.Enums.ShipClass;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

// Check if CumulativeBonus is a percentage or a value. (Extra)
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
        DataSaver.getInstance().saveData(bonusType.name(), newValue);
    }

    public long applyBonus(long baseValue, int totalBonus) {
        return new BigDecimal(baseValue).divide(new BigDecimal(Float.toString(1f + (totalBonus / 100f))), RoundingMode.HALF_DOWN).longValue();
    }

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

    public int getBuildingCostEfficiencyBonus(Material material) {
        switch (material) {
            case PARSTEEL:
            case TRITANIUM:
            case DILITHIUM: return getValue(BonusType.BUILDING_COST_EFFICIENCY_RSS);
            case GAS:       return getValue(BonusType.OUTLAW_COST_EFFICIENCY_STATION_GAS);
            case ORE:       return getValue(BonusType.OUTLAW_COST_EFFICIENCY_STATION_ORE);
            case CRYSTAL:   return getValue(BonusType.OUTLAW_COST_EFFICIENCY_STATION_CRYSTAL);
            default:        return 0;
        }
    }

    public int getResearchBaseCostEfficiencyBonus(Material material) {
        switch (material) {
            case PARSTEEL:
            case TRITANIUM:
            case DILITHIUM: return getValue(BonusType.RESEARCH_COST_EFFICIENCY) + getValue(BonusType.RESEARCH_COST_EFFICIENCY_RSS);
            case GAS:       return getValue(BonusType.OUTLAW_COST_EFFICIENCY_RESEARCH_GAS);
            case ORE:       return getValue(BonusType.OUTLAW_COST_EFFICIENCY_RESEARCH_ORE);
            case CRYSTAL:   return getValue(BonusType.OUTLAW_COST_EFFICIENCY_RESEARCH_CRYSTAL);
            default:        return 0;
        }
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
        return getValue(BonusType.SHIP_SCRAPPING_SPEED) + getValue(BonusType.OUTLAW_SCRAP_SPEED);
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

    public int getShipRepairCostEfficiencyBonus(Faction faction, ShipClass shipClass, Grade grade) {
        int temp = 0;

        temp += getValue(BonusType.BASE_REPAIR_COST_EFFICIENCY) +
                getValue(BonusType.REPAIR_COST_EFFICIENCY) +
                getValue(BonusType.OUTLAW_SHIP_REPAIR_COST_EFFICIENCY);

        switch (faction) {
            case FEDERATION: temp += getValue(BonusType.FEDERATION_COST_EFFICIENCY_REPAIR);
                break;
            case KLINGON: temp += getValue(BonusType.KLINGON_COST_EFFICIENCY_REPAIR);
                break;
            case ROMULAN: temp+= getValue(BonusType.ROMULAN_COST_EFFICIENCY_REPAIR);
                break;
        }

        if (shipClass.equals(ShipClass.SURVEY)) temp += getValue(BonusType.SURVEY_REPAIR_COST_EFFICIENCY);

        if (grade.equals(Grade.FOUR)) temp += getValue(BonusType.OUTLAW_SHIP_REPAIR_COST_EFFICIENCY_G4_SHIPS);

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
            case TRITANIUM: temp += getValue(BonusType.TRITANIUM_COST_EFFICIENCY_COMPONENTS) + getValue(BonusType.OUTLAW_COST_EFFICIENCY_SHIP_TRITANIUM);
                break;
            case DILITHIUM: temp += getValue(BonusType.DILITHIUM_COST_EFFICIENCY_COMPONENTS) + getValue(BonusType.OUTLAW_COST_EFFICIENCY_SHIP_DILITHIUM);
                break;
        }

        return temp;
    }

    public int getShipMaterialCostEfficiencyBonus(Faction faction, Material material) {
        int temp = 0;

        //Add when adding plutonium (optional): OUTLAW_COMMON_PLUTONIUM_COST_EFFICIENCY, OUTLAW_UNCOMMON_PLUTONIUM_COST_EFFICIENCY, OUTLAW_RARE_PLUTONIUM_COST_EFFICIENCY
        //Add when adding special materials for the Stella (optional): OUTLAW_COST_EFFICIENCY_UNIQUE_MATERIALS_STELLA

        switch (material) {
            case GAS:
                temp += getValue(BonusType.COST_EFFICIENCY_GAS) + getValue(BonusType.OUTLAW_COST_EFFICIENCY_SHIP_MATERIALS);
                if (faction.equals(Faction.FEDERATION)) temp += getValue(BonusType.COST_EFFICIENCY_GAS_FEDERATION);
                break;
            case ORE:
                temp += getValue(BonusType.COST_EFFICIENCY_ORE) + getValue(BonusType.OUTLAW_COST_EFFICIENCY_SHIP_MATERIALS);
                if (faction.equals(Faction.ROMULAN)) temp += getValue(BonusType.COST_EFFICIENCY_ORE_ROMULANS);
                break;
            case CRYSTAL:
                temp += getValue(BonusType.COST_EFFICIENCY_CRYSTAL) + getValue(BonusType.OUTLAW_COST_EFFICIENCY_SHIP_MATERIALS);
                if (faction.equals(Faction.KLINGON)) temp += getValue(BonusType.COST_EFFICIENCY_CRYSTAL_KLINGONS);
                break;
            case EXPLORER_PARTS:
                temp += getValue(BonusType.OUTLAW_COST_EFFICIENCY_EXPLORER_PARTS) + getValue(BonusType.COST_EFFICIENCY_PARTS_EXPLORERS);
                break;
            case BATTLESHIP_PARTS:
                temp += getValue(BonusType.OUTLAW_COST_EFFICIENCY_BATTLESHIP_PARTS) + getValue(BonusType.COST_EFFICIENCY_PARTS_BATTLESHIPS);
                break;
            case INTERCEPTOR_PARTS:
                temp += getValue(BonusType.OUTLAW_COST_EFFICIENCY_INTERCEPTOR_PARTS) + getValue(BonusType.COST_EFFICIENCY_PARTS_INTERCEPTORS);
                break;
            case SURVEY_PARTS:
                break;
        }

        return temp;
    }

    public int getShipWarpRangeBonus() {
        return getValue(BonusType.WARP_RANGE);
    }

    public int getShipWarpSpeedBonus(String name, ShipClass shipClass, boolean isEmpty) {
        int temp = 0;

        temp += getValue(BonusType.WARP_SPEED) + getValue(BonusType.OUTLAW_WARP_SPEED) + getValue(BonusType.OUTLAW_WARP_SPEED_II);

        switch (name) {
            case "Botany Bay": temp += getValue(BonusType.OUTLAW_WARP_SPEED_BOTANY_BAY);
                break;
            case "Stella": temp += getValue(BonusType.OUTLAW_WARP_SPEED_STELLA);
                break;
        }

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

        if (isEmpty) temp += getValue(BonusType.OUTLAW_WARP_SPEED_EMPTY);

        return temp;
    }

    public int getShipImpulseSpeedBonus(String name, Grade grade) {
        int temp = 0;

        if (name.equals("Botany Bay")) temp += getValue(BonusType.OUTLAW_IMPULSE_SPEED_BOTANY_BAY);

        if (grade.equals(Grade.FOUR)) temp += getValue(BonusType.OUTLAW_IMPULSE_SPEED_G4_SHIPS);

        return temp;
    }

    public int getProtectedCargoBonus(String name, ShipClass shipClass) {
        int temp = 0;

        if (name.equals("Botany Bay")) temp += getValue(BonusType.OUTLAW_PROTECTED_CARGO_BOTANY_BAY);
        if (shipClass.equals(ShipClass.SURVEY)) temp += getValue(BonusType.PROTECTED_CARGO_SURVEYS);

        return temp;
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
