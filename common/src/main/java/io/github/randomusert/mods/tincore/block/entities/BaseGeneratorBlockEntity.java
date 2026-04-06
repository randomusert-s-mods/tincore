package io.github.randomusert.mods.tincore.block.entities;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public abstract class BaseGeneratorBlockEntity extends BaseMachineBlockEntity {

    protected int generationRate;

    public BaseGeneratorBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
        this.generationRate = 20; // default
    }

    @Override
    protected void tickServer() {
        generateEnergy();
        setChanged();
    }

    protected void generateEnergy() {
        energy.setEnergy(
                Math.min(energy.getEnergy() + generationRate, energy.getCapacity()), false
        );
    }

    @Override
    protected void craft() {
        // generators don’t craft
    }
}
