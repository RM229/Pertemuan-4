package com.example.rizkimaulana4;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import cn.pedant.SweetAlert.SweetAlertDialog;
import android.graphics.Color;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. Success message
        Button buttonSuccess = findViewById(R.id.messageButton);
        buttonSuccess.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                new SweetAlertDialog(MainActivity.this)
                        .setTitleText("Rizki Maulana")
                        .setContentText("191011401004")
                        .show();
            }
        });

        // 2. Confirmation message
        Button buttonWarning = findViewById(R.id.confirmationButton);
        buttonWarning.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                new SweetAlertDialog(MainActivity.this, SweetAlertDialog.WARNING_TYPE)
                        .setTitleText("Are you sure?")
                        .setContentText("You won't be able to recover this file!")
                        .setConfirmText("Delete!")
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                sDialog.dismissWithAnimation();
                            }
                        })
                        .setCancelButton("Cancel", new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                sDialog.dismissWithAnimation();
                            }
                        })
                        .show();
            }
        });

        // 3. Alert message
        Button buttonDanger = findViewById(R.id.alertButton);
        buttonDanger.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                new SweetAlertDialog(MainActivity.this, SweetAlertDialog.ERROR_TYPE)
                        .setTitleText("Oops...")
                        .setContentText("Mohon maaf server sedang error!")
                        .show();
            }
        });

        // 4. Toast message
        Button buttonToast = findViewById(R.id.toastButton);
        buttonToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                // Displaying simple Toast message
                Toast.makeText(getApplicationContext(), "Hey there! This is rizki!", Toast.LENGTH_LONG)
                        .show();
            }
        });

        // 5. Costume message
        Button buttonCustome = findViewById(R.id.costumeButton);
        buttonCustome.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SweetAlertDialog pDialog = new SweetAlertDialog(MainActivity.this, SweetAlertDialog.CUSTOM_IMAGE_TYPE);
                pDialog.setTitleText("Woops!");
                pDialog.setContentText("Here's an Halal Logo.");
                pDialog.setCustomImage(R.drawable.halal);
                pDialog.show();
            }
        });
    }
}