package com.example.atividade2lab2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        Button btnIniciar = findViewById(R.id.btnIniciarServico);
        Button btnParar = findViewById(R.id.btnPararServico);

        if (android.os.Build.VERSION.SDK_INT >= 33) {
            requestPermissions(new String[]{"android.permission.POST_NOTIFICATIONS"}, 1);
        }

        btnIniciar.setOnClickListener(v -> {
            Intent intent = new Intent(this, ForegroundService.class);
            ContextCompat.startForegroundService(this, intent);
        });

        btnParar.setOnClickListener(v -> {
            Intent intent = new Intent(this, ForegroundService.class);
            stopService(intent);
        });
    }
}