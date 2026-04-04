package weirdaddons.mixins;

import net.minecraft.item.ItemStack;
import net.minecraft.screen.AnvilScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.text.LiteralText;
import org.apache.commons.lang3.StringUtils;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import weirdaddons.WeirdAddonsSettings;


@Mixin(AnvilScreenHandler.class)
public abstract class AnvilScreenHandlerMixin extends ScreenHandler {

    protected AnvilScreenHandlerMixin(ScreenHandlerType<?> type, int syncId) {
        super(type, syncId);
    }

    @Shadow
    private String newItemName;

    @Shadow
    public abstract void updateResult();

    @Inject(at = @At("HEAD"), method = "setNewItemName", cancellable = true)
    public void setNewItemName(String string, CallbackInfo info) {
        if (WeirdAddonsSettings.anvilColorFormatting && string != null) {

            info.cancel();

            if (string.matches(".*&[0-9a-fk-or].*")) {
                this.newItemName = string.replace("&", "§");
            } else {
                this.newItemName = string;
            }

            if (this.getSlot(2).hasStack()) {
                ItemStack itemStack = this.getSlot(2).getStack();
                if (StringUtils.isBlank(string)) {
                    itemStack.removeCustomName();
                } else {
                    itemStack.setCustomName(new LiteralText(this.newItemName));
                }
            }

            this.updateResult();
        }
    }
}

