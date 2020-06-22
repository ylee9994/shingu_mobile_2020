package com.ylee.a14voting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class ResultActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        setTitle("투표결과");

        Intent intent = getIntent();
        int[] voteResult = intent.getIntArrayExtra("VoteCount");
        String[] imageName = intent.getStringArrayExtra("ImageNames");

        TextView tv[] = new TextView[9];
        RatingBar rbar[] = new RatingBar[9];
        Integer tvId[] = {R.id.tv1, R.id.tv2, R.id.tv3,
                R.id.tv4, R.id.tv5, R.id.tv6,
                R.id.tv7, R.id.tv8, R.id.tv9};
        Integer rbarId[] = {R.id.rbar1, R.id.rbar2, R.id.rbar3,
                R.id.rbar4, R.id.rbar5, R.id.rbar6,
                R.id.rbar7, R.id.rbar8, R.id.rbar9};

        for(int i=0; i<9; ++i){
            tv[i] = findViewById(tvId[i]);
            rbar[i]= findViewById(rbarId[i]);
            tv[i].setText(imageName[i]);
            rbar[i].setRating( (float) voteResult[i]);
        }




        Button rbutton = findViewById(R.id.btnReturn);
        rbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
