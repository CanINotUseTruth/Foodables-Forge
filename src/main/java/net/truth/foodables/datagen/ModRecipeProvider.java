package net.truth.foodables.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.truth.foodables.block.ModBlocks;
import net.truth.foodables.datagen.custom.DryingRackRecipeBuilder;
import net.truth.foodables.item.ModItems;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider{

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {

        new DryingRackRecipeBuilder(ModItems.WET_CARTON.get(), ModItems.CARTON.get(), 1200, 1)
                .unlockedBy("has_drying_rack", has(ModBlocks.OAK_DRYING_RACK.get())).save(pWriter);
        new DryingRackRecipeBuilder(ModItems.SALTED_BACON_STRIPS.get(), ModItems.BACON_JERKY.get(), 3000, 1)
                .unlockedBy("has_drying_rack", has(ModBlocks.OAK_DRYING_RACK.get())).save(pWriter);
        new DryingRackRecipeBuilder(ModItems.SALTED_BEEF_STRIPS.get(), ModItems.BEEF_JERKY.get(), 3000, 1)
                .unlockedBy("has_drying_rack", has(ModBlocks.OAK_DRYING_RACK.get())).save(pWriter);
        new DryingRackRecipeBuilder(ModItems.SALTED_CHICKEN_STRIPS.get(), ModItems.CHICKEN_JERKY.get(), 3000, 1)
                .unlockedBy("has_drying_rack", has(ModBlocks.OAK_DRYING_RACK.get())).save(pWriter);
        new DryingRackRecipeBuilder(ModItems.SALTED_LAMB_STRIPS.get(), ModItems.LAMB_JERKY.get(), 3000, 1)
                .unlockedBy("has_drying_rack", has(ModBlocks.OAK_DRYING_RACK.get())).save(pWriter);
        new DryingRackRecipeBuilder(ModItems.SALTED_RABBIT_STRIPS.get(), ModItems.RABBIT_JERKY.get(), 3000, 1)
                .unlockedBy("has_drying_rack", has(ModBlocks.OAK_DRYING_RACK.get())).save(pWriter);
        new DryingRackRecipeBuilder(ModItems.SALTED_ZOMBIE_FLESH.get(), ModItems.ZOMBIE_JERKY.get(), 1500, 1)
                .unlockedBy("has_drying_rack", has(ModBlocks.OAK_DRYING_RACK.get())).save(pWriter);
        new DryingRackRecipeBuilder(ModItems.PEPPERCORN.get(), ModItems.DRIED_PEPPERCORN.get(), 3000, 1)
                .unlockedBy("has_drying_rack", has(ModBlocks.OAK_DRYING_RACK.get())).save(pWriter);

    }

}
