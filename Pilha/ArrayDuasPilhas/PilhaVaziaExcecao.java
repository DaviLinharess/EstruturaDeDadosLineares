package Pilha.ArrayDuasPilhas;

// usamos RunTimeException por não precisar checar: sem usar try/catch
// "Minha exceção PilhaVaziaExcecao é um tipo especial de RuntimeException"
// "String" = tipo de texto, "err" = nome da variável
// "super..." manda mensagem pro sistema de exceções do Java, se n resolver o problema e o programa parar, mostra a mensagem que passei.
public class PilhaVaziaExcecao extends RuntimeException { 
    public PilhaVaziaExcecao(String err) {
        super(err);
    }
}