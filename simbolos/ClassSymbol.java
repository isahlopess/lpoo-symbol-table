package simbolos;

import escopos.Scope;
import java.util.Map;
import java.util.TreeMap;

// Herda de Symbol (tem nome e modificadores) e Implementa Scope (é um dicionário)
public class ClassSymbol extends Symbol implements Scope {
    
    private ClassSymbol superClass; // A superclasse (pode ser null)
    private Scope enclosingScope;   // O escopo onde a classe foi declarada (GlobalScope)
    private Map<String, Symbol> members; // Dicionário: guarda atributos, métodos e construtores

    public ClassSymbol(String name, ClassSymbol superClass, Scope enclosingScope) {
        super(name);
        this.superClass = superClass;
        this.enclosingScope = enclosingScope;
        this.members = new TreeMap<>(); // Instanciamos o TreeMap exigido
    }

    public ClassSymbol getSuperClass() {
        return superClass;
    }

    // --- Implementação da interface Scope ---

    @Override
    public String getScopeName() {
        return getName();
    }

    @Override
    public Scope getEnclosingScope() {
        // Regra do roteiro: O pai é a superclasse. Se for nula, é o escopo global.
        return (superClass != null) ? superClass : enclosingScope;
    }

    @Override
    public void define(Symbol symbol) {
        // Adiciona um membro (método, atributo) ao dicionário da classe
        members.put(symbol.getName(), symbol);
    }

    @Override
    public Symbol resolve(String name) {
        // 1. Tenta achar o símbolo dentro da própria classe
        Symbol s = members.get(name);
        if (s != null) {
            return s;
        }
        
        // 2. Se não achou, e se tiver um escopo pai (superclasse ou global), procura lá
        if (getEnclosingScope() != null) {
            return getEnclosingScope().resolve(name);
        }
        
        // 3. Se não achou em lugar nenhum, retorna nulo
        return null;
    }

    @Override
    public String toString() {
        return "class " + getName();
    }
}
