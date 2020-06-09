package com.ylee.a101dialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tvName, tvEmail;

    Button button;
    EditText dlgEdtName, dlgEdtEmail;
    View dialogView;
    View toastView;
    TextView toastTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("대화상자실습");
        tvName = findViewById(R.id.tvName);
        tvEmail = findViewById(R.id.tvEmail);
        button = findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogView = View.inflate(MainActivity.this,
                        R.layout.dialog1, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(
                        MainActivity.this);
                dlg.setTitle("사용자정보");
                dlg.setView(dialogView);
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dlgEdtName = dialogView.findViewById(R.id.dlgEdt1);
                        dlgEdtEmail = dialogView.findViewById(R.id.dlgEdt2);
                        String eName = dlgEdtName.getText().toString();
                        String eEmail = dlgEdtEmail.getText().toString();
                        tvName.setText(eName);
                        tvEmail.setText(eEmail);
                    }
                });
                dlg.setNegativeButton("거절", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
//                        Toast.makeText(MainActivity.this,
//                                "거절했습니다", Toast.LENGTH_LONG).show();

                        Toast toast = new Toast(MainActivity.this);
                        toastView = View.inflate(MainActivity.this,
                                R.layout.toast1, null);
                        toastTextView = toastView.findViewById(R.id.toastText1);
                        toastTextView.setText("거절했습니다");
                        toast.setView(toastView);
                        toast.show();
                    }
                });
                dlg.show();
            }
        });
    }
}
