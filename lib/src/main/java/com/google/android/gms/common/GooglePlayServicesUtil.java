//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.google.android.gms.common;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageInstaller.SessionInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Build.VERSION;
//import android.support.v4.app.Fragment;
//import android.support.v4.app.FragmentActivity;
//import android.support.v4.app.FragmentManager;
import android.util.Log;
//import com.google.android.gms.R.drawable;
//import com.google.android.gms.R.string;
//import com.google.android.gms.common.ConnectionResult;
//import com.google.android.gms.common.ErrorDialogFragment;
//import com.google.android.gms.common.SupportErrorDialogFragment;
import com.google.android.gms.common.internal.zzd;
//import com.google.android.gms.common.internal.zzf;
//import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.internal.zzm;
import com.google.android.gms.common.zzc.zzbk;
import com.google.android.gms.internal.zzkz;
//import com.google.android.gms.internal.zzlk;
import ru.korniltsev.google_play_services_hacks.advertising_id_client.R;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public final class GooglePlayServicesUtil {
    public static final String GMS_ERROR_DIALOG = "GooglePlayServicesErrorDialog";
    @Deprecated
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = zzml();
    @Deprecated
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
    public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";
    public static boolean zzVS = false;
    public static boolean zzVT = false;
    private static int zzVU = -1;
    private static final Object zzoW = new Object();
    private static String zzVV = null;
    private static Integer zzVW = null;
    static final AtomicBoolean zzVX = new AtomicBoolean();

    private GooglePlayServicesUtil() {
    }

    private static int zzml() {
        return 7571000;
    }

//    @Deprecated
//    public static String getErrorString(int errorCode) {
//        return ConnectionResult.getStatusString(errorCode);
//    }

    @Deprecated
    public static int isGooglePlayServicesAvailable(Context context) {
        if(zzd.zzZR) {
            return 0;
        } else {
            PackageManager var1 = context.getPackageManager();

            try {
                Resources var2 = context.getResources();
                var2.getString(R.string.common_google_play_services_unknown_issue);
            } catch (Throwable var10) {
                Log.e("GooglePlayServicesUtil", "The Google Play services resources were not found. Check your project configuration to ensure that the resources are included.");
            }

            if(!"com.google.android.gms".equals(context.getPackageName())) {
                zzaa(context);
            }

            PackageInfo var12;
            try {
                var12 = var1.getPackageInfo("com.google.android.gms", 64);
            } catch (NameNotFoundException var9) {
                Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
                return 1;
            }

            com.google.android.gms.common.zzd var3 = com.google.android.gms.common.zzd.zzmn();
            if(!zzkz.zzbP(var12.versionCode) && !zzkz.zzai(context)) {
                try {
                    PackageInfo var4 = var1.getPackageInfo("com.android.vending", 64);
                    com.google.android.gms.common.zzc.zza var5 = var3.zza(var4, zzbk.zzVR);
                    if(var5 == null) {
                        Log.w("GooglePlayServicesUtil", "Google Play Store signature invalid.");
                        return 9;
                    }

                    if(var3.zza(var12, new com.google.android.gms.common.zzc.zza[]{var5}) == null) {
                        Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
                        return 9;
                    }
                } catch (NameNotFoundException var11) {
                    if(!zzh(context, "com.android.vending")) {
                        Log.w("GooglePlayServicesUtil", "Google Play Store is neither installed nor updating.");
                        return 9;
                    }

                    Log.w("GooglePlayServicesUtil", "Google Play Store is updating.");
                    if(var3.zza(var12, zzbk.zzVR) == null) {
                        Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
                        return 9;
                    }
                }
            } else if(var3.zza(var12, zzbk.zzVR) == null) {
                Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
                return 9;
            }

            int var13 = zzkz.zzbN(GOOGLE_PLAY_SERVICES_VERSION_CODE);
            int var14 = zzkz.zzbN(var12.versionCode);
            if(var14 < var13) {
                Log.w("GooglePlayServicesUtil", "Google Play services out of date.  Requires " + GOOGLE_PLAY_SERVICES_VERSION_CODE + " but found " + var12.versionCode);
                return 2;
            } else {
                ApplicationInfo var6 = var12.applicationInfo;
                if(var6 == null) {
                    try {
                        var6 = var1.getApplicationInfo("com.google.android.gms", 0);
                    } catch (NameNotFoundException var8) {
                        Log.wtf("GooglePlayServicesUtil", "Google Play services missing when getting application info.");
                        var8.printStackTrace();
                        return 1;
                    }
                }

                return !var6.enabled?3:0;
            }
        }
    }

    @Deprecated
    public static void zzY(Context var0) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
        int var1 = isGooglePlayServicesAvailable(var0);
        if(var1 != 0) {
            Intent var2 = zzaT(var1);
            Log.e("GooglePlayServicesUtil", "GooglePlayServices not available due to error " + var1);
            if(var2 == null) {
                throw new GooglePlayServicesNotAvailableException(var1);
            } else {
                throw new GooglePlayServicesRepairableException(var1, "Google Play Services not available", var2);
            }
        }
    }

    private static void zzaa(Context var0) {
        Object var2 = zzoW;
        Integer var1;
        synchronized(zzoW) {
            if(zzVV == null) {
                zzVV = var0.getPackageName();

                try {
                    ApplicationInfo var3 = var0.getPackageManager().getApplicationInfo(var0.getPackageName(), 128);
                    Bundle var4 = var3.metaData;
                    if(var4 != null) {
                        zzVW = Integer.valueOf(var4.getInt("com.google.android.gms.version"));
                    } else {
                        zzVW = null;
                    }
                } catch (NameNotFoundException var6) {
                    Log.wtf("GooglePlayServicesUtil", "This should never happen.", var6);
                }
            } else if(!zzVV.equals(var0.getPackageName())) {
                throw new IllegalArgumentException("isGooglePlayServicesAvailable should only be called with Context from your application\'s package. A previous call used package \'" + zzVV + "\' and this call used package \'" + var0.getPackageName() + "\'.");
            }

            var1 = zzVW;
        }

        if(var1 == null) {
            throw new IllegalStateException("A required meta-data tag in your app\'s AndroidManifest.xml does not exist.  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
        } else if(var1.intValue() != GOOGLE_PLAY_SERVICES_VERSION_CODE) {
            throw new IllegalStateException("The meta-data tag in your app\'s AndroidManifest.xml does not have the right value.  Expected " + GOOGLE_PLAY_SERVICES_VERSION_CODE + " but" + " found " + var1 + ".  You must have the" + " following declaration within the <application> element: " + "    <meta-data android:name=\"" + "com.google.android.gms.version" + "\" android:value=\"@integer/google_play_services_version\" />");
        }
    }

//    public static boolean zzd(Context var0, int var1) {
//        return zza(var0, var1, "com.google.android.gms") && zzb(var0.getPackageManager(), "com.google.android.gms");
//    }

//    public static boolean zza(Context var0, int var1, String var2) {
//        if(zzlk.zzoX()) {
//            AppOpsManager var7 = (AppOpsManager)var0.getSystemService("appops");
//
//            try {
//                var7.checkPackage(var1, var2);
//                return true;
//            } catch (SecurityException var6) {
//                return false;
//            }
//        } else {
//            PackageManager var3 = var0.getPackageManager();
//            String[] var4 = var3.getPackagesForUid(var1);
//            if(var2 != null && var4 != null) {
//                for(int var5 = 0; var5 < var4.length; ++var5) {
//                    if(var2.equals(var4[var5])) {
//                        return true;
//                    }
//                }
//            }
//
//            return false;
//        }
//    }

//    @Deprecated
//    public static boolean zzb(PackageManager var0, String var1) {
//        return com.google.android.gms.common.zzd.zzmn().zzb(var0, var1);
//    }

    @Deprecated
    public static Intent zzaT(int var0) {
        switch(var0) {
        case 1:
        case 2:
            return zzm.zzcg("com.google.android.gms");
        case 3:
            return zzm.zzce("com.google.android.gms");
        case 42:
            return zzm.zznX();
        default:
            return null;
        }
    }

//    public static boolean zzmm() {
//        return zzVS?zzVT:"user".equals(Build.TYPE);
//    }

//    public static boolean zzb(PackageManager var0) {
//        Object var1 = zzoW;
//        synchronized(zzoW) {
//            if(zzVU == -1) {
//                try {
//                    PackageInfo var2 = var0.getPackageInfo("com.google.android.gms", 64);
//                    if(com.google.android.gms.common.zzd.zzmn().zza(var2, new com.google.android.gms.common.zzc.zza[]{zzc.zzVK[1]}) != null) {
//                        zzVU = 1;
//                    } else {
//                        zzVU = 0;
//                    }
//                } catch (NameNotFoundException var4) {
//                    zzVU = 0;
//                }
//            }
//        }
//
//        return zzVU != 0;
//    }

//    public static boolean zzc(PackageManager var0) {
//        return zzb(var0) || !zzmm();
//    }

//    private static boolean zzaU(int var0) {
//        switch(var0) {
//        case 1:
//        case 2:
//        case 3:
//        case 18:
//        case 42:
//            return true;
//        default:
//            return false;
//        }
//    }

//    @Deprecated
//    public static PendingIntent getErrorPendingIntent(int errorCode, Context context, int requestCode) {
//        Intent var3 = zzaT(errorCode);
//        return var3 == null?null:PendingIntent.getActivity(context, requestCode, var3, 268435456);
//    }
//
//    @Deprecated
//    public static Dialog getErrorDialog(int errorCode, Activity activity, int requestCode) {
//        return getErrorDialog(errorCode, activity, requestCode, (OnCancelListener)null);
//    }
//
//    @Deprecated
//    public static Dialog getErrorDialog(int errorCode, Activity activity, int requestCode, OnCancelListener cancelListener) {
//        return zza(errorCode, activity, (Fragment)null, requestCode, cancelListener);
//    }

//    private static Dialog zza(int var0, Activity var1, Fragment var2, int var3, OnCancelListener var4) {
//        if(var0 == 0) {
//            return null;
//        } else {
//            if(zzkz.zzai(var1) && var0 == 2) {
//                var0 = 42;
//            }
//
//            Builder var5 = null;
//            if(zzlk.zzoU()) {
//                TypedValue var6 = new TypedValue();
//                var1.getTheme().resolveAttribute(16843529, var6, true);
//                String var7 = var1.getResources().getResourceEntryName(var6.resourceId);
//                if("Theme.Dialog.Alert".equals(var7)) {
//                    var5 = new Builder(var1, 5);
//                }
//            }
//
//            if(var5 == null) {
//                var5 = new Builder(var1);
//            }
//
//            String var11 = zzad(var1);
//            var5.setMessage(zzf.zzb(var1, var0, var11));
//            if(var4 != null) {
//                var5.setOnCancelListener(var4);
//            }
//
//            Intent var12 = zzaT(var0);
//            zzg var8;
//            if(var2 == null) {
//                var8 = new zzg(var1, var12, var3);
//            } else {
//                var8 = new zzg(var2, var12, var3);
//            }
//
//            String var9 = zzf.zzh(var1, var0);
//            if(var9 != null) {
//                var5.setPositiveButton(var9, var8);
//            }
//
//            String var10 = zzf.zzg(var1, var0);
//            if(var10 != null) {
//                var5.setTitle(var10);
//            }
//
//            return var5.create();
//        }
//    }
//
//    @Deprecated
//    public static boolean showErrorDialogFragment(int errorCode, Activity activity, int requestCode, OnCancelListener cancelListener) {
//        return showErrorDialogFragment(errorCode, activity, (Fragment)null, requestCode, cancelListener);
//    }
//
//    public static boolean showErrorDialogFragment(int errorCode, Activity activity, Fragment fragment, int requestCode, OnCancelListener cancelListener) {
//        Dialog var6 = zza(errorCode, activity, fragment, requestCode, cancelListener);
//        if(var6 == null) {
//            return false;
//        } else {
//            boolean var5;
//            try {
//                var5 = activity instanceof FragmentActivity;
//            } catch (NoClassDefFoundError var9) {
//                var5 = false;
//            }
//
//            if(var5) {
//                FragmentManager var7 = ((FragmentActivity)activity).getSupportFragmentManager();
//                SupportErrorDialogFragment var8 = SupportErrorDialogFragment.newInstance(var6, cancelListener);
//                var8.show(var7, "GooglePlayServicesErrorDialog");
//            } else {
//                if(!zzlk.zzoR()) {
//                    throw new RuntimeException("This Activity does not support Fragments.");
//                }
//
//                android.app.FragmentManager var10 = activity.getFragmentManager();
//                ErrorDialogFragment var11 = ErrorDialogFragment.newInstance(var6, cancelListener);
//                var11.show(var10, "GooglePlayServicesErrorDialog");
//            }
//
//            return true;
//        }
//    }

//    @Deprecated
//    public static void showErrorNotification(int errorCode, Context context) {
//        if(zzkz.zzai(context) && errorCode == 2) {
//            errorCode = 42;
//        }
//
//        if(!zze(context, errorCode) && !zzf(context, errorCode)) {
//            zza(errorCode, context);
//        } else {
//            zzab(context);
//        }
//
//    }

//    private static void zzab(Context var0) {
//        GooglePlayServicesUtil.zza var1 = new GooglePlayServicesUtil.zza(var0);
//        var1.sendMessageDelayed(var1.obtainMessage(1), 120000L);
//    }

//    private static void zza(int var0, Context var1) {
//        zza(var0, var1, (String)null);
//    }

//    private static void zza(int var0, Context var1, String var2) {
//        Resources var3 = var1.getResources();
//        String var4 = zzad(var1);
//        String var5 = zzf.zzi(var1, var0);
//        if(var5 == null) {
//            var5 = var3.getString(string.common_google_play_services_notification_ticker);
//        }
//
//        String var6 = zzf.zzc(var1, var0, var4);
//        PendingIntent var8 = getErrorPendingIntent(var0, var1, 0);
//        Notification var7;
//        if(zzkz.zzai(var1)) {
//            zzu.zzU(zzlk.zzoV());
//            android.app.Notification.Builder var9 = (new android.app.Notification.Builder(var1)).setSmallIcon(drawable.common_ic_googleplayservices).setPriority(2).setAutoCancel(true).setStyle((new BigTextStyle()).bigText(var5 + " " + var6)).addAction(drawable.common_full_open_on_phone, var3.getString(string.common_open_on_phone), var8);
//            var7 = var9.build();
//        } else {
//            String var11 = var3.getString(string.common_google_play_services_notification_ticker);
//            if(zzlk.zzoR()) {
//                android.app.Notification.Builder var10 = (new android.app.Notification.Builder(var1)).setSmallIcon(17301642).setContentTitle(var5).setContentText(var6).setContentIntent(var8).setTicker(var11).setAutoCancel(true);
//                if(zzlk.zzoY()) {
//                    var10.setLocalOnly(true);
//                }
//
//                if(zzlk.zzoV()) {
//                    var10.setStyle((new BigTextStyle()).bigText(var6));
//                    var7 = var10.build();
//                } else {
//                    var7 = var10.getNotification();
//                }
//
//                if(VERSION.SDK_INT == 19) {
//                    var7.extras.putBoolean("android.support.localOnly", true);
//                }
//            } else {
//                var7 = new Notification(17301642, var11, System.currentTimeMillis());
//                var7.flags |= 16;
//                var7.setLatestEventInfo(var1, var5, var6, var8);
//            }
//        }
//
//        char var12;
//        if(zzaU(var0)) {
//            var12 = 10436;
//            zzVX.set(false);
//        } else {
//            var12 = '魭';
//        }
//
//        NotificationManager var13 = (NotificationManager)var1.getSystemService("notification");
//        if(var2 != null) {
//            var13.notify(var2, var12, var7);
//        } else {
//            var13.notify(var12, var7);
//        }
//
//    }
//
//    @Deprecated
//    public static void zzac(Context var0) {
//        if(!zzVX.getAndSet(true)) {
//            try {
//                NotificationManager var1 = (NotificationManager)var0.getSystemService("notification");
//                var1.cancel(10436);
//            } catch (SecurityException var2) {
//                ;
//            }
//
//        }
//    }
//
//    @Deprecated
//    public static boolean showErrorDialogFragment(int errorCode, Activity activity, int requestCode) {
//        return showErrorDialogFragment(errorCode, activity, requestCode, (OnCancelListener)null);
//    }
//
//    @Deprecated
//    public static boolean isUserRecoverableError(int errorCode) {
//        switch(errorCode) {
//        case 1:
//        case 2:
//        case 3:
//        case 9:
//            return true;
//        case 4:
//        case 5:
//        case 6:
//        case 7:
//        case 8:
//        default:
//            return false;
//        }
//    }
//
//    @Deprecated
//    public static String getOpenSourceSoftwareLicenseInfo(Context context) {
//        Uri var1 = (new android.net.Uri.Builder()).scheme("android.resource").authority("com.google.android.gms").appendPath("raw").appendPath("oss_notice").build();
//
//        try {
//            InputStream var2 = context.getContentResolver().openInputStream(var1);
//
//            Object var4;
//            try {
//                String var3 = (new Scanner(var2)).useDelimiter("\\A").next();
//                return var3;
//            } catch (NoSuchElementException var9) {
//                var4 = null;
//            } finally {
//                if(var2 != null) {
//                    var2.close();
//                }
//
//            }
//
//            return (String)var4;
//        } catch (Exception var11) {
//            return null;
//        }
//    }
//
//    public static Resources getRemoteResource(Context context) {
//        try {
//            return context.getPackageManager().getResourcesForApplication("com.google.android.gms");
//        } catch (NameNotFoundException var2) {
//            return null;
//        }
//    }
//
//    public static Context getRemoteContext(Context context) {
//        try {
//            return context.createPackageContext("com.google.android.gms", 3);
//        } catch (NameNotFoundException var2) {
//            return null;
//        }
//    }

//    public static String zzad(Context var0) {
//        String var1 = var0.getApplicationInfo().name;
//        if(TextUtils.isEmpty(var1)) {
//            var1 = var0.getPackageName();
//            PackageManager var2 = var0.getApplicationContext().getPackageManager();
//
//            ApplicationInfo var3;
//            try {
//                var3 = var2.getApplicationInfo(var0.getPackageName(), 0);
//            } catch (NameNotFoundException var5) {
//                var3 = null;
//            }
//
//            if(var3 != null) {
//                var1 = var2.getApplicationLabel(var3).toString();
//            }
//        }
//
//        return var1;
//    }
//
//    public static boolean zzae(Context var0) {
//        PackageManager var1 = var0.getPackageManager();
//        return zzlk.zzoZ() && var1.hasSystemFeature("com.google.sidewinder");
//    }
//
//    @Deprecated
//    public static boolean zze(Context var0, int var1) {
//        return var1 == 18?true:(var1 == 1?zzh(var0, "com.google.android.gms"):false);
//    }
//
//    @Deprecated
//    public static boolean zzf(Context var0, int var1) {
//        return var1 == 9?zzh(var0, "com.android.vending"):false;
//    }

    public static boolean zzh(Context var0, String var1) {
        if(VERSION.SDK_INT >= 21) {
            List var2 = var0.getPackageManager().getPackageInstaller().getAllSessions();
            Iterator var3 = var2.iterator();

            while(var3.hasNext()) {
                SessionInfo var4 = (SessionInfo)var3.next();
                if(var1.equals(var4.getAppPackageName())) {
                    return true;
                }
            }
        } else {
            PackageManager var6 = var0.getPackageManager();

            try {
                if(var6.getApplicationInfo(var1, 8192).enabled) {
                    return true;
                }
            } catch (NameNotFoundException var5) {
                ;
            }
        }

        return false;
    }

//    private static class zza extends Handler {
//        private final Context zzqw;
//
//        zza(Context var1) {
//            super(Looper.myLooper() == null?Looper.getMainLooper():Looper.myLooper());
//            this.zzqw = var1.getApplicationContext();
//        }
//
//        public void handleMessage(Message msg) {
//            switch(msg.what) {
//            case 1:
//                int var2 = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.zzqw);
//                if(GooglePlayServicesUtil.isUserRecoverableError(var2)) {
//                    GooglePlayServicesUtil.zza(var2, this.zzqw);
//                }
//                break;
//            default:
//                Log.w("GooglePlayServicesUtil", "Don\'t know how to handle this message: " + msg.what);
//            }
//
//        }
//    }
}
