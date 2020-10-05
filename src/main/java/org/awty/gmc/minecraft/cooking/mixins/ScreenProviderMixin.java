package org.awty.gmc.minecraft.cooking.mixins;

import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.screen.ScreenHandlerType;
import org.apache.logging.log4j.LogManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin(HandledScreens.class)
public class ScreenProviderMixin {
//    @ModifyArgs(method = "getProvider", at = @At(value = "INVOKE", target = "Ljava/util/Map;get(Ljava/lang/Object;)Ljava/lang/Object;"))
//    private static void injectProvider(Args args) {
//        if(true) {
//            LogManager.getLogger().info("Foreign provider injection successful!");
//            args.set(0, ScreenHandlerType.CRAFTING);
//        }
//    }
}
