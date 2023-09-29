package com.cs2340.armadillo;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

public class Player extends androidx.appcompat.widget.AppCompatImageView {
    private String name;
    private String difficulty;
    private int sprite;
    private int HP;

    private int playerWidth, playerHeight;
    private int spriteID;

    private float x, y;

    public Player(Context context, float x, float y, int HP, int playerWidth, int playerHeight) {
        super(context);
        this.x = x;
        this.y = y;
        this.sprite = 1;
        this.HP = HP;
        this.playerHeight = playerHeight;
        this.playerWidth = playerWidth;
        this.setImageResource(R.drawable.sprite_one_img);
        this.setMaxHeight(40);
        this.setMaxWidth(50);
        this.setX(x);
        this.setY(y);
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDifficulty() {
        return difficulty;
    }
    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }
    public int getHP() {
        return HP;
    }
    public void setHP(int HP) {
        this.HP = HP;
    }
    public int getSprite() {
        return sprite;
    }
    public void setSprite(int sprite) {
        this.sprite = sprite;
        if (sprite == 1) {
            spriteID = R.drawable.sprite_one_img;
        } else if (sprite == 2) {
            spriteID = R.drawable.sprite_two_img;
        } else {
            spriteID = R.drawable.sprite_three_img;
        }
        this.setImageResource(spriteID);
//        this.getLayoutParams().height = 30;
    }
}
