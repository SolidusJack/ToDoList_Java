package com.solidusjack.todolist.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class TarefaUrgente extends Tarefa{
	
	private LocalDate dataLimite;
	
	public TarefaUrgente(String descricao,LocalDate dataLimite) {
		super(descricao);
		this.dataLimite = dataLimite;
	}

	@Override
	public String toString() {
	    DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    String dataFormatada = this.dataLimite.format(formatador);
	    return  super.toString() + "\n" +
	    "[URGENTE]\n " + 
	    " Prazo    : " + dataFormatada + "\n" +
	    "------------------------------------" ;
	}
}


