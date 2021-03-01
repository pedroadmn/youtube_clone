package activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;
import java.util.List;

import adapters.AdapterVideo;
import models.Video;
import pedroadmn.youtubeclone.com.R;

public class MainActivity extends AppCompatActivity implements YouTubePlayer.OnInitializedListener {

    private RecyclerView rvVideos;
    private List<Video> videos = new ArrayList<>();
    private AdapterVideo videoAdapter;
    private YouTubePlayerView youTubePlayerView;
    private static final String GOOGLE_API_KEY = "AIzaSyC71w5ruIWujm7_9nKsbwUDirFHOtBWhT0";
    private MaterialSearchView searchView;

    private YouTubePlayer.PlaybackEventListener playbackEventListener;
    private YouTubePlayer.PlayerStateChangeListener playerStateChangeListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvVideos = findViewById(R.id.rvVideos);
        searchView = findViewById(R.id.search_view);

        getVideos();

        rvVideos.setHasFixedSize(true);
        rvVideos.setLayoutManager(new LinearLayoutManager(this));
        videoAdapter = new AdapterVideo(this, videos);
        rvVideos.setAdapter(videoAdapter);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Youtube Clone");
        setSupportActionBar(toolbar);

        searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        searchView.setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {
            @Override
            public void onSearchViewShown() {

            }

            @Override
            public void onSearchViewClosed() {

            }
        });

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

    private void getVideos() {
        Video video1 = new Video();
        video1.setTitle("Video 1");
        videos.add(video1);

        Video video2 = new Video();
        video2.setTitle("Video 2");
        videos.add(video2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);

        MenuItem menuItem = menu.findItem(R.id.menu_search);
        searchView.setMenuItem(menuItem);
        return true;
    }
}