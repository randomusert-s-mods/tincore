package io.github.randomusert.mods.tincore.energy;


/**
 * Reference implementation of {@link IEnergyStorage}. You can use/extend or implement your own.
 *
 * Derived from Neoforge's FE system.
 * */
public class EnergyStorage implements IEnergyStorage{

    private int energy;
    private final int capacity;

    public EnergyStorage(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public int insert(int amount, boolean simulate) {
        int accepted = Math.min(amount, capacity - energy);
        if (!simulate) energy += accepted;
        return accepted;
    }

    @Override
    public int extract(int amount, boolean simulate) {
        int taken = Math.min(amount, energy);
        if (!simulate) energy -= taken;
        return taken;
    }


    @Override
    public int getEnergy() {
        return energy;
    }

    @Override
    public int getCapacity() {
        return capacity;
    }
}
