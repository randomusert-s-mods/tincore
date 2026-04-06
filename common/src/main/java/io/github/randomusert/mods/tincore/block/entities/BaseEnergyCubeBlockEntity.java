package io.github.randomusert.mods.tincore.block.entities;

import io.github.randomusert.mods.tincore.energy.EnergyStorage;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class BaseEnergyCubeBlockEntity extends BlockEntity {

    protected final EnergyStorage energy;
    protected int transferRate;

    public BaseEnergyCubeBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
        this.energy = new EnergyStorage(50000);
        this.transferRate = 100;
    }

    public static <T extends BlockEntity> void tick(Level level, BlockPos pos, BlockState state, T t) {
        if (t instanceof BaseEnergyCubeBlockEntity cube) {
            cube.tickServer(level, pos);
        }
    }

    protected void tickServer(Level level, BlockPos pos) {
        for (Direction dir : Direction.values()) {
            BlockEntity neighbor = level.getBlockEntity(pos.relative(dir));

            if (neighbor instanceof BaseMachineBlockEntity machine) {
                transferEnergy(machine);
            }
        }
    }

    protected void transferEnergy(BaseMachineBlockEntity target) {
        int extracted = Math.min(transferRate, energy.getEnergy());

        if (extracted > 0) {
            energy.setEnergy(energy.getEnergy() - extracted, false);
            target.energy.setEnergy(target.energy.getEnergy() + extracted, false);
        }
    }
}
