package zkamper.romaniansdelight.common.block;

import net.minecraft.world.level.block.Block;
import vectorwing.farmersdelight.common.registry.ModBlocks;

public class GarlicCrateBlock extends Block {
    public static final String NAME = "garlic_crate";

    public static final Properties PROPERTIES = Properties.copy(ModBlocks.ONION_CRATE.get());
    public GarlicCrateBlock() {
        super(PROPERTIES);
    }
}
