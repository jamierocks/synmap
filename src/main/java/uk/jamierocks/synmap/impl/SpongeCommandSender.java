package uk.jamierocks.synmap.impl;

import org.dynmap.common.DynmapCommandSender;
import org.spongepowered.api.text.Texts;
import org.spongepowered.api.util.TextMessageException;
import org.spongepowered.api.util.command.CommandSource;

public class SpongeCommandSender implements DynmapCommandSender {

    private final CommandSource commandSource;

    public SpongeCommandSender(CommandSource commandSource) {
        this.commandSource = commandSource;
    }

    @Override
    public boolean hasPrivilege(String privid) {
        return false;
    }

    @Override
    public void sendMessage(String msg) {
        try {
            this.commandSource.sendMessage(Texts.legacy().from(msg));
        } catch (TextMessageException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean isConnected() {
        return false;
    }

    @Override
    public boolean isOp() {
        return false;
    }

    @Override
    public boolean hasPermissionNode(String node) {
        return this.commandSource.hasPermission(node);
    }
}
