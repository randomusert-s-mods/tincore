package io.github.randomusert.mods.tincore.energy;

/**
 * A marker interface for Tin Core energy used by my mods.
 * @author randomusert
 * @version 0.1.0
 */
public interface ITinEnergy {
    /**
     * gets the current energy stored in the object.
     * @return the current energy stored.
     */
    int getEnergy();

    /**
     * gets the max energy capacity of the object.
     * @return the max energy capacity.
     */
    int getMaxEnergy();
     /**
     * Attempts to add energy to this container.
     *
     * @param amount   the maximum amount of energy to add
     * @param simulate if {@code true}, no actual change is applied
     * @return the amount of energy that was (or would be) accepted
     */
    int receiveEnergy(int amount, boolean simulate);

    /**
     * Attempts to extract energy from this container.
     *
     * @param amount   the maximum amount of energy to remove
     * @param simulate if {@code true}, no actual change is applied
     * @return the amount of energy that was (or would be) extracted
     */
    int extractEnergy(int amount, boolean simulate);

    /**
     * Checks whether this container is allowed to receive energy.
     *
     * @return {@code true} if receiving energy is allowed
     */
    boolean canReceive();

    /**
     * Checks whether this container is allowed to extract energy.
     *
     * @return {@code true} if extracting energy is allowed
     */
    boolean canExtract();

}
