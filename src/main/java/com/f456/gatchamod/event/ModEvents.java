package com.f456.gatchamod.event;

import com.f456.gatchamod.Gatcha;
import com.f456.gatchamod.item.Moditems;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = Gatcha.MOD_ID)

public class ModEvents {
    @SubscribeEvent
    public static void addCustomTrade(VillagerTradesEvent event){

        //Level 2 librarian to trade lucky ball
        if (event.getType()== VillagerProfession.LIBRARIAN){
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            trades.get(2).add((pTrader,pRandom)-> new MerchantOffer(
                    new ItemStack(Items.EMERALD,1),
                    new ItemStack(Moditems.LUCKYBALL.get(),1),
                    12,6,0.02f));

        }

    }
}
