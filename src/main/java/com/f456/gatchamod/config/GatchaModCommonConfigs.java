package com.f456.gatchamod.config;

import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class GatchaModCommonConfigs {
    public static final ForgeConfigSpec CONFIG;
    public static final ConfigValues VALUES;

    static {
        final Pair<ConfigValues, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(ConfigValues::new);
        CONFIG = specPair.getRight();
        VALUES = specPair.getLeft();
    }

    public static class ConfigValues {
        public final ForgeConfigSpec.ConfigValue<String> item1;
        public final ForgeConfigSpec.ConfigValue<String> item2;
        public final ForgeConfigSpec.ConfigValue<String> item3;
        public final ForgeConfigSpec.ConfigValue<String> item4;
        public final ForgeConfigSpec.ConfigValue<String> item5;
        public final ForgeConfigSpec.ConfigValue<String> item6;
        public final ForgeConfigSpec.ConfigValue<String> item7;
        public final ForgeConfigSpec.ConfigValue<String> item8;
        public final ForgeConfigSpec.ConfigValue<String> item9;
        public final ForgeConfigSpec.ConfigValue<String> item10;
        public final ForgeConfigSpec.ConfigValue<String> item11;
        public final ForgeConfigSpec.ConfigValue<String> item12;

        ConfigValues(ForgeConfigSpec.Builder builder) {
            builder.push("Custom Gacha Items 20 % of getting nothing ， 有20%的機率不會獲得物品");
            builder.comment("Item 1 to 4 name settings for luckyball lv1, use a proper id for item");
            builder.comment(" 初級扭蛋 更改物品1 -4 的名稱設定 ， 請使用正確的物品名稱 ");
            item1 = builder
                    .comment("10% item, 10% 機率物品 ")
                    .define("item1", "minecraft:name_tag");

            item2 = builder
                    .comment("15% item, 15% 機率物品 ")
                    .define("item2", "minecraft:slime_ball");

            item3 = builder
                    .comment("20% item, 20% 機率物品 ")
                    .define("item3", "minecraft:iron_ingot");

            item4 = builder
                    .comment("35% item, 35% 機率物品 ")
                    .define("item4", "minecraft:coal");

            builder.comment("");
            builder.comment("[luckyball lv2 中級扭蛋 -------------------------------------------------------]");
            builder.comment("");
            item5 = builder
                    .comment("10% item, 10% 機率物品 ")
                    .define("item5", "minecraft:diamond");

            item6 = builder
                    .comment("15% item, 15% 機率物品 ")
                    .define("item6", "minecraft:blaze_powder");

            item7 = builder
                    .comment("20% item, 20%機率物品 ")
                    .define("item7", "minecraft:gold_ingot");

            item8 = builder
                    .comment("35% item, 35% 機率物品 ")
                    .define("item8", "minecraft:leather");

            builder.comment("");
            builder.comment("[luckyball lv3 高級扭蛋 -------------------------------------------------------]");
            builder.comment("");
            item9 = builder
                    .comment("10% item, 10% 機率物品 ")
                    .define("item9", "minecraft:netherite_scrap");

            item10 = builder
                    .comment("15% item, 15% 機率物品 ")
                    .define("item10", "minecraft:ender_pearl");

            item11 = builder
                    .comment("20% item, 20% 機率物品 ")
                    .define("item11", "minecraft:redstone");

            item12 = builder
                    .comment("35% item, 35% 機率物品 ")
                    .define("item12", "minecraft:lapis_lazuli");

            builder.pop();
        }
    }

}
