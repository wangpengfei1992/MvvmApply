package com.wpf.common_base.utils;

/**
 * Author: feipeng.wang
 * Time:   2022/1/11
 * Description : 权限处理工具类
 */
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;

import androidx.core.content.ContextCompat;

public class PermissionUtils {
    public static int PERMISSION_REQUEST_CODE = 124;

    /**
     * 跳转到系统界面
     */
    public static void openSettings(Context context) {
        Intent intent = new Intent();
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", context.getPackageName(), null));
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }


    /**
     * 多个权限判断是否同意
     *
     * @param permissions 权限请求数组
     */
    private static boolean isCheckSelfPermission = true;

    public static boolean checkSelfPermissions(Context context, String[] permissions) {
        for (String permission : permissions) {
            if (ContextCompat.checkSelfPermission(context, permission) !=
                    PackageManager.PERMISSION_GRANTED) {
                isCheckSelfPermission = false;
            }
        }
        return isCheckSelfPermission;
    }

    /**
     * 单个权限判断是否同意
     *
     * @param permissions 权限请求数组
     */
    public static boolean checkSelfPermission(Context context, String permissions) {
        return checkSelfPermissions(context, new String[]{permissions});
    }

    /**
     * 判断是否需要显示权限解释弹窗
     *
     * @param permissions 权限请求数组
     */
    private static boolean shouldShowRequestPermissionRationale = true;

    public static boolean shouldShowRequestPermissionsRationale(Activity activity, String[] permissions) {
        for (String permission : permissions) {
            if (!activity.shouldShowRequestPermissionRationale(permission)) {
                shouldShowRequestPermissionRationale = false;
            }
        }
        return shouldShowRequestPermissionRationale;
    }

    /**
     * 单个权限判断是否需要显示权限解释弹窗
     *
     * @param permissions 权限请求数组
     */
    public static boolean shouldShowRequestPermissionRationale(Activity activity, String permissions) {
        return shouldShowRequestPermissionsRationale(activity, new String[]{permissions});
    }

    /**
     * 用户为给权限，跳转到App设置界面，弹窗
     */
    public static void showPermissionsSystemAlert(final Activity context,String rationaleMessage) {
        new AlertDialog.Builder(context)
                .setTitle("Permissions required!")
                .setMessage(rationaleMessage)
                .setPositiveButton("GOTO SETTINGS", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        openSettings(context);
                    }
                }).setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                context.finish();
            }
        }).setCancelable(false).show();
    }


    /**
     * 权限解释弹窗
     */
    public static void showPermissionsAlert(final Activity activity, String rationaleMessage, String[] permissions) {
        new AlertDialog.Builder(activity)
                .setTitle("Permissions required!")
                .setMessage(rationaleMessage)
                .setPositiveButton("GOTO SETTINGS", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        activity.requestPermissions(permissions, PERMISSION_REQUEST_CODE);
                    }
                }).setCancelable(false).show();
    }

    /**
     * 请求权限
     */
    public static void requestPermissions(Activity activity, String[] permissions) {
        activity.requestPermissions(permissions, PERMISSION_REQUEST_CODE);
    }
}
