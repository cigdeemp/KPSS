package com.nexis.kpss_3;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.util.Collections;
import java.util.List;

import javax.xml.transform.Result;

public class Matematik extends AppCompatActivity {
    public TextView questionText, txtTotalQuesText, timeText, coinText, txtCorrect, txtWrong;
    public Button buttonA, buttonB, buttonC, buttonD, buttonE;
    TriviaQuizHelper triviaQuizHelper;
    TriviaQuestion currentQuestion;
    List<TriviaQuestion> list;
    int qid = 0;
    int sizeofQuiz = 5;

    // Update Handlers to use Looper.getMainLooper()
    private final Handler handler = new Handler(android.os.Looper.getMainLooper());
    private final Handler handler2 = new Handler(android.os.Looper.getMainLooper());
    CountDownTimer countDownTimer;
    int timeValue=90;
    int correct=0;
    int wrong = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_quiz);
        questionText = findViewById(R.id.questionText);
        txtTotalQuesText = findViewById(R.id.txtTotalQuesText);

        buttonA = findViewById(R.id.option1);
        buttonB = findViewById(R.id.option2);
        buttonC = findViewById(R.id.option3);
        buttonD = findViewById(R.id.option4);
        buttonE = findViewById(R.id.option5);

        txtCorrect = findViewById(R.id.txtCorrect);
        txtWrong = findViewById(R.id.txtWrong);

        timeText = findViewById(R.id.timeText);
        triviaQuizHelper = new TriviaQuizHelper(this);
        triviaQuizHelper.getReadableDatabase();

        // Fetch only "Türkçe" questions
        list = triviaQuizHelper.getAllQuestions("Matematik");

        if (list.isEmpty()) {
            Log.e("Matematik", "No questions found in the 'Matematik' category!");
            return;
        }

        Collections.shuffle(list);
        currentQuestion = list.get(qid);
        if (list.size() > sizeofQuiz) {
            list = list.subList(0, sizeofQuiz); // Sadece ilk 5 soruyu al
        }
        txtTotalQuesText.setText((qid + 1) + "/" + sizeofQuiz);
        txtCorrect.setText(String.valueOf(correct));

        countDownTimer = new CountDownTimer(90000, 1000) {  // 5000 ms toplam süre, 1000 ms arayla tick
            @Override
            public void onTick(long millisUntilFinished) {
                if (timeValue > 0) {
                    timeText.setText(String.valueOf(timeValue));  // Time text güncelleniyor
                    timeValue -= 1;  // timeValue her tikte azalır
                } else {
                    // Eğer timeValue sıfırsa ve bitmeden önce yapılacak işlemi burada yapalım
                    timeText.setText("0"); // 0'ı gösterelim
                }
            }

            @Override
            public void onFinish() {
                // Süre dolduğunda bir sonraki soruya geçiyoruz
                Toast.makeText(Matematik.this, "Süre doldu", Toast.LENGTH_SHORT).show();

                // Soruyu değiştirmek için SetNewQuestion() metodunu çağır
                if (qid < list.size() - 1) { // Liste sınırını aşmamaya dikkat et
                    SetNewQuestion();
                } else {
                    finalResult(); // Sorular bittiğinde sonucu göster
                }
            }
        }.start();
        updateQueAnsOptions();
    }

    private void correctTextUpdate(int correct){
        txtCorrect.setText(String.valueOf(correct));
    }
    private void wrongTextUpdate(int wrong){
        txtWrong.setText(String.valueOf(wrong));
    }

    public void updateQueAnsOptions() {
        questionText.setText(currentQuestion.getQuestion()); // Display the question
        buttonA.setText(currentQuestion.getOption1()); // Set options to buttons
        buttonB.setText(currentQuestion.getOption2());
        buttonC.setText(currentQuestion.getOption3());
        buttonD.setText(currentQuestion.getOption4());
        buttonE.setText(currentQuestion.getOption5());
        buttonA.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.default_button));
        buttonB.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.default_button));
        buttonC.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.default_button));
        buttonD.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.default_button));
        buttonE.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.default_button));
    }

    private void SetNewQuestion() {
        if (qid < list.size()) {
            currentQuestion = list.get(qid);
            updateQueAnsOptions();

            // Burada soru numarasını da güncelle
            txtTotalQuesText.setText((qid + 1) + "/" + sizeofQuiz);

            if (countDownTimer != null) {
                countDownTimer.cancel();
            }

            timeValue = 90;
            countDownTimer.start();
        } else {
            finalResult();
        }
    }
    public void buttonA(View view) {
        handler.postDelayed(() -> {
            if (currentQuestion.getOption1().equals(currentQuestion.getAnswer_nr())) {
                buttonA.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.green));
                correct++;
                correctTextUpdate(correct);
            } else {
                buttonA.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.red));
                wrong++;
                wrongTextUpdate(wrong);
            }

            handler2.postDelayed(() -> {
                if (qid < list.size() - 1) { // Listenin sınırını aşmasını engelle
                    qid++;
                    SetNewQuestion();
                } else {
                    finalResult();
                }
            }, 200);
        }, 200);
    }

    public void buttonB(View view) {
        handler.postDelayed(() -> {
            if (currentQuestion.getOption2().equals(currentQuestion.getAnswer_nr())) {
                buttonB.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.green));
                correct++;
                correctTextUpdate(correct);
            } else {
                buttonB.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.red));
                wrong++;
                wrongTextUpdate(wrong);
            }

            handler2.postDelayed(() -> {
                if (qid < list.size() - 1) {
                    qid++;
                    SetNewQuestion();
                } else {
                    finalResult();
                }
            }, 200);
        }, 200);
    }

    public void buttonC(View view) {
        handler.postDelayed(() -> {
            if (currentQuestion.getOption3().equals(currentQuestion.getAnswer_nr())) {
                buttonC.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.green));
                correct++;
                correctTextUpdate(correct);
            } else {
                buttonC.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.red));
                wrong++;
                wrongTextUpdate(wrong);
            }

            handler2.postDelayed(() -> {
                if (qid < list.size() - 1) {
                    qid++;
                    SetNewQuestion();
                } else {
                    finalResult();
                }
            }, 200);
        }, 200);
    }

    public void buttonD(View view) {
        handler.postDelayed(() -> {
            if (currentQuestion.getOption4().equals(currentQuestion.getAnswer_nr())) {
                buttonD.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.green));
                correct++;
                correctTextUpdate(correct);
            } else {
                buttonD.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.red));
                wrong++;
                wrongTextUpdate(wrong);
            }

            handler2.postDelayed(() -> {
                if (qid < list.size() - 1) {
                    qid++;
                    SetNewQuestion();
                } else {
                    finalResult();
                }
            }, 200);
        }, 200);
    }

    public void buttonE(View view) {
        handler.postDelayed(() -> {
            if (currentQuestion.getOption5().equals(currentQuestion.getAnswer_nr())) {
                buttonE.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.green));
                correct++;
                correctTextUpdate(correct);
            } else {
                buttonE.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.red));
                wrong++;
                wrongTextUpdate(wrong);
            }

            handler2.postDelayed(() -> {
                if (qid < list.size() - 1) {
                    qid++;
                    SetNewQuestion();
                } else {
                    finalResult();
                }
            }, 200);
        }, 200);
    }

    private int calculateResult(int correct, int totalQuestions) {
        if (totalQuestions == 0) return 0; // Bölme hatasını önlemek için kontrol
        return (correct * 100) / totalQuestions; // Yüzlük sisteme göre hesaplama
    }

    private void finalResult(){
        int result = calculateResult(correct, sizeofQuiz);

        Intent resultIntent = new Intent(Matematik.this,  com.nexis.kpss_3.Result.class);
        resultIntent.putExtra(Constants.TOTAL_QOESTIONS, sizeofQuiz);
        resultIntent.putExtra(Constants.FALSE, wrong);
        resultIntent.putExtra(Constants.CORRECT, correct);
        resultIntent.putExtra("RESULT", result); // Puanı intent ile gönder

        startActivity(resultIntent);
        finish();

    }

}
