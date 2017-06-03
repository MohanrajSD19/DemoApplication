package com.intertech;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Mohanraj.S,innobot-linux-4 on 2/6/17.
 */

public class Dashoard extends Activity implements View.OnClickListener {
    private Button button_Health,button_Friends,button_Resident;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dasboard);
        button_Health=(Button)findViewById(R.id.button_Health);
        button_Friends=(Button)findViewById(R.id.button_Friends);
        button_Resident=(Button)findViewById(R.id.button_Resident);

        button_Health.setOnClickListener(this);
        button_Friends.setOnClickListener(this);
        button_Resident.setOnClickListener(this);
        //Show the string value defined by the private constructor
        //Toast.makeText(getApplicationContext(),Singleton.getInstance().getString(), Toast.LENGTH_LONG).show();


    }

    @Override
    public void onClick(View view) {
        GlobalState state = null;
        Intent io =null;
        switch (view.getId()){

            case R.id.button_Health:
                state = ((GlobalState) getApplicationContext());
                state.setDashboardVal(1);
                //Change the string value and launch intent to ActivityB
                //Singleton.getInstance().setString("Singleton");
                Singleton.getInstance().setDashboardVal("1");
                io = new Intent(Dashoard.this,SignInOut.class);
                startActivity(io);
                finish();
                break;
            case R.id.button_Friends:
                /*state = ((GlobalState) getApplicationContext());
                state.setDashboardVal(1);*/
                Singleton.getInstance().setDashboardVal("2");

                io = new Intent(Dashoard.this,SignInOut.class);
                startActivity(io);
                finish();

                break;
            case R.id.button_Resident:
                /*state = ((GlobalState) getApplicationContext());
                state.setDashboardVal(1);*/
                Singleton.getInstance().setDashboardVal("3");
                io = new Intent(Dashoard.this,SignInOut.class);
                startActivity(io);
                finish();

                break;
            default:
                break;
        }

    }
}
