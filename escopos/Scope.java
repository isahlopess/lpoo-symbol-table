/**
 * @author Isadora Fernandes Lopes
 * @author Mariana Cardeliquio Mesquita
 */

package escopos;

import simbolos.Symbol;

public interface Scope {
    
    // Retorna o nome do escopo 
    public String getScopeName();

    // Retorna o escopo pai 
    public Scope getEnclosingScope();

    // Adiciona um símbolo no escopo corrente 
    public void define(Symbol symbol);

    // Busca um símbolo pelo nome simples 
    // Se não achar aqui, deve procurar no pai 
    public Symbol resolve(String name);
}