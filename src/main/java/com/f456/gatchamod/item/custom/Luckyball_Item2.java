package com.f456.gatchamod.item.custom;

import com.f456.gatchamod.config.GatchaModCommonConfigs;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class Luckyball_Item2 extends Item {

    public Luckyball_Item2(Properties pProperties) {
        super(pProperties);
    }

    @Override
    // if right click is used on the item
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        if (!world.isClientSide){

            // Play the sound effect
            world.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.EXPERIENCE_ORB_PICKUP, SoundSource.PLAYERS, 1.0F, 1.0F);

            //getting item from the mod config
            String item5Name = GatchaModCommonConfigs.VALUES.item5.get();
            String item6Name = GatchaModCommonConfigs.VALUES.item6.get();
            String item7Name = GatchaModCommonConfigs.VALUES.item7.get();
            String item8Name = GatchaModCommonConfigs.VALUES.item8.get();

            //converting string from config into usable item objects
            Item item5 = BuiltInRegistries.ITEM.get(new ResourceLocation(item5Name));
            Item item6 = BuiltInRegistries.ITEM.get(new ResourceLocation(item6Name));
            Item item7 = BuiltInRegistries.ITEM.get(new ResourceLocation(item7Name));
            Item item8 = BuiltInRegistries.ITEM.get(new ResourceLocation(item8Name));

            Item[]possibleitems = new Item []{
                    item5,item6,item7,item8
            };

            Item randomItem = null;


        //randomize the item list
        //choosing a integer between 0 and 100
        int choosen_int = (int)(Math.random()*101);
            // Consume the item used
            ItemStack itemInHand = player.getItemInHand(hand);
            itemInHand.shrink(1); // Reduce the item count by 1

            // If the item count is 0, set it to air (remove it)
            if (itemInHand.isEmpty()) {
                player.setItemInHand(hand, ItemStack.EMPTY);
            }
        // deciding the probability of getting the grades of prizes
        if (choosen_int < 20){
            player.sendSystemMessage(Component.translatable("message.gatchamod.winnothing"));
            }
            //lowest rank of reward 35% probability
            else if (choosen_int<55 ) {
                randomItem = possibleitems[3];
            }
            //third rank of reward  20% probability
            else if(choosen_int<75) {
                randomItem = possibleitems[2];
            }
            //second rank of reward  15% probability
            else if(choosen_int<90) {
                randomItem = possibleitems[1];
            } else {
                // left highest reward 10% probability
                randomItem = possibleitems[0];
            }

            //Giving player award if randomItem is not null
            if (randomItem!= null ){
                ItemStack rewardStack = new ItemStack(randomItem,1);
                String Itemname = randomItem.getDescription().getString();
                player.sendSystemMessage(Component.translatable("message.gatchamod.won_prize",Itemname));
                if (!player.addItem(rewardStack)){
                    //dropping the item if the player inventory is full
                    player.drop(rewardStack,false);
                }
            }
        }


        return InteractionResultHolder.sidedSuccess(player.getItemInHand(hand), world.isClientSide());
    }
}
