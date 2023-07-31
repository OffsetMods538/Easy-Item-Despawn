package top.offsetmonkey538.easyitemdespawn;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.offsetmonkey538.easyitemdespawn.config.ModConfig;
import top.offsetmonkey538.monkeyconfig538.ConfigManager;

public class EasyItemDespawn implements ModInitializer {
	public static final String MOD_ID = "easy-item-despawn";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// Do stuff
		ConfigManager.init(new ModConfig(), MOD_ID);
	}

	public static ModConfig config() {
		return (ModConfig) ConfigManager.get(MOD_ID);
	}

	public static Identifier id(String path) {
		return new Identifier(MOD_ID, path);
	}
}
