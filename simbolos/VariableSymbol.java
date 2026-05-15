package simbolos;

public class VariableSymbol extends Symbol {
    
    // Todo atributo ou variável precisa de um tipo (ex: int, float, ou uma Classe).
    // Como o roteiro diz que o tipo pode ser uma classe (que também é um símbolo),
    // vamos usar a classe Symbol para representar o tipo.
    private Symbol type;

    // Construtor: Repare no "super(name)", ele chama o construtor da classe base (Symbol)
    public VariableSymbol(String name, Symbol type) {
        super(name); 
        this.type = type;
    }

    // Getter para o tipo
    public Symbol getType() {
        return type;
    }

    // Sobrescrevemos o toString para facilitar a visualização nos testes.
    // Vai imprimir algo como: "idade: int" ou "meuCarro: Carro"
    @Override
    public String toString() {
        String typeName = (type != null) ? type.getName() : "void";
        return getName() + ": " + typeName;
    }
}