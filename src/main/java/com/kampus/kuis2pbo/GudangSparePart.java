/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kampus.kuis2pbo;

/**
 *
 * @author NABIL MUHAMMAD S
 */
public class GudangSparePart {
    private String namaGudang;
    private String statusGudang;
    
    public GudangSparePart(){
        this.namaGudang = "Bengkel Pak Hambali";
        this.statusGudang = "Operasional";
    }
    
    public void cekKesiapan(){
        System.out.println("[SYSTEM] " + this.namaGudang + " siap (" + this.statusGudang + ").");
    }
}
