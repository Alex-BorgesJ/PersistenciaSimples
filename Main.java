import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scannerString = new Scanner(System.in);
        Scanner scannerInt = new Scanner(System.in);
        String diretorio = "pessoas";

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Ver a lista completa");
            System.out.println("2. Adicionar uma pessoa à lista");
            System.out.println("3. Capturar uma pessoa específica na lista");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scannerInt.nextInt();

            switch (opcao) {
                case 1:
                    List<Pessoa> pessoas = Gravar.lerTodosObjetos(diretorio);
                    System.out.println();
                    for (int i = 0; i < pessoas.size(); i++) {
						int index = i + 1;
                        System.out.println("\t" + index + ". " + pessoas.get(i));
                    }
                    break;

                case 2:
                    System.out.print("Digite o nome: ");
                    String nome = scannerString.nextLine();
                    System.out.print("Digite a idade: ");
                    int idade = scannerInt.nextInt();
                    System.out.print("Digite a altura: ");
                    double altura = scannerInt.nextDouble();
                    System.out.print("Digite o peso: ");
                    double peso = scannerInt.nextDouble();
                    Pessoa novaPessoa = new Pessoa(nome, idade, altura, peso);
                    Gravar.gravarObjUnico(diretorio, novaPessoa);
                    break;

                case 3:
                    System.out.print("Digite o índice da pessoa que você deseja capturar: ");
                    int indice = scannerInt.nextInt() - 1;
                    List<Pessoa> listaPessoas = Gravar.lerTodosObjetos(diretorio);
                    if (indice >= 0 && indice < listaPessoas.size()) {
                        System.out.println("\n\t\t"+listaPessoas.get(indice));
                    } else {
                        System.out.println("Índice fora do intervalo válido.");
                    }
                    break;

                case 4:
                    System.out.println("Saindo...");
                    scannerString.close();
                    scannerInt.close();
                    return;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
