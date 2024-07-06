package zkamper.romaniansdelight.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import vectorwing.farmersdelight.common.block.FeastBlock;
import zkamper.romaniansdelight.common.ModItems;


public class MamaligaBlock extends FeastBlock {
    public static final String NAME = "mamaliga";
    protected static final VoxelShape PLATE_SHAPE = Block.box(1.0, 0.0, 1.0, 15.0, 2.0, 15.0);
    protected static final VoxelShape PIE_SHAPE;
    public static final IntegerProperty MAMALIGA_SERVINGS = IntegerProperty.create("servings", 0, 6);
    public static final Properties PROPERTIES = Block.Properties.copy(Blocks.CAKE);
    public MamaligaBlock() {
        super(PROPERTIES, ModItems.COOKED_MICI, true);
    }

    public IntegerProperty getServingsProperty() {
        return MAMALIGA_SERVINGS;
    }

    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return (Integer)state.getValue(this.getServingsProperty()) == 0 ? PLATE_SHAPE : PIE_SHAPE;
    }

    public int getMaxServings() {
        return 6;
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, MAMALIGA_SERVINGS);
    }


    static {
        PIE_SHAPE = Shapes.joinUnoptimized(PLATE_SHAPE, Block.box(2.0, 2.0, 2.0, 14.0, 6.0, 14.0), BooleanOp.OR);
    }
}
