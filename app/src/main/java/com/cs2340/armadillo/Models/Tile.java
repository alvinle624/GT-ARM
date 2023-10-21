package com.cs2340.armadillo.Models;

import android.graphics.Rect;

public class Tile {
    protected final Rect mapLocation;

    public Tile(Rect mapLocation) {
        this.mapLocation = mapLocation;
    }

    public enum TileID {

    }

//    public static Tile getTile(int tileID, SpriteSheet spritesheet, Rect mapLocation) {
//        switch(TileID.values()[tileID]) {
//            default:
//                return;
//        }
//    }
}
