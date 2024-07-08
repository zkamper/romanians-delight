package zkamper.romaniansdelight.common.item;

import net.minecraft.world.item.Item;
import zkamper.romaniansdelight.registry.ModCreativeTab;

public class CornFlourItem extends Item {
    public static final String NAME = "corn_flour";
    public static final Properties PROPERTIES = new Item.Properties().tab(ModCreativeTab.MOD_TAB);
    public CornFlourItem() {
        super(PROPERTIES);
    }
}
