# Projeto de Persistência de Objetos em Arquivos

Este projeto apresenta uma solução simples para persistência de objetos em arquivos utilizando a serialização do Java. O foco principal é a classe `Gravar.java`, que oferece métodos genéricos para gravar e ler objetos serializáveis. As outras classes fornecidas são apenas para exemplificação do uso da classe `Gravar`.

## Classe Gravar

A classe `Gravar` foi desenvolvida para facilitar a persistência de objetos serializáveis em arquivos. Ela inclui métodos para gravar e ler objetos de forma genérica, permitindo que qualquer objeto que implemente a interface `Serializable` seja facilmente armazenado e recuperado.

### Métodos Principais

#### `gravarObj(String nomeArquivo, Serializable objeto)`

Este método grava um objeto serializável em um arquivo especificado.

- **Parâmetros**:
  - `nomeArquivo`: O caminho do arquivo onde o objeto será gravado.
  - `objeto`: O objeto que será gravado no arquivo. Deve implementar a interface `Serializable`.

- **Uso**:
  ```java
  MeuObjeto obj = new MeuObjeto();
  Gravar.gravarObj("caminho/para/arquivo.txt", obj);
  ```

#### `gravarObjUnico(String diretorio, Serializable objeto)`

Este método grava um objeto serializável em um arquivo com um nome único (UUID) dentro de um diretório especificado.

- **Parâmetros**:
  - `diretorio`: O diretório onde o arquivo será criado.
  - `objeto`: O objeto que será gravado no arquivo. Deve implementar a interface `Serializable`.

- **Uso**:
  ```java
  MeuObjeto obj = new MeuObjeto();
  Gravar.gravarObjUnico("caminho/para/diretorio", obj);
  ```

#### `lerObj(String nomeArquivo)`

Este método lê um objeto de um arquivo especificado.

- **Parâmetros**:
  - `nomeArquivo`: O caminho do arquivo de onde o objeto será lido.

- **Retorno**:
  - O objeto lido do arquivo, ou `null` se ocorrer algum erro.

- **Uso**:
  ```java
  MeuObjeto obj = Gravar.lerObj("caminho/para/arquivo.txt");
  ```

#### `lerTodosObjetos(String diretorio)`

Este método lê todos os objetos serializáveis de arquivos `.txt` em um diretório especificado.

- **Parâmetros**:
  - `diretorio`: O diretório de onde os arquivos serão lidos.

- **Retorno**:
  - Uma lista de objetos lidos do diretório.

- **Uso**:
  ```java
  List<MeuObjeto> objetos = Gravar.lerTodosObjetos("caminho/para/diretorio");
  ```

## Exemplo de Uso

Para demonstrar o funcionamento da classe `Gravar`, foi criada a classe `Pessoa` que implementa `Serializable`, e a classe `Main` que interage com o usuário através de um menu para gerenciar uma lista de pessoas.

### Classe Pessoa

A classe `Pessoa` é uma classe de exemplo que representa uma pessoa com atributos nome, idade, altura e peso.

### Classe Main

A classe `Main` fornece um menu interativo para:
1. Ver a lista completa de pessoas.
2. Adicionar uma nova pessoa à lista.
3. Capturar uma pessoa específica na lista pelo índice.
4. Sair da aplicação.

### Como Executar

1. **Compile todas as classes**:
    ```sh
    javac Gravar.java Pessoa.java Main.java
    ```

2. **Crie um diretório chamado `pessoas`**:
    ```sh
    mkdir pessoas
    ```

3. **Execute a aplicação**:
    ```sh
    java Main
    ```

## Considerações Finais

A classe `Gravar` simplifica a tarefa de persistir objetos em arquivos sem a necessidade de um banco de dados. Ela é flexível e pode ser utilizada com qualquer classe que implemente a interface `Serializable`.
