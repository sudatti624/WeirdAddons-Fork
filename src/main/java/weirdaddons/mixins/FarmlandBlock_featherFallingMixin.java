package weirdaddons.mixins;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FarmlandBlock;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import weirdaddons.WeirdAddonsSettings;

@Mixin(FarmlandBlock.class)
public abstract class FarmlandBlock_featherFallingMixin extends Block {
    public FarmlandBlock_featherFallingMixin(Settings settings) { super(settings); }

    @Inject(method = "onLandedUpon(Lnet/minecraft/world/World;Lnet/minecraft/block/BlockState;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/entity/Entity;F)V",
            at = @At("HEAD"), cancellable = true)
    private void stopTrampleIfFeather(World world, BlockState state, BlockPos pos, Entity entity, float fallDistance, CallbackInfo ci) {
        if (WeirdAddonsSettings.featherFallingPlus && entity instanceof LivingEntity livingEntity
                && EnchantmentHelper.getEquipmentLevel(Enchantments.FEATHER_FALLING, livingEntity) > 0) {
            // setToDirtをスキップし、Block.onLandedUpon(落下ダメージ処理)のみ実行
            super.onLandedUpon(world, state, pos, entity, fallDistance);
            ci.cancel();
        }
    }
}
