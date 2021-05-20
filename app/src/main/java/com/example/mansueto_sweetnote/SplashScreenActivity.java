package com.example.mansueto_sweetnote;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.VideoView;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        getSupportActionBar().hide();


        try {
            VideoView videoHolder = new VideoView(this);
            videoHolder.setBackgroundColor(Color.WHITE);
            setContentView(videoHolder);
            Uri video = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.sweetnote_logo);
            videoHolder.setVideoURI(video);


            videoHolder.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                                                  @Override
                                                  public void onPrepared(MediaPlayer mediaPlayer) {
                                                        videoHolder.setBackgroundColor(Color.TRANSPARENT);
                                                  }
                                              }
            );
            videoHolder.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                public void onCompletion(MediaPlayer mp) {
                    jump();
                }
            });
            videoHolder.start();
        } catch (Exception ex) {
            jump();
        }

    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        jump();
        return true;
    }

    private void jump() {
        if (isFinishing())
            return;
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }

}