package net.dvdx.tutorialmod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;

public class ZirconLampBlock extends Block {
    public static final BooleanProperty LIT = BooleanProperty.create("lit");



    public ZirconLampBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(LIT);
    }

    @Override
    public InteractionResult use(BlockState blockState, Level level, BlockPos blockPos, Player player,
                                 InteractionHand interactionHand, BlockHitResult blockHitResult) {

        if (!level.isClientSide() && interactionHand == InteractionHand.MAIN_HAND && player.getMainHandItem().isEmpty()) {
            level.setBlock(blockPos, blockState.cycle(LIT), 3);
        }

        return super.use(blockState, level, blockPos, player, interactionHand, blockHitResult);
    }
}
