/**
 * @author Isadora Fernandes Lopes
 * @author Mariana Cardeliquio Mesquita
 */

package simbolos;

public class VariableSymbol extends Symbol {
    
    // Todo atributo ou variável precisa de um tipo (ex: int, float, ou uma Classe).
    // Como o roteiro diz que o tipo pode ser uma classe (que também é um símbolo),
    // decidimos usar a classe Symbol para representar o tipo.
    private Symbol type;

    // Construtor: Ele chama o construtor da classe base (Symbol)
    public VariableSymbol(String name, Symbol type) {
        super(name); 
        this.type = type;
    }

    // Getter para o tipo
    public Symbol getType() {
        return type;
    }

    // Sobrescrevemos o toString para facilitar a visualização nos testes.
    @Override
    public String toString() {
        String typeName = (type != null) ? type.getName() : "void";
        return getName() + ": " + typeName;
    }
}