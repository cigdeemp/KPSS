package com.nexis.kpss_3;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import static androidx.core.content.ContextCompat.startActivity;

public class MainActivity extends AppCompatActivity {

    private TextView upper_title;
    private Button btn_turkce, btn_matematik, btn_tarih, btn_cografya, btn_vatandaslik, btn_guncel, btn_quiz;
    private static final String TAG = "MainActivity";
    TriviaQuizHelper triviaQuizHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            triviaQuizHelper = new TriviaQuizHelper(this);
            triviaQuizHelper.getReadableDatabase();
            Log.d(TAG, "Veritabanı bağlantısı başarılı");
        } catch (Exception e) {
            Log.e(TAG, "Veritabanı bağlantısı sırasında hata: " + e.getMessage(), e);
        }

        upper_title = findViewById(R.id.upper_title);
        btn_turkce = findViewById(R.id.btn_turkce);
        btn_matematik = findViewById(R.id.btn_matematik);
        btn_tarih = findViewById(R.id.btn_tarih);
        btn_cografya = findViewById(R.id.btn_cografya);
        btn_vatandaslik = findViewById(R.id.btn_vatandaslik);
        btn_guncel = findViewById(R.id.btn_guncel);
        btn_quiz = findViewById(R.id.btn_quiz);

        btn_turkce.setOnClickListener(v -> startActivity(new Intent(this, Turkish.class)));
        btn_matematik.setOnClickListener(v -> startActivity(new Intent(this, Matematik.class)));
        btn_tarih.setOnClickListener(v -> startActivity(new Intent(this, History.class)));
        btn_cografya.setOnClickListener(v -> startActivity(new Intent(this, Geography.class)));
        btn_vatandaslik.setOnClickListener(v -> startActivity(new Intent(this, Vatandaslik.class)));
        btn_guncel.setOnClickListener(v -> startActivity(new Intent(this, Guncel.class)));
        btn_quiz.setOnClickListener(v -> startActivity(new Intent(this, QuizActivity.class)));
    }
}
