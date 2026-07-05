package com.solidusjack.todolist.model;

public abstract class Tarefa{
	
	private int id;
	private String descricao;
	private boolean statusConclusao;
	
	public static int contador = 1;
	
	protected Tarefa(String descricao) {
		this.id = contador++;
		this.descricao = descricao;
		this.statusConclusao = false;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public boolean isStatusConclusao() {
		return statusConclusao;
	}
	public void setStatusConclusao(boolean statusConclusao) {
		this.statusConclusao = statusConclusao;
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
