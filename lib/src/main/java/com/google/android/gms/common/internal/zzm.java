//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.google.android.gms.common.internal;

import android.content.Intent;
import android.net.Uri;

public class zzm {
//    private static final Uri zzaaV = Uri.parse("http://plus.google.com/");
//    private static final Uri zzaaW;

    public static Intent zzce(String var0) {
        Uri var1 = Uri.fromParts("package", var0, (String)null);
        Intent var2 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        var2.setData(var1);
        return var2;
    }

    private static Uri zzcf(String var0) {
        return Uri.parse("market://details").buildUpon().appendQueryParameter("id", var0).build();
    }

    public static Intent zzcg(String var0) {
        Intent var1 = new Intent("android.intent.action.VIEW");
        var1.setData(zzcf(var0));
        var1.setPackage("com.android.vending");
        var1.addFlags(524288);
        return var1;
    }

    public static Intent zznX() {
        Intent var0 = new Intent("com.google.android.clockwork.home.UPDATE_ANDROID_WEAR_ACTION");
        var0.setPackage("com.google.android.wearable.app");
        return var0;
    }

//    static {
//        zzaaW = zzaaV.buildUpon().appendPath("circles").appendPath("find").build();
//    }
}
