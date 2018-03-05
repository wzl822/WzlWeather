package com.wzl.WzlWeather.common;

import com.wzl.WzlWeather.BuildConfig;
import com.wzl.WzlWeather.base.BaseApplication;
import java.io.File;

/**
 * Created by wzl
 * Info: 常量类
 */
public class C {

    public static final String API_TOKEN = BuildConfig.FirToken;
    public static final String KEY = BuildConfig.WeatherKey;// Wzl天气 key

    public static final String MULTI_CHECK = "multi_check";

    public static final String ORM_NAME = "cities.db";

    public static final String UNKNOWN_CITY = "unknown city";

    public static final String NET_CACHE = BaseApplication.getAppCacheDir() + File.separator + "NetCache";
}
