/**
 * @author Isadora Fernandes Lopes
 * @author Mariana Cardeliquio Mesquita
 */

import escopos.GlobalScope;
import escopos.Scope;
import simbolos.Symbol;

public class SymbolTable {

    private GlobalScope globals;
    private Scope currentScope; // Ponteiro para o escopo onde estamos trabalhando no momento

    public SymbolTable() {
        init();
    }

    // Inicializa a tabela criando o escopo global e definindo-o como corrente
    public void init() {
        globals = new GlobalScope();
        currentScope = globals;
    }

    // --- 1. Operações de Mudança de Escopo Corrente ---

    // Entrar em um novo escopo
    public void pushScope(Scope scope) {
        currentScope = scope;
    }

    // Sair do escopo atual
    public void popScope() {
        // Volta o ponteiro para o escopo pai
        if (currentScope.getEnclosingScope() != null) {
            currentScope = currentScope.getEnclosingScope();
        }
    }

    // Retorna o escopo corrente para sabermos onde estamos
    public Scope getCurrentScope() {
        return currentScope;
    }

    // --- 2. Operação de Adição de Símbolos ---

    // Toda declaração sem erros resulta em um símbolo adicionado ao escopo corrente
    public void define(Symbol symbol) {
        currentScope.define(symbol);
        System.out.println("Definido o simbolo [" + symbol.getName() + "] no escopo [" + currentScope.getScopeName() + "]");
    }

    // --- 3. Operações de Busca ---

    // Busca por um nome simples (ex: "idade") começando do escopo corrente e subindo
    public Symbol resolve(String name) {
        return currentScope.resolve(name);
    }

    // Busca por um nome qualificado (ex: "Carro.cor").
    // O qualificador define o escopo no qual a busca inicia.
    public Symbol resolveQualified(String qualifier, String name) {
        // Primeiro, procuramos quem é o qualificador (ex: a classe "Carro")
        Symbol qualSymbol = this.resolve(qualifier);
        
        // Se acharmos e ele for um escopo (como uma Classe), procuramos o nome lá dentro
        if (qualSymbol instanceof Scope) {
            Scope qualScope = (Scope) qualSymbol;
            // Busca apenas dentro do dicionário daquele escopo específico
            return qualScope.resolve(name); 
        }
        
        return null; // Qualificador não encontrado ou não é um escopo válido
    }
}
