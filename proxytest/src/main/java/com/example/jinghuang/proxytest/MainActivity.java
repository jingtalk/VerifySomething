package com.example.jinghuang.proxytest;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.jinghuang.proxytest.hook_activity.HookHelper;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(TAG, "onCreate");
        Button btn = new Button(this);
        btn.setText("Go to jing blog");

//        setContentView(R.layout.activity_main);

        setContentView(btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setData(Uri.parse("https://jingtalk.github.io/"));
                getApplicationContext().startActivity(intent);
            }
        });

        TestManager.getInstance().test();
    }

    /**
     * main()->Application:attachBaseContext()->onCreate()->Activity:onCreate()->onStart()->onPostCreate()->onResume()->onPostResume()
     *
     * @param newBase
     */

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);
        HookHelper.attachContext();
        Log.d(TAG, "attachBaseContext");
    }
}
