package com.hiy.hiyplayer.page;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.hiy.hiyplayer.OkHttpManager;
import com.hiy.hiyplayer.R;
import com.hiy.hiyplayer.RnFileUtils;
import com.hiy.hiyplayer.StringViewProvider;
import com.zhihu.matisse.Matisse;
import com.zhihu.matisse.MimeType;
import com.zhihu.matisse.engine.impl.GlideEngine;
import com.zhihu.matisse.filter.Filter;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import me.drakeet.multitype.MultiTypeAdapter;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Okio;

@Route(path = "/app/main")
public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    private List<String> mList = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mList.add("上传图片");
        mRecyclerView = findViewById(R.id.rv);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        MultiTypeAdapter adapter = new MultiTypeAdapter(mList);
        adapter.register(String.class, new StringViewProvider() {
            @Override
            public void onViewHolderClick(RecyclerView.ViewHolder holder, int index) {
                onItemClick(mList.get(index));
            }
        });
        mRecyclerView.setAdapter(adapter);


        Glide.with(this).load("").asBitmap().into(new SimpleTarget<Bitmap>() {
            @Override
            public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {

            }
        });
    }


    public void onItemClick(String key) {
        switch (key) {
            case "上传图片":
                Matisse.from(MainActivity.this)
                        .choose(MimeType.ofAll())
                        .countable(true)
                        .maxSelectable(9)
//                        .addFilter()
                        .restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED)
                        .thumbnailScale(0.85f)
                        .imageEngine(new GlideEngine())
//                        .showPreview(false) // Default is `true`
                        .forResult(10001);
                break;
        }

    }


    List<Uri> mSelected;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 10001 && resultCode == RESULT_OK) {
            mSelected = Matisse.obtainResult(data);

            if (mSelected.size() > 0) {
                Uri uri = mSelected.get(0);
                Log.d("file", uri.toString());
                String path = new RnFileUtils(MainActivity.this).getFilePathByUri(uri);
                File file = new File(path);
                if (file.exists()) {
                    apiPostFile(file);
                } else {
                    Toast.makeText(MainActivity.this, "文件不存在" + uri.getPath(), Toast.LENGTH_SHORT).show();
                }


            }
        }
    }


    public void apiPostFile(File file) {
        MediaType mediaType = MediaType.parse("image/jpg");
        RequestBody filebody = MultipartBody.create(mediaType, file);

        RequestBody multipartBody = new MultipartBody.Builder()
                .addFormDataPart("smfile", String.valueOf(System.currentTimeMillis()) + ".png", filebody)
                .setType(MultipartBody.FORM)
                .build();


        Request request = new Request.Builder()
                .url("https://sm.ms/api/v2/upload")
                .addHeader("Authorization", "s3fTe54VUofxew3dDaJiv045Nr7kkZFd")
                .addHeader("content-Type", "multipart/form-data")
                .addHeader("user-agent", new WebView(this).getSettings().getUserAgentString())
                .post(multipartBody)
                .build();

        OkHttpManager.getInstance().getOkHttpClient().newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Log.d("上传图片的结构是：", e.getMessage());
                        Toast.makeText(MainActivity.this, "失败", Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ResponseBody responseBody = response.body();

                        String retStr = null;
                        try {
                            retStr = responseBody.string();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        Toast.makeText(MainActivity.this, "成功", Toast.LENGTH_SHORT).show();
                        Log.d("上传图片的结构是：", retStr);
                    }
                });
            }
        });
    }


}
