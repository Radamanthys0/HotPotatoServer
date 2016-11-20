package com.example.radamanthys.hotpoatosphero.Server;


/**
 * A classe Cliente lida com todos os atributos que um cliente possui
 */

public class Cliente
{
	private int    vez; 
	private String nome;
        private int prox;
        private int cor;
        private int message_type;
	
	public Cliente(String nome){ this.nome = nome; }
	
	public void setVez(int vez){ this.vez = vez; }
	public int  getVez(){ return this.vez; }
	
	public void   setNome(String nome){ this.nome = nome; }
	public String getNome(){ return this.nome; }
        
        public void   setProx(int prox){ this.prox = prox; }
	public int getProx(){ return this.prox; }
        
        public void setCor(int cor){ this.cor = cor; }
	public int  getCor(){ return this.cor; }
        
	public void setMessage_type(int message){ this.message_type= message; }
	public int getMessage_type(){ return this.message_type; }
}
