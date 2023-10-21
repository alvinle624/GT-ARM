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


}
