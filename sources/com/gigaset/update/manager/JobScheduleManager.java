package com.gigaset.update.manager;

import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import com.gigaset.update.service.CustomActionService;
import com.gigaset.update.utils.LogUtil;
/* loaded from: classes.dex */
public class JobScheduleManager extends JobService {

    /* renamed from: a  reason: collision with root package name */
    private static long f1151a;

    /* renamed from: b  reason: collision with root package name */
    private static long f1152b;
    private static long c;
    private static long d;

    private static void a() {
        String[] j = i.j();
        f1151a = Long.parseLong(j[0]) * 60000;
        f1152b = Long.parseLong(j[1]) * 60000;
        LogUtil.a("change network min time : " + f1151a + ",change network deadline time : " + f1152b);
        String[] i = i.i();
        c = Long.parseLong(i[0]) * 60000;
        d = Long.parseLong(i[1]) * 60000;
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        int jobId = jobParameters.getJobId();
        LogUtil.a("start job id : " + jobId);
        if (jobId == 100) {
            CustomActionService.a(this, 1);
        }
        a(this, jobId);
        return false;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }

    public static void a(Context context, int i) {
        JobScheduler jobScheduler;
        if (Build.VERSION.SDK_INT >= 21 && (jobScheduler = (JobScheduler) context.getSystemService("jobscheduler")) != null) {
            a();
            JobInfo.Builder builder = new JobInfo.Builder(i, new ComponentName(context, JobScheduleManager.class));
            if (i == 100) {
                builder.setMinimumLatency(f1151a);
                builder.setOverrideDeadline(f1152b);
            } else if (i == 101) {
                builder.setMinimumLatency(c);
                builder.setOverrideDeadline(d);
            }
            builder.setPersisted(true);
            builder.setRequiresCharging(false);
            builder.setRequiresDeviceIdle(false);
            builder.setRequiredNetworkType(1);
            if (Build.VERSION.SDK_INT >= 26) {
                builder.setRequiresStorageNotLow(false);
                builder.setRequiresBatteryNotLow(false);
            }
            LogUtil.a("schedule job id : " + i + " ;schedule status : " + jobScheduler.schedule(builder.build()));
        }
    }
}
