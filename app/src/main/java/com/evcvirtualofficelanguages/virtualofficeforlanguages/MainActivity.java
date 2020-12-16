package com.evcvirtualofficelanguages.virtualofficeforlanguages;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference refdb = FirebaseDatabase.getInstance().getReference();
    private FirebaseAuth usuario= FirebaseAuth.getInstance();
    private static final String TAG = "EmailPassword";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

/*
        usuario.createUserWithEmailAndPassword("edervc@gmail.com","teste").addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete( @NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()){

                            Log.i("CreateUserTask", "Usuario criado com sucesso");
                        } else {
                            Log.i("CreateUserTask", "Erro ao cadastrar o usuario");

                        }

                    }
                }); */



        usuario.createUserWithEmailAndPassword("edervc@gmail.com","teste")
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = usuario.getCurrentUser();
                            //updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(MainActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            //updateUI(null);
                        }

                        // [START_EXCLUDE]
                        //hideProgressBar();
                        // [END_EXCLUDE]
                    }
                });


/*

        if (usuario.getCurrentUser()!=null) {
            Log.i("CreateUser", "Usuario logado");
        } else {
            Log.i("CreateUser", "Usuario nao logado");
        }

        DatabaseReference usuarios = refdb.child("usuarios");


          Usuario usr = new Usuario();
          usr.setNome("Eder");
          usr.setSobrenome("Vieira");
          usr.setEmail("edervc_gmail.com");

          usuarios.child("001").setValue(usr);

            usuarios.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    Log.i("FIREBASE",dataSnapshot.getValue().toString());
                }

                @Override
                public void onCancelled( DatabaseError databaseError) {

                }
            });
*/

    }
}
