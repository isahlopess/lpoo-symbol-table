package escopos;

import simbolos.Symbol;
import java.util.Map;
import java.util.TreeMap;

public class GlobalScope implements Scope {

    private Map<String, Symbol> symbols; // Dicionário de classes

    public GlobalScope() {
        this.symbols = new TreeMap<>();
    }

    @Override
    public String getScopeName() {
        return "global";
    }

    @Override
    public Scope getEnclosingScope() {
        // Regra do roteiro: O escopo global não possui pai
        return null;
    }

    @Override
    public void define(Symbol symbol) {
        symbols.put(symbol.getName(), symbol);
    }

    @Override
    public Symbol resolve(String name) {
        // Busca apenas no dicionário global, pois não há pai para subir
        return symbols.get(name);
    }

    @Override
    public String toString() {
        return "GlobalScope";
    }
}
