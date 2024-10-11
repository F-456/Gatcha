package com.f456.gatchamod.item.custom;

import com.f456.gatchamod.config.GatchaModCommonConfigs;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import java.util.Random;

public class Luckyball_Item1 extends Item {

    public Luckyball_Item1(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        if (!world.isClientSide){

            //getting item from the mod config
            String item1Name = GatchaModCommonConfigs.VALUES.item1.get();
            String item2Name = GatchaModCommonConfigs.VALUES.item2.get();
            String item3Name = GatchaModCommonConfigs.VALUES.item3.get();
            String item4Name = GatchaModCommonConfigs.VALUES.item4.get();

            //converting string from config into usable item objects
            Item item1 = BuiltInRegistries.ITEM.get(new ResourceLocation(item1Name));
            Item item2 = BuiltInRegistries.ITEM.get(new ResourceLocation(item2Name));
            Item item3 = BuiltInRegistries.ITEM.get(new ResourceLocation(item3Name));
            Item item4 = BuiltInRegistries.ITEM.get(new ResourceLocation(item4Name));

            Item[]possibleitems = new Item []{
                    item1,item2,item3,item4
            };
        //randomize the item list
            // creating instance for random class
        Random rand = new Random();
        int randoming_limit = possibleitems.length+1;
        int choosen_int = rand.nextInt(randoming_limit);
            // Consume the item used
            ItemStack itemInHand = player.getItemInHand(hand);
            itemInHand.shrink(1); // Reduce the item count by 1

            // If the item count is 0, set it to air (remove it)
            if (itemInHand.isEmpty()) {
                player.setItemInHand(hand, ItemStack.EMPTY);
            }

        if (choosen_int == possibleitems.length){
            player.sendSystemMessage(Component.translatable("message.gatchamod.winnothing"));
            }
        else{
            //using next int for randomize number between a range
            Item randomItem = possibleitems[choosen_int];
            //Giving player award
            ItemStack rewardStack = new ItemStack(randomItem,1);
            String Itemname = randomItem.getDescription().getString();
            player.sendSystemMessage(Component.translatable("message.gatchamod.won_prize",Itemname));
            if (!player.addItem(rewardStack)){
                //dropping the item if the player inventory is full
                player.drop(rewardStack,false);
            }


        };
        }


        return InteractionResultHolder.sidedSuccess(player.getItemInHand(hand), world.isClientSide());
    }
}
