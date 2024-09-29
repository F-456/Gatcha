package com.f456.gatchamod.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import java.util.Random;

public class LuckyballItem extends Item {

    public LuckyballItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        if (!world.isClientSide){
            Item[]possibleitems = new Item []{
                    Items.GOLD_INGOT,
                    Items.SLIME_BLOCK,
                    Items.IRON_INGOT,
            };
        //randomize the item list
            // creating instance for random class
        Random rand = new Random();
        int randoming_limit = possibleitems.length+1;
        int choosen_int = rand.nextInt(randoming_limit);

        if (choosen_int == possibleitems.length){
            player.sendSystemMessage(Component.literal("Unlucky! No item is drawed"));
            }
        else{
            //using next int for randomize number between a range
            Item randomItem = possibleitems[choosen_int];
            //Giving player award
            ItemStack rewardStack = new ItemStack(randomItem,1);
            String Itemname = randomItem.getDescription().getString();
            player.sendSystemMessage(Component.literal("Congrat! You have won a "+Itemname));
            if (!player.addItem(rewardStack)){
                //dropping the item if the player inventory is full
                player.drop(rewardStack,false);
            }

        };
        }


        return InteractionResultHolder.sidedSuccess(player.getItemInHand(hand), world.isClientSide());
    }
}
