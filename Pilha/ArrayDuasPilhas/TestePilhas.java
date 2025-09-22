package ArrayDuasPilhas;

public class TestePilhas{
    public static void main(String[] args) {
        PilhasColoridas pilhas = new PilhasColoridas(5);
        pilhas.pushVermelho(10);
        pilhas.pushVermelho(20);
        pilhas.pushPreto(99);
        pilhas.pushPreto(88);
        System.out.println("Push vermelho e Preto funcionando!");
    }
}
