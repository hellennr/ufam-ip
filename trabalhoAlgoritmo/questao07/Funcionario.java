import java.time.LocalDate; // Importando LocalDate para manipular data

public class Funcionario {
    // Atributos da classe Funcionario
    private String nome;
    private String departamento;
    private float salario;
    private LocalDate dataEntrada; // Tipo LocalDate para armazenar a data de entrada na empresa

    // Construtor da classe Funcionario
    public Funcionario(String nome, String departamento, float salario, LocalDate dataEntrada) {
        this.nome = nome;
        this.departamento = departamento;
        this.salario = salario;
        this.dataEntrada = dataEntrada;
    }

    // Métodos get e set para cada atributo
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    // Método bonifica(float)
    public void bonifica(float aumento) {
        this.salario += aumento;
    }

    // Método ganhoAnual()
    public float ganhoAnual() {
        return this.salario * 12;
    }

    // Método para imprimir informações do funcionário
    public void imprimirInformacoes() {
        System.out.println("Nome: " + this.nome);
        System.out.println("Departamento: " + this.departamento);
        System.out.println("Salário atual: " + this.salario);
    }

    // Método main para exemplo de uso da classe Funcionario
    public static void main(String[] args) {
        // Exemplo de uso da classe Funcionario
        LocalDate dataEntrada = LocalDate.of(2020, 8, 15); // Data de entrada na empresa

        Funcionario funcionario1 = new Funcionario("Maria", "TI", 3500.0f, dataEntrada);

        funcionario1.imprimirInformacoes();
        System.out.println("Ganho anual: " + funcionario1.ganhoAnual());

        funcionario1.bonifica(500.0f); // Bonificação de 500.00 no salário

        System.out.println("\nApós bonificação:");
        funcionario1.imprimirInformacoes();
        System.out.println("Ganho anual atualizado: " + funcionario1.ganhoAnual());
    }
}
