/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kampus.kuis2pbo;

/**
 *
 * @author NABIL MUHAMMAD S
 */
public class LayananServis extends Layanan {

    private int kuotaServis;

    public LayananServis(String kodeLayanan, String namaLayanan, int kuotaServis) {
        super(kodeLayanan, namaLayanan);
        this.kuotaServis = kuotaServis;
    }

    public int getKuotaServis() {
        return this.kuotaServis;
    }

    public void kurangiKuota(int jumlah) throws FormatDataInvalidException{
        if(jumlah <= 0){
           throw new FormatDataInvalidException("Jumlah kuota yang diinginkan tidak valid!");
        }
        
        if(this.kuotaServis < jumlah){
            throw new FormatDataInvalidException("Kuota servis kurang dari jumlah yang diingikan!");
        }
        this.kuotaServis-=jumlah;
    }
   
    @Override
    public void tampilkanInfo() {
        System.out.printf("[Layanan Servis] Kode: %-8s | Nama: %-22s | Sisa Kuota: %d\n", getKodeLayanan(), getNamaLayanan(), getKuotaServis());
    }
}
