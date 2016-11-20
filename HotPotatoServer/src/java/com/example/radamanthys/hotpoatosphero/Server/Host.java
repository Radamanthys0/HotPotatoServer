package com.example.radamanthys.hotpoatosphero.Server;


import com.example.radamanthys.hotpoatosphero.Server.Cliente;



/**
 * A classe Host herda de cliente, ja que o host nada mais é do que um cliente especial
 *
 * */

public class Host extends Cliente
{
	public Host(String nome)
	{
		/*
		 * Ja que Host herda de Cliente, ele precisa chamar o
		 * construtor dele.
		 */
		super(nome);
	}
}

/*
 * Tome nota, qualquer alteracao em Cliente/Host ou em qualquer objeto
 * que seja codificado via XStream e enviado, deve ser refletida no cliente
 * e no servidor para que nao haja inconsistencias entre os objetos ;)
 */