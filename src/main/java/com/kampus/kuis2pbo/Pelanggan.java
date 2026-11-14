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
public class Pelanggan implements Serializable {

    private String idPelanggan;
    private String namaPelanggan;

    public Pelanggan(String idPelanggan, String namaPelanggan) {
        this.idPelanggan = idPelanggan;
        this.namaPelanggan = namaPelanggan;
    }

    public String getNamaPelanggan() {return this.namaPelanggan;}
    public String getIdPelanggan() {return this.idPelanggan;}
    
}
