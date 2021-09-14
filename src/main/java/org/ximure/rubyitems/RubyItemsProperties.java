package org.ximure.rubyitems;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class RubyItemsProperties implements ToolMaterial {
    public static final RubyItemsProperties INSTANCE  = new RubyItemsProperties();
    @Override
    public int getDurability() {
        return 376;
    }
    @Override
    public float getMiningSpeedMultiplier() {
        return 6.5F;
    }
    @Override
    public float getAttackDamage() {
        return 0.5F;
    }
    @Override
    public int getMiningLevel() {
        return 2;
    }
    @Override
    public int getEnchantability() {
        return 15;
    }
    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(RubyItems.RUBY);
    }
}