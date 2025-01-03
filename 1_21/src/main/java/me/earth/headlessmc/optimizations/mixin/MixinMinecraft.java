package me.earth.headlessmc.optimizations.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.util.profiling.ProfileResults;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public class MixinMinecraft {
    @Inject(method = "renderFpsMeter", at = @At("HEAD"), cancellable = true, require = 0)
    private void renderFpsMeterHook(GuiGraphics guiGraphics, ProfileResults profileResults, CallbackInfo ci) {
        ci.cancel();
    }

}
