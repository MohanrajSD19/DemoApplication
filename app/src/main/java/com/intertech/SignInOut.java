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

public class SignInOut extends Activity implements View.OnClickListener {
    private Button button_signIn,button_signOut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signinout);
        button_signIn=(Button)findViewById(R.id.button_signIn);
        button_signOut=(Button)findViewById(R.id.button_signOut);

        button_signIn.setOnClickListener(this);
        button_signOut.setOnClickListener(this);
        //Show the string value of the singleton
        Toast.makeText(getApplicationContext(),Singleton.getInstance().getDashboardVal(), Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onClick(View view) {
        //GlobalState state = null;
        Intent io =null;
        switch (view.getId()){

            case R.id.button_signIn:
                //state = ((GlobalState) getApplicationContext());
                String m = Singleton.getInstance().getDashboardVal();
                int mm = Integer.parseInt(m);
                switch(mm) {
                    case 1:
                       // state.setSignIOVal(1);
                        io = new Intent(SignInOut.this,Health.class);
                        startActivity(io);
                        finish();
                        break;
                    case 2:
                        //state.setSignIOVal(2);
                        io = new Intent(SignInOut.this,Family.class);
                        startActivity(io);
                        finish();
                        break;
                    case 3:
                        //state.setSignIOVal(3);
                        io = new Intent(SignInOut.this,Resident.class);
                        startActivity(io);
                        finish();
                        break;
                }


                break;

            /*case R.id.button_signOut:
                state = ((GlobalState) getApplicationContext());
                switch(state.getDashboardVal()) {
                    case 1:
                        state.setSignIOVal(1);
                        break;
                    case 2:
                        state.setSignIOVal(2);
                        break;
                    case 3:
                        state.setSignIOVal(3);
                        break;
                }
                io = new Intent(SignInOut.this,SignInOut.class);
                startActivity(io);
                finish();

                break;*/

            default:
                break;
        }

    }
}
