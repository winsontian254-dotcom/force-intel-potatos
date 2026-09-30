package com.ultraoptimize.config;

/**
 * Central configuration for all UltraOptimize features.
 * Combines optimizations from: ModernFix, ImmediatelyFast, CullLessLeaves, Embeddium, Luxium
 */
public class OptimizationConfig {

    // ============= ModernFix Features =============
    public static class ModernFixConfig {
        public static boolean enableStructureCaching = true;
        public static boolean enableRenderingOptimizations = true;
        public static boolean enableMemoryOptimizations = true;
    }

    // ============= ImmediatelyFast Features =============
    public static class ImmediatelyFastConfig {
        public static boolean enableImmediateModeOptimization = true;
        public static boolean enableSignTextBuffering = true;
        public static boolean enableBatchedItemUpdates = true;
        public static boolean enableMapAtlasGeneration = true;
    }

    // ============= CullLessLeaves Features =============
    public static class CullLeavesConfig {
        public static boolean enableLeafCulling = true;
        public static boolean enableSmartCulling = true;
        public static float cullDistance = 32.0f;
    }

    // ============= Embeddium Features =============
    public static class EmbeddiumConfig {
        public static boolean enableClientOptimizations = true;
        public static boolean enableRenderingPipeline = true;
        public static boolean enableChunkRendering = true;
    }

    // ============= Luxium Features =============
    public static class LuxiumConfig {
        public static boolean enableGraphicsEnhancements = true;
        public static boolean enableShadows = true;
        public static boolean enableDynamicLighting = true;
    }

    public static void load() {
        // Load all configurations from files
        ModernFixConfig.enableStructureCaching = true;
        ImmediatelyFastConfig.enableImmediateModeOptimization = true;
        CullLeavesConfig.enableLeafCulling = true;
        EmbeddiumConfig.enableClientOptimizations = true;
        LuxiumConfig.enableGraphicsEnhancements = true;
    }

    public static void save() {
        // Save all configurations to files
    }
}
