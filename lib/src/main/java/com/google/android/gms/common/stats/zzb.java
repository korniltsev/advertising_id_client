//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.google.android.gms.common.stats;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.util.Log;
import com.google.android.gms.internal.zzla;

//import com.google.android.gms.common.stats.ConnectionEvent;
//import com.google.android.gms.common.stats.zzd;
//import com.google.android.gms.common.stats.zze;
//import com.google.android.gms.common.stats.zzc.zza;
//import com.google.android.gms.internal.zzla;
//import com.google.android.gms.internal.zzll;

public class zzb {
    private static final Object zzaaJ = new Object();
    private static zzb zzack;
//    private final List<String> zzacl;
//    private final List<String> zzacm;
//    private final List<String> zzacn;
//    private final List<String> zzaco;
//    private static final ComponentName zzacp = new ComponentName("com.google.android.gms", "com.google.android.gms.common.stats.GmsCoreStatsService");
//    private zze zzacq;

    public static zzb zzoO() {
        Object var0 = zzaaJ;
        synchronized(zzaaJ) {
            if(zzack == null) {
                zzack = new zzb();
            }
        }

        return zzack;
    }

    private zzb() {
//        if(this.getLogLevel() == zzd.zzacz) {
//            this.zzacl = Collections.EMPTY_LIST;
//            this.zzacm = Collections.EMPTY_LIST;
//            this.zzacn = Collections.EMPTY_LIST;
//            this.zzaco = Collections.EMPTY_LIST;
//        } else {
//            String var1 = (String)zza.zzacu.get();
//            this.zzacl = var1 == null?Collections.EMPTY_LIST:Arrays.asList(var1.split(","));
//            var1 = (String)zza.zzacv.get();
//            this.zzacm = var1 == null?Collections.EMPTY_LIST:Arrays.asList(var1.split(","));
//            var1 = (String)zza.zzacw.get();
//            this.zzacn = var1 == null?Collections.EMPTY_LIST:Arrays.asList(var1.split(","));
//            var1 = (String)zza.zzacx.get();
//            this.zzaco = var1 == null?Collections.EMPTY_LIST:Arrays.asList(var1.split(","));
//            this.zzacq = new zze(1024, ((Long)zza.zzacy.get()).longValue());
//        }
    }

    private boolean zza(Context var1, Intent var2) {
        ComponentName var3 = var2.getComponent();
        return var3 != null && (!com.google.android.gms.common.internal.zzd.zzZR || !"com.google.android.gms".equals(var3.getPackageName()))? zzla.zzi(var1, var3.getPackageName()):false;
    }

    public boolean zza(Context var1, String var2, Intent var3, ServiceConnection var4, int var5) {
        if(this.zza(var1, var3)) {
            Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
            return false;
        } else {
            this.zza(var1, (ServiceConnection)var4, (String)var2, (Intent)var3, 2);
            return var1.bindService(var3, var4, var5);
        }
    }

    public boolean zza(Context var1, Intent var2, ServiceConnection var3, int var4) {
        return this.zza(var1, var1.getClass().getName(), var2, var3, var4);
    }

    public void zza(Context var1, ServiceConnection var2) {
        this.zza(var1, (ServiceConnection)var2, (String)null, (Intent)null, 1);
        var1.unbindService(var2);
    }

//    public void zza(Context var1, ServiceConnection var2, String var3, Intent var4) {
//        this.zza(var1, (ServiceConnection)var2, (String)var3, (Intent)var4, 3);
//    }
//
//    public void zzb(Context var1, ServiceConnection var2) {
//        this.zza(var1, (ServiceConnection)var2, (String)null, (Intent)null, 4);
//    }

    private void zza(Context var1, ServiceConnection var2, String var3, Intent var4, int var5) {
//        if(com.google.android.gms.common.internal.zzd.zzZR) {
//            String var6 = this.zzb(var2);
//            if(this.zza(var1, var3, var4, var6, var5)) {
//                long var7 = System.currentTimeMillis();
//                String var10 = null;
//                if((this.getLogLevel() & zzd.zzacD) != 0) {
//                    var10 = zzll.zzl(3, 5);
//                }
//
//                long var11 = 0L;
//                if((this.getLogLevel() & zzd.zzacF) != 0) {
//                    var11 = Debug.getNativeHeapAllocatedSize();
//                }
//
//                ConnectionEvent var9;
//                if(var5 != 1 && var5 != 4) {
//                    ServiceInfo var13 = zzb(var1, var4);
//                    var9 = new ConnectionEvent(var7, var5, zzll.zzaj(var1), var3, var13.processName, var13.name, var10, var6, SystemClock.elapsedRealtime(), var11);
//                } else {
//                    var9 = new ConnectionEvent(var7, var5, (String)null, (String)null, (String)null, (String)null, var10, var6, SystemClock.elapsedRealtime(), var11);
//                }
//
//                var1.startService((new Intent()).setComponent(zzacp).putExtra("com.google.android.gms.common.stats.EXTRA_LOG_EVENT", var9));
//            }
//        }
    }

//    private boolean zza(Context var1, String var2, Intent var3, String var4, int var5) {
//        int var6 = this.getLogLevel();
//        if(var6 != zzd.zzacz && this.zzacq != null) {
//            if(var5 != 4 && var5 != 1) {
//                ServiceInfo var7 = zzb(var1, var3);
//                if(var7 == null) {
//                    Log.w("ConnectionTracker", String.format("Client %s made an invalid request %s", new Object[]{var2, var3.toUri(0)}));
//                    return false;
//                } else {
//                    String var8 = zzll.zzaj(var1);
//                    String var9 = var7.processName;
//                    String var10 = var7.name;
//                    if(!this.zzacl.contains(var8) && !this.zzacm.contains(var2) && !this.zzacn.contains(var9) && !this.zzaco.contains(var10) && (!var9.equals(var8) || (var6 & zzd.zzacE) == 0)) {
//                        this.zzacq.zzcp(var4);
//                        return true;
//                    } else {
//                        return false;
//                    }
//                }
//            } else {
//                return this.zzacq.zzcq(var4);
//            }
//        } else {
//            return false;
//        }
//    }

//    private static ServiceInfo zzb(Context var0, Intent var1) {
//        List var2 = var0.getPackageManager().queryIntentServices(var1, 128);
//        if(var2 != null && var2.size() != 0) {
//            if(var2.size() > 1) {
//                Log.w("ConnectionTracker", String.format("Multiple handlers found for this intent: %s\n Stack trace: %s", new Object[]{var1.toUri(0), zzll.zzl(3, 20)}));
//                Iterator var3 = var2.iterator();
//                if(var3.hasNext()) {
//                    ResolveInfo var4 = (ResolveInfo)var3.next();
//                    Log.w("ConnectionTracker", var4.serviceInfo.name);
//                    return null;
//                }
//            }
//
//            return ((ResolveInfo)var2.get(0)).serviceInfo;
//        } else {
//            Log.w("ConnectionTracker", String.format("There are no handler of this intent: %s\n Stack trace: %s", new Object[]{var1.toUri(0), zzll.zzl(3, 20)}));
//            return null;
//        }
//    }

//    private String zzb(ServiceConnection var1) {
//        return String.valueOf(Process.myPid() << 32 | System.identityHashCode(var1));
//    }

//    private int getLogLevel() {
//        try {
//            return zzla.zziW()?((Integer)zza.zzact.get()).intValue():zzd.zzacz;
//        } catch (SecurityException var2) {
//            return zzd.zzacz;
//        }
//    }
}
