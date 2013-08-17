/*
 * Copyright (C) 2013 Martin Leopold <m@martinleopold.com>
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package com.martinleopold.pui.events2;

import java.util.ArrayList;

/**
 * 
 * @author Martin Leopold <m@martinleopold.com>
 * @param <T> Data Type of the Event
 */
public class Event<T> {
	ArrayList<Listener<T>> listeners;
	
	Event() {
		listeners = new ArrayList<Listener<T>>();
	}
	
	synchronized void fire(T args) {
		for (Listener<T> l : listeners) {
			l.notify(args);
		}
	}
	
	synchronized void addListener(Listener<T> listener) {
		listeners.add(listener);
	}
	
	synchronized void removeListener(Listener<T> listener) {
		listeners.remove(listener);
	}
}