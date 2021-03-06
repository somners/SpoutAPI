/*
 * This file is part of SpoutAPI.
 *
 * Copyright (c) 2011-2012, Spout LLC <http://www.spout.org/>
 * SpoutAPI is licensed under the Spout License Version 1.
 *
 * SpoutAPI is free software: you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or (at your option)
 * any later version.
 *
 * In addition, 180 days after any changes are published, you can use the
 * software, incorporating those changes, under the terms of the MIT license,
 * as described in the Spout License Version 1.
 *
 * SpoutAPI is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License for
 * more details.
 *
 * You should have received a copy of the GNU Lesser General Public License,
 * the MIT license and the Spout License Version 1 along with this program.
 * If not, see <http://www.gnu.org/licenses/> for the GNU Lesser General Public
 * License and see <http://spout.in/licensev1> for the full license, including
 * the MIT license.
 */
package org.spout.api.event.object;

import org.spout.api.util.thread.annotation.Threadsafe;

/**
 * Base interface for an object that can accept listeners for a specified event
 * @param <T> The type of event allowed
 */
public interface Eventable<T extends ObjectEvent<U>, U extends Eventable<T, U>> {
	/**
	 * Add a listener for the type of event this {@link Eventable} covers.
	 * @param listener The listener to register.
	 */
	@Threadsafe
	public void registerListener(EventableListener<T> listener);

	/**
	 * Remove all listeners for the event
	 */
	@Threadsafe
	public void unregisterAllListeners();

	/**
	 * Unregister a specific listener
	 * @param listener The listener to unregister
	 */
	@Threadsafe
	public void unregisterListener(EventableListener<T> listener);

	/**
	 * Call the event with all current listeners.
	 * @param event The event instance to call
	 */
	@Threadsafe
	public void callEvent(T event);
}
