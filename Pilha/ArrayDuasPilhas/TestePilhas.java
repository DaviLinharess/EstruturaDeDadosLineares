package Pilha.ArrayDuasPilhas;

public class TestePilhas {
    public static void main(String[] args) {
        PilhasColoridas pilhas = new PilhasColoridas(4);

        System.out.println("==== Teste 1: Crescimento Vermelho ====");
        for (int i = 1; i <= 10; i++) {
            pilhas.pushVermelho(i);
            System.out.println("pushVermelho(" + i + ")");
        }
        for (int i = 0; i < 8; i++) {
            int valor = pilhas.popVermelho();
            System.out.println("popVermelho() -> " + valor);
        }

        System.out.println("\n==== Teste 2: Crescimento Preto ====");
        for (int i = 100; i <= 110; i++) {
            pilhas.pushPreto(i);
            System.out.println("pushPreto(" + i + ")");
        }
        for (int i = 0; i < 8; i++) {
            int valor = pilhas.popPreto();
            System.out.println("popPreto() -> " + valor);
        }

        System.out.println("\n==== Teste 3: Pilhas Juntas ====");
        pilhas.pushVermelho(1);
        pilhas.pushVermelho(2);
        pilhas.pushVermelho(3);

        pilhas.pushPreto(99);
        pilhas.pushPreto(88);
        pilhas.pushPreto(77);

        System.out.println("popVermelho() -> " + pilhas.popVermelho()); // deve sair 3
        System.out.println("popPreto() -> " + pilhas.popPreto());       // deve sair 77
    }
}
