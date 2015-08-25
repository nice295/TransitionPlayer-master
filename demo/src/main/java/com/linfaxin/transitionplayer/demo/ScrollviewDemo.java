package com.linfaxin.transitionplayer.demo;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.transitions.everywhere.TransitionManager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.linfaxin.transitionplayer.TransitionPlayer;

/**
 * Created by linfaxin on 2015/8/1.
 * Email: linlinfaxin@163.com
 */
public class ScrollviewDemo extends ActionBarActivity {
    ScrollView scrollView;
    ViewGroup rootView;
    ImageView imageView;
    ViewGroup mSceneRoot;
    //TransitionPlayer transitionPlayer = new TransitionPlayer();
    TransitionPlayer transitionPlayer2 = new TransitionPlayer();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_scrollview);
        rootView = (ViewGroup) findViewById(R.id.rootView);
        scrollView = (ScrollView) findViewById(R.id.scrollView);
        imageView = (ImageView) findViewById(R.id.imageView);
        mSceneRoot = (ViewGroup) findViewById(R.id.sceneRootView);


        /*

        imageView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                imageView.getViewTreeObserver().removeOnPreDrawListener(this);
                //after layout is ok, then change view
                TransitionManager.beginDelayedTransition(mSceneRoot, transitionPlayer);

                imageView.setRotation(360);
                imageView.setRotationX(270);
                imageView.setRotationY(180);
                imageView.setTranslationX(70 * getResources().getDisplayMetrics().density);
                imageView.setScaleX(0.2f);
                imageView.setScaleY(0f);
                imageView.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_bright));
                return false;
            }
        });

        */

        mSceneRoot.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                mSceneRoot.getViewTreeObserver().removeOnPreDrawListener(this);
                //after layout is ok, then change view
                TransitionManager.beginDelayedTransition(rootView, transitionPlayer2);

                mSceneRoot.setScaleY(0.5f);
                return false;
            }
        });

        scrollView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {

            @Override
            public void onScrollChanged() {

                int scrollX = scrollView.getScrollX(); //for horizontalScrollView
                int scrollY = scrollView.getScrollY(); //for verticalScrollView
                //DO SOMETHING WITH THE SCROLL COORDINATES

                Log.e("NICE295", "scrollY: " + scrollY);


                float slideOffset = (float) (scrollY / 164.0f);
                Log.e("NICE295", "slideOffset: " + slideOffset);

                //transitionPlayer.setCurrentFraction(slideOffset);
                transitionPlayer2.setCurrentFraction(slideOffset);

            }
        });

    }
}
