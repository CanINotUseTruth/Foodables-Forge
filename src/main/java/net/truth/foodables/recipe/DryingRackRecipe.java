package net.truth.foodables.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.truth.foodables.Foodables;
import org.jetbrains.annotations.NotNull;

public class DryingRackRecipe implements Recipe<SimpleContainer> {

    private final ResourceLocation id;
    private final NonNullList<Ingredient> inputItems;
    private final ItemStack result;
    private final int dryingTime;

    public DryingRackRecipe(ResourceLocation id, NonNullList<Ingredient> inputItems, ItemStack result, int dryingTime) {
        this.id = id;
        this.inputItems = inputItems;
        this.result = result;
        this.dryingTime = dryingTime;
    }

    @Override
    public boolean matches(@NotNull SimpleContainer pContainer, Level pLevel) {
        if(pLevel.isClientSide()) return false;
        return inputItems.get(0).test(pContainer.getItem(0));
    }

    @Override
    public @NotNull ItemStack assemble(@NotNull SimpleContainer p_44001_, @NotNull RegistryAccess p_267165_) {
        return result.copy();
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return true;
    }

    @Override
    public @NotNull ItemStack getResultItem(@NotNull RegistryAccess p_267052_) {
        return result.copy();
    }

    @Override
    public @NotNull NonNullList<Ingredient> getIngredients() {
        return this.inputItems;
    }

    @Override
    public @NotNull ResourceLocation getId() {
        return id;
    }

    public int getDryingTime() {
        return dryingTime;
    }


    @Override
    public @NotNull RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public @NotNull RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public static class Type implements RecipeType<DryingRackRecipe> {
        public static final Type INSTANCE = new Type();
        public static final String ID = "rack_drying";
    }

    public static class Serializer implements RecipeSerializer<DryingRackRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final ResourceLocation ID =
                new ResourceLocation(Foodables.MOD_ID,"rack_drying");

        @Override
        public @NotNull DryingRackRecipe fromJson(@NotNull ResourceLocation id, @NotNull JsonObject json) {
            ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(json, "result"));
            int dryingTime = GsonHelper.getAsInt(json, "dryingTime");

            JsonArray ingredients = GsonHelper.getAsJsonArray(json, "ingredients");
            NonNullList<Ingredient> inputs = NonNullList.withSize(1, Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
            }

            return new DryingRackRecipe(id, inputs, output, dryingTime);
        }

        @Override
        public DryingRackRecipe fromNetwork(@NotNull ResourceLocation id, FriendlyByteBuf buf) {
            NonNullList<Ingredient> inputs = NonNullList.withSize(buf.readInt(), Ingredient.EMPTY);

            inputs.replaceAll(ignored -> Ingredient.fromNetwork(buf));

            ItemStack output = buf.readItem();
            int dryingTime = buf.readInt();
            return new DryingRackRecipe(id, inputs, output, dryingTime);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buf, DryingRackRecipe recipe) {
            buf.writeInt(recipe.getIngredients().size());

            for (Ingredient ing : recipe.getIngredients()) {
                ing.toNetwork(buf);
            }
            buf.writeItemStack(recipe.getResultItem(null), false);
            buf.writeInt(recipe.getDryingTime());
        }
    }
}
