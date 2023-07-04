package net.truth.foodables.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.truth.foodables.Foodables;
import net.truth.foodables.block.ModBlocks;
import net.truth.foodables.item.custom.ModDrink;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Foodables.MOD_ID);

    // - Tool Items -
    public static final RegistryObject<Item> MORTAR_AND_PESTLE = ITEMS.register("mortar_and_pestle", () -> new Item(new Item.Properties()
            .stacksTo(1)));
    public static final RegistryObject<Item> KNIFE = ITEMS.register("knife", () -> new Item(new Item.Properties()
            .stacksTo(1)));
    public static final RegistryObject<Item> CRUSHER = ITEMS.register("crusher", () -> new Item(new Item.Properties()
            .stacksTo(1)));
    public static final RegistryObject<Item> WHISK = ITEMS.register("whisk", () -> new Item(new Item.Properties()
            .stacksTo(1)));
    public static final RegistryObject<Item> JUICER = ITEMS.register("juicer", () -> new Item(new Item.Properties()
            .stacksTo(1)));
    public static final RegistryObject<Item> WET_CARTON = ITEMS.register("wet_carton", () -> new Item(new Item.Properties()
            .stacksTo(16)));
    public static final RegistryObject<Item> CARTON = ITEMS.register("carton", () -> new Item(new Item.Properties()
            .stacksTo(16)));
    public static final RegistryObject<Item> CAKE_TIN = ITEMS.register("cake_tin", () -> new Item(new Item.Properties()
            .stacksTo(16)));

    // - Seed Items -
    public static final RegistryObject<Item> LETTUCE_SEEDS = ITEMS.register("lettuce_seeds",
            () -> new ItemNameBlockItem(ModBlocks.LETTUCE_CROP.get(), new Item.Properties()));
    public static final RegistryObject<Item> TOMATO_SEEDS = ITEMS.register("tomato_seeds",
            () -> new ItemNameBlockItem(ModBlocks.TOMATO_CROP.get(), new Item.Properties()));
    public static final RegistryObject<Item> BROWN_ONION_SEEDS = ITEMS.register("brown_onion_seeds",
            () -> new ItemNameBlockItem(ModBlocks.BROWN_ONION_CROP.get(), new Item.Properties()));
    public static final RegistryObject<Item> RED_ONION_SEEDS = ITEMS.register("red_onion_seeds",
            () -> new ItemNameBlockItem(ModBlocks.RED_ONION_CROP.get(), new Item.Properties()));
    public static final RegistryObject<Item> GARLIC_SEEDS = ITEMS.register("garlic_seeds",
            () -> new ItemNameBlockItem(ModBlocks.GARLIC_CROP.get(), new Item.Properties()));

    //  - Food Items -
    // Veggies
    public static final RegistryObject<Item> LETTUCE = ITEMS.register("lettuce", () -> new Item(new Item.Properties()
            .food(new FoodProperties.Builder().nutrition(2).saturationMod(0.6F).build())));
    public static final RegistryObject<Item> TOMATO = ITEMS.register("tomato", () -> new Item(new Item.Properties()
            .food(new FoodProperties.Builder().nutrition(2).saturationMod(0.6F).build())));
    public static final RegistryObject<Item> GARLIC = ITEMS.register("garlic", () -> new Item(new Item.Properties()
            .food(new FoodProperties.Builder().nutrition(2).saturationMod(0.3F).build())));
    public static final RegistryObject<Item> BROWN_ONION = ITEMS.register("brown_onion", () -> new Item(new Item.Properties()
            .food(new FoodProperties.Builder().nutrition(2).saturationMod(0.3F).build())));
    public static final RegistryObject<Item> RED_ONION = ITEMS.register("red_onion", () -> new Item(new Item.Properties()
            .food(new FoodProperties.Builder().nutrition(2).saturationMod(0.6F).build())));
    public static final RegistryObject<Item> SLICED_BROWN_ONION = ITEMS.register("sliced_brown_onion", () -> new Item(new Item.Properties()
            .food(new FoodProperties.Builder().nutrition(2).saturationMod(0.3F).build())));
    public static final RegistryObject<Item> SLICED_RED_ONION = ITEMS.register("sliced_red_onion", () -> new Item(new Item.Properties()
            .food(new FoodProperties.Builder().nutrition(2).saturationMod(0.6F).build())));
    public static final RegistryObject<Item> PUMPKIN_SLICES = ITEMS.register("pumpkin_slices", () -> new Item(new Item.Properties()
            .food(new FoodProperties.Builder().nutrition(2).saturationMod(0.3F).build())));

    // Cooked Veggies
    public static final RegistryObject<Item> COOKED_ONION = ITEMS.register("cooked_onion", () -> new Item(new Item.Properties()
            .food(new FoodProperties.Builder().nutrition(4).saturationMod(0.5F).build())));
    public static final RegistryObject<Item> CARAMELIZED_ONION = ITEMS.register("caramelized_onion", () -> new Item(new Item.Properties()
            .food(new FoodProperties.Builder().nutrition(5).saturationMod(0.6F).build())));
    public static final RegistryObject<Item> BATTERED_ONIONS = ITEMS.register("battered_onions", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ONION_RINGS = ITEMS.register("onion_rings", () -> new Item(new Item.Properties()
            .food(new FoodProperties.Builder().nutrition(5).saturationMod(0.8F).build())));
    public static final RegistryObject<Item> UNCOOKED_FRIES = ITEMS.register("uncooked_fries", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> FRIES = ITEMS.register("fries", () -> new Item(new Item.Properties()
            .food(new FoodProperties.Builder().nutrition(5).saturationMod(0.8F).build())));

    // Fruit
    public static final RegistryObject<Item> LEMON = ITEMS.register("lemon", () -> new Item(new Item.Properties()
            .food(new FoodProperties.Builder().nutrition(2).saturationMod(0.6F).build())));
    public static final RegistryObject<Item> LIME = ITEMS.register("lime", () -> new Item(new Item.Properties()
            .food(new FoodProperties.Builder().nutrition(2).saturationMod(0.6F).build())));
    public static final RegistryObject<Item> ORANGE = ITEMS.register("orange", () -> new Item(new Item.Properties()
            .food(new FoodProperties.Builder().nutrition(4).saturationMod(0.6F).build())));
    public static final RegistryObject<Item> MANGO = ITEMS.register("mango", () -> new Item(new Item.Properties()
            .food(new FoodProperties.Builder().nutrition(4).saturationMod(0.6F).build())));
    public static final RegistryObject<Item> BANANA = ITEMS.register("banana", () -> new Item(new Item.Properties()
            .food(new FoodProperties.Builder().nutrition(4).saturationMod(0.6F).build())));
    public static final RegistryObject<Item> FRUIT_SALAD = ITEMS.register("fruit_salad", () -> new Item(new Item.Properties()
            .food(new FoodProperties.Builder().nutrition(8).saturationMod(0.8F).build())));

    // Berries
    public static final RegistryObject<Item> BLUEBERRIES = ITEMS.register("blueberries", () -> new Item(new Item.Properties()
            .food(new FoodProperties.Builder().nutrition(3).saturationMod(0.5F).build())));
    public static final RegistryObject<Item> BLACKBERRIES = ITEMS.register("blackberries", () -> new Item(new Item.Properties()
            .food(new FoodProperties.Builder().nutrition(3).saturationMod(0.5F).build())));

    // Baked Fruit & Veggies
    public static final RegistryObject<Item> BAKED_APPLE = ITEMS.register("baked_apple", () -> new Item(new Item.Properties()
            .food(new FoodProperties.Builder().nutrition(6).saturationMod(0.5F).build())));
    public static final RegistryObject<Item> BAKED_PUMPKIN = ITEMS.register("baked_pumpkin", () -> new Item(new Item.Properties()
            .food(new FoodProperties.Builder().nutrition(4).saturationMod(0.6F).build())));
    public static final RegistryObject<Item> BAKED_CARROT = ITEMS.register("baked_carrot", () -> new Item(new Item.Properties()
            .food(new FoodProperties.Builder().nutrition(4).saturationMod(0.6F).build())));
    public static final RegistryObject<Item> BAKED_BEETROOT = ITEMS.register("baked_beetroot", () -> new Item(new Item.Properties()
            .food(new FoodProperties.Builder().nutrition(3).saturationMod(0.6F).build())));

    // Meat
    public static final RegistryObject<Item> SQUID = ITEMS.register("squid", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BATTERED_SQUID = ITEMS.register("battered_squid", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SALT_AND_PEPPER_SQUID = ITEMS.register("salt_and_pepper_squid", () -> new Item(new Item.Properties()
            .food(new FoodProperties.Builder().nutrition(10).saturationMod(0.6F).build())));
    public static final RegistryObject<Item> RAW_NUGGETS = ITEMS.register("raw_nuggets", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BATTERED_NUGGETS = ITEMS.register("battered_nuggets", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> COOKED_NUGGETS = ITEMS.register("cooked_nuggets", () -> new Item(new Item.Properties()
            .food(new FoodProperties.Builder().nutrition(8).saturationMod(0.8F).build())));
    public static final RegistryObject<Item> RAW_BACON = ITEMS.register("raw_bacon", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SALTED_BACON_STRIPS = ITEMS.register("salted_bacon_strips", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BACON_JERKY = ITEMS.register("bacon_jerky", () -> new Item(new Item.Properties()
            .food(new FoodProperties.Builder().nutrition(9).saturationMod(0.75F).build())));
    public static final RegistryObject<Item> COOKED_BACON = ITEMS.register("cooked_bacon", () -> new Item(new Item.Properties()
            .food(new FoodProperties.Builder().nutrition(6).saturationMod(0.8F).build())));
    public static final RegistryObject<Item> CHICKEN_STRIPS = ITEMS.register("chicken_strips", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SALTED_CHICKEN_STRIPS = ITEMS.register("salted_chicken_strips", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CHICKEN_JERKY = ITEMS.register("chicken_jerky", () -> new Item(new Item.Properties()
            .food(new FoodProperties.Builder().nutrition(7).saturationMod(0.75F).build())));
    public static final RegistryObject<Item> BEEF_STRIPS = ITEMS.register("beef_strips", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SALTED_BEEF_STRIPS = ITEMS.register("salted_beef_strips", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BEEF_JERKY = ITEMS.register("beef_jerky", () -> new Item(new Item.Properties()
            .food(new FoodProperties.Builder().nutrition(9).saturationMod(0.75F).build())));
    public static final RegistryObject<Item> COOKED_BEEF_STRIPS = ITEMS.register("cooked_beef_strips", () -> new Item(new Item.Properties()
            .food(new FoodProperties.Builder().nutrition(6).saturationMod(0.8F).build())));
    public static final RegistryObject<Item> LAMB_STRIPS = ITEMS.register("lamb_strips", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SALTED_LAMB_STRIPS = ITEMS.register("salted_lamb_strips", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LAMB_JERKY = ITEMS.register("lamb_jerky", () -> new Item(new Item.Properties()
            .food(new FoodProperties.Builder().nutrition(7).saturationMod(0.75F).build())));
    public static final RegistryObject<Item> RABBIT_STRIPS = ITEMS.register("rabbit_strips", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SALTED_RABBIT_STRIPS = ITEMS.register("salted_rabbit_strips", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RABBIT_JERKY = ITEMS.register("rabbit_jerky", () -> new Item(new Item.Properties()
            .food(new FoodProperties.Builder().nutrition(7).saturationMod(0.75F).build())));
    public static final RegistryObject<Item> SALTED_ZOMBIE_FLESH = ITEMS.register("salted_zombie_flesh", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ZOMBIE_JERKY = ITEMS.register("zombie_jerky", () -> new Item(new Item.Properties()
            .food(new FoodProperties.Builder().nutrition(4).saturationMod(0.5F).build())));

    // Meat Adjacent
    public static final RegistryObject<Item> FRIED_EGG = ITEMS.register("fried_egg", () -> new Item(new Item.Properties()
            .food(new FoodProperties.Builder().nutrition(4).saturationMod(0.8F).build())));
    public static final RegistryObject<Item> BACON_AND_EGG = ITEMS.register("bacon_and_eggs", () -> new Item(new Item.Properties()
            .food(new FoodProperties.Builder().nutrition(8).saturationMod(0.8F).build())));

    // Juices
    public static final RegistryObject<Item> LEMON_JUICE = ITEMS.register("lemon_juice", () -> new ModDrink(new Item.Properties()
            .food(new FoodProperties.Builder().nutrition(3).saturationMod(0.6F).build()).craftRemainder(Items.GLASS_BOTTLE)));
    public static final RegistryObject<Item> LIME_JUICE = ITEMS.register("lime_juice", () -> new ModDrink(new Item.Properties()
            .food(new FoodProperties.Builder().nutrition(3).saturationMod(0.6F).build()).craftRemainder(Items.GLASS_BOTTLE)));
    public static final RegistryObject<Item> ORANGE_JUICE = ITEMS.register("orange_juice", () -> new ModDrink(new Item.Properties()
            .food(new FoodProperties.Builder().nutrition(5).saturationMod(0.5F).build()).craftRemainder(Items.GLASS_BOTTLE)));
    public static final RegistryObject<Item> APPLE_JUICE = ITEMS.register("apple_juice", () -> new ModDrink(new Item.Properties()
            .food(new FoodProperties.Builder().nutrition(5).saturationMod(0.5F).build()).craftRemainder(Items.GLASS_BOTTLE)));
    public static final RegistryObject<Item> CARROT_JUICE = ITEMS.register("carrot_juice", () -> new ModDrink(new Item.Properties()
            .food(new FoodProperties.Builder().nutrition(3).saturationMod(0.6F).build()).craftRemainder(Items.GLASS_BOTTLE)));
    public static final RegistryObject<Item> PUMPKIN_JUICE = ITEMS.register("pumpkin_juice", () -> new ModDrink(new Item.Properties()
            .food(new FoodProperties.Builder().nutrition(3).saturationMod(0.6F).build()).craftRemainder(Items.GLASS_BOTTLE)));
    public static final RegistryObject<Item> TOMATO_JUICE = ITEMS.register("tomato_juice", () -> new ModDrink(new Item.Properties()
            .food(new FoodProperties.Builder().nutrition(3).saturationMod(0.6F).build()).craftRemainder(Items.GLASS_BOTTLE)));
    public static final RegistryObject<Item> MELON_JUICE = ITEMS.register("melon_juice", () -> new ModDrink(new Item.Properties()
            .food(new FoodProperties.Builder().nutrition(5).saturationMod(0.5F).build()).craftRemainder(Items.GLASS_BOTTLE)));
    public static final RegistryObject<Item> SWEET_BERRY_JUICE = ITEMS.register("sweet_berry_juice", () -> new ModDrink(new Item.Properties()
            .food(new FoodProperties.Builder().nutrition(5).saturationMod(0.5F).build()).craftRemainder(Items.GLASS_BOTTLE)));
    public static final RegistryObject<Item> BLUEBERRY_JUICE = ITEMS.register("blueberry_juice", () -> new ModDrink(new Item.Properties()
            .food(new FoodProperties.Builder().nutrition(5).saturationMod(0.5F).build()).craftRemainder(Items.GLASS_BOTTLE)));
    public static final RegistryObject<Item> BLACKBERRY_JUICE = ITEMS.register("blackberry_juice", () -> new ModDrink(new Item.Properties()
            .food(new FoodProperties.Builder().nutrition(5).saturationMod(0.5F).build()).craftRemainder(Items.GLASS_BOTTLE)));
    public static final RegistryObject<Item> MANGO_JUICE = ITEMS.register("mango_juice", () -> new ModDrink(new Item.Properties()
            .food(new FoodProperties.Builder().nutrition(5).saturationMod(0.5F).build()).craftRemainder(Items.GLASS_BOTTLE)));

    // Drinks
    public static final RegistryObject<Item> LEMONADE = ITEMS.register("lemonade", () -> new ModDrink(new Item.Properties()
            .food(new FoodProperties.Builder().nutrition(5).saturationMod(0.7F).build()).craftRemainder(Items.GLASS_BOTTLE)));

    // Oils
    public static final RegistryObject<Item> SUNFLOWER_OIL = ITEMS.register("sunflower_oil", () -> new Item(new Item.Properties()
            .craftRemainder(Items.GLASS_BOTTLE)));

    // Sauces
    public static final RegistryObject<Item> MAYONNAISE = ITEMS.register("mayonnaise", () -> new Item(new Item.Properties()
            .craftRemainder(Items.GLASS_BOTTLE)));
    public static final RegistryObject<Item> AIOLI = ITEMS.register("aioli", () -> new Item(new Item.Properties()
            .craftRemainder(Items.GLASS_BOTTLE)));

    // Cake Related Items
    public static final RegistryObject<Item> PLAIN_CAKE_MIX = ITEMS.register("plain_cake_mix", () -> new Item(new Item.Properties()
            .stacksTo(16)));
    public static final RegistryObject<Item> HONEY_CAKE_MIX = ITEMS.register("honey_cake_mix", () -> new Item(new Item.Properties()
            .stacksTo(16)));
    public static final RegistryObject<Item> APPLE_CAKE_MIX = ITEMS.register("apple_cake_mix", () -> new Item(new Item.Properties()
            .stacksTo(16)));
    public static final RegistryObject<Item> BERRY_CAKE_MIX = ITEMS.register("berry_cake_mix", () -> new Item(new Item.Properties()
            .stacksTo(16)));
    public static final RegistryObject<Item> ORANGE_CAKE_MIX = ITEMS.register("orange_cake_mix", () -> new Item(new Item.Properties()
            .stacksTo(16)));
    public static final RegistryObject<Item> BANANA_CAKE_MIX = ITEMS.register("banana_cake_mix", () -> new Item(new Item.Properties()
            .stacksTo(16)));
    public static final RegistryObject<Item> CHOCOLATE_CAKE_MIX = ITEMS.register("chocolate_cake_mix", () -> new Item(new Item.Properties()
            .stacksTo(16)));
    public static final RegistryObject<Item> BAKED_PLAIN_CAKE = ITEMS.register("baked_plain_cake", () -> new Item(new Item.Properties()
            .stacksTo(16).craftRemainder(CAKE_TIN.get())));
    public static final RegistryObject<Item> BAKED_HONEY_CAKE = ITEMS.register("baked_honey_cake", () -> new Item(new Item.Properties()
            .stacksTo(16).craftRemainder(CAKE_TIN.get())));
    public static final RegistryObject<Item> BAKED_APPLE_CAKE = ITEMS.register("baked_apple_cake", () -> new Item(new Item.Properties()
            .stacksTo(16).craftRemainder(CAKE_TIN.get())));
    public static final RegistryObject<Item> BAKED_BERRY_CAKE = ITEMS.register("baked_berry_cake", () -> new Item(new Item.Properties()
            .stacksTo(16).craftRemainder(CAKE_TIN.get())));
    public static final RegistryObject<Item> BAKED_ORANGE_CAKE = ITEMS.register("baked_orange_cake", () -> new Item(new Item.Properties()
            .stacksTo(16).craftRemainder(CAKE_TIN.get())));
    public static final RegistryObject<Item> BAKED_BANANA_CAKE = ITEMS.register("baked_banana_cake", () -> new Item(new Item.Properties()
            .stacksTo(16).craftRemainder(CAKE_TIN.get())));
    public static final RegistryObject<Item> BAKED_CHOCOLATE_CAKE = ITEMS.register("baked_chocolate_cake", () -> new Item(new Item.Properties()
            .stacksTo(16).craftRemainder(CAKE_TIN.get())));

    // Sandwich Related Items
    public static final RegistryObject<Item> DOUGH = ITEMS.register("dough", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SLICED_BREAD = ITEMS.register("sliced_bread", () -> new Item(new Item.Properties()
            .food(new FoodProperties.Builder().nutrition(2).saturationMod(0.4F).build())));
    public static final RegistryObject<Item> TOAST = ITEMS.register("toast", () -> new Item(new Item.Properties()
            .food(new FoodProperties.Builder().nutrition(4).saturationMod(0.8F).build())));
    public static final RegistryObject<Item> BLT_SANDWICH = ITEMS.register("blt_sandwich", () -> new Item(new Item.Properties()
            .food(new FoodProperties.Builder().nutrition(12).saturationMod(0.6F).build())));
    public static final RegistryObject<Item> STEAK_SANDWICH = ITEMS.register("steak_sandwich", () -> new Item(new Item.Properties()
            .food(new FoodProperties.Builder().nutrition(14).saturationMod(0.6F).build())));

    // Miscellaneous
    public static final RegistryObject<Item> PEPPERCORN = ITEMS.register("peppercorn", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DRIED_PEPPERCORN = ITEMS.register("dried_peppercorn", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SALT = ITEMS.register("salt", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GROUND_PEPPER = ITEMS.register("ground_pepper", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GROUND_SALT = ITEMS.register("ground_salt", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> WHEAT_FLOUR = ITEMS.register("wheat_flour", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GROUND_COCOA = ITEMS.register("ground_cocoa", () -> new Item(new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
