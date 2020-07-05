package com.umbrella.stfctracker.Structures;

import android.util.Log;

import androidx.annotation.NonNull;

import com.umbrella.stfctracker.DataTypes.Enums.BonusType;

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

    @NonNull
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        map.forEach((key, val) -> builder.append(key).append(" -> ").append(val).append("\n"));
        return builder.toString();
    }
}
