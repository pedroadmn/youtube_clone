package pedroadmn.youtubeclone.com;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class MainActivity extends AppCompatActivity implements YouTubePlayer.OnInitializedListener {

    private YouTubePlayerView youTubePlayerView;
    private static final String GOOGLE_API_KEY = "AIzaSyC71w5ruIWujm7_9nKsbwUDirFHOtBWhT0";

    private YouTubePlayer.PlaybackEventListener playbackEventListener;
    private YouTubePlayer.PlayerStateChangeListener playerStateChangeListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Youtube Clone");
        setSupportActionBar(toolbar);


//        youTubePlayerView = findViewById(R.id.viewYoutubePlayer);

//        youTubePlayerView.initialize(GOOGLE_API_KEY, this);

//        playbackEventListener = new YouTubePlayer.PlaybackEventListener() {
//            @Override
//            public void onPlaying() {
//                Toast.makeText(MainActivity.this, "Executing Video", Toast.LENGTH_LONG).show();
//            }
//
//            @Override
//            public void onPaused() {
//                Toast.makeText(MainActivity.this, "Paused Video", Toast.LENGTH_LONG).show();
//            }
//
//            @Override
//            public void onStopped() {
//                Toast.makeText(MainActivity.this, "Stopped Video", Toast.LENGTH_LONG).show();
//            }
//
//            @Override
//            public void onBuffering(boolean b) {
//                Toast.makeText(MainActivity.this, "Buffering Video", Toast.LENGTH_LONG).show();
//            }
//
//            @Override
//            public void onSeekTo(int i) {
//                Toast.makeText(MainActivity.this, "Seek Video", Toast.LENGTH_LONG).show();
//            }
//        };
//
//        playerStateChangeListener= new YouTubePlayer.PlayerStateChangeListener() {
//            @Override
//            public void onLoading() {
//                Toast.makeText(MainActivity.this, "OnLoading", Toast.LENGTH_LONG).show();
//            }
//
//            @Override
//            public void onLoaded(String s) {
//                Toast.makeText(MainActivity.this, "OnLoaded", Toast.LENGTH_LONG).show();
//            }
//
//            @Override
//            public void onAdStarted() {
//                Toast.makeText(MainActivity.this, "onAdStarted", Toast.LENGTH_LONG).show();
//            }
//
//            @Override
//            public void onVideoStarted() {
//                Toast.makeText(MainActivity.this, "onVideoStarted", Toast.LENGTH_LONG).show();
//            }
//
//            @Override
//            public void onVideoEnded() {
//                Toast.makeText(MainActivity.this, "onVideoEnded", Toast.LENGTH_LONG).show();
//            }
//
//            @Override
//            public void onError(YouTubePlayer.ErrorReason errorReason) {
//                Toast.makeText(MainActivity.this, "onError", Toast.LENGTH_LONG).show();
//            }
//        };
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean wasRestored) {
//        youTubePlayer.loadVideo("byQtPUOXzu4");

//        youTubePlayer.setPlaybackEventListener(playbackEventListener);

        youTubePlayer.setPlayerStateChangeListener(playerStateChangeListener);

        if (!wasRestored) {
//            youTubePlayer.cueVideo("byQtPUOXzu4");
            youTubePlayer.cuePlaylist("PLWz5rJ2EKKc98e0f5ZbsgB63MdjZTFgsy");
        }

        Toast.makeText(this, "Initialized Success", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        Toast.makeText(this, "Initialized Failure: " + youTubeInitializationResult.toString(), Toast.LENGTH_LONG).show();
    }
}