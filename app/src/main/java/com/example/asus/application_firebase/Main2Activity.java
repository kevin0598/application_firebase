package com.example.asus.application_firebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Main2Activity extends AppCompatActivity {
    private DatabaseReference mnilaipboRef;
    TextView view1;
    EditText text1;
    EditText text2;
    EditText text3;
    EditText text4;
    EditText text5;
    EditText text6;
    Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        view1=(TextView) findViewById(R.id.view1);
        text1=(EditText) findViewById(R.id.text1);
        text2=(EditText) findViewById(R.id.text2);
        text3=(EditText) findViewById(R.id.text3);
        text4=(EditText) findViewById(R.id.text4);
        text5=(EditText) findViewById(R.id.text5);
        text6=(EditText) findViewById(R.id.text6);
        button1=(Button) findViewById(R.id.button1);
        mnilaipboRef = FirebaseDatabase.getInstance().getReference().child("NilaiPBo");
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
                mnilaipboRef.child(NIM).setValue(mhs);
                Toast.makeText(Main2Activity.this, "Data Berhasil di input", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
