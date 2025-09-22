package ArrayDuasPilhas;

public class TestePilhas{
    public static void main(String[] args) {
        PilhasColoridas pilhas = new PilhasColoridas(5);
        pilhas.pushVermelho(10);
        pilhas.pushVermelho(20);
        pilhas.pushVermelho(30);
        System.out.println("Push vermelho funcionando!");
    }
}
