package amst.g1.amst_primeraevaluacion_g3_astudillo_sanchez;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

import amst.g1.amst_primeraevaluacion_g3_astudillo_sanchez.models.Answer;
import amst.g1.amst_primeraevaluacion_g3_astudillo_sanchez.models.Question;

public class MainActivity extends AppCompatActivity {

    LinearLayout answerContainer;
    TextView tvQuestion;
    int c = 0;

    Question actualQuestion;

    ArrayList<Question> questions = new ArrayList<>();
    Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buildDB();

        answerContainer = findViewById(R.id.answerContainer);
        tvQuestion = findViewById(R.id.tvQuestion);

        selectNextQuestion();
    }

    private void selectNextQuestion() {
        if (questions.size() == 0) {
            Intent intent = new Intent(getApplicationContext(), WinActivity.class);
            startActivity(intent);
            finish();
        } else {
            answerContainer.removeAllViews();

            int radomIndex = random.nextInt(questions.size());
            actualQuestion = new Question(questions.get(radomIndex));
            questions.remove(radomIndex);

            tvQuestion.setText(actualQuestion.getQuestion());

            for (Answer answer: actualQuestion.getAnswerList()) {
                Button btn = new Button(getApplicationContext());
                btn.setText(answer.getAnswer());
                btn.setTag(answer.isCorrect());
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        checkAnswer(view);
                    }
                });
                answerContainer.addView(btn);
            }
        }
    }

    private void buildDB() {
        ArrayList<Answer> answers1 = new ArrayList<>();
        answers1.add(new Answer("Elsa", true));
        answers1.add(new Answer("Betty", false));
        answers1.add(new Answer("Anita", false));
        answers1.add(new Answer("Olaf", false));
        questions.add(new Question("Como se llama el personaje principal de Frozen?", answers1));

        ArrayList<Answer> answers2 = new ArrayList<>();
        answers2.add(new Answer("Ericka Russo", false));
        answers2.add(new Answer("Eugenio Derbez", false));
        answers2.add(new Answer("Raul Santana", true));
        answers2.add(new Answer("Erika Velez", false));
        questions.add(new Question("Cual es actor principal de dedicada a mi ex?", answers2));

        ArrayList<Answer> answers3 = new ArrayList<>();
        answers3.add(new Answer("15 de Noviembre del 2019", false));
        answers3.add(new Answer("22 de Noviembre del 2019", true));
        answers3.add(new Answer("12 de Noviembre del 2019", false));
        answers3.add(new Answer("25 de Noviembre del 2019", false));
        questions.add(new Question("En que fecha se estreno de Frozen 2?", answers3));

        ArrayList<Answer> answers4 = new ArrayList<>();
        answers4.add(new Answer("Shakiro", false));
        answers4.add(new Answer("Jennifer Aniston", false));
        answers4.add(new Answer("Lucy Lui", false));
        answers4.add(new Answer("Angelina Jolie", true));
        questions.add(new Question("Quien interpreta a Malefica?", answers4));

        ArrayList<Answer> answers5 = new ArrayList<>();
        answers5.add(new Answer("Mouse", false));
        answers5.add(new Answer("Shelly", false));
        answers5.add(new Answer("Dr. Smolder", true));
        answers5.add(new Answer("Seaplane", false));
        questions.add(new Question("Que personaje interpreta la roca en el reboot de Jumanji?", answers5));
    }

    public void checkAnswer(View view) {
        boolean isCorrect = (boolean)view.getTag();
        if (isCorrect) {
            selectNextQuestion();
            c++;
        } else {
            Intent intent = new Intent(getApplicationContext(), LoseActivity.class);
            intent.setAction(String.valueOf(c));
            startActivity(intent);
            finish();
        }
    }
}
