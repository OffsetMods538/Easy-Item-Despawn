package top.offsetmonkey538.easyitemdespawn.config;

import blue.endless.jankson.Comment;
import top.offsetmonkey538.monkeylib538.config.Config;

import java.util.HashMap;
import java.util.Map;

import static top.offsetmonkey538.easyitemdespawn.EasyItemDespawn.MOD_ID;

public class ModConfig extends Config {

     @Comment("This is the despawn time (measured in ticks) for *all* items (even ones not dropped from a death). Only applies for entities that don't have a specified despawn time. Default value = 6000")
     public int globalDespawnTime = 6000;

     public Map<String, Integer> entityDropDespawnTimes = new HashMap<>(Map.of(
             "minecraft:player", 12000
     ));

     @Override
     protected String getName() {
          return MOD_ID;
     }
}
