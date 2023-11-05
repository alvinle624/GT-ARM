package com.cs2340.armadillo.Models;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import static com.cs2340.armadillo.Models.MapLayout.*;
public class TileMap {
    private final MapLayout mapLayout;
    private Tile[][] tileMap;
    private SpriteSheet spritesheet;
    private Bitmap bitmap;
    public TileMap(SpriteSheet spritesheet) {
        mapLayout = new MapLayout();
        this.spritesheet = spritesheet;
        initializeMap();
    }

    private void initializeMap() {
        int[][] layout = mapLayout.getLayout();
        tileMap = new Tile[rowTiles][colTiles];
        for (int row = 0; row < rowTiles; row++) {
            for (int col = 0; col < colTiles; col++) {
                tileMap[row][col] = Tile.getTile(
                    layout[row][col],
                    spritesheet,
                    getTileIdx(row, col)
                );
            }
        }
        Bitmap.Config config = Bitmap.Config.ARGB_8888;
        bitmap = Bitmap.createBitmap(
                colTiles*tileWidth,
                rowTiles*tileHeight,
                config
        );

        Canvas map = new Canvas(bitmap);

        for (int row = 0; row < rowTiles; row++) {
            for (int col = 0; col < colTiles; col++) {
                tileMap[row][col].draw(map);
            }
        }
    }

    private Rect getTileIdx(int row, int col) {
        return new Rect(
                col * tileWidth,
                row * tileHeight,
                (col + 1) * tileWidth,
                (row + 1) * tileHeight
        );
    }

}
