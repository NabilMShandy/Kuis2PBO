/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kampus.kuis2pbo;

import java.io.Serializable;

/**
 *
 * @author NABIL MUHAMMAD S
 */
public abstract class Layanan implements Serializable{
    private static final long serialVersionUID = 1L;
    private String kodeLayanan;
    private String namaLayanan;
    
    public Layanan(String kodeLayanan, String namaLayanan){
        this.kodeLayanan = kodeLayanan;
        this.namaLayanan = namaLayanan;
    }
    
    public String getKodeLayanan(){
        return this.kodeLayanan;
    }
    
    public String getNamaLayanan(){
        return this.namaLayanan;
    }
    
    public abstract void tampilkanInfo();
}
