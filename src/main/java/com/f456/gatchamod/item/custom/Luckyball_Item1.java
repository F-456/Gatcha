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

public class Luckyball_Item1 extends Item {

    public Luckyball_Item1(Properties pProperties) {
        super(pProperties);
    }

    @Override
    // if right click is used on the item
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        if (!world.isClientSide){

            // Play the sound effect
            world.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.EXPERIENCE_ORB_PICKUP, SoundSource.PLAYERS, 1.0F, 1.0F);

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
            // 10% of getting nothing
            if (choosen_int < 10){
                player.sendSystemMessage(Component.translatable("message.gatchamod.winnothing"));
            }
            //lowest rank of reward 45% probability
            else if (choosen_int<55 ) {
                randomItem = possibleitems[3];
            }
            //third rank of reward  30% probability
            else if(choosen_int<85) {
                randomItem = possibleitems[2];
            }
            //second rank of reward  10% probability
            else if(choosen_int<95) {
                randomItem = possibleitems[1];
            } else {
                // highest reward 5% probability
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
