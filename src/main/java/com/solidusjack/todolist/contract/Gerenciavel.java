package com.solidusjack.todolist.contract;

import com.solidusjack.todolist.model.Tarefa;

public interface Gerenciavel {
	
	void adicionarTarefa(Tarefa tarefa);
	
	void concluirTarefa(int id);
	
	void exibirDetalhes();
}
