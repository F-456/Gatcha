package com.f456.gatchamod.item;

import com.f456.gatchamod.Gatcha;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Moditems {
    public static final DeferredRegister <Item>
            ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Gatcha.MOD_ID);

    public static final RegistryObject<Item> LUCKYBALL = ITEMS.register("luckyball",
        ()-> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
