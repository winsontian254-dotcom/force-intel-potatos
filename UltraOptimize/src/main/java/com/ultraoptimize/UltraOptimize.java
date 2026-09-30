package com.ultraoptimize;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod("ultraoptimize")
public class UltraOptimize {
    public static final String MODID = "ultraoptimize";
    public static final Logger LOGGER = LoggerFactory.getLogger(MODID);

    public UltraOptimize() {
        LOGGER.info("Initializing UltraOptimize - Combined Optimization Mod");
        LOGGER.info("Features: ModernFix + ImmediatelyFast + CullLessLeaves + Embeddium + Luxium");
    }

    public static void onCommonSetup(FMLCommonSetupEvent event) {
        LOGGER.info("UltraOptimize common setup complete");
    }

    @OnlyIn(Dist.CLIENT)
    public static void onClientSetup(FMLClientSetupEvent event) {
        LOGGER.info("UltraOptimize client setup complete - All optimization features loaded");
    }
}
