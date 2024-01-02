package com.example.toast_2;
import android.content.Intent;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.buttonShowToast).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Hello, Toast!");
            }
        });

        findViewById(R.id.buttonShowToast2).setOnClickListener(new View.OnClickListener() {
        @Override
            public void onClick(View v) {
            showCustomToast();
        }
        }
        );

        findViewById(R.id.TakePhoto).setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
         TakePhoto();
          }
          }
        );
    }
        private void showToast(String message)
        {
           Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
        }

        private void showCustomToast()
        {
            LayoutInflater li = getLayoutInflater();
            View layout = li.inflate(R.layout.custom_toast,(ViewGroup) findViewById(R.id.custom_toast_layout));
            Toast toast = new Toast(getApplicationContext());
            toast.setDuration(Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
            toast.setView(layout);//setting the view of custom toast layout
            toast.show();
        }

        private void TakePhoto()
        {
            Intent intent = new Intent(MainActivity.this, Camera.class);
            startActivity(intent);
        }
}