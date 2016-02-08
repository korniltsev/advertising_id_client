//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.google.android.gms.common;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.zzc;
import com.google.android.gms.common.zzc.zza;
import com.google.android.gms.common.zzc.zzb;
import java.util.Set;

public class zzd {
    private static final zzd zzVY = new zzd();

    private zzd() {
    }

    public static zzd zzmn() {
        return zzVY;
    }

//    public boolean zzb(PackageManager var1, String var2) {
//        PackageInfo var3;
//        try {
//            var3 = var1.getPackageInfo(var2, 64);
//        } catch (NameNotFoundException var5) {
//            if(Log.isLoggable("GoogleSignatureVerifier", 3)) {
//                Log.d("GoogleSignatureVerifier", "Package manager can\'t find package " + var2 + ", defaulting to false");
//            }
//
//            return false;
//        }
//
//        return this.zza(var1, var3);
//    }

//    public boolean zza(PackageManager var1, PackageInfo var2) {
//        if(var2 == null) {
//            return false;
//        } else if(GooglePlayServicesUtil.zzc(var1)) {
//            return this.zza(var2, true);
//        } else {
//            boolean var3 = this.zza(var2, false);
//            if(!var3 && this.zza(var2, true)) {
//                Log.w("GoogleSignatureVerifier", "Test-keys aren\'t accepted on this build.");
//            }
//
//            return var3;
//        }
//    }

//    private boolean zza(PackageInfo var1, boolean var2) {
//        if(var1.signatures.length != 1) {
//            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
//            return false;
//        } else {
//            zzb var3 = new zzb(var1.signatures[0].toByteArray());
//            Set var4;
//            if(var2) {
//                var4 = zzc.zzmi();
//            } else {
//                var4 = zzc.zzmj();
//            }
//
//            if(var4.contains(var3)) {
//                return true;
//            } else {
//                if(Log.isLoggable("GoogleSignatureVerifier", 2)) {
//                    Log.v("GoogleSignatureVerifier", "Signature not valid.  Found: \n" + Base64.encodeToString(var3.getBytes(), 0));
//                }
//
//                return false;
//            }
//        }
//    }

    zza zza(PackageInfo var1, zza... var2) {
        if(var1.signatures.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return null;
        } else {
            zzb var3 = new zzb(var1.signatures[0].toByteArray());

            for(int var4 = 0; var4 < var2.length; ++var4) {
                if(var2[var4].equals(var3)) {
                    return var2[var4];
                }
            }

            if(Log.isLoggable("GoogleSignatureVerifier", 2)) {
                Log.v("GoogleSignatureVerifier", "Signature not valid.  Found: \n" + Base64.encodeToString(var3.getBytes(), 0));
            }

            return null;
        }
    }
}
