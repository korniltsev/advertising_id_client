//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.ads.identifier.internal.IAdvertisingIdService;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.common.stats.zzb;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class AdvertisingIdClient {
    com.google.android.gms.common.zza zznX;
    IAdvertisingIdService zznY;
    boolean zznZ;
    Object zzoa;
    AdvertisingIdClient.zza zzob;
    private final Context mContext;
    final long zzoc;

    public AdvertisingIdClient(Context context) {
        this(context, 30000L);
    }

    public AdvertisingIdClient(Context context, long timeoutInMillis) {
        this.zzoa = new Object();
        zzu.zzu(context);
        this.mContext = context;
        this.zznZ = false;
        this.zzoc = timeoutInMillis;
    }

    public void start() throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        this.zzb(true);
    }

    protected void zzb(boolean var1) throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        zzu.zzbZ("Calling this from your main thread can lead to deadlock");
        synchronized(this) {
            if(this.zznZ) {
                this.finish();
            }

            this.zznX = zzo(this.mContext);
            this.zznY = zza(this.mContext, this.zznX);
            this.zznZ = true;
            if(var1) {
                this.zzaJ();
            }

        }
    }

    private void zzaJ() {
        Object var1 = this.zzoa;
        synchronized(this.zzoa) {
            if(this.zzob != null) {
                this.zzob.cancel();

                try {
                    this.zzob.join();
                } catch (InterruptedException var4) {
                    ;
                }
            }

            if(this.zzoc > 0L) {
                this.zzob = new AdvertisingIdClient.zza(this, this.zzoc);
            }

        }
    }

    public AdvertisingIdClient.Info getInfo() throws IOException {
        zzu.zzbZ("Calling this from your main thread can lead to deadlock");
        AdvertisingIdClient.Info var1 = null;
        synchronized(this) {
            if(!this.zznZ) {
                Object var3 = this.zzoa;
                synchronized(this.zzoa) {
                    if(this.zzob == null || !this.zzob.zzaK()) {
                        throw new IOException("AdvertisingIdClient is not connected.");
                    }
                }

                try {
                    this.zzb(false);
                } catch (Exception var7) {
                    throw new IOException("AdvertisingIdClient cannot reconnect.", var7);
                }

                if(!this.zznZ) {
                    throw new IOException("AdvertisingIdClient cannot reconnect.");
                }
            }

            zzu.zzu(this.zznX);
            zzu.zzu(this.zznY);

            try {
                var1 = new AdvertisingIdClient.Info(this.zznY.getAdvertisingId(), this.zznY.isAdTrackingLimited(true));
            } catch (RemoteException var6) {
                Log.i("AdvertisingIdClient", "GMS remote exception ", var6);
                throw new IOException("Remote exception");
            }
        }

        this.zzaJ();
        return var1;
    }

    public void finish() {
        zzu.zzbZ("Calling this from your main thread can lead to deadlock");
        synchronized(this) {
            if(this.mContext != null && this.zznX != null) {
                try {
                    if(this.zznZ) {
                        zzb.zzoO().zza(this.mContext, this.zznX);
                    }
                } catch (IllegalArgumentException var4) {
                    Log.i("AdvertisingIdClient", "AdvertisingIdClient unbindService failed.", var4);
                }

                this.zznZ = false;
                this.zznY = null;
                this.zznX = null;
            }
        }
    }

    protected void finalize() throws Throwable {
        this.finish();
        super.finalize();
    }

    static com.google.android.gms.common.zza zzo(Context var0) throws IOException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        try {
            PackageManager var1 = var0.getPackageManager();
            var1.getPackageInfo("com.android.vending", 0);
        } catch (NameNotFoundException var4) {
            throw new GooglePlayServicesNotAvailableException(9);
        }

        try {
            GooglePlayServicesUtil.zzY(var0);
        } catch (GooglePlayServicesNotAvailableException var3) {
            throw new IOException(var3);
        }

        com.google.android.gms.common.zza var5 = new com.google.android.gms.common.zza();
        Intent var2 = new Intent("com.google.android.gms.ads.identifier.service.START");
        var2.setPackage("com.google.android.gms");
        if(zzb.zzoO().zza(var0, var2, var5, 1)) {
            return var5;
        } else {
            throw new IOException("Connection failure");
        }
    }

    public static AdvertisingIdClient.Info getAdvertisingIdInfo(Context context) throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        AdvertisingIdClient var1 = new AdvertisingIdClient(context, -1L);

        AdvertisingIdClient.Info var2;
        try {
            var1.zzb(false);
            var2 = var1.getInfo();
        } finally {
            var1.finish();
        }

        return var2;
    }

    static IAdvertisingIdService zza(Context var0, com.google.android.gms.common.zza var1) throws IOException {
        try {
            return IAdvertisingIdService.Stub.asInterface(var1.zzmh());
        } catch (InterruptedException var3) {
            throw new IOException("Interrupted exception");
        }
    }

    public static final class Info {
        private final String zzoh;
        private final boolean zzoi;

        public Info(String advertisingId, boolean limitAdTrackingEnabled) {
            this.zzoh = advertisingId;
            this.zzoi = limitAdTrackingEnabled;
        }

        public String getId() {
            return this.zzoh;
        }

        public boolean isLimitAdTrackingEnabled() {
            return this.zzoi;
        }

        public String toString() {
            return "{" + this.zzoh + "}" + this.zzoi;
        }
    }

    static class zza extends Thread {
        private WeakReference<AdvertisingIdClient> zzod;
        private long zzoe;
        CountDownLatch zzof;
        boolean zzog;

        public zza(AdvertisingIdClient var1, long var2) {
            this.zzod = new WeakReference(var1);
            this.zzoe = var2;
            this.zzof = new CountDownLatch(1);
            this.zzog = false;
            this.start();
        }

        public void cancel() {
            this.zzof.countDown();
        }

        public boolean zzaK() {
            return this.zzog;
        }

        private void disconnect() {
            AdvertisingIdClient var1 = (AdvertisingIdClient)this.zzod.get();
            if(var1 != null) {
                var1.finish();
                this.zzog = true;
            }

        }

        public void run() {
            try {
                if(!this.zzof.await(this.zzoe, TimeUnit.MILLISECONDS)) {
                    this.disconnect();
                }
            } catch (InterruptedException var2) {
                this.disconnect();
            }

        }
    }
}
