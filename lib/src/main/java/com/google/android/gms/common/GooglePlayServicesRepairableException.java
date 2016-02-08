//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.google.android.gms.common;

import android.content.Intent;
import com.google.android.gms.common.UserRecoverableException;

public class GooglePlayServicesRepairableException extends UserRecoverableException {
    private final int zzOD;

    GooglePlayServicesRepairableException(int connectionStatusCode, String msg, Intent intent) {
        super(msg, intent);
        this.zzOD = connectionStatusCode;
    }

//    public int getConnectionStatusCode() {
//        return this.zzOD;
//    }
}
