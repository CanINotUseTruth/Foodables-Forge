package net.truth.foodables.compat;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.truth.foodables.Foodables;
import net.truth.foodables.block.ModBlocks;
import net.truth.foodables.recipe.DryingRackRecipe;
import org.jetbrains.annotations.NotNull;

public class DryingRackRecipeCategory implements IRecipeCategory<DryingRackRecipe> {
    public static final ResourceLocation UID = new ResourceLocation(Foodables.MOD_ID, "rack_drying");
    public static final ResourceLocation TEXTURE = new ResourceLocation(Foodables.MOD_ID,
            "textures/gui/drying_rack_jei_gui.png");

    public static final RecipeType<DryingRackRecipe> DRYING_RACK_RECIPE_TYPE =
            new RecipeType<>(UID, DryingRackRecipe.class);

    private final IDrawable background;
    private final IDrawable icon;

    public DryingRackRecipeCategory(IGuiHelper helper) {
        Foodables.LOGGER.info(TEXTURE.toString());
        this.background = helper.drawableBuilder(TEXTURE, 0, 0, 74, 31).setTextureSize(74,31).build();
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK,
                new ItemStack(ModBlocks.OAK_DRYING_RACK.get()));
    }

    @Override
    public void draw(@NotNull DryingRackRecipe recipe, @NotNull IRecipeSlotsView recipeSlotsView, @NotNull GuiGraphics guiGraphics, double mouseX, double mouseY) {
        drawCookTime(recipe, guiGraphics);
    }

    protected void drawCookTime(DryingRackRecipe recipe, GuiGraphics guiGraphics) {
        int dryingTime = recipe.getDryingTime();
        if (dryingTime > 0) {
            Component timeString;
            int dryingTimeSeconds, dryingTimeMinutes;
            if(dryingTime < 1200) {
                dryingTimeSeconds = dryingTime / 20;
                timeString = Component.translatable("gui.jei.category.rack.drying.time.seconds", dryingTimeSeconds);
            }
            else if(dryingTime % 1200 == 0) {
                dryingTimeMinutes = dryingTime / 1200;
                timeString = Component.translatable("gui.jei.category.rack.drying.time.minutes", dryingTimeMinutes);
            } else {
                dryingTimeMinutes = dryingTime / 1200;
                dryingTimeSeconds = dryingTime % 1200 / 20;
                timeString = Component.translatable("gui.jei.category.rack.drying.time.minutes.seconds", dryingTimeMinutes, dryingTimeSeconds);
            }
            Minecraft minecraft = Minecraft.getInstance();
            Font fontRenderer = minecraft.font;
            int stringWidth = fontRenderer.width(timeString);
            guiGraphics.drawString(fontRenderer, timeString, getWidth() / 2 - stringWidth / 2 , 0, 0xFF808080, false);
        }
    }

    @Override
    public @NotNull RecipeType<DryingRackRecipe> getRecipeType() {
        return DRYING_RACK_RECIPE_TYPE;
    }

    @Override
    public @NotNull Component getTitle() {
        return Component.literal("Drying Rack");
    }

    @Override
    public @NotNull IDrawable getBackground() {
        return this.background;
    }

    @Override
    public @NotNull IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, DryingRackRecipe recipe, @NotNull IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 1, 14).addIngredients(recipe.getIngredients().get(0));

        builder.addSlot(RecipeIngredientRole.OUTPUT, 57, 14).addItemStack(recipe.getResultItem(null));
    }
}
