package net.wakeful.noScroll.wakefulsNoScrollWheelMod.mixin;

import net.minecraft.client.Mouse;
import net.wakeful.noScroll.wakefulsNoScrollWheelMod.WakefulsNoScrollWheelMod;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Mouse.class)
public abstract class MouseScrollDisableMixin {
    @Inject(method = "onMouseScroll(JDD)V", at = @At("HEAD"), cancellable = true)
    private void wakefulsNoScrollWheelMod$onMouseScroll(long window, double horizontal, double vertical, CallbackInfo ci) {
        boolean effectiveDisable = WakefulsNoScrollWheelMod.config != null
                ? WakefulsNoScrollWheelMod.config.disableScrolling
                : WakefulsNoScrollWheelMod.disableScroll;
        if (effectiveDisable) {
            ci.cancel();
        }
    }
}
