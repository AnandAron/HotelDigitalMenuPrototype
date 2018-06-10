package com.hood.red.menudtry2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by malyf on 9/6/18.
 */

public class ArticleFrag1 extends Fragment {
    public ArticleFrag1(){

    }

    public static ArticleFrag1 newInstance() {


        return new ArticleFrag1();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_article1, container, false);

        return rootView;
    }
}
