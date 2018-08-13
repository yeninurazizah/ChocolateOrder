package id.co.asyst.yeni.chocolateorderyeni;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class FinishActivity extends AppCompatActivity {

    TextView finishTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);

        finishTV = findViewById(R.id.finish_tv);
    }
}
