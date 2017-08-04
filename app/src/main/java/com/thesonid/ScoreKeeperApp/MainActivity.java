package com.thesonid.ScoreKeeperApp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import static android.R.attr.id;

public class MainActivity extends AppCompatActivity {

    int sets1;
    int sets2;
    int points1;
    int points2;
    Button b1;
    Button b2;
    int outs1 = 0;
    int outs2 = 0;
    TextView s1;
    TextView s2;
    TextView p1;
    TextView p2;
    boolean ad1;
    boolean ad2;
    String se1;
    String se2;
    String po1;
    String po2;
    String ou1;
    String ou2;
    TextView o1;
    TextView o2;
    Button out1;
    Button out2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.thesonid.ScoreKeeperApp.R.layout.activity_main);
        b1 = (Button) findViewById(com.thesonid.ScoreKeeperApp.R.id.won1);
        b2 = (Button) findViewById(com.thesonid.ScoreKeeperApp.R.id.won2);
        out1 = (Button) findViewById(com.thesonid.ScoreKeeperApp.R.id.out1);
        out2 = (Button) findViewById(com.thesonid.ScoreKeeperApp.R.id.out2);
        s1 = (TextView) findViewById(com.thesonid.ScoreKeeperApp.R.id.sets1);
        s2 = (TextView) findViewById(com.thesonid.ScoreKeeperApp.R.id.sets2);
        p1 = (TextView) findViewById(com.thesonid.ScoreKeeperApp.R.id.points1);
        p2 = (TextView) findViewById(com.thesonid.ScoreKeeperApp.R.id.points2);
        o1 = (TextView) findViewById(com.thesonid.ScoreKeeperApp.R.id.outs1);
        o2 = (TextView) findViewById(com.thesonid.ScoreKeeperApp.R.id.outs2);
        sets1 = 0;
        sets2 = 0;
        points1 = 0;
        points2 = 0;
        ad1 = false;
        ad2 = false;
        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Won1(v);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Won2(v);
            }
        });
        out1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Out1(v);
            }
        });
        out2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Out2(v);
            }
        });

    }

    public void Reset(View v) {
        sets1 = 0;
        sets2 = 0;
        points1 = 0;
        points2 = 0;
        outs1 = 0;
        outs2 = 0;
        ad1 = false;
        ad2 = false;
        display(v);
    }

    public void Out1(View v) {
        outs1++;
        ou1 = String.valueOf(outs1);
        o1.setText(ou1);
    }

    public void Out2(View v) {
        outs2++;
        ou2 = String.valueOf(outs2);
        o2.setText(ou2);
    }

    public void Won1(View v) {
        if (points1 == points2 && points1 == 40 && !ad2) {
            if (ad1) {
                points1 = 0;
                points2 = 0;
                sets1++;
                ad1 = false;
            } else {
                ad1 = true;
            }
        } else if (points1 == points2 && points1 == 40 && ad2) {
            ad2 = false;
        } else if (points1 == 40 && points2 != 40) {
            points1 = 0;
            points2 = 0;
            sets1++;
        } else {
            if (points1 == 0) {
                points1 = 15;
            } else if (points1 == 15) {
                points1 = 30;
            } else if (points1 == 30) {
                points1 = 40;
            }
        }
        display(v);
    }


    public void Won2(View v) {
        if (points1 == points2 && points1 == 40 && !ad1) {
            if (ad2) {
                points1 = 0;
                points2 = 0;
                sets2++;
                ad2 = false;
            } else {
                ad2 = true;
            }
        } else if (points1 == points2 && points1 == 40 && ad1) {
            ad1 = false;
        } else if (points2 == 40 && points1 != 40) {
            points1 = 0;
            points2 = 0;
            sets2++;
        } else {
            if (points2 == 0) {
                points2 = 15;
            } else if (points2 == 15) {
                points2 = 30;
            } else if (points2 == 30) {
                points2 = 40;
            }
        }
        display(v);
    }

    public void display(View v) {
        se1 = String.valueOf(sets1);
        se2 = String.valueOf(sets2);
        ou1 = String.valueOf(outs1);
        o1.setText(ou1);
        ou2 = String.valueOf(outs2);
        o2.setText(ou2);
        if (ad1) {
            po1 = "Ad";
        } else {
            po1 = String.valueOf(points1);
        }
        if (ad2) {
            po2 = "Ad";
        } else {
            po2 = String.valueOf(points2);
        }
        s1.setText(se1);
        s2.setText(se2);
        p1.setText(po1);
        p2.setText(po2);
    }

}

