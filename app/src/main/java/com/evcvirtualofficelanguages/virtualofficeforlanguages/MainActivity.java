package com.evcvirtualofficelanguages.virtualofficeforlanguages;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference refdb = FirebaseDatabase.getInstance().getReference();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseReference usuarios = refdb.child("usuarios");


          Usuario usr = new Usuario();
          usr.setNome("Eder");
          usr.setSobrenome("Vieira");

        usuarios.child("001").setValue(usr);




    }
}
