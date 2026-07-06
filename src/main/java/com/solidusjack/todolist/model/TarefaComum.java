package com.solidusjack.todolist.model;

public class TarefaComum extends Tarefa{
	
	public TarefaComum(String descricao) {
		super(descricao);
	}

	@Override
	public String toString() {
	    return super.toString() + "\n" +
	           "------------------------------------";
	}
}
