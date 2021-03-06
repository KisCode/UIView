package com.kiscode.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.kiscode.ui.adapter.PaintDemoAdapter;
import com.kiscode.ui.pojo.TabItem;
import com.kiscode.ui.view.XfermodesView;
import com.kiscode.ui.view.paint.BitmapShaderView;
import com.kiscode.ui.view.paint.BlurMaskFilterView;
import com.kiscode.ui.view.paint.EmbossMaskFilterView;
import com.kiscode.ui.view.paint.LinearGradientShaderView;
import com.kiscode.ui.view.paint.RadialGradientShaderView;
import com.kiscode.ui.view.paint.SweepGradientShaderView;

import static androidx.fragment.app.FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT;

public class PaintDemoActivity extends AppCompatActivity {

    private static final TabItem[] TAB_ITEMS = new TabItem[]{
            new TabItem("XfermodeMode", XfermodesView.class.getName()),
            new TabItem("LinearGradient", LinearGradientShaderView.class.getName()),
            new TabItem("RadialGradient", RadialGradientShaderView.class.getName()),
            new TabItem("SweepGradient", SweepGradientShaderView.class.getName()),
            new TabItem("BitmapShader", BitmapShaderView.class.getName()),
            new TabItem("BlurMaskFilter", BlurMaskFilterView.class.getName()),
            new TabItem("EmbossMaskFilter", EmbossMaskFilterView.class.getName())
    };

    public static void start(Context context) {
        Intent starter = new Intent(context, PaintDemoActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paint_demo);
        setTitle("PaintDemoActivity");

        ViewPager viewPager = findViewById(R.id.viewpager_paint_demo);

        PaintDemoAdapter adapter = new PaintDemoAdapter(getSupportFragmentManager()
                , BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
                ,TAB_ITEMS);
        viewPager.setAdapter(adapter);

        TabLayout tabs = findViewById(R.id.tablayout_paint_demo);
        tabs.setupWithViewPager(viewPager);
    }
}