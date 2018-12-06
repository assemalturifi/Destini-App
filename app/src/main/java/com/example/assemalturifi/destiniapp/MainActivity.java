package com.example.assemalturifi.destiniapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private TextView storyText;
    private Button topBtn;
    private Button bottonBtn;
    private int mStoryIndex=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        upViews();

        if(savedInstanceState!=null){
            mStoryIndex = savedInstanceState.getInt("Index");
            storyText.setText(savedInstanceState.getString("Story"));
            if(storyText.getText().toString().equals(R.string.T4_End)||storyText.getText().toString().equals(R.string.T5_End)||storyText.getText().toString().equals(R.string.T6_End)){

                topBtn.setVisibility(View.GONE);
                bottonBtn.setVisibility(View.GONE);
            }
            else{
                topBtn.setText(savedInstanceState.getString("Topbtn"));
                bottonBtn.setText(savedInstanceState.getString("BottonBtn"));

            }
        }
        else{
            mStoryIndex=1;
            storyText.setText(R.string.T1_Story);
            topBtn.setText(R.string.T1_Ans1);
            bottonBtn.setText(R.string.T1_Ans2);

        }




        topBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mStoryIndex==1) {
                    storyText.setText(R.string.T3_Story);
                    topBtn.setText(R.string.T3_Ans1);
                    bottonBtn.setText(R.string.T3_Ans2);
                    mStoryIndex+=2;
                }
                else if(mStoryIndex==2){
                    storyText.setText(R.string.T3_Story);
                    topBtn.setText(R.string.T3_Ans1);
                    bottonBtn.setText(R.string.T3_Ans2);
                    mStoryIndex+=2;

                }
                else if(mStoryIndex==3||mStoryIndex==4){
                    storyText.setText(R.string.T6_End);
                    bottonBtn.setVisibility(View.GONE);
                    topBtn.setVisibility(View.GONE);
                }


            }
        });

        bottonBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mStoryIndex==1) {
                    storyText.setText(R.string.T2_Story);
                    topBtn.setText(R.string.T2_Ans1);
                    bottonBtn.setText(R.string.T2_Ans2);
                    mStoryIndex += 1;
                }
                else if(mStoryIndex==2){
                    storyText.setText(R.string.T4_End);
                    bottonBtn.setVisibility(View.GONE);
                    topBtn.setVisibility(View.GONE);

                }
                else if(mStoryIndex==3){
                    storyText.setText(R.string.T5_End);
                    bottonBtn.setVisibility(View.GONE);
                    topBtn.setVisibility(View.GONE);
                }
                else if(mStoryIndex==4){
                    storyText.setText(R.string.T5_End);
                    bottonBtn.setVisibility(View.GONE);
                    topBtn.setVisibility(View.GONE);
                }

            }
        });


    }
    public void upViews(){
        storyText = findViewById(R.id.storyTextView);
        topBtn = findViewById(R.id.btnTop);
        bottonBtn = findViewById(R.id.btnBotton);

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("Index",mStoryIndex);
        outState.putString("Story",storyText.getText().toString());
        outState.putString("Topbtn",topBtn.getText().toString());
        outState.putString("BottonBtn",bottonBtn.getText().toString());


    }
}
