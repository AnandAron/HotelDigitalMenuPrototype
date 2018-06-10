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

public class ArticleFrag3 extends Fragment {
    public ArticleFrag3(){

    }

    public static ArticleFrag3 newInstance() {


        return new ArticleFrag3();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_article3, container, false);

        return rootView;
    }
}
