package com.solidusjack.todolist.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public abstract class Tarefa{

	private int id;
	private String descricao;
	private boolean statusConclusao;
	
	public Tarefa(String descricao) {
		this.descricao = descricao;
		this.statusConclusao = false;
	}
	
	@Override
	public String toString() {
	    String status = this.statusConclusao ? "Concluída" : "Pendente";
	    return "------------------------------------\n" +
	           " TAREFA #" + this.id + "\n" +
	           " Descrição: " + this.descricao + "\n" +
	           " Status   : " + status + "\n";
	}

}
