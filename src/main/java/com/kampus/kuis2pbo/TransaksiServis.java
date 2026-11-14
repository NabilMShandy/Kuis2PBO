/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kampus.kuis2pbo;

/**
 *
 * @author NABIL MUHAMMAD S
 */
public class TransaksiServis {
    public static void prosesServis(Pelanggan p, LayananServis ls, int jumlah) throws FormatDataInvalidException{
        ls.kurangiKuota(jumlah);
        System.out.println("[TRANSAKSI BERHASIL] (ID Pelangan: " + p.getIdPelanggan()+ 
                ") | (Layanan: " + ls.getNamaLayanan() + ") | (Jumlah: " + jumlah);
    }
}