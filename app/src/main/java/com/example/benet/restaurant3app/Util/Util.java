package com.example.benet.restaurant3app.Util;

import android.app.Activity;

import com.example.benet.restaurant3app.Model.Restaurant;
import com.example.benet.restaurant3app.R;

import java.util.ArrayList;

/**
 * Created by Benet on 21/02/15.
 */
public class Util {


    public static ArrayList<Restaurant> getData(Activity context){
        ArrayList<Restaurant> data=new ArrayList<Restaurant>();
        String [] names=context.getResources().getStringArray(R.array.names_restaurants);
        String [] citys=context.getResources().getStringArray(R.array.citys_restaurants);
        String [] districts=context.getResources().getStringArray(R.array.districts_restaurants);
        String [] urls=context.getResources().getStringArray(R.array.url_restaurants);
        String [] img=context.getResources().getStringArray(R.array.imgs_restaurants);

        for(int i=0; i<names.length; i++){

            data.add(new Restaurant(names[i],citys[i],districts[i],urls[i],
                    context.getResources().getIdentifier(img[i],"mipmap",context.getPackageName())));
        }

        return data;
    }

}
