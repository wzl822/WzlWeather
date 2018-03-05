package com.wzl.WzlWeather.component;

import com.litesuits.orm.LiteOrm;
import com.wzl.WzlWeather.BuildConfig;
import com.wzl.WzlWeather.base.BaseApplication;
import com.wzl.WzlWeather.common.C;

/**
 * Created by wzl
 */
public class OrmLite {

    static LiteOrm sLiteOrm;

    public static LiteOrm getInstance() {
        getOrmHolder();
        return sLiteOrm;
    }

    private static OrmLite getOrmHolder() {
        return OrmHolder.sInstance;
    }

    private OrmLite() {
        if (sLiteOrm == null) {
            sLiteOrm = LiteOrm.newSingleInstance(BaseApplication.getAppContext(), C.ORM_NAME);
        }
        sLiteOrm.setDebugged(BuildConfig.DEBUG);
    }

    private static class OrmHolder {
        private static final OrmLite sInstance = new OrmLite();
    }
}
