/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.radamanthys.hotpoatosphero.Server;

/**
 *
 * @author Radamanthys
 */
public class PassaVez {
     String atual;
    String prox;

    public PassaVez(String atual, String prox){
        this.atual = atual;
        this.prox = prox;
    }

    public void   setProx(String prox){ this.prox = prox; }

    public  String getAtual (){return this.atual;}
    public String getProx(){ return this.prox; }
}
