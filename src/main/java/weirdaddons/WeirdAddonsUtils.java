package weirdaddons;

import net.minecraft.network.MessageType;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ChunkHolder;
import net.minecraft.text.LiteralText;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.ChunkManager;
import net.minecraft.world.chunk.WorldChunk;

import java.util.*;

public class WeirdAddonsUtils {

    public static HashSet<UUID> playersWatching = new HashSet<>();

    public static void sendToPlayer(MinecraftServer server, UUID playerUUID, String msg) {
        ServerPlayerEntity player = server.getPlayerManager().getPlayer(playerUUID);
        if (player != null) {
            player.sendMessage(new LiteralText(msg), MessageType.SYSTEM, playerUUID);
        }
    }

    public static void updateDisplayingChunks(MinecraftServer server) {
        for (UUID player : playersWatching) {
            sendToPlayer(server, player, displayChunks(server, WeirdAddonsSettings.chunkWorld, WeirdAddonsSettings.chunkPos, WeirdAddonsSettings.chunkRadius, player));
        }
    }

    public static String displayChunks(MinecraftServer server, World world, ChunkPos pos, int radius, UUID playerUUID){
        ChunkManager chunkManager = world.getChunkManager();
        StringBuilder result = new StringBuilder();
        for (int x = pos.x-radius; x <= pos.x+radius; x++) {
            for (int z = pos.z-radius; z <= pos.z+radius; z++) {
                char icon = '█';
                WorldChunk chunk = chunkManager.getWorldChunk(x, z, false);
                if (x == pos.x && z == pos.z) {
                    icon = '◎';
                }
                if (chunk != null) {
                    boolean isPlayerChunk = false;
                    for (ServerPlayerEntity player : server.getPlayerManager().getPlayerList()) {
                        if (player != null && player.getChunkPos().x == x && player.getChunkPos().z == z) {
                            isPlayerChunk = true;
                            break;
                        }
                    }
                    if (isPlayerChunk) {
                        ServerPlayerEntity player = server.getPlayerManager().getPlayer(playerUUID);
                        if (player != null && player.getChunkPos().x == x && player.getChunkPos().z == z) {
                            result.append("§5☻");
                        } else {
                            result.append("§5").append(icon);
                        }
                    } else {
                        ChunkHolder.LevelType levelType = chunk.getLevelType();
                        if (levelType == ChunkHolder.LevelType.TICKING) {
                            result.append("§a").append(icon); //green
                        } else if (levelType == ChunkHolder.LevelType.ENTITY_TICKING) {
                            result.append("§2").append(icon); //dark_green
                        } else if (levelType == ChunkHolder.LevelType.BORDER) {
                            result.append("§7").append(icon); //gray
                        } else if (levelType == ChunkHolder.LevelType.INACCESSIBLE) {
                            result.append("§4").append(icon); //red
                        } else {
                            result.append("§8").append(icon); //dark_gray - null levelType
                        }
                    }
                } else {
                    result.append("§0").append(icon); //black - null chunk
                }
            }
            result.append("\n");
        }
        return result.toString();
    }

}
