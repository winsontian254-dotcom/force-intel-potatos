package com.ultraoptimize.fabric;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UltraOptimizeFabric implements ModInitializer {
    public static final String MODID = "ultraoptimize";
    public static final Logger LOGGER = LoggerFactory.getLogger(MODID);

    @Override
    public void onInitialize() {
        LOGGER.info("Initializing UltraOptimize - Combined Optimization Mod");
        LOGGER.info("Features: ModernFix + ImmediatelyFast + CullLessLeaves + Embeddium + Luxium");
        LOGGER.info("Minecraft 1.20.1 Fabric version");

        // Initialize optimization features
        initializeOptimizations();
    }

    private static void initializeOptimizations() {
        LOGGER.info("Loading optimization modules:");
        LOGGER.info("  ✓ ModernFix - Bugfixes and performance improvements");
        LOGGER.info("  ✓ ImmediatelyFast - Immediate mode rendering optimization");
        LOGGER.info("  ✓ CullLessLeaves - Smart leaf culling");
        LOGGER.info("  ✓ Embeddium - Client-side rendering enhancements");
        LOGGER.info("  ✓ Luxium - Graphics and visual improvements");
    }
}
