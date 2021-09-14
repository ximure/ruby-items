package org.ximure.rubyitems;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;

public class RubyItems implements ModInitializer {
    // Constructors for tools
    public static class RubyPickaxe extends PickaxeItem {
        public RubyPickaxe(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
            super(material, attackDamage, attackSpeed, settings);
        }
    }
    public static class RubyAxe extends AxeItem {
        public RubyAxe(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
            super(material, attackDamage, attackSpeed, settings);
        }
    }
    public static class RubyHoe extends HoeItem {
        public RubyHoe(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
            super(material, attackDamage, attackSpeed, settings);
        }
    }

    // Group tab
    public static final ItemGroup ITEMS_GROUP = FabricItemGroupBuilder.build(
            new Identifier("rubyitems", "items"), () -> new ItemStack(RubyItems.RUBY));

    // Blocks
    public static final Block RUBY_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(4.5f));
    public static final Block RUBY_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(4.5F));

    // Items
    public static final Item RUBY = new Item(new FabricItemSettings().group(RubyItems.ITEMS_GROUP));

    // Tools
    public static final ToolItem RUBY_SWORD = new SwordItem(RubyItemsProperties.INSTANCE, 5, -2.4F,
            new Item.Settings().group(RubyItems.ITEMS_GROUP));
    public static final ToolItem RUBY_SHOVEL = new ShovelItem(RubyItemsProperties.INSTANCE, 3.5F, -3.0F,
            new Item.Settings().group(RubyItems.ITEMS_GROUP));
    public static final ToolItem RUBY_PICKAXE = new RubyPickaxe(RubyItemsProperties.INSTANCE, 3, -2.8F,
            new Item.Settings().group(RubyItems.ITEMS_GROUP));
    public static final ToolItem RUBY_AXE = new RubyAxe(RubyItemsProperties.INSTANCE, 7.7F, -3.1F,
            new Item.Settings().group(RubyItems.ITEMS_GROUP));
    public static final ToolItem RUBY_HOE = new RubyHoe(RubyItemsProperties.INSTANCE, 0, -1F,
            new Item.Settings().group(RubyItems.ITEMS_GROUP));

    // Armor
    public static final ArmorMaterial RUBY_ARMOR_MATERIAL = new RubyArmorProperties();
    public static final Item RUBY_MATERIAL_HELMET = new ArmorItem(RUBY_ARMOR_MATERIAL, EquipmentSlot.HEAD,
            new Item.Settings().group(RubyItems.ITEMS_GROUP));
    public static final Item RUBY_MATERIAL_CHESTPLATE = new ArmorItem(RUBY_ARMOR_MATERIAL, EquipmentSlot.CHEST,
            new Item.Settings().group(RubyItems.ITEMS_GROUP));
    public static final Item RUBY_MATERIAL_LEGGINGS = new ArmorItem(RUBY_ARMOR_MATERIAL, EquipmentSlot.LEGS,
            new Item.Settings().group(RubyItems.ITEMS_GROUP));
    public static final Item RUBY_MATERIAL_BOOTS = new ArmorItem(RUBY_ARMOR_MATERIAL, EquipmentSlot.FEET,
            new Item.Settings().group(RubyItems.ITEMS_GROUP));

    // Adding ruby ore to overworld oregen
    public static final ConfiguredFeature<?, ?> RUBY_ORE_OVERWORLD = Feature.ORE
            .configure(new OreFeatureConfig(
                    OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
                    RubyItems.RUBY_ORE.getDefaultState(),
                    3))
            .decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(
                    0,
                    0,
                    25)))
            .spreadHorizontally()
            .repeat(16);

    @Override
    public void onInitialize() {
        // Blocks registering
        Registry.register(Registry.BLOCK, new Identifier("rubyitems", "ruby_ore"), RUBY_ORE);
        Registry.register(Registry.BLOCK, new Identifier("rubyitems", "ruby_block"), RUBY_BLOCK);

        // Items registering
        Registry.register(Registry.ITEM, new Identifier("rubyitems", "ruby_ore"),
                new BlockItem(RUBY_ORE, new FabricItemSettings().group(RubyItems.ITEMS_GROUP))); // Ruby ore item
        Registry.register(Registry.ITEM, new Identifier("rubyitems", "ruby_block"),
                new BlockItem(RUBY_BLOCK, new FabricItemSettings().group(RubyItems.ITEMS_GROUP))); // Ruby block item
        Registry.register(Registry.ITEM, new Identifier("rubyitems", "ruby"), RUBY);

        // Tool registering
        Registry.register(Registry.ITEM, new Identifier("rubyitems", "ruby_sword"), RUBY_SWORD);
        Registry.register(Registry.ITEM, new Identifier("rubyitems", "ruby_shovel"), RUBY_SHOVEL);
        Registry.register(Registry.ITEM, new Identifier("rubyitems", "ruby_pickaxe"), RUBY_PICKAXE);
        Registry.register(Registry.ITEM, new Identifier("rubyitems", "ruby_axe"), RUBY_AXE);
        Registry.register(Registry.ITEM, new Identifier("rubyitems", "ruby_hoe"), RUBY_HOE);

        // Armor registering
        Registry.register(Registry.ITEM, new Identifier("rubyitems", "ruby_helmet"),
                RUBY_MATERIAL_HELMET);
        Registry.register(Registry.ITEM, new Identifier("rubyitems", "ruby_chestplate"),
                RUBY_MATERIAL_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier("rubyitems", "ruby_leggings"),
                RUBY_MATERIAL_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier("rubyitems", "ruby_boots"),
                RUBY_MATERIAL_BOOTS);

        // Ruby oregen init
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier("rubyitems",
                "ruby_ore_overworld"), RUBY_ORE_OVERWORLD);
    }
}