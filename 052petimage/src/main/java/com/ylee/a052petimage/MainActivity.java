package com.ylee.a052petimage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textView1, textView2;
    CheckBox chkAgree;
    RadioGroup radioGroup;
    RadioButton rDog, rCat, rrabbit;
    Button btnOK;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("애완동물 선택하기 - 이용희");

        textView1 = findViewById(R.id.text1);
        textView2 = findViewById(R.id.text2);
        chkAgree = findViewById(R.id.chkAgree);
        radioGroup = findViewById(R.id.Rgroup1);
        rDog = findViewById(R.id.Rdog);
        rCat = findViewById(R.id.Rcat);
        rrabbit = findViewById(R.id.Rrabbit);
        btnOK = findViewById(R.id.BtnOK);
        imageView = findViewById(R.id.ImgPet);

        chkAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(chkAgree.isChecked() == true){
                    textView2.setVisibility(View.VISIBLE);
                    radioGroup.setVisibility(View.VISIBLE);
                    btnOK.setVisibility(View.VISIBLE);
                    imageView.setVisibility(View.VISIBLE);
                }else{
                    textView2.setVisibility(View.INVISIBLE);
                    radioGroup.setVisibility(View.INVISIBLE);
                    btnOK.setVisibility(View.INVISIBLE);
                    imageView.setVisibility(View.INVISIBLE);
                }
            }
        });

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch(radioGroup.getCheckedRadioButtonId()){
                    case R.id.Rdog:
                        imageView.setImageResource(R.drawable.cat);
                        rDog.setChecked(false);
                        rCat.setChecked(true);
                        break;
                    case R.id.Rcat:
                        imageView.setImageResource(R.drawable.rabbit);
                        rCat.setChecked(false);
                        rrabbit.setChecked(true);
                        break;
                    case R.id.Rrabbit:
                        imageView.setImageResource(R.drawable.dog);
                        rrabbit.setChecked(false);
                        rDog.setChecked(true);
                        break;
                    default:
                        Toast.makeText(getApplicationContext(),
                                "동물먼저 선택하세요", Toast.LENGTH_LONG).show();
                }
            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(radioGroup.getCheckedRadioButtonId()){
                    case R.id.Rdog:
                        imageView.setImageResource(R.drawable.dog);
                        break;
                    case R.id.Rcat:
                        imageView.setImageResource(R.drawable.cat);
                        break;
                    case R.id.Rrabbit:
                        imageView.setImageResource(R.drawable.rabbit);
                        break;
                    default:
                        Toast.makeText(getApplicationContext(),
                                "동물먼저 선택하세요", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}
