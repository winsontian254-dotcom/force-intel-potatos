# UltraOptimize Fabric Porting Guide

## Overview

This document explains the architecture and porting strategy for converting the UltraOptimize mod from Forge to Fabric 1.20.1.

## Key Differences: Forge vs Fabric

### Modloader Architecture
| Feature | Forge | Fabric |
|---------|-------|--------|
| Entry Point | @Mod class | ModInitializer interface |
| Client Setup | FMLClientSetupEvent | ClientModInitializer interface |
| Metadata | mods.toml | fabric.mod.json |
| Mixin System | Built-in | Via Mixin library |
| Access Widening | Annotation-based | Access widener files |
| Registry | ForgeRegistry | Fabric Registry |
| Events | MinecraftForge.EVENT_BUS | Fabric Event Callbacks |

### Module Organization

**Fabric Structure**:
```
src/main/java/com/ultraoptimize/fabric/
├── UltraOptimizeFabric.java       # Main (ModInitializer)
├── client/
│   └── UltraOptimizeClient.java   # Client (ClientModInitializer)
├── mixin/                          # Fabric mixins
├── config/                         # Configuration
└── util/                           # Utilities
```

## Porting Strategy

### 1. Entry Points

**Forge** (old):
```java
@Mod("ultraoptimize")
public class UltraOptimize {
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientHandler {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) { }
    }
}
```

**Fabric** (new):
```java
@Override
public void onInitialize() {
    // Common initialization
}

// Separate client class
public class UltraOptimizeClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // Client-side initialization
    }
}
```

### 2. Event Handling

**Forge**:
```java
@SubscribeEvent
public static void onRenderTick(TickEvent.RenderTickEvent event) { }

@SubscribeEvent
public static void onClientTick(TickEvent.ClientTickEvent event) { }
```

**Fabric**:
```java
// Use Fabric API callbacks
ServerTickEvents.START_SERVER_TICK.register(server -> { });
ClientTickEvents.START_CLIENT_TICK.register(client -> { });
ClientTickEvents.END_CLIENT_TICK.register(client -> { });
```

### 3. Mixins

**Forge** (ModernFix style):
```json
{
  "package": "org.embeddedt.modernfix.forge.mixins",
  "refmap": "modernfix.refmap.json",
  "mixins": ["MixinChunkRenderDispatcher"]
}
```

**Fabric**:
```json
{
  "required": true,
  "minVersion": "0.8",
  "package": "com.ultraoptimize.fabric.mixin",
  "compatibilityLevel": "JAVA_17",
  "client": ["MixinChunkRenderDispatcher"],
  "injectors": {
    "defaultRequire": 1
  }
}
```

### 4. Configuration

**Forge** (mods.toml):
```toml
[[dependencies.ultraoptimize]]
modId = "minecraft"
mandatory = true
versionRange = "[1.20,1.21)"
```

**Fabric** (fabric.mod.json):
```json
{
  "depends": {
    "fabricloader": ">=0.15.7",
    "minecraft": "1.20.1"
  }
}
```

## Porting Checklist

### Phase 1: Project Setup ✅
- [x] Create Fabric project structure
- [x] Configure gradle.properties
- [x] Set up build.gradle.kts
- [x] Create fabric.mod.json
- [x] Create access widener file

### Phase 2: Core Classes ✅
- [x] Port UltraOptimizeFabric (main entry point)
- [x] Port UltraOptimizeClient (client setup)
- [x] Create OptimizationConfig
- [x] Create ModuleManager

### Phase 3: Mixins ⏳
- [ ] Port ModernFix mixins
- [ ] Port ImmediatelyFast mixins
- [ ] Port CullLessLeaves mixins
- [ ] Port Embeddium mixins
- [ ] Port Luxium mixins

### Phase 4: Events ⏳
- [ ] Implement Fabric event listeners
- [ ] Port tick events
- [ ] Port rendering events

### Phase 5: Testing ⏳
- [ ] Build verification
- [ ] Load testing
- [ ] Performance testing
- [ ] Compatibility testing

## Mixin Porting Template

When porting mixins from Forge to Fabric:

```java
// Fabric mixin example
@Mixin(ChunkRenderDispatcher.class)
public abstract class MixinChunkRenderDispatcher {
    @Inject(
        method = "rebuildChunkSync",
        at = @At("HEAD"),
        cancellable = true
    )
    private void optimizeChunkSync(ChunkRenderDispatcher.RenderChunk chunk, CallbackInfo ci) {
        // Optimization logic here
    }
}
```

## Build Process

### Building
```bash
cd UltraOptimize-Fabric
./gradlew build
```

### Output
- `build/libs/ultraoptimize-1.0.0.jar` - The mod JAR
- `build/libs/ultraoptimize-1.0.0-sources.jar` - Source code

## Dependency Comparison

### Forge Dependencies
- NeoForged/Forge API
- Minecraft Forge mappings
- Mixin (0.8+)

### Fabric Dependencies
- Fabric Loader 0.15.7+
- Fabric API 0.92.2+
- Fabric Language Kotlin (if needed)
- Mixin Extras (for enhanced mixin support)

## Performance Characteristics

### Fabric Advantages
- Lower memory overhead
- Faster startup times
- More modular dependency system
- Better mod compatibility out-of-box

### Considerations
- Some optimization techniques may differ
- Mixin approach is slightly different
- Event system uses callbacks instead of bus

## Known Compatibility Issues

### Sodium vs Embeddium
- Both can be installed, but Embeddium is preferred
- Ensure proper ordering in mods folder

### Shader Packs
- Iris shaders work well with Fabric
- OptiFine shaders have mixed compatibility

## Testing Recommendations

1. **Build Test**: Verify JAR creates successfully
2. **Load Test**: Test mod loads in Minecraft launcher
3. **Feature Test**: Verify all optimizations activate
4. **Performance Test**: Compare FPS before/after
5. **Compatibility Test**: Test with popular mods

## Next Steps

1. **Complete mixin porting** from Forge mixins
2. **Implement Fabric events** for tick/render hooks
3. **Test with Fabric 1.20.1**
4. **Create Modrinth release**
5. **Document Fabric-specific features**

## References

- [Fabric Wiki](https://fabricmc.net/wiki/)
- [Mixin Documentation](https://github.com/SpongePowered/Mixin/wiki)
- [Access Widener](https://fabricmc.net/wiki/documentation:public_jumps)
- [Fabric API](https://github.com/FabricMC/fabric)

---

**Porting Status**: In Progress 🔄
**Last Updated**: 2026-10-01
**Target Completion**: Mixin porting phase
