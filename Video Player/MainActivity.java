package com.example.week9;

import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        VideoView videoView = (VideoView) findViewById(R.id.videoView);
        String rpath = "android.resource://"+getPackageName()+"/"+R.raw.anime2;
        videoView.setVideoURI(Uri.parse(rpath));
        videoView.requestFocus();
        videoView.start();
    }
}
