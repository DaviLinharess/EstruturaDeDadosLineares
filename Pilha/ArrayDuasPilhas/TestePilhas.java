package Pilha.ArrayDuasPilhas;

public class TestePilhas {
    public static void main(String[] args) {
        PilhasColoridas pilhas = new PilhasColoridas(4);

        System.out.println("==== Teste 1: Crescimento Vermelho ====");
        for (int i = 1; i <= 10; i++) {
            pilhas.pushVermelho(i);
            System.out.println("pushVermelho(" + i + ")");
        }

        System.out.println("\nPop Vermelho:");
        while (!pilhas.isEmptyVermelho()) {
            System.out.println("popVermelho() -> " + pilhas.popVermelho());
        }

        System.out.println("\n==== Teste 2: Crescimento Preto ====");
        for (int i = 100; i <= 110; i++) {
            pilhas.pushPreto(i);
            System.out.println("pushPreto(" + i + ")");
        }

        System.out.println("\nPop Preto:");
        while (!pilhas.isEmptyPreto()) {
            System.out.println("popPreto() -> " + pilhas.popPreto());
        }

        System.out.println("\n==== Teste 3: Pilhas Juntas ====");
        for (int i = 1; i <= 5; i++) {
            pilhas.pushVermelho(i);
            pilhas.pushPreto(100 + i);
        }

        System.out.println("Topo vermelho: " + pilhas.topVermelho());
        System.out.println("Topo preto: " + pilhas.topPreto());
        System.out.println("Tamanho vermelho: " + pilhas.sizeVermelho());
        System.out.println("Tamanho preto: " + pilhas.sizePreto());

        System.out.println("\nEsvaziando as duas pilhas...");
        while (!pilhas.isEmptyVermelho() || !pilhas.isEmptyPreto()) {
            if (!pilhas.isEmptyVermelho()) {
                System.out.println("popVermelho() -> " + pilhas.popVermelho());
            }
            if (!pilhas.isEmptyPreto()) {
                System.out.println("popPreto() -> " + pilhas.popPreto());
            }
        }
    }
}
