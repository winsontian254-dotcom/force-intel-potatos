package com.ultraoptimize.feature;

import com.ultraoptimize.UltraOptimize;
import java.util.ArrayList;
import java.util.List;

/**
 * Manages all optimization features from combined mods.
 * Provides centralized enable/disable control for each module.
 */
public class ModuleManager {
    private static final List<OptimizationModule> modules = new ArrayList<>();

    public static void registerModules() {
        modules.clear();

        // Register ModernFix features
        modules.add(new OptimizationModule("ModernFix", true,
            "Structure caching, rendering optimizations, memory management"));

        // Register ImmediatelyFast features
        modules.add(new OptimizationModule("ImmediatelyFast", true,
            "Immediate mode rendering, sign text buffering, batch updates"));

        // Register CullLessLeaves features
        modules.add(new OptimizationModule("CullLessLeaves", true,
            "Smart leaf culling, block occlusion, rendering optimization"));

        // Register Embeddium features
        modules.add(new OptimizationModule("Embeddium", true,
            "Chunk rendering, graphics pipeline, performance optimization"));

        // Register Luxium features
        modules.add(new OptimizationModule("Luxium", true,
            "Graphics enhancements, shadows, dynamic lighting, post-processing"));

        UltraOptimize.LOGGER.info("Registered {} optimization modules", modules.size());
    }

    public static void enableAllModules() {
        for (OptimizationModule module : modules) {
            module.enable();
        }
        UltraOptimize.LOGGER.info("All optimization modules enabled");
    }

    public static void disableAllModules() {
        for (OptimizationModule module : modules) {
            module.disable();
        }
        UltraOptimize.LOGGER.info("All optimization modules disabled");
    }

    public static void enableModule(String name) {
        for (OptimizationModule module : modules) {
            if (module.getName().equalsIgnoreCase(name)) {
                module.enable();
                UltraOptimize.LOGGER.info("Enabled module: {}", name);
                return;
            }
        }
        UltraOptimize.LOGGER.warn("Module not found: {}", name);
    }

    public static void disableModule(String name) {
        for (OptimizationModule module : modules) {
            if (module.getName().equalsIgnoreCase(name)) {
                module.disable();
                UltraOptimize.LOGGER.info("Disabled module: {}", name);
                return;
            }
        }
        UltraOptimize.LOGGER.warn("Module not found: {}", name);
    }

    public static List<OptimizationModule> getModules() {
        return new ArrayList<>(modules);
    }

    public static boolean isModuleEnabled(String name) {
        for (OptimizationModule module : modules) {
            if (module.getName().equalsIgnoreCase(name)) {
                return module.isEnabled();
            }
        }
        return false;
    }

    public static class OptimizationModule {
        private final String name;
        private final String description;
        private boolean enabled;

        public OptimizationModule(String name, boolean defaultEnabled, String description) {
            this.name = name;
            this.enabled = defaultEnabled;
            this.description = description;
        }

        public void enable() {
            this.enabled = true;
        }

        public void disable() {
            this.enabled = false;
        }

        public boolean isEnabled() {
            return enabled;
        }

        public String getName() {
            return name;
        }

        public String getDescription() {
            return description;
        }

        @Override
        public String toString() {
            return String.format("%s [%s]: %s", name, enabled ? "ENABLED" : "DISABLED", description);
        }
    }
}
