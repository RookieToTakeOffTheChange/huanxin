package com.cc;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.hyphenate.EMCallBack;
import com.hyphenate.chat.EMClient;

/**
 * Created by Auser on 2017/12/21.
 */

public class LoginActivity extends AppCompatActivity{

    private EditText etName,etPwd;
    public final String TAG="LoginActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etName=findViewById(R.id.et_name);
        etPwd=findViewById(R.id.et_pwd);
    }

    public void login(View view){
        EMClient.getInstance().login(etName.getText().toString(), etPwd.getText().toString(), new EMCallBack() {
            @Override
            public void onSuccess() {
                Log.i(TAG,"onSuccess");
            }

            @Override
            public void onError(int code, String error) {
                Log.i(TAG,"onError");
            }

            @Override
            public void onProgress(int progress, String status) {
            }
        });
    }
}
