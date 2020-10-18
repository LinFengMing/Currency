package com.home.currency;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText edNtd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }

    private void findViews() {
        edNtd = findViewById(R.id.ntd);
    }

    public void exchange(View view) {
        String n = edNtd.getText().toString();
        if (n.equals("")) {
            new AlertDialog.Builder(this)
                    .setTitle("Problem")
                    .setMessage("Please enter you NTD amount")
                    .setPositiveButton("OK", null)
                    .show();
        } else {
            float ntd = Float.parseFloat(n);
            float usd = ntd / 30.9f;
            new AlertDialog.Builder(this)
                    .setTitle("Result")
                    .setMessage("USD is " + usd)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            edNtd.setText("");
                        }
                    })
                    .show();
        }
    }
}
