package gliath.mmtest.blocks;

import gliath.mmtest.items.ModItem;
import gliath.mmtest.tileentity.ModTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.World;

public class ModBlock extends Block implements ITileEntityProvider {

    public ModBlock(Material materialIn) {
        super(materialIn);
    }

    @Override
    public boolean isOpaqueCube() {
        return false; // Makes transparent textures transparant
    }

    @Override
    public boolean isFullCube() {
        return false;
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ) {
        ItemStack stack = playerIn.getCurrentEquippedItem();
        if(stack != null) {
            if(stack.getItem() instanceof ModItem) {
                if(stack.getItem().hasEffect(stack)) {
                    ModTileEntity mte = (ModTileEntity) worldIn.getTileEntity(pos);
                    mte.addEntry("Data Item", stack);
                    playerIn.addChatMessage(new ChatComponentText("Added data to tile entity"));
                    stack.stackSize--;

                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public EnumWorldBlockLayer getBlockLayer() {
        return EnumWorldBlockLayer.CUTOUT; // Fully transparent or not (CUTOUT), Applies right amount of transparency (TRANSLUCENT, maybe buggy)
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new ModTileEntity();
    }
}
