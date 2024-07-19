import java.util.Scanner;

public class Esqueleto {
    private float numero1, numero2;

    public float getNumero1() {
        return this.numero1;
    }

    public void setNumero1(float numero1) {
        this.numero1 = numero1;
    }

    public float getNumero2() {
        return this.numero2;
    }

    public void setNumero2(float numero2) {
        this.numero2 = numero2;
    }

    public void verificaCliente(){

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

    }
}

public void verificaCliente(){
    float valorCompra = this.getNumero1();
    float saldoCliente = this.getNumero2();
    float desconto = valorCompra * 0.05f;
    float novoValorCompra = valorCompra - desconto;

if (valorCompra < 200) {
if (saldoCliente >= valorCompra) {
     System.out.printf("Valor final da compra %.2f, O cliente tem saldo suficiente!!", valorCompra);
} else {
     System.out.printf("Valor final da compra %.2f, O cliente nao tem saldo suficiente!!", valorCompra);
}
} else {
if (saldoCliente >= novoValorCompra) {
     System.out.printf("Valor final da compra %.2f, O cliente tem saldo suficiente!!", novoValorCompra);
} else {
     System.out.printf("Valor final da compra %.2f, O cliente nao tem saldo suficiente!!", novoValorCompra);
}
}


}