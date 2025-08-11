package com.darkduy.gfxtool.client;

import com.darkduy.gfxtool.config.ConfigManager;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import org.lwjgl.glfw.GLFW;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;

@Environment(EnvType.CLIENT)
public class GfxToolClient implements ClientModInitializer {
    private static KeyBinding openGuiKey;
    @Override
    public void onInitializeClient() {
        System.out.println("[GFXTool] Client initializing...");
        ConfigManager.init();
        HudRenderCallback.EVENT.register((matrices, tickDelta) -> {
            com.darkduy.gfxtool.overlay.OverlayRenderer.render(matrices, tickDelta);
        });
        openGuiKey = KeyBindingHelper.registerKeyBinding(new KeyBinding("key.gfxtool.opengui", GLFW.GLFW_KEY_G, "category.gfxtool.controls"));
    }
    public static void openGui() {
        MinecraftClient client = MinecraftClient.getInstance();
        if (client != null) client.execute(() -> client.setScreen(new com.darkduy.gfxtool.ui.GfxScreen()));
    }
}
