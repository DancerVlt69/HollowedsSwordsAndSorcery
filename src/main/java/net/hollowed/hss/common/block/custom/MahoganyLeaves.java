package net.hollowed.hss.common.block.custom;

import net.hollowed.hss.common.block.ModBlocks;
import net.minecraft.core.Direction;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.core.BlockPos;
import org.jetbrains.annotations.NotNull;

public class MahoganyLeaves extends LeavesBlock {
    private final boolean isFlammable;
    private final int flammability;
    private final int fireSpreadSpeed;

    public MahoganyLeaves(boolean isFlammable, int flammability, int fireSpreadSpeed) {
        super(BlockBehaviour.Properties.of(Material.LEAVES).strength(0.2F, 0.2f)
                .randomTicks().sound(SoundType.GRASS).noOcclusion());
        this.isFlammable = isFlammable;
        this.flammability = flammability;
        this.fireSpreadSpeed = fireSpreadSpeed;
    }

    @Override
    public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return isFlammable;
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return flammability;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return fireSpreadSpeed;
    }

    @Override
    public int getLightBlock(@NotNull BlockState state, @NotNull BlockGetter worldIn, @NotNull BlockPos pos) {
        return 15;
    }


    @OnlyIn(Dist.CLIENT)
    public static void blockColorLoad(RegisterColorHandlersEvent.Block event) {
        event.getBlockColors().register((bs, world, pos, index) -> FoliageColor.getDefaultColor(),
                ModBlocks.MAHOGANY_LEAVES.get());
    }

    @OnlyIn(Dist.CLIENT)
    public static void itemColorLoad(RegisterColorHandlersEvent.Item event) {
        event.getItemColors().register((stack, index) -> FoliageColor.getDefaultColor(),
                ModBlocks.MAHOGANY_LEAVES.get());
    }
}
