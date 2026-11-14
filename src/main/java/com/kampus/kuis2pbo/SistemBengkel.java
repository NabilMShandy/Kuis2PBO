/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kampus.kuis2pbo;

import java.util.ArrayList;
import java.util.HashMap;
import java.io.*;
import java.util.Scanner;

/**
 *
 * @author NABIL MUHAMMAD S
 */
public class SistemBengkel implements Serializable {

    private static final long serialVersionUID = 1L;

    private ArrayList<LayananServis> daftarLayananServis;
    private HashMap<String, Pelanggan> dataPelanggan;
    private String namaBengkel;
    private GudangSparePart gudangSparePart;

    public SistemBengkel(String namaBengkel) {
        this.namaBengkel = namaBengkel;
        this.daftarLayananServis = new ArrayList<>();
        this.dataPelanggan = new HashMap<>();

        // Composition
        this.gudangSparePart = new GudangSparePart();
        this.gudangSparePart.cekKesiapan();
    }

    // Penerapan Aggregation (LayananServis)    
    public void tambahLayananServis(String kodeLayananServis, String namaLayananServis, int kuotaLayananServis) {
        daftarLayananServis.add(new LayananServis(kodeLayananServis, namaLayananServis, kuotaLayananServis));
    }

    // Penerapan Aggregation (Pelanggan)
    public void tambahPelanggan(String idPelanggan, String namaPelanggan) {
        Pelanggan pel = new Pelanggan(idPelanggan, namaPelanggan);
        this.dataPelanggan.put(idPelanggan, pel);
    }

    // Helper untuk cari objek LayananServis di dalam ArrayList
    private LayananServis cariLayanan(String kode) {
        for (LayananServis ls : daftarLayananServis) {
            if (ls.getKodeLayanan().equalsIgnoreCase(kode)) {
                return ls;
            }
        }
        return null;
    }

    // Baca dan Parsing data sesuai format format Strip & Pipe (ID-ACT-01/KD-OBJ-A/JML-3/|)
    // Baca file archive_mem.bin
    public void jalankanTransaksiDariFile(String namaFile) throws Exception {
        try {
            File file = new File(namaFile);
            Scanner scan = new Scanner(file);

            while (scan.hasNextLine()) {
                String baris = scan.nextLine().trim();
                if (baris.isEmpty()) {
                    continue;
                }

                // Pecah dengan delimiter |
                String[] daftarTransaksi = baris.split("\\|");

                for (String var : daftarTransaksi) {
                    if (var.trim().isEmpty()) {
                        continue;
                    }

                    try {
                        String[] bagian = var.split("/");
                        if (bagian.length < 3) {
                            throw new FormatDataInvalidException("Format segmen tidak lengkap" + var);
                        }

                        // Bersihkan prefix "ID-", "KD-", "JML--"
                        String idPelanggan = bagian[0].replace("ID-", "").trim();
                        String kodeLayanan = bagian[1].replace("KD-", "").trim();
                        int jumlah = Integer.parseInt(bagian[2].replace("JML-", "").trim());

                        Pelanggan pelanggan = dataPelanggan.get(idPelanggan);

                        if (pelanggan == null) {
                            throw new FormatDataInvalidException("Pelanggan dengan ID " + idPelanggan + " tidak terdaftar.");
                        }

                        LayananServis layanan = cariLayanan(kodeLayanan);

                        if (layanan == null) {
                            throw new FormatDataInvalidException("Layanan dengan kode " + kodeLayanan + " tidak terdaftar.");
                        }

                        // Penerapan Association
                        TransaksiServis.prosesServis(pelanggan, layanan, jumlah);
                    }
                    catch(Exception e){
                        System.out.println("[ERROR] Terjadi kesalahan " + e.getMessage());
                    }
                }  
            }
            scan.close();
        } 
        catch (Exception e) {
            System.out.println("[DITOLAK] " + e.getMessage());
        }
    }
    
    public void simpanLaporanAkhir(){
        try {
            FileWriter writer = new FileWriter("archive_mem.bin");
            writer.write("=== LAPORAN SISA KUOTA LAYANAN (" +  this.namaBengkel + ") ===\n");
            
            for(LayananServis ls : this.daftarLayananServis){
                String barisLaporan = String.format("Kode: %-8s | Layanan: %-22s | Sisa Kuota: %d\n", 
                        ls.getKodeLayanan(), ls.getNamaLayanan(), ls.getKuotaServis());
                writer.write(barisLaporan);
            }
            System.out.println("[LAPORAN TERSIMPAN] Sisa kuota berhasil ditulis ke archive_mem.bin");
            
            writer.close();
        } 
        catch (IOException e) {
            System.out.println("[ERROR] Gagal menyimpan laporan akhir: " + e.getMessage());
        }
    }
}