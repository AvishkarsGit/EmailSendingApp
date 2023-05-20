package com.example.sendemail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText to,subject,message;
    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        to = findViewById(R.id.to);
        subject = findViewById(R.id.subject);
        message = findViewById(R.id.msg);

        send = findViewById(R.id.btnSend);


        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String recipent = to.getText().toString();
                String[] recipents = recipent.split(",");
                String sub = subject.getText().toString();
                String msg = message.getText().toString();

                Intent i =new Intent(Intent.ACTION_SEND);
                i.putExtra(Intent.EXTRA_EMAIL,recipents);
                i.putExtra(Intent.EXTRA_SUBJECT,sub);
                i.putExtra(Intent.EXTRA_TEXT,msg);

                i.setType("message/rfc822");
                startActivity(Intent.createChooser(i,"choose email client"));

            }
        });
        Toast.makeText(MainActivity.this, "Email send...", Toast.LENGTH_SHORT).show();
    }
}