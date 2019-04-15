package com.alkerth.game.Factories;

import com.alkerth.game.Ships.Ship;

import java.util.List;

public abstract class ShipFactory {

    abstract Ship generateShip();
    abstract List<Ship> generateShips(int amount);
}
