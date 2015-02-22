package com.example.benet.restaurant3app.Test;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.benet.restaurant3app.Model.ListItemFragment;
import com.example.benet.restaurant3app.Model.Restaurant;
import com.example.benet.restaurant3app.Model.WebViewFragment;
import com.example.benet.restaurant3app.R;
import com.example.benet.restaurant3app.Util.Util;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity implements ListItemFragment.OnFragmentInteractionListener, WebViewFragment.OnFragmentInteractionListener{
    //TAGS
    public final static String SEND_DATA="send_data";
    public final static String SEND_URL="send_url";
    //
    private ArrayList<Restaurant> data;
    private FragmentTransaction fragmentTransaction;
    private FragmentManager fragmentManager;
    private ListItemFragment listItemFragment;
    private WebViewFragment webViewFragment;
    private Bundle arg;
    private boolean mobile=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponents();

        if(findViewById(R.id.container_mobile)!=null){//this is mobile

            this.fragmentTransaction.add(R.id.container_mobile,listItemFragment);
            this.mobile=true;

        }else{
            Log.e("MAin","tablet");
            this.fragmentTransaction.add(R.id.container_tablet_list,listItemFragment);
            arg.putString(SEND_URL,data.get(0).getUrl());
            this.webViewFragment=new WebViewFragment();
            this.webViewFragment.setArguments(arg);
            this.fragmentTransaction.add(R.id.container_tablet_web,webViewFragment);
        }
    this.fragmentTransaction.commit();
    }

    public void initComponents(){

        this.data= Util.getData(this);
        this.arg=new Bundle();
        arg.putSerializable(SEND_DATA,data);
        this.fragmentManager=getFragmentManager();
        this.fragmentTransaction=this.fragmentManager.beginTransaction();
        this.listItemFragment=new ListItemFragment();
        this.listItemFragment.setArguments(arg);
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteractionWebView(Uri uri) {

    }
    //events to ListItemFragment
    @Override
    public void onFragmentInteractionListItem(int position) {


        this.fragmentTransaction=this.fragmentManager.beginTransaction();
        this.fragmentTransaction.addToBackStack(null);
        webViewFragment=new WebViewFragment();
        this.arg.putString(SEND_URL,data.get(position).getUrl());
        this.webViewFragment.setArguments(arg);

        if(mobile){
            this.fragmentTransaction.replace(R.id.container_mobile,webViewFragment).commit();
        }else{

            this.fragmentTransaction.replace(R.id.container_tablet_web,webViewFragment).commit();
        }

    }

    @Override
    public void onBackPressed() {

        if(getFragmentManager().getBackStackEntryCount()>0){
            getFragmentManager().popBackStack();
        }else {
            super.onBackPressed();
        }

    }
}
