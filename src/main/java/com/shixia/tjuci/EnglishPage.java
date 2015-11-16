package com.shixia.tjuci;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

/**
 * Created by shixiuwen on 15-11-13.
 */
public class EnglishPage extends Activity implements View.OnClickListener {

    SharedPreferences.Editor edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_english_page);

        Button btnLogin = (Button) findViewById(R.id.english_btn_login);
        Button btnRegister = (Button) findViewById(R.id.english_btn_register);
        Button btnEnter = (Button) findViewById(R.id.english_btn_enter);

        ImageButton ibSetting = (ImageButton) findViewById(R.id.english_ib_setting);
        ImageButton ibShare = (ImageButton) findViewById(R.id.english_ib_share);

        btnLogin.setOnClickListener(this);
        btnRegister.setOnClickListener(this);
        btnEnter.setOnClickListener(this);

        ibSetting.setOnClickListener(this);
        ibShare.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //登陆
            case R.id.english_btn_login:
                Intent intent = new Intent(EnglishPage.this, LoginPage.class);
                startActivity(intent);
                break;
            //注册
            case R.id.english_btn_register:
                Intent intent2 = new Intent(EnglishPage.this, RegistePage.class);
                startActivity(intent2);
                break;
            //进入主页
            case R.id.english_btn_enter:
                Intent intent3 = new Intent(EnglishPage.this, MainPage.class);
                startActivity(intent3);
                finish();
                break;
            //设置
            case R.id.english_ib_setting:
                setting();
                break;
            //分享
            case R.id.english_ib_share:
                break;

            default:
                break;
        }
    }

    private void setting() {

        int count = 0;

        SharedPreferences preferences = getSharedPreferences("english_mode", Context.MODE_PRIVATE);
        edit = preferences.edit();

        //进入时选择状态
        String mode = preferences.getString("MODE", null);
        if (mode != null) {
            switch (mode) {
                case "EVERY_TIMES":
                    count = 0;
                    break;
                case "EVERY_DAY":
                    count = 1;
                    break;
                case "EVERY_WEEK":
                    count = 2;
                    break;
                case "NO_MORE":
                    count = 3;
                    break;
            }
        }

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("请设置显示频率");
        builder.setSingleChoiceItems(new String[]{"每次打开显示", "每日首次打开显示", "每周首次打开显示", "不再显示"},
                count, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {

                            case 0:
                                edit.putString("MODE", "EVERY_TIMES");
                                break;
                            case 1:
                                edit.putString("MODE", "EVERY_DAY");
                                break;
                            case 2:
                                edit.putString("MODE", "EVERY_WEEK");
                                break;
                            case 3:
                                edit.putString("MODE", "NO_MORE");

                                break;
                            default:
                                break;
                        }

                    }
                });
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (edit != null) {
                    edit.apply();
                }
            }
        }).setNegativeButton("取消", null);
        builder.show();
    }
}
