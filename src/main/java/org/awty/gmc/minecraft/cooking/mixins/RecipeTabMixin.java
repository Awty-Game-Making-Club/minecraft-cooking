package org.awty.gmc.minecraft.cooking.mixins;

import net.minecraft.client.gui.screen.recipebook.RecipeBookWidget;
import net.minecraft.screen.AbstractRecipeScreenHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(RecipeBookWidget.class)
public class RecipeTabMixin {
    @Shadow protected AbstractRecipeScreenHandler<?> craftingScreenHandler;

//    @ModifyArgs(method = "reset", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/recipebook/RecipeBookGroup;method_30285(Lnet/minecraft/recipe/book/RecipeBookCategory;)Ljava/util/List;"))
//    private void replaceCategory(Args args) {
//        if(craftingScreenHandler instanceof AbstractCookingScreenHandler) {
//            LogManager.getLogger().info("Iterator replacement Mixin activated!");
//            RecipeBookCategory newCategory = RecipeBookCategory.SMOKER;
//            LogManager.getLogger().info("Changing {} to {}", args.get(0).toString(), newCategory.toString());
//            args.set(0, newCategory);
//        }
//    }
}