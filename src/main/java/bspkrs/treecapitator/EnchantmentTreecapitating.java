package bspkrs.treecapitator;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.init.Enchantments;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import bspkrs.treecapitator.config.TCSettings;
import bspkrs.treecapitator.registry.ToolRegistry;

public class EnchantmentTreecapitating extends Enchantment
{
    public EnchantmentTreecapitating(Enchantment.Rarity rarityIn, EntityEquipmentSlot... slots)
    {
        super(rarityIn, EnumEnchantmentType.DIGGER, slots);
        this.setName("treecapitating");
    }

    @Override
    public boolean canApply(ItemStack itemStack)
    {
        return itemStack.isItemEnchantable() && TCSettings.enableEnchantmentMode &&
                TCSettings.requireItemInAxeListForEnchant ? ToolRegistry.instance().isAxe(itemStack) : type.canEnchantItem(itemStack.getItem());
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack itemStack)
    {
        return itemStack.isItemEnchantable() && TCSettings.enableEnchantmentMode &&
                TCSettings.requireItemInAxeListForEnchant ? ToolRegistry.instance().isAxe(itemStack) : type.canEnchantItem(itemStack.getItem());
    }

    @Override
    public int getMinEnchantability(int par1)
    {
        return 20;
    }

    @Override
    public int getMaxEnchantability(int par1)
    {
        return 60;
    }

    @Override
    public int getMaxLevel()
    {
        return 1;
    }

    @Override
    public boolean canApplyTogether(Enchantment enchantment)
    {
        return TCSettings.enableEnchantmentMode && super.canApplyTogether(enchantment) && (enchantment != Enchantments.FORTUNE);
    }

}
