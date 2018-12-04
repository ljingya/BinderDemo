package com.lijingya.binder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.lijingya.binder.aidl.BookActivity;
import com.lijingya.binder.messenger.MessengerActivity;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    private Button btnAidl, btnSecondAct, btnThreeAct,btnMessengerAct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAidl = findViewById(R.id.btn_aidl);
        btnSecondAct = findViewById(R.id.btn_second_act);
        btnThreeAct = findViewById(R.id.btn_three_act);
        btnMessengerAct = findViewById(R.id.btn_messenger);
        btnThreeAct.setOnClickListener(this);
        btnSecondAct.setOnClickListener(this);
        btnAidl.setOnClickListener(this);
        btnMessengerAct.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.btn_aidl:
                intent = new Intent(this, BookActivity.class);
                break;
            case R.id.btn_second_act:
                intent = new Intent(this, SecondActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("SecondActivity", "Hello");
                intent.putExtra("data", bundle);
                intent.putExtra("name", "lijingya");

                break;
                case R.id.btn_messenger:
                    intent = new Intent(this, MessengerActivity.class);
                    break;
            default:
                intent = new Intent(this, ThirdActivity.class);
                break;

        }
        startActivity(intent);
    }
}

