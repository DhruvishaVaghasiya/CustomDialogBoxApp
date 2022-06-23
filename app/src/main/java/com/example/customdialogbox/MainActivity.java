package com.example.customdialogbox;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.app.ActionBar;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    AppCompatButton customDialogBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        customDialogBtn = findViewById(R.id.customDialogBtn);

        customDialogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCustomDialog();
            }
        });
    }

    private void openCustomDialog() {
        Dialog d = new Dialog(MainActivity.this);
        d.setContentView(R.layout.dialog_custom);

        Window w = d.getWindow();
        //  d.getWindow().setSoftInputMode(android.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        w.setLayout(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);

        AppCompatButton negBtn = (AppCompatButton) d.findViewById(R.id.negBtn);

        negBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, " cancel CLICK ", Toast.LENGTH_SHORT).show();
                d.dismiss();

            }
        });

        AppCompatButton posBtn = (AppCompatButton) d.findViewById(R.id.posBtn);

        posBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, " Delete CLICK ", Toast.LENGTH_SHORT).show();
            }
        });
        d.setCancelable(false);
        d.show();
    }
}