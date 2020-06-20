package com.jit.dyy.myapp_keeple;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jit.dyy.myapp_keeple.adapter.FigureAdapter;
import com.jit.dyy.myapp_keeple.fragment.Figure00Fragment;
import com.jit.dyy.myapp_keeple.fragment.Figure01Fragment;
import com.jit.dyy.myapp_keeple.fragment.Figure02Fragment;
import com.jit.dyy.myapp_keeple.fragment.Figure03Fragment;
import com.jit.dyy.myapp_keeple.fragment.Figure04Fragment;
import com.jit.dyy.myapp_keeple.fragment.Figure05Fragment;

import java.util.ArrayList;
import java.util.List;

public class ShowFigureFragment extends Fragment  {

    private TabLayout tab;
    private ViewPager pager;
    private List<String> titlelist;
    private List<Fragment> fragmentList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_show_figure, container, false);

        init(view);
        return view;
    }


    private void init(View view){

        this.pager = view.findViewById(R.id.pager);
        this.tab = view.findViewById(R.id.tab);

        /*初始化数据*/
        titlelist = new ArrayList<>();
        fragmentList = new ArrayList<>();
        fragmentList.add(new Figure00Fragment());
        fragmentList.add(new Figure01Fragment());
        fragmentList.add(new Figure02Fragment());
        fragmentList.add(new Figure03Fragment());
        fragmentList.add(new Figure04Fragment());
        fragmentList.add(new Figure05Fragment());
        for (int i = 0; i < fragmentList.size() ; i++) {
            titlelist.add(fragmentList.get(i).getClass().getSimpleName());
        }
        /*设置Adapter*/
        pager.setAdapter(new FigureAdapter(getChildFragmentManager(),titlelist,fragmentList));
        /*Tab与ViewPager绑定*/
        tab.setupWithViewPager(pager);


    }
}