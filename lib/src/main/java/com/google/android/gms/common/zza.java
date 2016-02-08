//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.google.android.gms.common;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class zza implements ServiceConnection {
    boolean zzVE = false;
    private final BlockingQueue<IBinder> zzVF = new LinkedBlockingQueue();

    public zza() {
    }

    public void onServiceConnected(ComponentName name, IBinder service) {
        this.zzVF.add(service);
    }

    public void onServiceDisconnected(ComponentName name) {
    }

    public IBinder zzmh() throws InterruptedException {
        if(Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("BlockingServiceConnection.getService() called on main thread");
        } else if(this.zzVE) {
            throw new IllegalStateException();
        } else {
            this.zzVE = true;
            return (IBinder)this.zzVF.take();
        }
    }
}
