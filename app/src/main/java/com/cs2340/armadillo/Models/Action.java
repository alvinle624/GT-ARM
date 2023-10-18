package com.cs2340.armadillo.Models;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.cs2340.armadillo.View.*;

import org.w3c.dom.Text;

public class Action {
    ImageButton up;
    ImageButton right;
    ImageButton down;
    ImageButton left;
    Player player;
    Direction direction;
    private Handler mHandler;

    public Action(ImageButton up, ImageButton right, ImageButton down, ImageButton left, Player player) {
        this.up = up;
        this.right = right;
        this.down = down;
        this.left = left;
        this.player = player;
    }

    public void setListeners() {
        up.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                direction = new MoveUp();
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        direction.move(player);
                        break;
                }
                return true;
            }
        });

        right.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                direction = new MoveRight();
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    direction.move(player);
                }
                return true;
            }
        });

        down.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                direction = new MoveDown();
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    direction.move(player);
                }
                return true;
            }
        });

        left.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                direction = new MoveLeft();
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    direction.move(player);
                }
                return true;
            }
        });
    }


}
