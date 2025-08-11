package com.darkduy.gfxtool.ui;
import com.darkduy.gfxtool.config.ConfigManager;
import com.darkduy.gfxtool.config.GfxConfig;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import net.minecraft.client.gui.widget.ButtonWidget;
public class GfxScreen extends Screen {
    protected GfxScreen() { super(Text.of("GFX Tool")); }
    @Override protected void init() {
        super.init();
        int w = this.width; int h = this.height;
        addDrawableChild(ButtonWidget.builder(Text.of("Apply Low"), (btn) -> { applyPreset("low"); }).dimensions(w/2 - 100, h/2 - 30, 200, 20).build());
        addDrawableChild(ButtonWidget.builder(Text.of("Apply Medium"), (btn) -> { applyPreset("medium"); }).dimensions(w/2 - 100, h/2, 200, 20).build());
        addDrawableChild(ButtonWidget.builder(Text.of("Apply High"), (btn) -> { applyPreset("high"); }).dimensions(w/2 - 100, h/2 + 30, 200, 20).build());
        addDrawableChild(ButtonWidget.builder(Text.of("Close"), (btn) -> { onClose(); }).dimensions(w/2 - 100, h/2 + 70, 200, 20).build());
    }
    private void applyPreset(String name) {
        GfxConfig cfg = ConfigManager.config;
        switch (name) {
            case "low": cfg.preset="low"; cfg.renderDistance=6; cfg.fancyGraphics=false; cfg.smoothLighting=false; cfg.vsync=false; cfg.aa="off"; cfg.textureQuality="low"; break;
            case "medium": cfg.preset="medium"; cfg.renderDistance=12; cfg.fancyGraphics=true; cfg.smoothLighting=true; cfg.vsync=true; cfg.aa="2x"; cfg.textureQuality="medium"; break;
            case "high": cfg.preset="high"; cfg.renderDistance=24; cfg.fancyGraphics=true; cfg.smoothLighting=true; cfg.vsync=true; cfg.aa="4x"; cfg.textureQuality="high"; break;
        }
        ConfigManager.save();
        if (this.client != null && this.client.player != null) this.client.player.sendMessage(Text.of("GFXTool: Preset '" + name + "' saved to config. Apply changes in Video Settings or restart world."), false);
    }
    @Override public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) { this.renderBackground(matrices); super.render(matrices, mouseX, mouseY, delta); }
}
