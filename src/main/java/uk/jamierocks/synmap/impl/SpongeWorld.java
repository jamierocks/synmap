/*
 * This file is part of Synmap, licensed under the MIT License (MIT).
 *
 * Copyright (c) 2015, Jamie Mansfield <https://github.com/jamierocks>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package uk.jamierocks.synmap.impl;

import org.dynmap.DynmapChunk;
import org.dynmap.DynmapLocation;
import org.dynmap.DynmapWorld;
import org.dynmap.utils.MapChunkCache;
import org.spongepowered.api.world.DimensionTypes;
import org.spongepowered.api.world.World;

import java.util.List;

public class SpongeWorld extends DynmapWorld {

    private final World world;

    protected SpongeWorld(World world) {
        super(world.getName(), 0, 0);
        this.world = world;
    }

    @Override
    public boolean isNether() {
        return this.world.getDimension().getType().equals(DimensionTypes.NETHER);
    }

    @Override
    public DynmapLocation getSpawnLocation() {
        return new SpongeLocation(this.world.getSpawnLocation());
    }

    @Override
    public long getTime() {
        return this.world.getProperties().getWorldTime();
    }

    @Override
    public boolean hasStorm() {
        return false;
    }

    @Override
    public boolean isThundering() {
        return false;
    }

    @Override
    public boolean isLoaded() {
        return false;
    }

    @Override
    public void setWorldUnloaded() {

    }

    @Override
    public int getLightLevel(int x, int y, int z) {
        return 0;
    }

    @Override
    public int getHighestBlockYAt(int x, int z) {
        return 0;
    }

    @Override
    public boolean canGetSkyLightLevel() {
        return this.world.getDimension().hasSky();
    }

    @Override
    public int getSkyLightLevel(int x, int y, int z) {
        return 0;
    }

    @Override
    public String getEnvironment() {
        return null;
    }

    @Override
    public MapChunkCache getChunkCache(List<DynmapChunk> chunks) {
        return null;
    }
}
