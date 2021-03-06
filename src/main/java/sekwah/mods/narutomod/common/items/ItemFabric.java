package sekwah.mods.narutomod.common.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import sekwah.mods.narutomod.NarutoMod;

import java.util.List;

public class ItemFabric extends Item {

    public static final String[] names = new String[]{"base", "reinforced", "reinforcedBlack", "reinforcedRed", "reinforcedBlue"};
    @SideOnly(Side.CLIENT)
    private IIcon[] Icons;

    public ItemFabric() {
        super();
        setHasSubtypes(true);
        this.setMaxDurability(0);
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister par1IconRegister) {
        Icons = new IIcon[5];
        Icons[0] = par1IconRegister.registerIcon(NarutoMod.modid + ":Fabric");
        Icons[1] = par1IconRegister.registerIcon(NarutoMod.modid + ":reinforcedFabricGreen");
        Icons[2] = par1IconRegister.registerIcon(NarutoMod.modid + ":reinforcedFabricBlack");
        Icons[3] = par1IconRegister.registerIcon(NarutoMod.modid + ":reinforcedFabricRed");
        Icons[4] = par1IconRegister.registerIcon(NarutoMod.modid + ":reinforcedFabricBlue");
    }

    @SideOnly(Side.CLIENT)
    public void getSubItems(Item item, CreativeTabs tabs, List list) {
        // You can also take a more direct approach and do each one individual but I prefer the lazy / right way
        for (int i = 0; i < Icons.length; ++i) {
            list.add(new ItemStack(item, 1, i));
        }
    }

    public String getUnlocalizedName(ItemStack par1ItemStack) {
        if (0 < par1ItemStack.getMetadata() && par1ItemStack.getMetadata() < Icons.length) {
            return super.getUnlocalizedName() + "." + names[par1ItemStack.getMetadata()];
        } else {
            return super.getUnlocalizedName();
        }
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int par1) {
        return Icons[par1];
    }

}