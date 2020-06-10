package com.ylee.a12event;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    View view1, view2;
    GestureDetector detector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("이벤트처리 이용희");

        textView = findViewById(R.id.textView);
        view1 = findViewById(R.id.view1);
        view2 = findViewById(R.id.view2);

        view1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                float curX = event.getX();
                float curY = event.getY();
                if(action == MotionEvent.ACTION_DOWN){
                    textView.append("Touch Down " + curX + " , " + curY + "\n");
                } else if(action == MotionEvent.ACTION_MOVE){
                    textView.append("Touch Move " + curX + " , " + curY + "\n");
                } else if(action == MotionEvent.ACTION_UP){
                    textView.append("Touch Up " + curX + " , " + curY + "\n");
                }
                return true;
            }
        });

        detector = new GestureDetector(this, new GestureDetector.OnGestureListener() {
            @Override
            public boolean onDown(MotionEvent e) {
                textView.append("On Down\n");
                return true;
            }

            @Override
            public void onShowPress(MotionEvent e) {
                textView.append("On ShowPress\n");
            }

            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                textView.append("On SingleTapUp\n");
                return true;
            }

            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                textView.append("On Scroll\n");
                return true;
            }

            @Override
            public void onLongPress(MotionEvent e) {
                textView.setText("On LongPress\n");
            }

            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                textView.append("On Fling\n");
                return true;
            }
        });

        view2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                detector.onTouchEvent(event);
                return true;
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        super.onKeyDown(keyCode, event);
        if(keyCode == KeyEvent.KEYCODE_BACK){
            Toast.makeText(this, "SystemBack pressed",
                    Toast.LENGTH_LONG).show();
            return false;  // false 돌아가지 않음
                            // true 메인화면으로 돌아감
        }
        return false;
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){
            Toast.makeText(this, "LANDSCAPE", Toast.LENGTH_LONG).show();
        }else if(newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            Toast.makeText(this, "PORTRAIT", Toast.LENGTH_LONG).show();
        }

    }
}
