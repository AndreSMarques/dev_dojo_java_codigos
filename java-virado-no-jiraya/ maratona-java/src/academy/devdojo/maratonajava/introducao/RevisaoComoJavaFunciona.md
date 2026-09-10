# Revisao: como o Java funciona

## Visao geral

Java e uma linguagem compilada e executada sobre uma maquina virtual. O codigo fonte escrito pelo programador nao e executado diretamente pelo sistema operacional:

```text
Codigo-fonte (.java)
        |
        | javac
        v
Bytecode (.class)
        |
        | JVM
        v
Programa em execucao
```

Essa separacao permite que o mesmo bytecode seja executado em diferentes sistemas operacionais que possuam uma JVM compatível.

## JDK, JVM e ferramentas

- **JDK (Java Development Kit):** conjunto usado para desenvolver Java. Inclui o compilador `javac`, a JVM e outras ferramentas.
- **JVM (Java Virtual Machine):** programa que carrega, verifica e executa o bytecode.
- **JRE (Java Runtime Environment):** nome tradicional para o ambiente de execucao formado pela JVM e bibliotecas. Nas distribuicoes modernas, normalmente instalamos um JDK para desenvolver ou um runtime para apenas executar.
- **Bibliotecas da plataforma:** classes prontas da API Java, como `String`, `System` e `Scanner`.

Para conferir a instalacao:

```bash
java -version
javac -version
```

## Como o Java compila

Considere este arquivo:

```java
public class OlaMundo {
    public static void main(String[] args) {
        System.out.println("Ola, mundo!");
    }
}
```

O nome do arquivo precisa ser `OlaMundo.java`, pois a classe publica tem o mesmo nome.

Ao executar:

```bash
javac OlaMundo.java
```

O compilador:

1. Le o codigo fonte.
2. Faz a analise lexica e sintatica.
3. Verifica tipos, regras da linguagem e referencias conhecidas.
4. Gera o bytecode no arquivo `OlaMundo.class`.

O bytecode e uma representacao intermediaria, independente do sistema operacional. Ele nao e, em geral, instrucoes nativas do processador.

Se houver um erro de compilacao, nenhum programa e executado. Por exemplo, uma chave ausente ou uma variavel com tipo incompatível gera uma mensagem do `javac`.

## Como o Java executa

Depois da compilacao, o comando abaixo inicia a JVM:

```bash
java OlaMundo
```

O nome da classe e informado sem `.class`. A JVM entao:

1. Inicia o processo Java.
2. Localiza e carrega a classe principal.
3. Verifica se o bytecode e valido e seguro.
4. Executa o metodo `main`.
5. Carrega outras classes conforme elas sao necessarias.
6. Encerra quando nao existem mais tarefas nao daemon em execucao.

A classe `System` oferece o objeto `out`, e `println` escreve a mensagem na saida padrao.

## Principais partes da JVM

### Class Loader

O **Class Loader** localiza e carrega arquivos `.class` para a memoria. O carregamento normalmente acontece sob demanda, quando uma classe e utilizada.

Ele segue uma hierarquia de carregadores e aplica o modelo de delegacao: antes de carregar uma classe, um carregador costuma pedir que o carregador pai tente carrega-la.

### Area de memoria

A JVM organiza a memoria em areas com responsabilidades diferentes:

- **Heap:** armazena objetos e arrays. E a area principal monitorada pelo Garbage Collector.
- **Stack:** cada thread possui sua propria pilha, com frames de metodos, variaveis locais e chamadas em andamento.
- **Metodos ou Metaspace:** guarda informacoes sobre classes, metodos e constantes. Em JVMs modernas, essa area fica fora do heap tradicional.
- **PC Register:** cada thread mantem a referencia para a proxima instrucao a ser executada.
- **Native Method Stack:** usada quando a JVM executa metodos nativos.

Uma simplificacao util e:

```text
objetos       -> heap compartilhado
variaveis locais e chamadas -> stack da thread
informacoes das classes     -> metaspace
```

### Execution Engine

A **Engine de execucao** interpreta ou compila o bytecode para instrucoes nativas:

- **Interpretador:** executa instrucoes bytecode passo a passo. Comeca rapidamente, mas pode ser mais lento em trechos muito repetidos.
- **JIT (Just-In-Time Compiler):** identifica trechos frequentemente executados e os compila para codigo nativo, melhorando o desempenho.
- **Garbage Collector:** encontra objetos que nao sao mais alcancaveis e libera a memoria que eles ocupam.

Por isso, a JVM pode comecar executando com interpretacao e otimizar partes do programa durante a execucao.

### JNI e bibliotecas nativas

A **JNI (Java Native Interface)** permite que codigo Java se comunique com codigo nativo, como bibliotecas escritas em C ou C++. Isso e usado em funcionalidades que dependem do sistema operacional ou de hardware especifico.

## Compilacao nao e execucao

Sao etapas diferentes:

```bash
# Compila: cria OlaMundo.class
javac OlaMundo.java

# Executa: inicia a JVM e roda OlaMundo
java OlaMundo
```

O arquivo `.class` pode ser levado para outro sistema com uma JVM compatível. Entretanto, o resultado ainda depende de fatores como versao da JVM, sistema operacional, bibliotecas disponiveis e configuracoes de memoria.

## Erros comuns

- **Erro de compilacao:** encontrado pelo `javac`, antes da execucao. Exemplo: `';' expected`.
- **Erro de execucao:** ocorre enquanto a JVM executa o programa. Exemplo: `ArithmeticException` ao dividir por zero.
- **Erro da JVM:** indica uma falha grave do ambiente, como `OutOfMemoryError`.
- **`ClassNotFoundException` ou classe nao encontrada:** a JVM nao encontrou uma classe necessaria no classpath.

## Classpath

O **classpath** informa onde a JVM e o compilador devem procurar classes e bibliotecas.

Para compilar e executar uma classe em uma pasta de saida:

```bash
javac -d bin src/OlaMundo.java
java -cp bin OlaMundo
```

Em projetos com pacotes, o caminho da classe acompanha o pacote:

```bash
java -cp bin academy.devdojo.maratonajava.introducao.Aula01TiposPrimitivos
```

O comando deve ser executado a partir de uma pasta em que `bin` contenha a estrutura de diretorios correspondente ao pacote.

## Resumo para lembrar

1. O programador escreve um arquivo `.java`.
2. O `javac` compila esse arquivo e gera bytecode em `.class`.
3. A JVM carrega e verifica o bytecode.
4. A Engine de execucao interpreta ou compila o bytecode para instrucoes nativas.
5. O Garbage Collector gerencia objetos que nao sao mais utilizados.
6. A portabilidade vem da JVM: o mesmo bytecode pode rodar em ambientes diferentes com uma JVM adequada.
