package com.darkduy.gfxtool.overlay;
import com.darkduy.gfxtool.config.ConfigManager;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
public class OverlayRenderer {
    private static long lastTime = System.nanoTime();
    private static double fps = 0.0;
    public static void render(Object matrices, float tickDelta) {
        long now = System.nanoTime();
        double frameTime = (now - lastTime) / 1_000_000.0;
        lastTime = now;
        if (frameTime > 0) fps = 1000.0 / frameTime;
        MinecraftClient client = MinecraftClient.getInstance();
        if (client == null || client.player == null) return;
        TextRenderer tr = client.textRenderer;
        String s = String.format("GFXTool - FPS: %.0f | RD: %d | Preset: %s", fps, ConfigManager.config.renderDistance, ConfigManager.config.preset);
        tr.drawWithShadow(s, 10, 10, 0xFFFFFF);
    }
}
