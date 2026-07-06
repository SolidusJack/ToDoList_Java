# 📝 ToDoList - Gerenciador de Tarefas em Java

Sistema de gerenciamento de tarefas desenvolvido em Java para console. O projeto nasceu como uma aplicação simples, mas foi projetado arquiteturalmente para evoluir de forma incremental, tornando-se uma aplicação robusta e pronta para o mercado.


## 🎯 Propósito de Aprendizado & Workflow Git.

Este projeto foi estruturado para simular o fluxo de trabalho real de um ambiente de desenvolvimento profissional. Mais do que treinar lógica em Java, o objetivo principal aqui é consolidar boas práticas de engenharia de software, com foco em:

* **Versionamento Profissional com Git:** Uso rigoroso de ramificações para o desenvolvimento de novas funcionalidades.
* **Trabalho com Pull Requests (PRs):** Cada feature (como a implementação das regras de negócio) é isolada em uma branch própria, revisada e integrada à branch `main` apenas através de Pull Requests, mantendo um histórico de commits limpo, semântico e auditável.
* **Programação Orientada a Objetos (POO):** Aplicação real de conceitos como herança, polimorfismo, encapsulamento e abstração (usando classes abstratas e subclasses para tipos de tarefas).

## ⚙️ Funcionalidades Atuais (Regras de Negócio)

O sistema conta com um motor de regras de negócio em memória, estruturado através do padrão Repository:

* **Abstração de Tarefas:** Classe mãe abstrata `Tarefa` que dita o comportamento base do sistema.
* **Subclasses Especializadas:** Divisão clara entre `TarefaComum` e `TarefaUrgente` (esta última controlando prazos e formatação de datas via `LocalDate` e `DateTimeFormatter`).
* **Gerenciamento em Memória:** Repositório desacoplado utilizando `ArrayList` para operações de busca, inserção e conclusão de tarefas.
* **Interface Customizada para Console:** Sobrescrita personalizada do método `toString()` para exibir as tarefas no terminal com um layout limpo, legível e amigável para o usuário.

## 📈 Roadmap de Evolução (Próximos Passos)

O projeto foi construído pensando em escalabilidade. As próximas etapas planejadas para tornar o sistema totalmente robusto incluem:

1.  **Refatoração com Lombok (Em andamento):** Introdução da biblioteca Lombok para eliminar código repetitivo (*boilerplate*), substituindo Getters, Setters manuais por anotações (`@Getter`, `@Setter`), mantendo o controle estrito sobre construtores e o `toString()` personalizado.
2.  **Persistência de Dados com MySQL:** Migração do armazenamento em memória (`ArrayList`) para um banco de dados relacional real, aplicando conceitos de persistência e isolamento de dados.
3.  **Robustez nas Regras de Negócio:** Implementação de tratamento de exceções customizadas para evitar falhas em tempo de execução (ex: validações de datas passadas ou índices inválidos).
4.  **Migração para Spring Boot:** Evolução da aplicação de console para uma API REST moderna e escalável.


## 🛠️ Tecnologias Utilizadas

* **Linguagem:** Java 21
* **Gerenciador de Dependências:** Maven
* **IDE:** Spring Tools Suite 4 (STS 4) / Eclipse
* **Controle de Versão:** Git / GitHub


## 💻 Como Executar o Projeto

1. Certifique-se de ter o **JDK 21** e o **Maven** instalados em sua máquina.
2. Clone este repositório:
   ```bash
   git clone git@github.com:SolidusJack/ToDoList_Java.git
