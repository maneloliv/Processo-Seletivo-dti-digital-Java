# Processo-Seletivo-dti-digital-Java
📚 Sistema do Professor Carlos
Sistema de gestão de notas e frequência desenvolvido em Java puro para o processo seletivo da dti digital. O sistema permite ao professor Carlos organizar as notas e frequência de seus alunos, com cálculos automáticos e relatórios.

🚀 Funcionalidades
✅ Requisitos Implementados
Cadastro de alunos com 5 notas (0-10) por disciplina

Registro de frequência (0-100%) por aluno

Cálculos automáticos:

Média individual de cada aluno

Média da turma por disciplina (5 disciplinas)

Média geral da turma

Identificação automática:

Alunos com média acima da média da turma

Alunos com frequência abaixo de 75% (precisam de atenção especial)

Relatórios completos com estatísticas detalhadas

🎯 Funcionalidades Extras
Busca de alunos por nome

Remoção de alunos

Exportação de relatório completo

Validação robusta de entrada de dados

Interface de terminal intuitiva

Dados em memória durante a execução

📁 Estrutura do Projeto
text
sistema-professor/
├── Aluno.java                # Classe que representa um aluno
├── SistemaProfessor.java     # Programa principal com menu interativo
├── run.bat                   # Script de execução para Windows
└── README.md                 # Este arquivo
🔧 Tecnologias Utilizadas
Java 8+ (JDK)

Apenas bibliotecas padrão do Java

Sem frameworks ou dependências externas

📋 Instruções para Executar
Pré-requisitos
Java Development Kit (JDK) 8 ou superior instalado

Terminal/Command Prompt

Passo a Passo
Windows:
Método 1 (Recomendado):

Clique duas vezes no arquivo run.bat

O script compilará e executará automaticamente

Método 2 (Manual):

cmd
# Navegue até a pasta do projeto
cd C:\caminho\para\sistema-professor

# Compile os arquivos Java
javac SistemaProfessor.java Aluno.java

# Execute o sistema
java SistemaProfessor
Linux/Mac:
bash
# Navegue até a pasta do projeto
cd /caminho/para/sistema-professor

# Compile os arquivos Java
javac SistemaProfessor.java Aluno.java

# Execute o sistema
java SistemaProfessor
Verificação da Instalação do Java
bash
# Verifique se o Java está instalado
java -version
javac -version
Se não estiver instalado, baixe em: Oracle JDK ou Adoptium

🖥️ Como Usar o Sistema
Menu Principal
text
============ MENU PRINCIPAL ============
1. Cadastrar novo aluno
2. Listar todos os alunos
3. Ver estatísticas da turma
4. Buscar aluno por nome
5. Remover aluno
6. Exportar relatório completo
0. Sair
=========================================
Fluxo de Uso
Cadastrar aluno: Insira nome, 5 notas (D1 a D5) e frequência

Ver estatísticas: Visualize médias, alunos acima da média e com frequência baixa

Exportar relatório: Gere um relatório completo formatado

Exemplo de Cadastro
text
Nome do aluno: João da Silva

Digite as 5 notas (0 a 10):
Nota da disciplina 1: 8.5
Nota da disciplina 2: 7.0
Nota da disciplina 3: 9.0
Nota da disciplina 4: 8.0
Nota da disciplina 5: 7.5

Frequência (0-100%): 80.0
📊 Premissas Assumidas
Dados e Validações:
Notas: Cada aluno tem exatamente 5 notas (uma por disciplina)

Intervalos:

Notas: 0 a 10 (inclusive)

Frequência: 0% a 100% (inclusive)

Limite de atenção: Frequência abaixo de 75% requer atenção especial

Cálculos:

Média aritmética simples para todas as disciplinas

Média da turma calculada sobre todas as notas de todos os alunos

Comportamento do Sistema:
Persistência: Dados ficam em memória durante a execução (reinicia ao fechar)

Interface: Apenas terminal/texto, sem interface gráfica

Execução: Sistema single-user, não concorrente

Dados de exemplo: Sistema inicia com 3 alunos previamente cadastrados

Técnicas:
Tratamento de erros: Validação em tempo real de entrada do usuário

Arredondamento: Duas casas decimais para médias

Busca: Case-insensitive para nomes

🎯 Decisões de Projeto
Arquitetura:
Aplicação monolítica: Todo o código em dois arquivos Java

Separação de responsabilidades:

Aluno.java: Modelo de dados e cálculos básicos

SistemaProfessor.java: Lógica de negócio, interface e controle

Programação procedural com orientação a objetos básica

Design de Código:
Sem frameworks: Optou-se por Java puro para simplicidade e portabilidade

Interface textual: Console/terminal para fácil execução em qualquer ambiente

Validação proativa: Previne entrada de dados inválidos

Feedback imediato: Mensagens claras para o usuário

Escolhas Técnicas:
Lista em memória (ArrayList) em vez de banco de dados

Prós: Simplicidade, zero configuração

Contras: Dados perdidos ao encerrar

Entrada via Scanner em vez de interface gráfica

Prós: Funciona em qualquer terminal, leve

Contras: Menos amigável que GUI

Cálculos em tempo real em vez de caching

Prós: Sempre dados atualizados

Contras: Recálculo a cada operação

Decisões de Usabilidade:
Menu numérico: Facilita navegação rápida

Dados de exemplo: Demonstra funcionalidades imediatamente

Formatação consistente: Tabelas alinhadas, casas decimais padronizadas

Cores/ícones textuais: Usa emojis e símbolos para melhor visualização

📈 O que Mais é Importante Compartilhar
Pontos Fortes do Projeto:
Simplicidade e Elegância

Código limpo e bem documentado

Sem complexidades desnecessárias

Fácil de entender e modificar

Robustez

Validação completa de todas as entradas

Tratamento de exceções adequado

Mensagens de erro claras e informativas

Portabilidade

Roda em qualquer sistema com Java

Sem dependências externas

Tamanho mínimo do projeto

Documentação Completa

Comentários no código

README detalhado

Instruções passo a passo

Decisões Críticas:
Optou-se por não usar banco de dados

Justificativa: O foco era demonstrar lógica de negócio, não persistência

Alternativa: Facilmente extendível para usar arquivos ou banco

Interface apenas terminal

Justificativa: Atender o requisito mínimo com máxima portabilidade

Alternativa: Pode ser transformado em API REST ou GUI facilmente

Sem testes unitários formais

Justificativa: O teste especificou que eram opcionais

Alternativa: Código estruturado para fácil adição de testes

Extensibilidade:
O sistema foi projetado para ser facilmente extendido:

java
// Possíveis melhorias:
// 1. Persistência em arquivo
// 2. Interface web com Spring Boot
// 3. Exportação para Excel/PDF
// 4. Múltiplas turmas
// 5. Histórico de notas
Desafios Enfrentados:
Validação de entrada: Garantir que o usuário só insira dados válidos

Formatação de saída: Alinhar tabelas no terminal

Cálculos precisos: Evitar erros de arredondamento

Experiência do usuário: Menu intuitivo mesmo em terminal

Conclusão:
Este projeto demonstra:

Domínio de Java puro

Capacidade de resolver problemas reais

Boa organização de código

Foco em requisitos do usuário

Balanceamento entre simplicidade e funcionalidade

👨‍💻 Autor
Desenvolvido para o processo seletivo da dti digital.

📄 Licença
Este projeto é para fins de avaliação técnica.
