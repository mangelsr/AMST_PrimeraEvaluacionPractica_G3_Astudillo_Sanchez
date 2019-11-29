package amst.g1.amst_primeraevaluacion_g3_astudillo_sanchez;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoseActivity extends AppCompatActivity {

    TextView tvMessage;
    Button btnExit, btnAgain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lose);

        btnExit = findViewById(R.id.btnLoseExit);
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnAgain = findViewById(R.id.btnLoseAgain);
        btnAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), StartActivity.class);
                startActivity(intent);
                finish();
            }
        });

        tvMessage = findViewById(R.id.tvCounter);
        tvMessage.setText("Has respondido " + getIntent().getAction() + " preguntas");
    }


}
