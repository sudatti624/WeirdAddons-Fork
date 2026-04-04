package weirdaddons.mixins;

import net.minecraft.world.tick.WorldTickScheduler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;
import weirdaddons.WeirdAddonsSettings;

@Mixin(WorldTickScheduler.class)
public abstract class WorldTickScheduler_instantMixin {

    @ModifyArgs(
            method = "tick(JILjava/util/function/BiConsumer;)V",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/tick/WorldTickScheduler;collectTickableTicks(JILnet/minecraft/util/profiler/Profiler;)V"
            )
    )
    private void tickAllChunkTickSchedulers(Args args) {
        boolean isInstant = ((WeirdAddonsSettings.instantTileTick && WeirdAddonsSettings.insideBlockTicks) || (WeirdAddonsSettings.instantLiquidFlow && !WeirdAddonsSettings.insideBlockTicks));
        if (isInstant) {
            args.set(0, Long.MAX_VALUE);
            args.set(1, Integer.MAX_VALUE);
        }
    }
}
