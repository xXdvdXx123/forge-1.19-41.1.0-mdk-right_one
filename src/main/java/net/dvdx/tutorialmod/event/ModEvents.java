package net.dvdx.tutorialmod.event;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.dvdx.tutorialmod.TutorialMod;
import net.dvdx.tutorialmod.item.ModItems;
import net.dvdx.tutorialmod.villager.ModVillagers;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = TutorialMod.MOD_ID)
public class ModEvents {
    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {
        if(event.getType() == VillagerProfession.TOOLSMITH) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            // trades \/
            ItemStack stack = new ItemStack(ModItems.EIGHT_BALL.get(), 1);
            int villagerlevel = 1;

            trades.get(villagerlevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 2),
                    stack, 10, 8, 0.02f));
        }
        if(event.getType() == ModVillagers.JUMPY_MASTER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            // trades \/
            ItemStack stack = new ItemStack(ModItems.BLUEBERRY.get(), 15);
            int villagerlevel = 1;

            trades.get(villagerlevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 5),
                    stack, 10, 8, 0.02f)); // 10 are max uses, 8 are the xp reward and 0.02f is the price multiplier
        }
    }
}
