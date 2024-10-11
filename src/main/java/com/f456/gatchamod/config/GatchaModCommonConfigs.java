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

        ConfigValues(ForgeConfigSpec.Builder builder) {
            builder.push("Custom Gacha Items");

            item1 = builder
                    .comment("The first item to be available in the gacha.")
                    .define("item1", "minecraft:iron_ingot");

            item2 = builder
                    .comment("The second item to be available in the gacha.")
                    .define("item2", "minecraft:slime_ball");

            item3 = builder
                    .comment("The third item to be available in the gacha.")
                    .define("item3", "minecraft:name_tag");

            item4 = builder
                    .comment("The third item to be available in the gacha.")
                    .define("item4", "minecraft:coal");

            builder.pop();
        }
    }

}
