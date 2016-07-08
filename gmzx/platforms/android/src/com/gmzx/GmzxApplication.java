package com.gmzx;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.alibaba.sdk.android.AlibabaSDK;
import com.alibaba.sdk.android.callback.InitResultCallback;
import com.alibaba.sdk.android.push.CloudPushService;
import com.alibaba.sdk.android.push.CommonCallback;

public class GmzxApplication extends Application {
	
	// 2015.10.9添加：注意Application类中不应该保存数据，当app出于后台的时候很容易被回收，这个时候再次启动app时，Application里面的值是为空的
    // 这里我就不改了，大家知道就好
    public static int screenW;
    public static int screenH;
	 
    private static final String TAG = "AliyunApp";
    
    @Override
    public void onCreate() {
        super.onCreate();
        
        //在应用启动时初始化AlibabaSDK
        initOneSDK(this);
    }
 
    /**
     * 初始化AlibabaSDK
     * @param applicationContext
     */
    private void initOneSDK(final Context applicationContext) {
        AlibabaSDK.asyncInit(applicationContext, new InitResultCallback() {
 
            @Override
            public void onSuccess() {
                Log.d(TAG, "init onesdk success");
                //alibabaSDK初始化成功后，初始化云推送通道
                initCloudChannel(applicationContext);
            }
 
            @Override
            public void onFailure(int code, String message) {
                Log.e(TAG, "init onesdk failed : " + message);
            }
        });
    }
 
    /**
     * 初始化云推送通道
     * @param applicationContext
     */
    private void initCloudChannel(Context applicationContext) {
        CloudPushService cloudPushService = AlibabaSDK.getService(CloudPushService.class);
        if(cloudPushService != null) {
            cloudPushService.register(applicationContext,  new CommonCallback() {
 
                @Override
                public void onSuccess() {
                    Log.d(TAG, "init cloudchannel success");
                }
 
                @Override
                public void onFailed(String errorCode, String errorMessage) {
                    Log.d(TAG, "init cloudchannel fail" + "err:" + errorCode + " - message:"+ errorMessage);
                }
            });
        }else{
            Log.i(TAG, "CloudPushService is null");
        }
    }
	
}
