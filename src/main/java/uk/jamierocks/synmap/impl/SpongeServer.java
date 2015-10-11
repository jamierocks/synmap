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
import org.dynmap.DynmapWorld;
import org.dynmap.common.DynmapListenerManager;
import org.dynmap.common.DynmapPlayer;
import org.dynmap.common.DynmapServerInterface;
import org.dynmap.utils.MapChunkCache;
import org.spongepowered.api.Game;
import org.spongepowered.api.Server;
import org.spongepowered.api.service.scheduler.SchedulerService;
import uk.jamierocks.synmap.SynmapPlugin;

import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

public class SpongeServer extends DynmapServerInterface {

    private final Game game;
    private final Server server;
    private final SynmapPlugin plugin;

    public SpongeServer(Game game, SynmapPlugin plugin) {
        this.game = game;
        this.server = game.getServer();
        this.plugin = plugin;
    }


    @Override
    public void scheduleServerTask(Runnable run, long delay) {
        this.game.getServiceManager().provide(SchedulerService.class).get()
                .createTaskBuilder()
                .delay(delay)
                .execute(run)
                .submit(plugin);
    }

    @Override
    public <T> Future<T> callSyncMethod(Callable<T> task) {
        return null;
    }

    @Override
    public DynmapPlayer[] getOnlinePlayers() {
        return new DynmapPlayer[0];
    }

    @Override
    public void reload() {

    }

    @Override
    public DynmapPlayer getPlayer(String name) {
        return null;
    }

    @Override
    public DynmapPlayer getOfflinePlayer(String name) {
        return null;
    }

    @Override
    public Set<String> getIPBans() {
        return null;
    }

    @Override
    public String getServerName() {
        return null;
    }

    @Override
    public boolean isPlayerBanned(String pid) {
        return false;
    }

    @Override
    public String stripChatColor(String s) {
        return null;
    }

    @Override
    public boolean requestEventNotification(DynmapListenerManager.EventType type) {
        return false;
    }

    @Override
    public boolean sendWebChatEvent(String source, String name, String msg) {
        return false;
    }

    @Override
    public void broadcastMessage(String msg) {

    }

    @Override
    public String[] getBiomeIDs() {
        return new String[0];
    }

    @Override
    public double getCacheHitRate() {
        return 0;
    }

    @Override
    public void resetCacheStats() {

    }

    @Override
    public DynmapWorld getWorldByName(String wname) {
        return null;
    }

    @Override
    public Set<String> checkPlayerPermissions(String player, Set<String> perms) {
        return null;
    }

    @Override
    public boolean checkPlayerPermission(String player, String perm) {
        return false;
    }

    @Override
    public MapChunkCache createMapChunkCache(DynmapWorld w, List<DynmapChunk> chunks, boolean blockdata,
            boolean highesty, boolean biome, boolean rawbiome) {
        return null;
    }

    @Override
    public int getMaxPlayers() {
        return this.server.getMaxPlayers();
    }

    @Override
    public int getCurrentPlayers() {
        return this.server.getOnlinePlayers().size();
    }

    @Override
    public int getBlockIDAt(String wname, int x, int y, int z) {
        return 0;
    }

    @Override
    public double getServerTPS() {
        return this.server.getTicksPerSecond();
    }

    @Override
    public String getServerIP() {
        return this.server.getBoundAddress().get().getHostName();
    }
}
