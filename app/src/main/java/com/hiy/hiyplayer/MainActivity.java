package com.hiy.hiyplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.ConcatenatingMediaSource;
import com.google.android.exoplayer2.source.LoopingMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MergingMediaSource;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.source.SingleSampleMediaSource;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.MimeTypes;

import utils.LogUtils;


public class MainActivity extends AppCompatActivity {

    PlayerView mPlayerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DefaultTrackSelector trackSelector = new DefaultTrackSelector(this);

        DefaultTrackSelector.ParametersBuilder parameters = trackSelector.buildUponParameters().setMaxVideoSizeSd().setPreferredAudioLanguage("deu");
        trackSelector.setParameters(parameters);
//                trackSelector
//                        .buildUponParameters()
//                        .setMaxVideoSizeSd()
//                        .setPreferredAudioLanguage("deu"));

        final SimpleExoPlayer player = new SimpleExoPlayer.Builder(this)
                .setTrackSelector(trackSelector)
                .build();

        mPlayerView = findViewById(R.id.player_view);

        mPlayerView.setPlayer(player);

        String useragent = new WebView(this).getSettings().getUserAgentString();
        DataSource.Factory dataSourceFactory = new DefaultDataSourceFactory(this, useragent);

        String path = "file:///android_asset/video/a.mp4";
        MediaSource videoSource = new ProgressiveMediaSource.Factory(dataSourceFactory).createMediaSource(Uri.parse(path));

        String path2 = "file:///android_asset/video/b.mp4";
        MediaSource videoSource2 = new ProgressiveMediaSource.Factory(dataSourceFactory).createMediaSource(Uri.parse(path2));

        String path3 = "file:///android_asset/video/c.mp4";
        MediaSource videoSource3 = new ProgressiveMediaSource.Factory(dataSourceFactory).createMediaSource(Uri.parse(path3));


        LoopingMediaSource loopingMediaSource = new LoopingMediaSource(videoSource, 2);
//        Format subtitleFormat = Format.createTextSampleFormat("sample", MimeTypes.TEXT_SSA, C.SELECTION_FLAG_DEFAULT, null);
//        String subtitlePath = "file:///android_asset/a.chs.ass";
//        MediaSource subtitleSource = new SingleSampleMediaSource.Factory(dataSourceFactory).createMediaSource(Uri.parse(subtitlePath), subtitleFormat, C.TIME_UNSET);
//        MergingMediaSource mergedSource = new MergingMediaSource(videoSource, subtitleSource);

        ConcatenatingMediaSource concatenatingMediaSource = new ConcatenatingMediaSource(loopingMediaSource, videoSource2, videoSource3);

        player.prepare(concatenatingMediaSource);

        player.addListener(new Player.EventListener() {

            @Override
            public void onPlayerStateChanged(boolean playWhenReady, int playbackState) {
                LogUtils.d("hiyplayer", playWhenReady + " => " + playbackState);

            }

            @Override
            public void onIsPlayingChanged(boolean isPlaying) {

            }

            @Override
            public void onPositionDiscontinuity(int reason) {
                LogUtils.d("hiyplayer", reason + "reason");

                switch (reason) {
                    case Player.DISCONTINUITY_REASON_PERIOD_TRANSITION:
                        break;
                    case Player.DISCONTINUITY_REASON_SEEK:
                        break;
                    case Player.DISCONTINUITY_REASON_SEEK_ADJUSTMENT:
                        break;
                    case Player.DISCONTINUITY_REASON_AD_INSERTION:
                        break;
                    case Player.DISCONTINUITY_REASON_INTERNAL:
                        break;
                }
                LogUtils.d("hiyplayer", (String) player.getCurrentTag());
            }
        });
    }


    @Override
    protected void onResume() {
        super.onResume();
        mPlayerView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mPlayerView.onPause();
    }
}
