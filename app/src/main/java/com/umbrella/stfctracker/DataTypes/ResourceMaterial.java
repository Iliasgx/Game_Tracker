package com.umbrella.stfctracker.DataTypes;

public final class ResourceMaterial {

    private int id;
    private Material material;
    private Rarity rarity;
    private Stars stars;
    private long value;

    public ResourceMaterial(int id, Material material, Rarity rarity, Stars stars, long value) {
        this.id = id;
        this.material = material;
        this.rarity = rarity;
        this.stars = stars;
        this.value = value;
    }

    public ResourceMaterial(int id, Material material, long value) {
        this.id = id;
        this.material = material;
        this.rarity = null;
        this.stars = null;
        this.value = value;
    }

    public int getId() {
        return id;
    }
    public Material getMaterial() {
        return material;
    }
    public Rarity getRarity() {
        return rarity;
    }
    public Stars getStars() {
        return stars;
    }
    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public enum Material {
        PARSTEEL,
        TRITANIUM,
        DILITHIUM,
        GAS,
        ORE,
        CRYSTAL
    }

    public enum Rarity {
        COMMON,
        UNCOMMON,
        RARE
    }

    public enum Stars {
        ONE,
        TWO,
        THREE,
        FOUR
    }
}
