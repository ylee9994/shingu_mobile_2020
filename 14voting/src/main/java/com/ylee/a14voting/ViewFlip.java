package com.ylee.a14voting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

import androidx.annotation.Nullable;

public class ViewFlip extends Activity {
    GestureDetector detector;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewflip);

        Intent intent = getIntent();
        int[] voteResult = intent.getIntArrayExtra("VoteCount");
        final String[] imageName = intent.getStringArrayExtra("ImageNames");

        final ViewFlipper viewFlipper;
        viewFlipper = findViewById(R.id.viewFlip);
        viewFlipper.setFlipInterval(1000);
        viewFlipper.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                detector.onTouchEvent(event);
                return true;
            }
        });

         detector = new GestureDetector(getApplicationContext(), new GestureDetector.OnGestureListener() {
            @Override
            public boolean onDown(MotionEvent e) {
                return false;
            }

            @Override
            public void onShowPress(MotionEvent e) {

            }

            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return false;
            }

            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                return false;
            }

            @Override
            public void onLongPress(MotionEvent e) {
                int currentpic;
                currentpic = viewFlipper.getDisplayedChild();
                Intent intent = new Intent(getApplicationContext(),
                        OnePicture.class);
                intent.putExtra("CurrentPictureNum", currentpic);
                intent.putExtra("ImageNames", imageName[currentpic]);
                startActivity(intent);
            }

            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                return false;
            }
        });


        Button btnStart = findViewById(R.id.btnStart);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewFlipper.startFlipping();
            }
        });

        Button btnStop = findViewById(R.id.btnStop);
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewFlipper.stopFlipping();
            }
        });

        Button btnReturn = findViewById(R.id.btntoResult);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
