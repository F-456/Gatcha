package com.f456.gatchamod.item;

import com.f456.gatchamod.Gatcha;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class GatchaTab {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Gatcha.MOD_ID);

    public static final RegistryObject<CreativeModeTab> GATCHA_TAB = CREATIVE_MODE_TABS.register("gatcha_tab",

            ()-> CreativeModeTab.builder().icon(()->new ItemStack(Moditems.LUCKYBALL_LOGO.get()))
                    .title(Component.translatable("creativetab.gatcha_tab"))
                    .displayItems((pParameters, pOutput) ->{
                        pOutput.accept(Moditems.LUCKYBALL.get());
                        pOutput.accept(Moditems.LUCKYBALL2.get());
                        pOutput.accept(Moditems.LUCKYBALL3.get());
                    } )
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
