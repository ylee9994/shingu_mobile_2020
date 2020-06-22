package com.ylee.a14voting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class ResultPictureActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultpicture);
        setTitle("투표결과");

        Intent intent = getIntent();
        final int[] voteResult = intent.getIntArrayExtra("VoteCount");
        final String[] imageName = intent.getStringArrayExtra("ImageNames");

        Integer imageFileId[] = {R.drawable.pic1, R.drawable.pic2, R.drawable.pic3,
                R.drawable.pic4, R.drawable.pic5, R.drawable.pic6,
                R.drawable.pic7, R.drawable.pic8, R.drawable.pic9};
        TextView tvtop = findViewById(R.id.tvTop);
        ImageView ivTop = findViewById(R.id.ivTop);
        int  maxVote = 0;
        for(int i = 1; i<9; ++i){
            if(voteResult[maxVote] < voteResult[i])
                maxVote = i;
        }
        tvtop.setText(imageName[maxVote]);
        ivTop.setImageResource(imageFileId[maxVote]);

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

        Button fbutton = findViewById(R.id.btnFlip);
        fbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),
                        ViewFlip.class);
                intent.putExtra("VoteCount", voteResult);
                intent.putExtra("ImageNames", imageName);
                startActivity(intent);
            }
        });


    }

}
