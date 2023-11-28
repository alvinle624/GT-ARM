package com.cs2340.armadillo.View;

import static com.cs2340.armadillo.Models.MapLayout.mapNum;

import android.widget.ImageView;
import com.cs2340.armadillo.Models.Enemies;
import com.cs2340.armadillo.Models.MapLayout;

import com.cs2340.armadillo.Models.Player;
import com.cs2340.armadillo.Models.PlayerT;

public class MoveDown implements Direction{

    MapLayout map = new MapLayout(mapNum);
    int[][] layout = map.getLayout();
//    System.out.println(layout[0][0]);

    /**
     * moves player down
     * @param player player
     * @param enemies enemies
     */
    public void move(Player player, Enemies enemies) {
        System.out.println(player.playerCanMove(1, layout));
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 28; j++) {
                System.out.print(layout[j][i] + " ");
            }
            System.out.println();
        }
        System.out.println("player coords: (" + player.getX() + ", " + player.getY() + ")");

        if (player.playerCanMove(1, layout)) {
            player.changeYPos(0, 20);

            for (int i = 0; i < enemies.getEnemyList().size(); i = i + 1) {
                EnemyView enemy = enemies.findE(i);
                enemy.moveEnemy(enemy, player, layout);
            }
        }
    }
//    public void move(PlayerT player) {
//        player.changePos(0, 20);
//    }
}
