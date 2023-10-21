package com.cs2340.armadillo.Models;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Bitmap;
public class Sprite {
    private final SpriteSheet spritesheet;
    private final Rect spriteImg;
    public Sprite(SpriteSheet spritesheet, Rect spriteImg) {
        this.spritesheet = spritesheet;
        this.spriteImg = spriteImg;
    }

    public void draw(Canvas canvas, int x, int y) {
        canvas.drawBitmap(
                spritesheet.getBitmap(),
                    spriteImg,
                    new Rect(x, y, x+getWidth(), y+getHeight()),
                null
        );
    }

    public int getWidth() {
        return spriteImg.width();
    }

    public int getHeight() {
        return spriteImg.width();
    }
}
