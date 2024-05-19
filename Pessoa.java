import java.io.Serializable;

public class Pessoa implements Serializable{
    private static final long serialVersionUID = 1L;
    private String nome;
    private int idade;
    private double peso,
                  altura;
    public Pessoa(){

    }

    public Pessoa(String nome, int idade, double altura, double peso){
        setName(nome);
        setIdade(idade);
        setAltura(altura);
        setPeso(peso);
    }
    
    public String getNome(){
        return nome;
    }

    public void setName(String nome){
        if (nome.length() < 2 || nome.equals(null)){
            throw new IllegalArgumentException("O nome deve possuir mais de 2 caracteres.");
        }
        this.nome = nome;
    }
    public int getIdade(){
        return idade;
    }

    public void setIdade(int idade){
        if (idade < 0) {
            throw new IllegalArgumentException("A idade deve possuir valor maior ou igual a 0");
        }
        this.idade = idade;
    }
    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        if (peso <= 0) {
            throw new IllegalArgumentException("O peso deve ser maior que 0");
        }
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        if (altura <= 0) {
            throw new IllegalArgumentException("A altura deve ser maior que 0");
        }
        this.altura = altura;
    }

    @Override
    public String toString() {
        return  "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", peso=" + peso +
                ", altura=" + altura +
                '}';
    }
}
