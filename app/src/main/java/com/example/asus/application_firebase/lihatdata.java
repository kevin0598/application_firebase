package com.example.asus.application_firebase;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Adapter;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class lihatdata extends AppCompatActivity implements adapter.ItemClickListener{
    static FirebaseDatabase database=FirebaseDatabase.getInstance();
    static DatabaseReference databaseReference=database.getReference();

    List<Mahasiswa> mhsData=new ArrayList<>();

    adapter adapter;
    RecyclerView view1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihatdata);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                mhsData.clear();
                DataSnapshot nilaipbo=dataSnapshot.child("NilaiPBo");
                for (DataSnapshot postsnapshot:nilaipbo.getChildren()){
                    Mahasiswa mhs = new Mahasiswa();
                    mhs.setNim(postsnapshot.getKey());
                    mhs.setNama(postsnapshot.child("nama").getValue().toString());
                    mhs.setProdi();
                    mhs.setTugas(Double.parseDouble(postsnapshot.child("tugas").getValue().toString()));
                    mhs.setQuiz(Double.parseDouble(postsnapshot.child("quiz").getValue().toString()));
                    mhs.setMid(Double.parseDouble(postsnapshot.child("mid").getValue().toString()));
                    mhs.setAkhir(Double.parseDouble(postsnapshot.child("akhir").getValue().toString()));
                    mhs.setTotal();
                    mhs.setHuruf();
                    mhsData.add(mhs);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        view1=findViewById(R.id.view1);
        view1.setHasFixedSize(true);
        view1.setLayoutManager(new LinearLayoutManager(this));
        adapter = new adapter(mhsData, lihatdata.this);
        adapter.setItemclick(this);
        view1.setAdapter(adapter);

        DividerItemDecoration divider=new DividerItemDecoration(view1.getContext(),DividerItemDecoration.VERTICAL);
        view1.addItemDecoration(divider);
    }



    @Override
    public void onItemClick(View view, int position) {
        Mahasiswa mhs= mhsData.get(position);
        Intent intent=new Intent(lihatdata.this,EditData.class);

        intent.putExtra("nim",mhs.getNim());
        intent.putExtra("nama",mhs.getNama());
        intent.putExtra("tugas",mhs.getTugas());
        intent.putExtra("quiz",mhs.getQuiz());
        intent.putExtra("mid",mhs.getMid());
        intent.putExtra("akhir",mhs.getAkhir());
        Toast.makeText(lihatdata.this,"terclick",Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }
}
