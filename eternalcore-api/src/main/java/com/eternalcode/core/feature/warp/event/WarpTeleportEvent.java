package com.eternalcode.core.feature.warp.event;

import com.eternalcode.core.feature.warp.Warp;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class WarpTeleportEvent extends Event implements Cancellable {
    private static final HandlerList HANDLER_LIST = new HandlerList();

    private final Player player;
    private boolean cancelled;
    private final Warp warp;

    public WarpTeleportEvent(Player player, Warp warp) {
        super(false);

        this.player = player;
        this.warp = warp;
    }

    public Player getPlayer() {
        return this.player;
    }

    public Warp getWarp() {
        return this.warp;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLER_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLER_LIST;
    }

    @Override
    public boolean isCancelled() {
        return this.cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }
}
