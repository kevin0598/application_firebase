package com.example.asus.application_firebase;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class adapter extends RecyclerView.Adapter<adapter.MahasiswaViewHolder> {
    ItemClickListener itemclick;
    List<Mahasiswa> mdata;
    Context context;

    public adapter(List<Mahasiswa> mdata, Context context) {
        this.mdata = mdata;
        this.context = context;
    }

    @NonNull
    @Override
    public adapter.MahasiswaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
        return new adapter.MahasiswaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull adapter.MahasiswaViewHolder mahasiswaViewHolder, int i) {
        final Mahasiswa mhs= mdata.get(i);
        mahasiswaViewHolder.nim.setText("Nim = "+mhs.getNim());
        mahasiswaViewHolder.nama.setText("Nama = "+mhs.getNama());
        mahasiswaViewHolder.prodi.setText("Prodi = "+mhs.getProdi());
        mahasiswaViewHolder.tugas.setText("Nilai Tugas = "+tugas(mhs));
        mahasiswaViewHolder.quiz.setText("Nilai Quiz = "+quiz(mhs));
        mahasiswaViewHolder.mid.setText("Nilai Mid = "+mid(mhs));
        mahasiswaViewHolder.fin.setText("Nilai Final = "+akhir(mhs));
        mahasiswaViewHolder.akhir.setText("Nilai Akhir = "+total(mhs));
        mahasiswaViewHolder.huruf.setText("Huruf = "+mhs.getHuruf());

    }

    private String tugas(Mahasiswa mhs){
        return String.valueOf(mhs.getTugas());
    }

    private String quiz(Mahasiswa mhs){
        return String.valueOf(mhs.getQuiz());
    }

    private String mid(Mahasiswa mhs){
        return String.valueOf(mhs.getMid());
    }

    private String akhir(Mahasiswa mhs){
        return String.valueOf(mhs.getAkhir());
    }

    private String total(Mahasiswa mhs){
        return String.valueOf(mhs.getTotal());
    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    public class MahasiswaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView nama,prodi,nim,tugas,quiz,mid,fin,akhir,huruf;
        public MahasiswaViewHolder(@NonNull View itemView) {
            super(itemView);
            nim= itemView.findViewById(R.id.Nim);
            nama= itemView.findViewById(R.id.Nama);
            prodi= itemView.findViewById(R.id.Prodi);
            tugas= itemView.findViewById(R.id.Tugas);
            quiz= itemView.findViewById(R.id.Quiz);
            mid= itemView.findViewById(R.id.Mid);
            fin= itemView.findViewById(R.id.Final);
            akhir= itemView.findViewById(R.id.Akhir);
            huruf= itemView.findViewById(R.id.Huruf);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (itemclick!=null){
                itemclick.onItemClick(v,getAdapterPosition());
            }
        }
    }

    void setItemclick(ItemClickListener itemclick){
        this.itemclick= itemclick;
    }

    public interface ItemClickListener {
        void onItemClick(View view,int position);
    }

}
