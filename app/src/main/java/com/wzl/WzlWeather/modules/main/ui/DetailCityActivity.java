package com.wzl.WzlWeather.modules.main.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import butterknife.BindView;
import com.wzl.WzlWeather.R;
import com.wzl.WzlWeather.base.ToolbarActivity;
import com.wzl.WzlWeather.common.IntentKey;
import com.wzl.WzlWeather.modules.main.adapter.WeatherAdapter;
import com.wzl.WzlWeather.modules.main.domain.Weather;

/**
 * Created by wzl
 * Info: 多城市详细页面
 */

public class DetailCityActivity extends ToolbarActivity {

    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerView;

    @Override
    protected int layoutId() {
        return R.layout.activity_detail;
    }

    @Override
    public boolean canBack() {
        return true;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViewWithData();
    }

    private void initViewWithData() {
        Intent intent = getIntent();
        Weather weather = (Weather) intent.getSerializableExtra(IntentKey.WEATHER);
        if (weather == null) {
            finish();
        }
        safeSetTitle(weather.basic.city);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        WeatherAdapter mAdapter = new WeatherAdapter(weather);
        mRecyclerView.setAdapter(mAdapter);
    }

    public static void launch(Context context, Weather weather) {
        Intent intent = new Intent(context, DetailCityActivity.class);
        intent.putExtra(IntentKey.WEATHER, weather);
        context.startActivity(intent);
    }
}
