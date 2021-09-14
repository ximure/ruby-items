package org.ximure.rubyitems;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public class RubyArmorProperties implements ArmorMaterial {
    private static final int[] BASE_DURABILITY = new int[] {287, 302, 329, 243};
    private static final int[] PROTECTION_VALUES = new int[] {2, 5, 7, 2};
    @Override
    public int getDurability(EquipmentSlot slot) {
        return BASE_DURABILITY[slot.getEntitySlotId()];
    }
    @Override
    public int getProtectionAmount(EquipmentSlot slot) {
        return PROTECTION_VALUES[slot.getEntitySlotId()];
    }
    @Override
    public int getEnchantability() {
        return 15;
    }
    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ITEM_ARMOR_EQUIP_IRON;
    }
    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(RubyItems.RUBY);
    }
    @Override
    public String getName() {
        return "ruby";
    }
    @Override
    public float getToughness() {
        return 1F;
    }
    @Override
    public float getKnockbackResistance() {
        return 0F;
    }
}