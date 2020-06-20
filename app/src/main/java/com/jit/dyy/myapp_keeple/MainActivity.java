package com.jit.dyy.myapp_keeple;


import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.jit.dyy.myapp_keeple.fragment.Figure00Fragment;
import com.jit.dyy.myapp_keeple.fragment.Figure01Fragment;

public class MainActivity extends AppCompatActivity  {

    private ImageView iv_menu;
    private DrawerLayout dl_menu;
    private NavigationView nav_view;
    private FragmentManager fragmentManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

    }
    private void init(){

        iv_menu = findViewById(R.id.iv_menu);
        dl_menu = findViewById(R.id.dl_menu);
        nav_view = findViewById(R.id.nav_view);

        fragmentManager = getSupportFragmentManager();

//        toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        iv_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dl_menu.openDrawer(GravityCompat.START);
            }
        });

        nav_view.setItemIconTintList( null );
        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_home:
                        ShowFigureFragment showFigureFragment = new ShowFigureFragment();
                        fmTransaction(showFigureFragment);
                        break;
                    case R.id.nav_newfigure:
                        Figure00Fragment figure00Fragment = new Figure00Fragment();
                        fmTransaction(figure00Fragment);
                        break;
                    case R.id.nav_showfigure:
                        Figure01Fragment figure01Fragment = new Figure01Fragment();
                        fmTransaction(figure01Fragment);
                        break;
                    default:
                }
                dl_menu.closeDrawers();
                return true;
            }
        });

        //初始化fragment
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        ShowFigureFragment showFigureFragment = new ShowFigureFragment();
        //todo 传值时做
        fragmentTransaction.add(R.id.ll_main,showFigureFragment);
        fragmentTransaction.commit();


    }

    private void fmTransaction(Fragment fragment){
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.ll_main,fragment);
        fragmentTransaction.commit();
    }

}
