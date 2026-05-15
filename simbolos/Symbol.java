package simbolos;

import java.util.EnumSet;
import java.util.Set;

public abstract class Symbol {
    
    // Usamos um Enum para definir os modificadores exatos que o professor pediu
    public enum Modifier {
        PUBLIC, PROTECTED, PRIVATE, STATIC, ABSTRACT, FINAL
    }

    private String name;
    private Set<Modifier> modifiers;

    // Construtor: Todo símbolo precisa de pelo menos um nome ao ser criado
    public Symbol(String name) {
        this.name = name;
        this.modifiers = EnumSet.noneOf(Modifier.class); // Inicia a lista de modificadores vazia
    }

    public String getName() {
        return name;
    }

    public void addModifier(Modifier modifier) {
        this.modifiers.add(modifier);
    }

    public boolean hasModifier(Modifier modifier) {
        return this.modifiers.contains(modifier);
    }
    
    @Override
    public String toString() {
        return name;
    }
}