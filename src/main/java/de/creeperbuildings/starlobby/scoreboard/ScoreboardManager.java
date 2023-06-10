package de.creeperbuildings.starlobby.scoreboard;

import de.creeperbuildings.starlobby.Main;
import de.creeperbuildings.starlobby.scoreboard.animation.FrameAnimatedString;
import fr.mrmicky.fastboard.FastBoard;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class ScoreboardManager {
    public void createScoreboard(Player player) {
        FastBoard board = new FastBoard(player);
        FrameAnimatedString fas = new FrameAnimatedString(Main.plugin().getConfig().getStringList("scoreboard.default.title"));

        new BukkitRunnable() {
            @Override
            public void run() {
                board.updateTitle(fas.next());
                board.updateLines(Main.plugin().getConfig().getStringList("scoreboard.default.content"));

                if (!Bukkit.getOnlinePlayers().contains(player)) {
                    board.delete();
                    cancel();
                }
            }
        }.runTaskTimer(Main.plugin(), 0, Main.plugin().getConfig().getInt("scoreboard.refresh-rate"));
    }
}
