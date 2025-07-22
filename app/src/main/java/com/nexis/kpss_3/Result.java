package com.nexis.kpss_3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Result extends AppCompatActivity {
    private TextView txtTotalQuestionsR, txtCorrectR, txtWrongR, txtResultR;
    private Button btnStartNewQuiz, btnAnaEkran;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result); // Doğru XML dosyasını bağladığından emin ol

        txtTotalQuestionsR = findViewById(R.id.txtTotalQuestionsR);
        txtCorrectR = findViewById(R.id.txtCorrectR);
        txtWrongR = findViewById(R.id.txtWrongR);
        txtResultR = findViewById(R.id.txtResultR);
        btnStartNewQuiz = findViewById(R.id.btnStartNewQuiz);
        btnAnaEkran = findViewById(R.id.btnAnaEkran);

        // Gelen verileri al
        int totalQuestions = getIntent().getIntExtra(Constants.TOTAL_QOESTIONS, 0);
        int correct = getIntent().getIntExtra(Constants.CORRECT, 0);
        int wrong = getIntent().getIntExtra(Constants.FALSE, 0);
        int result = getIntent().getIntExtra("RESULT", 0);

        // TextView'lere gelen verileri yazdır
        txtTotalQuestionsR.setText("TOPLAM: " + totalQuestions);
        txtCorrectR.setText("DOĞRU: " + correct);
        txtWrongR.setText("YANLIŞ: " + wrong);
        txtResultR.setText("PUAN: " + result + "%");

        // "Yeni Sınav" Butonuna Tıklanınca activity_quiz Aç
        btnStartNewQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Result.this, Turkish.class);
                startActivity(intent);
                finish(); // Sonuç ekranını kapat
            }
        });

        // "Ana Ekran" Butonuna Tıklanınca activity_main Aç
        btnAnaEkran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Result.this, MainActivity.class);
                startActivity(intent);
                finish(); // Sonuç ekranını kapat
            }
        });
    }
}

