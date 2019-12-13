package com.example.asus.application_firebase;

public class Mahasiswa {
    private String nim;
    private String nama;
    private String prodi;
    private double tugas;
    private double quiz;
    private double mid;
    private double akhir;
    private double total;
    private String huruf;

    public Mahasiswa(){

    }

    public Mahasiswa(String nim,String nama,String prodi,double tugas,double quiz,double mid,double akhir,double total,String huruf){
        this.nim=nim;
        this.nama=nama;
        this.prodi=prodi;
        this.tugas=tugas;
        this.quiz=quiz;
        this.mid=mid;
        this.akhir=akhir;
        this.total=total;
        this.huruf=huruf;
    }

    public void setNim(String nim){
        this.nim=nim;
    }

    public void setNama(String nama){
        this.nama=nama;
    }

    public void setProdi(){
        if (this.nim.startsWith("520")) {
            this.prodi="Teknik Informatika";
        } else if (this.nim.startsWith("510")){
            this.prodi="Sistem Informasi";
        } else {
            this.prodi="Tidak Diketahui";
        }
    }

    public void setTugas(double tugas){
        this.tugas=tugas;
    }

    public void setQuiz(double quiz){
        this.quiz=quiz;
    }

    public void setMid(double mid){
        this.mid=mid;
    }

    public void setAkhir(double akhir){
        this.akhir=akhir;
    }

    public void setTotal(){
        this.total=0.3*this.tugas+0.1*this.quiz+0.3*this.mid+0.3*this.akhir;
    }

    public void setHuruf(){
        if (this.total>=80){
            this.huruf="A";
        } else if (this.total>=60 && this.total<80){
            this.huruf="B";
        } else if (this.total>=50 && this.total<60){
            this.huruf="C";
        } else if (this.total>=40 && this.total<50){
            this.huruf="D";
        } else if (this.total<40){
            this.huruf="E";
        } else {
            this.huruf="Tidak Diketahui";
        }
    }

    public String getNim() {
        return nim;
    }

    public String getNama() {
        return nama;
    }

    public String getProdi() {
        return prodi;
    }

    public double getTugas() {
        return tugas;
    }

    public double getQuiz() {
        return quiz;
    }

    public double getMid() {
        return mid;
    }

    public double getAkhir() {
        return akhir;
    }

    public double getTotal() {
        return total;
    }

    public String getHuruf() {
        return huruf;
    }

}
