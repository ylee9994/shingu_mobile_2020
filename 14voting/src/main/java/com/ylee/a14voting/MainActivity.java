package com.ylee.a14voting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("좋아하는 그림을 클릭하세요");
        final int voteCount[] = new int[9];
        for(int i=0; i<9; ++i){
            voteCount[i] = 0;
        }
        ImageView image[] = new ImageView[9];
        Integer imageId[] = {R.id.iv1, R.id.iv2, R.id.iv3,
                R.id.iv4, R.id.iv5, R.id.iv6,
                R.id.iv7, R.id.iv8, R.id.iv9};
        final String imgName[] = {"독서하는 소녀", "꽃장식 모자 소녀", "부채를 든 소녀",
                "이레느깡 단 베르양", "잠자는 소녀", "테라스의 두 자매",
                "피아노 레슨", "피아노 앞의 소녀들",  "해변에서" };

        for(int i=0; i<imageId.length; ++i){
            final int index = i;
            image[i] = findViewById(imageId[i]);
            image[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    voteCount[index]++;
                    Toast.makeText(getApplicationContext(),
                            imgName[index] + " 현재 모두 " + voteCount[index] + "표",
                            Toast.LENGTH_LONG).show();
                }
            });
            image[i].setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int currentpic = index;
                    Intent intent = new Intent(getApplicationContext(),
                            OnePicture.class);
                    intent.putExtra("CurrentPictureNum", currentpic);
                    intent.putExtra("ImageName", imgName[currentpic]);
                    startActivity(intent);
                    return true;
                }
            });
        }

        Button button = findViewById(R.id.btnResult);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(),
//                        ResultActivity.class);
                Intent intent = new Intent(getApplicationContext(),
                        ResultPictureActivity.class);
                intent.putExtra("VoteCount", voteCount);
                intent.putExtra("ImageNames", imgName);

                startActivity(intent);
            }
        });


    }
}
