import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Gravar {

    // Método para escrever um objeto em um arquivo
    public static void gravarObj(String nomeArquivo, Serializable objeto) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            oos.writeObject(objeto);
            System.out.println("Objeto gravado com sucesso em " + nomeArquivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para gravar um objeto com nome de arquivo único
    public static void gravarObjUnico(String diretorio, Serializable objeto) {
        String nomeArquivo = diretorio + File.separator + UUID.randomUUID().toString() + ".txt";
        gravarObj(nomeArquivo, objeto);
    }

    // Método para ler um objeto de um arquivo
    @SuppressWarnings("unchecked")
    public static <T> T lerObj(String nomeArquivo) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            return (T) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Método para ler todos os objetos de um diretório
    public static <T> List<T> lerTodosObjetos(String diretorio) {
        File pasta = new File(diretorio);
        File[] arquivos = pasta.listFiles();
        List<T> objetos = new ArrayList<>();

        if (arquivos != null) {
            for (File arquivo : arquivos) {
                if (arquivo.isFile() && arquivo.getName().endsWith(".txt")) {
                    T objeto = lerObj(arquivo.getAbsolutePath());
                    if (objeto != null) {
                        objetos.add(objeto);
                    }
                }
            }
        }
        return objetos;
    }
}
