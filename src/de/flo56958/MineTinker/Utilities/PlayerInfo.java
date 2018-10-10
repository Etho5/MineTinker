package de.flo56958.MineTinker.Utilities;

import de.flo56958.MineTinker.Data.Strings;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class PlayerInfo {

    public static String getFacingDirection(Player player) {
        double rot = (player.getLocation().getYaw() - 90) % 360;
        if (rot < 0) {
            rot += 360.0;
        }
        return getDirection(rot);
    }

    private static String getDirection(double rot) {
        if (0 <= rot && rot < 45) {
            return "W";
        } else if (45 <= rot && rot < 135) {
            return "N";
        } else if (135 <= rot && rot < 225) {
            return "E";
        } else if (225 <= rot && rot < 315) {
            return "S";
        } else if (315 <= rot && rot < 360.0) {
            return "W";
        } else {
            return null;
        }
    }

    public static boolean isToolViable(ItemStack tool) {
        if (!tool.hasItemMeta()) { return false; }
        ItemMeta meta = tool.getItemMeta();

        if (!meta.hasLore()) { return false; }
        List<String> lore = meta.getLore();
        if (!lore.contains(Strings.IDENTIFIER)) { return false; }
        return true;
    }

    public static boolean isWandViable(ItemStack tool) {
        if (!tool.hasItemMeta()) { return false; }
        ItemMeta meta = tool.getItemMeta();

        if (!meta.hasLore()) { return false; }
        List<String> lore = meta.getLore();
        if (!lore.contains(Strings.IDENTIFIER_BUILDERSWAND)) { return false; }
        return true;
    }

}
