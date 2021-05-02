package com.example.whiteboard;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Random;

import me.panavtec.drawableview.DrawableView;
import me.panavtec.drawableview.DrawableViewConfig;

public class MainActivity extends AppCompatActivity {
    Button btnAdd, btnMinus, btnColor, btnUndo;
    DrawableView drawableView;
    private DrawableViewConfig config = new DrawableViewConfig();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {

        drawableView = findViewById(R.id.paintView);
        btnAdd = findViewById(R.id.buttonUp);
        btnMinus = findViewById(R.id.buttonDown);
        btnColor = findViewById(R.id.buttonColor);
        btnUndo = findViewById(R.id.buttonUndo);

        config.setStrokeColor(getResources().getColor(android.R.color.black));
        config.setShowCanvasBounds(true);
        config.setStrokeWidth(20.0f);
        config.setMinZoom(1.0f);
        config.setMaxZoom(3.0f);
        config.setCanvasHeight(1880);
        config.setCanvasWidth(1920);
        drawableView.setConfig(config);

        btnAdd.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                config.setStrokeWidth(config.getStrokeWidth() + 10);
            }
        });
        btnMinus.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                config.setStrokeWidth(config.getStrokeWidth() - 10);
            }
        });
        btnColor.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Random random = new Random();
                config.setStrokeColor(
                        Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256)));
            }
        });
        btnUndo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                drawableView.undo();
            }
        });
    }
}
