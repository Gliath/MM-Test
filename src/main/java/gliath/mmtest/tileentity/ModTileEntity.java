package gliath.mmtest.tileentity;

import gliath.mmtest.ModData;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

import java.util.ArrayList;
import java.util.List;

public class ModTileEntity extends TileEntity {
    private List<ModData> data = new ArrayList<ModData>();

    public void addEntry(String name, ItemStack modData) {
        NBTTagCompound nbt = (NBTTagCompound) modData.getTagCompound().getTag("coords");
        int dim = nbt.getInteger("dim");
        int x = nbt.getInteger("posX");
        int y = nbt.getInteger("posY");
        int z = nbt.getInteger("posZ");
        data.add(new ModData(name, dim, x, y, z));
    }

    public ModData getEntry(int i) {
        if (i < data.size())
            return data.get(i);

        return null;
    }

    public void deleteEntry(int i) {
        if (i < data.size())
            data.remove(i);
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);

        data = new ArrayList<ModData>();

        NBTTagList dataList = (NBTTagList) compound.getTag("moddata");
        for(int i = 0; i < dataList.tagCount(); i++)
            data.add(ModData.readDataFromNBT(dataList.getCompoundTagAt(i)));
    }

    @Override
    public void writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);

        NBTTagList dataList = new NBTTagList();
        for(ModData item : data) {
            NBTTagCompound dataCompound = new NBTTagCompound();
            item.writeDataToNBT(dataCompound);
            dataList.appendTag(dataCompound);
        }

        compound.setTag("moddata", dataList);
    }
}