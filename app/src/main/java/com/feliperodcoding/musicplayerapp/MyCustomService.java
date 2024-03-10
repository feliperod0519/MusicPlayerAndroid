package com.feliperodcoding.musicplayerapp;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.MediaStore;
import android.provider.Settings;

import androidx.annotation.Nullable;

import java.security.Provider;

public class MyCustomService extends Service {

    private MediaPlayer player;


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        this.player = MediaPlayer.create(this, Settings.System.DEFAULT_NOTIFICATION_URI);
        this.player.setLooping(true);
        this.player.start();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.player.stop();
    }
}
