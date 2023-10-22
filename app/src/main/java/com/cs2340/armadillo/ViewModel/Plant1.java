package com.cs2340.armadillo.ViewModel;

import android.graphics.Canvas;
import android.graphics.Rect;

import com.cs2340.armadillo.Models.Sprite;
import com.cs2340.armadillo.Models.SpriteSheet;
import com.cs2340.armadillo.Models.Tile;

public class Plant1 extends Tile {
    private final Sprite sprite;

    public Plant1(SpriteSheet spritesheet, Rect coords) {
        super(coords);
        sprite = spritesheet.getGround1();
    }

    @Override
    public void draw(Canvas canvas) {
        sprite.draw(canvas, coords.left, coords.top);
    }
}
