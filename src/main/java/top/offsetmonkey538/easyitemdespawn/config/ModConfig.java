package top.offsetmonkey538.easyitemdespawn.config;

import top.offsetmonkey538.monkeyconfig538.Config;
import top.offsetmonkey538.monkeyconfig538.annotation.ConfigEntry;

public class ModConfig extends Config {


     @ConfigEntry("This is the despawn time (measured in ticks) for *all* items (even ones not dropped from a death). Only applies for entities that don't have a specified despawn time. Default value = 6000")
     public static int globalDespawnTime = 6000;


    @Override
    protected String getName() {
        return "easy-item-despawn";
    }
}
