/**
 * @author Isadora Fernandes Lopes
 * @author Mariana Cardeliquio Mesquita
 */

import simbolos.ClassSymbol;
import simbolos.MethodSymbol;
import simbolos.Symbol;
import simbolos.VariableSymbol;

public class Main {
    public static void main(String[] args) {
        
        System.out.println("=== INICIANDO O COMPILADOR ===");
        SymbolTable tabela = new SymbolTable(); // Inicia com o GlobalScope

        // 1. Criamos alguns "tipos primitivos" falsos apenas para usar como tipo das variáveis
        ClassSymbol intType = new ClassSymbol("int", null, null);
        ClassSymbol voidType = new ClassSymbol("void", null, null);

        // LENDO: class Carro {
        System.out.println("\n-> Compilador leu: class Carro");
        ClassSymbol carroClass = new ClassSymbol("Carro", null, tabela.getCurrentScope());
        tabela.define(carroClass); // Adiciona "Carro" no escopo global
        tabela.pushScope(carroClass); // Entra no escopo da classe Carro

        // LENDO: int ano;
        System.out.println("\n-> Compilador leu: int ano;");
        VariableSymbol anoAttr = new VariableSymbol("ano", intType);
        tabela.define(anoAttr);

        // LENDO: void acelerar(int intensidade) {
        System.out.println("\n-> Compilador leu: void acelerar(int intensidade) {");
        MethodSymbol acelerarMethod = new MethodSymbol("acelerar", voidType, tabela.getCurrentScope());
        tabela.define(acelerarMethod); // Adiciona o método na classe Carro
        tabela.pushScope(acelerarMethod); // Entra no escopo do método

        // O parâmetro pertence ao escopo do método
        VariableSymbol intensidadeParam = new VariableSymbol("intensidade", intType);
        tabela.define(intensidadeParam);

        // LENDO: int velocidade;
        System.out.println("\n-> Compilador leu: int velocidade;");
        VariableSymbol velocidadeVar = new VariableSymbol("velocidade", intType);
        tabela.define(velocidadeVar);

        // TESTES DE BUSCA (RESOLVE)
        System.out.println("\n=== TESTANDO AS BUSCAS NA TABELA ===");
        
        // 1. Buscar algo que está no escopo atual (dentro do método)
        Symbol s1 = tabela.resolve("velocidade");
        System.out.println("Buscando 'velocidade': Encontrou -> " + s1);

        // 2. Buscar algo que está no pai (subindo do método para a classe)
        Symbol s2 = tabela.resolve("ano");
        System.out.println("Buscando 'ano' de dentro do metodo: Encontrou -> " + s2);

        // 3. Buscar algo que não existe
        Symbol s3 = tabela.resolve("pneu");
        System.out.println("Buscando 'pneu': Encontrou -> " + s3);

        // FECHANDO ESCOPOS (LENDO OS "}")
        System.out.println("\n-> Compilador leu: } (Fim do metodo)");
        tabela.popScope(); // Sai de acelerar, volta para Carro

        System.out.println("-> Compilador leu: } (Fim da classe)");
        tabela.popScope(); // Sai de Carro, volta para GlobalScope

        // TESTE DE NOME QUALIFICADO
        System.out.println("\n=== TESTANDO BUSCA QUALIFICADA ===");
        Symbol qualificado = tabela.resolveQualified("Carro", "ano");
        System.out.println("Buscando 'Carro.ano' do escopo Global: Encontrou -> " + qualificado);
    }
}