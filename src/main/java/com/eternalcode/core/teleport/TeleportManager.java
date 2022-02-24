package com.eternalcode.core.teleport;

import lombok.Getter;
import org.bukkit.Location;
import panda.std.Option;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TeleportManager {

   @Getter private final Map<UUID, Teleport> teleportMap = new HashMap<>();

    public void createTeleport(UUID uuid, Location location, int seconds){
        Teleport teleport = new Teleport(uuid, location, seconds);

        this.teleportMap.put(uuid, teleport);
    }

    public void removeTeleport(UUID uuid){
        this.teleportMap.remove(uuid);
    }

    public Option<Teleport> findTeleport(UUID uuid){
        return Option.of(this.teleportMap.get(uuid));
    }

    public boolean inTeleport(UUID uuid){
        Option<Teleport> teleportOption = this.findTeleport(uuid);

        if (teleportOption.isEmpty()){
            return false;
        }

        Teleport teleport = teleportOption.get();
        if (System.currentTimeMillis() < teleport.getTime()){
            return true;
        }

        this.removeTeleport(uuid);

        return false;
    }
}