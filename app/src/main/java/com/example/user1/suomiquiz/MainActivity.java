package com.example.user1.suomiquiz;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    AppCompatButton choiceBtn1,choiceBtn2,choiceBtn3,restartBtn;
    TextView questionNbrTxt,questionText,questionTextKR;
    ImageView logoView;
    private String feedbackText;
    static int questionNbr = 0;
    private static int imageNbr = 0;
    int [] logoViews = {R.drawable.nokia,R.drawable.marimekko,R.drawable.santaclaus,R.drawable.supercell,R.drawable.angrybird};

    public String questions[][]={
            {"What is the Finnish national food?","다음 중 핀란드 음식은 무엇인가요?"},
            {"How many lakes are in Finland?","핀란드에는 호수가 몇개가 있나요?"},
            {"What is the rough population of Finland?","핀란드의 대략적인 인구는 몇명인가요?"},
            {"What is the national bird of Finland?","핀란드의 국조는 무엇인가요?"},
            {"When did Finland declare its independence?","핀란드는 언제 독립을 선언했나요?"},
            {"What is this Finnish brand?","이 핀란드 브랜드는 무엇인가요?"},
            {"What Finnish brand is known for this pattern?","어떤 핀란드 브랜드가 이런 패턴으로 잘 알려져 있나요?"},
            {"Which one is the hometown of Santa Claus?"," 산타클로스의 고향은 어떤 것인가요?"},
            {"Which game has this company published?","이 회사는 어떤 게임을 만들었나요?"},
            {"Which company is behind this animal?","이 동물과 연관된 회사가 무엇인가요?"}
};

    public String [][] choices = new String[][]{
            {"Salmon soup","Carelian Hot Pot","Rye Bread"},
            {"80,000","750,000","190,000"},
            {"Around 12 million","Around 7 million","Around 5 million"},
            {"Whooper swan","Tundra duck","Albino Crow"},
            {"1917","1943","1968"},
            {"Kone","Nokia","Moomin"},
            {"Marimekko","New Yorker","S-Market"},
            {"Helsinki","Rovaniemi","Moscow"},
            {"Overwatch","Angry Birds","Clash of Clans"},
            {"Rovio","Blizzard","Supercell"}
    };
    public String [] answers = {"Rye Bread","190,000","Around 5 million","Whooper swan","1917","Nokia","Marimekko","Rovaniemi","Clash of Clans","Rovio"};
    int score = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logoView = findViewById(R.id.logoImage);
        choiceBtn1 = findViewById(R.id.choiceBtn1);
        choiceBtn2 = findViewById(R.id.choiceBtn2);
        choiceBtn3 = findViewById(R.id.choiceBtn3);
        questionNbrTxt = findViewById(R.id.questionNbr);
        questionText = findViewById(R.id.questionText);
        questionTextKR = findViewById(R.id.questionTextKR);
        restartBtn = findViewById(R.id.restartBtn);
        restartBtn.setVisibility(View.INVISIBLE);
        logoView.setVisibility(View.INVISIBLE);

        nextQuestion();

        choiceBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleButtons(false);
                if(choiceBtn1.getText().toString().equals(answers[questionNbr-1])){
                    score++;
                    choiceBtn1.setTextColor(Color.GREEN);
                } else{
                    choiceBtn1.setTextColor(Color.RED);
                }
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        choiceBtn1.setTextColor(Color.WHITE);
                        nextQuestion();
                    }
                }, 1000);

            }
        });
        choiceBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleButtons(false);
                if(choiceBtn2.getText().toString().equals(answers[questionNbr-1])){
                    score++;
                    choiceBtn2.setTextColor(Color.GREEN);

                } else{
                    choiceBtn2.setTextColor(Color.RED);
                }
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        choiceBtn2.setTextColor(Color.WHITE);
                        nextQuestion();
                    }
                }, 1000);

            }
        });
        choiceBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleButtons(false);
                if(choiceBtn3.getText().toString().equals(answers[questionNbr-1])){
                    score++;
                    choiceBtn3.setTextColor(Color.GREEN);

                } else{
                    choiceBtn3.setTextColor(Color.RED);
                }
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        choiceBtn3.setTextColor(Color.WHITE);
                        nextQuestion();
                    }
                }, 1000);

            }
        });
        restartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                restartQuiz();
            }
        });
    }

    private void restartQuiz() {
        questionNbr = 0;
        score = 0;
        imageNbr = 0;
        nextQuestion();
        choiceBtn1.setVisibility(View.VISIBLE);
        choiceBtn2.setVisibility(View.VISIBLE);
        choiceBtn3.setVisibility(View.VISIBLE);
        restartBtn.setVisibility(View.INVISIBLE);
        questionText.setVisibility(View.VISIBLE);
        questionTextKR.setVisibility(View.VISIBLE);
        logoView.setVisibility(View.INVISIBLE);
    }
    private void toggleButtons(boolean setActive){
        if(setActive == true ){
            choiceBtn1.setEnabled(true);
            choiceBtn2.setEnabled(true);
            choiceBtn3.setEnabled(true);
        } else{
            choiceBtn1.setEnabled(false);
            choiceBtn2.setEnabled(false);
            choiceBtn3.setEnabled(false);
        }
    }

    public void nextQuestion(){
        toggleButtons(true);
        if(questionNbr < questions.length && questionNbr < 5) {
            questionNbrTxt.setText("Question " + (questionNbr+1) + "/" + questions.length);
            questionText.setText(questions[questionNbr][0].toString());
            questionTextKR.setText(questions[questionNbr][1].toString());
            choiceBtn1.setText(choices[questionNbr][0].toString());
            choiceBtn2.setText(choices[questionNbr][1].toString());
            choiceBtn3.setText(choices[questionNbr][2].toString());
            questionNbr++;
        } else if(questionNbr < questions.length){
            questionNbrTxt.setText("Question " + (questionNbr+1)  + "/" + questions.length);
            questionText.setText(questions[questionNbr][0].toString());
            questionTextKR.setText(questions[questionNbr][1].toString());
            choiceBtn1.setText(choices[questionNbr][0].toString());
            choiceBtn2.setText(choices[questionNbr][1].toString());
            choiceBtn3.setText(choices[questionNbr][2].toString());
            if(logoView.getVisibility() == View.INVISIBLE)
            logoView.setVisibility(View.VISIBLE);
            logoView.setImageResource(logoViews[imageNbr]);
            questionNbr++;
            imageNbr++;
        } else{
            showScore();
        }
    }

    private void showScore() {
        if(score < 4) {
            feedbackText = "Better luck next time!";
        } else if(score > 4 && score < 8){
            feedbackText = "Nicely done!";
        } else if(score >= 8){
            feedbackText = "Great job, you're smart!";
        }
        choiceBtn1.setVisibility(View.INVISIBLE);
        choiceBtn2.setVisibility(View.INVISIBLE);
        choiceBtn3.setVisibility(View.INVISIBLE);
        questionNbrTxt.setText("You scored "
                + score
                + " out of "
                + questions.length
                + "."
                + System.getProperty ("line.separator")
                + System.getProperty("line.separator")
                + feedbackText);
        questionTextKR.setVisibility(View.INVISIBLE);
        questionText.setVisibility(View.INVISIBLE);
        logoView.setVisibility(View.INVISIBLE);
        restartBtn.setVisibility(View.VISIBLE);


    }


}
