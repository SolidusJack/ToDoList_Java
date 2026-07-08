package com.solidusjack.todolist.repository;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.solidusjack.todolist.contract.Gerenciavel;
import com.solidusjack.todolist.model.Tarefa;
import com.solidusjack.todolist.model.TarefaComum;
import com.solidusjack.todolist.model.TarefaUrgente;

public class TarefaRepository implements Gerenciavel {

	public Connection getConnection() {
		
		Properties props = new Properties();
		
		try (InputStream input = getClass().getClassLoader().getResourceAsStream("database.properties")) {
			if (input == null) {
				throw new RuntimeException("Arquivo database.properties não foi encontrado!");
			}
			props.load(input);

			String url = props.getProperty("db.url");
			String user = props.getProperty("db.user");
			String password = props.getProperty("db.password");

			return DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
			return null;
		}
	}

	
	public void adicionarTarefa(Tarefa tarefa) {
		String sql = "INSERT INTO tarefas (descricao, status_conclusao, tipo, data_limite) VALUES (?, ?, ?, ?)";

		try (Connection conn = getConnection(); 
			 PreparedStatement pstm = conn.prepareStatement(sql)) {

			pstm.setString(1, tarefa.getDescricao());
			pstm.setBoolean(2, tarefa.isStatusConclusao());

			
			if (tarefa instanceof TarefaUrgente) {
				pstm.setString(3, "URGENTE");
				
				pstm.setDate(4, java.sql.Date.valueOf(((TarefaUrgente) tarefa).getDataLimite()));
			} else {
				pstm.setString(3, "COMUM");
				pstm.setNull(4, java.sql.Types.DATE); 
			}

			pstm.executeUpdate();
			System.out.println("Tarefa salva com sucesso!");

		} catch (SQLException e) {
			System.err.println("Erro ao salvar tarefa no banco: " + e.getMessage());
		}
	}

	@Override
	public void concluirTarefa(int id) {
		String sql = "UPDATE tarefas SET status_conclusao = TRUE WHERE id = ?";

		try (Connection conn = getConnection(); 
			 PreparedStatement pstm = conn.prepareStatement(sql)) {

			pstm.setInt(1, id);
			int linhasAfetadas = pstm.executeUpdate();

			if (linhasAfetadas > 0) {
				System.out.println("Tarefa #" + id + " marcada como Concluída com sucesso!");
			} else {
				System.out.println("Tarefa com o ID " + id + " não foi encontrada no banco.");
			}

		} catch (SQLException e) {
			System.err.println("Erro ao concluir tarefa no banco: " + e.getMessage());
		}
	}


	@Override
	public void exibirDetalhes() {
		String sql = "SELECT * FROM tarefas";

		try (Connection conn = getConnection(); 
			 PreparedStatement pstm = conn.prepareStatement(sql); 
			 ResultSet rs = pstm.executeQuery()) {

			if (!rs.isBeforeFirst()) {
				System.out.println("Nenhuma tarefa cadastrada no banco de dados.");
				return;
			}

			System.out.println("\n------------------------------------------");
			System.out.println("            SUAS TAREFAS ATUAIS           ");
			System.out.println("------------------------------------------");

			int contadorVisual = 1; 
			
			while (rs.next()) {
				Tarefa tarefa;
				String tipo = rs.getString("tipo");
				String description = rs.getString("descricao");

				if ("URGENTE".equals(tipo)) {
					java.sql.Date sqlDate = rs.getDate("data_limite");
					tarefa = new TarefaUrgente(description, sqlDate.toLocalDate());
				} else {
					tarefa = new TarefaComum(description);
				}

				tarefa.setId(rs.getInt("id"));
				tarefa.setStatusConclusao(rs.getBoolean("status_conclusao"));
				
				System.out.print("[" + contadorVisual + "] ");
				System.out.println(tarefa);
				
				contadorVisual++;
			}
			System.out.println("------------------------------------------");

		} catch (SQLException e) {
			System.err.println("Erro ao ler tarefas do banco: " + e.getMessage());
		}
	}
}