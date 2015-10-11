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
        return null;
    }

    @Override
    public String getWorld() {
        return null;
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
        return 0;
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
        return 0;
    }

    @Override
    public long getFirstLoginTime() {
        return 0;
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
