package com.umbrella.stfctracker.Database.Data;

import android.content.res.Resources;

import com.umbrella.stfctracker.R;
import com.umbrella.stfctracker.DataTypes.Enums.Grade;
import com.umbrella.stfctracker.DataTypes.Enums.Material;
import com.umbrella.stfctracker.DataTypes.Enums.Rarity;
import com.umbrella.stfctracker.DataTypes.Enums.ShipClass;
import com.umbrella.stfctracker.DataTypes.ResourceMaterial;
import com.umbrella.stfctracker.Database.Entities.Ship;
import com.umbrella.stfctracker.Database.Entities.Tier;
import com.umbrella.stfctracker.Database.Entities.Tier.Component;
import com.umbrella.stfctracker.Database.Entities.Tier.Component.ComponentName;
import com.umbrella.stfctracker.Database.Entities.Tier.Level;
import com.umbrella.stfctracker.Database.Entities.Tier.Level.Scrap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// FIXME: Realta: RequiredOps + RequiredOpsScrap
// FIXME: Realta + EcsFortunate --> level 20 requiredXP not available?

public final class DataShips extends DataFunctions {
    private static DataShips mInstance;

    private List<Ship> ships = new ArrayList<>();

    private Resources db;

    public static DataShips getInstance(Resources db) {
        if (mInstance == null) {
            mInstance = new DataShips(db);
        }
        return mInstance;
    }

    public DataShips(Resources db) {
        this.db = db;
        initData();
    }

    public List<Ship> getShips() {
        return ships;
    }

    private String img(int id) {
        return db.getResourceEntryName(id);
    }

    // TODO: set base strength of ships
    private void initData() {
        ships.addAll(Arrays.asList(
                getOrionCorvette(),
                getTalla()
        ));
    }

    private Ship getOrionCorvette() {
        return new Ship(
                "Orion Corvette",
                Rarity.COMMON,
                Grade.ONE,
                ShipClass.BATTLESHIP,
                img(R.drawable.orion_corvette),
                0,
                "Enhanced Hull",
                5,
                20,
                addTiers(
                        new Tier(1, 3000, 360,
                                addShipLevels(
                                        new Level(1, 0, 10,
                                                new Scrap(8100, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 360L)
                                                ))
                                        ),
                                        new Level(2, 4, 15,
                                                new Scrap(8100, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 360L),
                                                        new ResourceMaterial(2, Material.SHIP_XP, 1L)
                                                ))
                                        ),
                                        new Level(3, 6, 20,
                                                new Scrap(8100, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 360L),
                                                        new ResourceMaterial(2, Material.SHIP_XP, 3L)
                                                ))
                                        ),
                                        new Level(4, 8, 25,
                                                new Scrap(8100, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 360L),
                                                        new ResourceMaterial(2, Material.SHIP_XP, 5L)
                                                ))
                                        ),
                                        new Level(5, 12, 30,
                                                new Scrap(8100, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 360L),
                                                        new ResourceMaterial(2, Material.SHIP_XP, 9L)
                                                ))
                                        )
                                ),
                                addComponents(
                                        new Component(1, ComponentName.BUILD_SHIP_TOTAL)
                                )
                        ),
                        new Tier(2, 1200, 420,
                                addShipLevels(
                                        new Level(6, 16, 35,
                                                new Scrap(10_800, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 730L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.COMMON, Grade.TWO, 1L),
                                                        new ResourceMaterial(3, Material.ORE, Rarity.COMMON, Grade.TWO, 1L),
                                                        new ResourceMaterial(4, Material.SHIP_XP, 12L),
                                                        new ResourceMaterial(5, Material.BATTLESHIP_PARTS, Grade.TWO, 1L)
                                                ))
                                        ),
                                        new Level(7, 22, 40,
                                                new Scrap(10_800, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 730L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.COMMON, Grade.TWO, 1L),
                                                        new ResourceMaterial(3, Material.ORE, Rarity.COMMON, Grade.TWO, 1L),
                                                        new ResourceMaterial(4, Material.SHIP_XP, 17L),
                                                        new ResourceMaterial(5, Material.BATTLESHIP_PARTS, Grade.TWO, 1L)
                                                ))
                                        ),
                                        new Level(8, 40, 45,
                                                new Scrap(10_800, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 730L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.COMMON, Grade.TWO, 1L),
                                                        new ResourceMaterial(3, Material.ORE, Rarity.COMMON, Grade.TWO, 1L),
                                                        new ResourceMaterial(4, Material.SHIP_XP, 27L),
                                                        new ResourceMaterial(5, Material.BATTLESHIP_PARTS, Grade.TWO, 1L)
                                                ))
                                        ),
                                        new Level(9, 45, 50,
                                                new Scrap(10_800, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 730L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.COMMON, Grade.TWO, 1L),
                                                        new ResourceMaterial(3, Material.ORE, Rarity.COMMON, Grade.TWO, 1L),
                                                        new ResourceMaterial(4, Material.SHIP_XP, 38L),
                                                        new ResourceMaterial(5, Material.BATTLESHIP_PARTS, Grade.TWO, 1L)
                                                ))
                                        ),
                                        new Level(10, 80, 55,
                                                new Scrap(10_800, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 730L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.COMMON, Grade.TWO, 1L),
                                                        new ResourceMaterial(3, Material.ORE, Rarity.COMMON, Grade.TWO, 1L),
                                                        new ResourceMaterial(4, Material.SHIP_XP, 58L),
                                                        new ResourceMaterial(5, Material.BATTLESHIP_PARTS, Grade.TWO, 1L)
                                                ))
                                        )
                                ),
                                addComponents(
                                        new Component(1, ComponentName.WARP_ENGINES,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 2L)
                                                ),
                                                setEmpty(),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.BATTLESHIP_PARTS, Grade.ONE, 1L)
                                                )
                                        ),
                                        new Component(2, ComponentName.TRITANIUM_ARMOR,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 6L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 275L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.BATTLESHIP_PARTS, Grade.ONE, 2L)
                                                )
                                        ),
                                        new Component(3, ComponentName.PHASER_CANNON,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 6L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 325L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.BATTLESHIP_PARTS, Grade.ONE, 3L)
                                                )
                                        ),
                                        new Component(4, ComponentName.PHASER_CANNON,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 6L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 325L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.BATTLESHIP_PARTS, Grade.ONE, 3L)
                                                )
                                        )
                                )
                        ),
                        new Tier(3, 2400, 540,
                                addShipLevels(
                                        new Level(11, 90, 60,
                                                new Scrap(13_500, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 1979L),
                                                        new ResourceMaterial(2, Material.ORE, Rarity.COMMON, Grade.TWO, 1L),
                                                        new ResourceMaterial(3, Material.ORE, Rarity.UNCOMMON, Grade.TWO, 1L),
                                                        new ResourceMaterial(4, Material.CRYSTAL, Rarity.COMMON, Grade.TWO, 1L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.UNCOMMON, Grade.TWO, 1L),
                                                        new ResourceMaterial(6, Material.SHIP_XP, 73L),
                                                        new ResourceMaterial(7, Material.BATTLESHIP_PARTS, Grade.TWO, 1L)
                                                ))
                                        ),
                                        new Level(12, 140, 65,
                                                new Scrap(13_500, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 1979L),
                                                        new ResourceMaterial(2, Material.ORE, Rarity.COMMON, Grade.TWO, 2L),
                                                        new ResourceMaterial(3, Material.ORE, Rarity.UNCOMMON, Grade.TWO, 1L),
                                                        new ResourceMaterial(4, Material.CRYSTAL, Rarity.COMMON, Grade.TWO, 1L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.UNCOMMON, Grade.TWO, 1L),
                                                        new ResourceMaterial(6, Material.SHIP_XP, 104L),
                                                        new ResourceMaterial(7, Material.BATTLESHIP_PARTS, Grade.TWO, 1L)
                                                ))
                                        ),
                                        new Level(13, 150, 70,
                                                new Scrap(13_500, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 1979L),
                                                        new ResourceMaterial(2, Material.ORE, Rarity.COMMON, Grade.TWO, 2L),
                                                        new ResourceMaterial(3, Material.ORE, Rarity.UNCOMMON, Grade.TWO, 1L),
                                                        new ResourceMaterial(4, Material.CRYSTAL, Rarity.COMMON, Grade.TWO, 1L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.UNCOMMON, Grade.TWO, 1L),
                                                        new ResourceMaterial(6, Material.SHIP_XP, 138L),
                                                        new ResourceMaterial(7, Material.BATTLESHIP_PARTS, Grade.TWO, 2L)
                                                ))
                                        ),
                                        new Level(14, 230, 75,
                                                new Scrap(13_500, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 1979L),
                                                        new ResourceMaterial(2, Material.ORE, Rarity.COMMON, Grade.TWO, 2L),
                                                        new ResourceMaterial(3, Material.ORE, Rarity.UNCOMMON, Grade.TWO, 1L),
                                                        new ResourceMaterial(4, Material.CRYSTAL, Rarity.COMMON, Grade.TWO, 2L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.UNCOMMON, Grade.TWO, 1L),
                                                        new ResourceMaterial(6, Material.SHIP_XP, 190L),
                                                        new ResourceMaterial(7, Material.BATTLESHIP_PARTS, Grade.TWO, 2L)
                                                ))
                                        ),
                                        new Level(15, 250, 85,
                                                new Scrap(13_500, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 1979L),
                                                        new ResourceMaterial(2, Material.ORE, Rarity.COMMON, Grade.TWO, 3L),
                                                        new ResourceMaterial(3, Material.ORE, Rarity.UNCOMMON, Grade.TWO, 1L),
                                                        new ResourceMaterial(4, Material.CRYSTAL, Rarity.COMMON, Grade.TWO, 2L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.UNCOMMON, Grade.TWO, 1L),
                                                        new ResourceMaterial(6, Material.SHIP_XP, 246L),
                                                        new ResourceMaterial(7, Material.BATTLESHIP_PARTS, Grade.TWO, 3L)
                                                ))
                                        )
                                ),
                                addComponents(
                                        new Component(1, ComponentName.WARP_ENGINES,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 6L)
                                                ),
                                                setEmpty(),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.BATTLESHIP_PARTS, Grade.ONE, 2L)
                                                )
                                        ),
                                        new Component(2, ComponentName.TRITANIUM_ARMOR,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 19L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 700L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.BATTLESHIP_PARTS, Grade.ONE, 4L)
                                                )
                                        ),
                                        new Component(3, ComponentName.PHASER_CANNON,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 19L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 1500L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.BATTLESHIP_PARTS, Grade.ONE, 8L)
                                                )
                                        ),
                                        new Component(4, ComponentName.PHASER_CANNON,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 19L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 1500L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.BATTLESHIP_PARTS, Grade.ONE, 8L)
                                                )
                                        )
                                )
                        ),
                        new Tier(4, 4000, 642,
                                addShipLevels(
                                        new Level(16, 350, 90,
                                                new Scrap(16_200, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 3879L),
                                                        new ResourceMaterial(2, Material.ORE, Rarity.COMMON, Grade.TWO, 3L),
                                                        new ResourceMaterial(3, Material.ORE, Rarity.UNCOMMON, Grade.TWO, 1L),
                                                        new ResourceMaterial(4, Material.CRYSTAL, Rarity.COMMON, Grade.TWO, 2L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.UNCOMMON, Grade.TWO, 1L),
                                                        new ResourceMaterial(6, Material.SHIP_XP, 289L),
                                                        new ResourceMaterial(7, Material.BATTLESHIP_PARTS, Grade.TWO, 3L)
                                                ))
                                        ),
                                        new Level(17, 500, 95,
                                                new Scrap(16_200, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 3879L),
                                                        new ResourceMaterial(2, Material.ORE, Rarity.COMMON, Grade.TWO, 3L),
                                                        new ResourceMaterial(3, Material.ORE, Rarity.UNCOMMON, Grade.TWO, 1L),
                                                        new ResourceMaterial(4, Material.CRYSTAL, Rarity.COMMON, Grade.TWO, 2L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.UNCOMMON, Grade.TWO, 1L),
                                                        new ResourceMaterial(6, Material.SHIP_XP, 359L),
                                                        new ResourceMaterial(7, Material.BATTLESHIP_PARTS, Grade.TWO, 3L)
                                                ))
                                        ),
                                        new Level(18, 600, 100,
                                                new Scrap(16_200, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 3879L),
                                                        new ResourceMaterial(2, Material.ORE, Rarity.COMMON, Grade.TWO, 4L),
                                                        new ResourceMaterial(3, Material.ORE, Rarity.UNCOMMON, Grade.TWO, 1L),
                                                        new ResourceMaterial(4, Material.CRYSTAL, Rarity.COMMON, Grade.TWO, 2L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.UNCOMMON, Grade.TWO, 1L),
                                                        new ResourceMaterial(6, Material.SHIP_XP, 459L),
                                                        new ResourceMaterial(7, Material.BATTLESHIP_PARTS, Grade.TWO, 4L)
                                                ))
                                        ),
                                        new Level(19, 700, 105,
                                                new Scrap(16_200, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 3879L),
                                                        new ResourceMaterial(2, Material.ORE, Rarity.COMMON, Grade.TWO, 4L),
                                                        new ResourceMaterial(3, Material.ORE, Rarity.UNCOMMON, Grade.TWO, 1L),
                                                        new ResourceMaterial(4, Material.CRYSTAL, Rarity.COMMON, Grade.TWO, 3L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.UNCOMMON, Grade.TWO, 1L),
                                                        new ResourceMaterial(6, Material.SHIP_XP, 569L),
                                                        new ResourceMaterial(7, Material.BATTLESHIP_PARTS, Grade.TWO, 5L)
                                                ))
                                        ),
                                        new Level(20, 0, 110,
                                                new Scrap(16_200, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 3879L),
                                                        new ResourceMaterial(2, Material.ORE, Rarity.COMMON, Grade.TWO, 5L),
                                                        new ResourceMaterial(3, Material.ORE, Rarity.UNCOMMON, Grade.TWO, 1L),
                                                        new ResourceMaterial(4, Material.CRYSTAL, Rarity.COMMON, Grade.TWO, 3L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.UNCOMMON, Grade.TWO, 1L),
                                                        new ResourceMaterial(6, Material.SHIP_XP, 709L),
                                                        new ResourceMaterial(7, Material.BATTLESHIP_PARTS, Grade.TWO, 6L)
                                                ))
                                        )
                                ),
                                addComponents(
                                        new Component(1, ComponentName.WARP_ENGINES,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 14L)
                                                ),
                                                setEmpty(),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.BATTLESHIP_PARTS, Grade.ONE, 5L)
                                                )
                                        ),
                                        new Component(2, ComponentName.TRITANIUM_ARMOR,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 42L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 2100L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.BATTLESHIP_PARTS, Grade.ONE, 9L)
                                                )
                                        ),
                                        new Component(3, ComponentName.PHASER_CANNON,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 42L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 2500L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.BATTLESHIP_PARTS, Grade.ONE, 14L)
                                                )
                                        ),
                                        new Component(4, ComponentName.PHASER_CANNON,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 42L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 2500L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.BATTLESHIP_PARTS, Grade.ONE, 14L)
                                                )
                                        )
                                )
                        )
                )
        );
    }

    private Ship getTalla() {
        return new Ship(
                "Talla",
                Rarity.COMMON,
                Grade.TWO,
                ShipClass.BATTLESHIP,
                img(R.drawable.talla),
                0,
                "Explorer Hunter",
                14,
                20,
                addTiers(
                        new Tier(1, 66_600, 2268,
                                addShipLevels(
                                        new Level(1, 0, 10,
                                                new Scrap(74_940, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 8800L)
                                                ))
                                        ),
                                        new Level(2, 130, 11,
                                                new Scrap(74_940, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 8800L),
                                                        new ResourceMaterial(2, Material.SHIP_XP, 16L)
                                                ))
                                        ),
                                        new Level(3, 150, 12,
                                                new Scrap(74_940, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 8800L),
                                                        new ResourceMaterial(2, Material.SHIP_XP, 34L)
                                                ))
                                        ),
                                        new Level(4, 180, 13,
                                                new Scrap(74_940, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 8800L),
                                                        new ResourceMaterial(2, Material.SHIP_XP, 55L)
                                                ))
                                        ),
                                        new Level(5, 250, 14,
                                                new Scrap(74_940, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 8800L),
                                                        new ResourceMaterial(2, Material.SHIP_XP, 85L)
                                                ))
                                        )
                                ),
                                addComponents(
                                        new Component(1, ComponentName.BUILD_SHIP_TOTAL)
                                )
                        ),
                        new Tier(2, 15_000, 2526,
                                addShipLevels(
                                        new Level(6, 300, 15,
                                                new Scrap(99_900, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 12_889L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 330L),
                                                        new ResourceMaterial(3, Material.ORE, Rarity.COMMON, Grade.THREE, 1L),
                                                        new ResourceMaterial(4, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 1L),
                                                        new ResourceMaterial(5, Material.SHIP_XP, 114L),
                                                        new ResourceMaterial(6, Material.BATTLESHIP_PARTS, Grade.THREE, 1L)
                                                ))
                                        ),
                                        new Level(7, 350, 16,
                                                new Scrap(99_900, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 12_889L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 330L),
                                                        new ResourceMaterial(3, Material.ORE, Rarity.COMMON, Grade.THREE, 2L),
                                                        new ResourceMaterial(4, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 1L),
                                                        new ResourceMaterial(5, Material.SHIP_XP, 153L),
                                                        new ResourceMaterial(6, Material.BATTLESHIP_PARTS, Grade.THREE, 1L)
                                                ))
                                        ),
                                        new Level(8, 500, 17,
                                                new Scrap(99_900, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 12_889L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 330L),
                                                        new ResourceMaterial(3, Material.ORE, Rarity.COMMON, Grade.THREE, 2L),
                                                        new ResourceMaterial(4, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 1L),
                                                        new ResourceMaterial(5, Material.SHIP_XP, 209L),
                                                        new ResourceMaterial(6, Material.BATTLESHIP_PARTS, Grade.THREE, 2L)
                                                ))
                                        ),
                                        new Level(9, 550, 18,
                                                new Scrap(99_900, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 12_889L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 330L),
                                                        new ResourceMaterial(3, Material.ORE, Rarity.COMMON, Grade.THREE, 2L),
                                                        new ResourceMaterial(4, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 2L),
                                                        new ResourceMaterial(5, Material.SHIP_XP, 271L),
                                                        new ResourceMaterial(6, Material.BATTLESHIP_PARTS, Grade.THREE, 2L)
                                                ))
                                        ),
                                        new Level(10, 650, 19,
                                                new Scrap(99_900, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 12_889L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 330L),
                                                        new ResourceMaterial(3, Material.ORE, Rarity.COMMON, Grade.THREE, 3L),
                                                        new ResourceMaterial(4, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 2L),
                                                        new ResourceMaterial(5, Material.SHIP_XP, 344L),
                                                        new ResourceMaterial(6, Material.BATTLESHIP_PARTS, Grade.THREE, 2L)
                                                ))
                                        )
                                ),
                                addComponents(
                                        new Component(1, ComponentName.WARP_ENGINES,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 8L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 180L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.BATTLESHIP_PARTS, Grade.TWO, 6L)
                                                )
                                        ),
                                        new Component(2, ComponentName.CARGO_BAY,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 17L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 1700L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.BATTLESHIP_PARTS, Grade.TWO, 3L)
                                                )
                                        ),
                                        new Component(3, ComponentName.TRITANIUM_ARMOR,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 52L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 4200L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.BATTLESHIP_PARTS, Grade.TWO, 9L)
                                                )
                                        ),
                                        new Component(4, ComponentName.PHASER_CANNON,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 26L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 13L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 2500L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 350L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.BATTLESHIP_PARTS, Grade.TWO, 18L)
                                                )
                                        ),
                                        new Component(5, ComponentName.PHASER_CANNON,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 26L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 13L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 2500L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 350L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.BATTLESHIP_PARTS, Grade.TWO, 18L)
                                                )
                                        )
                                )
                        ),
                        new Tier(3, 30_000, 2850,
                                addShipLevels(
                                        new Level(11, 700, 20,
                                                new Scrap(124_860, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 19_440L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 964L),
                                                        new ResourceMaterial(3, Material.ORE, Rarity.COMMON, Grade.THREE, 4L),
                                                        new ResourceMaterial(4, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 3L),
                                                        new ResourceMaterial(5, Material.SHIP_XP, 395L),
                                                        new ResourceMaterial(6, Material.BATTLESHIP_PARTS, Grade.THREE, 3L)
                                                ))
                                        ),
                                        new Level(12, 900, 21,
                                                new Scrap(124_860, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 19_440L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 964L),
                                                        new ResourceMaterial(3, Material.ORE, Rarity.COMMON, Grade.THREE, 6L),
                                                        new ResourceMaterial(4, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 3L),
                                                        new ResourceMaterial(5, Material.SHIP_XP, 489L),
                                                        new ResourceMaterial(6, Material.BATTLESHIP_PARTS, Grade.THREE, 3L)
                                                ))
                                        ),
                                        new Level(13, 1000, 22,
                                                new Scrap(124_860, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 19_440L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 964L),
                                                        new ResourceMaterial(3, Material.ORE, Rarity.COMMON, Grade.THREE, 9L),
                                                        new ResourceMaterial(4, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 5L),
                                                        new ResourceMaterial(5, Material.SHIP_XP, 594L),
                                                        new ResourceMaterial(6, Material.BATTLESHIP_PARTS, Grade.THREE, 4L)
                                                ))
                                        ),
                                        new Level(14, 1100, 23,
                                                new Scrap(124_860, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 19_440L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 964L),
                                                        new ResourceMaterial(3, Material.ORE, Rarity.COMMON, Grade.THREE, 12L),
                                                        new ResourceMaterial(4, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 7L),
                                                        new ResourceMaterial(5, Material.SHIP_XP, 710L),
                                                        new ResourceMaterial(6, Material.BATTLESHIP_PARTS, Grade.THREE, 5L)
                                                ))
                                        ),
                                        new Level(15, 1400, 24,
                                                new Scrap(124_860, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 19_440L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 964L),
                                                        new ResourceMaterial(3, Material.ORE, Rarity.COMMON, Grade.THREE, 17L),
                                                        new ResourceMaterial(4, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 10L),
                                                        new ResourceMaterial(5, Material.SHIP_XP, 857L),
                                                        new ResourceMaterial(6, Material.BATTLESHIP_PARTS, Grade.THREE, 6L)
                                                ))
                                        )
                                ),
                                addComponents(
                                        new Component(1, ComponentName.WARP_ENGINES,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 17L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 375L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.BATTLESHIP_PARTS, Grade.TWO, 12L)
                                                )
                                        ),
                                        new Component(2, ComponentName.CARGO_BAY,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 42L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 3000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.BATTLESHIP_PARTS, Grade.TWO, 6L)
                                                )
                                        ),
                                        new Component(3, ComponentName.TRITANIUM_ARMOR,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 126L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 7500L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.BATTLESHIP_PARTS, Grade.TWO, 18L)
                                                )
                                        ),
                                        new Component(4, ComponentName.PHASER_CANNON,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 63L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 28L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 4500L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 750L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.ORE, Rarity.COMMON, Grade.TWO, 190L),
                                                        new ResourceMaterial(2, Material.BATTLESHIP_PARTS, Grade.TWO, 36L)
                                                )
                                        ),
                                        new Component(5, ComponentName.PHASER_CANNON,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 63L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 28L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 4500L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 750L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.ORE, Rarity.COMMON, Grade.TWO, 190L),
                                                        new ResourceMaterial(2, Material.BATTLESHIP_PARTS, Grade.TWO, 36L)
                                                )
                                        )
                                )
                        ),
                        new Tier(4, 50_000, 3450,
                                addShipLevels(
                                        new Level(16, 1600, 25,
                                                new Scrap(149_880, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 29_244L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 2196L),
                                                        new ResourceMaterial(3, Material.ORE, Rarity.COMMON, Grade.THREE, 17L),
                                                        new ResourceMaterial(4, Material.ORE, Rarity.UNCOMMON, Grade.THREE, 2L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 9L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 1L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 952L),
                                                        new ResourceMaterial(8, Material.BATTLESHIP_PARTS, Grade.THREE, 7L)
                                                ))
                                        ),
                                        new Level(17, 1700, 26,
                                                new Scrap(149_880, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 29_244L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 2196L),
                                                        new ResourceMaterial(3, Material.ORE, Rarity.COMMON, Grade.THREE, 20L),
                                                        new ResourceMaterial(4, Material.ORE, Rarity.UNCOMMON, Grade.THREE, 2L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 11L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 1L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 1117L),
                                                        new ResourceMaterial(8, Material.BATTLESHIP_PARTS, Grade.THREE, 7L)
                                                ))
                                        ),
                                        new Level(18, 2100, 27,
                                                new Scrap(149_880, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 29_244L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 2196L),
                                                        new ResourceMaterial(3, Material.ORE, Rarity.COMMON, Grade.THREE, 27L),
                                                        new ResourceMaterial(4, Material.ORE, Rarity.UNCOMMON, Grade.THREE, 2L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 15L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 1L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 1322L),
                                                        new ResourceMaterial(8, Material.BATTLESHIP_PARTS, Grade.THREE, 9L)
                                                ))
                                        ),
                                        new Level(19, 2300, 28,
                                                new Scrap(149_880, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 29_244L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 2196L),
                                                        new ResourceMaterial(3, Material.ORE, Rarity.COMMON, Grade.THREE, 35L),
                                                        new ResourceMaterial(4, Material.ORE, Rarity.UNCOMMON, Grade.THREE, 3L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 19L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 2L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 1546L),
                                                        new ResourceMaterial(8, Material.BATTLESHIP_PARTS, Grade.THREE, 11L)
                                                ))
                                        ),
                                        new Level(20, 2500, 29,
                                                new Scrap(149_880, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 29_244L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 2196L),
                                                        new ResourceMaterial(3, Material.ORE, Rarity.COMMON, Grade.THREE, 47L),
                                                        new ResourceMaterial(4, Material.ORE, Rarity.UNCOMMON, Grade.THREE, 3L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 25L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 2L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 1790L),
                                                        new ResourceMaterial(8, Material.BATTLESHIP_PARTS, Grade.THREE, 14L)
                                                ))
                                        )
                                ),
                                addComponents(
                                        new Component(1, ComponentName.WARP_ENGINES,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 34L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 800L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.BATTLESHIP_PARTS, Grade.TWO, 21L)
                                                )
                                        ),
                                        new Component(2, ComponentName.CARGO_BAY,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 95L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 5000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.BATTLESHIP_PARTS, Grade.TWO, 11L)
                                                )
                                        ),
                                        new Component(3, ComponentName.TRITANIUM_ARMOR,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 285L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 2_500)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.ORE, Rarity.COMMON, Grade.TWO, 400L),
                                                        new ResourceMaterial(2, Material.BATTLESHIP_PARTS, Grade.TWO, 32L)
                                                )
                                        ),
                                        new Component(4, ComponentName.PHASER_CANNON,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 143L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 56L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 7500L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 1600L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.ORE, Rarity.COMMON, Grade.TWO, 500L),
                                                        new ResourceMaterial(2, Material.BATTLESHIP_PARTS, Grade.TWO, 63L)
                                                )
                                        ),
                                        new Component(5, ComponentName.PHASER_CANNON,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 143L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 56L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 7500L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 1600L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.ORE, Rarity.COMMON, Grade.TWO, 500L),
                                                        new ResourceMaterial(2, Material.BATTLESHIP_PARTS, Grade.TWO, 63L)
                                                )
                                        )
                                )
                        ),
                        new Tier(5, 75_000, 3930,
                                addShipLevels(
                                        new Level(21, 2600, 30,
                                                new Scrap(174_840, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 44_020L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 4187L),
                                                        new ResourceMaterial(3, Material.ORE, Rarity.COMMON, Grade.THREE, 42L),
                                                        new ResourceMaterial(4, Material.ORE, Rarity.UNCOMMON, Grade.THREE, 5L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 23L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 3L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 1886L),
                                                        new ResourceMaterial(8, Material.BATTLESHIP_PARTS, Grade.THREE, 14L)
                                                ))
                                        ),
                                        new Level(22, 3200, 31,
                                                new Scrap(174_840, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 44_020L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 4187L),
                                                        new ResourceMaterial(3, Material.ORE, Rarity.COMMON, Grade.THREE, 46L),
                                                        new ResourceMaterial(4, Material.ORE, Rarity.UNCOMMON, Grade.THREE, 5L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 25L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 3L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 2174L),
                                                        new ResourceMaterial(8, Material.BATTLESHIP_PARTS, Grade.THREE, 15L)
                                                ))
                                        ),
                                        new Level(23, 3400, 32,
                                                new Scrap(174_840, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 44_020L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 4187L),
                                                        new ResourceMaterial(3, Material.ORE, Rarity.COMMON, Grade.THREE, 54L),
                                                        new ResourceMaterial(4, Material.ORE, Rarity.UNCOMMON, Grade.THREE, 6L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 29L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 4L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 2480L),
                                                        new ResourceMaterial(8, Material.BATTLESHIP_PARTS, Grade.THREE, 18L)
                                                ))
                                        ),
                                        new Level(24, 3600, 33,
                                                new Scrap(174_840, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 44_020L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 4187L),
                                                        new ResourceMaterial(3, Material.ORE, Rarity.COMMON, Grade.THREE, 63L),
                                                        new ResourceMaterial(4, Material.ORE, Rarity.UNCOMMON, Grade.THREE, 7L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 34L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 4L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 2804L),
                                                        new ResourceMaterial(8, Material.BATTLESHIP_PARTS, Grade.THREE, 21L)
                                                ))
                                        ),
                                        new Level(25, 4400, 34,
                                                new Scrap(174_840, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 44_020L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 4187L),
                                                        new ResourceMaterial(3, Material.ORE, Rarity.COMMON, Grade.THREE, 77L),
                                                        new ResourceMaterial(4, Material.ORE, Rarity.UNCOMMON, Grade.THREE, 9L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 42L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 5L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 3200L),
                                                        new ResourceMaterial(8, Material.BATTLESHIP_PARTS, Grade.THREE, 25L)
                                                ))
                                        )
                                ),
                                addComponents(
                                        new Component(1, ComponentName.WARP_ENGINES,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 63L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 1400L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.ORE, Rarity.COMMON, Grade.TWO, 375L),
                                                        new ResourceMaterial(2, Material.BATTLESHIP_PARTS, Grade.TWO, 36L)
                                                )
                                        ),
                                        new Component(2, ComponentName.CARGO_BAY,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 187L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 8500L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.BATTLESHIP_PARTS, Grade.TWO, 18L)
                                                )
                                        ),
                                        new Component(3, ComponentName.TRITANIUM_ARMOR,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 561L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 21_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.ORE, Rarity.COMMON, Grade.TWO, 750L),
                                                        new ResourceMaterial(2, Material.BATTLESHIP_PARTS, Grade.TWO, 54L)
                                                )
                                        ),
                                        new Component(4, ComponentName.PHASER_CANNON,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 281L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 104L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 12_500L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 2900L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.ORE, Rarity.UNCOMMON, Grade.TWO, 63L),
                                                        new ResourceMaterial(2, Material.BATTLESHIP_PARTS, Grade.TWO, 110L)
                                                )
                                        ),
                                        new Component(5, ComponentName.PHASER_CANNON,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 281L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 104L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 12_500L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 2900L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.ORE, Rarity.UNCOMMON, Grade.TWO, 63L),
                                                        new ResourceMaterial(2, Material.BATTLESHIP_PARTS, Grade.TWO, 110L)
                                                )
                                        )
                                )
                        ),
                        new Tier(6, 100_000, 4344,
                                addShipLevels(
                                        new Level(26, 4600, 35,
                                                new Scrap(199_800, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 68_036L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 7797L),
                                                        new ResourceMaterial(3, Material.ORE, Rarity.COMMON, Grade.THREE, 56L),
                                                        new ResourceMaterial(4, Material.ORE, Rarity.UNCOMMON, Grade.THREE, 12L),
                                                        new ResourceMaterial(5, Material.ORE, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 30L),
                                                        new ResourceMaterial(7, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 6L),
                                                        new ResourceMaterial(8, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(9, Material.SHIP_XP, 3313L),
                                                        new ResourceMaterial(10, Material.BATTLESHIP_PARTS, Grade.THREE, 25L)
                                                ))
                                        ),
                                        new Level(27, 4900, 36,
                                                new Scrap(199_800, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 68_036L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 7797L),
                                                        new ResourceMaterial(3, Material.ORE, Rarity.COMMON, Grade.THREE, 61L),
                                                        new ResourceMaterial(4, Material.ORE, Rarity.UNCOMMON, Grade.THREE, 13L),
                                                        new ResourceMaterial(5, Material.ORE, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 33L),
                                                        new ResourceMaterial(7, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 7L),
                                                        new ResourceMaterial(8, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(9, Material.SHIP_XP, 3717L),
                                                        new ResourceMaterial(10, Material.BATTLESHIP_PARTS, Grade.THREE, 27L)
                                                ))
                                        ),
                                        new Level(28, 5000, 37,
                                                new Scrap(199_800, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 68_036L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 7797L),
                                                        new ResourceMaterial(3, Material.ORE, Rarity.COMMON, Grade.THREE, 71L),
                                                        new ResourceMaterial(4, Material.ORE, Rarity.UNCOMMON, Grade.THREE, 15L),
                                                        new ResourceMaterial(5, Material.ORE, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 39L),
                                                        new ResourceMaterial(7, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 8L),
                                                        new ResourceMaterial(8, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(9, Material.SHIP_XP, 4130L),
                                                        new ResourceMaterial(10, Material.BATTLESHIP_PARTS, Grade.THREE, 32L)
                                                ))
                                        ),
                                        new Level(29, 6000, 38,
                                                new Scrap(199_800, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 68_036L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 7797L),
                                                        new ResourceMaterial(3, Material.ORE, Rarity.COMMON, Grade.THREE, 84L),
                                                        new ResourceMaterial(4, Material.ORE, Rarity.UNCOMMON, Grade.THREE, 17L),
                                                        new ResourceMaterial(5, Material.ORE, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 45L),
                                                        new ResourceMaterial(7, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 9L),
                                                        new ResourceMaterial(8, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(9, Material.SHIP_XP, 4625L),
                                                        new ResourceMaterial(10, Material.BATTLESHIP_PARTS, Grade.THREE, 37L)
                                                ))
                                        ),
                                        new Level(30, 6500, 40,
                                                new Scrap(199_800, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 68_036L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 7797L),
                                                        new ResourceMaterial(3, Material.ORE, Rarity.COMMON, Grade.THREE, 101L),
                                                        new ResourceMaterial(4, Material.ORE, Rarity.UNCOMMON, Grade.THREE, 21L),
                                                        new ResourceMaterial(5, Material.ORE, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 55L),
                                                        new ResourceMaterial(7, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 11L),
                                                        new ResourceMaterial(8, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(9, Material.SHIP_XP, 5161L),
                                                        new ResourceMaterial(10, Material.BATTLESHIP_PARTS, Grade.THREE, 45L)
                                                ))
                                        )
                                ),
                                addComponents(
                                        new Component(1, ComponentName.WARP_ENGINES,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 123L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 2900L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.ORE, Rarity.COMMON, Grade.TWO, 750L),
                                                        new ResourceMaterial(2, Material.BATTLESHIP_PARTS, Grade.TWO, 70L)
                                                )
                                        ),
                                        new Component(2, ComponentName.CARGO_BAY,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 343L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 15_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.ORE, Rarity.COMMON, Grade.TWO, 375L),
                                                        new ResourceMaterial(2, Material.BATTLESHIP_PARTS, Grade.TWO, 36L)
                                                )
                                        ),
                                        new Component(3, ComponentName.TRITANIUM_ARMOR,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 1029L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 38_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.ORE, Rarity.UNCOMMON, Grade.TWO, 120L),
                                                        new ResourceMaterial(2, Material.BATTLESHIP_PARTS, Grade.TWO, 110L)
                                                )
                                        ),
                                        new Component(4, ComponentName.PHASER_CANNON,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 515L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 206L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 22_500L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 5750L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.ORE, Rarity.UNCOMMON, Grade.TWO, 150L),
                                                        new ResourceMaterial(2, Material.BATTLESHIP_PARTS, Grade.TWO, 220L)
                                                )
                                        ),
                                        new Component(5, ComponentName.PHASER_CANNON,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 515L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 206L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 22_500L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 5750L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.ORE, Rarity.UNCOMMON, Grade.TWO, 150L),
                                                        new ResourceMaterial(2, Material.BATTLESHIP_PARTS, Grade.TWO, 220L)
                                                )
                                        )
                                )
                        ),
                        new Tier(7, 125_000, 5442,
                                addShipLevels(
                                        new Level(31, 6500, 42,
                                                new Scrap(224_760, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 117_275L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 15_527L),
                                                        new ResourceMaterial(3, Material.ORE, Rarity.COMMON, Grade.THREE, 83L),
                                                        new ResourceMaterial(4, Material.ORE, Rarity.UNCOMMON, Grade.THREE, 24L),
                                                        new ResourceMaterial(5, Material.ORE, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 45L),
                                                        new ResourceMaterial(7, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 13L),
                                                        new ResourceMaterial(8, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(9, Material.SHIP_XP, 5180L),
                                                        new ResourceMaterial(10, Material.BATTLESHIP_PARTS, Grade.THREE, 46L)
                                                ))
                                        ),
                                        new Level(32, 8000, 44,
                                                new Scrap(224_760, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 117_275L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 15_527L),
                                                        new ResourceMaterial(3, Material.ORE, Rarity.COMMON, Grade.THREE, 90L),
                                                        new ResourceMaterial(4, Material.ORE, Rarity.UNCOMMON, Grade.THREE, 26L),
                                                        new ResourceMaterial(5, Material.ORE, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 49L),
                                                        new ResourceMaterial(7, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 14L),
                                                        new ResourceMaterial(8, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(9, Material.SHIP_XP, 5780L),
                                                        new ResourceMaterial(10, Material.BATTLESHIP_PARTS, Grade.THREE, 50L)
                                                ))
                                        ),
                                        new Level(33, 8000, 46,
                                                new Scrap(224_760, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 117_275L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 15_527L),
                                                        new ResourceMaterial(3, Material.ORE, Rarity.COMMON, Grade.THREE, 106L),
                                                        new ResourceMaterial(4, Material.ORE, Rarity.UNCOMMON, Grade.THREE, 30L),
                                                        new ResourceMaterial(5, Material.ORE, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 57L),
                                                        new ResourceMaterial(7, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 16L),
                                                        new ResourceMaterial(8, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(9, Material.SHIP_XP, 6380L),
                                                        new ResourceMaterial(10, Material.BATTLESHIP_PARTS, Grade.THREE, 59L)
                                                ))
                                        ),
                                        new Level(34, 8500, 48,
                                                new Scrap(224_760, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 117_275L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 15_527L),
                                                        new ResourceMaterial(3, Material.ORE, Rarity.COMMON, Grade.THREE, 125L),
                                                        new ResourceMaterial(4, Material.ORE, Rarity.UNCOMMON, Grade.THREE, 36L),
                                                        new ResourceMaterial(5, Material.ORE, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 68L),
                                                        new ResourceMaterial(7, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 19L),
                                                        new ResourceMaterial(8, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(9, Material.SHIP_XP, 7017L),
                                                        new ResourceMaterial(10, Material.BATTLESHIP_PARTS, Grade.THREE, 70L)
                                                ))
                                        ),
                                        new Level(35, 10_000, 50,
                                                new Scrap(224_760, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 117_275L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 15_527L),
                                                        new ResourceMaterial(3, Material.ORE, Rarity.COMMON, Grade.THREE, 153L),
                                                        new ResourceMaterial(4, Material.ORE, Rarity.UNCOMMON, Grade.THREE, 43L),
                                                        new ResourceMaterial(5, Material.ORE, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 82L),
                                                        new ResourceMaterial(7, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 24L),
                                                        new ResourceMaterial(8, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(9, Material.SHIP_XP, 7767L),
                                                        new ResourceMaterial(10, Material.BATTLESHIP_PARTS, Grade.THREE, 85L)
                                                ))
                                        )
                                ),
                                addComponents(
                                        new Component(1, ComponentName.WARP_ENGINES,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 236L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 6750L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.ORE, Rarity.UNCOMMON, Grade.TWO, 140L),
                                                        new ResourceMaterial(2, Material.BATTLESHIP_PARTS, Grade.TWO, 160L)
                                                )
                                        ),
                                        new Component(2, ComponentName.CARGO_BAY,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 644L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 33_500L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.ORE, Rarity.COMMON, Grade.TWO, 875L),
                                                        new ResourceMaterial(2, Material.BATTLESHIP_PARTS, Grade.TWO, 80L)
                                                )
                                        ),
                                        new Component(3, ComponentName.TRITANIUM_ARMOR,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 1932L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 84_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.ORE, Rarity.UNCOMMON, Grade.TWO, 275L),
                                                        new ResourceMaterial(2, Material.BATTLESHIP_PARTS, Grade.TWO, 250L)
                                                )
                                        ),
                                        new Component(4, ComponentName.PHASER_CANNON,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 966L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 393L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 50_500L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 13_500L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.ORE, Rarity.UNCOMMON, Grade.TWO, 350L),
                                                        new ResourceMaterial(2, Material.BATTLESHIP_PARTS, Grade.TWO, 475L)
                                                )
                                        ),
                                        new Component(5, ComponentName.PHASER_CANNON,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 966L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 393L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 50_500L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 13_500L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.ORE, Rarity.UNCOMMON, Grade.TWO, 350L),
                                                        new ResourceMaterial(2, Material.BATTLESHIP_PARTS, Grade.TWO, 475L)
                                                )
                                        )
                                )
                        )
                )
        );
    }

    private Ship getKumari() {
        return new Ship(
                "Kumari",
                Rarity.COMMON,
                Grade.THREE,
                ShipClass.BATTLESHIP,
                img(R.drawable.kumari),
                0,
                "Shield Disruptor",
                24,
                26,
                addTiers(
                        new Tier(1, 900_000, 16_440,
                                addShipLevels(
                                        new Level(1, 0, 10,
                                                new Scrap(435_480, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 132_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 7000L)
                                                ))
                                        ),
                                        new Level(2, 800, 11,
                                                new Scrap(435_480, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 132_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 7000L),
                                                        new ResourceMaterial(3, Material.SHIP_XP, 32L)
                                                ))
                                        ),
                                        new Level(3, 1000, 12,
                                                new Scrap(435_480, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 132_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 7000L),
                                                        new ResourceMaterial(3, Material.SHIP_XP, 72L)
                                                ))
                                        ),
                                        new Level(4, 1400, 13,
                                                new Scrap(435_480, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 132_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 7000L),
                                                        new ResourceMaterial(3, Material.SHIP_XP, 128L)
                                                ))
                                        ),
                                        new Level(5, 1700, 14,
                                                new Scrap(435_480, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 132_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 7000L),
                                                        new ResourceMaterial(3, Material.SHIP_XP, 196L)
                                                ))
                                        )
                                ),
                                addComponents(
                                        new Component(1, ComponentName.BUILD_SHIP_TOTAL)
                                )
                        ),
                        new Tier(2, 102_600, 18_264,
                                addShipLevels(
                                        new Level(6, 2400, 15,
                                                new Scrap(489_900, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 320_455L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 15_727L),
                                                        new ResourceMaterial(3, Material.ORE, Rarity.COMMON, Grade.THREE, 38L),
                                                        new ResourceMaterial(4, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 21L),
                                                        new ResourceMaterial(5, Material.SHIP_XP, 274L),
                                                        new ResourceMaterial(6, Material.BATTLESHIP_PARTS, Grade.THREE, 10L)
                                                ))
                                        ),
                                        new Level(7, 2900, 16,
                                                new Scrap(489_900, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 320_455L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 15_727L),
                                                        new ResourceMaterial(3, Material.ORE, Rarity.COMMON, Grade.THREE, 48L),
                                                        new ResourceMaterial(4, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 26L),
                                                        new ResourceMaterial(5, Material.SHIP_XP, 383L),
                                                        new ResourceMaterial(6, Material.BATTLESHIP_PARTS, Grade.THREE, 12L)
                                                ))
                                        ),
                                        new Level(8, 3900, 17,
                                                new Scrap(489_900, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 320_455L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 15_727L),
                                                        new ResourceMaterial(3, Material.ORE, Rarity.COMMON, Grade.THREE, 62L),
                                                        new ResourceMaterial(4, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 34L),
                                                        new ResourceMaterial(5, Material.SHIP_XP, 529L),
                                                        new ResourceMaterial(6, Material.BATTLESHIP_PARTS, Grade.THREE, 16L)
                                                ))
                                        ),
                                        new Level(9, 4600, 18,
                                                new Scrap(489_900, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 320_455L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 15_727L),
                                                        new ResourceMaterial(3, Material.ORE, Rarity.COMMON, Grade.THREE, 76L),
                                                        new ResourceMaterial(4, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 41L),
                                                        new ResourceMaterial(5, Material.SHIP_XP, 701L),
                                                        new ResourceMaterial(6, Material.BATTLESHIP_PARTS, Grade.THREE, 19L)
                                                ))
                                        ),
                                        new Level(10, 6000, 19,
                                                new Scrap(489_900, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 320_455L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 15_727L),
                                                        new ResourceMaterial(3, Material.ORE, Rarity.COMMON, Grade.THREE, 95L),
                                                        new ResourceMaterial(4, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 52L),
                                                        new ResourceMaterial(5, Material.SHIP_XP, 926L),
                                                        new ResourceMaterial(6, Material.BATTLESHIP_PARTS, Grade.THREE, 24L)
                                                ))
                                        )
                                ),
                                addComponents(
                                        new Component(1, ComponentName.WARP_ENGINES,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 549L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 8250L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 26L),
                                                        new ResourceMaterial(2, Material.BATTLESHIP_PARTS, Grade.THREE, 18L)
                                                )
                                        ),
                                        new Component(2, ComponentName.CARGO_BAY,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 1790L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 187_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.ORE, Rarity.COMMON, Grade.THREE, 29L),
                                                        new ResourceMaterial(2, Material.BATTLESHIP_PARTS, Grade.THREE, 6L)
                                                )
                                        ),
                                        new Component(3, ComponentName.TRITANIUM_ARMOR,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 5369L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 375_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.ORE, Rarity.COMMON, Grade.THREE, 110L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 17L),
                                                        new ResourceMaterial(3, Material.BATTLESHIP_PARTS, Grade.THREE, 24L)
                                                )
                                        ),
                                        new Component(4, ComponentName.PHASER_CANNON,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 1790L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 610L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 187_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 16_750L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.ORE, Rarity.COMMON, Grade.THREE, 140L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 34L),
                                                        new ResourceMaterial(3, Material.BATTLESHIP_PARTS, Grade.THREE, 36L)
                                                )
                                        ),
                                        new Component(5, ComponentName.PHASER_CANNON,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 1790L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 610L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 187_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 16_750L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.ORE, Rarity.COMMON, Grade.THREE, 140L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 34L),
                                                        new ResourceMaterial(3, Material.BATTLESHIP_PARTS, Grade.THREE, 36L)
                                                )
                                        ),
                                        new Component(6, ComponentName.PHOTON_TORPEDO,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 1491L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 183L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 375_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 3300L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.ORE, Rarity.COMMON, Grade.THREE, 110L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 26L),
                                                        new ResourceMaterial(3, Material.BATTLESHIP_PARTS, Grade.THREE, 30L)
                                                )
                                        )
                                )
                        ),
                        new Tier(3, 205_200, 20_712,
                                addShipLevels(
                                        new Level(11, 7000, 20,
                                                new Scrap(544_380, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 673_201L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 35_416L),
                                                        new ResourceMaterial(3, Material.ORE, Rarity.COMMON, Grade.THREE, 93L),
                                                        new ResourceMaterial(4, Material.ORE, Rarity.UNCOMMON, Grade.THREE, 5L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 50L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 3L),
                                                        new ResourceMaterial(7,Material.SHIP_XP, 1110L),
                                                        new ResourceMaterial(8, Material.BATTLESHIP_PARTS, Grade.THREE, 27L)
                                                ))
                                        ),
                                        new Level(12, 8500, 21,
                                                new Scrap(544_380, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 673_201L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 35_416L),
                                                        new ResourceMaterial(3, Material.ORE, Rarity.COMMON, Grade.THREE, 107L),
                                                        new ResourceMaterial(4, Material.ORE, Rarity.UNCOMMON, Grade.THREE, 5L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 58L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 3L),
                                                        new ResourceMaterial(7,Material.SHIP_XP, 1407L),
                                                        new ResourceMaterial(8, Material.BATTLESHIP_PARTS, Grade.THREE, 32L)
                                                ))
                                        ),
                                        new Level(13, 9500, 22,
                                                new Scrap(544_380, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 673_201L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 35_416L),
                                                        new ResourceMaterial(3, Material.ORE, Rarity.COMMON, Grade.THREE, 136L),
                                                        new ResourceMaterial(4, Material.ORE, Rarity.UNCOMMON, Grade.THREE, 6L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 73L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 4L),
                                                        new ResourceMaterial(7,Material.SHIP_XP, 1740L),
                                                        new ResourceMaterial(8, Material.BATTLESHIP_PARTS, Grade.THREE, 40L)
                                                ))
                                        ),
                                        new Level(14, 11_000, 23,
                                                new Scrap(544_380, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 673_201L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 35_416L),
                                                        new ResourceMaterial(3, Material.ORE, Rarity.COMMON, Grade.THREE, 172L),
                                                        new ResourceMaterial(4, Material.ORE, Rarity.UNCOMMON, Grade.THREE, 8L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 93L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 5L),
                                                        new ResourceMaterial(7,Material.SHIP_XP, 2125L),
                                                        new ResourceMaterial(8, Material.BATTLESHIP_PARTS, Grade.THREE, 51L)
                                                ))
                                        ),
                                        new Level(15, 13_500, 24,
                                                new Scrap(544_380, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 673_201L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 35_416L),
                                                        new ResourceMaterial(3, Material.ORE, Rarity.COMMON, Grade.THREE, 222L),
                                                        new ResourceMaterial(4, Material.ORE, Rarity.UNCOMMON, Grade.THREE, 10L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 120L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 6L),
                                                        new ResourceMaterial(7,Material.SHIP_XP, 2597L),
                                                        new ResourceMaterial(8, Material.BATTLESHIP_PARTS, Grade.THREE, 66L)
                                                ))
                                        )
                                ),
                                addComponents(
                                        new Component(1, ComponentName.WARP_ENGINES,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 1107L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 19_750L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 80L),
                                                        new ResourceMaterial(2, Material.BATTLESHIP_PARTS, Grade.THREE, 36L)
                                                )
                                        ),
                                        new Component(2, ComponentName.CARGO_BAY,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 3683L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 375_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.ORE, Rarity.COMMON, Grade.THREE, 90L),
                                                        new ResourceMaterial(2, Material.BATTLESHIP_PARTS, Grade.THREE, 12L)
                                                )
                                        ),
                                        new Component(3, ComponentName.TRITANIUM_ARMOR,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 11_000L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 750_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.ORE, Rarity.COMMON, Grade.THREE, 350L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 51L),
                                                        new ResourceMaterial(3, Material.BATTLESHIP_PARTS, Grade.THREE, 48L)
                                                )
                                        ),
                                        new Component(4, ComponentName.PHASER_CANNON,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 3683L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 1230L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 375_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 39_500L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.ORE, Rarity.UNCOMMON, Grade.THREE, 20L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 5L),
                                                        new ResourceMaterial(3, Material.BATTLESHIP_PARTS, Grade.THREE, 70L)
                                                )
                                        ),
                                        new Component(5, ComponentName.PHASER_CANNON,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 3683L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 1230L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 375_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 39_500L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.ORE, Rarity.UNCOMMON, Grade.THREE, 20L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 5L),
                                                        new ResourceMaterial(3, Material.BATTLESHIP_PARTS, Grade.THREE, 70L)
                                                )
                                        ),
                                        new Component(6, ComponentName.PHOTON_TORPEDO,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 3069L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 369L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 750_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 7750L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.ORE, Rarity.COMMON, Grade.THREE, 350L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 80L),
                                                        new ResourceMaterial(3, Material.BATTLESHIP_PARTS, Grade.THREE, 60L)
                                                )
                                        )
                                )
                        ),
                        new Tier(4, 342_000, 24_402,
                                addShipLevels(
                                        new Level(16, 15_000, 25,
                                                new Scrap(598_800, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 1_220_852L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 75_114L),
                                                        new ResourceMaterial(3, Material.ORE, Rarity.COMMON, Grade.THREE, 213L),
                                                        new ResourceMaterial(4, Material.ORE, Rarity.UNCOMMON, Grade.THREE, 18L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 115L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 10L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 2899L),
                                                        new ResourceMaterial(8, Material.BATTLESHIP_PARTS, Grade.THREE, 72L)
                                                ))
                                        ),
                                        new Level(17, 17_500, 26,
                                                new Scrap(598_800, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 1_220_852L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 75_114L),
                                                        new ResourceMaterial(3, Material.ORE, Rarity.COMMON, Grade.THREE, 237L),
                                                        new ResourceMaterial(4, Material.ORE, Rarity.UNCOMMON, Grade.THREE, 20L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 128L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 11L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 3468L),
                                                        new ResourceMaterial(8, Material.BATTLESHIP_PARTS, Grade.THREE, 79L)
                                                ))
                                        ),
                                        new Level(18, 19_500, 27,
                                                new Scrap(598_800, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 1_220_852L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 75_114L),
                                                        new ResourceMaterial(3, Material.ORE, Rarity.COMMON, Grade.THREE, 286L),
                                                        new ResourceMaterial(4, Material.ORE, Rarity.UNCOMMON, Grade.THREE, 24L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 154L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 13L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 4102L),
                                                        new ResourceMaterial(8, Material.BATTLESHIP_PARTS, Grade.THREE, 95L)
                                                ))
                                        ),
                                        new Level(19, 23_000, 28,
                                                new Scrap(598_800, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 1_220_852L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 75_114L),
                                                        new ResourceMaterial(3, Material.ORE, Rarity.COMMON, Grade.THREE, 346L),
                                                        new ResourceMaterial(4, Material.ORE, Rarity.UNCOMMON, Grade.THREE, 29L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 187L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 16L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 4849L),
                                                        new ResourceMaterial(8, Material.BATTLESHIP_PARTS, Grade.THREE, 114L)
                                                ))
                                        ),
                                        new Level(20, 25_000, 29,
                                                new Scrap(598_800, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 1_220_852L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 75_114L),
                                                        new ResourceMaterial(3, Material.ORE, Rarity.COMMON, Grade.THREE, 431L),
                                                        new ResourceMaterial(4, Material.ORE, Rarity.UNCOMMON, Grade.THREE, 36L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 232L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 20L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 5662L),
                                                        new ResourceMaterial(8, Material.BATTLESHIP_PARTS, Grade.THREE, 141L)
                                                ))
                                        )
                                ),
                                addComponents(
                                        new Component(1, ComponentName.WARP_ENGINES,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 1687L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 41_500L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 210L),
                                                        new ResourceMaterial(2, Material.BATTLESHIP_PARTS, Grade.THREE, 63L)
                                                )
                                        ),
                                        new Component(2, ComponentName.CARGO_BAY,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 6229L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(2, Material.TRITANIUM, 620_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.ORE, Rarity.COMMON, Grade.THREE, 230L),
                                                        new ResourceMaterial(2, Material.BATTLESHIP_PARTS, Grade.THREE, 21L)
                                                )
                                        ),
                                        new Component(3, ComponentName.TRITANIUM_ARMOR,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 18_000L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 1_250_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.ORE, Rarity.COMMON, Grade.THREE, 925L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 140L),
                                                        new ResourceMaterial(3, Material.BATTLESHIP_PARTS, Grade.THREE, 80L)
                                                )
                                        ),
                                        new Component(4, ComponentName.PHASER_CANNON,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 6229L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 1875L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 620_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 83_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.ORE, Rarity.UNCOMMON, Grade.THREE, 70L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 16L),
                                                        new ResourceMaterial(3, Material.BATTLESHIP_PARTS, Grade.THREE, 130L)
                                                )
                                        ),
                                        new Component(5, ComponentName.PHASER_CANNON,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 6229L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 1875L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 620_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 83_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.ORE, Rarity.UNCOMMON, Grade.THREE, 70L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 16L),
                                                        new ResourceMaterial(3, Material.BATTLESHIP_PARTS, Grade.THREE, 130L)
                                                )
                                        ),
                                        new Component(6, ComponentName.PHOTON_TORPEDO,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 5191L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 562L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 1_250_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 16_750L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.ORE, Rarity.UNCOMMON, Grade.THREE, 54L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 12L),
                                                        new ResourceMaterial(3, Material.BATTLESHIP_PARTS, Grade.THREE, 110L)
                                                )
                                        )
                                )
                        ),
                        new Tier(5, 513_000, 28_002,
                                addShipLevels(
                                        new Level(21, 29_000, 30,
                                                new Scrap(653_220, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 2_175_250L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 150_204L),
                                                        new ResourceMaterial(3, Material.ORE, Rarity.COMMON, Grade.THREE, 357L),
                                                        new ResourceMaterial(4, Material.ORE, Rarity.UNCOMMON, Grade.THREE, 60L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 193L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 33L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 6096L),
                                                        new ResourceMaterial(8, Material.BATTLESHIP_PARTS, Grade.THREE, 148L)
                                                ))
                                        ),
                                        new Level(22, 31_500, 31,
                                                new Scrap(653_220, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 2_175_250L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 150_204L),
                                                        new ResourceMaterial(3, Material.ORE, Rarity.COMMON, Grade.THREE, 383L),
                                                        new ResourceMaterial(4, Material.ORE, Rarity.UNCOMMON, Grade.THREE, 64L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 207L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 35L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 7041L),
                                                        new ResourceMaterial(8, Material.BATTLESHIP_PARTS, Grade.THREE, 160L)
                                                ))
                                        ),
                                        new Level(23, 36_000, 32,
                                                new Scrap(653_220, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 2_175_250L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 150_204L),
                                                        new ResourceMaterial(3, Material.ORE, Rarity.COMMON, Grade.THREE, 435L),
                                                        new ResourceMaterial(4, Material.ORE, Rarity.UNCOMMON, Grade.THREE, 73L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 234L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 39L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 8121L),
                                                        new ResourceMaterial(8, Material.BATTLESHIP_PARTS, Grade.THREE, 184L)
                                                ))
                                        ),
                                        new Level(24, 39_000, 33,
                                                new Scrap(653_220, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 2_175_250L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 150_204L),
                                                        new ResourceMaterial(3, Material.ORE, Rarity.COMMON, Grade.THREE, 499L),
                                                        new ResourceMaterial(4, Material.ORE, Rarity.UNCOMMON, Grade.THREE, 84L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 269L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 45L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 9291L),
                                                        new ResourceMaterial(8, Material.BATTLESHIP_PARTS, Grade.THREE, 214L)
                                                ))
                                        ),
                                        new Level(25, 42_000, 34,
                                                new Scrap(653_220, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 2_175_250L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 150_204L),
                                                        new ResourceMaterial(3, Material.ORE, Rarity.COMMON, Grade.THREE, 590L),
                                                        new ResourceMaterial(4, Material.ORE, Rarity.UNCOMMON, Grade.THREE, 99L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 318L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 53L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 10_551L),
                                                        new ResourceMaterial(8, Material.BATTLESHIP_PARTS, Grade.THREE, 255L)
                                                ))
                                        )
                                ),
                                addComponents(
                                        new Component(1, ComponentName.WARP_ENGINES,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 2643L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 82_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 275L),
                                                        new ResourceMaterial(2, Material.BATTLESHIP_PARTS, Grade.THREE, 110L)
                                                )
                                        ),
                                        new Component(2, ComponentName.CARGO_BAY,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 10_000L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 1_150_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.ORE, Rarity.COMMON, Grade.THREE, 425L),
                                                        new ResourceMaterial(2, Material.BATTLESHIP_PARTS, Grade.THREE, 36L)
                                                )
                                        ),
                                        new Component(3, ComponentName.TRITANIUM_ARMOR,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 30_000L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 2_300_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.ORE, Rarity.UNCOMMON, Grade.THREE, 110L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 16L),
                                                        new ResourceMaterial(3, Material.BATTLESHIP_PARTS, Grade.THREE, 140L)
                                                )
                                        ),
                                        new Component(4, ComponentName.PHASER_CANNON,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 10_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 2936L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 1_150_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 164_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.ORE, Rarity.UNCOMMON, Grade.THREE, 130L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 32L),
                                                        new ResourceMaterial(3, Material.BATTLESHIP_PARTS, Grade.THREE, 220L)
                                                )
                                        ),
                                        new Component(5, ComponentName.PHASER_CANNON,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 10_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 2936L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 1_150_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 164_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.ORE, Rarity.UNCOMMON, Grade.THREE, 130L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 32L),
                                                        new ResourceMaterial(3, Material.BATTLESHIP_PARTS, Grade.THREE, 220L)
                                                )
                                        ),
                                        new Component(6, ComponentName.PHOTON_TORPEDO,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 8505L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 881L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 2_300_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 32_500L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.ORE, Rarity.UNCOMMON, Grade.THREE, 110L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 24L),
                                                        new ResourceMaterial(3, Material.BATTLESHIP_PARTS, Grade.THREE, 180L)
                                                )
                                        )
                                )
                        ),
                        new Tier(6, 684_000, 32_998,
                                addShipLevels(
                                        new Level(26, 47_000, 35,
                                                new Scrap(707_640, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 3_789_027L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 293_419L),
                                                        new ResourceMaterial(3, Material.ORE, Rarity.COMMON, Grade.THREE, 405L),
                                                        new ResourceMaterial(4, Material.ORE, Rarity.UNCOMMON, Grade.THREE, 114L),
                                                        new ResourceMaterial(5, Material.ORE, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 219L),
                                                        new ResourceMaterial(7, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 62L),
                                                        new ResourceMaterial(8, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(9, Material.SHIP_XP, 10_964L),
                                                        new ResourceMaterial(10, Material.BATTLESHIP_PARTS, 267L)
                                                ))
                                        ),
                                        new Level(27, 51_000, 36,
                                                new Scrap(707_640, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 3_789_027L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 293_419L),
                                                        new ResourceMaterial(3, Material.ORE, Rarity.COMMON, Grade.THREE, 433L),
                                                        new ResourceMaterial(4, Material.ORE, Rarity.UNCOMMON, Grade.THREE, 122L),
                                                        new ResourceMaterial(5, Material.ORE, Rarity.RARE, Grade.THREE, 2L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 233L),
                                                        new ResourceMaterial(7, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 66L),
                                                        new ResourceMaterial(8, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(9, Material.SHIP_XP, 12_367L),
                                                        new ResourceMaterial(10, Material.BATTLESHIP_PARTS, 288L)
                                                ))
                                        ),
                                        new Level(28, 57_000, 37,
                                                new Scrap(707_640, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 3_789_027L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 293_419L),
                                                        new ResourceMaterial(3, Material.ORE, Rarity.COMMON, Grade.THREE, 488L),
                                                        new ResourceMaterial(4, Material.ORE, Rarity.UNCOMMON, Grade.THREE, 138L),
                                                        new ResourceMaterial(5, Material.ORE, Rarity.RARE, Grade.THREE, 2L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 263L),
                                                        new ResourceMaterial(7, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 74L),
                                                        new ResourceMaterial(8, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(9, Material.SHIP_XP, 13_934L),
                                                        new ResourceMaterial(10, Material.BATTLESHIP_PARTS, 332L)
                                                ))
                                        ),
                                        new Level(29, 61_000, 38,
                                                new Scrap(707_640, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 3_789_027L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 293_419L),
                                                        new ResourceMaterial(3, Material.ORE, Rarity.COMMON, Grade.THREE, 557L),
                                                        new ResourceMaterial(4, Material.ORE, Rarity.UNCOMMON, Grade.THREE, 157L),
                                                        new ResourceMaterial(5, Material.ORE, Rarity.RARE, Grade.THREE, 2L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 300L),
                                                        new ResourceMaterial(7, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 85L),
                                                        new ResourceMaterial(8, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(9, Material.SHIP_XP, 15612L),
                                                        new ResourceMaterial(10, Material.BATTLESHIP_PARTS, 386L)
                                                ))
                                        ),
                                        new Level(30, 69_000, 40,
                                                new Scrap(707_640, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 3_789_027L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 293_419L),
                                                        new ResourceMaterial(3, Material.ORE, Rarity.COMMON, Grade.THREE, 653L),
                                                        new ResourceMaterial(4, Material.ORE, Rarity.UNCOMMON, Grade.THREE, 184L),
                                                        new ResourceMaterial(5, Material.ORE, Rarity.RARE, Grade.THREE, 2L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 352L),
                                                        new ResourceMaterial(7, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 99L),
                                                        new ResourceMaterial(8, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(9, Material.SHIP_XP, 17_509L),
                                                        new ResourceMaterial(10, Material.BATTLESHIP_PARTS, 461L)
                                                ))
                                        )
                                ),
                                addComponents(
                                        new Component(1, ComponentName.WARP_ENGINES,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 4610L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 164_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 58L),
                                                        new ResourceMaterial(2, Material.BATTLESHIP_PARTS, Grade.THREE, 220L)
                                                )
                                        ),
                                        new Component(2, ComponentName.CARGO_BAY,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 17_000L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 2_050_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.ORE, Rarity.COMMON, Grade.THREE, 850L),
                                                        new ResourceMaterial(2, Material.BATTLESHIP_PARTS, Grade.THREE, 70L)
                                                )
                                        ),
                                        new Component(3, ComponentName.TRITANIUM_ARMOR,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 53_000L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 4_150_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.ORE, Rarity.UNCOMMON, Grade.THREE, 250L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 39),
                                                        new ResourceMaterial(3, Material.BATTLESHIP_PARTS, Grade.THREE, 300L)
                                                )
                                        ),
                                        new Component(4, ComponentName.PHASER_CANNON,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 17_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 5122L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 2_050_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 325_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.ORE, Rarity.RARE, Grade.THREE, 3L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(3, Material.BATTLESHIP_PARTS, Grade.THREE, 425L)
                                                )
                                        ),
                                        new Component(5, ComponentName.PHASER_CANNON,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 17_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 5122L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 2_050_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 325_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.ORE, Rarity.RARE, Grade.THREE, 3L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(3, Material.BATTLESHIP_PARTS, Grade.THREE, 425L)
                                                )
                                        ),
                                        new Component(6, ComponentName.PHOTON_TORPEDO,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 14_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 1537L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 4_150_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 65_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.ORE, Rarity.UNCOMMON, Grade.THREE, 250L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 58L),
                                                        new ResourceMaterial(3, Material.BATTLESHIP_PARTS, Grade.THREE, 350L)
                                                )
                                        )
                                )
                        ),
                        new Tier(7, 855_000, 38_880,
                                addShipLevels(
                                        new Level(31, 72_000, 41,
                                                new Scrap(762_120, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 7_612_801L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 655_749L),
                                                        new ResourceMaterial(3, Material.ORE, Rarity.COMMON, Grade.THREE, 432L),
                                                        new ResourceMaterial(4, Material.ORE, Rarity.UNCOMMON, Grade.THREE, 194L),
                                                        new ResourceMaterial(5, Material.ORE, Rarity.RARE, Grade.THREE, 4L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 233L),
                                                        new ResourceMaterial(7, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 105L),
                                                        new ResourceMaterial(8, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 2L),
                                                        new ResourceMaterial(9, Material.SHIP_XP, 17_718L),
                                                        new ResourceMaterial(10, Material.BATTLESHIP_PARTS, Grade.THREE, 490L)
                                                ))
                                        ),
                                        new Level(32, 81_000, 42,
                                                new Scrap(762_120, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 7_612_801L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 655_749L),
                                                        new ResourceMaterial(3, Material.ORE, Rarity.COMMON, Grade.THREE, 472L),
                                                        new ResourceMaterial(4, Material.ORE, Rarity.UNCOMMON, Grade.THREE, 213L),
                                                        new ResourceMaterial(5, Material.ORE, Rarity.RARE, Grade.THREE, 4L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 254L),
                                                        new ResourceMaterial(7, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 115L),
                                                        new ResourceMaterial(8, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 2L),
                                                        new ResourceMaterial(9, Material.SHIP_XP, 19_743L),
                                                        new ResourceMaterial(10, Material.BATTLESHIP_PARTS, Grade.THREE, 538L)
                                                ))
                                        ),
                                        new Level(33, 86_000, 43,
                                                new Scrap(762_120, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 7_612_801L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 655_749L),
                                                        new ResourceMaterial(3, Material.ORE, Rarity.COMMON, Grade.THREE, 552L),
                                                        new ResourceMaterial(4, Material.ORE, Rarity.UNCOMMON, Grade.THREE, 249L),
                                                        new ResourceMaterial(5, Material.ORE, Rarity.RARE, Grade.THREE, 5L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 297L),
                                                        new ResourceMaterial(7, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 134L),
                                                        new ResourceMaterial(8, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 3L),
                                                        new ResourceMaterial(9, Material.SHIP_XP, 21_893L),
                                                        new ResourceMaterial(10, Material.BATTLESHIP_PARTS, Grade.THREE, 633L)
                                                ))
                                        ),
                                        new Level(34, 95_000, 44,
                                                new Scrap(762_120, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 7_612_801L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 655_749L),
                                                        new ResourceMaterial(3, Material.ORE, Rarity.COMMON, Grade.THREE, 652L),
                                                        new ResourceMaterial(4, Material.ORE, Rarity.UNCOMMON, Grade.THREE, 294L),
                                                        new ResourceMaterial(5, Material.ORE, Rarity.RARE, Grade.THREE, 5L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 351L),
                                                        new ResourceMaterial(7, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 158L),
                                                        new ResourceMaterial(8, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 3L),
                                                        new ResourceMaterial(9, Material.SHIP_XP, 24_268L),
                                                        new ResourceMaterial(10, Material.BATTLESHIP_PARTS, Grade.THREE, 752L)
                                                ))
                                        ),
                                        new Level(35, 100_000, 45,
                                                new Scrap(762_120, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 7_612_801L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 655_749L),
                                                        new ResourceMaterial(3, Material.ORE, Rarity.COMMON, Grade.THREE, 792L),
                                                        new ResourceMaterial(4, Material.ORE, Rarity.UNCOMMON, Grade.THREE, 357L),
                                                        new ResourceMaterial(5, Material.ORE, Rarity.RARE, Grade.THREE, 6L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 427L),
                                                        new ResourceMaterial(7, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 192L),
                                                        new ResourceMaterial(8, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 4L),
                                                        new ResourceMaterial(9, Material.SHIP_XP, 26_768L),
                                                        new ResourceMaterial(10, Material.BATTLESHIP_PARTS, Grade.THREE, 919L)
                                                ))
                                        )
                                ),
                                addComponents(
                                        new Component(1, ComponentName.WARP_ENGINES,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 8010L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 425_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 140L),
                                                        new ResourceMaterial(2, Material.BATTLESHIP_PARTS, Grade.THREE, 475L)
                                                )
                                        ),
                                        new Component(2, ComponentName.CARGO_BAY,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 30_000L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 5_100_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.ORE, Rarity.COMMON, Grade.THREE, 2000L),
                                                        new ResourceMaterial(2, Material.BATTLESHIP_PARTS, Grade.THREE, 160L)
                                                )
                                        ),
                                        new Component(3, ComponentName.TRITANIUM_ARMOR,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 90_000L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 10_200_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.ORE, Rarity.UNCOMMON, Grade.THREE, 600L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 90L),
                                                        new ResourceMaterial(3, Material.BATTLESHIP_PARTS, Grade.THREE, 650L)
                                                )
                                        ),
                                        new Component(4, ComponentName.PHASER_CANNON,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 30_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 8900L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 5_100_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 850_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.ORE, Rarity.RARE, Grade.THREE, 12L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 3L),
                                                        new ResourceMaterial(3, Material.BATTLESHIP_PARTS, Grade.THREE, 975L)
                                                )
                                        ),
                                        new Component(5, ComponentName.PHASER_CANNON,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 30_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 8900L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 5_100_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 850_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.ORE, Rarity.RARE, Grade.THREE, 12L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 3L),
                                                        new ResourceMaterial(3, Material.BATTLESHIP_PARTS, Grade.THREE, 975L)
                                                )
                                        ),
                                        new Component(6, ComponentName.PHOTON_TORPEDO,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 25_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 2670L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 10_200_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 170_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.ORE, Rarity.RARE, Grade.THREE, 10L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 2L),
                                                        new ResourceMaterial(3, Material.BATTLESHIP_PARTS, Grade.THREE, 800L)
                                                )
                                        )
                                )
                        ),
                        new Tier(8, 1_111_500, 46_494,
                                addShipLevels(
                                        new Level(36, 105_000, 46,
                                                new Scrap(816_540, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 13_853_762L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 1_283_141L),
                                                        new ResourceMaterial(3, Material.ORE, Rarity.COMMON, Grade.THREE, 332L),
                                                        new ResourceMaterial(4, Material.ORE, Rarity.UNCOMMON, Grade.THREE, 373L),
                                                        new ResourceMaterial(5, Material.ORE, Rarity.RARE, Grade.THREE, 10L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 179L),
                                                        new ResourceMaterial(7, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 201L),
                                                        new ResourceMaterial(8, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 6L),
                                                        new ResourceMaterial(9, Material.SHIP_XP, 26_453L),
                                                        new ResourceMaterial(10, Material.BATTLESHIP_PARTS, Grade.THREE, 964L)
                                                ))
                                        ),
                                        new Level(37, 116_000, 48,
                                                new Scrap(816_540, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 13_853_762L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 1_283_141L),
                                                        new ResourceMaterial(3, Material.ORE, Rarity.COMMON, Grade.THREE, 360L),
                                                        new ResourceMaterial(4, Material.ORE, Rarity.UNCOMMON, Grade.THREE, 405L),
                                                        new ResourceMaterial(5, Material.ORE, Rarity.RARE, Grade.THREE, 11L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 194L),
                                                        new ResourceMaterial(7, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 218L),
                                                        new ResourceMaterial(8, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 6L),
                                                        new ResourceMaterial(9, Material.SHIP_XP, 29_063L),
                                                        new ResourceMaterial(10, Material.BATTLESHIP_PARTS, Grade.THREE, 1049L)
                                                ))
                                        ),
                                        new Level(38, 122_000, 49,
                                                new Scrap(816_540, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 13_853_762L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 1_283_141L),
                                                        new ResourceMaterial(3, Material.ORE, Rarity.COMMON, Grade.THREE, 417L),
                                                        new ResourceMaterial(4, Material.ORE, Rarity.UNCOMMON, Grade.THREE, 469L),
                                                        new ResourceMaterial(5, Material.ORE, Rarity.RARE, Grade.THREE, 12L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 225L),
                                                        new ResourceMaterial(7, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 253L),
                                                        new ResourceMaterial(8, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 7L),
                                                        new ResourceMaterial(9, Material.SHIP_XP, 31_808L),
                                                        new ResourceMaterial(10, Material.BATTLESHIP_PARTS, Grade.THREE, 1218L)
                                                ))
                                        ),
                                        new Level(39, 134_000, 50,
                                                new Scrap(816_540, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 13_853_762L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 1_283_141L),
                                                        new ResourceMaterial(3, Material.ORE, Rarity.COMMON, Grade.THREE, 488L),
                                                        new ResourceMaterial(4, Material.ORE, Rarity.UNCOMMON, Grade.THREE, 549L),
                                                        new ResourceMaterial(5, Material.ORE, Rarity.RARE, Grade.THREE, 14L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 263L),
                                                        new ResourceMaterial(7, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 296L),
                                                        new ResourceMaterial(8, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 8L),
                                                        new ResourceMaterial(9, Material.SHIP_XP, 34_823L),
                                                        new ResourceMaterial(10, Material.BATTLESHIP_PARTS, Grade.THREE, 1430L)
                                                ))
                                        ),
                                        new Level(40, 140_000, 51,
                                                new Scrap(816_540, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 13_853_762L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 1_283_141L),
                                                        new ResourceMaterial(3, Material.ORE, Rarity.COMMON, Grade.THREE, 588L),
                                                        new ResourceMaterial(4, Material.ORE, Rarity.UNCOMMON, Grade.THREE, 661L),
                                                        new ResourceMaterial(5, Material.ORE, Rarity.RARE, Grade.THREE, 17L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 317L),
                                                        new ResourceMaterial(7, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 356L),
                                                        new ResourceMaterial(8, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 9L),
                                                        new ResourceMaterial(9, Material.SHIP_XP, 37_973L),
                                                        new ResourceMaterial(10, Material.BATTLESHIP_PARTS, Grade.THREE, 1726L)
                                                ))
                                        )
                                ),
                                addComponents(
                                        new Component(1, ComponentName.WARP_ENGINES,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 14_000L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 770_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 300L),
                                                        new ResourceMaterial(2, Material.BATTLESHIP_PARTS, Grade.THREE, 900L)
                                                )
                                        ),
                                        new Component(2, ComponentName.CARGO_BAY,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 52_000L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 8_950_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.ORE, Rarity.UNCOMMON, Grade.THREE, 325L),
                                                        new ResourceMaterial(2, Material.BATTLESHIP_PARTS, Grade.THREE, 300L)
                                                )
                                        ),
                                        new Component(3, ComponentName.TRITANIUM_ARMOR,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 156_000L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 17_900_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.ORE, Rarity.RARE, Grade.THREE, 23L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 3L),
                                                        new ResourceMaterial(3, Material.BATTLESHIP_PARTS, Grade.THREE, 1200L)
                                                )
                                        ),
                                        new Component(4, ComponentName.PHASER_CANNON,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 52_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 16_000L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 8_950_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 1_550_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.ORE, Rarity.RARE, Grade.THREE, 28L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 7L),
                                                        new ResourceMaterial(3, Material.BATTLESHIP_PARTS, Grade.THREE, 1800L)
                                                )
                                        ),
                                        new Component(5, ComponentName.PHASER_CANNON,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 52_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 16_000L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 8_950_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 1_550_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.ORE, Rarity.RARE, Grade.THREE, 28L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 7L),
                                                        new ResourceMaterial(3, Material.BATTLESHIP_PARTS, Grade.THREE, 1800L)
                                                )
                                        ),
                                        new Component(6, ComponentName.PHOTON_TORPEDO,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 43_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 4866L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 17_900_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 305_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.ORE, Rarity.RARE, Grade.THREE, 23L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 5L),
                                                        new ResourceMaterial(3, Material.BATTLESHIP_PARTS, Grade.THREE, 1500L)
                                                )
                                        )
                                )
                        ),
                        new Tier(9, 1_368_000, 54_066,
                                addShipLevels(
                                        new Level(41, 154_000, 52,
                                                new Scrap(870_960, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 22_986_600L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 2_245_346L),
                                                        new ResourceMaterial(3, Material.ORE, Rarity.UNCOMMON, Grade.THREE, 606L),
                                                        new ResourceMaterial(4, Material.ORE, Rarity.RARE, Grade.THREE, 23L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 326L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 13L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 36_834L),
                                                        new ResourceMaterial(8, Material.BATTLESHIP_PARTS, Grade.THREE, 1773L)
                                                ))
                                        ),
                                        new Level(42, 161_000, 53,
                                                new Scrap(870_960, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 22_986_600L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 2_245_346L),
                                                        new ResourceMaterial(3, Material.ORE, Rarity.UNCOMMON, Grade.THREE, 650L),
                                                        new ResourceMaterial(4, Material.ORE, Rarity.RARE, Grade.THREE, 25L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 350L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 14L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 40_054L),
                                                        new ResourceMaterial(8, Material.BATTLESHIP_PARTS, Grade.THREE, 1898L)
                                                ))
                                        ),
                                        new Level(43, 176_000, 54,
                                                new Scrap(870_960, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 22_986_600L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 2_245_346L),
                                                        new ResourceMaterial(3, Material.ORE, Rarity.UNCOMMON, Grade.THREE, 739L),
                                                        new ResourceMaterial(4, Material.ORE, Rarity.RARE, Grade.THREE, 28L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 398L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 15L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 43_574L),
                                                        new ResourceMaterial(8, Material.BATTLESHIP_PARTS, Grade.THREE, 2147L)
                                                ))
                                        ),
                                        new Level(44, 183_000, 56,
                                                new Scrap(870_960, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 22_986_600L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 2_245_346L),
                                                        new ResourceMaterial(3, Material.ORE, Rarity.UNCOMMON, Grade.THREE, 849L),
                                                        new ResourceMaterial(4, Material.ORE, Rarity.RARE, Grade.THREE, 32L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 458L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 18L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 47_234L),
                                                        new ResourceMaterial(8, Material.BATTLESHIP_PARTS, Grade.THREE, 2458L)
                                                ))
                                        ),
                                        new Level(45, 200_000, 60,
                                                new Scrap(870_960, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 22_986_600L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 2_245_346L),
                                                        new ResourceMaterial(3, Material.ORE, Rarity.UNCOMMON, Grade.THREE, 1004L),
                                                        new ResourceMaterial(4, Material.ORE, Rarity.RARE, Grade.THREE, 38L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 541L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 21L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 51_234L),
                                                        new ResourceMaterial(8, Material.BATTLESHIP_PARTS, Grade.THREE, 2894L)
                                                ))
                                        )
                                ),
                                addComponents(
                                        new Component(1, ComponentName.WARP_ENGINES,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 28_000L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 1_250_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 9L),
                                                        new ResourceMaterial(2, Material.BATTLESHIP_PARTS, Grade.THREE, 1350L)
                                                )
                                        ),
                                        new Component(2, ComponentName.CARGO_BAY,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 90_000L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 14_200_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.ORE, Rarity.UNCOMMON, Grade.THREE, 525L),
                                                        new ResourceMaterial(2, Material.BATTLESHIP_PARTS, Grade.THREE, 450L)
                                                )
                                        ),
                                        new Component(3, ComponentName.TRITANIUM_ARMOR,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 272_000L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 28_400_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.ORE, Rarity.RARE, Grade.THREE, 39L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 6L),
                                                        new ResourceMaterial(3, Material.BATTLESHIP_PARTS, Grade.THREE, 1800L)
                                                )
                                        ),
                                        new Component(4, ComponentName.PHASER_CANNON,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 90_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 31_000L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 14_200_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 2_500_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.ORE, Rarity.RARE, Grade.THREE, 49L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 12L),
                                                        new ResourceMaterial(3, Material.BATTLESHIP_PARTS, Grade.THREE, 2700L)
                                                )
                                        ),
                                        new Component(5, ComponentName.PHASER_CANNON,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 90_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 31_000L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 14_200_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 2_500_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.ORE, Rarity.RARE, Grade.THREE, 49L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 12L),
                                                        new ResourceMaterial(3, Material.BATTLESHIP_PARTS, Grade.THREE, 2700L)
                                                )
                                        ),
                                        new Component(6, ComponentName.PHOTON_TORPEDO,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 75_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 9576L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 28_400_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 505_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.ORE, Rarity.RARE, Grade.THREE, 39L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 9L),
                                                        new ResourceMaterial(3, Material.BATTLESHIP_PARTS, Grade.THREE, 2300L)
                                                )
                                        )
                                )
                        )
                )
        );
    }

    private Ship getRealta() {
        return new Ship(
                "Realta",
                Rarity.COMMON,
                Grade.ONE,
                ShipClass.EXPLORER,
                img(R.drawable.realta),
                0,
                "Enhanced Shield",
                0,
                -1,
                addTiers(
                        new Tier(1, 2400, 240,
                                addShipLevels(
                                        new Level(1, 0, 10,
                                                new Scrap(6480, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 225L)
                                                ))
                                        ),
                                        new Level(2, 4, 15,
                                                new Scrap(6480, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 225L),
                                                        new ResourceMaterial(2, Material.SHIP_XP, 1L)
                                                ))
                                        ),
                                        new Level(3, 6, 20,
                                                new Scrap(6480, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 225L),
                                                        new ResourceMaterial(2, Material.SHIP_XP, 3L)
                                                ))
                                        ),
                                        new Level(4, 8, 25,
                                                new Scrap(6480, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 225L),
                                                        new ResourceMaterial(2, Material.SHIP_XP, 5L)
                                                ))
                                        ),
                                        new Level(5, 12, 30,
                                                new Scrap(6480, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 225L),
                                                        new ResourceMaterial(2, Material.SHIP_XP, 9L)
                                                ))
                                        )
                                ),
                                addComponents(
                                        new Component(1, ComponentName.BUILD_SHIP_TOTAL)
                                )
                        ),
                        new Tier(2, 300, 300,
                                addShipLevels(
                                        new Level(6, 16, 35,
                                                new Scrap(8640, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 261L),
                                                        new ResourceMaterial(2, Material.GAS, Rarity.COMMON, Grade.TWO, 1L),
                                                        new ResourceMaterial(3, Material.ORE, Rarity.COMMON, Grade.TWO, 1L),
                                                        new ResourceMaterial(4, Material.SHIP_XP, 12L),
                                                        new ResourceMaterial(5, Material.EXPLORER_PARTS, Grade.TWO, 1L)
                                                ))
                                        ),
                                        new Level(7, 22, 40,
                                                new Scrap(8640, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 261L),
                                                        new ResourceMaterial(2, Material.GAS, Rarity.COMMON, Grade.TWO, 1L),
                                                        new ResourceMaterial(3, Material.ORE, Rarity.COMMON, Grade.TWO, 1L),
                                                        new ResourceMaterial(4, Material.SHIP_XP, 17L),
                                                        new ResourceMaterial(5, Material.EXPLORER_PARTS, Grade.TWO, 1L)
                                                ))
                                        ),
                                        new Level(8, 40, 45,
                                                new Scrap(8640, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 261L),
                                                        new ResourceMaterial(2, Material.GAS, Rarity.COMMON, Grade.TWO, 1L),
                                                        new ResourceMaterial(3, Material.ORE, Rarity.COMMON, Grade.TWO, 1L),
                                                        new ResourceMaterial(4, Material.SHIP_XP, 27L),
                                                        new ResourceMaterial(5, Material.EXPLORER_PARTS, Grade.TWO, 1L)
                                                ))
                                        ),
                                        new Level(9, 45, 50,
                                                new Scrap(8640, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 261L),
                                                        new ResourceMaterial(2, Material.GAS, Rarity.COMMON, Grade.TWO, 1L),
                                                        new ResourceMaterial(3, Material.ORE, Rarity.COMMON, Grade.TWO, 1L),
                                                        new ResourceMaterial(4, Material.SHIP_XP, 38L),
                                                        new ResourceMaterial(5, Material.EXPLORER_PARTS, Grade.TWO, 1L)
                                                ))
                                        ),
                                        new Level(10, 80, 55,
                                                new Scrap(8640, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 261L),
                                                        new ResourceMaterial(2, Material.GAS, Rarity.COMMON, Grade.TWO, 1L),
                                                        new ResourceMaterial(3, Material.ORE, Rarity.COMMON, Grade.TWO, 1L),
                                                        new ResourceMaterial(4, Material.SHIP_XP, 58L),
                                                        new ResourceMaterial(5, Material.EXPLORER_PARTS, Grade.TWO, 1L)
                                                ))
                                        )
                                ),
                                addComponents(
                                        new Component(1, ComponentName.WARP_ENGINES,
                                                setEmpty(),
                                                setEmpty(),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.EXPLORER_PARTS, Grade.ONE, 1L)
                                                )
                                        ),
                                        new Component(2, ComponentName.SHIELD,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.PARSTEEL, 7L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 30L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.EXPLORER_PARTS, Grade.ONE, 2L)
                                                )
                                        ),
                                        new Component(3, ComponentName.PHASER_CANNON,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.PARSTEEL, 8L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 30L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.EXPLORER_PARTS, Grade.ONE, 3L)
                                                )
                                        ),
                                        new Component(4, ComponentName.PHASER_CANNON,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.PARSTEEL, 8L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 30L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.EXPLORER_PARTS, Grade.ONE, 3L)
                                                )
                                        )
                                )
                        ),
                        new Tier(3, 600, 378,
                                addShipLevels(
                                        new Level(11, 90, 60,
                                                new Scrap(10_800, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 345L),
                                                        new ResourceMaterial(2, Material.GAS, Rarity.COMMON, Grade.TWO, 1L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.UNCOMMON, Grade.TWO, 1L),
                                                        new ResourceMaterial(4, Material.ORE, Rarity.COMMON, Grade.TWO, 1L),
                                                        new ResourceMaterial(5, Material.ORE, Rarity.UNCOMMON, Grade.TWO, 1L),
                                                        new ResourceMaterial(6, Material.SHIP_XP, 73L),
                                                        new ResourceMaterial(7, Material.EXPLORER_PARTS, Grade.TWO, 1L)
                                                ))
                                        ),
                                        new Level(12, 140, 65,
                                                new Scrap(10_8000, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 345L),
                                                        new ResourceMaterial(2, Material.GAS, Rarity.COMMON, Grade.TWO, 2L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.UNCOMMON, Grade.TWO, 1L),
                                                        new ResourceMaterial(4, Material.ORE, Rarity.COMMON, Grade.TWO, 1L),
                                                        new ResourceMaterial(5, Material.ORE, Rarity.UNCOMMON, Grade.TWO, 1L),
                                                        new ResourceMaterial(6, Material.SHIP_XP, 104L),
                                                        new ResourceMaterial(7, Material.EXPLORER_PARTS, Grade.TWO, 1L)
                                                ))
                                        ),
                                        new Level(13, 150, 70,
                                                new Scrap(10_800, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 345L),
                                                        new ResourceMaterial(2, Material.GAS, Rarity.COMMON, Grade.TWO, 2L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.UNCOMMON, Grade.TWO, 1L),
                                                        new ResourceMaterial(4, Material.ORE, Rarity.COMMON, Grade.TWO, 1L),
                                                        new ResourceMaterial(5, Material.ORE, Rarity.UNCOMMON, Grade.TWO, 1L),
                                                        new ResourceMaterial(6, Material.SHIP_XP, 138L),
                                                        new ResourceMaterial(7, Material.EXPLORER_PARTS, Grade.TWO, 2L)
                                                ))
                                        ),
                                        new Level(14, 230, 75,
                                                new Scrap(10_800, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 345L),
                                                        new ResourceMaterial(2, Material.GAS, Rarity.COMMON, Grade.TWO, 2L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.UNCOMMON, Grade.TWO, 1L),
                                                        new ResourceMaterial(4, Material.ORE, Rarity.COMMON, Grade.TWO, 2L),
                                                        new ResourceMaterial(5, Material.ORE, Rarity.UNCOMMON, Grade.TWO, 1L),
                                                        new ResourceMaterial(6, Material.SHIP_XP, 190L),
                                                        new ResourceMaterial(7, Material.EXPLORER_PARTS, Grade.TWO, 2L)
                                                ))
                                        ),
                                        new Level(15, 250, 85,
                                                new Scrap(10_800, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 345L),
                                                        new ResourceMaterial(2, Material.GAS, Rarity.COMMON, Grade.TWO, 3L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.UNCOMMON, Grade.TWO, 1L),
                                                        new ResourceMaterial(4, Material.ORE, Rarity.COMMON, Grade.TWO, 2L),
                                                        new ResourceMaterial(5, Material.ORE, Rarity.UNCOMMON, Grade.TWO, 1L),
                                                        new ResourceMaterial(6, Material.SHIP_XP, 246L),
                                                        new ResourceMaterial(7, Material.EXPLORER_PARTS, Grade.TWO, 3L)
                                                ))
                                        )
                                ),
                                addComponents(
                                        new Component(1, ComponentName.WARP_ENGINES,
                                                setEmpty(),
                                                setEmpty(),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.EXPLORER_PARTS, Grade.ONE, 3L)
                                                )
                                        ),
                                        new Component(2, ComponentName.SHIELD,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.PARSTEEL, 20L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 90L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.EXPLORER_PARTS, Grade.ONE, 5L)
                                                )
                                        ),
                                        new Component(3, ComponentName.PHASER_CANNON,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.PARSTEEL, 20L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 80L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.EXPLORER_PARTS, Grade.ONE, 7L)
                                                )
                                        ),
                                        new Component(4, ComponentName.PHASER_CANNON,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.PARSTEEL, 20L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 80L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.EXPLORER_PARTS, Grade.ONE, 7L)
                                                )
                                        )
                                )
                        ),
                        new Tier(4, 1000, 498,
                                addShipLevels(
                                        new Level(16, 350, 90,
                                                new Scrap(0, addRewards(

                                                ))
                                        ),
                                        new Level(17, 500, 95,
                                                new Scrap(0, addRewards(

                                                ))
                                        ),
                                        new Level(18, 600, 100,
                                                new Scrap(0, addRewards(

                                                ))
                                        ),
                                        new Level(19, 700, 105,
                                                new Scrap(0, addRewards(

                                                ))
                                        ),
                                        new Level(20, 0, 110,
                                                new Scrap(0, addRewards(

                                                ))
                                        )
                                ),
                                addComponents(
                                        new Component(1, ComponentName.WARP_ENGINES,
                                                setEmpty(),
                                                setEmpty(),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.EXPLORER_PARTS, Grade.ONE, 7L)
                                                )
                                        ),
                                        new Component(2, ComponentName.SHIELD,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.PARSTEEL, 35L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 150L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.EXPLORER_PARTS, Grade.ONE, 14L)
                                                )
                                        ),
                                        new Component(3, ComponentName.PHASER_CANNON,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.PARSTEEL, 40L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 180L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.EXPLORER_PARTS, Grade.ONE, 21L)
                                                )
                                        ),
                                        new Component(4, ComponentName.PHASER_CANNON,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.PARSTEEL, 40L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 180L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.EXPLORER_PARTS, Grade.ONE, 21L)
                                                )
                                        )
                                )
                        )
                )
        );
    }

    private Ship getEcsFortunate() {
        return new Ship(
                "ECS Fortunate",
                Rarity.COMMON,
                Grade.ONE,
                ShipClass.SURVEY,
                img(R.drawable.ecs_fortunate),
                0,
                "Parsteel Mining Laser",
                7,
                20,
                addTiers(
                        new Tier(1, 4800, 144,
                                addShipLevels(
                                        new Level(1, 0, 15,
                                                new Scrap(12_960, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 338L)
                                                ))
                                        ),
                                        new Level(2, 4, 17.5f,
                                                new Scrap(12_960, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 338L),
                                                        new ResourceMaterial(2, Material.SHIP_XP, 1L)
                                                ))
                                        ),
                                        new Level(3, 6, 20,
                                                new Scrap(12_960, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 338L),
                                                        new ResourceMaterial(2, Material.SHIP_XP, 3L)
                                                ))
                                        ),
                                        new Level(4, 8, 22.5f,
                                                new Scrap(12_960, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 338L),
                                                        new ResourceMaterial(2, Material.SHIP_XP, 5L)
                                                ))
                                        ),
                                        new Level(5, 12, 25,
                                                new Scrap(12_960, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 338L),
                                                        new ResourceMaterial(2, Material.SHIP_XP, 9L)
                                                ))
                                        )
                                ),
                                addComponents(
                                        new Component(1, ComponentName.BUILD_SHIP_TOTAL)
                                )
                        ),
                        new Tier(2, 1800, 180,
                                addShipLevels(
                                        new Level(6, 16, 28,
                                                new Scrap(17_280, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 1098L),
                                                        new ResourceMaterial(2, Material.GAS, Rarity.COMMON, Grade.TWO, 1L),
                                                        new ResourceMaterial(3, Material.CRYSTAL, Rarity.COMMON, Grade.TWO, 1L),
                                                        new ResourceMaterial(4, Material.SHIP_XP, 12L),
                                                        new ResourceMaterial(5, Material.SURVEY_PARTS, Grade.TWO, 1L)
                                                ))
                                        ),
                                        new Level(7, 22, 31,
                                                new Scrap(17_280, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 1098L),
                                                        new ResourceMaterial(2, Material.GAS, Rarity.COMMON, Grade.TWO, 1L),
                                                        new ResourceMaterial(3, Material.CRYSTAL, Rarity.COMMON, Grade.TWO, 1L),
                                                        new ResourceMaterial(4, Material.SHIP_XP, 17L),
                                                        new ResourceMaterial(5, Material.SURVEY_PARTS, Grade.TWO, 1L)
                                                ))
                                        ),
                                        new Level(8, 40, 34,
                                                new Scrap(17_280, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 1098L),
                                                        new ResourceMaterial(2, Material.GAS, Rarity.COMMON, Grade.TWO, 1L),
                                                        new ResourceMaterial(3, Material.CRYSTAL, Rarity.COMMON, Grade.TWO, 2L),
                                                        new ResourceMaterial(4, Material.SHIP_XP, 27L),
                                                        new ResourceMaterial(5, Material.SURVEY_PARTS, Grade.TWO, 1L)
                                                ))
                                        ),
                                        new Level(9, 45, 37,
                                                new Scrap(17_280, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 1098L),
                                                        new ResourceMaterial(2, Material.GAS, Rarity.COMMON, Grade.TWO, 1L),
                                                        new ResourceMaterial(3, Material.CRYSTAL, Rarity.COMMON, Grade.TWO, 2L),
                                                        new ResourceMaterial(4, Material.SHIP_XP, 38L),
                                                        new ResourceMaterial(5, Material.SURVEY_PARTS, Grade.TWO, 2L)
                                                ))
                                        ),
                                        new Level(10, 80, 40,
                                                new Scrap(17_2800, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 1098L),
                                                        new ResourceMaterial(2, Material.GAS, Rarity.COMMON, Grade.TWO, 2L),
                                                        new ResourceMaterial(3, Material.CRYSTAL, Rarity.COMMON, Grade.TWO, 2L),
                                                        new ResourceMaterial(4, Material.SHIP_XP, 58L),
                                                        new ResourceMaterial(5, Material.SURVEY_PARTS, Grade.TWO, 2L)
                                                ))
                                        )
                                ),
                                addComponents(
                                        new Component(1, ComponentName.WARP_ENGINES,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 6L)
                                                ),
                                                setEmpty(),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.SURVEY_PARTS, Grade.ONE, 2L)
                                                )
                                        ),
                                        new Component(2, ComponentName.CARGO_BAY,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 11L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 950L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.SURVEY_PARTS, Grade.ONE, 6L)
                                                )
                                        ),
                                        new Component(3, ComponentName.SHIELD,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 10L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 400L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.SURVEY_PARTS, Grade.ONE, 4L)
                                                )
                                        ),
                                        new Component(4, ComponentName.MINING_LASER,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 11L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 550L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.SURVEY_PARTS, Grade.ONE, 6L)
                                                )
                                        )
                                )
                        ),
                        new Tier(3, 3600, 246,
                                addShipLevels(
                                        new Level(11, 90, 45,
                                                new Scrap(21_600, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 3087L),
                                                        new ResourceMaterial(2, Material.GAS, Rarity.COMMON, Grade.TWO, 2L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.UNCOMMON, Grade.TWO, 1L),
                                                        new ResourceMaterial(4, Material.CRYSTAL, Rarity.COMMON, Grade.TWO, 2L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.UNCOMMON, Grade.TWO, 1L),
                                                        new ResourceMaterial(6, Material.SHIP_XP, 73L),
                                                        new ResourceMaterial(7, Material.SURVEY_PARTS, Grade.TWO, 2L)
                                                ))
                                        ),
                                        new Level(12, 140, 50,
                                                new Scrap(21_600, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 3087L),
                                                        new ResourceMaterial(2, Material.GAS, Rarity.COMMON, Grade.TWO, 2L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.UNCOMMON, Grade.TWO, 1L),
                                                        new ResourceMaterial(4, Material.CRYSTAL, Rarity.COMMON, Grade.TWO, 3L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.UNCOMMON, Grade.TWO, 1L),
                                                        new ResourceMaterial(6, Material.SHIP_XP, 104L),
                                                        new ResourceMaterial(7, Material.SURVEY_PARTS, Grade.TWO, 3L)
                                                ))
                                        ),
                                        new Level(13, 150, 55,
                                                new Scrap(21_600, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 3087L),
                                                        new ResourceMaterial(2, Material.GAS, Rarity.COMMON, Grade.TWO, 2L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.UNCOMMON, Grade.TWO, 1L),
                                                        new ResourceMaterial(4, Material.CRYSTAL, Rarity.COMMON, Grade.TWO, 4L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.UNCOMMON, Grade.TWO, 1L),
                                                        new ResourceMaterial(6, Material.SHIP_XP, 138L),
                                                        new ResourceMaterial(7, Material.SURVEY_PARTS, Grade.TWO, 3L)
                                                ))
                                        ),
                                        new Level(14, 230, 60,
                                                new Scrap(21_600, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 3087L),
                                                        new ResourceMaterial(2, Material.GAS, Rarity.COMMON, Grade.TWO, 3L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.UNCOMMON, Grade.TWO, 1L),
                                                        new ResourceMaterial(4, Material.CRYSTAL, Rarity.COMMON, Grade.TWO, 5L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.UNCOMMON, Grade.TWO, 1L),
                                                        new ResourceMaterial(6, Material.SHIP_XP, 190L),
                                                        new ResourceMaterial(7, Material.SURVEY_PARTS, Grade.TWO, 4L)
                                                ))
                                        ),
                                        new Level(15, 250, 65,
                                                new Scrap(21_600, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 3087L),
                                                        new ResourceMaterial(2, Material.GAS, Rarity.COMMON, Grade.TWO, 3L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.UNCOMMON, Grade.TWO, 1L),
                                                        new ResourceMaterial(4, Material.CRYSTAL, Rarity.COMMON, Grade.TWO, 6L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.UNCOMMON, Grade.TWO, 1L),
                                                        new ResourceMaterial(6, Material.SHIP_XP, 246L),
                                                        new ResourceMaterial(7, Material.SURVEY_PARTS, Grade.TWO, 5L)
                                                ))
                                        )
                                ),
                                addComponents(
                                        new Component(1, ComponentName.WARP_ENGINES,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 18L)
                                                ),
                                                setEmpty(),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.SURVEY_PARTS, Grade.ONE, 5L)
                                                )
                                        ),
                                        new Component(2, ComponentName.CARGO_BAY,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 35L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 3000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.SURVEY_PARTS, Grade.ONE, 15L)
                                                )
                                        ),
                                        new Component(3, ComponentName.SHIELD,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 29L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 1250L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.SURVEY_PARTS, Grade.ONE, 10L)
                                                )
                                        ),
                                        new Component(4, ComponentName.MINING_LASER,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 35L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 1700L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.SURVEY_PARTS, Grade.ONE, 15L)
                                                )
                                        )
                                )
                        ),
                        new Tier(4, 6000, 336,
                                addShipLevels(
                                        new Level(16, 350, 70,
                                                new Scrap(25_920, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 7343L),
                                                        new ResourceMaterial(2, Material.GAS, Rarity.COMMON, Grade.TWO, 3L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.UNCOMMON, Grade.TWO, 1L),
                                                        new ResourceMaterial(4, Material.CRYSTAL, Rarity.COMMON, Grade.TWO, 5L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.UNCOMMON, Grade.TWO, 1L),
                                                        new ResourceMaterial(6, Material.SHIP_XP, 289L),
                                                        new ResourceMaterial(7, Material.SURVEY_PARTS, Grade.TWO, 6L)
                                                ))
                                        ),
                                        new Level(17, 500, 75,
                                                new Scrap(25_920, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 7343L),
                                                        new ResourceMaterial(2, Material.GAS, Rarity.COMMON, Grade.TWO, 3L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.UNCOMMON, Grade.TWO, 1L),
                                                        new ResourceMaterial(4, Material.CRYSTAL, Rarity.COMMON, Grade.TWO, 6L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.UNCOMMON, Grade.TWO, 1L),
                                                        new ResourceMaterial(6, Material.SHIP_XP, 359L),
                                                        new ResourceMaterial(7, Material.SURVEY_PARTS, Grade.TWO, 7L)
                                                ))
                                        ),
                                        new Level(18, 600, 82,
                                                new Scrap(25_920, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 7343L),
                                                        new ResourceMaterial(2, Material.GAS, Rarity.COMMON, Grade.TWO, 4L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.UNCOMMON, Grade.TWO, 1L),
                                                        new ResourceMaterial(4, Material.CRYSTAL, Rarity.COMMON, Grade.TWO, 7L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.UNCOMMON, Grade.TWO, 1L),
                                                        new ResourceMaterial(6, Material.SHIP_XP, 459L),
                                                        new ResourceMaterial(7, Material.SURVEY_PARTS, Grade.TWO, 8L)
                                                ))
                                        ),
                                        new Level(19, 700, 90,
                                                new Scrap(25_920, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 7343L),
                                                        new ResourceMaterial(2, Material.GAS, Rarity.COMMON, Grade.TWO, 5L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.UNCOMMON, Grade.TWO, 1L),
                                                        new ResourceMaterial(4, Material.CRYSTAL, Rarity.COMMON, Grade.TWO, 9L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.UNCOMMON, Grade.TWO, 1L),
                                                        new ResourceMaterial(6, Material.SHIP_XP, 569L),
                                                        new ResourceMaterial(7, Material.SURVEY_PARTS, Grade.TWO, 10L)
                                                ))
                                        ),
                                        new Level(20, 0, 100,
                                                new Scrap(25_920, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 7343L),
                                                        new ResourceMaterial(2, Material.GAS, Rarity.COMMON, Grade.TWO, 6L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.UNCOMMON, Grade.TWO, 1L),
                                                        new ResourceMaterial(4, Material.CRYSTAL, Rarity.COMMON, Grade.TWO, 12L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.UNCOMMON, Grade.TWO, 2L),
                                                        new ResourceMaterial(6, Material.SHIP_XP, 709L),
                                                        new ResourceMaterial(7, Material.SURVEY_PARTS, Grade.TWO, 13L)
                                                ))
                                        )
                                ),
                                addComponents(
                                        new Component(1, ComponentName.WARP_ENGINES,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 44L)
                                                ),
                                                setEmpty(),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.SURVEY_PARTS, Grade.ONE, 12L)
                                                )
                                        ),
                                        new Component(2, ComponentName.CARGO_BAY,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 87L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 8500L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.SURVEY_PARTS, Grade.ONE, 36L)
                                                )
                                        ),
                                        new Component(3, ComponentName.SHIELD,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 73L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 3000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.SURVEY_PARTS, Grade.ONE, 24L)
                                                )
                                        ),
                                        new Component(4, ComponentName.MINING_LASER,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 87L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 4000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.SURVEY_PARTS, Grade.ONE, 36L)
                                                )
                                        )
                                )
                        )
                )
        );
    }

}