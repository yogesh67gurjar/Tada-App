package com.example.tadaapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Toast;

import com.example.tadaapp.databinding.ActivityLiveShoppingBinding;

import de.hdodenhof.circleimageview.BuildConfig;

public class LiveShoppingActivity extends AppCompatActivity {
    ActivityLiveShoppingBinding binding;

    AudioManager audioManager;

    static Boolean soundonoff;
    static Boolean likeunlike = false;
    static int currentVolume;
    static int maxVolume;
    static int likecount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityLiveShoppingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();

        binding.recycler1.setLayoutManager (new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true));

        audioManager = (AudioManager) LiveShoppingActivity.this.getSystemService (this.AUDIO_SERVICE);

        currentVolume = audioManager.getStreamVolume (AudioManager.STREAM_MUSIC);
        maxVolume = audioManager.getStreamMaxVolume (AudioManager.STREAM_MUSIC);

        binding.follow.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                if (binding.follow.getText ().toString ().equals ("Follow")) {
                    binding.follow.setText ("Following");
                } else {
                    binding.follow.setText ("Follow");
                }
            }
        });

        binding.name.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent(LiveShoppingActivity.this, SellerProfileActivity.class));
            }
        });

        binding.img.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (LiveShoppingActivity.this, SellerProfileActivity.class));
            }
        });

        binding.backBtn.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (LiveShoppingActivity.this, SeeAllActivity.class));
                finish ();
            }
        });

        binding.like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (likeunlike) {
                    likeunlike = false;
                    binding.like.setImageResource(R.drawable.heart_inactive);
                    likecount = Integer.parseInt(binding.likeCount.getText().toString());
                    likecount--;
                    Log.i("like decrement", "like decrement");
                    binding.likeCount.setText(String.valueOf(likecount));
                } else {
                    likeunlike = true;
                    binding.like.setImageResource(R.drawable.heart_active);
                    likecount = Integer.parseInt(binding.likeCount.getText().toString());
                    likecount++;
                    Log.i("like increment", "like increment");
                    binding.likeCount.setText(String.valueOf(likecount));
                }
            }
        });


        binding.share.setOnClickListener(v -> {
            try {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "my app name");
                String shareMsg = "\nLet me recommend you this application\n\n";
                shareMsg = shareMsg + "https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID + "\n\n";
                shareIntent.putExtra(Intent.EXTRA_TEXT, shareMsg);
                startActivity(Intent.createChooser(shareIntent, "choose any medium"));
            } catch (Exception e) {
                Toast.makeText(LiveShoppingActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
            }
        });


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            if (currentVolume == audioManager.getStreamMinVolume(AudioManager.STREAM_MUSIC)) {
                soundonoff = false;
                binding.soundonoff.setImageResource(R.drawable.sound_off);
            } else {
                soundonoff = true;
                binding.soundonoff.setImageResource(R.drawable.sound_high);
            }
        }

        binding.videoview.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" +
                R.raw.video4));

        binding.soundonoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (soundonoff)// sound on hai
                {
                    audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, 0, 0);
                    soundonoff = false;
                    binding.soundonoff.setImageResource(R.drawable.sound_off);
                } else {
                    audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, currentVolume, 0);
                    soundonoff = true;
                    binding.soundonoff.setImageResource(R.drawable.sound_high);
                }
            }
        });

        binding.videoview.start();

    }
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_VOLUME_UP) {
            currentVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
            binding.soundonoff.setImageResource(R.drawable.sound_high);
        }
        return true;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        currentVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            if (currentVolume - 1 == audioManager.getStreamMinVolume(AudioManager.STREAM_MUSIC)) {
                binding.soundonoff.setImageResource(R.drawable.sound_off);
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}