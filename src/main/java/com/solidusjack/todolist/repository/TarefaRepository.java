package com.solidusjack.todolist.repository;

import java.util.ArrayList;
import java.util.List;

import com.solidusjack.todolist.model.Tarefa;
import com.solidusjack.todolist.contract.Gerenciavel;

public class TarefaRepository implements Gerenciavel{
	
	List<Tarefa> listaTarefas = new ArrayList<>();
		
	public void adicionarTarefa(Tarefa tarefa) {
		listaTarefas.add(tarefa);
	}
	
	@Override
	public void concluirTarefa(int valor) {
		
		if(listaTarefas.isEmpty()) {
			System.out.println("adicione uma tarefa primeiro");
			return;
		} else if(valor <= 0 ) {
				System.out.println("id invalido");
				return;
		}
		
		int id = --valor;
		
		try {
			if (listaTarefas.get(id).isStatusConclusao()) {
				 System.out.println("A tarefa ja está Concluida!");
				 return;
			 } else {
				 listaTarefas.get(id).setStatusConclusao(true);
				 System.out.println("Tarefa Concluida!");
			 }
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Tarefa não encontrada!\n");
			}		
	}

	@Override
	public void exibirDetalhes() {
		listaTarefas.stream().forEach(e -> System.out.println(e));
	}
}
