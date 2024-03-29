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

import org.dynmap.DynmapLocation;
import org.dynmap.common.DynmapPlayer;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Texts;

import java.net.InetSocketAddress;

public class SpongePlayer extends SpongeCommandSender implements DynmapPlayer {

    private final Player player;

    public SpongePlayer(Player player) {
        super(player);
        this.player = player;
    }

    @Override
    public String getName() {
        return this.player.getName();
    }

    @Override
    public String getDisplayName() {
        return Texts.toPlain(this.player.getDisplayNameData().displayName().get());
    }

    @Override
    public boolean isOnline() {
        return this.player.isOnline();
    }

    @Override
    public DynmapLocation getLocation() {
        return new SpongeLocation(this.player.getLocation());
    }

    @Override
    public String getWorld() {
        return this.player.getLocation().getExtent().getName();
    }

    @Override
    public InetSocketAddress getAddress() {
        return this.player.getConnection().getAddress();
    }

    @Override
    public boolean isSneaking() {
        return false;
    }

    @Override
    public int getHealth() {
        return this.player.getHealthData().health().get().intValue();
    }

    @Override
    public int getArmorPoints() {
        return 0;
    }

    @Override
    public DynmapLocation getBedSpawnLocation() {
        return null;
    }

    @Override
    public long getLastLoginTime() {
        return this.player.getJoinData().lastPlayed().get().getTime();
    }

    @Override
    public long getFirstLoginTime() {
        return this.player.getJoinData().firstPlayed().get().getTime();
    }

    @Override
    public boolean isInvisible() {
        return false;
    }

    @Override
    public int getSortWeight() {
        return 0;
    }

    @Override
    public void setSortWeight(int wt) {

    }
}
