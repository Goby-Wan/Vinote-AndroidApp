package com.sio2017.vinote;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class VinActivity extends AppCompatActivity {

    Vin vin ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        vin = (Vin) getIntent().getSerializableExtra("vin") ;

        setContentView(R.layout.activity_vin);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle(vin.getAppellation());
        refreshVin();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Commenter...", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void refreshVin(){

        ImageView photo = (ImageView) findViewById(R.id.photo); photo.setImageURI(Uri.parse(vin.getPhoto()));
        TextView appellation = (TextView) findViewById(R.id.appellation); appellation.setText(vin.getAppellation());
        TextView annee = (TextView) findViewById(R.id.annee); annee.setText(Integer.toString(vin.getAnnee()));
        TextView domaine = (TextView) findViewById(R.id.domaine); domaine.setText(vin.getExposant().getDomaine());
        TextView score = (TextView) findViewById(R.id.score); score.setText(Integer.toString(vin.getScore()));
        ProgressBar barScore = (ProgressBar) findViewById(R.id.barScore); barScore.setProgress(vin.getScore());
        TextView cepage = (TextView) findViewById(R.id.cepage); cepage.setText(vin.getCepage());
        TextView type = (TextView) findViewById(R.id.type); type.setText(vin.getType());
        ImageView imageType = (ImageView) findViewById(R.id.imageType);
        switch(vin.getType()){
            case "Blanc":
                imageType.setImageResource(getResources().getIdentifier("com.sio2017.vinote:drawable/wine_white", null, null));
                break;
            case "Rosé":
                imageType.setImageResource(getResources().getIdentifier("com.sio2017.vinote:drawable/wine_pink", null, null));
                break;
            case "Rouge":
            default:
                imageType.setImageResource(getResources().getIdentifier("com.sio2017.vinote:drawable/wine_red", null, null));
                System.out.println("ID = " + getResources().getIdentifier("com.sio2017.vinote:drawable/wine_red", null, null));
                break;
        }
        TextView alcool = (TextView) findViewById(R.id.alcool); alcool.setText(Integer.toString(vin.getAlcool()) + "% d'alcool");
        TextView prix = (TextView) findViewById(R.id.prix); prix.setText(Integer.toString(vin.getPrix()) + " €");
        TextView description = (TextView) findViewById(R.id.description); description.setText(vin.getDescription());
        TextView avis = (TextView) findViewById(R.id.avis); avis.setText(vin.getAvis());
    }

}
