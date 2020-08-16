package com.hiy.hiyplayer.camera;

import android.content.Context;
import android.hardware.camera2.CameraManager;

import java.util.Set;

public class Camera2 extends ICamera {

    private Context mContext;

    private CameraManager mCameraManager;

    protected Camera2(Context context, Callback callback, IPreview preview) {
        super(callback, preview);

        mContext = context;

        mCameraManager = (CameraManager) mContext.getSystemService(Context.CAMERA_SERVICE);

        mPreview.setCallback(new IPreview.Callback() {
            @Override
            public void onSurfaceChanged() {
                startCaptureSession();
            }
        });
    }

    private void startCaptureSession() {

    }

    @Override
    boolean start() {
        return false;
    }

    @Override
    void stop() {

    }

    @Override
    boolean isCameraOpened() {
        return false;
    }

    @Override
    void setFacing(int facing) {

    }

    @Override
    int getFacing() {
        return 0;
    }

    @Override
    Set<AspectRatio> getSupportedAspectRatios() {
        return null;
    }

    @Override
    boolean setAspectRatio(AspectRatio ratio) {
        return false;
    }

    @Override
    AspectRatio getAspectRatio() {
        return null;
    }

    @Override
    void setAutoFocus(boolean autoFocus) {

    }

    @Override
    boolean getAutoFocus() {
        return false;
    }

    @Override
    void setFlash(int flash) {

    }

    @Override
    int getFlash() {
        return 0;
    }

    @Override
    void takePicture() {

    }

    @Override
    void setDisplayOrientation(int displayOrientation) {

    }
}
