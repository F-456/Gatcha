package com.f456.gatchamod.item;

import com.f456.gatchamod.Gatcha;
import com.f456.gatchamod.item.custom.Luckyball_Item1;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Moditems {
    public static final DeferredRegister <Item>
            ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Gatcha.MOD_ID);

    //importing luckyball item function from the custom packages
    public static final RegistryObject<Item> LUCKYBALL = ITEMS.register("luckyball",
        ()-> new Luckyball_Item1(new Item.Properties()));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
