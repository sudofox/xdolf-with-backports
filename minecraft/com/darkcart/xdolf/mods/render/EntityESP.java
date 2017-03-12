package com.darkcart.xdolf.mods.render;

import java.awt.Color;

import org.lwjgl.input.Keyboard;

import com.darkcart.xdolf.Client;
import com.darkcart.xdolf.Module;
import com.darkcart.xdolf.util.RenderUtils;

import net.minecraft.entity.Entity;

public class EntityESP extends Module {

	@Override
	public int getKeyCode() {
		return Keyboard.KEY_G;
	}
	
	public void render() {
		for (Entity e: Client.mc.world.loadedEntityList) {
			String entityPackage = e.getClass().getPackage().getName();
			if (entityPackage.equals("net.minecraft.entity.monster")) {
				RenderUtils.entityESPBox(e, Color.red);
			}
			if (entityPackage.equals("net.minecraft.entity.passive")) {
				RenderUtils.entityESPBox(e, Color.green);
			}
			if (entityPackage.equals("net.minecraft.entity.item")) {
				RenderUtils.entityESPBox(e, Color.white);
			}
		}
	}
	
	@Override
	public String getName() {
		return "EntityESP";
	}

	@Override
	public String getDescription() {
		return "Creates an ESP box around entities.";
	}
}