# Revisao: arrays

Um array e uma estrutura que armazena uma quantidade fixa de valores do mesmo tipo. Cada valor ocupa uma posicao identificada por um indice, que comeca em `0`.

## Declaracao e criacao

A declaracao informa o tipo dos elementos e o nome da variavel. A criacao reserva o espaco para uma quantidade definida de elementos:

```java
int[] numeros;
numeros = new int[3];

String[] nomes = new String[2];
```

Tambem e possivel declarar e inicializar o array com valores conhecidos:

```java
int[] numeros = {10, 20, 30};
String[] nomes = {"Ana", "Bruno"};
```

Depois que o array e criado, seu tamanho nao pode ser alterado. Para armazenar mais elementos, e necessario criar outro array ou usar uma colecao, como `ArrayList`.

## Indices e valores

O primeiro indice e `0` e o ultimo indice valido e `length - 1`:

```java
int[] numeros = new int[3];

numeros[0] = 10;
numeros[1] = 20;
numeros[2] = 30;

System.out.println(numeros[0]);              // 10
System.out.println(numeros[numeros.length - 1]); // 30
```

Tentar acessar um indice negativo ou maior ou igual a `length` causa `ArrayIndexOutOfBoundsException`:

```java
// numeros[3] = 40; // erro em tempo de execucao
```

## Valores padrao

Quando um array e criado com `new`, seus elementos recebem valores padrao:

- Tipos numericos: `0` ou `0.0`.
- `char`: `\u0000`.
- `boolean`: `false`.
- Tipos de referencia, como `String`: `null`.

```java
int[] numeros = new int[2];
String[] nomes = new String[2];

System.out.println(numeros[0]); // 0
System.out.println(nomes[0]);   // null
```

Um array de referencias nao cria automaticamente os objetos referenciados. Os objetos precisam ser instanciados separadamente:

```java
String[] nomes = new String[2];
nomes[0] = new String("Ana");
nomes[1] = "Bruno";
```

## Percorrendo um array

Use o `for` tradicional quando o indice for necessario:

```java
int[] numeros = {10, 20, 30};

for (int indice = 0; indice < numeros.length; indice++) {
    System.out.println(indice + ": " + numeros[indice]);
}
```

O `for-each` e mais simples quando basta acessar cada elemento:

```java
for (int numero : numeros) {
    System.out.println(numero);
}
```

Alterar a variavel do `for-each` nao altera o elemento primitivo no array:

```java
for (int numero : numeros) {
    numero *= 2;
}
// numeros continua com 10, 20 e 30
```

Para alterar os elementos, use o indice:

```java
for (int indice = 0; indice < numeros.length; indice++) {
    numeros[indice] *= 2;
}
```

## Arrays e referencias

Arrays sao objetos. A variavel guarda uma referencia para o array, e duas variaveis podem apontar para o mesmo objeto:

```java
int[] primeiro = {1, 2, 3};
int[] segundo = primeiro;

segundo[0] = 99;
System.out.println(primeiro[0]); // 99
```

Para criar uma copia independente, use `clone` ou um metodo da classe `Arrays`:

```java
import java.util.Arrays;

int[] original = {1, 2, 3};
int[] copia = Arrays.copyOf(original, original.length);

copia[0] = 99;
System.out.println(original[0]); // 1
```

## Classe `Arrays`

`java.util.Arrays` oferece operacoes comuns para arrays:

```java
import java.util.Arrays;

int[] numeros = {3, 1, 2};

Arrays.sort(numeros);
System.out.println(Arrays.toString(numeros)); // [1, 2, 3]
System.out.println(Arrays.equals(numeros, new int[]{1, 2, 3})); // true
```

Use `Arrays.toString` para exibir o conteudo. Imprimir o array diretamente mostra uma representacao de referencia, e nao seus elementos.

## Array como parametro e retorno

Metodos podem receber e retornar arrays:

```java
static int somar(int[] numeros) {
    int soma = 0;

    for (int numero : numeros) {
        soma += numero;
    }

    return soma;
}
```

Como o array e um objeto, o metodo pode alterar seus elementos. Se a intencao for preservar o array original, crie uma copia antes de modifica-lo.