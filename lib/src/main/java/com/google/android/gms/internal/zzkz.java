//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.google.android.gms.internal;

import android.content.Context;
import java.util.regex.Pattern;

public final class zzkz {
    private static Pattern zzacJ = null;

    public static int zzbN(int var0) {
        return var0 / 1000;
    }

    public static int zzbO(int var0) {
        return var0 % 1000 / 100;
    }

    public static boolean zzbP(int var0) {
        return zzbO(var0) == 3;
    }

    public static boolean zzai(Context var0) {
        return var0.getPackageManager().hasSystemFeature("android.hardware.type.watch");
    }
}
