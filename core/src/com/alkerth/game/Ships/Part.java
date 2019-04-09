package com.alkerth.game.Ships;


import java.util.List;

public class Part {

    private List<Weapon> weapons;
    private List<Shield> shields;
    private List<Engine> engines;
    private List<Hull> hulles;

    public List<Weapon> getWeapons() {
        return weapons;
    }

    public void setWeapons(List<Weapon> weapons) {
        this.weapons = weapons;
    }

    public List<Shield> getShields() {
        return shields;
    }

    public void setShields(List<Shield> shields) {
        this.shields = shields;
    }

    public List<Engine> getEngines() {
        return engines;
    }

    public void setEngines(List<Engine> engines) {
        this.engines = engines;
    }

    public List<Hull> getHulles() {
        return hulles;
    }

    public void setHulles(List<Hull> hulles) {
        this.hulles = hulles;
    }
}
