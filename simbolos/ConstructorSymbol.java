/**
 * @author Isadora Fernandes Lopes
 * @author Mariana Cardeliquio Mesquita
 */

package simbolos;

import escopos.Scope;

// Estendemos MethodSymbol para herdar toda a lógica de parâmetros e dicionário
public class ConstructorSymbol extends MethodSymbol {

    public ConstructorSymbol(String name, Scope enclosingScope) {
        // Chamamos o construtor do MethodSymbol, mas passamos 'null' no tipo de retorno
        super(name, null, enclosingScope);
    }

    @Override
    public String toString() {
        return "constructor " + getName();
    }
}
