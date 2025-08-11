package com.darkduy.gfxtool.config;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Path;

public class ConfigManager {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final String CONFIG_FILE = "config/gfxtool.json";
    public static GfxConfig config = new GfxConfig();
    public static void init() {
        try {
            File f = Path.of(CONFIG_FILE).toFile();
            if (f.exists()) {
                try (FileReader fr = new FileReader(f)) { config = GSON.fromJson(fr, GfxConfig.class); if (config==null) config=new GfxConfig(); }
            } else { save(); }
            System.out.println("[GFXTool] Config loaded: " + f.getAbsolutePath());
        } catch (Exception e) { e.printStackTrace(); }
    }
    public static void save() {
        try {
            File dir = Path.of("config").toFile();
            if (!dir.exists()) dir.mkdirs();
            try (FileWriter fw = new FileWriter(Path.of(CONFIG_FILE).toFile())) { GSON.toJson(config, fw); }
        } catch (Exception e) { e.printStackTrace(); }
    }
}
