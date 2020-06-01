package com.ylee.a091menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    LinearLayout baseLayout;
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        baseLayout = findViewById(R.id.baseLayout);
        button1 = findViewById(R.id.button1);
        setTitle("91메뉴실습");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu1, menu );
        menu.add(0, 9, 0, "배경색바꿈" );
        SubMenu subMenu = menu.addSubMenu("또다른 버튼변경 ");
        subMenu.add(0, 10, 0, "버튼 글씨조정");
        subMenu.add(0, 11, 0, "버튼 각도조정");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()){
            case R.id.itemRed:
                baseLayout.setBackgroundColor(Color.RED);
                return true;
            case R.id.itemGreen:
                baseLayout.setBackgroundColor(Color.GREEN);
                return true;
            case R.id.subRotate:
                button1.setRotation(45);
                return true;
            case R.id.subSize:
                button1.setScaleX(2);
                return true;
            case R.id.subsubUnrotate:
                button1.setRotation(0);
                return true;
            case R.id.subsubUnsize:
                button1.setScaleX(1);
                return true;
            case 9:
                baseLayout.setBackgroundColor(Color.BLUE);
                return true;
            case 10:
                button1.setTextColor(Color.RED);
                return true;
            case 11:
                button1.setRotation(180);
                return true;
        }
        return false;
    }
}
