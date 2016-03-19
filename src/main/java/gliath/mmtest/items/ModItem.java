package gliath.mmtest.items;

import gliath.mmtest.MMTest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class ModItem extends Item {
    public ModItem() {
        super();
        this.setUnlocalizedName("mod_item");
        this.setCreativeTab(MMTest.tabMod);
    }

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ) {
        if (!playerIn.isSneaking()) {
            if (stack.getTagCompound() == null)
                stack.setTagCompound(new NBTTagCompound());

            NBTTagCompound nbt = new NBTTagCompound();
            nbt.setInteger("dim", playerIn.dimension);
            nbt.setInteger("posX", pos.getX());
            nbt.setInteger("posY", pos.getY());
            nbt.setInteger("posZ", pos.getZ());
            stack.getTagCompound().setTag("coords", nbt);
            stack.setStackDisplayName(EnumChatFormatting.AQUA + "Mod Item (Data stored)");
        }
        return false;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack stack, World worldIn, EntityPlayer playerIn) {
        if (playerIn.isSneaking()) {
            if (stack.getTagCompound() != null) {
                stack.getTagCompound().removeTag("coords");
                stack.clearCustomName();
            }
        }
        return stack;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List toolTip, boolean advanced) {
        if (stack.getTagCompound() != null) {
            if (stack.getTagCompound().hasKey("coords")) {
                NBTTagCompound nbt = (NBTTagCompound) stack.getTagCompound().getTag("coords");
                int dim = nbt.getInteger("dim");
                int posX = nbt.getInteger("posX");
                int posY = nbt.getInteger("posY");
                int posZ = nbt.getInteger("posZ");
                toolTip.add(EnumChatFormatting.DARK_GRAY + "Dim: " + EnumChatFormatting.GRAY + dim + EnumChatFormatting.DARK_GRAY + " X: " + EnumChatFormatting.GRAY + posX + EnumChatFormatting.DARK_GRAY + " Y: " + EnumChatFormatting.GRAY + posY + EnumChatFormatting.DARK_GRAY + " Z: " + EnumChatFormatting.GRAY + posZ);
            }
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack) {
        if (stack.getTagCompound() != null)
            return stack.getTagCompound().hasKey("coords");

        return false;
    }
}