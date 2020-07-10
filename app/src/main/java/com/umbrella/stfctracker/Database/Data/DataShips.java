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

    public String img(int id) {
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
                                        new Component(1, ComponentName.BUILD_SHIP_TOTAL,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 28L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 800L)
                                                ),
                                                setEmpty()
                                        )
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
                                        new Component(1, ComponentName.BUILD_SHIP_TOTAL,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 393L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 22_000L)
                                                ),
                                                setEmpty()
                                        )
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
                                        new Component(1, ComponentName.BUILD_SHIP_TOTAL,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 22_654L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 1069L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 880_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 35_000L)
                                                ),
                                                setEmpty()
                                        )
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
                                        new Component(1, ComponentName.BUILD_SHIP_TOTAL,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.PARSTEEL, 25L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 500L)
                                                ),
                                                setEmpty()
                                        )
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
                                        new Component(1, ComponentName.BUILD_SHIP_TOTAL,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 14L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 750L)
                                                ),
                                                setEmpty()
                                        )
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

    private Ship getJelyfish() {
        return new Ship(
                "Jellyfish",
                Rarity.RARE,
                Grade.TWO,
                ShipClass.EXPLORER,
                img(R.drawable.jellyfish),
                0,
                "Pilot Recognition",
                12,
                -1,
                addTiers(
                        new Tier(1, 64_800, 3444,
                                addShipLevels(
                                        new Level(1, 0, 15),
                                        new Level(2, 130, 17),
                                        new Level(3, 150, 18),
                                        new Level(4, 180, 20),
                                        new Level(5, 250, 21)
                                ),
                                addComponents(
                                        new Component(1, ComponentName.BUILD_SHIP_TOTAL,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 585L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 60_000L)
                                                ),
                                                setEmpty()
                                        )
                                )
                        ),
                        new Tier(2, 18_000, 3942,
                                addShipLevels(
                                        new Level(6, 300, 23),
                                        new Level(7, 350, 24),
                                        new Level(8, 500, 26),
                                        new Level(9, 550, 27),
                                        new Level(10, 650, 29)
                                ),
                                addComponents(
                                        new Component(1, ComponentName.WARP_ENGINES,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 11L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 325L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.EXPLORER_PARTS, Grade.TWO, 11L)
                                                )
                                        ),
                                        new Component(2, ComponentName.CARGO_BAY,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 75L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 4500L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.EXPLORER_PARTS, Grade.TWO, 6L)
                                                )
                                        ),
                                        new Component(3, ComponentName.SHIELD,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 75L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 18L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 11_250L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.EXPLORER_PARTS, Grade.TWO, 17L)
                                                )
                                        ),
                                        new Component(4, ComponentName.PHASER_CANNON,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 112L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 18L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 6750L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 650L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.EXPLORER_PARTS, Grade.TWO, 34L)
                                                )
                                        ),
                                        new Component(5, ComponentName.PHASER_CANNON,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 112L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 18L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 6750L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 650L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.EXPLORER_PARTS, Grade.TWO, 34L)
                                                )
                                        )
                                )
                        ),
                        new Tier(3, 36_000, 4368,
                                addShipLevels(
                                        new Level(11, 700, 31),
                                        new Level(12, 900, 32),
                                        new Level(13, 1000, 34),
                                        new Level(14, 1100, 35),
                                        new Level(15, 1400, 37)
                                ),
                                addComponents(
                                        new Component(1, ComponentName.WARP_ENGINES,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 24L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 675L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.EXPLORER_PARTS, Grade.TWO, 23L)
                                                )
                                        ),
                                        new Component(2, ComponentName.CARGO_BAY,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 191L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 8000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.EXPLORER_PARTS, Grade.TWO, 11L)
                                                )
                                        ),
                                        new Component(3, ComponentName.SHIELD,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 191L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 39L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 20_500L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.EXPLORER_PARTS, Grade.TWO, 34L)
                                                )
                                        ),
                                        new Component(4, ComponentName.PHASER_CANNON,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 286L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 39L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 12_250L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 1350L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.COMMON, Grade.TWO, 300L),
                                                        new ResourceMaterial(2, Material.EXPLORER_PARTS, Grade.TWO, 70L)
                                                )
                                        ),
                                        new Component(5, ComponentName.PHASER_CANNON,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 286L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 39L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 12_250L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 1350L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.COMMON, Grade.TWO, 300L),
                                                        new ResourceMaterial(2, Material.EXPLORER_PARTS, Grade.TWO, 70L)
                                                )
                                        )
                                )
                        ),
                        new Tier(4, 60_000, 5448,
                                addShipLevels(
                                        new Level(16, 1600, 38),
                                        new Level(17, 1700, 40),
                                        new Level(18, 2100, 41),
                                        new Level(19, 2300, 43),
                                        new Level(20, 2500, 44)
                                ),
                                addComponents(
                                        new Component(1, ComponentName.WARP_ENGINES,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 50L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 1400L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.EXPLORER_PARTS, Grade.TWO, 39L)
                                                )
                                        ),
                                        new Component(2, ComponentName.CARGO_BAY,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 403L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 13_500L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.EXPLORER_PARTS, Grade.TWO, 20L)
                                                )
                                        ),
                                        new Component(3, ComponentName.SHIELD,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 403L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 83L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 34_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.COMMON, Grade.TWO, 625L),
                                                        new ResourceMaterial(2, Material.EXPLORER_PARTS, Grade.TWO, 59L)
                                                )
                                        ),
                                        new Component(4, ComponentName.PHASER_CANNON,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 604L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 83L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 20_500L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 2900L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.COMMON, Grade.TWO, 775L),
                                                        new ResourceMaterial(2, Material.EXPLORER_PARTS, Grade.TWO, 120L)
                                                )
                                        ),
                                        new Component(5, ComponentName.PHASER_CANNON,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 604L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 83L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 20_500L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 2900L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.COMMON, Grade.TWO, 775L),
                                                        new ResourceMaterial(2, Material.EXPLORER_PARTS, Grade.TWO, 120L)
                                                )
                                        )
                                )
                        ),
                        new Tier(5, 90_000, 6444,
                                addShipLevels(
                                        new Level(21, 2600, 46),
                                        new Level(22, 3200, 48),
                                        new Level(23, 3400, 49),
                                        new Level(24, 3600, 51),
                                        new Level(25, 4400, 52)
                                ),
                                addComponents(
                                        new Component(1, ComponentName.WARP_ENGINES,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 83L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 2600L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.COMMON, Grade.TWO, 575L),
                                                        new ResourceMaterial(2, Material.EXPLORER_PARTS, Grade.TWO, 70L)
                                                )
                                        ),
                                        new Component(2, ComponentName.CARGO_BAY,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 674L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 22_500L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.EXPLORER_PARTS, Grade.TWO, 34L)
                                                )
                                        ),
                                        new Component(3, ComponentName.SHIELD,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 674L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 138L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 56_600L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.COMMON, Grade.TWO, 1150L),
                                                        new ResourceMaterial(2, Material.EXPLORER_PARTS, Grade.TWO, 100L)
                                                )
                                        ),
                                        new Component(4, ComponentName.PHASER_CANNON,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 1011L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 138L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 34_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 5000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.UNCOMMON, Grade.TWO, 100L),
                                                        new ResourceMaterial(2, Material.EXPLORER_PARTS, Grade.TWO, 200L)
                                                )
                                        ),
                                        new Component(5, ComponentName.PHASER_CANNON,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 1011L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 138L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 34_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 5000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.UNCOMMON, Grade.TWO, 100L),
                                                        new ResourceMaterial(2, Material.EXPLORER_PARTS, Grade.TWO, 200L)
                                                )
                                        )
                                )
                        ),
                        new Tier(6, 120_000, 7230,
                                addShipLevels(
                                        new Level(26, 4600, 54),
                                        new Level(27, 4900, 55),
                                        new Level(28, 5000, 57),
                                        new Level(29, 6000, 58),
                                        new Level(30, 6500, 60)
                                ),
                                addComponents(
                                        new Component(1, ComponentName.WARP_ENGINES,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 176L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 5500L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.COMMON, Grade.TWO, 1150L),
                                                        new ResourceMaterial(2, Material.EXPLORER_PARTS, Grade.TWO, 140L)
                                                )
                                        ),
                                        new Component(2, ComponentName.CARGO_BAY,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 1404L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 43_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.COMMON, Grade.TWO, 575L),
                                                        new ResourceMaterial(2, Material.EXPLORER_PARTS, Grade.TWO, 70L)
                                                )
                                        ),
                                        new Component(3, ComponentName.SHIELD,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 1404L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 294L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 107_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.UNCOMMON, Grade.TWO, 180L),
                                                        new ResourceMaterial(2, Material.EXPLORER_PARTS, Grade.TWO, 200L)
                                                )
                                        ),
                                        new Component(4, ComponentName.PHASER_CANNON,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 2107L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 294L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 64_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 10_750L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.UNCOMMON, Grade.TWO, 230L),
                                                        new ResourceMaterial(2, Material.EXPLORER_PARTS, Grade.TWO, 400L)
                                                )
                                        ),
                                        new Component(5, ComponentName.PHASER_CANNON,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 2107L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 294L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 64_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 10_750L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.UNCOMMON, Grade.TWO, 230L),
                                                        new ResourceMaterial(2, Material.EXPLORER_PARTS, Grade.TWO, 400L)
                                                )
                                        )
                                )
                        ),
                        new Tier(7, 150_000, 8928,
                                addShipLevels(
                                        new Level(31, 6500, 62),
                                        new Level(32, 8000, 64),
                                        new Level(33, 8000, 66),
                                        new Level(34, 8500, 68),
                                        new Level(35, 10_000, 70)
                                ),
                                addComponents(
                                        new Component(1, ComponentName.WARP_ENGINES,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 444L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 13_500L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.UNCOMMON, Grade.TWO, 220L),
                                                        new ResourceMaterial(2, Material.EXPLORER_PARTS, Grade.TWO, 300L)
                                                )
                                        ),
                                        new Component(2, ComponentName.CARGO_BAY,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 3351L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 101_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.COMMON, Grade.TWO, 1350L),
                                                        new ResourceMaterial(2, Material.EXPLORER_PARTS, Grade.TWO, 150L)
                                                )
                                        ),
                                        new Component(3, ComponentName.SHIELD,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 3351L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 740L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 250_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.UNCOMMON, Grade.TWO, 425L),
                                                        new ResourceMaterial(2, Material.EXPLORER_PARTS, Grade.TWO, 450L)
                                                )
                                        ),
                                        new Component(4, ComponentName.PHASER_CANNON,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 5027L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 740L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 151_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 27_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.UNCOMMON, Grade.TWO, 550L),
                                                        new ResourceMaterial(2, Material.EXPLORER_PARTS, Grade.TWO, 900L)
                                                )
                                        ),
                                        new Component(5, ComponentName.PHASER_CANNON,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 5027L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 740L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 151_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 27_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.UNCOMMON, Grade.TWO, 550L),
                                                        new ResourceMaterial(2, Material.EXPLORER_PARTS, Grade.TWO, 900L)
                                                )
                                        )
                                )
                        )
                )
        );
    }

    private Ship getEnvoy() {
        return new Ship(
                "Envoy",
                Rarity.COMMON,
                Grade.TWO,
                ShipClass.SURVEY,
                img(R.drawable.envoy),
                0,
                "Tritanium Mining Laser",
                16,
                20,
                addTiers(
                        new Tier(1, 63_000, 1038,
                                addShipLevels(
                                        new Level(1, 0, 15,
                                                new Scrap(70_860, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 8400L)
                                                ))
                                        ),
                                        new Level(2, 130, 16.5f,
                                                new Scrap(70_860, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 8400L),
                                                        new ResourceMaterial(2, Material.SHIP_XP, 16L)
                                                ))
                                        ),
                                        new Level(3, 150, 18,
                                                new Scrap(70_860, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 8400L),
                                                        new ResourceMaterial(2, Material.SHIP_XP, 34L)
                                                ))
                                        ),
                                        new Level(4, 180, 19.5f,
                                                new Scrap(70_860, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 8400L),
                                                        new ResourceMaterial(2, Material.SHIP_XP, 55L)
                                                ))
                                        ),
                                        new Level(5, 250, 21,
                                                new Scrap(70_860, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 8400L),
                                                        new ResourceMaterial(2, Material.SHIP_XP, 85L)
                                                ))
                                        )
                                ),
                                addComponents(
                                        new Component(1, ComponentName.BUILD_SHIP_TOTAL,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 185L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 21_000L)
                                                ),
                                                setEmpty()
                                        )
                                )
                        ),
                        new Tier(2, 12_000, 1194,
                                addShipLevels(
                                        new Level(6, 300, 23,
                                                new Scrap(94_500, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 17_232L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 483L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 1L),
                                                        new ResourceMaterial(4, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 2L),
                                                        new ResourceMaterial(5, Material.SHIP_XP, 114L),
                                                        new ResourceMaterial(6, Material.SURVEY_PARTS, Grade.THREE, 1L)
                                                ))
                                        ),
                                        new Level(7, 350, 25,
                                                new Scrap(94_500, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 17_232L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 483L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 1L),
                                                        new ResourceMaterial(4, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 2L),
                                                        new ResourceMaterial(5, Material.SHIP_XP, 153L),
                                                        new ResourceMaterial(6, Material.SURVEY_PARTS, Grade.THREE, 2L)
                                                ))
                                        ),
                                        new Level(8, 500, 28,
                                                new Scrap(94_500, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 17_232L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 483L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 2L),
                                                        new ResourceMaterial(4, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 2L),
                                                        new ResourceMaterial(5, Material.SHIP_XP, 209L),
                                                        new ResourceMaterial(6, Material.SURVEY_PARTS, Grade.THREE, 2L)
                                                ))
                                        ),
                                        new Level(9, 550, 30,
                                                new Scrap(94_500, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 17_232L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 483L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 2L),
                                                        new ResourceMaterial(4, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 3L),
                                                        new ResourceMaterial(5, Material.SHIP_XP, 271L),
                                                        new ResourceMaterial(6, Material.SURVEY_PARTS, Grade.THREE, 2L)
                                                ))
                                        ),
                                        new Level(10, 650, 33,
                                                new Scrap(94_500, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 17_232L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 483L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 2L),
                                                        new ResourceMaterial(4, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 3L),
                                                        new ResourceMaterial(5, Material.SHIP_XP, 344L),
                                                        new ResourceMaterial(6, Material.SURVEY_PARTS, Grade.THREE, 3L)
                                                ))
                                        )
                                ),
                                addComponents(
                                        new Component(1, ComponentName.WARP_ENGINES,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 9L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 140L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.SURVEY_PARTS, Grade.TWO, 4L)
                                                )
                                        ),
                                        new Component(2, ComponentName.CARGO_BAY,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 71L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 9000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 220L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.SURVEY_PARTS, Grade.TWO, 16L)
                                                )
                                        ),
                                        new Component(3, ComponentName.SHIELD,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 35L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 13L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 7250L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.SURVEY_PARTS, Grade.TWO, 8L)
                                                )
                                        ),
                                        new Component(4, ComponentName.PHASER_CANNON,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 24L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 13L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 1800L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 350L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.SURVEY_PARTS, Grade.TWO, 12L)
                                                )
                                        ),
                                        new Component(5, ComponentName.MINING_LASER,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 35L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 16L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 5500L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 575L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.SURVEY_PARTS, Grade.TWO, 24L)
                                                )
                                        )
                                )
                        ),
                        new Tier(3, 24_000, 1278,
                                addShipLevels(
                                        new Level(11, 700, 36,
                                                new Scrap(118_140, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 31_414L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 1413L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 2L),
                                                        new ResourceMaterial(4, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 4L),
                                                        new ResourceMaterial(5, Material.SHIP_XP, 395L),
                                                        new ResourceMaterial(6, Material.SURVEY_PARTS, Grade.THREE, 3L)
                                                ))
                                        ),
                                        new Level(12, 900, 39,
                                                new Scrap(118_140, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 31_414L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 1413L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 3L),
                                                        new ResourceMaterial(4, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 5L),
                                                        new ResourceMaterial(5, Material.SHIP_XP, 489L),
                                                        new ResourceMaterial(6, Material.SURVEY_PARTS, Grade.THREE, 3L)
                                                ))
                                        ),
                                        new Level(13, 1000, 42,
                                                new Scrap(118_1400, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 31_414L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 1413L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 4L),
                                                        new ResourceMaterial(4, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 7L),
                                                        new ResourceMaterial(5, Material.SHIP_XP, 594L),
                                                        new ResourceMaterial(6, Material.SURVEY_PARTS, Grade.THREE, 4L)
                                                ))
                                        ),
                                        new Level(14, 1100, 45,
                                                new Scrap(118_140, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 31_414L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 1413L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 5L),
                                                        new ResourceMaterial(4, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 9L),
                                                        new ResourceMaterial(5, Material.SHIP_XP, 710L),
                                                        new ResourceMaterial(6, Material.SURVEY_PARTS, Grade.THREE, 5L)
                                                ))
                                        ),
                                        new Level(15, 1400, 48,
                                                new Scrap(118_140, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 31_414L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 1413L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 7L),
                                                        new ResourceMaterial(4, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 12L),
                                                        new ResourceMaterial(5, Material.SHIP_XP, 857L),
                                                        new ResourceMaterial(6, Material.SURVEY_PARTS, Grade.THREE, 6L)
                                                ))
                                        )
                                ),
                                addComponents(
                                        new Component(1, ComponentName.WARP_ENGINES,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 21L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 300L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.SURVEY_PARTS, Grade.TWO, 7L)
                                                )
                                        ),
                                        new Component(2, ComponentName.CARGO_BAY,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 271L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 16_250L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 450L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.SURVEY_PARTS, Grade.TWO, 29L)
                                                )
                                        ),
                                        new Component(3, ComponentName.SHIELD,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 136L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 27L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 13_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.SURVEY_PARTS, Grade.TWO, 14L)
                                                )
                                        ),
                                        new Component(4, ComponentName.PHASER_CANNON,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 90L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 27L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 3200L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 775L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.SURVEY_PARTS, Grade.TWO, 22L)
                                                )
                                        ),
                                        new Component(5, ComponentName.MINING_LASER,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 136L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 34L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 9750L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 1225L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.CRYSTAL, Rarity.COMMON, Grade.TWO, 140L),
                                                        new ResourceMaterial(2, Material.SURVEY_PARTS, Grade.TWO, 43L)
                                                )
                                        )
                                )
                        ),
                        new Tier(4, 40_000, 1494,
                                addShipLevels(
                                        new Level(16, 1600, 51,
                                                new Scrap(141_780, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 52_601L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 3205L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 6L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 1L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 11L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 1L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 952L),
                                                        new ResourceMaterial(8, Material.SURVEY_PARTS, Grade.THREE, 6L)
                                                ))
                                        ),
                                        new Level(17, 1700, 54,
                                                new Scrap(141_780, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 52_601L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 3205L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 7L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 1L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 13L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 1L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 1117L),
                                                        new ResourceMaterial(8, Material.SURVEY_PARTS, Grade.THREE, 7L)
                                                ))
                                        ),
                                        new Level(18, 2100, 58,
                                                new Scrap(141_780, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 52_601L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 3205L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 9L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 1L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 17L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 2L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 1322L),
                                                        new ResourceMaterial(8, Material.SURVEY_PARTS, Grade.THREE, 8L)
                                                ))
                                        ),
                                        new Level(19, 2300, 62,
                                                new Scrap(141_780, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 52_601L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 3205L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 12L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 1L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 22L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 2L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 1546L),
                                                        new ResourceMaterial(8, Material.SURVEY_PARTS, Grade.THREE, 10L)
                                                ))
                                        ),
                                        new Level(20, 2500, 66,
                                                new Scrap(141_780, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 52_601L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 3205L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 16L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 1L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 28L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 2L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 1790L),
                                                        new ResourceMaterial(8, Material.SURVEY_PARTS, Grade.THREE, 12L)
                                                ))
                                        )
                                ),
                                addComponents(
                                        new Component(1, ComponentName.WARP_ENGINES,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 45L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 650L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.SURVEY_PARTS, Grade.TWO, 12L)
                                                )
                                        ),
                                        new Component(2, ComponentName.CARGO_BAY,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 699L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 27_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 975L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.CRYSTAL, Rarity.COMMON, Grade.TWO, 300L),
                                                        new ResourceMaterial(2, Material.SURVEY_PARTS, Grade.TWO, 48L)
                                                )
                                        ),
                                        new Component(3, ComponentName.SHIELD,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 350L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 60L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 21_500L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.SURVEY_PARTS, Grade.TWO, 24L)
                                                )
                                        ),
                                        new Component(4, ComponentName.PHASER_CANNON,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 233L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 60L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 5500L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 1600L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.SURVEY_PARTS, Grade.TWO, 36L)
                                                )
                                        ),
                                        new Component(5, ComponentName.MINING_LASER,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 350L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 75L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 16_250L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 2600L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.CRYSTAL, Rarity.COMMON, Grade.TWO, 375L),
                                                        new ResourceMaterial(2, Material.SURVEY_PARTS, Grade.TWO, 70L)
                                                )
                                        )
                                )
                        ),
                        new Tier(5, 60_000, 1872,
                                addShipLevels(
                                        new Level(21, 2600, 70,
                                                new Scrap(165_360, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 98_400L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 6064L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 14L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 2L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 26L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 3L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 1886L),
                                                        new ResourceMaterial(8, Material.SURVEY_PARTS, Grade.THREE, 13L)
                                                ))
                                        ),
                                        new Level(22, 3200, 74,
                                                new Scrap(165_360, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 98_400L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 6064L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 16L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 2L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 29L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 4L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 2174L),
                                                        new ResourceMaterial(8, Material.SURVEY_PARTS, Grade.THREE, 14L)
                                                ))
                                        ),
                                        new Level(23, 3400, 78,
                                                new Scrap(165_360, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 98_400L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 6064L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 19L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 2L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 35L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 4L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 2480L),
                                                        new ResourceMaterial(8, Material.SURVEY_PARTS, Grade.THREE, 16L)
                                                ))
                                        ),
                                        new Level(24, 3600, 82,
                                                new Scrap(165_360, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 98_400L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 6064L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 23L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 3L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 42L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 5L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 2804L),
                                                        new ResourceMaterial(8, Material.SURVEY_PARTS, Grade.THREE, 19L)
                                                ))
                                        ),
                                        new Level(25, 4400, 86,
                                                new Scrap(165_360, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 98_400L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 6064L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 28L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 3L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 52L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 6L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 3200L),
                                                        new ResourceMaterial(8, Material.SURVEY_PARTS, Grade.THREE, 22L)
                                                ))
                                        )
                                ),
                                addComponents(
                                        new Component(1, ComponentName.WARP_ENGINES,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 83L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 1150L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.SURVEY_PARTS, Grade.TWO, 20L)
                                                )
                                        ),
                                        new Component(2, ComponentName.CARGO_BAY,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 1482L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 63_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 1700L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.CRYSTAL, Rarity.COMMON, Grade.TWO, 575L),
                                                        new ResourceMaterial(2, Material.SURVEY_PARTS, Grade.TWO, 80L)
                                                )
                                        ),
                                        new Component(3, ComponentName.SHIELD,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 741L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 110L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 50_500L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.SURVEY_PARTS, Grade.TWO, 40L)
                                                )
                                        ),
                                        new Component(4, ComponentName.PHASER_CANNON,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 494L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 110L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 12_500L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 2900L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.CRYSTAL, Rarity.COMMON, Grade.TWO, 425L),
                                                        new ResourceMaterial(2, Material.SURVEY_PARTS, Grade.TWO, 60L)
                                                )
                                        ),
                                        new Component(5, ComponentName.MINING_LASER,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 741L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 138L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 38_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 4600L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.CRYSTAL, Rarity.UNCOMMON, Grade.TWO, 48L),
                                                        new ResourceMaterial(2, Material.SURVEY_PARTS, Grade.TWO, 120L)
                                                )
                                        )
                                )
                        ),
                        new Tier(6, 80_000, 2208,
                                addShipLevels(
                                        new Level(26, 4600, 90,
                                                new Scrap(189_000, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 183_851L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 12_405L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 21L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 5L),
                                                        new ResourceMaterial(5, Material.GAS, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 39L),
                                                        new ResourceMaterial(7, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 8L),
                                                        new ResourceMaterial(8, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(9, Material.SHIP_XP, 3313L),
                                                        new ResourceMaterial(10, Material.SURVEY_PARTS, Grade.THREE, 23L)
                                                ))
                                        ),
                                        new Level(27, 4900, 95,
                                                new Scrap(189_000, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 183_851L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 12_405L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 23L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 5L),
                                                        new ResourceMaterial(5, Material.GAS, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 43L),
                                                        new ResourceMaterial(7, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 9L),
                                                        new ResourceMaterial(8, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(9, Material.SHIP_XP, 3717L),
                                                        new ResourceMaterial(10, Material.SURVEY_PARTS, Grade.THREE, 24L)
                                                ))
                                        ),
                                        new Level(28, 5000, 100,
                                                new Scrap(189_000, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 183_851L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 12_405L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 27L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 6L),
                                                        new ResourceMaterial(5, Material.GAS, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 50L),
                                                        new ResourceMaterial(7, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 10L),
                                                        new ResourceMaterial(8, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(9, Material.SHIP_XP, 4130L),
                                                        new ResourceMaterial(10, Material.SURVEY_PARTS, Grade.THREE, 28L)
                                                ))
                                        ),
                                        new Level(29, 6000, 105,
                                                new Scrap(189_000, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 183_851L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 12_405L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 33L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 7L),
                                                        new ResourceMaterial(5, Material.GAS, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 60L),
                                                        new ResourceMaterial(7, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 12L),
                                                        new ResourceMaterial(8, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(9, Material.SHIP_XP, 4625L),
                                                        new ResourceMaterial(10, Material.SURVEY_PARTS, Grade.THREE, 33L)
                                                ))
                                        ),
                                        new Level(30, 6500, 110,
                                                new Scrap(189_000, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 183_851L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 12_405L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 40L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 8L),
                                                        new ResourceMaterial(5, Material.GAS, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 74L),
                                                        new ResourceMaterial(7, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 15L),
                                                        new ResourceMaterial(8, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(9, Material.SHIP_XP, 5161L),
                                                        new ResourceMaterial(10, Material.SURVEY_PARTS, Grade.THREE, 39L)
                                                ))
                                        )
                                ),
                                addComponents(
                                        new Component(1, ComponentName.WARP_ENGINES,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 206L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 2800L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.SURVEY_PARTS, Grade.TWO, 36L)
                                                )
                                        ),
                                        new Component(2, ComponentName.CARGO_BAY,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 2996L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 130_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 4100L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.CRYSTAL, Rarity.UNCOMMON, Grade.TWO, 90L),
                                                        new ResourceMaterial(2, Material.SURVEY_PARTS, Grade.TWO, 140L)
                                                )
                                        ),
                                        new Component(3, ComponentName.SHIELD,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 1498L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 275L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 104_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.CRYSTAL, Rarity.COMMON, Grade.TWO, 575L),
                                                        new ResourceMaterial(2, Material.SURVEY_PARTS, Grade.TWO, 70L)
                                                )
                                        ),
                                        new Component(4, ComponentName.PHASER_CANNON,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 999L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 275L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 26_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 7000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.CRYSTAL, Rarity.COMMON, Grade.TWO, 875L),
                                                        new ResourceMaterial(2, Material.SURVEY_PARTS, Grade.TWO, 110L)
                                                )
                                        ),
                                        new Component(5, ComponentName.MINING_LASER,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 1498L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 343L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 78_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 11_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.CRYSTAL, Rarity.UNCOMMON, Grade.TWO, 120L),
                                                        new ResourceMaterial(2, Material.SURVEY_PARTS, Grade.TWO, 220L)
                                                )
                                        )
                                )
                        ),
                        new Tier(7, 100_000, 2568,
                                addShipLevels(
                                        new Level(31, 6500, 115,
                                                new Scrap(212_640, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 415_651L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 30_652L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 33L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 10L),
                                                        new ResourceMaterial(5, Material.GAS, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 61L),
                                                        new ResourceMaterial(7, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 17L),
                                                        new ResourceMaterial(8, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(9, Material.SHIP_XP, 5180L),
                                                        new ResourceMaterial(10, Material.SURVEY_PARTS, Grade.THREE, 40L)
                                                ))
                                        ),
                                        new Level(32, 8000, 120,
                                                new Scrap(212_640, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 415_651L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 30_652L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 36L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 11L),
                                                        new ResourceMaterial(5, Material.GAS, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 67L),
                                                        new ResourceMaterial(7, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 19L),
                                                        new ResourceMaterial(8, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(9, Material.SHIP_XP, 5780L),
                                                        new ResourceMaterial(10, Material.SURVEY_PARTS, Grade.THREE, 44L)
                                                ))
                                        ),
                                        new Level(33, 8000, 125,
                                                new Scrap(212_640, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 415_651L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 30_652L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 43L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 13L),
                                                        new ResourceMaterial(5, Material.GAS, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 80L),
                                                        new ResourceMaterial(7, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 23L),
                                                        new ResourceMaterial(8, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(9, Material.SHIP_XP, 6380L),
                                                        new ResourceMaterial(10, Material.SURVEY_PARTS, Grade.THREE, 51L)
                                                ))
                                        ),
                                        new Level(34, 8500, 135,
                                                new Scrap(212_640, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 415_651L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 30_652L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 52L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 15L),
                                                        new ResourceMaterial(5, Material.GAS, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 96L),
                                                        new ResourceMaterial(7, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 27L),
                                                        new ResourceMaterial(8, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(9, Material.SHIP_XP, 7017L),
                                                        new ResourceMaterial(10, Material.SURVEY_PARTS, Grade.THREE, 61L)
                                                ))
                                        ),
                                        new Level(35, 10_000, 150,
                                                new Scrap(212_640, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 415_651L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 30_652L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 64L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 18L),
                                                        new ResourceMaterial(5, Material.GAS, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 118L),
                                                        new ResourceMaterial(7, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 33L),
                                                        new ResourceMaterial(8, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(9, Material.SHIP_XP, 7767L),
                                                        new ResourceMaterial(10, Material.SURVEY_PARTS, Grade.THREE, 74L)
                                                ))
                                        )
                                ),
                                addComponents(
                                        new Component(1, ComponentName.WARP_ENGINES,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 625L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 8500L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.CRYSTAL, Rarity.COMMON, Grade.TWO, 675L),
                                                        new ResourceMaterial(2, Material.SURVEY_PARTS, Grade.TWO, 80L)
                                                )
                                        ),
                                        new Component(2, ComponentName.CARGO_BAY,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 6446L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 380_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 13_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.CRYSTAL, Rarity.UNCOMMON, Grade.TWO, 220L),
                                                        new ResourceMaterial(2, Material.SURVEY_PARTS, Grade.TWO, 325L)
                                                )
                                        ),
                                        new Component(3, ComponentName.SHIELD,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 3223L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 833L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 305_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.CRYSTAL, Rarity.COMMON, Grade.TWO, 1350L),
                                                        new ResourceMaterial(2, Material.SURVEY_PARTS, Grade.TWO, 160L)
                                                )
                                        ),
                                        new Component(4, ComponentName.PHASER_CANNON,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 2149L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 833L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 76_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 21_500L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.CRYSTAL, Rarity.UNCOMMON, Grade.TWO, 160L),
                                                        new ResourceMaterial(2, Material.SURVEY_PARTS, Grade.TWO, 250L)
                                                )
                                        ),
                                        new Component(5, ComponentName.MINING_LASER,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 3223L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 1041L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 230_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 34_500L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.CRYSTAL, Rarity.UNCOMMON, Grade.TWO, 275L),
                                                        new ResourceMaterial(2, Material.SURVEY_PARTS, Grade.TWO, 475L)
                                                )
                                        )
                                )
                        )
                )
        );
    }

    private Ship getPhindra() {
        return new Ship(
                "Phindra",
                Rarity.COMMON,
                Grade.TWO,
                ShipClass.INTERCEPTOR,
                img(R.drawable.phindra),
                0,
                "Battleship Hunter",
                10,
                20,
                addTiers(
                        new Tier(1, 30_600, 1050,
                                addShipLevels(
                                        new Level(1, 0, 10,
                                                new Scrap(38_580, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 2600L)
                                                ))
                                        ),
                                        new Level(2, 130, 11,
                                                new Scrap(38_580, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 2600L),
                                                        new ResourceMaterial(2, Material.SHIP_XP, 16L)
                                                ))
                                        ),
                                        new Level(3, 150, 12,
                                                new Scrap(38_580, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 2600L),
                                                        new ResourceMaterial(2, Material.SHIP_XP, 34L)
                                                ))
                                        ),
                                        new Level(4, 180, 13,
                                                new Scrap(38_580, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 2600L),
                                                        new ResourceMaterial(2, Material.SHIP_XP, 55L)
                                                ))
                                        ),
                                        new Level(5, 250, 14,
                                                new Scrap(38_580, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 2600L),
                                                        new ResourceMaterial(2, Material.SHIP_XP, 85L)
                                                ))
                                        )
                                ),
                                addComponents(
                                        new Component(1, ComponentName.BUILD_SHIP_TOTAL,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 188L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 6500L)
                                                ),
                                                setEmpty()
                                        )
                                )
                        ),
                        new Tier(2, 9000, 1272,
                                addShipLevels(
                                        new Level(6, 300, 15,
                                                new Scrap(51_480, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 5967L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 76L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 1L),
                                                        new ResourceMaterial(4, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 1L),
                                                        new ResourceMaterial(5, Material.SHIP_XP, 114L),
                                                        new ResourceMaterial(6, Material.INTERCEPTOR_PARTS, Grade.THREE, 1L)
                                                ))
                                        ),
                                        new Level(7, 350, 16,
                                                new Scrap(51_480, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 5967L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 76L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 1L),
                                                        new ResourceMaterial(4, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 1L),
                                                        new ResourceMaterial(5, Material.SHIP_XP, 153L),
                                                        new ResourceMaterial(6, Material.INTERCEPTOR_PARTS, Grade.THREE, 1L)
                                                ))
                                        ),
                                        new Level(8, 500, 17,
                                                new Scrap(51_480, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 5967L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 76L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 1L),
                                                        new ResourceMaterial(4, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 1L),
                                                        new ResourceMaterial(5, Material.SHIP_XP, 209L),
                                                        new ResourceMaterial(6, Material.INTERCEPTOR_PARTS, Grade.THREE, 1L)
                                                ))
                                        ),
                                        new Level(9, 550, 18,
                                                new Scrap(51_480, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 5967L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 76L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 1L),
                                                        new ResourceMaterial(4, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 1L),
                                                        new ResourceMaterial(5, Material.SHIP_XP, 271L),
                                                        new ResourceMaterial(6, Material.INTERCEPTOR_PARTS, Grade.THREE, 1L)
                                                ))
                                        ),
                                        new Level(10, 650, 19,
                                                new Scrap(51_480, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 5967L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 76L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 1L),
                                                        new ResourceMaterial(4, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 2L),
                                                        new ResourceMaterial(5, Material.SHIP_XP, 344L),
                                                        new ResourceMaterial(6, Material.INTERCEPTOR_PARTS, Grade.THREE, 1L)
                                                ))
                                        )
                                ),
                                addComponents(
                                        new Component(1, ComponentName.WARP_ENGINES,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 1L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 80L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.INTERCEPTOR_PARTS, Grade.TWO, 3L)
                                                )
                                        ),
                                        new Component(2, ComponentName.CARGO_BAY,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 8L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 775L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.INTERCEPTOR_PARTS, Grade.TWO, 1L)
                                                )
                                        ),
                                        new Component(3, ComponentName.IMPULSE_ENGINE,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 8L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 2L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 2000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.INTERCEPTOR_PARTS, Grade.TWO, 4L)
                                                )
                                        ),
                                        new Component(4, ComponentName.PHOTON_TORPEDO,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 21L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 1L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 3100L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 62L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.INTERCEPTOR_PARTS, Grade.TWO, 8L)
                                                )
                                        ),
                                        new Component(5, ComponentName.PHOTON_TORPEDO,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 21L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 1L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 3100L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 62L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.INTERCEPTOR_PARTS, Grade.TWO, 8L)
                                                )
                                        )
                                )
                        ),
                        new Tier(3, 18_000, 1566,
                                addShipLevels(
                                        new Level(11, 700, 20,
                                                new Scrap(64_320, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 11_306L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 225L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 1L),
                                                        new ResourceMaterial(4, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 2L),
                                                        new ResourceMaterial(6, Material.SHIP_XP, 395L),
                                                        new ResourceMaterial(5, Material.INTERCEPTOR_PARTS, Grade.THREE, 1L)
                                                ))
                                        ),
                                        new Level(12, 900, 21,
                                                new Scrap(64_320, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 11_306L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 225L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 2L),
                                                        new ResourceMaterial(4, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 3L),
                                                        new ResourceMaterial(6, Material.SHIP_XP, 489L),
                                                        new ResourceMaterial(5, Material.INTERCEPTOR_PARTS, Grade.THREE, 2L)
                                                ))
                                        ),
                                        new Level(13, 1000, 22,
                                                new Scrap(64_320, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 11_306L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 225L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 3L),
                                                        new ResourceMaterial(4, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 4L),
                                                        new ResourceMaterial(6, Material.SHIP_XP, 594L),
                                                        new ResourceMaterial(5, Material.INTERCEPTOR_PARTS, Grade.THREE, 2L)
                                                ))
                                        ),
                                        new Level(14, 1100, 23,
                                                new Scrap(64_320, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 11_306L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 225L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 3L),
                                                        new ResourceMaterial(4, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 6L),
                                                        new ResourceMaterial(6, Material.SHIP_XP, 710L),
                                                        new ResourceMaterial(5, Material.INTERCEPTOR_PARTS, Grade.THREE, 2L)
                                                ))
                                        ),
                                        new Level(15, 1400, 24,
                                                new Scrap(64_320, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 11_306L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 225L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 5L),
                                                        new ResourceMaterial(4, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 8L),
                                                        new ResourceMaterial(6, Material.SHIP_XP, 857L),
                                                        new ResourceMaterial(5, Material.INTERCEPTOR_PARTS, Grade.THREE, 3L)
                                                ))
                                        )
                                ),
                                addComponents(
                                        new Component(1, ComponentName.WARP_ENGINES,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 3L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 180L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.INTERCEPTOR_PARTS, Grade.TWO, 6L)
                                                )
                                        ),
                                        new Component(2, ComponentName.CARGO_BAY,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 22L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 1400L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.INTERCEPTOR_PARTS, Grade.TWO, 3L)
                                                )
                                        ),
                                        new Component(3, ComponentName.IMPULSE_ENGINE,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 22L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 6L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 3500L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.INTERCEPTOR_PARTS, Grade.TWO, 8L)
                                                )
                                        ),
                                        new Component(4, ComponentName.PHOTON_TORPEDO,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 55L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 3L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 5500L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 130L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.CRYSTAL, Rarity.COMMON, Grade.TWO, 90L),
                                                        new ResourceMaterial(2, Material.INTERCEPTOR_PARTS, Grade.TWO, 17L)
                                                )
                                        ),
                                        new Component(5, ComponentName.PHOTON_TORPEDO,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 55L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 3L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 5500L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 130L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.CRYSTAL, Rarity.COMMON, Grade.TWO, 90L),
                                                        new ResourceMaterial(2, Material.INTERCEPTOR_PARTS, Grade.TWO, 17L)
                                                )
                                        )
                                )
                        ),
                        new Tier(4, 30_000, 2010,
                                addShipLevels(
                                        new Level(16, 1600, 25,
                                                new Scrap(77_220, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 19_312L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 510L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 5L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 1L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 8L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 1L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 952L),
                                                        new ResourceMaterial(8, Material.INTERCEPTOR_PARTS, Grade.THREE, 3L)
                                                ))
                                        ),
                                        new Level(17, 1700, 26,
                                                new Scrap(77_220, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 19_312L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 510L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 5L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 1L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 10L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 1L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 1117L),
                                                        new ResourceMaterial(8, Material.INTERCEPTOR_PARTS, Grade.THREE, 4L)
                                                ))
                                        ),
                                        new Level(18, 2100, 27,
                                                new Scrap(77_220, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 19_312L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 510L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 7L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 1L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 13L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 1L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 1322L),
                                                        new ResourceMaterial(8, Material.INTERCEPTOR_PARTS, Grade.THREE, 4L)
                                                ))
                                        ),
                                        new Level(19, 2300, 28,
                                                new Scrap(77_220, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 19_312L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 510L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 9L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 1L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 17L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 2L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 1546L),
                                                        new ResourceMaterial(8, Material.INTERCEPTOR_PARTS, Grade.THREE, 5L)
                                                ))
                                        ),
                                        new Level(20, 2500, 29,
                                                new Scrap(77_220, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 19_312L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 510L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 13L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 1L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 23L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 2L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 1790L),
                                                        new ResourceMaterial(8, Material.INTERCEPTOR_PARTS, Grade.THREE, 7L)
                                                ))
                                        )
                                ),
                                addComponents(
                                        new Component(1, ComponentName.WARP_ENGINES,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 7L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 375L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.INTERCEPTOR_PARTS, Grade.TWO, 10L)
                                                )
                                        ),
                                        new Component(2, ComponentName.CARGO_BAY,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 50L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 2300L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.INTERCEPTOR_PARTS, Grade.TWO, 5L)
                                                )
                                        ),
                                        new Component(3, ComponentName.IMPULSE_ENGINE,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 50L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 12L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 5750L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.CRYSTAL, Rarity.COMMON, Grade.TWO, 200L),
                                                        new ResourceMaterial(2, Material.INTERCEPTOR_PARTS, Grade.TWO, 15L)
                                                )
                                        ),
                                        new Component(4, ComponentName.PHOTON_TORPEDO,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 126L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 7L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 9250L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 275L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.CRYSTAL, Rarity.COMMON, Grade.TWO, 250L),
                                                        new ResourceMaterial(2, Material.INTERCEPTOR_PARTS, Grade.TWO, 29L)
                                                )
                                        ),
                                        new Component(5, ComponentName.PHOTON_TORPEDO,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 126L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 7L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 9250L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 275L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.CRYSTAL, Rarity.COMMON, Grade.TWO, 250L),
                                                        new ResourceMaterial(2, Material.INTERCEPTOR_PARTS, Grade.TWO, 29L)
                                                )
                                        )
                                )
                        ),
                        new Tier(5, 45_000, 2628,
                                addShipLevels(
                                        new Level(21, 2600, 30,
                                                new Scrap(90_060, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 31_423L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 973L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 11L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 2L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 21L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 3L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 1886L),
                                                        new ResourceMaterial(8, Material.INTERCEPTOR_PARTS, Grade.THREE, 7L)
                                                ))
                                        ),
                                        new Level(22, 3200, 31,
                                                new Scrap(90_060, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 31_423L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 973L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 12L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 2L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 23L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 3L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 2174L),
                                                        new ResourceMaterial(8, Material.INTERCEPTOR_PARTS, Grade.THREE, 7L)
                                                ))
                                        ),
                                        new Level(23, 3400, 32,
                                                new Scrap(90_060, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 31_423L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 973L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 14L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 2L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 26L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 3L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 2480L),
                                                        new ResourceMaterial(8, Material.INTERCEPTOR_PARTS, Grade.THREE, 9L)
                                                ))
                                        ),
                                        new Level(24, 3600, 33,
                                                new Scrap(90_060, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 31_423L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 973L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 17L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 2L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 31L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 4L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 2804L),
                                                        new ResourceMaterial(8, Material.INTERCEPTOR_PARTS, Grade.THREE, 10L)
                                                ))
                                        ),
                                        new Level(25, 4400, 34,
                                                new Scrap(90_060, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 31_423L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 973L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 21L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 3L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 38L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 4L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 3200L),
                                                        new ResourceMaterial(8, Material.INTERCEPTOR_PARTS, Grade.THREE, 12L)
                                                ))
                                        )
                                ),
                                addComponents(
                                        new Component(1, ComponentName.WARP_ENGINES,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 12L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 675L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.CRYSTAL, Rarity.COMMON, Grade.TWO, 190L),
                                                        new ResourceMaterial(2, Material.INTERCEPTOR_PARTS, Grade.TWO, 17L)
                                                )
                                        ),
                                        new Component(2, ComponentName.CARGO_BAY,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 91L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 3900L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.INTERCEPTOR_PARTS, Grade.TWO, 8L)
                                                )
                                        ),
                                        new Component(3, ComponentName.IMPULSE_ENGINE,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 91L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 19L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 9750L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.CRYSTAL, Rarity.COMMON, Grade.TWO, 375L),
                                                        new ResourceMaterial(2, Material.INTERCEPTOR_PARTS, Grade.TWO, 25L)
                                                )
                                        ),
                                        new Component(4, ComponentName.PHOTON_TORPEDO,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 228L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 12L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 15_500L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 500L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.CRYSTAL, Rarity.UNCOMMON, Grade.TWO, 31L),
                                                        new ResourceMaterial(2, Material.INTERCEPTOR_PARTS, Grade.TWO, 50L)
                                                )
                                        ),
                                        new Component(5, ComponentName.PHOTON_TORPEDO,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 228L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 12L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 15_500L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 500L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.CRYSTAL, Rarity.UNCOMMON, Grade.TWO, 31L),
                                                        new ResourceMaterial(2, Material.INTERCEPTOR_PARTS, Grade.TWO, 50L)
                                                )
                                        )
                                )
                        ),
                        new Tier(6, 60_000, 3174,
                                addShipLevels(
                                        new Level(26, 4600, 35,
                                                new Scrap(102_960, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 51_158L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 1807L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 15L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 3L),
                                                        new ResourceMaterial(5, Material.GAS, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 28L),
                                                        new ResourceMaterial(7, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 6L),
                                                        new ResourceMaterial(8, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(9, Material.SHIP_XP, 3313L),
                                                        new ResourceMaterial(10, Material.INTERCEPTOR_PARTS, Grade.THREE, 12L)
                                                ))
                                        ),
                                        new Level(27, 4900, 36,
                                                new Scrap(102_960, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 51_158L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 1807L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 17L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 4L),
                                                        new ResourceMaterial(5, Material.GAS, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 30L),
                                                        new ResourceMaterial(7, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 6L),
                                                        new ResourceMaterial(8, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(9, Material.SHIP_XP, 3717L),
                                                        new ResourceMaterial(10, Material.INTERCEPTOR_PARTS, Grade.THREE, 13L)
                                                ))
                                        ),
                                        new Level(28, 5000, 37,
                                                new Scrap(102_9600, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 51_158L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 1807L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 19L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 4L),
                                                        new ResourceMaterial(5, Material.GAS, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 35L),
                                                        new ResourceMaterial(7, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 7L),
                                                        new ResourceMaterial(8, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(9, Material.SHIP_XP, 4130L),
                                                        new ResourceMaterial(10, Material.INTERCEPTOR_PARTS, Grade.THREE, 15L)
                                                ))
                                        ),
                                        new Level(29, 6000, 38,
                                                new Scrap(102_960, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 51_158L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 1807L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 23L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 5L),
                                                        new ResourceMaterial(5, Material.GAS, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 42L),
                                                        new ResourceMaterial(7, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 9L),
                                                        new ResourceMaterial(8, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(9, Material.SHIP_XP, 4625L),
                                                        new ResourceMaterial(10, Material.INTERCEPTOR_PARTS, Grade.THREE, 18L)
                                                ))
                                        ),
                                        new Level(30, 6500, 40,
                                                new Scrap(102_960, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 51_158L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 1807L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 27L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 6L),
                                                        new ResourceMaterial(5, Material.GAS, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 50L),
                                                        new ResourceMaterial(7, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 10L),
                                                        new ResourceMaterial(8, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(9, Material.SHIP_XP, 5161L),
                                                        new ResourceMaterial(10, Material.INTERCEPTOR_PARTS, Grade.THREE, 21L)
                                                ))
                                        )
                                ),
                                addComponents(
                                        new Component(1, ComponentName.WARP_ENGINES,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 24L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 1325L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.CRYSTAL, Rarity.COMMON, Grade.TWO, 375L),
                                                        new ResourceMaterial(2, Material.INTERCEPTOR_PARTS, Grade.TWO, 34L)
                                                )
                                        ),
                                        new Component(2, ComponentName.CARGO_BAY,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 199L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 7000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.CRYSTAL, Rarity.COMMON, Grade.TWO, 190L),
                                                        new ResourceMaterial(2, Material.INTERCEPTOR_PARTS, Grade.TWO, 17L)
                                                )
                                        ),
                                        new Component(3, ComponentName.IMPULSE_ENGINE,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 199L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 41L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 17_500L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.CRYSTAL, Rarity.UNCOMMON, Grade.TWO, 60L),
                                                        new ResourceMaterial(2, Material.INTERCEPTOR_PARTS, Grade.TWO, 50L)
                                                )
                                        ),
                                        new Component(4, ComponentName.PHOTON_TORPEDO,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 497L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 24L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 28_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 1000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.CRYSTAL, Rarity.UNCOMMON, Grade.TWO, 80L),
                                                        new ResourceMaterial(2, Material.INTERCEPTOR_PARTS, Grade.TWO, 100L)
                                                )
                                        ),
                                        new Component(5, ComponentName.PHOTON_TORPEDO,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 497L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 24L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 28_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 1000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.CRYSTAL, Rarity.UNCOMMON, Grade.TWO, 80L),
                                                        new ResourceMaterial(2, Material.INTERCEPTOR_PARTS, Grade.TWO, 100L)
                                                )
                                        )
                                )
                        ),
                        new Tier(7, 75_000, 4206,
                                addShipLevels(
                                        new Level(31, 6500, 42,
                                                new Scrap(115_800, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 91_370L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 3568L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 22L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 7L),
                                                        new ResourceMaterial(5, Material.GAS, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 41L),
                                                        new ResourceMaterial(7, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 12L),
                                                        new ResourceMaterial(8, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(9, Material.SHIP_XP, 5180L),
                                                        new ResourceMaterial(10, Material.INTERCEPTOR_PARTS, Grade.THREE, 22L)
                                                ))
                                        ),
                                        new Level(32, 8000, 44,
                                                new Scrap(115_800, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 91_370L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 3568L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 25L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 7L),
                                                        new ResourceMaterial(5, Material.GAS, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 45L),
                                                        new ResourceMaterial(7, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 13L),
                                                        new ResourceMaterial(8, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(9, Material.SHIP_XP, 5780L),
                                                        new ResourceMaterial(10, Material.INTERCEPTOR_PARTS, Grade.THREE, 24L)
                                                ))
                                        ),
                                        new Level(33, 8000, 46,
                                                new Scrap(115_800, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 91_370L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 3568L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 29L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 8L),
                                                        new ResourceMaterial(5, Material.GAS, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 53L),
                                                        new ResourceMaterial(7, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 15L),
                                                        new ResourceMaterial(8, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(9, Material.SHIP_XP, 6380L),
                                                        new ResourceMaterial(10, Material.INTERCEPTOR_PARTS, Grade.THREE, 28L)
                                                ))
                                        ),
                                        new Level(34, 8500, 48,
                                                new Scrap(115_8000, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 91_370L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 3568L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 34L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 10L),
                                                        new ResourceMaterial(5, Material.GAS, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 63L),
                                                        new ResourceMaterial(7, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 18L),
                                                        new ResourceMaterial(8, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(9, Material.SHIP_XP, 7017L),
                                                        new ResourceMaterial(10, Material.INTERCEPTOR_PARTS, Grade.THREE, 34L)
                                                ))
                                        ),
                                        new Level(35, 10_000, 50,
                                                new Scrap(115_800, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 91_370L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 3568L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 41L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 12L),
                                                        new ResourceMaterial(5, Material.GAS, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 76L),
                                                        new ResourceMaterial(7, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 22L),
                                                        new ResourceMaterial(8, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(9, Material.SHIP_XP, 7767L),
                                                        new ResourceMaterial(10, Material.INTERCEPTOR_PARTS, Grade.THREE, 41L)
                                                ))
                                        )
                                ),
                                addComponents(
                                        new Component(1, ComponentName.WARP_ENGINES,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 53L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 3100L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.CRYSTAL, Rarity.UNCOMMON, Grade.TWO, 70L),
                                                        new ResourceMaterial(2, Material.INTERCEPTOR_PARTS, Grade.TWO, 80L)
                                                )
                                        ),
                                        new Component(2, ComponentName.CARGO_BAY,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 424L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 15_500L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.CRYSTAL, Rarity.COMMON, Grade.TWO, 450L),
                                                        new ResourceMaterial(2, Material.INTERCEPTOR_PARTS, Grade.TWO, 38L)
                                                )
                                        ),
                                        new Component(3, ComponentName.IMPULSE_ENGINE,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 424L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 89L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 39_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.CRYSTAL, Rarity.UNCOMMON, Grade.TWO, 140L),
                                                        new ResourceMaterial(2, Material.INTERCEPTOR_PARTS, Grade.TWO, 110L)
                                                )
                                        ),
                                        new Component(4, ComponentName.PHOTON_TORPEDO,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 1060L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 53L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 62_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 2300L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.CRYSTAL, Rarity.UNCOMMON, Grade.TWO, 180L),
                                                        new ResourceMaterial(2, Material.INTERCEPTOR_PARTS, Grade.TWO, 230L)
                                                )
                                        ),
                                        new Component(5, ComponentName.PHOTON_TORPEDO,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 1060L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 53L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 62_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 2300L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.CRYSTAL, Rarity.UNCOMMON, Grade.TWO, 180L),
                                                        new ResourceMaterial(2, Material.INTERCEPTOR_PARTS, Grade.TWO, 230L)
                                                )
                                        )
                                )
                        )
                )
        );
    }

    private Ship getKehra() {
        return new Ship(
                "Kehra",
                Rarity.COMMON,
                Grade.THREE,
                ShipClass.INTERCEPTOR,
                img(R.drawable.kehra),
                0,
                "Armor Breaker",
                20,
                26,
                addTiers(
                        new Tier(1, 342_000, 9696,
                                addShipLevels(
                                        new Level(1, 0, 10,
                                                new Scrap(183_240, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 37_500L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 2000L)
                                                ))
                                        ),
                                        new Level(2, 800, 11,
                                                new Scrap(183_240, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 37_500L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 2000L),
                                                        new ResourceMaterial(3, Material.SHIP_XP, 32L)
                                                ))
                                        ),
                                        new Level(3, 1000, 12,
                                                new Scrap(183_240, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 37_500L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 2000L),
                                                        new ResourceMaterial(3, Material.SHIP_XP, 72L)
                                                ))
                                        ),
                                        new Level(4, 1400, 13,
                                                new Scrap(183_240, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 37_500L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 2000L),
                                                        new ResourceMaterial(3, Material.SHIP_XP, 128L)
                                                ))
                                        ),
                                        new Level(5, 1700, 14,
                                                new Scrap(183_240, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 37_500L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 2000L),
                                                        new ResourceMaterial(3, Material.SHIP_XP, 196L)
                                                ))
                                        )
                                ),
                                addComponents(
                                        new Component(1, ComponentName.BUILD_SHIP_TOTAL,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 8543L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 246L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 250_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 10_000L)
                                                ),
                                                setEmpty()
                                        )
                                )
                        ),
                        new Tier(2, 48_600, 11_232,
                                addShipLevels(
                                        new Level(6, 2400, 15,
                                                new Scrap(206_100, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 138_701L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 4054L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 14L),
                                                        new ResourceMaterial(4, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 26L),
                                                        new ResourceMaterial(5, Material.SHIP_XP, 274L),
                                                        new ResourceMaterial(6, Material.INTERCEPTOR_PARTS, Grade.THREE, 6L)
                                                ))
                                        ),
                                        new Level(7, 2900, 16,
                                                new Scrap(206_100, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 138_701L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 4054L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 18L),
                                                        new ResourceMaterial(4, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 32L),
                                                        new ResourceMaterial(5, Material.SHIP_XP, 383L),
                                                        new ResourceMaterial(6, Material.INTERCEPTOR_PARTS, Grade.THREE, 8L)
                                                ))
                                        ),
                                        new Level(8, 3900, 17,
                                                new Scrap(206_100, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 138_701L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 4054L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 23L),
                                                        new ResourceMaterial(4, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 42L),
                                                        new ResourceMaterial(5, Material.SHIP_XP, 529L),
                                                        new ResourceMaterial(6, Material.INTERCEPTOR_PARTS, Grade.THREE, 10L)
                                                ))
                                        ),
                                        new Level(9, 4600, 18,
                                                new Scrap(206_100, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 138_701L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 4054L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 28L),
                                                        new ResourceMaterial(4, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 51L),
                                                        new ResourceMaterial(5, Material.SHIP_XP, 701L),
                                                        new ResourceMaterial(6, Material.INTERCEPTOR_PARTS, Grade.THREE, 12L)
                                                ))
                                        ),
                                        new Level(10, 6000, 19,
                                                new Scrap(206_100, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 138_701L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 4054L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 35L),
                                                        new ResourceMaterial(4, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 64L),
                                                        new ResourceMaterial(5, Material.SHIP_XP, 926L),
                                                        new ResourceMaterial(6, Material.INTERCEPTOR_PARTS, Grade.THREE, 15L)
                                                ))
                                        )
                                ),
                                addComponents(
                                        new Component(1, ComponentName.WARP_ENGINES,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 78L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 3300L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.COMMON, Grade.THREE, 13L),
                                                        new ResourceMaterial(2, Material.INTERCEPTOR_PARTS, Grade.THREE, 8L)
                                                )
                                        ),
                                        new Component(2, ComponentName.CARGO_BAY,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 621L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 66_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.CRYSTAL, Grade.THREE, 14L),
                                                        new ResourceMaterial(2, Material.INTERCEPTOR_PARTS, Grade.THREE, 3L)
                                                )
                                        ),
                                        new Component(3, ComponentName.IMPULSE_ENGINE,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 621L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 129L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 132_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.COMMON, Grade.THREE, 9L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 57L),
                                                        new ResourceMaterial(3, Material.INTERCEPTOR_PARTS, Grade.THREE, 11L)
                                                )
                                        ),
                                        new Component(4, ComponentName.PHASER_CANNON,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 310L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 43L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 66_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 3300L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.COMMON, Grade.THREE, 13L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 57L),
                                                        new ResourceMaterial(3, Material.INTERCEPTOR_PARTS, Grade.THREE, 14L)
                                                )
                                        ),
                                        new Component(5, ComponentName.PHOTON_TORPEDO,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 1035L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 53L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 220_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 2000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.COMMON, Grade.THREE, 17L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 70L),
                                                        new ResourceMaterial(3, Material.INTERCEPTOR_PARTS, Grade.THREE, 17L)
                                                )
                                        ),
                                        new Component(6, ComponentName.PHOTON_TORPEDO,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 1035L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 53L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 220_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 2000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.COMMON, Grade.THREE, 17L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 70L),
                                                        new ResourceMaterial(3, Material.INTERCEPTOR_PARTS, Grade.THREE, 17L)
                                                )
                                        )
                                )
                        ),
                        new Tier(3, 97_200, 13_248,
                                addShipLevels(
                                        new Level(11, 7000, 20,
                                                new Scrap(229_020, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 288_301L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 8356L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 33L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 2L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 62L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 3L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 1110L),
                                                        new ResourceMaterial(8, Material.INTERCEPTOR_PARTS, Grade.THREE, 18L)
                                                ))
                                        ),
                                        new Level(12, 8500, 21,
                                                new Scrap(229_020, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 288_301L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 8356L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 38L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 2L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 71L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 4L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 1407L),
                                                        new ResourceMaterial(8, Material.INTERCEPTOR_PARTS, Grade.THREE, 20L)
                                                ))
                                        ),
                                        new Level(13, 9500, 22,
                                                new Scrap(229_020, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 288_301L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 8356L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 48L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 3L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 89L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 4L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 1740L),
                                                        new ResourceMaterial(8, Material.INTERCEPTOR_PARTS, Grade.THREE, 26L)
                                                ))
                                        ),
                                        new Level(14, 11_000, 23,
                                                new Scrap(229_020, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 288_301L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 8356L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 61L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 3L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 113L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 5L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 2125L),
                                                        new ResourceMaterial(8, Material.INTERCEPTOR_PARTS, Grade.THREE, 33L)
                                                ))
                                        ),
                                        new Level(15, 13_500, 24,
                                                new Scrap(229_020, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 288_301L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 8356L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 79L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 4L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 145L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 7L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 2597L),
                                                        new ResourceMaterial(8, Material.INTERCEPTOR_PARTS, Grade.THREE, 43L)
                                                ))
                                        )
                                ),
                                addComponents(
                                        new Component(1, ComponentName.WARP_ENGINES,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 178L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 7250L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.COMMON, Grade.THREE, 39L),
                                                        new ResourceMaterial(2, Material.INTERCEPTOR_PARTS, Grade.THREE, 17L)
                                                )
                                        ),
                                        new Component(2, ComponentName.CARGO_BAY,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 1475L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 105_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 43L),
                                                        new ResourceMaterial(2, Material.INTERCEPTOR_PARTS, Grade.THREE, 6L)
                                                )
                                        ),
                                        new Component(3, ComponentName.IMPULSE_ENGINE,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 1475L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 297L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 210_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.COMMON, Grade.THREE, 26L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 170L),
                                                        new ResourceMaterial(3, Material.INTERCEPTOR_PARTS, Grade.THREE, 22L)
                                                )
                                        ),
                                        new Component(4, ComponentName.PHASER_CANNON,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 738L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 99L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 105_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 7250L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.COMMON, Grade.THREE, 39L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 170L),
                                                        new ResourceMaterial(3, Material.INTERCEPTOR_PARTS, Grade.THREE, 28L)
                                                )
                                        ),
                                        new Component(5, ComponentName.PHOTON_TORPEDO,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 2459L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 119L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 350_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 4400L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 2L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 10L),
                                                        new ResourceMaterial(3, Material.INTERCEPTOR_PARTS, Grade.THREE, 34L)
                                                )
                                        ),
                                        new Component(6, ComponentName.PHOTON_TORPEDO,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 2459L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 119L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 350_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 4400L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 2L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 10L),
                                                        new ResourceMaterial(3, Material.INTERCEPTOR_PARTS, Grade.THREE, 34L)
                                                )
                                        )
                                )
                        ),
                        new Tier(4, 162_000, 15_744,
                                addShipLevels(
                                        new Level(16, 15_000, 25,
                                                new Scrap(251_940, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 500_026L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 17_660L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 75L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 7L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 138L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 12L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 2899L),
                                                        new ResourceMaterial(8, Material.INTERCEPTOR_PARTS, Grade.THREE, 46L)
                                                ))
                                        ),
                                        new Level(17, 17_500, 26,
                                                new Scrap(251_940, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 500_026L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 17_660L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 83L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 7L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 153L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 13L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 3468L),
                                                        new ResourceMaterial(8, Material.INTERCEPTOR_PARTS, Grade.THREE, 50L)
                                                ))
                                        ),
                                        new Level(18, 19_500, 27,
                                                new Scrap(251_940, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 500_026L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 17_660L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 99L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 9L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 184L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 16L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 4102L),
                                                        new ResourceMaterial(8, Material.INTERCEPTOR_PARTS, Grade.THREE, 60L)
                                                ))
                                        ),
                                        new Level(19, 23_000, 28,
                                                new Scrap(251_940, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 500_026L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 17_660L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 120L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 10L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 223L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 19L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 4849L),
                                                        new ResourceMaterial(8, Material.INTERCEPTOR_PARTS, Grade.THREE, 72L)
                                                ))
                                        ),
                                        new Level(20, 25_000, 29,
                                                new Scrap(251_940, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 500_026L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 17_660L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 149L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 13L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 277L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 24L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 5662L),
                                                        new ResourceMaterial(8, Material.INTERCEPTOR_PARTS, Grade.THREE, 89L)
                                                ))
                                        )
                                ),
                                addComponents(
                                        new Component(1, ComponentName.WARP_ENGINES,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 359L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 16_500L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.COMMON, Grade.THREE, 100L),
                                                        new ResourceMaterial(2, Material.INTERCEPTOR_PARTS, Grade.THREE, 29L)
                                                )
                                        ),
                                        new Component(2, ComponentName.CARGO_BAY,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 3313L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 160_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 110L),
                                                        new ResourceMaterial(2, Material.INTERCEPTOR_PARTS, Grade.THREE, 10L)
                                                )
                                        ),
                                        new Component(3, ComponentName.IMPULSE_ENGINE,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 3313L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 598L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 320_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.COMMON, Grade.THREE, 70L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 450L),
                                                        new ResourceMaterial(3, Material.INTERCEPTOR_PARTS, Grade.THREE, 39L)
                                                )
                                        ),
                                        new Component(4, ComponentName.PHASER_CANNON,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 1656L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 199L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 160_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 16_500L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 6L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 27L),
                                                        new ResourceMaterial(3, Material.INTERCEPTOR_PARTS, Grade.THREE, 49L)
                                                )
                                        ),
                                        new Component(5, ComponentName.PHOTON_TORPEDO,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 5522L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 239L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 530_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 9750L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 8L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 34L),
                                                        new ResourceMaterial(3, Material.INTERCEPTOR_PARTS, Grade.THREE, 59L)
                                                )
                                        ),
                                        new Component(6, ComponentName.PHOTON_TORPEDO,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 5522L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 239L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 530_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 9750L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 8L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 34L),
                                                        new ResourceMaterial(3, Material.INTERCEPTOR_PARTS, Grade.THREE, 59L)
                                                )
                                        )
                                )
                        ),
                        new Tier(5, 243_000, 18_834,
                                addShipLevels(
                                        new Level(21, 29_000, 30,
                                                new Scrap(274_800, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 805_500L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 33_396L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 123L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 21L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 228L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 38L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 6096L),
                                                        new ResourceMaterial(8, Material.INTERCEPTOR_PARTS, Grade.THREE, 92L)
                                                ))
                                        ),
                                        new Level(22, 31_500, 31,
                                                new Scrap(274_800, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 805_500L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 33_396L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 132L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 22L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 245L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 41L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 7041L),
                                                        new ResourceMaterial(8, Material.INTERCEPTOR_PARTS, Grade.THREE, 99L)
                                                ))
                                        ),
                                        new Level(23, 36_000, 32,
                                                new Scrap(274_800, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 805_500L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 33_396L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 150L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 25L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 278L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 47L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 8121L),
                                                        new ResourceMaterial(8, Material.INTERCEPTOR_PARTS, Grade.THREE, 114L)
                                                ))
                                        ),
                                        new Level(24, 39_000, 33,
                                                new Scrap(274_800, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 805_500L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 33_396L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 173L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 29L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 320L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 54L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 9291L),
                                                        new ResourceMaterial(8, Material.INTERCEPTOR_PARTS, Grade.THREE, 132L)
                                                ))
                                        ),
                                        new Level(25, 42_000, 34,
                                                new Scrap(274_800, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 805_500L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 33_396L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 173L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 29L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 320L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 54L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 9291L),
                                                        new ResourceMaterial(8, Material.INTERCEPTOR_PARTS, Grade.THREE, 132L)
                                                ))
                                        )
                                ),
                                addComponents(
                                        new Component(1, ComponentName.WARP_ENGINES,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 587L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 29_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.COMMON, Grade.THREE, 190L),
                                                        new ResourceMaterial(2, Material.INTERCEPTOR_PARTS, Grade.THREE, 50L)
                                                )
                                        ),
                                        new Component(2, ComponentName.CARGO_BAY,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 5509L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 245_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 210L),
                                                        new ResourceMaterial(2, Material.INTERCEPTOR_PARTS, Grade.THREE, 17L)
                                                )
                                        ),
                                        new Component(3, ComponentName.IMPULSE_ENGINE,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 5509L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 979L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 490_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 8L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 54L),
                                                        new ResourceMaterial(3, Material.INTERCEPTOR_PARTS, Grade.THREE, 70L)
                                                )
                                        ),
                                        new Component(4, ComponentName.PHASER_CANNON,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 2755L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 326L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 245_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 29_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 12L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 54L),
                                                        new ResourceMaterial(3, Material.INTERCEPTOR_PARTS, Grade.THREE, 80L)
                                                )
                                        ),
                                        new Component(5, ComponentName.PHOTON_TORPEDO,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 9182L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 392L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 820_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 17_500L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 16L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 70L),
                                                        new ResourceMaterial(3, Material.INTERCEPTOR_PARTS, Grade.THREE, 100L)
                                                )
                                        ),
                                        new Component(6, ComponentName.PHOTON_TORPEDO,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 9182L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 392L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 820_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 17_500L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 16L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 70L),
                                                        new ResourceMaterial(3, Material.INTERCEPTOR_PARTS, Grade.THREE, 100L)
                                                )
                                        )
                                )
                        ),
                        new Tier(6, 324_000, 22_800,
                                addShipLevels(
                                        new Level(26, 47_000, 35,
                                                new Scrap(297_720, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 1_467_727L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 65_686L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 140L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 40L),
                                                        new ResourceMaterial(5, Material.GAS, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 259L),
                                                        new ResourceMaterial(7, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 73L),
                                                        new ResourceMaterial(8, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(9, Material.SHIP_XP, 10_964L),
                                                        new ResourceMaterial(10, Material.INTERCEPTOR_PARTS, Grade.THREE, 164L)
                                                ))
                                        ),
                                        new Level(27, 51_000, 36,
                                                new Scrap(297_720, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 1_467_727L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 65_686L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 150L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 43L),
                                                        new ResourceMaterial(5, Material.GAS, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 278L),
                                                        new ResourceMaterial(7, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 79L),
                                                        new ResourceMaterial(8, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(9, Material.SHIP_XP, 12_367L),
                                                        new ResourceMaterial(10, Material.INTERCEPTOR_PARTS, Grade.THREE, 177L)
                                                ))
                                        ),
                                        new Level(28, 57_000, 37,
                                                new Scrap(297_720, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 1_467_727L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 65_686L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 171L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 48L),
                                                        new ResourceMaterial(5, Material.GAS, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 316L),
                                                        new ResourceMaterial(7, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 89L),
                                                        new ResourceMaterial(8, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(9, Material.SHIP_XP, 13_934L),
                                                        new ResourceMaterial(10, Material.INTERCEPTOR_PARTS, Grade.THREE, 205L)
                                                ))
                                        ),
                                        new Level(29, 61_000, 38,
                                                new Scrap(297_720, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 1_467_727L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 65_686L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 196L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 56L),
                                                        new ResourceMaterial(5, Material.GAS, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 364L),
                                                        new ResourceMaterial(7, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 103L),
                                                        new ResourceMaterial(8, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(9, Material.SHIP_XP, 15_612L),
                                                        new ResourceMaterial(10, Material.INTERCEPTOR_PARTS, Grade.THREE, 238L)
                                                ))
                                        ),
                                        new Level(30, 69_000, 40,
                                                new Scrap(297_720, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 1_467_727L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 65_686L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 232L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 66L),
                                                        new ResourceMaterial(5, Material.GAS, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 431L),
                                                        new ResourceMaterial(7, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 122L),
                                                        new ResourceMaterial(8, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 2L),
                                                        new ResourceMaterial(9, Material.SHIP_XP, 17_509L),
                                                        new ResourceMaterial(10, Material.INTERCEPTOR_PARTS, Grade.THREE, 286L)
                                                ))
                                        )
                                ),
                                addComponents(
                                        new Component(1, ComponentName.WARP_ENGINES,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 1195L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 62_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 29L),
                                                        new ResourceMaterial(2, Material.INTERCEPTOR_PARTS, Grade.THREE, 100L)
                                                )
                                        ),
                                        new Component(2, ComponentName.CARGO_BAY,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 10_000L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 550_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 425L),
                                                        new ResourceMaterial(2, Material.INTERCEPTOR_PARTS, Grade.THREE, 34L)
                                                )
                                        ),
                                        new Component(3, ComponentName.IMPULSE_ENGINE,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 10_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 1991L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 1_100_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 19L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 130L),
                                                        new ResourceMaterial(3, Material.INTERCEPTOR_PARTS, Grade.THREE, 130L)
                                                )
                                        ),
                                        new Component(4, ComponentName.PHASER_CANNON,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 5486L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 664L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 550_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 62_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 29L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 130L),
                                                        new ResourceMaterial(3, Material.INTERCEPTOR_PARTS, Grade.THREE, 170L)
                                                )
                                        ),
                                        new Component(5, ComponentName.PHOTON_TORPEDO,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 18_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 797L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 1_850_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 37_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 2L),
                                                        new ResourceMaterial(3, Material.INTERCEPTOR_PARTS, Grade.THREE, 200L)
                                                )
                                        ),
                                        new Component(6, ComponentName.PHOTON_TORPEDO,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 18_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 797L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 1_850_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 37_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 2L),
                                                        new ResourceMaterial(3, Material.INTERCEPTOR_PARTS, Grade.THREE, 200L)
                                                )
                                        )
                                )
                        ),
                        new Tier(7, 405_000, 26_922,
                                addShipLevels(
                                        new Level(31, 72_000, 40,
                                                new Scrap(320_640, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 3_012_450L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 147_178L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 151L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 68L),
                                                        new ResourceMaterial(5, Material.GAS, Rarity.RARE, Grade.THREE, 2L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 280L),
                                                        new ResourceMaterial(7, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 126L),
                                                        new ResourceMaterial(8, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 3L),
                                                        new ResourceMaterial(9, Material.SHIP_XP, 17_718L),
                                                        new ResourceMaterial(10, Material.INTERCEPTOR_PARTS, Grade.THREE, 300L)
                                                ))
                                        ),
                                        new Level(32, 81_000, 41,
                                                new Scrap(320_640, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 3_012_450L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 147_178L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 164L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 74L),
                                                        new ResourceMaterial(5, Material.GAS, Rarity.RARE, Grade.THREE, 2L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 305L),
                                                        new ResourceMaterial(7, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 137L),
                                                        new ResourceMaterial(8, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 3L),
                                                        new ResourceMaterial(9, Material.SHIP_XP, 19_743L),
                                                        new ResourceMaterial(10, Material.INTERCEPTOR_PARTS, Grade.THREE, 329L)
                                                ))
                                        ),
                                        new Level(33, 86_000, 42,
                                                new Scrap(320_640, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 3_012_450L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 147_178L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 191L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 86L),
                                                        new ResourceMaterial(5, Material.GAS, Rarity.RARE, Grade.THREE, 2L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 354L),
                                                        new ResourceMaterial(7, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 160L),
                                                        new ResourceMaterial(8, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 3L),
                                                        new ResourceMaterial(9, Material.SHIP_XP, 21_893L),
                                                        new ResourceMaterial(10, Material.INTERCEPTOR_PARTS, Grade.THREE, 386L)
                                                ))
                                        ),
                                        new Level(34, 95_000, 43,
                                                new Scrap(320_640, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 3_012_450L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 147_178L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 224L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 101L),
                                                        new ResourceMaterial(5, Material.GAS, Rarity.RARE, Grade.THREE, 2L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 416L),
                                                        new ResourceMaterial(7, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 187L),
                                                        new ResourceMaterial(8, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 4L),
                                                        new ResourceMaterial(9, Material.SHIP_XP, 24_268L),
                                                        new ResourceMaterial(10, Material.INTERCEPTOR_PARTS, Grade.THREE, 458L)
                                                ))
                                        ),
                                        new Level(35, 100_000, 44,
                                                new Scrap(320_640, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 3_012_450L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 147_178L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 271L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 122L),
                                                        new ResourceMaterial(5, Material.GAS, Rarity.RARE, Grade.THREE, 3L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 502L),
                                                        new ResourceMaterial(7, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 226L),
                                                        new ResourceMaterial(8, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 4L),
                                                        new ResourceMaterial(9, Material.SHIP_XP, 26_768L),
                                                        new ResourceMaterial(10, Material.INTERCEPTOR_PARTS, Grade.THREE, 559L)
                                                ))
                                        )
                                ),
                                addComponents(
                                        new Component(1, ComponentName.WARP_ENGINES,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 2741L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 161_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 70L),
                                                        new ResourceMaterial(2, Material.INTERCEPTOR_PARTS, Grade.THREE, 230L)
                                                )
                                        ),
                                        new Component(2, ComponentName.CARGO_BAY,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 23_000L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 1_350_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 1000L),
                                                        new ResourceMaterial(2, Material.INTERCEPTOR_PARTS, Grade.THREE, 80L)
                                                )
                                        ),
                                        new Component(3, ComponentName.IMPULSE_ENGINE,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 23_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 4569L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 2_700_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 45L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 300L),
                                                        new ResourceMaterial(3, Material.INTERCEPTOR_PARTS, Grade.THREE, 300L)
                                                )
                                        ),
                                        new Component(4, ComponentName.PHASER_CANNON,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 11_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 1523L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 1_350_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 161_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 5L),
                                                        new ResourceMaterial(3, Material.INTERCEPTOR_PARTS, Grade.THREE, 375L)
                                                )
                                        ),
                                        new Component(5, ComponentName.PHOTON_TORPEDO,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 39_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 1827L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 4_500_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 97_000)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 6L),
                                                        new ResourceMaterial(3, Material.INTERCEPTOR_PARTS, Grade.THREE, 450L)
                                                )
                                        ),
                                        new Component(6, ComponentName.PHOTON_TORPEDO,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 39_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 1827L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 4_500_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 97_000)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 6L),
                                                        new ResourceMaterial(3, Material.INTERCEPTOR_PARTS, Grade.THREE, 450L)
                                                )
                                        )
                                )
                        ),
                        new Tier(8, 526_500, 33_222,
                                addShipLevels(
                                        new Level(36, 105_000, 46,
                                                new Scrap(343_500, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 6_688_114L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 286_594L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 112L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 126L),
                                                        new ResourceMaterial(5, Material.GAS, Rarity.RARE, Grade.THREE, 4L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 207L),
                                                        new ResourceMaterial(7, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 233L),
                                                        new ResourceMaterial(8, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 6L),
                                                        new ResourceMaterial(9, Material.SHIP_XP, 26_453L),
                                                        new ResourceMaterial(10, Material.INTERCEPTOR_PARTS, Grade.THREE, 579L)
                                                ))
                                        ),
                                        new Level(37, 116_000, 47,
                                                new Scrap(343_500, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 6_688_114L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 286_594L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 121L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 136L),
                                                        new ResourceMaterial(5, Material.GAS, Rarity.RARE, Grade.THREE, 4L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 225L),
                                                        new ResourceMaterial(7, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 253L),
                                                        new ResourceMaterial(8, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 7L),
                                                        new ResourceMaterial(9, Material.SHIP_XP, 29_063L),
                                                        new ResourceMaterial(10, Material.INTERCEPTOR_PARTS, Grade.THREE, 629L)
                                                ))
                                        ),
                                        new Level(38, 122_000, 48,
                                                new Scrap(343_500, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 6_688_114L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 286_594L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 140L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 158L),
                                                        new ResourceMaterial(5, Material.GAS, Rarity.RARE, Grade.THREE, 4L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 260L),
                                                        new ResourceMaterial(7, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 292L),
                                                        new ResourceMaterial(8, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 8L),
                                                        new ResourceMaterial(9, Material.SHIP_XP, 31_808L),
                                                        new ResourceMaterial(10, Material.INTERCEPTOR_PARTS, Grade.THREE, 731L)
                                                ))
                                        ),
                                        new Level(39, 134_000, 49,
                                                new Scrap(343_500, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 6_688_114L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 286_594L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 164L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 184L),
                                                        new ResourceMaterial(5, Material.GAS, Rarity.RARE, Grade.THREE, 5L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 303L),
                                                        new ResourceMaterial(7, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 341L),
                                                        new ResourceMaterial(8, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 9L),
                                                        new ResourceMaterial(9, Material.SHIP_XP, 34_823L),
                                                        new ResourceMaterial(10, Material.INTERCEPTOR_PARTS, Grade.THREE, 858L)
                                                ))
                                        ),
                                        new Level(40, 140_000, 50,
                                                new Scrap(343_500, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 6_688_114L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 286_594L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 196L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 221L),
                                                        new ResourceMaterial(5, Material.GAS, Rarity.RARE, Grade.THREE, 6L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 364L),
                                                        new ResourceMaterial(7, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 410L),
                                                        new ResourceMaterial(8, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 11L),
                                                        new ResourceMaterial(9, Material.SHIP_XP, 37_973L),
                                                        new ResourceMaterial(10, Material.INTERCEPTOR_PARTS, Grade.THREE, 1035L)
                                                ))
                                        )
                                ),
                                addComponents(
                                        new Component(1, ComponentName.WARP_ENGINES,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 4775L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 290_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 140L),
                                                        new ResourceMaterial(2, Material.INTERCEPTOR_PARTS, Grade.THREE, 425L)
                                                )
                                        ),
                                        new Component(2, ComponentName.CARGO_BAY,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 38_000L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 3_400_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 160L),
                                                        new ResourceMaterial(2, Material.INTERCEPTOR_PARTS, Grade.THREE, 140L)
                                                )
                                        ),
                                        new Component(3, ComponentName.IMPULSE_ENGINE,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 38_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 7959L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 6_750_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.RARE, Grade.THREE, 2L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 11L),
                                                        new ResourceMaterial(3, Material.INTERCEPTOR_PARTS, Grade.THREE, 550L)
                                                )
                                        ),
                                        new Component(4, ComponentName.PHASER_CANNON,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 19_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 2653L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 3_400_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 290_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.RARE, Grade.THREE, 3L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 11L),
                                                        new ResourceMaterial(3, Material.INTERCEPTOR_PARTS, Grade.THREE, 700L)
                                                )
                                        ),
                                        new Component(5, ComponentName.PHOTON_TORPEDO,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 64_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 3_184L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 11_300_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 174_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.RARE, Grade.THREE, 3L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 14L),
                                                        new ResourceMaterial(3, Material.INTERCEPTOR_PARTS, Grade.THREE, 850L)
                                                )
                                        ),
                                        new Component(6, ComponentName.PHOTON_TORPEDO,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 64_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 3_184L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 11_300_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 174_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.RARE, Grade.THREE, 3L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 14L),
                                                        new ResourceMaterial(3, Material.INTERCEPTOR_PARTS, Grade.THREE, 850L)
                                                )
                                        )
                                )
                        ),
                        new Tier(9, 648_000, 39_732,
                                addShipLevels(
                                        new Level(41, 154_000, 51,
                                                new Scrap(366_420, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 11_996_900L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 503_212L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 199L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.RARE, Grade.THREE, 8L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 370L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 14L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 36_834L),
                                                        new ResourceMaterial(8, Material.INTERCEPTOR_PARTS, Grade.THREE, 1048L)
                                                ))
                                        ),
                                        new Level(42, 161_000, 52,
                                                new Scrap(366_420, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 11_996_900L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 503_212L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 214L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.RARE, Grade.THREE, 8L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 397L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 15L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 40_054L),
                                                        new ResourceMaterial(8, Material.INTERCEPTOR_PARTS, Grade.THREE, 1121L)
                                                ))
                                        ),
                                        new Level(43, 176_000, 53,
                                                new Scrap(366_420, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 11_996_900L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 503_212L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 243L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.RARE, Grade.THREE, 10L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 450L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 17L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 43_574L),
                                                        new ResourceMaterial(8, Material.INTERCEPTOR_PARTS, Grade.THREE, 1267L)
                                                ))
                                        ),
                                        new Level(44, 183_000, 54,
                                                new Scrap(366_420, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 11_996_900L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 503_212L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 279L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.RARE, Grade.THREE, 11L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 518L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 20L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 47_234L),
                                                        new ResourceMaterial(8, Material.INTERCEPTOR_PARTS, Grade.THREE, 1449L)
                                                ))
                                        ),
                                        new Level(45, 200_000, 60,
                                                new Scrap(366_420, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 11_996_900L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 503_212L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 330L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.RARE, Grade.THREE, 13L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 612L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 23L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 51_234L),
                                                        new ResourceMaterial(8, Material.INTERCEPTOR_PARTS, Grade.THREE, 1705L)
                                                ))
                                        )
                                ),
                                addComponents(
                                        new Component(1, ComponentName.WARP_ENGINES,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 9158L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 475_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.RARE, Grade.THREE, 4L),
                                                        new ResourceMaterial(2, Material.INTERCEPTOR_PARTS, Grade.THREE, 625L)
                                                )
                                        ),
                                        new Component(2, ComponentName.CARGO_BAY,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 65_000L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 5_350_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 275L),
                                                        new ResourceMaterial(2, Material.INTERCEPTOR_PARTS, Grade.THREE, 210L)
                                                )
                                        ),
                                        new Component(3, ComponentName.IMPULSE_ENGINE,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 65_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 15_000L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 10_700_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.RARE, Grade.THREE, 3L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 20L),
                                                        new ResourceMaterial(3, Material.INTERCEPTOR_PARTS, Grade.THREE, 850L)
                                                )
                                        ),
                                        new Component(4, ComponentName.PHASER_CANNON,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 32_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 5088L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 5_350_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 475_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.RARE, Grade.THREE, 4L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 20L),
                                                        new ResourceMaterial(3, Material.INTERCEPTOR_PARTS, Grade.THREE, 1050L)
                                                )
                                        ),
                                        new Component(5, ComponentName.PHOTON_TORPEDO,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 109_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 6105L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 17_800_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 285_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.RARE, Grade.THREE, 6L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 24L),
                                                        new ResourceMaterial(3, Material.INTERCEPTOR_PARTS, Grade.THREE, 1250L)
                                                )
                                        ),
                                        new Component(6, ComponentName.PHOTON_TORPEDO,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 109_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 6105L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 17_800_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 285_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.RARE, Grade.THREE, 6L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 24L),
                                                        new ResourceMaterial(3, Material.INTERCEPTOR_PARTS, Grade.THREE, 1250L)
                                                )
                                        )
                                )
                        )
                )
        );
    }

    private Ship getTuras() {
        return new Ship(
                "Turas",
                Rarity.COMMON,
                Grade.TWO,
                ShipClass.EXPLORER,
                img(R.drawable.turas),
                0,
                "Interceptor Hunter",
                12,
                20,
                addTiers(
                        new Tier(1, 46_800, 1638,
                                addShipLevels(
                                        new Level(1, 0, 10,
                                                new Scrap(56_940, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 5000L)
                                                ))
                                        ),
                                        new Level(2, 130, 11,
                                                new Scrap(56_940, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 5000L),
                                                        new ResourceMaterial(2, Material.SHIP_XP, 16L)
                                                ))
                                        ),
                                        new Level(3, 150, 12,
                                                new Scrap(56_940, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 5000L),
                                                        new ResourceMaterial(2, Material.SHIP_XP, 34L)
                                                ))
                                        ),
                                        new Level(4, 180, 13,
                                                new Scrap(56_940, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 5000L),
                                                        new ResourceMaterial(2, Material.SHIP_XP, 55L)
                                                ))
                                        ),
                                        new Level(5, 250, 14,
                                                new Scrap(56_940, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 5000L),
                                                        new ResourceMaterial(2, Material.SHIP_XP, 85L)
                                                ))
                                        )
                                ),
                                addComponents(
                                        new Component(1, ComponentName.BUILD_SHIP_TOTAL,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 272L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 12_500L)
                                                ),
                                                setEmpty()
                                        )
                                )
                        ),
                        new Tier(2, 12_000, 1860,
                                addShipLevels(
                                        new Level(6, 300, 15,
                                                new Scrap(75_900, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 7925L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 237L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 1L),
                                                        new ResourceMaterial(4, Material.ORE, Rarity.COMMON, Grade.THREE, 1L),
                                                        new ResourceMaterial(5, Material.SHIP_XP, 114L),
                                                        new ResourceMaterial(6, Material.EXPLORER_PARTS, Grade.THREE, 1L)
                                                ))
                                        ),
                                        new Level(7, 350, 16,
                                                new Scrap(75_900, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 7925L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 237L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 1L),
                                                        new ResourceMaterial(4, Material.ORE, Rarity.COMMON, Grade.THREE, 1L),
                                                        new ResourceMaterial(5, Material.SHIP_XP, 153L),
                                                        new ResourceMaterial(6, Material.EXPLORER_PARTS, Grade.THREE, 1L)
                                                ))
                                        ),
                                        new Level(8, 500, 17,
                                                new Scrap(75_900, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 7925L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 237L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 2L),
                                                        new ResourceMaterial(4, Material.ORE, Rarity.COMMON, Grade.THREE, 1L),
                                                        new ResourceMaterial(5, Material.SHIP_XP, 209L),
                                                        new ResourceMaterial(6, Material.EXPLORER_PARTS, Grade.THREE, 1L)
                                                ))
                                        ),
                                        new Level(9, 550, 18,
                                                new Scrap(75_900, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 7925L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 237L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 2L),
                                                        new ResourceMaterial(4, Material.ORE, Rarity.COMMON, Grade.THREE, 1L),
                                                        new ResourceMaterial(5, Material.SHIP_XP, 271L),
                                                        new ResourceMaterial(6, Material.EXPLORER_PARTS, Grade.THREE, 1L)
                                                ))
                                        ),
                                        new Level(10, 650, 19,
                                                new Scrap(75_900, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 7925L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 237L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 2L),
                                                        new ResourceMaterial(4, Material.ORE, Rarity.COMMON, Grade.THREE, 1L),
                                                        new ResourceMaterial(5, Material.SHIP_XP, 344L),
                                                        new ResourceMaterial(6, Material.EXPLORER_PARTS, Grade.THREE, 2L)
                                                ))
                                        )
                                ),
                                addComponents(
                                        new Component(1, ComponentName.WARP_ENGINES,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 4L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 130L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.EXPLORER_PARTS, Grade.TWO, 4L)
                                                )
                                        ),
                                        new Component(2, ComponentName.CARGO_BAY,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 12L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 1200L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.EXPLORER_PARTS, Grade.TWO, 2L)
                                                )
                                        ),
                                        new Component(3, ComponentName.SHIELD,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 12L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 7L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 3000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.EXPLORER_PARTS, Grade.TWO, 6L)
                                                )
                                        ),
                                        new Component(4, ComponentName.PHASER_CANNON,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 18L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 7L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 1800L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 250L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.EXPLORER_PARTS, Grade.TWO, 12L)
                                                )
                                        ),
                                        new Component(5, ComponentName.PHASER_CANNON,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 18L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 7L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 1800L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 250L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.EXPLORER_PARTS, Grade.TWO, 12L)
                                                )
                                        )
                                )
                        ),
                        new Tier(3, 24_000, 2238,
                                addShipLevels(
                                        new Level(11, 700, 20,
                                                new Scrap(94_860, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 12_665L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 702L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 3L),
                                                        new ResourceMaterial(4, Material.ORE, Rarity.COMMON, Grade.THREE, 2L),
                                                        new ResourceMaterial(5, Material.SHIP_XP, 395L),
                                                        new ResourceMaterial(6, Material.EXPLORER_PARTS, Grade.THREE, 2L)
                                                ))
                                        ),
                                        new Level(12, 900, 21,
                                                new Scrap(94_860, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 12_665L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 702L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 4L),
                                                        new ResourceMaterial(4, Material.ORE, Rarity.COMMON, Grade.THREE, 2L),
                                                        new ResourceMaterial(5, Material.SHIP_XP, 489L),
                                                        new ResourceMaterial(6, Material.EXPLORER_PARTS, Grade.THREE, 2L)
                                                ))
                                        ),
                                        new Level(13, 1000, 22,
                                                new Scrap(94_860, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 12_665L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 702L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 6L),
                                                        new ResourceMaterial(4, Material.ORE, Rarity.COMMON, Grade.THREE, 3L),
                                                        new ResourceMaterial(5, Material.SHIP_XP, 594L),
                                                        new ResourceMaterial(6, Material.EXPLORER_PARTS, Grade.THREE, 3L)
                                                ))
                                        ),
                                        new Level(14, 1100, 23,
                                                new Scrap(94_860, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 12_665L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 702L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 8L),
                                                        new ResourceMaterial(4, Material.ORE, Rarity.COMMON, Grade.THREE, 5L),
                                                        new ResourceMaterial(5, Material.SHIP_XP, 710L),
                                                        new ResourceMaterial(6, Material.EXPLORER_PARTS, Grade.THREE, 3L)
                                                ))
                                        ),
                                        new Level(15, 1400, 24,
                                                new Scrap(94_860, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 12_665L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 702L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 12L),
                                                        new ResourceMaterial(4, Material.ORE, Rarity.COMMON, Grade.THREE, 7L),
                                                        new ResourceMaterial(5, Material.SHIP_XP, 857L),
                                                        new ResourceMaterial(6, Material.EXPLORER_PARTS, Grade.THREE, 4L)
                                                ))
                                        )
                                ),
                                addComponents(
                                        new Component(1, ComponentName.WARP_ENGINES,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 8L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 275L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.EXPLORER_PARTS, Grade.TWO, 8L)
                                                )
                                        ),
                                        new Component(2, ComponentName.CARGO_BAY,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 26L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 2200L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.EXPLORER_PARTS, Grade.TWO, 4L)
                                                )
                                        ),
                                        new Component(3, ComponentName.SHIELD,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 26L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 14L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 5500L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.EXPLORER_PARTS, Grade.TWO, 12L)
                                                )
                                        ),
                                        new Component(4, ComponentName.PHASER_CANNON,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 39L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 14L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 3200L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 550L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.COMMON, Grade.TWO, 130L),
                                                        new ResourceMaterial(2, Material.EXPLORER_PARTS, Grade.TWO, 24L)
                                                )
                                        ),
                                        new Component(5, ComponentName.PHASER_CANNON,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 39L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 14L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 3200L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 550L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.COMMON, Grade.TWO, 130L),
                                                        new ResourceMaterial(2, Material.EXPLORER_PARTS, Grade.TWO, 24L)
                                                )
                                        )
                                )
                        ),
                        new Tier(4, 40_000, 2682,
                                addShipLevels(
                                        new Level(16, 1600, 25,
                                                new Scrap(113_820, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 19_789L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 1587L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 11L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 1L),
                                                        new ResourceMaterial(5, Material.ORE, Rarity.COMMON, Grade.THREE, 6L),
                                                        new ResourceMaterial(6, Material.ORE, Rarity.UNCOMMON, Grade.THREE, 1L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 952L),
                                                        new ResourceMaterial(8, Material.EXPLORER_PARTS, Grade.THREE, 5L)
                                                ))
                                        ),
                                        new Level(17, 1700, 26,
                                                new Scrap(113_820, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 19_789L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 1587L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 14L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 1L),
                                                        new ResourceMaterial(5, Material.ORE, Rarity.COMMON, Grade.THREE, 8L),
                                                        new ResourceMaterial(6, Material.ORE, Rarity.UNCOMMON, Grade.THREE, 1L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 1117L),
                                                        new ResourceMaterial(8, Material.EXPLORER_PARTS, Grade.THREE, 5L)
                                                ))
                                        ),
                                        new Level(18, 2100, 27,
                                                new Scrap(113_820, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 19_789L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 1587L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 18L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 2L),
                                                        new ResourceMaterial(5, Material.ORE, Rarity.COMMON, Grade.THREE, 10L),
                                                        new ResourceMaterial(6, Material.ORE, Rarity.UNCOMMON, Grade.THREE, 1L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 1322L),
                                                        new ResourceMaterial(8, Material.EXPLORER_PARTS, Grade.THREE, 6L)
                                                ))
                                        ),
                                        new Level(19, 2300, 28,
                                                new Scrap(113_820, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 19_789L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 1587L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 24L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 2L),
                                                        new ResourceMaterial(5, Material.ORE, Rarity.COMMON, Grade.THREE, 13L),
                                                        new ResourceMaterial(6, Material.ORE, Rarity.UNCOMMON, Grade.THREE, 1L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 1546L),
                                                        new ResourceMaterial(8, Material.EXPLORER_PARTS, Grade.THREE, 8L)
                                                ))
                                        ),
                                        new Level(20, 2500, 29,
                                                new Scrap(113_820, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 19_789L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 1587L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 32L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 2L),
                                                        new ResourceMaterial(5, Material.ORE, Rarity.COMMON, Grade.THREE, 18L),
                                                        new ResourceMaterial(6, Material.ORE, Rarity.UNCOMMON, Grade.THREE, 2L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 1790L),
                                                        new ResourceMaterial(8, Material.EXPLORER_PARTS, Grade.THREE, 9L)
                                                ))
                                        )
                                ),
                                addComponents(
                                        new Component(1, ComponentName.WARP_ENGINES,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 16L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 575L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.EXPLORER_PARTS, Grade.TWO, 14L)
                                                )
                                        ),
                                        new Component(2, ComponentName.CARGO_BAY,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 65L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 3600L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.EXPLORER_PARTS, Grade.TWO, 7L)
                                                )
                                        ),
                                        new Component(3, ComponentName.SHIELD,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 65L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 27L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 9000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.COMMON, Grade.TWO, 275L),
                                                        new ResourceMaterial(2, Material.EXPLORER_PARTS, Grade.TWO, 21L)
                                                )
                                        ),
                                        new Component(4, ComponentName.PHASER_CANNON,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 98L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 27L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 5500L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 1150L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.COMMON, Grade.TWO, 350L),
                                                        new ResourceMaterial(2, Material.EXPLORER_PARTS, Grade.TWO, 42L)
                                                )
                                        ),
                                        new Component(5, ComponentName.PHASER_CANNON,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 98L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 27L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 5500L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 1150L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.COMMON, Grade.TWO, 350L),
                                                        new ResourceMaterial(2, Material.EXPLORER_PARTS, Grade.TWO, 42L)
                                                )
                                        )
                                )
                        ),
                        new Tier(5, 60_000, 3354,
                                addShipLevels(
                                        new Level(21, 2600, 30,
                                                new Scrap(132_780, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 30_350L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 2972L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 29L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 4L),
                                                        new ResourceMaterial(5, Material.ORE, Rarity.COMMON, Grade.THREE, 16L),
                                                        new ResourceMaterial(6, Material.ORE, Rarity.UNCOMMON, Grade.THREE, 2L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 1886L),
                                                        new ResourceMaterial(8, Material.EXPLORER_PARTS, Grade.THREE, 10L)
                                                ))
                                        ),
                                        new Level(22, 3200, 31,
                                                new Scrap(132_780, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 30_350L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 2972L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 32L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 4L),
                                                        new ResourceMaterial(5, Material.ORE, Rarity.COMMON, Grade.THREE, 17L),
                                                        new ResourceMaterial(6, Material.ORE, Rarity.UNCOMMON, Grade.THREE, 2L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 2174L),
                                                        new ResourceMaterial(8, Material.EXPLORER_PARTS, Grade.THREE, 10L)
                                                ))
                                        ),
                                        new Level(23, 3400, 32,
                                                new Scrap(132_780, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 30_350L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 2972L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 37L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 4L),
                                                        new ResourceMaterial(5, Material.ORE, Rarity.COMMON, Grade.THREE, 20L),
                                                        new ResourceMaterial(6, Material.ORE, Rarity.UNCOMMON, Grade.THREE, 3L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 2480L),
                                                        new ResourceMaterial(8, Material.EXPLORER_PARTS, Grade.THREE, 12L)
                                                ))
                                        ),
                                        new Level(24, 3600, 33,
                                                new Scrap(132_780, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 30_350L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 2972L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 43L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 5L),
                                                        new ResourceMaterial(5, Material.ORE, Rarity.COMMON, Grade.THREE, 24L),
                                                        new ResourceMaterial(6, Material.ORE, Rarity.UNCOMMON, Grade.THREE, 3L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 2804L),
                                                        new ResourceMaterial(8, Material.EXPLORER_PARTS, Grade.THREE, 14L)
                                                ))
                                        ),
                                        new Level(25, 4400, 34,
                                                new Scrap(132_780, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 30_350L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 2972L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 53L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 6L),
                                                        new ResourceMaterial(5, Material.ORE, Rarity.COMMON, Grade.THREE, 29L),
                                                        new ResourceMaterial(6, Material.ORE, Rarity.UNCOMMON, Grade.THREE, 4L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 3200L),
                                                        new ResourceMaterial(8, Material.EXPLORER_PARTS, Grade.THREE, 17L)
                                                ))
                                        )
                                ),
                                addComponents(
                                        new Component(1, ComponentName.WARP_ENGINES,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 28L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 1025L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.COMMON, Grade.TWO, 250L),
                                                        new ResourceMaterial(2, Material.EXPLORER_PARTS, Grade.TWO, 24L)
                                                )
                                        ),
                                        new Component(2, ComponentName.CARGO_BAY,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 140L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 6000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.EXPLORER_PARTS, Grade.TWO, 12L)
                                                )
                                        ),
                                        new Component(3, ComponentName.SHIELD,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 140L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 46L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 15_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.COMMON, Grade.TWO, 525L),
                                                        new ResourceMaterial(2, Material.EXPLORER_PARTS, Grade.TWO, 36L)
                                                )
                                        ),
                                        new Component(4, ComponentName.PHASER_CANNON,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 209L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 46L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 9000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 2000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.UNCOMMON, Grade.TWO, 43L),
                                                        new ResourceMaterial(2, Material.EXPLORER_PARTS, Grade.TWO, 70L)
                                                )
                                        ),
                                        new Component(5, ComponentName.PHASER_CANNON,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 209L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 46L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 9000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 2000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.UNCOMMON, Grade.TWO, 43L),
                                                        new ResourceMaterial(2, Material.EXPLORER_PARTS, Grade.TWO, 70L)
                                                )
                                        )
                                )
                        ),
                        new Tier(6, 80_000, 4176,
                                addShipLevels(
                                        new Level(26, 4600, 35,
                                                new Scrap(151_800, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 47_556L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 5529L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 38L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 8L),
                                                        new ResourceMaterial(5, Material.GAS, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(6, Material.ORE, Rarity.COMMON, Grade.THREE, 21L),
                                                        new ResourceMaterial(7, Material.ORE, Rarity.UNCOMMON, Grade.THREE, 5L),
                                                        new ResourceMaterial(8, Material.ORE, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(9, Material.SHIP_XP, 3313L),
                                                        new ResourceMaterial(10, Material.EXPLORER_PARTS, Grade.THREE, 17L)
                                                ))
                                        ),
                                        new Level(27, 4900, 36,
                                                new Scrap(151_800, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 47_556L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 5529L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 42L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 9L),
                                                        new ResourceMaterial(5, Material.GAS, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(6, Material.ORE, Rarity.COMMON, Grade.THREE, 23L),
                                                        new ResourceMaterial(7, Material.ORE, Rarity.UNCOMMON, Grade.THREE, 5L),
                                                        new ResourceMaterial(8, Material.ORE, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(9, Material.SHIP_XP, 3717L),
                                                        new ResourceMaterial(10, Material.EXPLORER_PARTS, Grade.THREE, 18L)
                                                ))
                                        ),
                                        new Level(28, 5000, 37,
                                                new Scrap(151_800, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 47_556L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 5529L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 48L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 10L),
                                                        new ResourceMaterial(5, Material.GAS, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(6, Material.ORE, Rarity.COMMON, Grade.THREE, 26L),
                                                        new ResourceMaterial(7, Material.ORE, Rarity.UNCOMMON, Grade.THREE, 6L),
                                                        new ResourceMaterial(8, Material.ORE, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(9, Material.SHIP_XP, 4130L),
                                                        new ResourceMaterial(10, Material.EXPLORER_PARTS, Grade.THREE, 21L)
                                                ))
                                        ),
                                        new Level(29, 6000, 38,
                                                new Scrap(151_800, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 47_556L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 5529L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 57L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 12L),
                                                        new ResourceMaterial(5, Material.GAS, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(6, Material.ORE, Rarity.COMMON, Grade.THREE, 31L),
                                                        new ResourceMaterial(7, Material.ORE, Rarity.UNCOMMON, Grade.THREE, 7L),
                                                        new ResourceMaterial(8, Material.ORE, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(9, Material.SHIP_XP, 4625L),
                                                        new ResourceMaterial(10, Material.EXPLORER_PARTS, Grade.THREE, 25L)
                                                ))
                                        ),
                                        new Level(30, 6500, 40,
                                                new Scrap(151_8000, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 47_556L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 5529L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 68L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 14L),
                                                        new ResourceMaterial(5, Material.GAS, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(6, Material.ORE, Rarity.COMMON, Grade.THREE, 37L),
                                                        new ResourceMaterial(7, Material.ORE, Rarity.UNCOMMON, Grade.THREE, 8L),
                                                        new ResourceMaterial(8, Material.ORE, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(9, Material.SHIP_XP, 5161L),
                                                        new ResourceMaterial(10, Material.EXPLORER_PARTS, Grade.THREE, 30L)
                                                ))
                                        )
                                ),
                                addComponents(
                                        new Component(1, ComponentName.WARP_ENGINES,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 54L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 2000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.EXPLORER_PARTS, Grade.TWO, 48L)
                                                )
                                        ),
                                        new Component(2, ComponentName.CARGO_BAY,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 320L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 10_750L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.COMMON, Grade.TWO, 250L),
                                                        new ResourceMaterial(2, Material.EXPLORER_PARTS, Grade.TWO, 24L)
                                                )
                                        ),
                                        new Component(3, ComponentName.SHIELD,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 320L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 90L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 27_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.UNCOMMON, Grade.TWO, 80L),
                                                        new ResourceMaterial(2, Material.EXPLORER_PARTS, Grade.TWO, 70L)
                                                )
                                        ),
                                        new Component(4, ComponentName.PHASER_CANNON,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 480L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 90L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 16_250L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 4100L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.UNCOMMON, Grade.TWO, 100L),
                                                        new ResourceMaterial(2, Material.EXPLORER_PARTS, Grade.TWO, 140L)
                                                )
                                        ),
                                        new Component(5, ComponentName.PHASER_CANNON,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 480L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 90L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 16_250L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 4100L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.UNCOMMON, Grade.TWO, 100L),
                                                        new ResourceMaterial(2, Material.EXPLORER_PARTS, Grade.TWO, 140L)
                                                )
                                        )
                                )
                        ),
                        new Tier(7, 100_000, 4860,
                                addShipLevels(
                                        new Level(31, 6500, 42,
                                                new Scrap(170_760, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 82_689L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 10_977L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 56L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 16L),
                                                        new ResourceMaterial(5, Material.GAS, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(6, Material.ORE, Rarity.COMMON, Grade.THREE, 30L),
                                                        new ResourceMaterial(7, Material.ORE, Rarity.UNCOMMON, Grade.THREE, 9L),
                                                        new ResourceMaterial(8, Material.ORE, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(9, Material.SHIP_XP, 5180L),
                                                        new ResourceMaterial(10, Material.EXPLORER_PARTS, Grade.THREE, 30L)
                                                ))
                                        ),
                                        new Level(32, 8000, 44,
                                                new Scrap(170_760, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 82_689L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 10_977L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 61L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 18L),
                                                        new ResourceMaterial(5, Material.GAS, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(6, Material.ORE, Rarity.COMMON, Grade.THREE, 33L),
                                                        new ResourceMaterial(7, Material.ORE, Rarity.UNCOMMON, Grade.THREE, 10L),
                                                        new ResourceMaterial(8, Material.ORE, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(9, Material.SHIP_XP, 5780L),
                                                        new ResourceMaterial(10, Material.EXPLORER_PARTS, Grade.THREE, 33L)
                                                ))
                                        ),
                                        new Level(33, 8000, 46,
                                                new Scrap(170_760, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 82_689L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 10_977L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 72L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 21L),
                                                        new ResourceMaterial(5, Material.GAS, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(6, Material.ORE, Rarity.COMMON, Grade.THREE, 39L),
                                                        new ResourceMaterial(7, Material.ORE, Rarity.UNCOMMON, Grade.THREE, 11L),
                                                        new ResourceMaterial(8, Material.ORE, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(9, Material.SHIP_XP, 6380L),
                                                        new ResourceMaterial(10, Material.EXPLORER_PARTS, Grade.THREE, 39L)
                                                ))
                                        ),
                                        new Level(34, 8500, 48,
                                                new Scrap(170_760, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 82_689L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 10_977L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 86L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 25L),
                                                        new ResourceMaterial(5, Material.GAS, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(6, Material.ORE, Rarity.COMMON, Grade.THREE, 47L),
                                                        new ResourceMaterial(7, Material.ORE, Rarity.UNCOMMON, Grade.THREE, 13L),
                                                        new ResourceMaterial(8, Material.ORE, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(9, Material.SHIP_XP, 7017L),
                                                        new ResourceMaterial(10, Material.EXPLORER_PARTS, Grade.THREE, 47L)
                                                ))
                                        ),
                                        new Level(35, 10_000, 50,
                                                new Scrap(170_760, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 82_689L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 10_977L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 105L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 30L),
                                                        new ResourceMaterial(5, Material.GAS, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(6, Material.ORE, Rarity.COMMON, Grade.THREE, 57L),
                                                        new ResourceMaterial(7, Material.ORE, Rarity.UNCOMMON, Grade.THREE, 16L),
                                                        new ResourceMaterial(8, Material.ORE, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(9, Material.SHIP_XP, 7767L),
                                                        new ResourceMaterial(10, Material.EXPLORER_PARTS, Grade.THREE, 57L)
                                                ))
                                        )
                                ),
                                addComponents(
                                        new Component(1, ComponentName.WARP_ENGINES,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 130L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 4800L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.UNCOMMON, Grade.TWO, 100L),
                                                        new ResourceMaterial(2, Material.EXPLORER_PARTS, Grade.TWO, 110L)
                                                )
                                        ),
                                        new Component(2, ComponentName.CARGO_BAY,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 756L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 24_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.COMMON, Grade.TWO, 600L),
                                                        new ResourceMaterial(2, Material.EXPLORER_PARTS, Grade.TWO, 54L)
                                                )
                                        ),
                                        new Component(3, ComponentName.SHIELD,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 756L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 217L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 60_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.UNCOMMON, Grade.TWO, 190L),
                                                        new ResourceMaterial(2, Material.EXPLORER_PARTS, Grade.TWO, 160L)
                                                )
                                        ),
                                        new Component(4, ComponentName.PHASER_CANNON,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 1134L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 217L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 36_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 9500L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.UNCOMMON, Grade.TWO, 250L),
                                                        new ResourceMaterial(2, Material.EXPLORER_PARTS, Grade.TWO, 325L)
                                                )
                                        ),
                                        new Component(5, ComponentName.PHASER_CANNON,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 1134L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 217L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 36_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 9500L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.UNCOMMON, Grade.TWO, 250L),
                                                        new ResourceMaterial(2, Material.EXPLORER_PARTS, Grade.TWO, 325L)
                                                )
                                        )
                                )
                        )
                )
        );
    }

    private Ship getNorthStar() {
        return new Ship(
                "North Star",
                Rarity.RARE,
                Grade.THREE,
                ShipClass.SURVEY,
                img(R.drawable.north_star),
                0,
                "Healthy Mining",
                18,
                26,
                addTiers(
                        new Tier(1, 648_000, 2298,
                                addShipLevels(
                                        new Level(1, 0, 0.1f,
                                                new Scrap(365_400, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 78_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 6000L)
                                                ))
                                        ),
                                        new Level(2, 800, 0.1f,
                                                new Scrap(365_400, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 78_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 6000L),
                                                        new ResourceMaterial(3, Material.SHIP_XP, 32L)
                                                ))
                                        ),
                                        new Level(3, 1000, 0.1f,
                                                new Scrap(365_400, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 78_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 6000L),
                                                        new ResourceMaterial(3, Material.SHIP_XP, 72L)
                                                ))
                                        ),
                                        new Level(4, 1400, 0.1f,
                                                new Scrap(365_400, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 78_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 6000L),
                                                        new ResourceMaterial(3, Material.SHIP_XP, 128L)
                                                ))
                                        ),
                                        new Level(5, 1700, 0.2f,
                                                new Scrap(365_400, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 78_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 6000L),
                                                        new ResourceMaterial(3, Material.SHIP_XP, 196L)
                                                ))
                                        )
                                ),
                                addComponents(
                                        new Component(1, ComponentName.BUILD_SHIP_TOTAL,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 1900L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 235L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 520_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 30_000L)
                                                ),
                                                setEmpty()
                                        )
                                )
                        ),
                        new Tier(2, 97_200, 2616,
                                addShipLevels(
                                        new Level(6, 2400, 0.2f,
                                                new Scrap(411_120, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 133_632L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 9933L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 7L),
                                                        new ResourceMaterial(4, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 12L),
                                                        new ResourceMaterial(5, Material.SHIP_XP, 274L),
                                                        new ResourceMaterial(6, Material.SURVEY_PARTS, Grade.THREE, 6L)
                                                ))
                                        ),
                                        new Level(7, 2900, 0.2f,
                                                new Scrap(411_120, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 133_632L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 9933L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 8L),
                                                        new ResourceMaterial(4, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 15L),
                                                        new ResourceMaterial(5, Material.SHIP_XP, 383L),
                                                        new ResourceMaterial(6, Material.SURVEY_PARTS, Grade.THREE, 8L)
                                                ))
                                        ),
                                        new Level(8, 3900, 0.2f,
                                                new Scrap(411_120, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 133_632L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 9933L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 11L),
                                                        new ResourceMaterial(4, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 19L),
                                                        new ResourceMaterial(5, Material.SHIP_XP, 529L),
                                                        new ResourceMaterial(6, Material.SURVEY_PARTS, Grade.THREE, 10L)
                                                ))
                                        ),
                                        new Level(9, 4600, 0.2f,
                                                new Scrap(411_120, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 133_632L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 9933L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 13L),
                                                        new ResourceMaterial(4, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 24L),
                                                        new ResourceMaterial(5, Material.SHIP_XP, 701L),
                                                        new ResourceMaterial(6, Material.SURVEY_PARTS, Grade.THREE, 12L)
                                                ))
                                        ),
                                        new Level(10, 6000, 0.3f,
                                                new Scrap(411_120, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 133_632L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 9933L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 16L),
                                                        new ResourceMaterial(4, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 30L),
                                                        new ResourceMaterial(5, Material.SHIP_XP, 926L),
                                                        new ResourceMaterial(6, Material.SURVEY_PARTS, Grade.THREE, 15L)
                                                ))
                                        )
                                ),
                                addComponents(
                                        new Component(1, ComponentName.WARP_ENGINES,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 17L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 3400L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 7),
                                                        new ResourceMaterial(2, Material.SURVEY_PARTS, Grade.THREE, 10L)
                                                )
                                        ),
                                        new Component(2, ComponentName.CARGO_BAY,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 508L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 129_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 1700L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.COMMON, Grade.THREE, 4L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 13L),
                                                        new ResourceMaterial(3, Material.SURVEY_PARTS, Grade.THREE, 30L)
                                                )
                                        ),
                                        new Component(3, ComponentName.SHIELD,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 254L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 23L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 86_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.COMMON, Grade.THREE, 4L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 7L),
                                                        new ResourceMaterial(3, Material.SURVEY_PARTS, Grade.THREE, 15L)
                                                )
                                        ),
                                        new Component(4, ComponentName.IMPULSE_ENGINE,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 85L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 11L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 43_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 2500L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.COMMON, Grade.THREE, 2L),
                                                        new ResourceMaterial(2, Material.SURVEY_PARTS, Grade.THREE, 2L)
                                                )
                                        ),
                                        new Component(5, ComponentName.PHASER_CANNON,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 169L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 23L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 43_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 4200L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.COMMON, Grade.THREE, 6L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 7L),
                                                        new ResourceMaterial(3, Material.SURVEY_PARTS, Grade.THREE, 20L)
                                                )
                                        ),
                                        new Component(6, ComponentName.MINING_LASER,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 254L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 28L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 86_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 8500L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.COMMON, Grade.THREE, 6L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 17L),
                                                        new ResourceMaterial(3, Material.SURVEY_PARTS, Grade.THREE, 30L)
                                                )
                                        )
                                )
                        ),
                        new Tier(3, 194_400, 3060,
                                addShipLevels(
                                        new Level(11, 7000, 0.3f,
                                                new Scrap(456_780, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 227_602L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 18_648L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 16L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 1L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 28L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 2L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 1110L),
                                                        new ResourceMaterial(8, Material.SURVEY_PARTS, Grade.THREE, 17L)
                                                ))
                                        ),
                                        new Level(12, 8500, 0.3f,
                                                new Scrap(456_780, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 227_602L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 18_648L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 18L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 1L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 33L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 2L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 1407L),
                                                        new ResourceMaterial(8, Material.SURVEY_PARTS, Grade.THREE, 20L)
                                                ))
                                        ),
                                        new Level(13, 9500, 0.3f,
                                                new Scrap(456_780, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 227_602L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 18_648L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 23L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 1L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 42L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 2L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 1740L),
                                                        new ResourceMaterial(8, Material.SURVEY_PARTS, Grade.THREE, 25L)
                                                ))
                                        ),
                                        new Level(14, 11_000, 0.3f,
                                                new Scrap(456_780, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 227_602L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 18_648L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 29L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 2L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 53L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 3L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 2125L),
                                                        new ResourceMaterial(8, Material.SURVEY_PARTS, Grade.THREE, 31L)
                                                ))
                                        ),
                                        new Level(15, 13_500, 0.4f,
                                                new Scrap(456_780, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 227_602L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 18_648L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 37L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 2L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 69L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 4L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 2597L),
                                                        new ResourceMaterial(8, Material.SURVEY_PARTS, Grade.THREE, 40L)
                                                ))
                                        )
                                ),
                                addComponents(
                                        new Component(1, ComponentName.WARP_ENGINES,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 43L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 7750L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 20L),
                                                        new ResourceMaterial(2, Material.SURVEY_PARTS, Grade.THREE, 18L)
                                                )
                                        ),
                                        new Component(2, ComponentName.CARGO_BAY,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 1005L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 235_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 3900L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.COMMON, Grade.THREE, 12L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 40L),
                                                        new ResourceMaterial(3, Material.SURVEY_PARTS, Grade.THREE, 54L)
                                                )
                                        ),
                                        new Component(3, ComponentName.SHIELD,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 503L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 57L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 155_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.COMMON, Grade.THREE, 12L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 20L),
                                                        new ResourceMaterial(3, Material.SURVEY_PARTS, Grade.THREE, 27L)
                                                )
                                        ),
                                        new Component(4, ComponentName.IMPULSE_ENGINE,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 168L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 28L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 78_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 6000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.COMMON, Grade.THREE, 6L),
                                                        new ResourceMaterial(2, Material.SURVEY_PARTS, Grade.THREE, 4L)
                                                )
                                        ),
                                        new Component(5, ComponentName.PHASER_CANNON,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 335L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 57L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 78_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 9750L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.COMMON, Grade.THREE, 18L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 20L),
                                                        new ResourceMaterial(3, Material.SURVEY_PARTS, Grade.THREE, 36L)
                                                )
                                        ),
                                        new Component(6, ComponentName.MINING_LASER,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 503L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 71L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 155_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 19_750L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 1L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 2L),
                                                        new ResourceMaterial(3, Material.SURVEY_PARTS, Grade.THREE, 54L)
                                                )
                                        )
                                )
                        ),
                        new Tier(4, 324_000, 3780,
                                addShipLevels(
                                        new Level(16, 15_000, 0.4f,
                                                new Scrap(502_440, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 382_764L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 39_159L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 35L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 3L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 64L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 6L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 2899L),
                                                        new ResourceMaterial(8, Material.SURVEY_PARTS, Grade.THREE, 42L)
                                                ))
                                        ),
                                        new Level(17, 17_500, 0.4f,
                                                new Scrap(502_440, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 382_764L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 39_159L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 38L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 4L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 71L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 6L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 3468L),
                                                        new ResourceMaterial(8, Material.SURVEY_PARTS, Grade.THREE, 46L)
                                                ))
                                        ),
                                        new Level(18, 19_500, 0.4f,
                                                new Scrap(502_440, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 382_764L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 39_159L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 46L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 4L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 84L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 7L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 4102L),
                                                        new ResourceMaterial(8, Material.SURVEY_PARTS, Grade.THREE, 55L)
                                                ))
                                        ),
                                        new Level(19, 23_000, 0.4f,
                                                new Scrap(502_440, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 382_764L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 39_159L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 55L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 5L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 101L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 9L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 4849L),
                                                        new ResourceMaterial(8, Material.SURVEY_PARTS, Grade.THREE, 65L)
                                                ))
                                        ),
                                        new Level(20, 25_000, 0.5f,
                                                new Scrap(502_440, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 382_764L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 39_159L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 67L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 6L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 125L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 11L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 5662L),
                                                        new ResourceMaterial(8, Material.SURVEY_PARTS, Grade.THREE, 79L)
                                                ))
                                        )
                                ),
                                addComponents(
                                        new Component(1, ComponentName.WARP_ENGINES,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 110L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 19_250L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 53L),
                                                        new ResourceMaterial(2, Material.SURVEY_PARTS, Grade.THREE, 30L)
                                                )
                                        ),
                                        new Component(2, ComponentName.CARGO_BAY,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 1856L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 410_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 9750L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 2L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 6L),
                                                        new ResourceMaterial(3, Material.SURVEY_PARTS, Grade.THREE, 90L)
                                                )
                                        ),
                                        new Component(3, ComponentName.SHIELD,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 928L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 146L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 275_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.COMMON, Grade.THREE, 32L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 53L),
                                                        new ResourceMaterial(3, Material.SURVEY_PARTS, Grade.THREE, 45L)
                                                )
                                        ),
                                        new Component(4, ComponentName.IMPULSE_ENGINE,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 309L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 73L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 137_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 14_500L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.COMMON, Grade.THREE, 16L),
                                                        new ResourceMaterial(2, Material.SURVEY_PARTS, Grade.THREE, 7L)
                                                )
                                        ),
                                        new Component(5, ComponentName.PHASER_CANNON,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 619L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 146L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 137_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 24_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.COMMON, Grade.THREE, 48L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 53L),
                                                        new ResourceMaterial(3, Material.SURVEY_PARTS, Grade.THREE, 60L)
                                                )
                                        ),
                                        new Component(6, ComponentName.MINING_LASER,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 928L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 183L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 275_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 48_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 3L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 8L),
                                                        new ResourceMaterial(3, Material.SURVEY_PARTS, Grade.THREE, 90L)
                                                )
                                        )
                                )
                        ),
                        new Tier(5, 486_000, 4830,
                                addShipLevels(
                                        new Level(21, 29_000, 0.5f,
                                                new Scrap(548_100, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 654_500L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 81_242L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 55L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 10L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 102L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 17L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 6096L),
                                                        new ResourceMaterial(8, Material.SURVEY_PARTS, Grade.THREE, 81L)
                                                ))
                                        ),
                                        new Level(22, 31_500, 0.5f,
                                                new Scrap(548_100, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 654_500L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 81_242L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 60L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 10L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 110L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 19L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 7041L),
                                                        new ResourceMaterial(8, Material.SURVEY_PARTS, Grade.THREE, 87L)
                                                ))
                                        ),
                                        new Level(23, 36_000, 0.5f,
                                                new Scrap(548_1000, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 654_500L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 81_242L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 68L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 12L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 126L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 21L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 8121L),
                                                        new ResourceMaterial(8, Material.SURVEY_PARTS, Grade.THREE, 100L)
                                                ))
                                        ),
                                        new Level(24, 39_000, 0.5f,
                                                new Scrap(548_100, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 654_500L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 81_242L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 79L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 14L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 146L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 25L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 9291L),
                                                        new ResourceMaterial(8, Material.SURVEY_PARTS, Grade.THREE, 116L)
                                                ))
                                        ),
                                        new Level(25, 42_000, 0.6f,
                                                new Scrap(548_1000, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 654_500L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 81_242L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 94L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 16L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 174L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 29L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 10_551L),
                                                        new ResourceMaterial(8, Material.SURVEY_PARTS, Grade.THREE, 138L)
                                                ))
                                        )
                                ),
                                addComponents(
                                        new Component(1, ComponentName.WARP_ENGINES,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 241L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 41_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 100L),
                                                        new ResourceMaterial(2, Material.SURVEY_PARTS, Grade.THREE, 50L)
                                                )
                                        ),
                                        new Component(2, ComponentName.CARGO_BAY,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 3668L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 760_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 20_500L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 4L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 12L),
                                                        new ResourceMaterial(3, Material.SURVEY_PARTS, Grade.THREE, 150L)
                                                )
                                        ),
                                        new Component(3, ComponentName.SHIELD,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 1834L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 321L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 510_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.COMMON, Grade.THREE, 59L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 100L),
                                                        new ResourceMaterial(3, Material.SURVEY_PARTS, Grade.THREE, 70L)
                                                )
                                        ),
                                        new Component(4, ComponentName.IMPULSE_ENGINE,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 611L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 160L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 255_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 31_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.COMMON, Grade.THREE, 30L),
                                                        new ResourceMaterial(2, Material.SURVEY_PARTS, Grade.THREE, 12L)
                                                )
                                        ),
                                        new Component(5, ComponentName.PHASER_CANNON,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 1223L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 321L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 255_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 51_500L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 6L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 6L),
                                                        new ResourceMaterial(3, Material.SURVEY_PARTS, Grade.THREE, 100L)
                                                )
                                        ),
                                        new Component(6, ComponentName.MINING_LASER,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 1834L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 401L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 510_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 103_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 6L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 15L),
                                                        new ResourceMaterial(3, Material.SURVEY_PARTS, Grade.THREE, 150L)
                                                )
                                        )
                                )
                        ),
                        new Tier(6, 648_000, 6468,
                                addShipLevels(
                                        new Level(26, 47_000, 0.6f,
                                                new Scrap(593_820, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 1_110_175L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 168_245L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 64L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 18L),
                                                        new ResourceMaterial(5, Material.GAS, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 118L),
                                                        new ResourceMaterial(7, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 34L),
                                                        new ResourceMaterial(8, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(9, Material.SHIP_XP, 10_964L),
                                                        new ResourceMaterial(10, Material.SURVEY_PARTS, Grade.THREE, 140L)
                                                ))
                                        ),
                                        new Level(27, 51_000, 0.6f,
                                                new Scrap(593_8200, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 1_110_175L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 168_245L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 69L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 20L),
                                                        new ResourceMaterial(5, Material.GAS, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 127L),
                                                        new ResourceMaterial(7, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 36L),
                                                        new ResourceMaterial(8, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(9, Material.SHIP_XP, 12_367L),
                                                        new ResourceMaterial(10, Material.SURVEY_PARTS, Grade.THREE, 151L)
                                                ))
                                        ),
                                        new Level(28, 57_000, 0.6f,
                                                new Scrap(593_820, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 1_110_175L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 168_245L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 78L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 22L),
                                                        new ResourceMaterial(5, Material.GAS, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 145L),
                                                        new ResourceMaterial(7, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 41L),
                                                        new ResourceMaterial(8, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(9, Material.SHIP_XP, 13_934L),
                                                        new ResourceMaterial(10, Material.SURVEY_PARTS, Grade.THREE, 173L)
                                                ))
                                        ),
                                        new Level(29, 61_000, 0.6f,
                                                new Scrap(593_820, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 1_110_175L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 168_245L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 90L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 26L),
                                                        new ResourceMaterial(5, Material.GAS, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 168L),
                                                        new ResourceMaterial(7, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 47L),
                                                        new ResourceMaterial(8, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(9, Material.SHIP_XP, 15_612L),
                                                        new ResourceMaterial(10, Material.SURVEY_PARTS, Grade.THREE, 200L)
                                                ))
                                        ),
                                        new Level(30, 69_000, 0.7f,
                                                new Scrap(593_820, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 1_110_175L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 168_245L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 107L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 31L),
                                                        new ResourceMaterial(5, Material.GAS, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 199L),
                                                        new ResourceMaterial(7, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 56L),
                                                        new ResourceMaterial(8, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(9, Material.SHIP_XP, 17_509L),
                                                        new ResourceMaterial(10, Material.SURVEY_PARTS, Grade.THREE, 238L)
                                                ))
                                        )
                                ),
                                addComponents(
                                        new Component(1, ComponentName.WARP_ENGINES,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 497L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 89_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 200L),
                                                        new ResourceMaterial(2, Material.SURVEY_PARTS, Grade.THREE, 90L)
                                                )
                                        ),
                                        new Component(2, ComponentName.CARGO_BAY,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 6977L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 1_350_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 44_500L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 9L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 30L),
                                                        new ResourceMaterial(3, Material.SURVEY_PARTS, Grade.THREE, 275L)
                                                )
                                        ),
                                        new Component(3, ComponentName.SHIELD,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 3488L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 663L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 910_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 9L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 15L),
                                                        new ResourceMaterial(3, Material.SURVEY_PARTS, Grade.THREE, 130L)
                                                )
                                        ),
                                        new Component(4, ComponentName.IMPULSE_ENGINE,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 1163L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 332L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 455_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 67_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.COMMON, Grade.THREE, 59L),
                                                        new ResourceMaterial(2, Material.SURVEY_PARTS, Grade.THREE, 22L)
                                                )
                                        ),
                                        new Component(5, ComponentName.PHASER_CANNON,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 2326L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 663L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 455_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 111_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 13L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 15L),
                                                        new ResourceMaterial(3, Material.SURVEY_PARTS, Grade.THREE, 180L)
                                                )
                                        ),
                                        new Component(6, ComponentName.MINING_LASER,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 3488L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 829L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 910_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 220_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 13L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(3, Material.SURVEY_PARTS, Grade.THREE, 275L)
                                                )
                                        )
                                )
                        ),
                        new Tier(7, 810_000, 8700,
                                addShipLevels(
                                        new Level(31, 72_000, 0.7f,
                                                new Scrap(639_480, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 2_186_475L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 403_223L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 69L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 31L),
                                                        new ResourceMaterial(5, Material.GAS, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 127L),
                                                        new ResourceMaterial(7, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 58L),
                                                        new ResourceMaterial(8, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(9, Material.SHIP_XP, 17_718L),
                                                        new ResourceMaterial(10, Material.SURVEY_PARTS, Grade.THREE, 244L)
                                                ))
                                        ),
                                        new Level(32, 81_000, 0.7f,
                                                new Scrap(639_480, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 2_186_475L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 403_223L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 75L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 34L),
                                                        new ResourceMaterial(5, Material.GAS, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 139L),
                                                        new ResourceMaterial(7, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 63L),
                                                        new ResourceMaterial(8, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 2L),
                                                        new ResourceMaterial(9, Material.SHIP_XP, 19_743L),
                                                        new ResourceMaterial(10, Material.SURVEY_PARTS, Grade.THREE, 267L)
                                                ))
                                        ),
                                        new Level(33, 86_000, 0.7f,
                                                new Scrap(639_480, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 2_186_475L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 403_223L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 87L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 39L),
                                                        new ResourceMaterial(5, Material.GAS, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 161L),
                                                        new ResourceMaterial(7, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 73L),
                                                        new ResourceMaterial(8, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 2L),
                                                        new ResourceMaterial(9, Material.SHIP_XP, 21_893L),
                                                        new ResourceMaterial(10, Material.SURVEY_PARTS, Grade.THREE, 311L)
                                                ))
                                        ),
                                        new Level(34, 95_000, 0.7f,
                                                new Scrap(639_480, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 2_186_475L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 403_223L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 102L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 46L),
                                                        new ResourceMaterial(5, Material.GAS, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 189L),
                                                        new ResourceMaterial(7, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 85L),
                                                        new ResourceMaterial(8, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 2L),
                                                        new ResourceMaterial(9, Material.SHIP_XP, 24_268L),
                                                        new ResourceMaterial(10, Material.SURVEY_PARTS, Grade.THREE, 367L)
                                                ))
                                        ),
                                        new Level(35, 100_000, 0.8f,
                                                new Scrap(639_480, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 2_186_475L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 403_223L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 123L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 56L),
                                                        new ResourceMaterial(5, Material.GAS, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 228L),
                                                        new ResourceMaterial(7, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 103L),
                                                        new ResourceMaterial(8, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 2L),
                                                        new ResourceMaterial(9, Material.SHIP_XP, 26_768L),
                                                        new ResourceMaterial(10, Material.SURVEY_PARTS, Grade.THREE, 445L)
                                                ))
                                        )
                                ),
                                addComponents(
                                        new Component(1, ComponentName.WARP_ENGINES,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 1355L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 245_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 35L),
                                                        new ResourceMaterial(2, Material.SURVEY_PARTS, Grade.THREE, 200L)
                                                )
                                        ),
                                        new Component(2, ComponentName.CARGO_BAY,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 17_000L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 3_350_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 123_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 21L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 2L)
                                                )
                                        ),
                                        new Component(3, ComponentName.SHIELD,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 8745L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 1807L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 2_250_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 21L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 35L)
                                                )
                                        ),
                                        new Component(4, ComponentName.IMPULSE_ENGINE,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 2915L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 904L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 1_100_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 185_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.COMMON, Grade.THREE, 140L),
                                                        new ResourceMaterial(2, Material.SURVEY_PARTS, Grade.THREE, 50L)
                                                )
                                        ),
                                        new Component(5, ComponentName.PHASER_CANNON,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 5830L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 1807L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 1_100_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 310_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 31L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 35L),
                                                        new ResourceMaterial(3, Material.SURVEY_PARTS, Grade.THREE, 400L)
                                                )
                                        ),
                                        new Component(6, ComponentName.MINING_LASER,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 8745L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 2259L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 2_250_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 620_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 2L),
                                                        new ResourceMaterial(3, Material.SURVEY_PARTS, Grade.THREE, 600L)
                                                )
                                        )
                                )
                        ),
                        new Tier(8, 1_053_000, 11_616,
                                addShipLevels(
                                        new Level(36, 105_000, 0.8f,
                                                new Scrap(685_140, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 3_949_964L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 834_039L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 50L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 56L),
                                                        new ResourceMaterial(5, Material.GAS, Rarity.RARE, Grade.THREE, 2L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 93L),
                                                        new ResourceMaterial(7, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 104L),
                                                        new ResourceMaterial(8, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 3L),
                                                        new ResourceMaterial(9, Material.SHIP_XP, 26_453L),
                                                        new ResourceMaterial(10, Material.SURVEY_PARTS, Grade.THREE, 449L)
                                                ))
                                        ),
                                        new Level(37, 116_000, 0.8f,
                                                new Scrap(685_140, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 3_949_964L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 834_039L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 54L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 61L),
                                                        new ResourceMaterial(5, Material.GAS, Rarity.RARE, Grade.THREE, 2L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 100L),
                                                        new ResourceMaterial(7, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 113L),
                                                        new ResourceMaterial(8, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 3L),
                                                        new ResourceMaterial(9, Material.SHIP_XP, 29_063L),
                                                        new ResourceMaterial(10, Material.SURVEY_PARTS, Grade.THREE, 486L)
                                                ))
                                        ),
                                        new Level(38, 122_000, 0.8f,
                                                new Scrap(685_140, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 3_949_964L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 834_039L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 62L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 70L),
                                                        new ResourceMaterial(5, Material.GAS, Rarity.RARE, Grade.THREE, 2L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 115L),
                                                        new ResourceMaterial(7, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 130L),
                                                        new ResourceMaterial(8, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 4L),
                                                        new ResourceMaterial(9, Material.SHIP_XP, 31_808L),
                                                        new ResourceMaterial(10, Material.SURVEY_PARTS, Grade.THREE, 559L)
                                                ))
                                        ),
                                        new Level(39, 134_000, 0.8f,
                                                new Scrap(685_1400, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 3_949_964L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 834_039L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 73L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 82L),
                                                        new ResourceMaterial(5, Material.GAS, Rarity.RARE, Grade.THREE, 3L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 135L),
                                                        new ResourceMaterial(7, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 151L),
                                                        new ResourceMaterial(8, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 4L),
                                                        new ResourceMaterial(9, Material.SHIP_XP, 34_823L),
                                                        new ResourceMaterial(10, Material.SURVEY_PARTS, Grade.THREE, 650L)
                                                ))
                                        ),
                                        new Level(40, 140_000, 0.9f,
                                                new Scrap(685_140, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 3_949_964L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 834_039L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 87L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 98L),
                                                        new ResourceMaterial(5, Material.GAS, Rarity.RARE, Grade.THREE, 3L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 161L),
                                                        new ResourceMaterial(7, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 181L),
                                                        new ResourceMaterial(8, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 5L),
                                                        new ResourceMaterial(9, Material.SHIP_XP, 37_973L),
                                                        new ResourceMaterial(10, Material.SURVEY_PARTS, Grade.THREE, 777L)
                                                ))
                                        )
                                ),
                                addComponents(
                                        new Component(1, ComponentName.WARP_ENGINES,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 2737L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 475_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 70L),
                                                        new ResourceMaterial(2, Material.SURVEY_PARTS, Grade.THREE, 350L)
                                                )
                                        ),
                                        new Component(2, ComponentName.CARGO_BAY,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 32_000L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 5_900_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 235_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 4L),
                                                        new ResourceMaterial(3, Material.SURVEY_PARTS, Grade.THREE, 1050L)
                                                )
                                        ),
                                        new Component(3, ComponentName.SHIELD,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 16_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 3649L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 3_950_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 45L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 70L),
                                                        new ResourceMaterial(3, Material.SURVEY_PARTS, Grade.THREE, 525L)
                                                )
                                        ),
                                        new Component(4, ComponentName.IMPULSE_ENGINE,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 5441L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 1825L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 1_950_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 355_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 22L),
                                                        new ResourceMaterial(2, Material.SURVEY_PARTS, Grade.THREE, 90L)
                                                )
                                        ),
                                        new Component(5, ComponentName.PHASER_CANNON,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 10_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 3649L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 1_950_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 590_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 70L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 2L),
                                                        new ResourceMaterial(3, Material.SURVEY_PARTS, Grade.THREE, 700L)
                                                )
                                        ),
                                        new Component(6, ComponentName.MINING_LASER,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 16_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 4562L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 3_950_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 1_200_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.RARE, Grade.THREE, 2L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 5L),
                                                        new ResourceMaterial(3, Material.SURVEY_PARTS, Grade.THREE, 1050L)
                                                )
                                        )
                                )
                        ),
                        new Tier(9, 1_296_000, 14_634,
                                addShipLevels(
                                        new Level(41, 154_000, 0.9f,
                                                new Scrap(730_800, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 6_527_200L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 1_545_669L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 86L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.RARE, Grade.THREE, 4L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 160L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 6L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 36_834L),
                                                        new ResourceMaterial(8, Material.SURVEY_PARTS, Grade.THREE, 766L)
                                                ))
                                        ),
                                        new Level(42, 161_000, 0.9f,
                                                new Scrap(730_8000, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 6_527_200L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 1_545_669L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 92L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.RARE, Grade.THREE, 4L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 170L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 7L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 40_054L),
                                                        new ResourceMaterial(8, Material.SURVEY_PARTS, Grade.THREE, 815L)
                                                ))
                                        ),
                                        new Level(43, 176_000, 0.9f,
                                                new Scrap(730_800, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 6_527_200L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 1_545_669L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 104L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.RARE, Grade.THREE, 4L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 192L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 8L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 43_574L),
                                                        new ResourceMaterial(8, Material.SURVEY_PARTS, Grade.THREE, 912L)
                                                ))
                                        ),
                                        new Level(44, 183_000, 0.9f,
                                                new Scrap(730_800, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 6_527_200L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 1_545_669L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 118L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.RARE, Grade.THREE, 5L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 219L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 9L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 47_234L),
                                                        new ResourceMaterial(8, Material.SURVEY_PARTS, Grade.THREE, 1033L)
                                                ))
                                        ),
                                        new Level(45, 200_000, 1.0f,
                                                new Scrap(730_800, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 6_527_200L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 1_545_669L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 138L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.RARE, Grade.THREE, 6L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 257L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 10L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 51_234L),
                                                        new ResourceMaterial(8, Material.SURVEY_PARTS, Grade.THREE, 1203L)
                                                ))
                                        )
                                ),
                                addComponents(
                                        new Component(1, ComponentName.WARP_ENGINES,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 5085L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 830_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 120L),
                                                        new ResourceMaterial(2, Material.SURVEY_PARTS, Grade.THREE, 500L)
                                                )
                                        ),
                                        new Component(2, ComponentName.CARGO_BAY,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 52_000L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 9_350_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 415_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.RARE, Grade.THREE, 2L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 6L),
                                                        new ResourceMaterial(3, Material.SURVEY_PARTS, Grade.THREE, 1500L)
                                                )
                                        ),
                                        new Component(3, ComponentName.SHIELD,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 26_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 6744L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 6_250_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.RARE, Grade.THREE, 2L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 4L),
                                                        new ResourceMaterial(3, Material.SURVEY_PARTS, Grade.THREE, 750L)
                                                )
                                        ),
                                        new Component(4, ComponentName.IMPULSE_ENGINE,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 8821L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 3372L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 3_100_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 620_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 50L),
                                                        new ResourceMaterial(2, Material.SURVEY_PARTS, Grade.THREE, 120L)
                                                )
                                        ),
                                        new Component(5, ComponentName.PHASER_CANNON,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 17_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 6744L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 3_100_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 1_050_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.RARE, Grade.THREE, 3L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 4L),
                                                        new ResourceMaterial(3, Material.SURVEY_PARTS, Grade.THREE, 1000L)
                                                )
                                        ),
                                        new Component(6, ComponentName.MINING_LASER,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 26_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 8429L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 6_250_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 2_050_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.RARE, Grade.THREE, 3L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 8L),
                                                        new ResourceMaterial(3, Material.SURVEY_PARTS, Grade.THREE, 1500L)
                                                )
                                        )
                                )
                        )
                )
        );
    }

    private Ship getBotanyBay() {
        return new Ship(
                "Botany Bay",
                Rarity.UNCOMMON,
                Grade.THREE,
                ShipClass.SURVEY,
                img(R.drawable.botany_bay),
                0,
                "Data Mining",
                18,
                -1,
                addTiers(
                        new Tier(1, 522_000, 1590,
                                addShipLevels(
                                        new Level(1, 0, 26_500),
                                        new Level(2, 800, 26_850),
                                        new Level(3, 1000, 27_200),
                                        new Level(4, 1400, 27_500),
                                        new Level(5, 1700, 27_800)
                                ),
                                addComponents(
                                        new Component(1, ComponentName.BUILD_SHIP_TOTAL,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 326L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 35L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 800_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 28_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.COMMON, Grade.THREE, 180L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 725L)
                                                )
                                        )
                                )
                        ),
                        new Tier(2, 96_000, 1908,
                                addShipLevels(
                                        new Level(6, 2400, 28_150),
                                        new Level(7, 2900, 28_500),
                                        new Level(8, 3900, 28_800),
                                        new Level(9, 4600, 29_100),
                                        new Level(10, 6000, 29_450)
                                ),
                                addComponents(
                                        new Component(1, ComponentName.WARP_ENGINES,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 6L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 250L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.ORE, Rarity.COMMON, Grade.TWO, 240L),
                                                        new ResourceMaterial(2, Material.SURVEY_PARTS, Grade.TWO, 30L)
                                                )
                                        ),
                                        new Component(2, ComponentName.CARGO_BAY,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 94L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 8000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 120L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.COMMON, Grade.TWO, 60L),
                                                        new ResourceMaterial(2, Material.ORE, Rarity.COMMON, Grade.TWO, 480L),
                                                        new ResourceMaterial(3, Material.SURVEY_PARTS, Grade.TWO, 80L)
                                                )
                                        ),
                                        new Component(3, ComponentName.SHIELD,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 47L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 8L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 5500L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.COMMON, Grade.TWO, 60L),
                                                        new ResourceMaterial(2, Material.ORE, Rarity.COMMON, Grade.TWO, 240L),
                                                        new ResourceMaterial(3, Material.SURVEY_PARTS, Grade.TWO, 40L)
                                                )
                                        ),
                                        new Component(4, ComponentName.IMPULSE_ENGINE,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 16L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 4L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 2700L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 180L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.COMMON, Grade.TWO, 30L),
                                                        new ResourceMaterial(2, Material.SURVEY_PARTS, Grade.TWO, 10L)
                                                )
                                        ),
                                        new Component(5, ComponentName.PHOTON_TORPEDO,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 47L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 4L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 6750L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 120L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.COMMON, Grade.TWO, 90L),
                                                        new ResourceMaterial(2, Material.ORE, Rarity.COMMON, Grade.TWO, 240L),
                                                        new ResourceMaterial(3, Material.SURVEY_PARTS, Grade.TWO, 60L)
                                                )
                                        ),
                                        new Component(6, ComponentName.MINING_LASER,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 47L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 10L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 5500L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 600L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.COMMON, Grade.TWO, 90L),
                                                        new ResourceMaterial(2, Material.ORE, Rarity.COMMON, Grade.TWO, 600L),
                                                        new ResourceMaterial(3, Material.SURVEY_PARTS, Grade.TWO, 80L)
                                                )
                                        )
                                )
                        ),
                        new Tier(3, 192_000, 2460,
                                addShipLevels(
                                        new Level(11, 7000, 29_800),
                                        new Level(12, 8500, 30_125),
                                        new Level(13, 9500, 30_450),
                                        new Level(14, 11_000, 30_800),
                                        new Level(15, 13_500, 31_100)
                                ),
                                addComponents(
                                        new Component(1, ComponentName.WARP_ENGINES,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 11L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 500L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.ORE, Rarity.COMMON, Grade.TWO, 360L),
                                                        new ResourceMaterial(2, Material.SURVEY_PARTS, Grade.TWO, 58L)
                                                )
                                        ),
                                        new Component(2, ComponentName.CARGO_BAY,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 165L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 14_500L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 250L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.COMMON, Grade.TWO, 90L),
                                                        new ResourceMaterial(2, Material.ORE, Rarity.COMMON, Grade.TWO, 720L),
                                                        new ResourceMaterial(3, Material.SURVEY_PARTS, Grade.TWO, 170L)
                                                )
                                        ),
                                        new Component(3, ComponentName.SHIELD,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 83L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 14L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 9750L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.COMMON, Grade.TWO, 90L),
                                                        new ResourceMaterial(2, Material.ORE, Rarity.COMMON, Grade.TWO, 360L),
                                                        new ResourceMaterial(3, Material.SURVEY_PARTS, Grade.TWO, 90L)
                                                )
                                        ),
                                        new Component(4, ComponentName.IMPULSE_ENGINE,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 28L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 7L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 4900L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 375L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.COMMON, Grade.TWO, 45L),
                                                        new ResourceMaterial(2, Material.SURVEY_PARTS, Grade.TWO, 15L)
                                                )
                                        ),
                                        new Component(5, ComponentName.PHOTON_TORPEDO,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 83L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 7L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 12_250L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 250L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.COMMON, Grade.TWO, 135L),
                                                        new ResourceMaterial(2, Material.ORE, Rarity.COMMON, Grade.TWO, 360L),
                                                        new ResourceMaterial(3, Material.SURVEY_PARTS, Grade.TWO, 120L)
                                                )
                                        ),
                                        new Component(6, ComponentName.MINING_LASER,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 83L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 18L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 9750L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 1275L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.UNCOMMON, Grade.TWO, 14L),
                                                        new ResourceMaterial(2, Material.ORE, Rarity.UNCOMMON, Grade.TWO, 90L),
                                                        new ResourceMaterial(3, Material.SURVEY_PARTS, Grade.TWO, 170L)
                                                )
                                        )
                                )
                        ),
                        new Tier(4, 320_000, 3226,
                                addShipLevels(
                                        new Level(16, 15_000, 31_450),
                                        new Level(17, 17_500, 31_800),
                                        new Level(18, 19_500, 32_100),
                                        new Level(19, 23_000, 32_400),
                                        new Level(20, 25_000, 32_750)
                                ),
                                addComponents(
                                        new Component(1, ComponentName.WARP_ENGINES,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 20L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 950L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.ORE, Rarity.COMMON, Grade.TWO, 540L),
                                                        new ResourceMaterial(2, Material.SURVEY_PARTS, Grade.TWO, 120L)
                                                )
                                        ),
                                        new Component(2, ComponentName.CARGO_BAY,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 314L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 24_500L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 475L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.UNCOMMON, Grade.TWO, 14L),
                                                        new ResourceMaterial(2, Material.ORE, Rarity.UNCOMMON, Grade.TWO, 108L),
                                                        new ResourceMaterial(3, Material.SURVEY_PARTS, Grade.TWO, 350L)
                                                )
                                        ),
                                        new Component(3, ComponentName.SHIELD,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 157L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 27L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 16_250L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.COMMON, Grade.TWO, 135L),
                                                        new ResourceMaterial(2, Material.ORE, Rarity.COMMON, Grade.TWO, 540L),
                                                        new ResourceMaterial(3, Material.SURVEY_PARTS, Grade.TWO, 180L)
                                                )
                                        ),
                                        new Component(4, ComponentName.IMPULSE_ENGINE,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 52L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 13L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 8000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 700L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.COMMON, Grade.TWO, 68L),
                                                        new ResourceMaterial(2, Material.SURVEY_PARTS, Grade.TWO, 30L)
                                                )
                                        ),
                                        new Component(5, ComponentName.PHOTON_TORPEDO,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 157L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 13L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 20_500L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 475L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.COMMON, Grade.TWO, 203L),
                                                        new ResourceMaterial(2, Material.ORE, Rarity.COMMON, Grade.TWO, 540L),
                                                        new ResourceMaterial(3, Material.SURVEY_PARTS, Grade.TWO, 250L)
                                                )
                                        ),
                                        new Component(6, ComponentName.MINING_LASER,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 157L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 33L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 16_250L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 2400L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.UNCOMMON, Grade.TWO, 20L),
                                                        new ResourceMaterial(2, Material.ORE, Rarity.UNCOMMON, Grade.TWO, 135L),
                                                        new ResourceMaterial(3, Material.SURVEY_PARTS, Grade.TWO, 350L)
                                                )
                                        )
                                )
                        ),
                        new Tier(5, 480_000, 4194,
                                addShipLevels(
                                        new Level(21, 29_000, 33_100),
                                        new Level(22, 31_500, 33_450),
                                        new Level(23, 36_000, 33_750),
                                        new Level(24, 39_000, 34_100),
                                        new Level(25, 42_000, 34_400)
                                ),
                                addComponents(
                                        new Component(1, ComponentName.WARP_ENGINES,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 65L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 2500L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.ORE, Rarity.COMMON, Grade.THREE, 1L),
                                                        new ResourceMaterial(2, Material.SURVEY_PARTS, Grade.THREE, 5L)
                                                )
                                        ),
                                        new Component(2, ComponentName.CARGO_BAY,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 990L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 75_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 1275L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 1L),
                                                        new ResourceMaterial(2, Material.ORE, Rarity.UNCOMMON, Grade.THREE, 2L),
                                                        new ResourceMaterial(3, Material.SURVEY_PARTS, Grade.THREE, 14L)
                                                )
                                        ),
                                        new Component(3, ComponentName.SHIELD,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 495L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 86L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 50_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.COMMON, Grade.THREE, 3L),
                                                        new ResourceMaterial(2, Material.ORE, Rarity.COMMON, Grade.THREE, 12L),
                                                        new ResourceMaterial(3, Material.SURVEY_PARTS, Grade.THREE, 7L)
                                                )
                                        ),
                                        new Component(4, ComponentName.IMPULSE_ENGINE,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 165L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 43L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 25_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 1900L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.COMMON, Grade.THREE, 2L),
                                                        new ResourceMaterial(2, Material.SURVEY_PARTS, Grade.THREE, 1L)
                                                )
                                        ),
                                        new Component(5, ComponentName.PHOTON_TORPEDO,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 495L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 43L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 63_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 1275L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 5L),
                                                        new ResourceMaterial(2, Material.ORE, Rarity.UNCOMMON, Grade.THREE, 12L),
                                                        new ResourceMaterial(3, Material.SURVEY_PARTS, Grade.THREE, 10L)
                                                )
                                        ),
                                        new Component(6, ComponentName.MINING_LASER,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 495L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 108L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 50_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 6250L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 1L),
                                                        new ResourceMaterial(2, Material.ORE, Rarity.UNCOMMON, Grade.THREE, 3L),
                                                        new ResourceMaterial(3, Material.SURVEY_PARTS, Grade.THREE, 14L)
                                                )
                                        )
                                )
                        ),
                        new Tier(6, 640_000, 5574,
                                addShipLevels(
                                        new Level(26, 47_000, 34_750),
                                        new Level(27, 51_000, 35_100),
                                        new Level(28, 57_000, 35_400),
                                        new Level(29, 61_000, 35_700),
                                        new Level(30, 69_000, 36_000)
                                ),
                                addComponents(
                                        new Component(1, ComponentName.WARP_ENGINES,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 185L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 5500L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.ORE, Rarity.COMMON, Grade.THREE, 2L),
                                                        new ResourceMaterial(2, Material.SURVEY_PARTS, Grade.THREE, 19L)
                                                )
                                        ),
                                        new Component(2, ComponentName.CARGO_BAY,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 2690L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 184_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 2700L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 1L),
                                                        new ResourceMaterial(2, Material.ORE, Rarity.UNCOMMON, Grade.THREE, 5L),
                                                        new ResourceMaterial(3, Material.SURVEY_PARTS, Grade.THREE, 56L)
                                                )
                                        ),
                                        new Component(3, ComponentName.SHIELD,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 1345L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 247L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 122_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 6L),
                                                        new ResourceMaterial(2, Material.ORE, Rarity.UNCOMMON, Grade.THREE, 24L),
                                                        new ResourceMaterial(3, Material.SURVEY_PARTS, Grade.THREE, 28L)
                                                )
                                        ),
                                        new Component(4, ComponentName.IMPULSE_ENGINE,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 448L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 124L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 61_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 4000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.COMMON, Grade.THREE, 3L),
                                                        new ResourceMaterial(2, Material.SURVEY_PARTS, Grade.THREE, 5L)
                                                )
                                        ),
                                        new Component(5, ComponentName.PHOTON_TORPEDO,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 1345L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 124L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 153_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 2700L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 1L),
                                                        new ResourceMaterial(2, Material.ORE, Rarity.UNCOMMON, Grade.THREE, 2L),
                                                        new ResourceMaterial(3, Material.SURVEY_PARTS, Grade.THREE, 37L)
                                                )
                                        ),
                                        new Component(6, ComponentName.MINING_LASER,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 1345L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 309L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 122_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 13_500L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 1L),
                                                        new ResourceMaterial(2, Material.ORE, Rarity.RARE, Grade.THREE, 3L),
                                                        new ResourceMaterial(3, Material.SURVEY_PARTS, Grade.THREE, 56L)
                                                )
                                        )
                                )
                        ),
                        new Tier(7, 800_000, 6864,
                                addShipLevels(
                                        new Level(31, 72_000, 36_350),
                                        new Level(32, 81_000, 36_700),
                                        new Level(33, 86_000, 37_050),
                                        new Level(34, 95_000, 37_400),
                                        new Level(35, 100_000, 37_700)
                                ),
                                addComponents(
                                        new Component(1, ComponentName.WARP_ENGINES,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 476L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 15_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.ORE, Rarity.UNCOMMON, Grade.THREE, 5L),
                                                        new ResourceMaterial(2, Material.SURVEY_PARTS, Grade.THREE, 58L)
                                                )
                                        ),
                                        new Component(2, ComponentName.CARGO_BAY,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 6508L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 455_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 7500L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(2, Material.ORE, Rarity.RARE, Grade.THREE, 5L),
                                                        new ResourceMaterial(3, Material.SURVEY_PARTS, Grade.THREE, 170L)
                                                )
                                        ),
                                        new Component(3, ComponentName.SHIELD,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 3254L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 635L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 300_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 12L),
                                                        new ResourceMaterial(2, Material.ORE, Rarity.UNCOMMON, Grade.THREE, 48L),
                                                        new ResourceMaterial(3, Material.SURVEY_PARTS, Grade.THREE, 90L)
                                                )
                                        ),
                                        new Component(4, ComponentName.IMPULSE_ENGINE,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 1085L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 317L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 151_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 12_250L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.COMMON, Grade.THREE, 1L),
                                                        new ResourceMaterial(2, Material.SURVEY_PARTS, Grade.THREE, 14L)
                                                )
                                        ),
                                        new Component(5, ComponentName.PHOTON_TORPEDO,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 3254L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 317L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 380_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 7500L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 2L),
                                                        new ResourceMaterial(2, Material.ORE, Rarity.UNCOMMON, Grade.THREE, 5L),
                                                        new ResourceMaterial(3, Material.SURVEY_PARTS, Grade.THREE, 120L)
                                                )
                                        ),
                                        new Component(6, ComponentName.MINING_LASER,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 3254L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 793L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 300_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 38_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(2, Material.ORE, Rarity.RARE, Grade.THREE, 6L),
                                                        new ResourceMaterial(3, Material.SURVEY_PARTS, Grade.THREE, 170L)
                                                )
                                        )
                                )
                        ),
                        new Tier(8, 1_040_000, 8922,
                                addShipLevels(
                                        new Level(36, 105_000, 38_050),
                                        new Level(37, 116_000, 38_350),
                                        new Level(38, 122_000, 38_700),
                                        new Level(39, 134_000, 39_050),
                                        new Level(40, 140_000, 39_350)
                                ),
                                addComponents(
                                        new Component(1, ComponentName.WARP_ENGINES,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 1501L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 33_500L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.ORE, Rarity.UNCOMMON, Grade.THREE, 6L),
                                                        new ResourceMaterial(2, Material.SURVEY_PARTS, Grade.THREE, 140L)
                                                )
                                        ),
                                        new Component(2, ComponentName.CARGO_BAY,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 18_000L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 1_200_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 16_750L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.RARE, Grade.THREE, 2L),
                                                        new ResourceMaterial(2, Material.ORE, Rarity.RARE, Grade.THREE, 12L),
                                                        new ResourceMaterial(3, Material.SURVEY_PARTS, Grade.THREE, 425L)
                                                )
                                        ),
                                        new Component(3, ComponentName.SHIELD,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 9362L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 2001L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 790_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 3L),
                                                        new ResourceMaterial(2, Material.ORE, Rarity.UNCOMMON, Grade.THREE, 12L),
                                                        new ResourceMaterial(3, Material.SURVEY_PARTS, Grade.THREE, 210L)
                                                )
                                        ),
                                        new Component(4, ComponentName.IMPULSE_ENGINE,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 3121L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 1000L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 395_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 25_500L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 2L),
                                                        new ResourceMaterial(2, Material.SURVEY_PARTS, Grade.THREE, 35L)
                                                )
                                        ),
                                        new Component(5, ComponentName.PHOTON_TORPEDO,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 9362L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 1000L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 980_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 16_750L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.RARE, Grade.THREE, 5L),
                                                        new ResourceMaterial(2, Material.ORE, Rarity.RARE, Grade.THREE, 12L),
                                                        new ResourceMaterial(3, Material.SURVEY_PARTS, Grade.THREE, 275L)
                                                )
                                        ),
                                        new Component(6, ComponentName.MINING_LASER,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 9362L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 2501L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 790_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 84_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.RARE, Grade.THREE, 2L),
                                                        new ResourceMaterial(2, Material.ORE, Rarity.RARE, Grade.THREE, 15L),
                                                        new ResourceMaterial(3, Material.SURVEY_PARTS, Grade.THREE, 425L)
                                                )
                                        )
                                )
                        ),
                        new Tier(9, 1_280_000, 11_452,
                                addShipLevels(
                                        new Level(41, 154_000, 39_700),
                                        new Level(42, 161_000, 40_000),
                                        new Level(43, 176_000, 40_350),
                                        new Level(44, 183_000, 40_700),
                                        new Level(45, 200_000, 41_000)
                                ),
                                addComponents(
                                        new Component(1, ComponentName.WARP_ENGINES,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 4961L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 103_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.ORE, Rarity.UNCOMMON, Grade.THREE, 15L),
                                                        new ResourceMaterial(2, Material.SURVEY_PARTS, Grade.THREE, 350L)
                                                )
                                        ),
                                        new Component(2, ComponentName.CARGO_BAY,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 45_000L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 2_950_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 51_500L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.RARE, Grade.THREE, 4L),
                                                        new ResourceMaterial(2, Material.ORE, Rarity.RARE, Grade.THREE, 30L),
                                                        new ResourceMaterial(3, Material.SURVEY_PARTS, Grade.THREE, 1075L)
                                                )
                                        ),
                                        new Component(3, ComponentName.SHIELD,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 24_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 6614L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 1_950_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.RARE, Grade.THREE, 8L),
                                                        new ResourceMaterial(2, Material.ORE, Rarity.RARE, Grade.THREE, 30L),
                                                        new ResourceMaterial(3, Material.SURVEY_PARTS, Grade.THREE, 550L)
                                                )
                                        ),
                                        new Component(4, ComponentName.IMPULSE_ENGINE,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 8260L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 3307L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 980_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 77_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 4L),
                                                        new ResourceMaterial(2, Material.SURVEY_PARTS, Grade.THREE, 90L)
                                                )
                                        ),
                                        new Component(5, ComponentName.PHOTON_TORPEDO,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 24_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 3307L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 2_450_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 51_500L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.RARE, Grade.THREE, 6L),
                                                        new ResourceMaterial(2, Material.ORE, Rarity.RARE, Grade.THREE, 15L),
                                                        new ResourceMaterial(3, Material.SURVEY_PARTS, Grade.THREE, 725L)
                                                )
                                        ),
                                        new Component(6, ComponentName.MINING_LASER,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 24_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 8268L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 1_950_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 255_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.RARE, Grade.THREE, 6L),
                                                        new ResourceMaterial(2, Material.ORE, Rarity.RARE, Grade.THREE, 38L),
                                                        new ResourceMaterial(3, Material.SURVEY_PARTS, Grade.THREE, 1075L)
                                                )
                                        )
                                )
                        )
                )
        );
    }

    private Ship getEcsHorizon() {
        return new Ship(
                "ECS Horizon",
                Rarity.COMMON,
                Grade.THREE,
                ShipClass.SURVEY,
                img(R.drawable.ecs_horizon),
                0,
                "Dilithium Mining Laser",
                26,
                30,
                addTiers(
                        new Tier(1, 882_000, 5202,
                                addShipLevels(
                                        new Level(1, 0, 15,
                                                new Scrap(455_220, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 120_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 5600L)
                                                ))
                                        ),
                                        new Level(2, 800, 16,
                                                new Scrap(455_220, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 120_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 5600L),
                                                        new ResourceMaterial(3, Material.SHIP_XP, 32L)
                                                ))
                                        ),
                                        new Level(3, 1000, 17,
                                                new Scrap(455_220, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 120_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 5600L),
                                                        new ResourceMaterial(3, Material.SHIP_XP, 72L)
                                                ))
                                        ),
                                        new Level(4, 1400, 18,
                                                new Scrap(455_220, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 120_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 5600L),
                                                        new ResourceMaterial(3, Material.SHIP_XP, 128L)
                                                ))
                                        ),
                                        new Level(5, 1700, 19,
                                                new Scrap(455_220, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 120_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 5600L),
                                                        new ResourceMaterial(3, Material.SHIP_XP, 196L)
                                                ))
                                        )
                                ),
                                addComponents(
                                        new Component(1, ComponentName.BUILD_SHIP_TOTAL,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 13_384L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 1027L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 800_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 28_000L)
                                                ),
                                                setEmpty()
                                        )
                                )
                        ),
                        new Tier(2, 97_200, 6198,
                                addShipLevels(
                                        new Level(6, 2400, 20,
                                                new Scrap(512_100, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 350_144L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 14_853L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 18L),
                                                        new ResourceMaterial(4, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 33L),
                                                        new ResourceMaterial(5, Material.SHIP_XP, 274L),
                                                        new ResourceMaterial(6, Material.SURVEY_PARTS, Grade.THREE, 11L)
                                                ))
                                        ),
                                        new Level(7, 2900, 21,
                                                new Scrap(512_100, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 350_144L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 14_853L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 22L),
                                                        new ResourceMaterial(4, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 41L),
                                                        new ResourceMaterial(5, Material.SHIP_XP, 383L),
                                                        new ResourceMaterial(6, Material.SURVEY_PARTS, Grade.THREE, 14L)
                                                ))
                                        ),
                                        new Level(8, 3900, 22,
                                                new Scrap(512_100, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 350_144L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 14_853L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 29L),
                                                        new ResourceMaterial(4, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 53L),
                                                        new ResourceMaterial(5, Material.SHIP_XP, 529L),
                                                        new ResourceMaterial(6, Material.SURVEY_PARTS, Grade.THREE, 18L)
                                                ))
                                        ),
                                        new Level(9, 4600, 23,
                                                new Scrap(512_100, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 350_144L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 14_853L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 35L),
                                                        new ResourceMaterial(4, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 65L),
                                                        new ResourceMaterial(5, Material.SHIP_XP, 701L),
                                                        new ResourceMaterial(6, Material.SURVEY_PARTS, Grade.THREE, 22L)
                                                ))
                                        ),
                                        new Level(10, 6000, 25,
                                                new Scrap(512_100, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 350_144L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 14_853L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 44L),
                                                        new ResourceMaterial(4, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 81L),
                                                        new ResourceMaterial(5, Material.SHIP_XP, 926L),
                                                        new ResourceMaterial(6, Material.SURVEY_PARTS, Grade.THREE, 27L)
                                                ))
                                        )
                                ),
                                addComponents(
                                        new Component(1, ComponentName.WARP_ENGINES,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 409L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 8000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 44L),
                                                        new ResourceMaterial(2, Material.SURVEY_PARTS, Grade.THREE, 16L)
                                                )
                                        ),
                                        new Component(2, ComponentName.CARGO_BAY,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 1866L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 535_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 4000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.COMMON, Grade.THREE, 13L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 90L),
                                                        new ResourceMaterial(3, Material.SURVEY_PARTS, Grade.THREE, 48L)
                                                )
                                        ),
                                        new Component(3, ComponentName.SHIELD,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 933L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 546L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 3555_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.COMMON, Grade.THREE, 13L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 44L),
                                                        new ResourceMaterial(3, Material.SURVEY_PARTS, Grade.THREE, 24L)
                                                )
                                        ),
                                        new Component(4, ComponentName.IMPULSE_ENGINE,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 311L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 273L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 178_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 6000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.COMMON, Grade.THREE, 7L),
                                                        new ResourceMaterial(2, Material.SURVEY_PARTS, Grade.THREE, 4L)
                                                )
                                        ),
                                        new Component(5, ComponentName.PHASER_CANNON,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 622L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 546L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 178_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 10_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.COMMON, Grade.THREE, 20L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 44L),
                                                        new ResourceMaterial(3, Material.SURVEY_PARTS, Grade.THREE, 32L)
                                                )
                                        ),
                                        new Component(6, ComponentName.MINING_LASER,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 933L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 682L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 355_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 19_750L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.COMMON, Grade.THREE, 20L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 110L),
                                                        new ResourceMaterial(3, Material.SURVEY_PARTS, Grade.THREE, 48L)
                                                )
                                        )
                                )
                        ),
                        new Tier(3, 194_400, 7134,
                                addShipLevels(
                                        new Level(11, 7000, 27.5f,
                                                new Scrap(569_040, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 777_390L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 35_506L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 42L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 2L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 78L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 4L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 1110L),
                                                        new ResourceMaterial(8, Material.SURVEY_PARTS, Grade.THREE, 30L)
                                                ))
                                        ),
                                        new Level(12, 8500, 30,
                                                new Scrap(569_040, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 777_390L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 35_506L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 50L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 3L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 92L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 5L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 1407L),
                                                        new ResourceMaterial(8, Material.SURVEY_PARTS, Grade.THREE, 35L)
                                                ))
                                        ),
                                        new Level(13, 9500, 32.5f,
                                                new Scrap(569_040, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 777_390L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 35_506L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 64L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 3L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 118L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 6L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 1740L),
                                                        new ResourceMaterial(8, Material.SURVEY_PARTS, Grade.THREE, 45L)
                                                ))
                                        ),
                                        new Level(14, 11_000, 35,
                                                new Scrap(569_040, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 777_390L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 35_506L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 82L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 4L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 151L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 7L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 2125L),
                                                        new ResourceMaterial(8, Material.SURVEY_PARTS, Grade.THREE, 57L)
                                                ))
                                        ),
                                        new Level(15, 13_500, 37.5f,
                                                new Scrap(569_040, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 777_390L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 35_506L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 107L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 5L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 198L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 9L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 2597L),
                                                        new ResourceMaterial(8, Material.SURVEY_PARTS, Grade.THREE, 73L)
                                                ))
                                        )
                                ),
                                addComponents(
                                        new Component(1, ComponentName.WARP_ENGINES,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 645L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 18_500L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 130L),
                                                        new ResourceMaterial(2, Material.SURVEY_PARTS, Grade.THREE, 29L)
                                                )
                                        ),
                                        new Component(2, ComponentName.CARGO_BAY,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 3866L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 1_050_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 9250L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.COMMON, Grade.THREE, 40L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 275L),
                                                        new ResourceMaterial(3, Material.SURVEY_PARTS, Grade.THREE, 90L)
                                                )
                                        ),
                                        new Component(3, ComponentName.SHIELD,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 1933L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 861L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 710_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.COMMON, Grade.THREE, 40L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 130L),
                                                        new ResourceMaterial(3, Material.SURVEY_PARTS, Grade.THREE, 43L)
                                                )
                                        ),
                                        new Component(4, ComponentName.IMPULSE_ENGINE,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 644L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 430L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 355_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 14_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.COMMON, Grade.THREE, 20L),
                                                        new ResourceMaterial(2, Material.SURVEY_PARTS, Grade.THREE, 7L)
                                                )
                                        ),
                                        new Component(5, ComponentName.PHASER_CANNON,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 1289L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 861L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 355_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 23_500L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.COMMON, Grade.THREE, 59L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 130L),
                                                        new ResourceMaterial(3, Material.SURVEY_PARTS, Grade.THREE, 58L)
                                                )
                                        ),
                                        new Component(6, ComponentName.MINING_LASER,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 1933L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 1076L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 710_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 46_500L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 3L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 15L),
                                                        new ResourceMaterial(3, Material.SURVEY_PARTS, Grade.THREE, 90L)
                                                )
                                        )
                                )
                        ),
                        new Tier(4, 324_000, 8105,
                                addShipLevels(
                                        new Level(16, 15_000, 40,
                                                new Scrap(625_920, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 1_447_669L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 77_512L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 100L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 9L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 186L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 16L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 2899L),
                                                        new ResourceMaterial(8, Material.SURVEY_PARTS, Grade.THREE, 77L)
                                                ))
                                        ),
                                        new Level(17, 17_500, 42.5f,
                                                new Scrap(625_920, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 1_447_669L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 77_512L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 111L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 10L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 206L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 18L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 3468L),
                                                        new ResourceMaterial(8, Material.SURVEY_PARTS, Grade.THREE, 84L)
                                                ))
                                        ),
                                        new Level(18, 19_500, 45,
                                                new Scrap(625_920, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 1_447_669L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 77_512L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 133L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 12L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 247L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 21L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 4102L),
                                                        new ResourceMaterial(8, Material.SURVEY_PARTS, Grade.THREE, 99L)
                                                ))
                                        ),
                                        new Level(19, 23_000, 47.5f,
                                                new Scrap(625_920, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 1_447_669L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 77_512L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 161L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 14L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 299L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 25L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 4849L),
                                                        new ResourceMaterial(8, Material.SURVEY_PARTS, Grade.THREE, 118L)
                                                ))
                                        ),
                                        new Level(20, 25_000, 50,
                                                new Scrap(625_920, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 1_447_669L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 77_512L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 200L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 17L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 371L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 31L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 5662L),
                                                        new ResourceMaterial(8, Material.SURVEY_PARTS, Grade.THREE, 145L)
                                                ))
                                        )
                                ),
                                addComponents(
                                        new Component(1, ComponentName.WARP_ENGINES,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 1066L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 39_500L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 350L),
                                                        new ResourceMaterial(2, Material.SURVEY_PARTS, Grade.THREE, 48L)
                                                )
                                        ),
                                        new Component(2, ComponentName.CARGO_BAY,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 7763L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 1_750_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 19_750L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 6L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 41L),
                                                        new ResourceMaterial(3, Material.SURVEY_PARTS, Grade.THREE, 140L)
                                                )
                                        ),
                                        new Component(3, ComponentName.SHIELD,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 3881L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 1421L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 1_200_000)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.COMMON, Grade.THREE, 110L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 350L),
                                                        new ResourceMaterial(3, Material.SURVEY_PARTS, Grade.THREE, 70L)
                                                )
                                        ),
                                        new Component(4, ComponentName.IMPULSE_ENGINE,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 1294),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 711)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 590_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 29_500L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.COMMON, Grade.THREE, 53L),
                                                        new ResourceMaterial(2, Material.SURVEY_PARTS, Grade.THREE, 12L)
                                                )
                                        ),
                                        new Component(5, ComponentName.PHASER_CANNON,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 2588L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 1421L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 590_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 49_500L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.COMMON, Grade.THREE, 160L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 350L),
                                                        new ResourceMaterial(3, Material.SURVEY_PARTS, Grade.THREE, 100L)
                                                )
                                        ),
                                        new Component(6, ComponentName.MINING_LASER,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 3881L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 1777L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 1_200_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 99_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 9L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 52L),
                                                        new ResourceMaterial(3, Material.SURVEY_PARTS, Grade.THREE, 140L)
                                                )
                                        )
                                )
                        ),
                        new Tier(5, 486_000, 9516,
                                addShipLevels(
                                        new Level(21, 29_000, 54,
                                                new Scrap(682_860, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 2_621_375L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 156_669L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 164L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 28L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 304L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 51L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 6096L),
                                                        new ResourceMaterial(8, Material.SURVEY_PARTS, Grade.THREE, 148L)
                                                ))
                                        ),
                                        new Level(22, 31_500, 58,
                                                new Scrap(682_860, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 2_621_375L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 156_669L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 177L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 30L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 328L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 55L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 7041L),
                                                        new ResourceMaterial(8, Material.SURVEY_PARTS, Grade.THREE, 160L)
                                                ))
                                        ),
                                        new Level(23, 36_000, 62,
                                                new Scrap(682_860, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 2_621_375L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 156_669L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 203L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 34L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 377L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 63L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 184L),
                                                        new ResourceMaterial(8, Material.SURVEY_PARTS, Grade.THREE, 184L)
                                                ))
                                        ),
                                        new Level(24, 39_000, 66,
                                                new Scrap(682_860, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 2_621_375L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 156_669L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 236L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 40L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 437L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 73L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 9291L),
                                                        new ResourceMaterial(8, Material.SURVEY_PARTS, Grade.THREE, 214L)
                                                ))
                                        ),
                                        new Level(25, 42_000, 70,
                                                new Scrap(682_860, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 2_621_375L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 156_669L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 282L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 47L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 522L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 87L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 10_551L),
                                                        new ResourceMaterial(8, Material.SURVEY_PARTS, Grade.THREE, 255L)
                                                ))
                                        )
                                ),
                                addComponents(
                                        new Component(1, ComponentName.WARP_ENGINES,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 1803L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 70_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 650L),
                                                        new ResourceMaterial(2, Material.SURVEY_PARTS, Grade.THREE, 80L)
                                                )
                                        ),
                                        new Component(2, ComponentName.CARGO_BAY,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 14_000L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 3_300_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 39_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 12L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 80L),
                                                        new ResourceMaterial(3, Material.SURVEY_PARTS, Grade.THREE, 250L)
                                                )
                                        ),
                                        new Component(3, ComponentName.SHIELD,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 7136L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 2404L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 2_200_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.COMMON, Grade.THREE, 200L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 650L),
                                                        new ResourceMaterial(3, Material.SURVEY_PARTS, Grade.THREE, 120L)
                                                )
                                        ),
                                        new Component(4, ComponentName.IMPULSE_ENGINE,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 2379L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 1202L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 1_100_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 58_500L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.COMMON, Grade.THREE, 100L),
                                                        new ResourceMaterial(2, Material.SURVEY_PARTS, Grade.THREE, 20L)
                                                )
                                        ),
                                        new Component(5, ComponentName.PHASER_CANNON,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 4757L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 2404L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 1_100_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 97_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 19L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 41L),
                                                        new ResourceMaterial(3, Material.SURVEY_PARTS, Grade.THREE, 160L)
                                                )
                                        ),
                                        new Component(6, ComponentName.MINING_LASER,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 7136L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 3005L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 2_200_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 194_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 19L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 100L),
                                                        new ResourceMaterial(3, Material.SURVEY_PARTS, Grade.THREE, 250L)
                                                )
                                        )
                                )
                        ),
                        new Tier(6, 648_000, 10_560,
                                addShipLevels(
                                        new Level(26, 47_000, 75,
                                                new Scrap(739_740, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 4_598_181L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 309_056L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 189L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 54L),
                                                        new ResourceMaterial(5, Material.GAS, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 351L),
                                                        new ResourceMaterial(7, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 99L),
                                                        new ResourceMaterial(8, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(9, Material.SHIP_XP, 10_964L),
                                                        new ResourceMaterial(10, Material.SURVEY_PARTS, Grade.THREE, 259L)
                                                ))
                                        ),
                                        new Level(27, 51_000, 80,
                                                new Scrap(739_740, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 4_598_181L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 309_056L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 203L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 57L),
                                                        new ResourceMaterial(5, Material.GAS, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 376L),
                                                        new ResourceMaterial(7, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 106L),
                                                        new ResourceMaterial(8, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(9, Material.SHIP_XP, 12_367L),
                                                        new ResourceMaterial(10, Material.SURVEY_PARTS, Grade.THREE, 278L)
                                                ))
                                        ),
                                        new Level(28, 57_000, 85,
                                                new Scrap(739_740, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 4_598_181L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 309_056L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 229L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 65L),
                                                        new ResourceMaterial(5, Material.GAS, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 426L),
                                                        new ResourceMaterial(7, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 120L),
                                                        new ResourceMaterial(8, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(9, Material.SHIP_XP, 13_934L),
                                                        new ResourceMaterial(10, Material.SURVEY_PARTS, Grade.THREE, 316L)
                                                ))
                                        ),
                                        new Level(29, 61_000, 90,
                                                new Scrap(739_740, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 4_598_181L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 309_056L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 263L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 74L),
                                                        new ResourceMaterial(5, Material.GAS, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 487L),
                                                        new ResourceMaterial(7, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 137L),
                                                        new ResourceMaterial(8, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 2L),
                                                        new ResourceMaterial(9, Material.SHIP_XP, 15_612L),
                                                        new ResourceMaterial(10, Material.SURVEY_PARTS, Grade.THREE, 364L)
                                                ))
                                        ),
                                        new Level(30, 69_000, 95,
                                                new Scrap(739_740, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 4_598_181L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 309_056L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 309L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 87L),
                                                        new ResourceMaterial(5, Material.GAS, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 574L),
                                                        new ResourceMaterial(7, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 162L),
                                                        new ResourceMaterial(8, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 2L),
                                                        new ResourceMaterial(9, Material.SHIP_XP, 17_509L),
                                                        new ResourceMaterial(10, Material.SURVEY_PARTS, Grade.THREE, 432L)
                                                ))
                                        )
                                ),
                                addComponents(
                                        new Component(1, ComponentName.WARP_ENGINES,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 3327L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 156_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 1325L),
                                                        new ResourceMaterial(2, Material.SURVEY_PARTS, Grade.THREE, 140L)
                                                )
                                        ),
                                        new Component(2, ComponentName.CARGO_BAY,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 26_000L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 5_900_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 78_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 30L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 30L),
                                                        new ResourceMaterial(3, Material.SURVEY_PARTS, Grade.THREE, 425L)
                                                )
                                        ),
                                        new Component(3, ComponentName.SHIELD,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 13_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 4436L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 3_950_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 30L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 100L),
                                                        new ResourceMaterial(3, Material.SURVEY_PARTS, Grade.THREE, 220L)
                                                )
                                        ),
                                        new Component(4, ComponentName.IMPULSE_ENGINE,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 4473L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 2218L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 1_950_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 117_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.COMMON, Grade.THREE, 200L),
                                                        new ResourceMaterial(2, Material.SURVEY_PARTS, Grade.THREE, 36L)
                                                )
                                        ),
                                        new Component(5, ComponentName.PHASER_CANNON,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 8945L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 4436L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 1_950_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 194_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 45L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 100L),
                                                        new ResourceMaterial(3, Material.SURVEY_PARTS, Grade.THREE, 300L)
                                                )
                                        ),
                                        new Component(6, ComponentName.MINING_LASER,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 13_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 5545L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 3_950_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 390_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 3L),
                                                        new ResourceMaterial(3, Material.SURVEY_PARTS, Grade.THREE, 425L)
                                                )
                                        )
                                )
                        ),
                        new Tier(7, 810_000, 12_282,
                                addShipLevels(
                                        new Level(31, 72_000, 100,
                                                new Scrap(796_620, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 9_278_740L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 691_067L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 195L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 88L),
                                                        new ResourceMaterial(5, Material.GAS, Rarity.RARE, Grade.THREE, 2L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 362L),
                                                        new ResourceMaterial(7, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 163L),
                                                        new ResourceMaterial(8, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 3L),
                                                        new ResourceMaterial(9, Material.SHIP_XP, 17_718L),
                                                        new ResourceMaterial(10, Material.SURVEY_PARTS, Grade.THREE, 442L)
                                                ))
                                        ),
                                        new Level(32, 81_000, 105,
                                                new Scrap(796_620, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 9_278_740L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 691_067L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 210L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 95L),
                                                        new ResourceMaterial(5, Material.GAS, Rarity.RARE, Grade.THREE, 2L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 390L),
                                                        new ResourceMaterial(7, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 176L),
                                                        new ResourceMaterial(8, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 3L),
                                                        new ResourceMaterial(9, Material.SHIP_XP, 19_743L),
                                                        new ResourceMaterial(10, Material.SURVEY_PARTS, Grade.THREE, 480L)
                                                ))
                                        ),
                                        new Level(33, 86_000, 110,
                                                new Scrap(796_620, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 9_278_740L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 691_067L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 239L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 108L),
                                                        new ResourceMaterial(5, Material.GAS, Rarity.RARE, Grade.THREE, 2L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 444L),
                                                        new ResourceMaterial(7, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 200L),
                                                        new ResourceMaterial(8, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 4L),
                                                        new ResourceMaterial(9, Material.SHIP_XP, 21_893L),
                                                        new ResourceMaterial(10, Material.SURVEY_PARTS, Grade.THREE, 557L)
                                                ))
                                        ),
                                        new Level(34, 95_000, 115,
                                                new Scrap(796_620, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 9_278_740L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 691_067L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 276L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 125L),
                                                        new ResourceMaterial(5, Material.GAS, Rarity.RARE, Grade.THREE, 3L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 513L),
                                                        new ResourceMaterial(7, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 231L),
                                                        new ResourceMaterial(8, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 4L),
                                                        new ResourceMaterial(9, Material.SHIP_XP, 24_268L),
                                                        new ResourceMaterial(10, Material.SURVEY_PARTS, Grade.THREE, 653L)
                                                ))
                                        ),
                                        new Level(35, 100_000, 120,
                                                new Scrap(796_620, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 9_278_740L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 691_067L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 328L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 148L),
                                                        new ResourceMaterial(5, Material.GAS, Rarity.RARE, Grade.THREE, 3L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 608L),
                                                        new ResourceMaterial(7, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 274L),
                                                        new ResourceMaterial(8, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 5L),
                                                        new ResourceMaterial(9, Material.SHIP_XP, 26_768L),
                                                        new ResourceMaterial(10, Material.SURVEY_PARTS, Grade.THREE, 787L)
                                                ))
                                        )
                                ),
                                addComponents(
                                        new Component(1, ComponentName.WARP_ENGINES,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 5869L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 405_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 230L),
                                                        new ResourceMaterial(2, Material.SURVEY_PARTS, Grade.THREE, 325L)
                                                )
                                        ),
                                        new Component(2, ComponentName.CARGO_BAY,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 46_000L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 14_600_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 205_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.RARE, Grade.THREE, 1L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 8L),
                                                        new ResourceMaterial(3, Material.SURVEY_PARTS, Grade.THREE, 950L)
                                                )
                                        ),
                                        new Component(3, ComponentName.SHIELD,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 23_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 7825L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 9_700_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 70L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 230L),
                                                        new ResourceMaterial(3, Material.SURVEY_PARTS, Grade.THREE, 475L)
                                                )
                                        ),
                                        new Component(4, ComponentName.IMPULSE_ENGINE,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 7696L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 3913L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 4_850_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 305_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.COMMON, Grade.THREE, 450L),
                                                        new ResourceMaterial(2, Material.SURVEY_PARTS, Grade.THREE, 80L)
                                                )
                                        ),
                                        new Component(5, ComponentName.PHASER_CANNON,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 15_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 7825L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 4_850_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 505_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 100L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 230L),
                                                        new ResourceMaterial(3, Material.SURVEY_PARTS, Grade.THREE, 650L)
                                                )
                                        ),
                                        new Component(6, ComponentName.MINING_LASER,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 23_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 9782L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 9_700_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 1_000_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.RARE, Grade.THREE, 2L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 9L),
                                                        new ResourceMaterial(3, Material.SURVEY_PARTS, Grade.THREE, 950L)
                                                )
                                        )
                                )
                        ),
                        new Tier(8, 1_053_000, 13_968,
                                addShipLevels(
                                        new Level(36, 105_000, 125,
                                                new Scrap(853_560, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 16_898_045L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 1_344_389L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 133L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 149L),
                                                        new ResourceMaterial(5, Material.GAS, Rarity.RARE, Grade.THREE, 4L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 246L),
                                                        new ResourceMaterial(7, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 276L),
                                                        new ResourceMaterial(8, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 7L),
                                                        new ResourceMaterial(9, Material.SHIP_XP, 26_453L),
                                                        new ResourceMaterial(10, Material.SURVEY_PARTS, Grade.THREE, 795L)
                                                ))
                                        ),
                                        new Level(37, 116_000, 130,
                                                new Scrap(853_560, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 16_898_045L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 1_344_389L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 143L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 161L),
                                                        new ResourceMaterial(5, Material.GAS, Rarity.RARE, Grade.THREE, 5L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 265L),
                                                        new ResourceMaterial(7, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 298L),
                                                        new ResourceMaterial(8, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 8L),
                                                        new ResourceMaterial(9, Material.SHIP_XP, 29_063L),
                                                        new ResourceMaterial(10, Material.SURVEY_PARTS, Grade.THREE, 860L)
                                                ))
                                        ),
                                        new Level(38, 122_000, 135,
                                                new Scrap(853_560, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 16_898_045L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 1_344_389L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 164L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 184L),
                                                        new ResourceMaterial(5, Material.GAS, Rarity.RARE, Grade.THREE, 5L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 304L),
                                                        new ResourceMaterial(7, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 342L),
                                                        new ResourceMaterial(8, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 9L),
                                                        new ResourceMaterial(9, Material.SHIP_XP, 31_808L),
                                                        new ResourceMaterial(10, Material.SURVEY_PARTS, Grade.THREE, 988L)
                                                ))
                                        ),
                                        new Level(39, 134_000, 140,
                                                new Scrap(853_560, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 16_898_045L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 1_344_389L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 190L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 214L),
                                                        new ResourceMaterial(5, Material.GAS, Rarity.RARE, Grade.THREE, 6L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 353L),
                                                        new ResourceMaterial(7, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 397L),
                                                        new ResourceMaterial(8, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 10L),
                                                        new ResourceMaterial(9, Material.SHIP_XP, 34_823L),
                                                        new ResourceMaterial(10, Material.SURVEY_PARTS, Grade.THREE, 1149L)
                                                ))
                                        ),
                                        new Level(40, 140_000, 145,
                                                new Scrap(853_5600, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 16_898_045L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 1_344_389L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.COMMON, Grade.THREE, 227L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 255L),
                                                        new ResourceMaterial(5, Material.GAS, Rarity.RARE, Grade.THREE, 7L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.COMMON, Grade.THREE, 421L),
                                                        new ResourceMaterial(7, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 474L),
                                                        new ResourceMaterial(8, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 12L),
                                                        new ResourceMaterial(9, Material.SHIP_XP, 37_973L),
                                                        new ResourceMaterial(10, Material.SURVEY_PARTS, Grade.THREE, 1374L)
                                                ))
                                        )
                                ),
                                addComponents(
                                        new Component(1, ComponentName.WARP_ENGINES,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 10_000L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 730_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 500L),
                                                        new ResourceMaterial(2, Material.SURVEY_PARTS, Grade.THREE, 550L)
                                                )
                                        ),
                                        new Component(2, ComponentName.CARGO_BAY,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 80_000L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 25_500_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 365_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.RARE, Grade.THREE, 3L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 18L),
                                                        new ResourceMaterial(3, Material.SURVEY_PARTS, Grade.THREE, 1700L)
                                                )
                                        ),
                                        new Component(3, ComponentName.SHIELD,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 40_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 14_000L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 17_000_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 150L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 500L),
                                                        new ResourceMaterial(3, Material.SURVEY_PARTS, Grade.THREE, 850L)
                                                )
                                        ),
                                        new Component(4, ComponentName.IMPULSE_ENGINE,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 13_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 7217L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 8_500_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 545_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 70L),
                                                        new ResourceMaterial(2, Material.SURVEY_PARTS, Grade.THREE, 140L)
                                                )
                                        ),
                                        new Component(5, ComponentName.PHASER_CANNON,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 26_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 14_000L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 8_500_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 910_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.RARE, Grade.THREE, 4L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 9L),
                                                        new ResourceMaterial(3, Material.SURVEY_PARTS, Grade.THREE, 1125L)
                                                )
                                        ),
                                        new Component(6, ComponentName.MINING_LASER,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 40_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 18_000L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 17_000_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 1_800_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.RARE, Grade.THREE, 4L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 22L),
                                                        new ResourceMaterial(3, Material.SURVEY_PARTS, Grade.THREE, 1700L)
                                                )
                                        )
                                )
                        ),
                        new Tier(9, 1_296_000, 15_972,
                                addShipLevels(
                                        new Level(41, 154_000, 150,
                                                new Scrap(910_440, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 16_898_045L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 1_344_389L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 224L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.RARE, Grade.THREE, 9L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 416L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 16L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 36_834L),
                                                        new ResourceMaterial(8, Material.SURVEY_PARTS, Grade.THREE, 1354L)
                                                ))
                                        ),
                                        new Level(42, 161_000, 160,
                                                new Scrap(910_440, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 16_898_045L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 1_344_389L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 239L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.RARE, Grade.THREE, 9L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 444L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 17L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 40_054L),
                                                        new ResourceMaterial(8, Material.SURVEY_PARTS, Grade.THREE, 1439L)
                                                ))
                                        ),
                                        new Level(43, 176_000, 170,
                                                new Scrap(910_440, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 16_898_045L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 1_344_389L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 269L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.RARE, Grade.THREE, 11L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 499L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 19L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 43_574L),
                                                        new ResourceMaterial(8, Material.SURVEY_PARTS, Grade.THREE, 1611L)
                                                ))
                                        ),
                                        new Level(44, 183_000, 180,
                                                new Scrap(910_440, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 16_898_045L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 1_344_389L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 306L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.RARE, Grade.THREE, 12L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 568L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 22L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 47_234L),
                                                        new ResourceMaterial(8, Material.SURVEY_PARTS, Grade.THREE, 1825L)
                                                ))
                                        ),
                                        new Level(45, 200_000, 200,
                                                new Scrap(910_440, addRewards(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 16_898_045L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 1_344_389L),
                                                        new ResourceMaterial(3, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 358L),
                                                        new ResourceMaterial(4, Material.GAS, Rarity.RARE, Grade.THREE, 14L),
                                                        new ResourceMaterial(5, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 664L),
                                                        new ResourceMaterial(6, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 25L),
                                                        new ResourceMaterial(7, Material.SHIP_XP, 51_234L),
                                                        new ResourceMaterial(8, Material.SURVEY_PARTS, Grade.THREE, 2125L)
                                                ))
                                        )
                                ),
                                addComponents(
                                        new Component(1, ComponentName.WARP_ENGINES,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 20_000L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.DILITHIUM, 1_200_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.CRYSTAL, Rarity.UNCOMMON, Grade.THREE, 825L),
                                                        new ResourceMaterial(2, Material.SURVEY_PARTS, Grade.THREE, 800L)
                                                )
                                        ),
                                        new Component(2, ComponentName.CARGO_BAY,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 137_000L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 40_900_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 610_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.RARE, Grade.THREE, 5L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 30L),
                                                        new ResourceMaterial(3, Material.SURVEY_PARTS, Grade.THREE, 2400L)
                                                )
                                        ),
                                        new Component(3, ComponentName.SHIELD,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 68_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 27_000L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 27_300_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.RARE, Grade.THREE, 5L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 15L),
                                                        new ResourceMaterial(3, Material.SURVEY_PARTS, Grade.THREE, 1200L)
                                                )
                                        ),
                                        new Component(4, ComponentName.IMPULSE_ENGINE,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 22_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 13_000L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 13_600_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 910_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.UNCOMMON, Grade.THREE, 120L),
                                                        new ResourceMaterial(2, Material.SURVEY_PARTS, Grade.THREE, 200L)
                                                )
                                        ),
                                        new Component(5, ComponentName.PHASER_CANNON,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 45_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 27_000L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 13_600_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 1_500_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.RARE, Grade.THREE, 7L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 15L),
                                                        new ResourceMaterial(3, Material.SURVEY_PARTS, Grade.THREE, 1600L)
                                                )
                                        ),
                                        new Component(6, ComponentName.MINING_LASER,
                                                addRepairCostResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 68_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 34_000L)
                                                ),
                                                addResources(
                                                        new ResourceMaterial(1, Material.TRITANIUM, 27_300_000L),
                                                        new ResourceMaterial(2, Material.DILITHIUM, 3_050_000L)
                                                ),
                                                addMaterials(
                                                        new ResourceMaterial(1, Material.GAS, Rarity.RARE, Grade.THREE, 7L),
                                                        new ResourceMaterial(2, Material.CRYSTAL, Rarity.RARE, Grade.THREE, 38L),
                                                        new ResourceMaterial(3, Material.SURVEY_PARTS, Grade.THREE, 2400L)
                                                )
                                        )
                                )
                        )
                )
        );
    }

}























