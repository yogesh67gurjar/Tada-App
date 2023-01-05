package com.example.tadaapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.SurfaceView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Switch;
import android.widget.Toast;

import com.example.tadaapp.databinding.ActivityLiveShoppingBinding;

import de.hdodenhof.circleimageview.BuildConfig;
import io.agora.rtc2.ChannelMediaOptions;
import io.agora.rtc2.Constants;
import io.agora.rtc2.IRtcEngineEventHandler;
import io.agora.rtc2.RtcEngine;
import io.agora.rtc2.RtcEngineConfig;
import io.agora.rtc2.video.VideoCanvas;

public class LiveShoppingActivity extends AppCompatActivity {
    ActivityLiveShoppingBinding binding;
    AudioManager audioManager;
    static Boolean soundonoff;
    static Boolean likeunlike = false;
    static int currentVolume;
    static int maxVolume;
    static int likecount;

    //Agora Code
    private final String appId = "4ef6c245464845caab4c5dd52c4bd724";
    // Fill the channel name.
    private String channelName = "Shubham";
    // Fill the temp token generated on Agora Console.
    private String token = "007eJxTYMg3MPtmqn5b7e2BV4bic09kG32+eTbxz3wxlsW3Pa6fOLNCgcEkNc0s2cjE1MTMxMLENDkxMckk2TQlxdQo2SQpxdzIhL1qa3JDICODYfUlVkYGCATx2RmCM0qTMhJzGRgAO7IiUw==";
    // An integer that identifies the local user.
    private int uid = 0;
    private boolean isJoined = false;

    private RtcEngine agoraEngine;
    //SurfaceView to render local video in a Container.
    private SurfaceView localSurfaceView;
    //SurfaceView to render Remote video in a Container.
    private SurfaceView remoteSurfaceView;
    // A toggle switch to change the User role.
    private Switch audienceRole;


    private static final int PERMISSION_REQ_ID = 22;
    private static final String[] REQUESTED_PERMISSIONS =
            {
                    Manifest.permission.RECORD_AUDIO,
                    Manifest.permission.CAMERA
            };

    private boolean checkSelfPermission() {
        if (ContextCompat.checkSelfPermission(this, REQUESTED_PERMISSIONS[0]) != PackageManager.PERMISSION_GRANTED ||
                ContextCompat.checkSelfPermission(this, REQUESTED_PERMISSIONS[1]) != PackageManager.PERMISSION_GRANTED) {
            return false;
        }
        return true;
    }

    void showMessage(String message) {
        runOnUiThread(() ->
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLiveShoppingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();


        audienceRole = (Switch) findViewById(R.id.switch1);
        // If all the permissions are granted, initialize the RtcEngine object and join a channel.
        if (!checkSelfPermission()) {
            ActivityCompat.requestPermissions(this, REQUESTED_PERMISSIONS, PERMISSION_REQ_ID);
        }
        setupVideoSDKEngine();
        joinChannel();
        binding.LeaveButton.setOnClickListener(v -> {
            leaveChannel();
        });

        binding.recycler1.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true));

        audioManager = (AudioManager) LiveShoppingActivity.this.getSystemService(this.AUDIO_SERVICE);

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

        binding.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LiveShoppingActivity.this, SellerProfileActivity.class));
            }
        });

        binding.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LiveShoppingActivity.this, SellerProfileActivity.class));
            }
        });

//        binding.backBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(LiveShoppingActivity.this, SeeAllActivity.class));
//                finish();
//            }
//        });

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

//        binding.videoview.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" +
//                R.raw.video4));

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

//        binding.videoview.start();

    }


    private void setupVideoSDKEngine() {
        try {
            RtcEngineConfig config = new RtcEngineConfig();
            config.mContext = getBaseContext();
            config.mAppId = appId;
            config.mEventHandler = mRtcEventHandler;
            agoraEngine = RtcEngine.create(config);
            // By default, the video module is disabled, call enableVideo to enable it.
            agoraEngine.enableVideo();
        } catch (Exception e) {
            showMessage(e.toString());
        }
    }

    private final IRtcEngineEventHandler mRtcEventHandler = new IRtcEngineEventHandler() {
        @Override
        // Listen for the remote host joining the channel to get the uid of the host.
        public void onUserJoined(int uid, int elapsed) {
            showMessage("Remote user joined " + uid);
            if (!audienceRole.isChecked()) return;
            // Set the remote video view
            runOnUiThread(() -> setupRemoteVideo(uid));
        }

        @Override
        public void onJoinChannelSuccess(String channel, int uid, int elapsed) {
            isJoined = true;
            showMessage("Joined Channel " + channel);
        }

        @Override
        public void onUserOffline(int uid, int reason) {
            showMessage("Remote user offline " + uid + " " + reason);
            runOnUiThread(() -> remoteSurfaceView.setVisibility(View.GONE));
        }
    };

    private void setupRemoteVideo(int uid) {
        FrameLayout container = findViewById(R.id.remote_video_view_container);
        remoteSurfaceView = new SurfaceView(getBaseContext());
        remoteSurfaceView.setZOrderMediaOverlay(true);
        container.addView(remoteSurfaceView);
        agoraEngine.setupRemoteVideo(new VideoCanvas(remoteSurfaceView, VideoCanvas.RENDER_MODE_FIT, uid));
        // Display RemoteSurfaceView.
        remoteSurfaceView.setVisibility(View.VISIBLE);
    }

    private void setupLocalVideo() {
        FrameLayout container = findViewById(R.id.local_video_view_container);
        // Create a SurfaceView object and add it as a child to the FrameLayout.
        localSurfaceView = new SurfaceView(getBaseContext());
        container.addView(localSurfaceView);
        // Pass the SurfaceView object to Agora so that it renders the local video.
        agoraEngine.setupLocalVideo(new VideoCanvas(localSurfaceView, VideoCanvas.RENDER_MODE_HIDDEN, 0));
    }

    public void joinChannel() {
        if (checkSelfPermission()) {
            ChannelMediaOptions options = new ChannelMediaOptions();
            // For Live Streaming, set the channel profile as LIVE_BROADCASTING.
            options.channelProfile = Constants.CHANNEL_PROFILE_LIVE_BROADCASTING;
            // Set the client role as BROADCASTER or AUDIENCE according to the scenario.
            if (audienceRole.isChecked()) { //Audience
                options.clientRoleType = Constants.CLIENT_ROLE_AUDIENCE;
            } else { //Host
                options.clientRoleType = Constants.CLIENT_ROLE_BROADCASTER;
                // Display LocalSurfaceView.
                setupLocalVideo();
                localSurfaceView.setVisibility(View.VISIBLE);
                // Start local preview.
                agoraEngine.startPreview();
            }
            audienceRole.setEnabled(false); // Disable the switch
            // Join the channel with a temp token.
            // You need to specify the user ID yourself, and ensure that it is unique in the channel.
            agoraEngine.joinChannel(token, channelName, uid, options);
        } else {
            Toast.makeText(getApplicationContext(), "Permissions was not granted", Toast.LENGTH_SHORT).show();
        }
    }

    public void leaveChannel() {
        if (!isJoined) {
            showMessage("Join a channel first");
        } else {
            agoraEngine.leaveChannel();
            showMessage("You left the channel");
            // Stop remote video rendering.
            if (remoteSurfaceView != null) remoteSurfaceView.setVisibility(View.GONE);
            // Stop local video rendering.
            if (localSurfaceView != null) localSurfaceView.setVisibility(View.GONE);
            isJoined = false;
            Intent intent = new Intent(getApplicationContext(), DashboardActivity.class);
            startActivity(intent);
            finish();
        }
        audienceRole.setEnabled(true); // Enable the switch
    }

    protected void onDestroy() {
        super.onDestroy();
        agoraEngine.stopPreview();
        agoraEngine.leaveChannel();

        // Destroy the engine in a sub-thread to avoid congestion
        new Thread(() -> {
            RtcEngine.destroy();
            agoraEngine = null;
        }).start();
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