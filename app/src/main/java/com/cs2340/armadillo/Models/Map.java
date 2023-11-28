package com.cs2340.armadillo.Models;

import static com.cs2340.armadillo.Models.MapLayout.mapNum;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.cs2340.armadillo.R;

public class Map extends BaseAdapter {
    //class uses all the drawables to form a map
    private Context context;

    //third map
    public int[] mapThree = {
            R.drawable.plant1, R.drawable.plant1, R.drawable.plant1, R.drawable.plant1, R.drawable.plant1, R.drawable.plant1, R.drawable.plant1, R.drawable.plant1, R.drawable.plant1, R.drawable.plant1, R.drawable.plant1,R.drawable.plant1, R.drawable.plant1,
            R.drawable.plant1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1,R.drawable.ground1, R.drawable.plant1,
            R.drawable.plant1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1,R.drawable.ground1, R.drawable.plant1,
            R.drawable.plant1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1,R.drawable.ground1, R.drawable.plant1,
            R.drawable.plant1, R.drawable.plant1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1,R.drawable.ground1, R.drawable.plant1,
            R.drawable.plant1, R.drawable.plant1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1,R.drawable.ground1, R.drawable.plant1,
            R.drawable.plant1, R.drawable.plant1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1,R.drawable.ground1, R.drawable.plant1,
            R.drawable.plant1, R.drawable.plant1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1,R.drawable.ground1, R.drawable.plant1,
            R.drawable.plant1, R.drawable.plant1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1,R.drawable.ground1, R.drawable.plant1,
            R.drawable.plant1, R.drawable.plant1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1,R.drawable.ground1, R.drawable.plant1,
            R.drawable.plant1, R.drawable.plant1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1,R.drawable.ground1, R.drawable.plant1,
            R.drawable.plant1, R.drawable.plant1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1,R.drawable.ground1, R.drawable.plant1,
            R.drawable.plant1, R.drawable.plant1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1,R.drawable.ground1, R.drawable.plant1,
            R.drawable.plant1, R.drawable.plant1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1,R.drawable.ground1, R.drawable.plant1,
            R.drawable.plant1, R.drawable.plant1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1,R.drawable.ground1, R.drawable.plant1,
            R.drawable.plant1, R.drawable.plant1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1,R.drawable.ground1, R.drawable.plant1,
            R.drawable.plant1, R.drawable.plant1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.plant1, R.drawable.plant1, R.drawable.plant1,R.drawable.plant1, R.drawable.plant1,
            R.drawable.plant1, R.drawable.plant1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.plant1, R.drawable.ground1, R.drawable.ground1,R.drawable.ground1, R.drawable.ground1,
            R.drawable.plant1, R.drawable.plant1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.plant1, R.drawable.ground1, R.drawable.ground1,R.drawable.ground1, R.drawable.ground1,
            R.drawable.plant1, R.drawable.plant1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.plant1, R.drawable.ground1, R.drawable.ground1,R.drawable.ground1, R.drawable.ground1,
            R.drawable.plant1, R.drawable.plant1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.plant1, R.drawable.plant1, R.drawable.plant1,R.drawable.plant1, R.drawable.plant1,
            R.drawable.plant1, R.drawable.plant1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1,R.drawable.ground1, R.drawable.plant1,
            R.drawable.plant1, R.drawable.plant1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1,R.drawable.ground1, R.drawable.plant1,
            R.drawable.plant1, R.drawable.plant1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1,R.drawable.ground1, R.drawable.plant1,
            R.drawable.plant1, R.drawable.plant1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.ground1,R.drawable.ground1, R.drawable.plant1,
            R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.plant1, R.drawable.plant1, R.drawable.plant1, R.drawable.plant1, R.drawable.plant1, R.drawable.plant1, R.drawable.plant1, R.drawable.plant1,R.drawable.plant1, R.drawable.plant1,
            R.drawable.ground1, R.drawable.ground1, R.drawable.ground1, R.drawable.plant1, R.drawable.plant1, R.drawable.plant1, R.drawable.plant1, R.drawable.plant1, R.drawable.plant1, R.drawable.plant1, R.drawable.plant1,R.drawable.plant1, R.drawable.plant1
    };

    //second map
    public int[] mapTwo = {
            R.drawable.wall2, R.drawable.wall2, R.drawable.wall2, R.drawable.wall2, R.drawable.wall2, R.drawable.wall2, R.drawable.wall2, R.drawable.wall2, R.drawable.wall2, R.drawable.wall2, R.drawable.wall2,R.drawable.wall2, R.drawable.wall2,
            R.drawable.wall2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2,R.drawable.ground2, R.drawable.wall2,
            R.drawable.wall2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2,R.drawable.ground2, R.drawable.wall2,
            R.drawable.wall2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2,R.drawable.ground2, R.drawable.wall2,
            R.drawable.wall2, R.drawable.wall2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2,R.drawable.ground2, R.drawable.wall2,
            R.drawable.wall2, R.drawable.wall2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2,R.drawable.ground2, R.drawable.wall2,
            R.drawable.wall2, R.drawable.wall2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2,R.drawable.ground2, R.drawable.wall2,
            R.drawable.wall2, R.drawable.wall2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2,R.drawable.ground2, R.drawable.wall2,
            R.drawable.wall2, R.drawable.wall2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2,R.drawable.ground2, R.drawable.wall2,
            R.drawable.wall2, R.drawable.wall2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2,R.drawable.ground2, R.drawable.wall2,
            R.drawable.wall2, R.drawable.wall2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2,R.drawable.ground2, R.drawable.wall2,
            R.drawable.wall2, R.drawable.wall2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2,R.drawable.ground2, R.drawable.wall2,
            R.drawable.wall2, R.drawable.wall2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2,R.drawable.ground2, R.drawable.wall2,
            R.drawable.wall2, R.drawable.wall2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2,R.drawable.ground2, R.drawable.wall2,
            R.drawable.wall2, R.drawable.wall2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2,R.drawable.ground2, R.drawable.wall2,
            R.drawable.wall2, R.drawable.wall2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2,R.drawable.ground2, R.drawable.wall2,
            R.drawable.wall2, R.drawable.wall2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.wall2, R.drawable.wall2, R.drawable.wall2,R.drawable.wall2, R.drawable.wall2,
            R.drawable.wall2, R.drawable.wall2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.wall2, R.drawable.ground2, R.drawable.ground2,R.drawable.ground2, R.drawable.ground2,
            R.drawable.wall2, R.drawable.wall2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.wall2, R.drawable.ground2, R.drawable.ground2,R.drawable.ground2, R.drawable.ground2,
            R.drawable.wall2, R.drawable.wall2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.wall2, R.drawable.ground2, R.drawable.ground2,R.drawable.ground2, R.drawable.ground2,
            R.drawable.wall2, R.drawable.wall2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.wall2, R.drawable.wall2, R.drawable.wall2,R.drawable.wall2, R.drawable.wall2,
            R.drawable.wall2, R.drawable.wall2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2,R.drawable.ground2, R.drawable.wall2,
            R.drawable.wall2, R.drawable.wall2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2,R.drawable.ground2, R.drawable.wall2,
            R.drawable.wall2, R.drawable.wall2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2,R.drawable.ground2, R.drawable.wall2,
            R.drawable.wall2, R.drawable.wall2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2,R.drawable.ground2, R.drawable.wall2,
            R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.wall2, R.drawable.wall2, R.drawable.wall2, R.drawable.wall2, R.drawable.wall2, R.drawable.wall2, R.drawable.wall2, R.drawable.wall2,R.drawable.wall2, R.drawable.wall2,
            R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.wall2, R.drawable.wall2, R.drawable.wall2, R.drawable.wall2, R.drawable.wall2, R.drawable.wall2, R.drawable.wall2, R.drawable.wall2,R.drawable.wall2, R.drawable.wall2
    };

    //first map
    public int[] mapOne = {
            R.drawable.wall2, R.drawable.wall2, R.drawable.wall2, R.drawable.wall2, R.drawable.wall2, R.drawable.wall2, R.drawable.wall2, R.drawable.wall2, R.drawable.wall2, R.drawable.wall2, R.drawable.wall2, R.drawable.wall2, R.drawable.wall2,
            R.drawable.wall2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2,R.drawable.ground2, R.drawable.wall2,
            R.drawable.wall2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2,R.drawable.ground2, R.drawable.wall2,
            R.drawable.wall2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2,R.drawable.ground2, R.drawable.wall2,
            R.drawable.ground2, R.drawable.wall2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2,R.drawable.ground2, R.drawable.wall2,
            R.drawable.ground2, R.drawable.wall2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2,R.drawable.ground2, R.drawable.wall2,
            R.drawable.ground2, R.drawable.wall2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2,R.drawable.ground2, R.drawable.wall2,
            R.drawable.ground2, R.drawable.wall2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2,R.drawable.ground2, R.drawable.wall2,
            R.drawable.ground2, R.drawable.wall2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2,R.drawable.ground2, R.drawable.wall2,
            R.drawable.ground2, R.drawable.wall2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2,R.drawable.ground2, R.drawable.wall2,
            R.drawable.ground2, R.drawable.wall2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2,R.drawable.ground2, R.drawable.wall2,
            R.drawable.ground2, R.drawable.wall2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2,R.drawable.ground2, R.drawable.wall2,
            R.drawable.ground2, R.drawable.wall2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2,R.drawable.ground2, R.drawable.wall2,
            R.drawable.ground2, R.drawable.wall2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2,R.drawable.ground2, R.drawable.wall2,
            R.drawable.ground2, R.drawable.wall2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2,R.drawable.ground2, R.drawable.wall2,
            R.drawable.ground2, R.drawable.wall2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2,R.drawable.ground2, R.drawable.wall2,
            R.drawable.ground2, R.drawable.wall2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2,R.drawable.ground2, R.drawable.wall2,
            R.drawable.ground2, R.drawable.wall2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2,R.drawable.ground2, R.drawable.wall2,
            R.drawable.ground2, R.drawable.wall2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2,R.drawable.ground2, R.drawable.wall2,
            R.drawable.ground2, R.drawable.wall2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2,R.drawable.ground2, R.drawable.wall2,
            R.drawable.ground2, R.drawable.wall2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2,R.drawable.ground2, R.drawable.wall2,
            R.drawable.ground2, R.drawable.wall2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2,R.drawable.ground2, R.drawable.wall2,
            R.drawable.ground2, R.drawable.wall2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2,R.drawable.ground2, R.drawable.wall2,
            R.drawable.ground2, R.drawable.wall2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2,R.drawable.ground2, R.drawable.wall2,
            R.drawable.ground2, R.drawable.wall2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2,R.drawable.ground2, R.drawable.wall2,
            R.drawable.ground2, R.drawable.wall2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2, R.drawable.ground2,R.drawable.ground2, R.drawable.wall2,
            R.drawable.wall2, R.drawable.wall2, R.drawable.wall2, R.drawable.wall2, R.drawable.wall2, R.drawable.wall2, R.drawable.wall2, R.drawable.wall2, R.drawable.wall2, R.drawable.wall2, R.drawable.wall2,R.drawable.wall2, R.drawable.wall2
    };

    /**
     * gets tiles for all of map
     * @param mapNum number for map
     * @return int[] of map tiles
     */
    public int[] getMapTiles(int mapNum) {
        switch(mapNum) {
            case 0:
                return mapOne;
            case 1:
                return mapTwo;
            case 2:
                return mapThree;
            default:
                return null;
        }
    }

    public Map(Context context, int mapID) {
        this.context = context;
        mapNum = mapID;
    }

    @Override
    public int getCount() {
        return getMapTiles(mapNum).length;
    }

    @Override
    public Object getItem(int i) {
        return getMapTiles(mapNum)[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView imageView = new ImageView(context);
        imageView.setAdjustViewBounds(true);
        imageView.setImageResource(getMapTiles(mapNum)[i]);
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        return imageView;
    }


}
