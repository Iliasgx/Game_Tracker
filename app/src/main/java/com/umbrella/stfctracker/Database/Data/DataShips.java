package com.umbrella.stfctracker.Database.Data;

import android.content.res.Resources;

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
import com.umbrella.stfctracker.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

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
        Battleships();
        Explorers();
        Interceptors();
        Surveys();
    }

    private LinkedList<ResourceMaterial> setEmpty() {
        return new LinkedList<>();
    }

    private void Battleships() {
        ships.addAll(Arrays.asList(
                new Ship(
                        "Orion Corvette",
                        Rarity.COMMON,
                        Grade.ONE,
                        ShipClass.BATTLESHIP,
                        img(R.drawable.orion_corvette),
                        0,
                        "Maximum Hull Health",
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
                                                new Component(1, ComponentName.BUILD_SHIP_TOTAL, false, setEmpty(), setEmpty(), setEmpty())
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
                                                        addRepairCostsResources(
                                                                new ResourceMaterial(1, Material.TRITANIUM, 2L)
                                                        ),
                                                        setEmpty(),
                                                        addMaterials(
                                                                new ResourceMaterial(1, Material.BATTLESHIP_PARTS, Grade.ONE, 1L)
                                                        )
                                                ),
                                                new Component(2, ComponentName.TRITANIUM_ARMOR,
                                                        addRepairCostsResources(
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
                                                        addRepairCostsResources(
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
                                                        addRepairCostsResources(
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
                                                        addRepairCostsResources(
                                                                new ResourceMaterial(1, Material.TRITANIUM, 6L)
                                                        ),
                                                        setEmpty(),
                                                        addMaterials(
                                                                new ResourceMaterial(1, Material.BATTLESHIP_PARTS, Grade.ONE, 2L)
                                                        )
                                                ),
                                                new Component(2, ComponentName.TRITANIUM_ARMOR,
                                                        addRepairCostsResources(
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
                                                        addRepairCostsResources(
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
                                                        addRepairCostsResources(
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
                                                        addRepairCostsResources(
                                                                new ResourceMaterial(1, Material.TRITANIUM, 14L)
                                                        ),
                                                        setEmpty(),
                                                        addMaterials(
                                                                new ResourceMaterial(1, Material.BATTLESHIP_PARTS, Grade.ONE, 5L)
                                                        )
                                                ),
                                                new Component(2, ComponentName.TRITANIUM_ARMOR,
                                                        addRepairCostsResources(
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
                                                        addRepairCostsResources(
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
                                                        addRepairCostsResources(
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
                )
        ));

        /*ships.addAll(Arrays.asList(
                new Ship(
                        "Shipingggg",
                        Rarity.COMMON,
                        Grade.ONE,
                        ShipClass.INTERCEPTOR,
                        img(R.drawable.button_ripple),
                        3_000,
                        "Ship ability",
                        14,
                        19,
                        addTiers(
                                new Tier(1, 2, 3,
                                        addShipLevels(
                                                new Level(1, 2, 3,
                                                        new Scrap(1,
                                                                addRewards(
                                                                        new ResourceMaterial(1, Material.GAS, 300L),
                                                                        new ResourceMaterial(1, Material.GAS, 300L),
                                                                        new ResourceMaterial(1, Material.GAS, 300L),
                                                                        new ResourceMaterial(1, Material.GAS, 300L)
                                                                )
                                                        )
                                                ),
                                                new Level(1,2,3,
                                                        new Scrap(1,
                                                                addRewards(
                                                                        new ResourceMaterial(1, Material.GAS, 300L),
                                                                        new ResourceMaterial(1, Material.GAS, 300L),
                                                                        new ResourceMaterial(1, Material.GAS, 300L)
                                                                )
                                                        )
                                                )
                                        ),
                                        addComponents(
                                                new Component(
                                                        ComponentName.PHASER_CANNON,
                                                        "IMAGE",
                                                        true,
                                                        addRepairCostsResources(
                                                                new ResourceMaterial(1, Material.GAS, 300L),
                                                                new ResourceMaterial(1, Material.GAS, 300L)
                                                        ),
                                                        addResources(
                                                                new ResourceMaterial(1, Material.GAS, 300L),
                                                                new ResourceMaterial(1, Material.GAS, 300L)
                                                        ),
                                                        addMaterials(
                                                                new ResourceMaterial(1, Material.GAS, 300L),
                                                                new ResourceMaterial(1, Material.GAS, 300L),
                                                                new ResourceMaterial(1, Material.GAS, 300L),
                                                                new ResourceMaterial(1, Material.GAS, 300L)
                                                        )
                                                ),
                                                new Component(
                                                        ComponentName.PHASER_CANNON,
                                                        "IMAGE",
                                                        true,
                                                        addRepairCostsResources(
                                                                new ResourceMaterial(1, Material.GAS, 300L),
                                                                new ResourceMaterial(1, Material.GAS, 300L)
                                                        ),
                                                        addResources(
                                                                new ResourceMaterial(1, Material.GAS, 300L),
                                                                new ResourceMaterial(1, Material.GAS, 300L)
                                                        ),
                                                        addMaterials(
                                                                new ResourceMaterial(1, Material.GAS, 300L),
                                                                new ResourceMaterial(1, Material.GAS, 300L),
                                                                new ResourceMaterial(1, Material.GAS, 300L),
                                                                new ResourceMaterial(1, Material.GAS, 300L)
                                                        )
                                                )
                                        )
                                ),
                                new Tier(1, 2, 3,
                                        addShipLevels(
                                                new Level(1, 2, 3,
                                                        new Scrap(1,
                                                                addRewards(
                                                                        new ResourceMaterial(1, Material.GAS, 300L),
                                                                        new ResourceMaterial(1, Material.GAS, 300L),
                                                                        new ResourceMaterial(1, Material.GAS, 300L),
                                                                        new ResourceMaterial(1, Material.GAS, 300L)
                                                                )
                                                        )
                                                ),
                                                new Level(1,2,3,
                                                        new Scrap(1,
                                                                addRewards(
                                                                        new ResourceMaterial(1, Material.GAS, 300L),
                                                                        new ResourceMaterial(1, Material.GAS, 300L),
                                                                        new ResourceMaterial(1, Material.GAS, 300L)
                                                                )
                                                        )
                                                )
                                        ),
                                        addComponents(
                                                new Component(
                                                        ComponentName.PHASER_CANNON,
                                                        "IMAGE",
                                                        true,
                                                        addRepairCostsResources(
                                                                new ResourceMaterial(1, Material.GAS, 300L),
                                                                new ResourceMaterial(1, Material.GAS, 300L)
                                                        ),
                                                        addResources(
                                                                new ResourceMaterial(1, Material.GAS, 300L),
                                                                new ResourceMaterial(1, Material.GAS, 300L)
                                                        ),
                                                        addMaterials(
                                                                new ResourceMaterial(1, Material.GAS, 300L),
                                                                new ResourceMaterial(1, Material.GAS, 300L),
                                                                new ResourceMaterial(1, Material.GAS, 300L),
                                                                new ResourceMaterial(1, Material.GAS, 300L)
                                                        )
                                                ),
                                                new Component(
                                                        ComponentName.PHASER_CANNON,
                                                        "IMAGE",
                                                        true,
                                                        addRepairCostsResources(
                                                                new ResourceMaterial(1, Material.GAS, 300L),
                                                                new ResourceMaterial(1, Material.GAS, 300L)
                                                        ),
                                                        addResources(
                                                                new ResourceMaterial(1, Material.GAS, 300L),
                                                                new ResourceMaterial(1, Material.GAS, 300L)
                                                        ),
                                                        addMaterials(
                                                                new ResourceMaterial(1, Material.GAS, 300L),
                                                                new ResourceMaterial(1, Material.GAS, 300L),
                                                                new ResourceMaterial(1, Material.GAS, 300L),
                                                                new ResourceMaterial(1, Material.GAS, 300L)
                                                        ) // end AddMaterials
                                                ) // end Component
                                        ) // end ComponentList
                                ) // end Tier
                        ) // end TierList
                ) // end Ship
        )); // end ShipList*/
    }

    private void Explorers() {

    }

    private void Interceptors() {

    }

    private void Surveys() {

    }
}
