# 🎓 Sistema de Gestão Escolar — Processo Seletivo DTI Digital (Java)

![Java](https://img.shields.io/badge/Java-8%2B-blue?style=for-the-badge&logo=java)
![Status](https://img.shields.io/badge/Status-Finalizado-brightgreen?style=for-the-badge)
![Plataforma](https://img.shields.io/badge/Plataforma-Multiplataforma-lightgrey?style=for-the-badge)
![Interface](https://img.shields.io/badge/Interface-Terminal-orange?style=for-the-badge)
![Complexidade](https://img.shields.io/badge/Complexidade-Baixa-yellow?style=for-the-badge)

Sistema desenvolvido em **Java puro** para gerenciamento de alunos, notas e frequência, com interface via terminal.

Projeto criado para o **processo seletivo da dti digital**.

---

## 📋 Pré-requisitos

- Java JDK 8 ou superior  
- Terminal / Prompt de Comando  

---

## ▶️ Como Executar

### 📥 Arquivos necessários
- `Aluno.java`  
- `SistemaProfessor.java`
- `run.bat`

### ▶️ Executar
- `Execute o arquivo run.bat com duplo clique.`

---

### 📌 Premissas Assumidas

- Cinco disciplinas fixas

- Notas entre 0 e 10

- Frequência entre 0% e 100%

- Alunos abaixo de 75% precisam de atenção

- Sistema funciona apenas em memória

- Interface textual (sem GUI)

- Média aritmética simples

- Validação de dados em tempo real

- Um professor por turma

- Dados não persistem após encerrar

---

## 🧱 Arquitetura
Aluno.java             -> Dados + cálculos  
SistemaProfessor.java  -> Lógica + interface  

- Java puro (sem frameworks)
 
- Menu interativo no terminal

- Estrutura simples e direta

---

## ⚙️ Decisões Técnicas

- Sem banco de dados (lista em memória)

- Validação rigorosa de entradas

- Cálculos em tempo real

- Interface formatada para leitura

- Separação de responsabilidades

---

## 🧠 Design de Código

- Classe Aluno: dados + médias

- Classe principal: fluxo do sistema

- Métodos auxiliares para:

- Entrada de dados

- Validação

- Cálculos

---

## ⭐ Pontos Fortes

✔ Funcional

✔ Fácil de executar

✔ Código limpo

✔ Robusto contra erro humano

✔ Processamento rápido

---

## 🚀 Funcionalidades

✅ Cadastro com 5 notas e frequência

✅ Média individual e da turma

✅ Identificação de alunos em risco

✅ Estatísticas por disciplina

✅ Relatório formatado

✅ Busca por nome

✅ Remoção segura

---

## 🧪 Dados de Demonstração

- Sistema inicia com 3 alunos de exemplo

- Relatório completo disponível na opção 6 do menu

---

## 🔮 Melhorias Futuras

- Persistência em arquivo

- Interface gráfica (Swing/JavaFX)

- Exportação para Excel/PDF

- Múltiplas turmas

- Histórico por bimestre

---

## 🏆 Diferenciais

- Zero configuração

- Mensagens em português

- Menu intuitivo

- Cálculos precisos

---

## ⚠️ Observações

- Todos os cálculos são feitos em tempo real

- Dados são perdidos ao fechar o programa


