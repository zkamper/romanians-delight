package zkamper.romaniansdelight.common.block.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.CampfireBlock;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import zkamper.romaniansdelight.common.block.entity.GrillBlockEntity;

@OnlyIn(Dist.CLIENT)
public class GrillRenderer implements BlockEntityRenderer<GrillBlockEntity> {
    private static final float SIZE = 0.25F;
    private final ItemRenderer itemRenderer;
    public GrillRenderer(BlockEntityRendererProvider.Context context) {
        this.itemRenderer = context.getItemRenderer();
    }
    @Override
    public void render(GrillBlockEntity grillBlockEntity, float v, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, int i1) {
        Direction dir = grillBlockEntity.getBlockState().getValue(CampfireBlock.FACING);
        NonNullList<ItemStack> items = grillBlockEntity.getItems();
        int pos = (int)grillBlockEntity.getBlockPos().asLong();
        for(int idx = 0; idx < items.size(); ++idx) {
            ItemStack item = items.get(idx);
            if (item != ItemStack.EMPTY) {
                poseStack.pushPose();
                poseStack.translate(0.5, 1.1, 0.5);
                Direction direction = Direction.from2DDataValue((idx + dir.get2DDataValue()) % 4);
                float angle = -direction.toYRot();
                poseStack.mulPose(Vector3f.YP.rotationDegrees(angle));
                poseStack.mulPose(Vector3f.XP.rotationDegrees(90.0F));
                poseStack.translate(-0.25, -0.25, 0.0);
                poseStack.scale(SIZE, SIZE, SIZE);
                this.itemRenderer.renderStatic(item, ItemTransforms.TransformType.FIXED, i, i1, poseStack, multiBufferSource, pos + idx);
                poseStack.popPose();
            }
        }
    }
}
