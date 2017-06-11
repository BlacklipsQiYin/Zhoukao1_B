package com.bawei.zhoukao1_b;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * Created by Administrator on 2017/6/11/0011.
 */

public class Three extends Activity {

    private ImageView touxiang3;
    private TextView mingzi3;
    private TextView jianjie3;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.three);


        touxiang3 = (ImageView) findViewById(R.id.touxiang3);
        mingzi3 = (TextView) findViewById(R.id.mingzi3);
        jianjie3 = (TextView) findViewById(R.id.jianjie3);

        Intent intent =  getIntent();

        String s1 = intent.getStringExtra("name");
        String s2 = intent.getStringExtra("text");
        String s3 = intent.getStringExtra("img");

        mingzi3.setText(s1+"的信息");
        jianjie3.setText(s2);
        ImageLoader.getInstance().displayImage(s3, touxiang3);


    }
}
