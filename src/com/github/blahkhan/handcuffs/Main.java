package com.github.blahkhan.handcuffs;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
    	Bukkit.getLogger().info("Plugin ON");
    	RegisterRecipe();
    	getServer().getPluginManager().registerEvents(new PlayerJoin(this), this);
    	getServer().getPluginManager().registerEvents(new PlayerMove(), this);
    	getServer().getPluginManager().registerEvents(new RightClick(this), this);
    }
    
    @Override
    public void onDisable() {
    	Bukkit.getLogger().info("Plugin OFF");
    }
    
    public void RegisterRecipe() {
    	ItemStack item = new ItemStack(Material.PUFFERFISH_SPAWN_EGG);
    	ItemMeta meta = item.getItemMeta();
    	meta.setDisplayName("Shackles");
    	List<String> lore = meta.getLore();
    	lore.add("Shackles");
    	meta.setLore(lore);
    	item.setItemMeta(meta);
    	NamespacedKey key = new NamespacedKey(this, "emerald_sword");
    	ShapedRecipe recipe = new ShapedRecipe(key, item);
    	recipe.shape("N","N","N","N","A","N","I","A","I");
    	recipe.setIngredient('N', Material.IRON_NUGGET);
    	recipe.setIngredient('A', Material.AIR);
    	recipe.setIngredient('I', Material.IRON_INGOT);
    	Bukkit.addRecipe(recipe);
    }
}
