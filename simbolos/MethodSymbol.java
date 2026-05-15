package simbolos;

import escopos.Scope;
import java.util.Map;
import java.util.TreeMap;

public class MethodSymbol extends Symbol implements Scope {

    private Symbol returnType; // O tipo de retorno (ex: int, String, ou null para void)
    private Scope enclosingScope; // A classe onde este método está declarado
    private Map<String, Symbol> localVariables; // Dicionário: guarda parâmetros e variáveis locais

    public MethodSymbol(String name, Symbol returnType, Scope enclosingScope) {
        super(name);
        this.returnType = returnType;
        this.enclosingScope = enclosingScope;
        this.localVariables = new TreeMap<>(); // Instanciamos o TreeMap exigido
    }

    public Symbol getReturnType() {
        return returnType;
    }

    // --- Implementação da interface Scope ---

    @Override
    public String getScopeName() {
        return getName();
    }

    @Override
    public Scope getEnclosingScope() {
        // Regra do roteiro: O pai do escopo do método é a classe onde ele está.
        return enclosingScope;
    }

    @Override
    public void define(Symbol symbol) {
        // Adiciona um parâmetro ou variável local ao dicionário do método
        localVariables.put(symbol.getName(), symbol);
    }

    @Override
    public Symbol resolve(String name) {
        // 1. Tenta achar a variável localmente
        Symbol s = localVariables.get(name);
        if (s != null) {
            return s;
        }
        
        // 2. Se não achou, sobe a busca para a classe (escopo pai)
        if (getEnclosingScope() != null) {
            return getEnclosingScope().resolve(name);
        }
        
        return null;
    }

    @Override
    public String toString() {
        String returnName = (returnType != null) ? returnType.getName() : "void";
        return "method " + getName() + " : " + returnName;
    }
}
