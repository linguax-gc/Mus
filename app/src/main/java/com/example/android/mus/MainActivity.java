package com.example.android.mus;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import static com.example.android.mus.R.id.Vaca1A;
import static com.example.android.mus.R.id.Vaca1B;
import static com.example.android.mus.R.id.Vaca2A;
import static com.example.android.mus.R.id.Vaca2B;
import static com.example.android.mus.R.id.Vaca3A;
import static com.example.android.mus.R.id.Vaca3B;
import static com.example.android.mus.R.id.Vaca4A;
import static com.example.android.mus.R.id.Vaca4B;
import static com.example.android.mus.R.id.Vaca5A;
import static com.example.android.mus.R.id.Vaca5B;
import static com.example.android.mus.R.id.radioGroupJuego;
import static com.example.android.mus.R.id.radioGroupPares;

public class MainActivity extends AppCompatActivity {

    int grandesPendientes = 0;
    int chicasPendientes = 0;
    int paresPendientes = 0;
    int juegoPendientes = 0;
    int puntosA = 0;
    int puntosB = 0;
    int vacaActual = 1;

    LinearLayout mostrarVacas;
    LinearLayout mostrarPendientes;
    LinearLayout mostrarTanteo;
    RadioButton radioButtonJuegoA, radioButtonJuegoB;
    RadioButton radioButtonParesA, radioButtonParesB;
    TextView Grandes_pendientes_text_view;
    TextView Chicas_pendientes_text_view;
    TextView Pares_pendientes_text_view;
    TextView Juego_pendientes_text_view;
    private RadioGroup paresRadioGroup;
    private RadioGroup juegoRadioGroup;
    private TextView vaca1A_text_view;
    private TextView vaca2A_text_view;
    private TextView vaca3A_text_view;
    private TextView vaca4A_text_view;
    private TextView vaca5A_text_view;
    private TextView vaca1B_text_view;
    private TextView vaca2B_text_view;
    private TextView vaca3B_text_view;
    private TextView vaca4B_text_view;
    private TextView vaca5B_text_view;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    public static void slide_down(Context ctx, View v) {
        Animation a = AnimationUtils.loadAnimation(ctx, R.anim.slide_down);
        if (a != null) {
            a.reset();
            if (v != null) {
                v.clearAnimation();
                v.startAnimation(a);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mostrarPendientes = (LinearLayout) findViewById(R.id.mostrarPendientes);
// hide until its title is clicked
        mostrarPendientes.setVisibility(View.GONE);
        mostrarTanteo = (LinearLayout) findViewById(R.id.mostrarTanteo);
// hide until its title is clicked
        mostrarTanteo.setVisibility(View.GONE);
        paresRadioGroup = (RadioGroup) findViewById(radioGroupPares);
        juegoRadioGroup = (RadioGroup) findViewById(radioGroupJuego);
        vaca1A_text_view = (TextView) findViewById(Vaca1A);
        vaca2A_text_view = (TextView) findViewById(Vaca2A);
        vaca3A_text_view = (TextView) findViewById(Vaca3A);
        vaca4A_text_view = (TextView) findViewById(Vaca4A);
        vaca5A_text_view = (TextView) findViewById(Vaca5A);
        vaca1B_text_view = (TextView) findViewById(Vaca1B);
        vaca2B_text_view = (TextView) findViewById(Vaca2B);
        vaca3B_text_view = (TextView) findViewById(Vaca3B);
        vaca4B_text_view = (TextView) findViewById(Vaca4B);
        vaca5B_text_view = (TextView) findViewById(Vaca5B);
        radioButtonJuegoA = (RadioButton) findViewById(R.id.radioButtonJuegoA);
        radioButtonJuegoB = (RadioButton) findViewById(R.id.radioButtonJuegoB);
        radioButtonParesA = (RadioButton) findViewById(R.id.radioButtonParesA);
        radioButtonParesB = (RadioButton) findViewById(R.id.radioButtonParesB);
        Grandes_pendientes_text_view = (TextView) findViewById(R.id.pend_grandes);
        Chicas_pendientes_text_view = (TextView) findViewById(R.id.pend_chicas);
        Pares_pendientes_text_view = (TextView) findViewById(R.id.pend_pares);
        Juego_pendientes_text_view = (TextView) findViewById(R.id.pend_juego);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public void deplegarVacas(View v) {
        mostrarVacas.setVisibility(mostrarVacas.isShown()
                ? View.GONE
                : View.VISIBLE);
    }

    public void desplegarPendientes(View v) {
        if (mostrarPendientes.isShown()) {
            Fx.slide_up(this, mostrarPendientes);
            mostrarPendientes.setVisibility(View.GONE);
        } else {
            mostrarPendientes.setVisibility(View.VISIBLE);
            Fx.slide_down(this, mostrarPendientes);
        }
    }

    public void desplegarTanteo(View v) {
        if (mostrarTanteo.isShown()) {
            Fx.slide_up(this, mostrarTanteo);
            mostrarTanteo.setVisibility(View.GONE);
        } else {
            mostrarTanteo.setVisibility(View.VISIBLE);
            Fx.slide_down(this, mostrarTanteo);
        }
    }

    public void mostrarEquipoA(int puntos) {
        if (puntos >= 40) {
            if (vacaActual == 1) {
                vaca1A_text_view.setText(String.valueOf("X"));
                vaca1B_text_view.setText(String.valueOf(" "));
                vacaActual += 1;
                puntosA = 0;
                puntosB = 0;
            } else if (vacaActual == 2) {
                vaca2A_text_view.setText(String.valueOf("X"));
                vaca2B_text_view.setText(String.valueOf(" "));
                vacaActual += 1;
                puntosA = 0;
                puntosB = 0;
            } else if (vacaActual == 3) {
                vaca3A_text_view.setText(String.valueOf("X"));
                vaca3B_text_view.setText(String.valueOf(" "));
                vacaActual += 1;
                puntosA = 0;
                puntosB = 0;
            } else if (vacaActual == 4) {
                vaca4A_text_view.setText(String.valueOf("X"));
                vaca4B_text_view.setText(String.valueOf(" "));
                vacaActual += 1;
                puntosA = 0;
                puntosB = 0;
            } else if (vacaActual == 5) {
                vaca5A_text_view.setText(String.valueOf("X"));
                vaca5B_text_view.setText(String.valueOf(" "));
                vacaActual += 1;
                puntosA = 0;
                puntosB = 0;
            }
        } else if (vacaActual == 1) {
            vaca1A_text_view.setText(String.valueOf(puntos));
        } else if (vacaActual == 2) {
            vaca2A_text_view.setText(String.valueOf(puntos));
        } else if (vacaActual == 3) {
            vaca3A_text_view.setText(String.valueOf(puntos));
        } else if (vacaActual == 4) {
            vaca4A_text_view.setText(String.valueOf(puntos));
        } else if (vacaActual == 5) {
            vaca5A_text_view.setText(String.valueOf(puntos));
        }
    }


    public void mas1EquipoA(View view) {
        puntosA = puntosA + 1;
        mostrarEquipoA(puntosA);
    }

    public void menos1EquipoA(View view) {
        puntosA = puntosA - 1;
        mostrarEquipoA(puntosA);
    }

    public void mostrarEquipoB(int puntos) {
        if (puntos >= 40) {
            if (vacaActual == 1) {
                vaca1A_text_view.setText(String.valueOf(" "));
                vaca1B_text_view.setText(String.valueOf("X"));
                vacaActual += 1;
                puntosA = 0;
                puntosB = 0;
            } else if (vacaActual == 2) {
                vaca2A_text_view.setText(String.valueOf(" "));
                vaca2B_text_view.setText(String.valueOf("X"));
                vacaActual += 1;
                puntosA = 0;
                puntosB = 0;
            } else if (vacaActual == 3) {
                vaca3A_text_view.setText(String.valueOf(" "));
                vaca3B_text_view.setText(String.valueOf("X"));
                vacaActual += 1;
                puntosA = 0;
                puntosB = 0;
            } else if (vacaActual == 4) {
                vaca4A_text_view.setText(String.valueOf(" "));
                vaca4B_text_view.setText(String.valueOf("X"));
                vacaActual += 1;
                puntosA = 0;
                puntosB = 0;
            } else if (vacaActual == 5) {
                vaca5A_text_view.setText(String.valueOf(" "));
                vaca5B_text_view.setText(String.valueOf("X"));
                vacaActual += 1;
                puntosA = 0;
                puntosB = 0;
            }
        } else if (vacaActual == 1) {
            vaca1B_text_view.setText(String.valueOf(puntos));
        } else if (vacaActual == 2) {
            vaca2B_text_view.setText(String.valueOf(puntos));
        } else if (vacaActual == 3) {
            vaca3B_text_view.setText(String.valueOf(puntos));
        } else if (vacaActual == 4) {
            vaca4B_text_view.setText(String.valueOf(puntos));
        } else if (vacaActual == 5) {
            vaca5B_text_view.setText(String.valueOf(puntos));
        }
    }

    public void mas1EquipoB(View view) {
        puntosB = puntosB + 1;
        mostrarEquipoB(puntosB);
    }

    public void menos1EquipoB(View view) {
        puntosB = puntosB - 1;
        mostrarEquipoB(puntosB);
    }

    public void ordagoA(View view) {
        int paraOrdago = 40 - puntosA;
        puntosA = puntosA + paraOrdago;
        mostrarEquipoA(puntosA);
    }

    public void ordagoB(View view) {
        int paraOrdago = 40 - puntosB;
        puntosB = puntosB + paraOrdago;
        mostrarEquipoB(puntosB);
    }

    public void mostrarGrandesPendientes(int score) {
        Grandes_pendientes_text_view.setText(String.valueOf(score));
    }

    public void mostrarChicasPendientes(int score) {

        Chicas_pendientes_text_view.setText(String.valueOf(score));
    }

    public void mostrarParesPendientes(int score) {
        TextView scoreView = (TextView) findViewById(R.id.pend_pares);
        scoreView.setText(String.valueOf(score));
    }

    public void mostrarJuegoPendientes(int score) {
        TextView scoreView = (TextView) findViewById(R.id.pend_juego);
        scoreView.setText(String.valueOf(score));
    }

    public void mas1GrandesPendientes(View view) {
        grandesPendientes = grandesPendientes + 1;
        mostrarGrandesPendientes(grandesPendientes);
    }

    public void mas1ChicasPendientes(View view) {
        chicasPendientes = chicasPendientes + 1;
        mostrarChicasPendientes(chicasPendientes);
    }

    public void mas1ParesPendientes(View view) {
        paresPendientes = paresPendientes + 1;
        mostrarParesPendientes(paresPendientes);
    }

    public void mas1JuegoPendientes(View view) {
        juegoPendientes = juegoPendientes + 1;
        mostrarJuegoPendientes(juegoPendientes);
    }

    public void mas5GrandesPendientes(View view) {
        grandesPendientes = grandesPendientes + 5;
        mostrarGrandesPendientes(grandesPendientes);
    }

    public void mas5ChicasPendientes(View view) {
        chicasPendientes = chicasPendientes + 5;
        mostrarChicasPendientes(chicasPendientes);
    }

    public void mas5ParesPendientes(View view) {
        paresPendientes = paresPendientes + 5;
        mostrarParesPendientes(paresPendientes);
    }

    public void mas5JuegoPendientes(View view) {
        juegoPendientes = juegoPendientes + 5;
        mostrarJuegoPendientes(juegoPendientes);
    }

    public void agregarGrandesPendientesA(View view) {
        puntosA = puntosA + grandesPendientes;
        mostrarEquipoA(puntosA);
        grandesPendientes = 0;
        mostrarGrandesPendientes(grandesPendientes);
    }

    public void agregarChicasPendientesA(View view) {
        puntosA = puntosA + chicasPendientes;
        mostrarEquipoA(puntosA);
        chicasPendientes = 0;
        mostrarChicasPendientes(chicasPendientes);
    }

    public void agregarParesPendientesA(View view) {
        puntosA = puntosA + paresPendientes;
        mostrarEquipoA(puntosA);
        paresPendientes = 0;
        mostrarParesPendientes(paresPendientes);
    }

    public void agregarJuegoPendientesA(View view) {
        puntosA = puntosA + juegoPendientes;
        mostrarEquipoA(puntosA);
        juegoPendientes = 0;
        mostrarJuegoPendientes(juegoPendientes);
    }

    public void agregarGrandesPendientesB(View view) {
        puntosB = puntosB + grandesPendientes;
        mostrarEquipoB(puntosB);
        grandesPendientes = 0;
        mostrarGrandesPendientes(grandesPendientes);
    }

    public void agregarChicasPendientesB(View view) {
        puntosB = puntosB + chicasPendientes;
        mostrarEquipoB(puntosB);
        chicasPendientes = 0;
        mostrarChicasPendientes(chicasPendientes);
    }

    public void agregarParesPendientesB(View view) {
        puntosB = puntosB + paresPendientes;
        mostrarEquipoB(puntosB);
        paresPendientes = 0;
        mostrarParesPendientes(paresPendientes);
    }

    public void agregarJuegoPendientesB(View view) {
        puntosB = puntosB + juegoPendientes;
        mostrarEquipoB(puntosB);
        juegoPendientes = 0;
        mostrarJuegoPendientes(juegoPendientes);
    }

    public void agregarParesPar(View view) {
        if (radioButtonParesA.isChecked()) {
            puntosA = puntosA + 1;
            mostrarEquipoA(puntosA);
            paresRadioGroup.clearCheck();

        } else if (radioButtonParesB.isChecked()) {
            puntosB = puntosB + 1;
            mostrarEquipoB(puntosB);
            paresRadioGroup.clearCheck();

        } else {
            Toast.makeText(getApplicationContext(), "Seleccionar equipo", Toast.LENGTH_SHORT).show();
        }

    }

    public void agregarParesMedias(View view) {
        if (radioButtonParesA.isChecked()) {
            puntosA = puntosA + 2;
            mostrarEquipoA(puntosA);
            paresRadioGroup.clearCheck();

        } else if (radioButtonParesB.isChecked()) {
            puntosB = puntosB + 2;
            mostrarEquipoB(puntosB);
            paresRadioGroup.clearCheck();

        } else {
            Toast.makeText(getApplicationContext(), "Seleccionar equipo", Toast.LENGTH_SHORT).show();
        }

    }

    public void agregarParesDuples(View view) {


        if (radioButtonParesA.isChecked()) {
            puntosA = puntosA + 3;
            mostrarEquipoA(puntosA);
            paresRadioGroup.clearCheck();

        } else if (radioButtonParesB.isChecked()) {
            puntosB = puntosB + 3;
            mostrarEquipoB(puntosB);
            paresRadioGroup.clearCheck();

        } else {
            Toast.makeText(getApplicationContext(), "Seleccionar equipo", Toast.LENGTH_SHORT).show();
        }

    }

    public void agregarJuego31(View view) {
        if (radioButtonJuegoA.isChecked()) {
            puntosA = puntosA + 3;
            mostrarEquipoA(puntosA);
            juegoRadioGroup.clearCheck();

        } else if (radioButtonJuegoB.isChecked()) {
            puntosB = puntosB + 3;
            mostrarEquipoB(puntosB);
            juegoRadioGroup.clearCheck();

        } else {
            Toast.makeText(getApplicationContext(), "Seleccionar equipo", Toast.LENGTH_SHORT).show();
        }

    }

    public void agregarJuegoJuego(View view) {


        if (radioButtonJuegoA.isChecked()) {
            puntosA = puntosA + 2;
            mostrarEquipoA(puntosA);
            //RadioGroup.clearCheck();

        } else if (radioButtonJuegoB.isChecked()) {
            puntosB = puntosB + 2;
            mostrarEquipoB(puntosB);

        } else {
            Toast.makeText(getApplicationContext(), "Seleccionar equipo", Toast.LENGTH_SHORT).show();
        }

    }

    public void borrarVacas(View view) {
        puntosA = 0;
        puntosB = 0;
        vacaActual = 1;
        vaca1A_text_view.setText(String.valueOf("0"));
        vaca2A_text_view.setText(String.valueOf("0"));
        vaca3A_text_view.setText(String.valueOf("0"));
        vaca4A_text_view.setText(String.valueOf("0"));
        vaca5A_text_view.setText(String.valueOf("0"));
        vaca1B_text_view.setText(String.valueOf("0"));
        vaca2B_text_view.setText(String.valueOf("0"));
        vaca3B_text_view.setText(String.valueOf("0"));
        vaca4B_text_view.setText(String.valueOf("0"));
        vaca5B_text_view.setText(String.valueOf("0"));

    }

    public void borrarPendientes(View view) {
        grandesPendientes = 0;
        chicasPendientes = 0;
        paresPendientes = 0;
        juegoPendientes = 0;
        mostrarGrandesPendientes(grandesPendientes);
        mostrarChicasPendientes(chicasPendientes);
        mostrarParesPendientes(paresPendientes);
        mostrarJuegoPendientes(juegoPendientes);
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
