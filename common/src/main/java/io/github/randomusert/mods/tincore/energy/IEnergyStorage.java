package io.github.randomusert.mods.tincore.energy;


/**
 * IEnergyStorage interface stores info about our custom energy system called Tin Energy(TE)
 * <br/>
 * This energy system is built upon FE or Forge Energy.
 * */
public interface IEnergyStorage {

    int insert(int amount, boolean simulate);

    int extract(int amount, boolean simulate);

    int getEnergy();

    int getCapacity();

    default boolean canInsert() { return true; }

    default boolean canExtract() { return true; }

    int setEnergy(int amount, boolean simulate);
}
