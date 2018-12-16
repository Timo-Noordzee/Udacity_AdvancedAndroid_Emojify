package com.example.android.emojify;

import android.content.Context;
import android.graphics.Bitmap;
import android.nfc.Tag;
import android.util.Log;
import android.util.SparseArray;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.FaceDetector;

public class Emojifier {

    public static final String TAG = "Emojofier";

    public static void detectFaces(Bitmap image, Context context){
        FaceDetector detector = new FaceDetector.Builder(context)
                .setTrackingEnabled(false)
                .setLandmarkType(FaceDetector.ALL_CLASSIFICATIONS)
                .build();

        Frame frame = new Frame.Builder().setBitmap(image).build();
        SparseArray<Face> faces = detector.detect(frame);

        Log.d(TAG, faces.size() + " faces detected!");
    }

}
