package com.david.sandh.a1_apputv;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;


public class MainActivity extends AppCompatActivity {
    private ImageButton btn_0;
    private ImageButton btn_1;
    private ImageButton btn_2;
    private ImageButton btn_3;
    private ImageButton btn_4;
    private ImageButton btn_5;

    public Button btn_roll;
    private Button btn_reset;

    private TextView txt_round;
    private TextView txt_score;

    private int[] dice_setting = {1,1,1,1,1,1};
    private int[] roll_result = new int[6];
    private int round = 0;
    private int score = 0;

    private Random r = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice_main);

        btn_0 = (ImageButton) findViewById(R.id.btn_dice_0);
        btn_0.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(dice_setting[0] == 1){
                    dice_setting[0] = 0;
                }
                else {
                    dice_setting[0] = 1;
                }
            }
        });
        btn_1 = (ImageButton) findViewById(R.id.btn_dice_1);
        btn_1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(dice_setting[1] == 1){
                    dice_setting[1] = 0;
                }
                else {
                    dice_setting[1] = 1;
                }
            }
        });
        btn_2 = (ImageButton) findViewById(R.id.btn_dice_2);
        btn_2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(dice_setting[2] == 1){
                    dice_setting[2] = 0;
                }
                else {
                    dice_setting[2] = 1;
                }
            }
        });
        btn_3 = (ImageButton) findViewById(R.id.btn_dice_3);
        btn_3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(dice_setting[3] == 1){
                    dice_setting[3] = 0;
                }
                else {
                    dice_setting[3] = 1;
                }
            }
        });
        btn_4 = (ImageButton) findViewById(R.id.btn_dice_4);
        btn_4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(dice_setting[4] == 1){
                    dice_setting[4] = 0;
                }
                else {
                    dice_setting[4] = 1;
                }
            }
        });
        btn_5 = (ImageButton) findViewById(R.id.btn_dice_5);
        btn_5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(dice_setting[5] == 1){
                    dice_setting[5] = 0;
                    btn_5.setImageResource(R.drawable.red6);
                }
                else {
                    dice_setting[5] = 1;
                }
            }
        });

        txt_round = (TextView) findViewById(R.id.txt_round);
        txt_score = (TextView) findViewById(R.id.txt_score);


        btn_roll = (Button) findViewById(R.id.btn_roll_dice);
        btn_roll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rollDice();
                txt_round.setText(Integer.toString(round));
                txt_score.setText(Integer.toString(score));
            }
        });

        //Resets dice, score and round
        btn_reset = (Button) findViewById(R.id.btn_reset_game);
        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                round = 0;
                score = 0;
                for (int i =  0; i < roll_result.length; i++){
                    roll_result[i]=0;
                    dice_setting[i]=1;

                    //Løgg till reset av knapp-bilder, samt grey-out
                }
                txt_round.setText(Integer.toString(round));
                txt_score.setText(Integer.toString(score));
                btn_roll.setClickable(true);
                btn_roll.setBackgroundColor(getResources().getColor(R.color.color_unclickable));
            }
        });



    }

    /*
    Rolls the dice, recording score and changes image to reflect the rolled score
     */
    private void rollDice(){
        for(int i= 0; i < roll_result.length;i++){
            if(dice_setting[i] == 1){
                roll_result[i] = r.nextInt(6)+1;
                System.out.println(roll_result[i]);
                score += roll_result[i];
            }
        }
        round++;
        if(round == 3){
            btn_roll.setClickable(false);
            btn_roll.setBackgroundColor(getResources().getColor(R.color.color_unclickable));
        }
    }

}
