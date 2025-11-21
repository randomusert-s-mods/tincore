package io.github.randomusert.mods.tincore.energy;

public class TinEnergyStorage implements ITinEnergy {
     /** The current stored energy value. */
    protected int energy;

    /** The maximum amount of energy that may be stored. */
    protected final int maxEnergy;

    /**
     * Creates a new {@code TinEnergyStorage} with the specified capacity.
     *
     * @param maxEnergy the maximum storable energy amount
     */
    public TinEnergyStorage(int maxEnergy) {
        this.maxEnergy = maxEnergy;
    }

    @Override
    public int getEnergy() {
        return energy;
    }

    @Override
    public int getMaxEnergy() {
        return maxEnergy;
    }

    @Override
    public int receiveEnergy(int amount, boolean simulate) {
        int accepted = Math.min(amount, maxEnergy - energy);
        if (!simulate) {
            energy += accepted;
        }
        return accepted;
    }

    @Override
    public int extractEnergy(int amount, boolean simulate) {
        int extracted = Math.min(amount, energy);
        if (!simulate) {
            energy -= extracted;
        }
        return extracted;
    }

    @Override
    public boolean canReceive() {
        return true;
    }

    @Override
    public boolean canExtract() {
        return true;
    }
}
