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
            builder.push("Custom Gacha Items 10 % of getting nothing ");
            builder.comment("Item 1 to 4 name settings for luckyball common, use a proper id for item");
            builder.comment(" Be cautious, item probability is non editable");
            item1 = builder
                    .comment("5% item")
                    .define("item1", "minecraft:name_tag");

            item2 = builder
                    .comment("10% item")
                    .define("item2", "minecraft:slime_ball");

            item3 = builder
                    .comment("30% item")
                    .define("item3", "minecraft:iron_ingot");

            item4 = builder
                    .comment("45% item")
                    .define("item4", "minecraft:coal");

            builder.comment("");
            builder.comment("[luckyball rare  -------------------------------------------------------]");
            builder.comment("");
            item5 = builder
                    .comment("5% item")
                    .define("item5", "minecraft:diamond");

            item6 = builder
                    .comment("10% item")
                    .define("item6", "minecraft:blaze_powder");

            item7 = builder
                    .comment("30% item")
                    .define("item7", "minecraft:gold_ingot");

            item8 = builder
                    .comment("45% item")
                    .define("item8", "minecraft:leather");

            builder.comment("");
            builder.comment("[luckyball legendary  -------------------------------------------------------]");
            builder.comment("");
            item9 = builder
                    .comment("5% item")
                    .define("item9", "minecraft:netherite_scrap");

            item10 = builder
                    .comment("10% item")
                    .define("item10", "minecraft:ender_pearl");

            item11 = builder
                    .comment("30% item")
                    .define("item11", "minecraft:redstone");

            item12 = builder
                    .comment("45% item")
                    .define("item12", "minecraft:lapis_lazuli");

            builder.pop();
        }
    }

}
