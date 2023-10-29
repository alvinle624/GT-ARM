package com.cs2340.armadillo.View;

import static com.cs2340.armadillo.Models.MapLayout.mapNum;

import android.widget.ImageView;

import com.cs2340.armadillo.Models.MapLayout;
import com.cs2340.armadillo.Models.Player;
import com.cs2340.armadillo.Models.PlayerT;

public class MoveLeft implements Direction {
    MapLayout map = new MapLayout(mapNum);
    int[][] layout = map.getLayout();
    public void move(Player player) {
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 28; j++) {
                System.out.print(layout[j][i] + " ");
            }
            System.out.println();
        }
        System.out.println("player coords: (" + player.getX() + ", " + player.getY() + ")");
        if (player.playerCanMove(2, layout)) {
            player.changeXPos(-20, 0);
        }
    }
//    public void move(PlayerT player) {
//        player.changePos(-20, 0);
//    }
}
