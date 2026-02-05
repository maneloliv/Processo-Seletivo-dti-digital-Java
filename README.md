# Processo-Seletivo-dti-digital-Java
Sistema de Gestão Escolar - Professor Carlos
Instruções para Executar o Sistema
Pré-requisitos
Java JDK 8 ou superior instalado

Terminal/Command Prompt

Passos para Executar:
Baixe os arquivos:

Aluno.java

SistemaProfessor.java

Compile o sistema:

bash
javac SistemaProfessor.java Aluno.java
Execute o programa:

bash
java SistemaProfessor
Alternativa para Windows:
Execute o arquivo run.bat (se disponível) clicando duas vezes nele.

Lista de Premissas Assumidas
Cinco disciplinas fixas para todos os alunos

Notas de 0 a 10 para cada disciplina

Frequência de 0% a 100% por aluno

Alunos com frequência abaixo de 75% precisam de atenção especial

Sistema opera em memória durante a execução

Interface via terminal/texto sem interface gráfica

Cálculo de média usando média aritmética simples

Validação de entrada em tempo real

Um professor gerencia uma única turma

Dados não persistem entre execuções (reset ao fechar)

Decisões de Projeto
Arquitetura Simplificada:
2 arquivos Java: Um para dados (Aluno.java), outro para lógica (SistemaProfessor.java)

Sem frameworks externos: Java puro para máxima compatibilidade

Menu interativo no terminal: Fácil de usar e testar

Principais Decisões Técnicas:
Java puro sem dependências: Facilita execução em qualquer ambiente

List em memória em vez de banco de dados: Para simplificação

Validação rigorosa: Impede entrada de dados inválidos

Cálculos em tempo real: Sem caching para garantir precisão

Interface textual com formatação: Melhor legibilidade no terminal

Design de Código:
Classe Aluno contém dados e métodos de cálculo

Classe principal gerencia fluxo e interface

Separação de responsabilidades: Cálculos vs. Interface vs. Dados

Métodos auxiliares para validação e entrada de dados

O que Mais é Importante Compartilhar
Pontos Fortes do Sistema:
Completamente funcional: Atende todos os requisitos especificados

Fácil de executar: Basta Java instalado

Código limpo e legível: Fácil de entender e modificar

Robusto: Validação completa contra erros de entrada

Rápido: Processamento instantâneo mesmo com muitos alunos

Recursos Implementados:
✅ Cadastro completo com 5 notas e frequência
✅ Cálculo automático de médias individuais e da turma
✅ Identificação automática de alunos com problemas
✅ Estatísticas detalhadas por disciplina
✅ Relatório completo formatado para leitura
✅ Busca de alunos por nome
✅ Remoção segura de alunos cadastrados

Potenciais Melhorias (para versões futuras):
Salvar dados em arquivo para persistência

Interface gráfica (Swing/JavaFX)

Exportação para Excel/PDF

Suporte a múltiplas turmas

Histórico de notas por bimestre

Diferenciais:
Zero configuração: Roda imediatamente após compilar

Feedback claro: Mensagens informativas em português

Interface intuitiva: Menu numérico fácil de navegar

Cálculos precisos: Sem erros de arredondamento significativos

Observações Importantes:
O sistema inclui 3 alunos de exemplo para demonstração imediata

Relatório completo pode ser visualizado na opção 6 do menu

Todos os cálculos são realizados em tempo real

Dados de teste são perdidos ao fechar o programa

Status: ✅ Sistema completamente funcional e pronto para uso
Complexidade: ⭐⭐☆☆☆ (Baixa - fácil de entender e modificar)
Portabilidade: ⭐⭐⭐⭐⭐ (Roda em qualquer sistema com Java)

Desenvolvido para o processo seletivo da dti digital

