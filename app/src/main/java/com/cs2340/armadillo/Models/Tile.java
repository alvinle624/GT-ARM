package com.cs2340.armadillo.Models;

import android.graphics.Canvas;
import android.graphics.Rect;

import com.cs2340.armadillo.ViewModel.*;

public abstract class Tile {
    protected final Rect coords;

    public Tile(Rect coords) {
        this.coords = coords;
    }

    public enum TileID {
        MAP1GROUND,
        MAP2GROUND,
        MAP3GROUND,
        WALL1,
        WALL2,
        WALL3,
        WINDOW,
        PLANT1,
        PLANT2
    }

    public static Tile getTile(int tileID, SpriteSheet spritesheet, Rect coords) {
        switch(TileID.values()[tileID]) {
            case MAP1GROUND:
                return new Ground1(spritesheet, coords);
            case MAP2GROUND:
                return new Ground2(spritesheet, coords);
            case MAP3GROUND:
                return new Ground3(spritesheet, coords);
            case WALL1:
                return new Wall1(spritesheet, coords);
            case WALL2:
                return new Wall2(spritesheet, coords);
            case WALL3:
                return new Wall3(spritesheet, coords);
            case WINDOW:
                return new Window(spritesheet, coords);
            case PLANT1:
                return new Plant1(spritesheet, coords);
            case PLANT2:
                return new Plant2(spritesheet, coords);
            default:
                return null;
        }
    }
    public abstract void draw(Canvas canvas);
}
