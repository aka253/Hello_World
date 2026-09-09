package com.example.hello_world;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button BtnChangeTextColor;
    TextView ChangeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ChangeText = findViewById(R.id.ChangeText);
        BtnChangeTextColor = findViewById(R.id.BtnChangeTextColor);

        BtnChangeTextColor.setOnClickListener(new MyOnClickListener());
    }

    public void BtnChangeText(View view) {
        TextView ChangeText = findViewById(R.id.ChangeText);
        ChangeText.setText(R.string.button_clicked);
    }

    private class MyOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            if (ChangeText != null) {
                ChangeText.setTextColor(Color.RED);
            }
        }
    }
}