//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Process;
import com.google.android.gms.common.internal.zzd;
//import com.google.android.gms.internal.zzkf;

public class zzla {
    public static boolean zzi(Context var0, String var1) {
        PackageManager var2 = var0.getPackageManager();

        try {
            ApplicationInfo var3 = var2.getApplicationInfo(var1, 0);
            return (var3.flags & 2097152) != 0;
        } catch (NameNotFoundException var4) {
            return false;
        }
    }

//    public static boolean zziW() {
//        return zzd.zzZR && zzkf.isInitialized() && zzkf.zzmY() == Process.myUid();
//    }
}
