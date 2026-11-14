/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kampus.kuis2pbo;

/**
 *
 * @author NABIL MUHAMMAD S
 */
public abstract class EntitasBengkel {
    private String idEntity;
    private String namaEntity;
    
    public EntitasBengkel(String idEntity, String namaEntity){
        this.idEntity = idEntity;
        this.namaEntity = namaEntity;
    }
    
    public abstract void tampilkanInfo();
    
}
