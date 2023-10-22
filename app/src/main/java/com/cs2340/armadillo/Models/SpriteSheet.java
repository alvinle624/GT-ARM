package com.cs2340.armadillo.Models;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

import com.cs2340.armadillo.R;

public class SpriteSheet {
    private static final int spriteWidth = 64;
    private static final int spriteHeight = 64;
    private Bitmap bitmap;

    public SpriteSheet(Context context) {
        BitmapFactory.Options bitmapOptions = new BitmapFactory.Options();
        bitmapOptions.inScaled = false;
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.sprite_sheet, bitmapOptions);
    }

//    public Sprite getPlayerSprite() {
//        Sprite playerSprite = new Sprite(this, new Rect(0, 0, 64, 64));
//        return playerSprite;
//    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public Sprite getGround1() {
        return getSprite(0, 4);
    }

    public Sprite getGround2() {
        return getSprite(0, 8);
    }

    public Sprite getGround3() {
        return getSprite(0, 12);
    }

    public Sprite getWall1() {
        return getSprite(4, 4);
    }

    public Sprite getWall2() {
        return getSprite(8, 4);
    }

    public Sprite getWall3() {
        return getSprite(4, 8);
    }

    public Sprite getWindow() {
        return getSprite(12, 4);
    }

    public Sprite getPlant1() {
        return getSprite(8, 8);
    }

    public Sprite getPlant2() {
        return getSprite(12, 8);
    }

    private Sprite getSprite(int x, int y) {
        return new Sprite(this, new Rect(
                x * spriteWidth,
                y * spriteHeight,
                (x + 1) * spriteWidth,
                (y + 1) * spriteHeight
        ));
    }

}
