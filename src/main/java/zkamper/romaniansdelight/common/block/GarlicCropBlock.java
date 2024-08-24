package zkamper.romaniansdelight.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;
import zkamper.romaniansdelight.registry.ModBlocks;
import zkamper.romaniansdelight.registry.ModItems;

public class GarlicCropBlock extends CropBlock {
    public static final String NAME = "garlic";
    private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{Block.box(0.0, 0.0, 0.0, 16.0, 2.0, 16.0), Block.box(0.0, 0.0, 0.0, 16.0, 3.0, 16.0), Block.box(0.0, 0.0, 0.0, 16.0, 4.0, 16.0), Block.box(0.0, 0.0, 0.0, 16.0, 5.0, 16.0), Block.box(0.0, 0.0, 0.0, 16.0, 6.0, 16.0), Block.box(0.0, 0.0, 0.0, 16.0, 7.0, 16.0), Block.box(0.0, 0.0, 0.0, 16.0, 8.0, 16.0), Block.box(0.0, 0.0, 0.0, 16.0, 9.0, 16.0)};

    public static final Properties PROPERTIES = Properties.copy(Blocks.WHEAT);
    public GarlicCropBlock() {
        super(PROPERTIES);
    }

    @Override
    public BlockState getPlant(BlockGetter world, BlockPos pos) {
        return ModBlocks.GARLIC_CROP.get().defaultBlockState();
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return ModItems.GARLIC.get();
    }
}
