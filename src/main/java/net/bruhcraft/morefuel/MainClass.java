package net.bruhcraft.morefuel;

import net.fabricmc.api.ModInitializer;

import net.bruhcraft.morefuel.MyConfig;

import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class MainClass implements ModInitializer {
	public static final String MOD_ID = "morefuel";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final MyConfig CONFIG = MyConfig.createAndLoad();

	@Override
	public void onInitialize() {
		LOGGER.info("More Fuel Initializing");
		registerFuel();
		LOGGER.info("More Fuel Initialized");
	}

	public void registerFuel() {
		FuelRegistry registry = FuelRegistry.INSTANCE;
		List<String> toCompost = CONFIG.FuelItems();

		for(String input : toCompost) {
			boolean add = input.charAt(0) != '-';
			String namespace;
			String path;
			if (add) {
				namespace = input.substring(0, input.indexOf(":"));
				path = input.substring(input.indexOf(":") + 1, input.indexOf(" "));
			} else {
				namespace = input.substring(1, input.indexOf(":"));
				path = input.substring(input.indexOf(":") + 1);
			}

			Item item = Registries.ITEM.get(new Identifier(namespace, path));
			if (add) {
				int time = Integer.parseInt(input.substring(input.indexOf(" ") + 1)) * 20;
				if (registry.get(item) != null) {
					registry.remove(item);
				}

				registry.add(item, time);
			} else {
				registry.remove(item);
			}
		}

	}
}