package io.github.randomusert.mods.tincore.block.entities;

import io.github.randomusert.mods.tincore.energy.EnergyStorage;
import io.github.randomusert.mods.tincore.utils.LogUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public abstract class BaseMachineBlockEntity extends BlockEntity {

    protected final EnergyStorage energy;

    protected int progress;
    protected int maxProgress;

    protected int spendEnergy;

    public BaseMachineBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
        this.energy = new EnergyStorage(10000);
        this.maxProgress = 200;
        this.spendEnergy = 10;
    }

    public static <T extends BlockEntity> void tick(Level level, BlockPos pos, BlockState state, T t) {
        if (t instanceof BaseMachineBlockEntity be) {
            be.tickServer();
        }
    }

    protected void tickServer() {
        if (canWork()) {
            consumeEnergy();
            progress++;

            if (progress >= maxProgress) {
                craft();
                progress = 0;
            }

            setChanged();
        } else {
            progress = 0;
        }
    }

    protected boolean canWork() {
        return energy.getEnergy() >= spendEnergy;
    }

    protected void consumeEnergy() {
        energy.extract(energy.getEnergy() - spendEnergy, false);

        if (energy.getEnergy() < 0) {
            energy.setEnergy(0, false);
        }
    }

    protected abstract void craft();
}
