package io.github.randomusert.mods.tincore.core.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.world.entity.player.Player;

// test mixin to apply to minecrafts player class. Will be removed later
@Mixin(Player.class)
public class TestMixin {
    @Inject(method = "tick", at = @At("HEAD"))
    private void onTick(CallbackInfo ci) {
        System.out.println("Player mixin running!");
    }
}
