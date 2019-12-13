package com.example.asus.application_firebase;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EditData extends AppCompatActivity {
    private FirebaseDatabase database =FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference=database.getReference();
    EditText text1;
    EditText text2;
    EditText text3;
    EditText text4;
    EditText text5;
    EditText text6;
    Button button1;
    Button button2;
    Button button3;
    String nim;
    String nama;
    Double tugas;
    Double quiz;
    Double mid;
    Double akhir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_data);
        text1=findViewById(R.id.text1);
        text2=findViewById(R.id.text2);
        text3=findViewById(R.id.text3);
        text4=findViewById(R.id.text4);
        text5=findViewById(R.id.text5);
        text6=findViewById(R.id.text6);
        button1=findViewById(R.id.button1);
        button2=findViewById(R.id.button2);
        button3=findViewById(R.id.button3);
        Intent receivedintent=getIntent();


        if (receivedintent.hasExtra("nim")){
            this.nim=getIntent().getStringExtra("nim");
        }

        if (receivedintent.hasExtra("nama")){
            this.nama=getIntent().getStringExtra("nama");
        }

        if (receivedintent.hasExtra("tugas")){
            this.tugas=getIntent().getDoubleExtra("tugas",0);
        }

        if (receivedintent.hasExtra("quiz")){
            this.quiz=getIntent().getDoubleExtra("quiz",0);
        }

        if (receivedintent.hasExtra("mid")){
            this.mid=getIntent().getDoubleExtra("mid",0);
        }

        if (receivedintent.hasExtra("akhir")){
            this.akhir=getIntent().getDoubleExtra("akhir",0);
        }

        text1.setText(nim);
        text2.setText(nama);
        text3.setText(String.valueOf(tugas));
        text4.setText(String.valueOf(quiz));
        text5.setText(String.valueOf(mid));
        text6.setText(String.valueOf(akhir));

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseReference.child("NilaiPBo").child(nim).removeValue(new DatabaseReference.CompletionListener() {
                    @Override
                    public void onComplete(@Nullable DatabaseError databaseError, @NonNull DatabaseReference databaseReference) {
                        Toast.makeText(EditData.this,"Berhasil Dihapus",Toast.LENGTH_SHORT).show();
                    }

                });
                Intent intent=new Intent(EditData.this,lihatdata.class);
                startActivity(intent);
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                databaseReference.child("NilaiPBo").child(nim).removeValue(new DatabaseReference.CompletionListener() {
                    @Override
                    public void onComplete(@Nullable DatabaseError databaseError, @NonNull DatabaseReference databaseReference) {
                        Toast.makeText(EditData.this,"berhasil diupdate",Toast.LENGTH_SHORT).show();
                    }
                });
                String NIM;
                Mahasiswa mhs=new Mahasiswa();
                NIM=text1.getText().toString();
                mhs.setNim(text1.getText().toString());
                mhs.setNama(text2.getText().toString());
                mhs.setTugas(Double.parseDouble(text3.getText().toString()));
                mhs.setQuiz(Double.parseDouble(text4.getText().toString()));
                mhs.setMid(Double.parseDouble(text5.getText().toString()));
                mhs.setAkhir(Double.parseDouble(text6.getText().toString()));
                mhs.setProdi();
                mhs.setTotal();
                mhs.setHuruf();
                databaseReference.child("NilaiPBo").child(NIM).setValue(mhs);
                Intent intent=new Intent(EditData.this,lihatdata.class);
                startActivity(intent);
            }
        });
    }
}
