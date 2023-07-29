package top.offsetmonkey538.easyitemdespawn;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import top.offsetmonkey538.easyitemdespawn.config.ModConfig;

public class EasyItemDespawn implements ModInitializer {
	public static final String MOD_ID = "easy-item-despawn";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// Do stuff
		new ModConfig().init();
	}

	public static Identifier id(String path) {
		return new Identifier(MOD_ID, path);
	}
}
