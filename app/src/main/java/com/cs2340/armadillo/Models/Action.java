package com.cs2340.armadillo.Models;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
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
    private Handler mHandler = new Handler(Looper.getMainLooper());

    public Action (ImageButton up, ImageButton right, ImageButton down, ImageButton left, Player player) {
        this.up = up;
        this.right = right;
        this.down = down;
        this.left = left;
        this.player = player;
    }
    @SuppressLint("ClickableViewAccessibility")
    public void setListeners() {
        up.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                direction = new MoveUp();
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        mHandler.postDelayed(moveAction, 10);
                        break;
                    case MotionEvent.ACTION_UP:
                        mHandler.removeCallbacks(moveAction);
                        break;
                }
                return true;
            }
        });

        right.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                direction = new MoveRight();
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        mHandler.postDelayed(moveAction, 10);
                        break;
                    case MotionEvent.ACTION_UP:
                        mHandler.removeCallbacks(moveAction);
                        break;
                }
                return true;
            }
        });

        down.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                direction = new MoveDown();
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        mHandler.postDelayed(moveAction, 10);
                        break;
                    case MotionEvent.ACTION_UP:
                        mHandler.removeCallbacks(moveAction);
                        break;
                }
                return true;
            }
        });

        left.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                direction = new MoveLeft();
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        mHandler.postDelayed(moveAction, 10);
                        break;
                    case MotionEvent.ACTION_UP:
                        mHandler.removeCallbacks(moveAction);
                        break;
                }
                return true;
            }
        });
    }

    Runnable moveAction = new Runnable() {
        @Override
        public void run() {
            direction.move(player);
            mHandler.postDelayed(this, 80);
        }
    };
    public void stopButton() {
        mHandler.removeCallbacks(moveAction);
    }

}
