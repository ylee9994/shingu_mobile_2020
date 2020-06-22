package com.ylee.a14voting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class OnePicture extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.one_picture);

        Integer imageFileId[] = {R.drawable.pic1, R.drawable.pic2, R.drawable.pic3,
                R.drawable.pic4, R.drawable.pic5, R.drawable.pic6,
                R.drawable.pic7, R.drawable.pic8, R.drawable.pic9};
        Intent intent = getIntent();
        int picindex = intent.getIntExtra("CurrentPictureNum",1 );
        String imgName = intent.getStringExtra("ImageName");
        ImageView imageView = findViewById(R.id.imgSingle);
        imageView.setImageResource(imageFileId[picindex]);
        Toast.makeText(getApplicationContext(), "Title: " + imgName,
                Toast.LENGTH_LONG).show();

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
