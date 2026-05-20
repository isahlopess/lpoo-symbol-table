===========================================================
TRABALHO 1 - LINGUAGEM DE PROGRAMAÇÃO ORIENTADA A OBJETOS
===========================================================

ALUNAS:
- Isadora Fernandes Lopes (RGA: 202419050786)
- Mariana Cardeliquio Mesquita (RGA: 202519040642)

LINK PARA O VÍDEO EXPLICATIVO: 
[PENDENTE]

-----------------------------------------------------------
STATUS DAS ATIVIDADES:
-----------------------------------------------------------
[X] Atividade A1: Implementação da hierarquia de classes de símbolos e escopos. (Concluída com sucesso)
[X] Atividade A2: Implementação da Tabela de Símbolos, com gerenciamento do escopo corrente e operações de busca. (Concluída com sucesso)
[X] Atividade A3: Aplicação de teste (Main.java) simulando as chamadas do compilador e validando a busca ascendente. (Concluída com sucesso)

-----------------------------------------------------------
RESUMO DA ARQUITETURA E FUNCIONAMENTO:
-----------------------------------------------------------
Este projeto implementa o motor de uma Tabela de Símbolos para uma versão 
simplificada da linguagem Java. O código foi organizado em pacotes:

1. Pacote "simbolos":
   Contém a classe abstrata base `Symbol`, que define o identificador e 
   os modificadores de acesso. A partir dela, derivam `VariableSymbol`, 
   `ClassSymbol`, `MethodSymbol` e `ConstructorSymbol`. As classes e 
   métodos atuam não apenas como símbolos, mas também como escopos, 
   implementando a interface responsável por guardar dados internamente.

2. Pacote "escopos":
   Contém a interface `Scope` (que dita o contrato de definição e resolução 
   de símbolos) e as implementações estruturais `GlobalScope` e `BlockScope`. 
   O armazenamento interno de todos os escopos utiliza a estrutura `TreeMap`, 
   implementando a interface `Map` do Java.

3. Motor Central (SymbolTable.java):
   Gerencia a entrada (pushScope) e saída (popScope) de blocos, mantendo o 
   controle através da variável `currentScope`. O método `resolve` implementa 
   a busca recursiva ascendente: procura o símbolo no escopo atual e, se não 
   encontrar, delega a busca para o escopo pai (enclosing scope) até chegar 
   ao escopo global. Também possui suporte a busca qualificada.

4. Teste de Execução (Main.java):
   Simula o comportamento de um parser, inserindo manualmente as classes, 
   métodos e atributos, comprovando via terminal (console) o sucesso da 
   localização de variáveis em diferentes níveis hierárquicos.