package zkamper.romaniansdelight.common.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.world.level.block.Block;
import vectorwing.farmersdelight.common.registry.ModBlocks;

public class GarlicCrateBlock extends Block {
    public static final MapCodec<GarlicCrateBlock> CODEC = simpleCodec(p -> new GarlicCrateBlock());

    public static final String NAME = "garlic_crate";

    public static final Properties PROPERTIES = Properties.ofFullCopy(ModBlocks.ONION_CRATE.get());

    public GarlicCrateBlock() {
        super(PROPERTIES);
    }

    @Override
    public MapCodec<GarlicCrateBlock> codec() {
        return CODEC;
    }
}
