package com.shixia.tjuci;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by shixiuwen on 15-11-13.
 */
public class MainPage extends AppCompatActivity implements View.OnClickListener {

    Main_LearnFrame learnFrame = null;
    Main_FunnyFrame funnyFrame = null;
    Main_ServiceFrame serviceFrame = null;
    Main_PersonalFrame persionalFrame = null;

    FragmentTransaction fragmentTransaction;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        setDefaultFrame();

        Button btnLearn = (Button) findViewById(R.id.main_btn_learn);
        Button btnFunny = (Button) findViewById(R.id.main_btn_funny);
        Button btnService = (Button) findViewById(R.id.main_btn_service);
        Button btnPersional = (Button) findViewById(R.id.main_btn_persional);

        btnLearn.setOnClickListener(this);
        btnFunny.setOnClickListener(this);
        btnService.setOnClickListener(this);
        btnPersional.setOnClickListener(this);

    }

    public void setDefaultFrame() {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Main_LearnFrame learnFrame = new Main_LearnFrame();
        fragmentTransaction.replace(R.id.fl_main_page, learnFrame);
        fragmentTransaction.commit();
    }


    @Override
    public void onClick(View v) {

        FragmentManager fragManager = getFragmentManager();
        fragmentTransaction = fragManager.beginTransaction();

        switch (v.getId()) {
            case R.id.main_btn_learn:
                replace(learnFrame,new Main_LearnFrame());
                break;
            case R.id.main_btn_funny:
                replace(funnyFrame,new Main_FunnyFrame());
                break;
            case R.id.main_btn_service:
                replace(serviceFrame,new Main_ServiceFrame());
                break;
            case R.id.main_btn_persional:
                replace(persionalFrame,new Main_PersonalFrame());
                break;
            default:
                break;

        }
        fragmentTransaction.commit();
    }

    public void replace(Fragment fragment,Fragment newFragmnet){
        if (fragment != null) {
            fragmentTransaction.replace(R.id.fl_main_page, fragment);
        }else{
            fragmentTransaction.replace(R.id.fl_main_page, newFragmnet);
        }
    }
}
