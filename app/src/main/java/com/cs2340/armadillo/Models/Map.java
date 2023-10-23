package com.cs2340.armadillo.Models;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.cs2340.armadillo.R;

public class Map extends BaseAdapter {
    private Context context;

    public int[] tiles = {
            R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3,R.drawable.ground3, R.drawable.ground3,
            R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3,R.drawable.ground3, R.drawable.ground3,
            R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3,R.drawable.ground3, R.drawable.ground3,
            R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3,R.drawable.ground3, R.drawable.ground3,
            R.drawable.ground3, R.drawable.wall1, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3,R.drawable.ground3, R.drawable.ground3,
            R.drawable.ground3, R.drawable.wall1, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3,R.drawable.ground3, R.drawable.ground3,
            R.drawable.ground3, R.drawable.wall1, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3,R.drawable.ground3, R.drawable.ground3,
            R.drawable.ground3, R.drawable.wall1, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3,R.drawable.ground3, R.drawable.ground3,
            R.drawable.ground3, R.drawable.wall1, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3,R.drawable.ground3, R.drawable.ground3,
            R.drawable.ground3, R.drawable.wall1, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3,R.drawable.ground3, R.drawable.ground3,
            R.drawable.ground3, R.drawable.wall1, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3,R.drawable.ground3, R.drawable.ground3,
            R.drawable.ground3, R.drawable.wall1, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3,R.drawable.ground3, R.drawable.ground3,
            R.drawable.ground3, R.drawable.wall1, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3,R.drawable.ground3, R.drawable.ground3,
            R.drawable.ground3, R.drawable.wall1, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3,R.drawable.ground3, R.drawable.ground3,
            R.drawable.ground3, R.drawable.wall1, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3,R.drawable.ground3, R.drawable.ground3,
            R.drawable.ground3, R.drawable.wall1, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3,R.drawable.ground3, R.drawable.ground3,
            R.drawable.ground3, R.drawable.wall1, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3,R.drawable.ground3, R.drawable.ground3,
            R.drawable.ground3, R.drawable.wall1, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3,R.drawable.ground3, R.drawable.ground3,
            R.drawable.ground3, R.drawable.wall1, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3,R.drawable.ground3, R.drawable.ground3,
            R.drawable.ground3, R.drawable.wall1, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3,R.drawable.ground3, R.drawable.ground3,
            R.drawable.ground3, R.drawable.wall1, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3,R.drawable.ground3, R.drawable.ground3,
            R.drawable.ground3, R.drawable.wall1, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3,R.drawable.ground3, R.drawable.ground3,
            R.drawable.ground3, R.drawable.wall1, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3,R.drawable.ground3, R.drawable.ground3,
            R.drawable.ground3, R.drawable.wall1, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3,R.drawable.ground3, R.drawable.ground3,
            R.drawable.ground3, R.drawable.wall1, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3,R.drawable.ground3, R.drawable.ground3,
            R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3,R.drawable.ground3, R.drawable.ground3,
            R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3, R.drawable.ground3,R.drawable.ground3, R.drawable.ground3
    };

    public Map(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return tiles.length;
    }

    @Override
    public Object getItem(int i) {
        return tiles[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView imageView = new ImageView(context);
        imageView.setAdjustViewBounds(true);
        imageView.setImageResource(tiles[i]);
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        return imageView;
    }
}
