package weirdaddons;

import carpet.settings.SettingsManager;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.command.argument.ColumnPosArgumentType;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.ColumnPos;

import java.util.UUID;

import static com.mojang.brigadier.arguments.IntegerArgumentType.getInteger;
import static com.mojang.brigadier.arguments.IntegerArgumentType.integer;
import static net.minecraft.server.command.CommandManager.literal;
import static net.minecraft.server.command.CommandManager.argument;

public class WeirdAddonsCommands {

    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(literal("weird").requires((player) -> SettingsManager.canUseCommand(player, WeirdAddonsSettings.commandWeird)).
                then(literal("chunk").
                        then(literal("watch").
                                executes((c) -> {
                                    MinecraftServer server = c.getSource().getServer();
                                    UUID playerUUID = c.getSource().getPlayer().getUuid();
                                    if (WeirdAddonsUtils.playersWatching.contains(playerUUID)) {
                                        WeirdAddonsUtils.playersWatching.remove(playerUUID);
                                        WeirdAddonsUtils.sendToPlayer(server, playerUUID, "You are no longer watching chunk activity!");
                                    } else {
                                        WeirdAddonsUtils.playersWatching.add(playerUUID);
                                        WeirdAddonsUtils.sendToPlayer(server, playerUUID, "You are now watching chunk activity!");
                                    }
                                    return 1;
                                })
                        ).
                        then(literal("set").
                                then(argument("chunk", ColumnPosArgumentType.columnPos()).
                                        executes((c) -> {
                                            ColumnPos columnPos = ColumnPosArgumentType.getColumnPos(c, "chunk");
                                            WeirdAddonsSettings.chunkPos = new ChunkPos(columnPos.x, columnPos.z);
                                            WeirdAddonsUtils.sendToPlayer(c.getSource().getServer(), c.getSource().getPlayer().getUuid(), "Targeted chunk set to: " + WeirdAddonsSettings.chunkPos);
                                            return 1;
                                        }))).
                        then(literal("start").
                                executes((c) -> {
                                    MinecraftServer server = c.getSource().getServer();
                                    UUID playerUUID = c.getSource().getPlayer().getUuid();
                                    if (WeirdAddonsSettings.chunkPos == null) {
                                        WeirdAddonsUtils.sendToPlayer(server, playerUUID, "A chunk must be specified before this can be enabled!");
                                    } else if (WeirdAddonsSettings.isDisplayingChunk) {
                                        WeirdAddonsUtils.sendToPlayer(server, playerUUID, "Chunk has already started!");
                                    } else {
                                        WeirdAddonsUtils.playersWatching.add(playerUUID);
                                        WeirdAddonsSettings.chunkWorld = c.getSource().getPlayer().world;
                                        WeirdAddonsSettings.isDisplayingChunk = true;
                                        WeirdAddonsUtils.sendToPlayer(server, playerUUID, "Chunk has started!");
                                    }
                                    return 1;
                                })
                        ).
                        then(literal("stop").
                                executes((c) -> {
                                    MinecraftServer server = c.getSource().getServer();
                                    UUID playerUUID = c.getSource().getPlayer().getUuid();
                                    if (WeirdAddonsSettings.isDisplayingChunk) {
                                        WeirdAddonsSettings.isDisplayingChunk = false;
                                        WeirdAddonsUtils.sendToPlayer(server, playerUUID, "Chunk has stopped!");
                                    } else {
                                        WeirdAddonsUtils.sendToPlayer(server, playerUUID, "Chunk is not running!");
                                    }
                                    WeirdAddonsUtils.playersWatching.clear();
                                    return 1;
                                })
                        ).
                        then(literal("radius").
                                then(argument("radius", integer(0)).
                                        executes((c) -> {
                                            WeirdAddonsSettings.chunkRadius = getInteger(c, "radius");
                                            WeirdAddonsUtils.sendToPlayer(c.getSource().getServer(), c.getSource().getPlayer().getUuid(), "Chunk Radius has been set to: " + WeirdAddonsSettings.chunkRadius);
                                            return 1;
                                        }))
                        )
                ).
                /*then(literal("tick").
                        then(literal("chunk").
                                then(argument("rate", floatArg(0.1F, 500.0F)).
                                        suggests( (c, b) -> suggestMatching(new String[]{"20.0"},b)).
                                        executes((c) -> setChunkTps(c.getSource(), getFloat(c, "rate")))))).*/
                        then(literal("control").
                        executes((c) -> {
                            WeirdAddonsUtils.sendToPlayer(c.getSource().getServer(), c.getSource().getPlayer().getUuid(), "Not implemented yet...");
                            return 1;
                        })
                ).
                        //Just ignore this
                        then(literal("color").
                                executes((c) -> {
                                    WeirdAddonsUtils.sendToPlayer(c.getSource().getServer(), c.getSource().getPlayer().getUuid(),
                                            """
                                            §l----------: §6§lColors: §r§l :----------
                                            §aGreen: &a
                                            §bAqua: &b
                                            §cRed: &c
                                            §dPink: &d
                                            §eYellow: &e
                                            §fWhite: &f
                                            §0Black: &0
                                            §1Dark Blue: &1
                                            §2Dark Green: &2
                                            §3Dark Aqua: &3
                                            §4Dark Red: &4
                                            §5Dark Purple: &5
                                            §6Gold: &6
                                            §7Grey: &7
                                            §8Dark Grey &8
                                            §9Indigo: &9§r
                                            §l----------: §6§lFormats: §r§l :----------§r
                                            Obfuscate: &k
                                            §lBold: &l
                                            §mStrike Through: &m§r
                                            §nUnderline: &n§r
                                            §oItalics &o§r
                                            """);
                                    return 1;
                                })
                        ));
    }
}
