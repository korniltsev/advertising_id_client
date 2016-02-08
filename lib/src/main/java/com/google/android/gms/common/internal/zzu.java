//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.google.android.gms.common.internal;

import android.os.Looper;
import android.text.TextUtils;

public final class zzu {
    public static <T> T zzu(T var0) {
        if(var0 == null) {
            throw new NullPointerException("null reference");
        } else {
            return var0;
        }
    }

//    public static String zzcj(String var0) {
//        if(TextUtils.isEmpty(var0)) {
//            throw new IllegalArgumentException("Given String is empty or null");
//        } else {
//            return var0;
//        }
//    }
//
//    public static String zzh(String var0, Object var1) {
//        if(TextUtils.isEmpty(var0)) {
//            throw new IllegalArgumentException(String.valueOf(var1));
//        } else {
//            return var0;
//        }
//    }
//
//    public static <T> T zzb(T var0, Object var1) {
//        if(var0 == null) {
//            throw new NullPointerException(String.valueOf(var1));
//        } else {
//            return var0;
//        }
//    }
//
//    public static int zza(int var0, Object var1) {
//        if(var0 == 0) {
//            throw new IllegalArgumentException(String.valueOf(var1));
//        } else {
//            return var0;
//        }
//    }
//
//    public static int zzbw(int var0) {
//        if(var0 == 0) {
//            throw new IllegalArgumentException("Given Integer is zero");
//        } else {
//            return var0;
//        }
//    }
//
//    public static void zzU(boolean var0) {
//        if(!var0) {
//            throw new IllegalStateException();
//        }
//    }
//
//    public static void zza(boolean var0, Object var1) {
//        if(!var0) {
//            throw new IllegalStateException(String.valueOf(var1));
//        }
//    }
//
//    public static void zza(boolean var0, String var1, Object... var2) {
//        if(!var0) {
//            throw new IllegalStateException(String.format(var1, var2));
//        }
//    }

    public static void zzb(boolean var0, Object var1) {
        if(!var0) {
            throw new IllegalArgumentException(String.valueOf(var1));
        }
    }

//    public static void zzb(boolean var0, String var1, Object... var2) {
//        if(!var0) {
//            throw new IllegalArgumentException(String.format(var1, var2));
//        }
//    }
//
//    public static void zzV(boolean var0) {
//        if(!var0) {
//            throw new IllegalArgumentException();
//        }
//    }
//
//    public static void zzbY(String var0) {
//        if(Looper.myLooper() != Looper.getMainLooper()) {
//            throw new IllegalStateException(var0);
//        }
//    }

    public static void zzbZ(String var0) {
        if(Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException(var0);
        }
    }
}
