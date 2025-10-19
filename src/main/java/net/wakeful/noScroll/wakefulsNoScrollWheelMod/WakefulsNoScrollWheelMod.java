package net.wakeful.noScroll.wakefulsNoScrollWheelMod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class WakefulsNoScrollWheelMod implements ModInitializer {
    public static final Logger LOGGER = LogManager.getLogger("wakefuls-no-scroll-wheel-mod");

    public static WakefulsNoScrollWheelModConfig config;

    public static volatile boolean disableScroll = true;

    public static Path configFile = FabricLoader.getInstance().getConfigDir().resolve("wakefuls-no-scroll-wheel-mod.txt");

    public static final boolean speedrunapi = FabricLoader.getInstance().isModLoaded("speedrunapi");

    @Override
    public void onInitialize() {
        LOGGER.info("Initializing wakefuls-no-scroll-wheel-mod (speedrunapi present={} )", speedrunapi);

        if (speedrunapi) return;

        try {
            if (Files.notExists(configFile)) {
                Files.createFile(configFile);
                Files.write(configFile, Boolean.toString(disableScroll).getBytes(StandardCharsets.UTF_8));
                LOGGER.info("Created fallback config file with disableScroll={}", disableScroll);
            } else if (Files.exists(configFile)) {
                String s = new String(Files.readAllBytes(configFile), StandardCharsets.UTF_8).trim().toLowerCase();
                if (s.isEmpty()) s = Boolean.toString(disableScroll);
                disableScroll = s.equals("true") || s.equals("1") || s.equals("yes");
                LOGGER.info("Loaded fallback config disableScroll={}", disableScroll);
            } else {
                LOGGER.error("Config file is in superposition: {}", configFile);
            }
        } catch (IOException e) {
            LOGGER.error("Could not read or create fallback config file", e);
        }
    }
}
