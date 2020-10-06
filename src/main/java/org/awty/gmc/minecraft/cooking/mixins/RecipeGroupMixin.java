package org.awty.gmc.minecraft.cooking.mixins;

import net.minecraft.client.recipebook.ClientRecipeBook;
import net.minecraft.client.recipebook.RecipeBookGroup;
import net.minecraft.recipe.Recipe;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ClientRecipeBook.class)
public class RecipeGroupMixin {
    private static final Logger logger = LogManager.getLogger("RecipeGroupMixin");

    @Inject(method = "getGroupForRecipe", at = @At("RETURN"), cancellable = true)
    private static void customRecipeGroupFixer(Recipe<?> recipe, CallbackInfoReturnable<RecipeBookGroup> callbackInfo) {
        if(callbackInfo.getReturnValue() == RecipeBookGroup.UNKNOWN) {
            logger.info("Unknown recipe category Mixin fix activated!");
            callbackInfo.setReturnValue(RecipeBookGroup.CRAFTING_MISC);
        }
    }
}