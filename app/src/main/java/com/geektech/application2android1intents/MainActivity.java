package com.geektech.application2android1intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etMessage, etEmail, etTheme;
    private Button btnSend, btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InitViews();

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA);
                startActivity(intent);

            }
        });

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentSend = new Intent(Intent.ACTION_SEND);

                intentSend.putExtra(android.content.Intent.EXTRA_EMAIL,
                        Uri.parse("Отправить письмо: " + etEmail.getText().toString() ));;

                intentSend.putExtra(android.content.Intent.EXTRA_SUBJECT,
                        etTheme.getText().toString());

                intentSend.putExtra(android.content.Intent.EXTRA_TEXT,
                        etMessage.getText().toString());

                if(!etEmail.getText().toString().equals(null) &&
                        !etTheme.getText().toString().equals(null)
                        && !etMessage.getText().toString().equals(null)){
                    Toast.makeText(MainActivity.this, "Заполните все поля", Toast.LENGTH_SHORT).show();}

                else {startActivity(Intent.createChooser(intentSend, "Выберите email клиент :"));}

            }
        });
    }

    private void InitViews() {

        etMessage = findViewById(R.id.message_et);
        etEmail = findViewById(R.id.email_et);
        etTheme = findViewById(R.id.theme_et);
        btnSend = findViewById(R.id.btn_send);
        btnNext = findViewById(R.id.btn_next);

    }


}