package com.example.kamienpapier;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageButton b_kamien, b_nozyce, b_papier;
    TextView wynik;
    ImageView w_gracz, w_komputer;
    int p_gracza, p_komputer = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b_kamien = (ImageButton) findViewById(R.id.b_kamien);
        b_nozyce = (ImageButton) findViewById(R.id.b_nozyce);
        b_papier = (ImageButton) findViewById(R.id.b_papier);

        wynik = (TextView) findViewById(R.id.wynik);

        w_gracz = (ImageView) findViewById(R.id.w_gracz);
        w_komputer = (ImageView) findViewById(R.id.w_komputer);


        b_papier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                w_gracz.setImageResource(R.drawable.papier);
               String wiadomosc = Runda("papier");
                Toast.makeText(MainActivity.this, wiadomosc, Toast.LENGTH_SHORT).show();
                wynik.setText("Ty " + Integer.toString(p_gracza) + " komputer " + Integer.toString(p_komputer));
            }
        });

        b_kamien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                w_gracz.setImageResource(R.drawable.kamien);
                String wiadomosc = Runda("kamien");
                Toast.makeText(MainActivity.this, wiadomosc, Toast.LENGTH_SHORT).show();
                wynik.setText("Ty " + Integer.toString(p_gracza) + " komputer " + Integer.toString(p_komputer));
            }
        });
        b_nozyce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                w_gracz.setImageResource(R.drawable.nozyce);
                String wiadomosc = Runda("nozyce");
                Toast.makeText(MainActivity.this, wiadomosc, Toast.LENGTH_SHORT).show();
                wynik.setText("Ty " + Integer.toString(p_gracza) + " komputer " + Integer.toString(p_komputer));
            }
        });
    }

    public String Runda(String Gracz) {
        String komputer = "";
        Random r = new Random();
        // gracz
        int liczba = r.nextInt(3) + 1;
        if (liczba == 1) {
            komputer = "kamien";
        } else if (liczba == 2) {
            komputer = "papier";
        } else if (liczba == 3) {
            komputer = "nozyce";
        }

        // komputer
        if (komputer == "kamien") {
            w_komputer.setImageResource(R.drawable.kamien);
        } else if (komputer == "papier") {
            w_komputer.setImageResource(R.drawable.papier);
        } else if (komputer == "nozyce") {
            w_komputer.setImageResource(R.drawable.nozyce);
        }
        // punkty
        if (komputer == Gracz) {
            return "Remis!";
        } else if (komputer == "kamien" && Gracz == "papier") {
            p_gracza++;
            return "Wygrales!";
        } else if (komputer == "papier" && Gracz == "nozyce") {
            p_gracza++;
            return "Wygrales!";
        } else if (komputer == "nozyce" && Gracz == "kamien") {
            p_gracza++;
            return "Wygrales!";
        } else if (komputer == "kamien" && Gracz == "nozyce") {
            p_komputer++;
            return "Przegrales";
        } else if (komputer == "papier" && Gracz == "kamien") {
            p_komputer++;
            return "przegrales";
        } else if (komputer == "nozyce" && Gracz == "papier") {
            p_komputer++;
            return "przegrales";
        }
        else return  "blad";

    }
}

