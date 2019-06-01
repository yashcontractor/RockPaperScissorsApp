package com.example.rpsgame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button b_rock, b_scissors, b_paper;
    TextView tv_score;
    ImageView iv_HumanChoice, iv_ComputerChoice;

    int HumanScore, ComputerScore = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b_paper = (Button) findViewById(R.id.b_paper);
        b_scissors = (Button) findViewById(R.id.b_scissor);
        b_rock = (Button) findViewById(R.id.b_rock);

        iv_ComputerChoice = (ImageView) findViewById(R.id.iv_ComputerChoice);
        iv_HumanChoice = (ImageView) findViewById(R.id.iv_HumanChoice);

        tv_score = (TextView) findViewById(R.id.tv_score);

        b_paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_HumanChoice.setImageResource(R.drawable.paper);
                String message = play_turn("paper");
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                tv_score.setText("Score Human: " + Integer.toString(HumanScore) + "Computer: " + Integer.toString(ComputerScore));
            }
        });

        b_rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_HumanChoice.setImageResource(R.drawable.rock);
                String message = play_turn("rock");
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                tv_score.setText("Score Human: " + Integer.toString(HumanScore) + " Computer: " + Integer.toString(ComputerScore));
            }
        });

        b_scissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_HumanChoice.setImageResource(R.drawable.scissor);
                String message = play_turn("scissors");
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                tv_score.setText("Score Human: " + Integer.toString(HumanScore) + "Computer: " + Integer.toString(ComputerScore));
            }
        });

    }
public String play_turn(String player_choice) {
    String computerChoice = "";
    Random r = new Random();

    int compChoiceNumber = r.nextInt(3) + 1;

    if (compChoiceNumber == 1) {
        computerChoice = "rock";
    }
    else if (compChoiceNumber == 2) {
        computerChoice = "scissors";
    }
    else if (compChoiceNumber == 3) {
        computerChoice = "paper";
    }

    if (computerChoice == "rock") {
        iv_ComputerChoice.setImageResource(R.drawable.rock);
    }
    else if (computerChoice == "paper") {
        iv_ComputerChoice.setImageResource(R.drawable.paper);
    }
    else if (computerChoice == "scissor") {
        iv_ComputerChoice.setImageResource(R.drawable.scissor);
    }


    if(computerChoice == player_choice) {
        return "It is a Draw!";
    }
    else if (player_choice == "rock" && computerChoice == "scissors") {
        HumanScore ++;
        return "Rock crushes Scissors, you win!";
    }
    else if (player_choice == "scissors" && computerChoice == "rock") {
        ComputerScore ++;
        return "Scissors get crushed by rock, you lose!";
    }
    else if (player_choice == "paper" && computerChoice == "rock") {
        HumanScore ++;
        return "Paper beats Rock, you win!";
    }
    else if (player_choice == "rock" && computerChoice == "paper") {
        ComputerScore ++;
        return "Paper covers Rock, you lose!";
    }
    else if (player_choice == "scissors" && computerChoice == "paper") {
        HumanScore ++;
        return "Scissor cuts Paper, you win!";
    }
    else if (player_choice == "paper" && computerChoice == "scissor") {
        ComputerScore ++;
        return "Paper gets cut by Scissor, you lose!";
    }
    else return " ";
    }

}
