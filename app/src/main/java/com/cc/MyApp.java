package com.cc;

import android.app.ActivityManager;
import android.app.Application;
import android.content.pm.PackageManager;
import android.os.Process;

import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMOptions;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Auser on 2017/12/21.
 */

public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initHuanXin();
    }

    private void initHuanXin() {
        int pid = Process.myPid();
        String processAppName = getAppName(pid);
        if (processAppName == null || !processAppName.equalsIgnoreCase(this.getPackageName())) {
            return;
        }

        EMOptions options = new EMOptions();
        options.setAcceptInvitationAlways(false);
        options.setAutoTransferMessageAttachments(true);
        options.setAutoDownloadThumbnail(true);
        EMClient.getInstance().init(this, options);
        EMClient.getInstance().setDebugMode(true);
    }

    private String getAppName(int pID) {
        String processName = null;
        ActivityManager am = (ActivityManager) this.getSystemService(ACTIVITY_SERVICE);
        List l = am.getRunningAppProcesses();
        Iterator i = l.iterator();
        PackageManager pm = this.getPackageManager();
        while (i.hasNext()) {
            ActivityManager.RunningAppProcessInfo info = (ActivityManager.RunningAppProcessInfo) (i.next());
            try {
                if (info.pid == pID) {
                    processName = info.processName;
                    return processName;
                }
            } catch (Exception e) {
                // Log.d("Process", "Error>> :"+ e.toString());
            }
        }
        return processName;
    }
}
