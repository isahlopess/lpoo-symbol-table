package escopos;

import simbolos.Symbol;

public interface Scope {
    
    // Retorna o nome do escopo (ex: "global", "ClasseX", "metodoY")
    public String getScopeName();

    // Retorna o escopo pai (hierarquia)
    public Scope getEnclosingScope();

    // Adiciona um símbolo no escopo corrente 
    public void define(Symbol symbol);

    // Busca um símbolo pelo nome simples 
    // Se não achar aqui, deve procurar no pai (recursivamente) 
    public Symbol resolve(String name);
}