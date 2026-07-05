package zkamper.romaniansdelight.common.block;

import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import zkamper.romaniansdelight.registry.ModItems;

public class GarlicCropBlock extends CropBlock {
    public static final String NAME = "garlic";

    public static final Properties PROPERTIES = Properties.ofFullCopy(Blocks.WHEAT);

    public GarlicCropBlock() {
        super(PROPERTIES);
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return ModItems.GARLIC.get();
    }
}
