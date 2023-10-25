package com.cs2340.armadillo.View;

import static com.cs2340.armadillo.Models.MapLayout.mapNum;

import android.widget.ImageView;
import com.cs2340.armadillo.Models.MapLayout;

import com.cs2340.armadillo.Models.Player;
import com.cs2340.armadillo.Models.PlayerT;

public class MoveDown implements Direction{

    MapLayout map = new MapLayout(mapNum);
    int[][] layout = map.getLayout();
//    System.out.println(layout[0][0]);
    public void move(Player player) {
        System.out.println(player.playerCanMove(1, layout));
        if (player.playerCanMove(1, layout)) {
            player.changeYPos(0, 20);
        }
    }
//    public void move(PlayerT player) {
//        player.changePos(0, 20);
//    }
}
