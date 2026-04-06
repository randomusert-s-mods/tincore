package io.github.randomusert.mods.tincore.energy;


/**
 * Reference implementation of {@link IEnergyStorage}. You can use/extend or implement your own.
 *
 * Derived from Neoforge's FE system.
 * */
public class EnergyStorage implements IEnergyStorage{

    protected int energy;
    protected final int capacity;
    protected int maxReceive;
    protected int maxExtract;

    public EnergyStorage(int capacity) {
        this(capacity, capacity, capacity, 0);
    }

    public EnergyStorage(int capacity, int maxTransfer) {
        this(capacity, maxTransfer, maxTransfer, 0);
    }

    public EnergyStorage(int capacity, int maxReceive, int maxExtract) {
        this(capacity, maxReceive, maxExtract, 0);
    }

    public EnergyStorage(int capacity, int maxReceive, int maxExtract, int energy) {
        this.capacity = capacity;
        this.maxReceive = maxReceive;
        this.maxExtract = maxExtract;
        this.energy = Math.max(0, Math.min(capacity, energy));
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
    public boolean canExtract() {
        return this.maxExtract > 0;
    }

    @Override
    public boolean canInsert() {
        return this.maxReceive > 0;
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
