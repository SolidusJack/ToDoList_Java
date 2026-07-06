package com.solidusjack.todolist;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.solidusjack.todolist.model.TarefaComum;
import com.solidusjack.todolist.model.TarefaUrgente;
import com.solidusjack.todolist.repository.TarefaRepository;

public class App {
    public static void main( String[] args ) {
    	
    	Scanner sc = new Scanner(System.in);
    	
    	var repo = new TarefaRepository();
    	
    	boolean OP = true;
    	while(OP) {
            System.out.println("\n==========================================");
            System.out.println("       SISTEMA DE GERENCIAMENTO TO-DO     ");
            System.out.println("==========================================");
            System.out.println(" Painel de Controle dos Usuários          ");
            System.out.println("------------------------------------------");
            System.out.println(" [1] Criar uma nova tarefa");
            System.out.println(" [2] Exibir todas as tarefas");
            System.out.println(" [3] Concluir uma tarefa");
            System.out.println(" [4] Sair do sistema");
            System.out.println("------------------------------------------");
            
            int opcao = sc.nextInt();
            
            switch(opcao) {
            case 1 ->  {
            	System.out.println("\n------------------------------------------");
            	System.out.println("   [NOVA TAREFA] Tipo de Cadastro         ");
            	System.out.println("------------------------------------------");
            	System.out.println(" 1. Tarefa Comum");
            	System.out.println(" 2. Tarefa Urgente (Exige data limite)");
            	System.out.println(" 3. Voltar");
            		int escolha = sc.nextInt();
            		sc.nextLine();
            		switch (escolha) {
            			case 1 -> {
            				System.out.println("Digite a descrição da tarefa");
            				String descricao = sc.nextLine();
            				
            				repo.adicionarTarefa(new TarefaComum(descricao));
            				System.out.println("\n [SUCESSO] Tarefa comum cadastrada!");
            				
            				try {
            					Thread.sleep(2000);
            				} catch (InterruptedException e) {
            					System.out.println(e.getMessage());
            					}
            			}
            			case 2 -> { 
            				System.out.println("Digite a descrição da tarefa");
            				String descricao = sc.nextLine();
            				
            				System.out.println("Agora digite a data limite");
            				String dataLimiteTexto = sc.nextLine();
            				
            				DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            				LocalDate dataLimite = LocalDate.parse(dataLimiteTexto, formatador);
            				
            				repo.adicionarTarefa(new TarefaUrgente(descricao,dataLimite));
            				System.out.println("\n [SUCESSO] Tarefa URGENTE cadastrada!");
            				
            				try {
            					Thread.sleep(2000);
            				} catch (InterruptedException e) {
            					System.out.println(e.getMessage());
            					}
            			}
            			
            			case 3 -> {
            				System.out.println("Retornando..");
            				break;
            			}
            			default -> System.out.println("Digite uma das opções acima!");	
            		}
            }
            
            case 2 -> {
            	repo.exibirDetalhes();
            	try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
					}
            }

            case 3 -> {
            	System.out.println("Digite o indentificador da tarefa");
            	int id = sc.nextInt();
            	repo.concluirTarefa(id);
            	try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
					}
            }
            
            case 4 -> {
            	System.out.println("Saindo...");
            	OP = false;
            }
            default -> System.out.println("Digite uma das opções acima!");
       }
    }
    	
 sc.close();  	   	
    } 
}
