package escopos;

import simbolos.Symbol;
import java.util.Map;
import java.util.TreeMap;

public class BlockScope implements Scope {

    private Scope enclosingScope; // O bloco ou método "pai"
    private Map<String, Symbol> symbols; // Variáveis locais deste bloco

    public BlockScope(Scope enclosingScope) {
        this.enclosingScope = enclosingScope;
        this.symbols = new TreeMap<>();
    }

    @Override
    public String getScopeName() {
        return "local block";
    }

    @Override
    public Scope getEnclosingScope() {
        return enclosingScope;
    }

    @Override
    public void define(Symbol symbol) {
        symbols.put(symbol.getName(), symbol);
    }

    @Override
    public Symbol resolve(String name) {
        // 1. Tenta achar aqui
        Symbol s = symbols.get(name);
        if (s != null) return s;

        // 2. Se não achou, sobe para o pai (recursão)
        if (getEnclosingScope() != null) {
            return getEnclosingScope().resolve(name);
        }
        return null;
    }
}
