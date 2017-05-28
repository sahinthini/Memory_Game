package com.example.sahinthini.mathgame;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.logging.Handler;

public class MainActivity extends AppCompatActivity {


    TextView tv_p1,tv_p2;
    ImageView iv_11,iv_12,iv_13,iv_14,iv_21,iv_22,iv_23,iv_24,iv_31,iv_32,iv_33,iv_34;
    //array for image
    Integer[] cardsArray = {101,102,103,104,105,106,201,202,203,204,205,206};
    //actual image
    int image101,image102,image103,image104,image105,image106,image201,image202,image203,image204,image205,image206;

    int firstCard,secondCard;
    int clickedFirst,clickedSecond;
    int cardNumber=1;

    int turn=1;
    int playerPoints=0, cpuPoints=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_p1=(TextView) findViewById(R.id.tv_p1);
        tv_p2=(TextView) findViewById(R.id.tv_p2);

        iv_11=(ImageView) findViewById(R.id.iv_11);
        iv_12=(ImageView) findViewById(R.id.iv_12);
        iv_13=(ImageView) findViewById(R.id.iv_13);
        iv_14=(ImageView) findViewById(R.id.iv_14);

        iv_21=(ImageView) findViewById(R.id.iv_21);
        iv_22=(ImageView) findViewById(R.id.iv_22);
        iv_23=(ImageView) findViewById(R.id.iv_23);
        iv_24=(ImageView) findViewById(R.id.iv_24);

        iv_31=(ImageView) findViewById(R.id.iv_31);
        iv_32=(ImageView) findViewById(R.id.iv_32);
        iv_33=(ImageView) findViewById(R.id.iv_33);
        iv_34=(ImageView) findViewById(R.id.iv_34);


        iv_11.setTag("0");
        iv_12.setTag("1");
        iv_13.setTag("2");
        iv_14.setTag("3");
        iv_21.setTag("4");
        iv_22.setTag("5");
        iv_23.setTag("6");
        iv_24.setTag("7");
        iv_31.setTag("8");
        iv_32.setTag("9");
        iv_33.setTag("10");
        iv_34.setTag("11");

        //load the card mage
        frontOfCardsResources();

        //shuffle the image
        Collections.shuffle(Arrays.asList(cardsArray));

        tv_p2.setTextColor(Color.GRAY);

        iv_11.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                int theCard=Integer.parseInt((String) view.getTag());
                doshuff(iv_11,theCard);

            }
        });
        iv_12.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                int theCard=Integer.parseInt((String) view.getTag());
                doshuff(iv_12,theCard);


            }
        });
        iv_13.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                int theCard=Integer.parseInt((String) view.getTag());
                doshuff(iv_13,theCard);


            }
        });
        iv_14.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                int theCard=Integer.parseInt((String) view.getTag());
                doshuff(iv_14,theCard);


            }
        });
        iv_21.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                int theCard=Integer.parseInt((String) view.getTag());
                doshuff(iv_21,theCard);


            }
        });
        iv_22.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                int theCard=Integer.parseInt((String) view.getTag());
                doshuff(iv_22,theCard);


            }
        });
        iv_23.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                int theCard=Integer.parseInt((String) view.getTag());
                doshuff(iv_23,theCard);


            }
        });
        iv_24.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                int theCard=Integer.parseInt((String) view.getTag());
                doshuff(iv_24,theCard);


            }
        });
        iv_31.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                int theCard=Integer.parseInt((String) view.getTag());
                doshuff(iv_31,theCard);


            }
        });
        iv_32.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                int theCard=Integer.parseInt((String) view.getTag());
                doshuff(iv_32,theCard);


            }
        });
        iv_33.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                int theCard=Integer.parseInt((String) view.getTag());
                doshuff(iv_33,theCard);


            }
        });
        iv_34.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                int theCard=Integer.parseInt((String) view.getTag());
                doshuff(iv_34,theCard);


            }
        });

    }





    private void checkEnd(){
        if(iv_11.getVisibility()==View.INVISIBLE &&
                iv_12.getVisibility()==View.INVISIBLE &&
                iv_13.getVisibility()==View.INVISIBLE &&
                iv_14.getVisibility()==View.INVISIBLE &&
                iv_21.getVisibility()==View.INVISIBLE &&
                iv_22.getVisibility()==View.INVISIBLE &&
                iv_23.getVisibility()==View.INVISIBLE &&
                iv_24.getVisibility()==View.INVISIBLE &&
                iv_31.getVisibility()==View.INVISIBLE &&
                iv_32.getVisibility()==View.INVISIBLE &&
                iv_33.getVisibility()==View.INVISIBLE &&
                iv_34.getVisibility()==View.INVISIBLE){

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
            alertDialogBuilder
                    .setMessage("GAME OVER! \np1: " +playerPoints + "\np2: " +cpuPoints)
                    .setCancelable(false)
                    .setPositiveButton("NEW", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                            startActivity(intent);
                            finish();

                        }
                    })
                    .setNegativeButton("EXIT", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finish();
                        }
                    });

            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }
    }

    private void frontOfCardsResources(){
        image101=R.drawable.image101;
        image102=R.drawable.image102;
        image103=R.drawable.image103;
        image104=R.drawable.image104;
        image105=R.drawable.image105;
        image106=R.drawable.image106;
        image201=R.drawable.image201;
        image202=R.drawable.image202;
        image203=R.drawable.image203;
        image204=R.drawable.image204;
        image205=R.drawable.image205;
        image206=R.drawable.image206;
    }

}
