/*
 * Wildfire's Female Gender Mod is a female gender mod created for Minecraft.
 * Copyright (C) 2023-present WildfireRomeo
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.wildfire.events;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

/**
 * Event invoked when an armor item is appending its stats to a tooltip.
 * <br>
 * This is invoked <i>after</i> all other stats have already been added, but before any other tooltip lines have been added.
 */
@FunctionalInterface
@Environment(EnvType.CLIENT)
public interface ArmorStatsTooltipEvent {
	Event<ArmorStatsTooltipEvent> EVENT = EventFactory.createArrayBacked(ArmorStatsTooltipEvent.class, listeners -> (item, tooltip, player) -> {
		for(var listener : listeners) {
			listener.appendTooltips(item, tooltip, player);
		}
	});

	void appendTooltips(ItemStack item, Consumer<Text> tooltip, @Nullable PlayerEntity player);
}
