package com.example.tadaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.MediaController;
import android.widget.SeekBar;
import android.widget.Toast;

import com.example.tadaapp.databinding.ActivityShoppingVideosBinding;

public class ShoppingVideosActivity extends AppCompatActivity {

    ActivityShoppingVideosBinding binding;

    AudioManager audioManager;

    static Boolean soundonoff;
    static Boolean likeunlike = false;

    static int currentVolume;
    static int maxVolume;
    static int likecount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityShoppingVideosBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();

        audioManager = (AudioManager) ShoppingVideosActivity.this.getSystemService(this.AUDIO_SERVICE);

        currentVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);

        binding.follow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.follow.getText().toString().equals("Follow")) {
                    binding.follow.setText("Following");
                } else {
                    binding.follow.setText("Follow");
                }
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


        binding.share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    shareIntent.setType("text/plain");
                    shareIntent.putExtra(Intent.EXTRA_SUBJECT, "my app name");
                    String shareMsg = "\nLet me recommend you this application\n\n";
                    shareMsg = shareMsg + "https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID + "\n\n";
                    shareIntent.putExtra(Intent.EXTRA_TEXT, shareMsg);
                    startActivity(Intent.createChooser(shareIntent, "choose any medium"));
                } catch (Exception e) {
                    Toast.makeText(ShoppingVideosActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
                }
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
                R.raw.video1));

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
        new VideoPlayAsyncTask().execute();
    }

    private class VideoPlayAsyncTask extends AsyncTask<Void, Integer, Void> {
        int duration = 0;
        int current = 0;

        @Override
        protected Void doInBackground(Void... params) {
            binding.videoview.start();
            binding.videoview.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    duration = binding.videoview.getDuration();
                }
            });

            do {
                current = binding.videoview.getCurrentPosition();

                try {
                    publishProgress((int) (current * 100 / duration));
                    if (binding.progressBar.getProgress() >= 100) {
                        break;
                    }
                } catch (Exception e) {
                }
            } while (binding.progressBar.getProgress() <= 100);

            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            binding.progressBar.setProgress(values[0]);

        }

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
}