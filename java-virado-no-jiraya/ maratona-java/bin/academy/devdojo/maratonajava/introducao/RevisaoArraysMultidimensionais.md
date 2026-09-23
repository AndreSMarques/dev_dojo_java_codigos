# Revisao: arrays multidimensionais

Um array multidimensional e um array cujos elementos tambem sao arrays. Em Java, isso significa que uma matriz e, na pratica, um array de arrays. Por isso, as linhas podem ter tamanhos diferentes.

## Declaracao e criacao

Uma declaracao comum para duas dimensoes e:

```java
int[][] matriz;
matriz = new int[2][3];
```

Esse codigo cria duas linhas, cada uma com tres colunas. Os indices seguem a ordem `matriz[linha][coluna]` e comecam em `0`:

```java
matriz[0][0] = 10;
matriz[0][1] = 20;
matriz[1][2] = 30;

System.out.println(matriz[1][2]); // 30
```

Tambem e possivel inicializar a matriz diretamente:

```java
int[][] matriz = {
    {1, 2, 3},
    {4, 5, 6}
};
```

## Tamanho das dimensoes

`length` representa a quantidade de elementos da dimensao consultada:

```java
int[][] matriz = {
    {1, 2, 3},
    {4, 5, 6}
};

System.out.println(matriz.length);    // 2 linhas
System.out.println(matriz[0].length); // 3 colunas na primeira linha
```

Em uma matriz regular, todas as linhas possuem o mesmo tamanho. Ainda assim, e importante consultar `matriz[linha].length` para percorrer cada linha corretamente.

## Percorrendo uma matriz

O `for` tradicional permite controlar os indices de linha e coluna:

```java
for (int linha = 0; linha < matriz.length; linha++) {
    for (int coluna = 0; coluna < matriz[linha].length; coluna++) {
        System.out.println(matriz[linha][coluna]);
    }
}
```

O `for-each` deixa o codigo mais direto quando os indices nao sao necessarios:

```java
for (int[] linha : matriz) {
    for (int valor : linha) {
        System.out.println(valor);
    }
}
```

## Arrays irregulares

Como cada linha e um array independente, e possivel criar linhas com tamanhos diferentes. Esse formato e chamado de array irregular, ou jagged array:

```java
int[][] valores = new int[3][];

valores[0] = new int[2];
valores[1] = new int[4];
valores[2] = new int[1];
```

Tambem e possivel inicializar as linhas com tamanhos diferentes:

```java
int[][] valores = {
    {1, 2},
    {3, 4, 5, 6},
    {7}
};
```

Nesse caso, o limite das colunas deve ser obtido da linha atual:

```java
for (int linha = 0; linha < valores.length; linha++) {
    for (int coluna = 0; coluna < valores[linha].length; coluna++) {
        System.out.println(valores[linha][coluna]);
    }
}
```

## Valores padrao e `null`

Ao criar todas as dimensoes com `new int[2][3]`, os valores numericos recebem `0`:

```java
int[][] matriz = new int[2][3];
System.out.println(matriz[0][0]); // 0
```

Quando apenas a primeira dimensao e criada, as referencias para as linhas ficam `null`:

```java
int[][] matriz = new int[2][];

// matriz[0][0] = 10; // erro: a linha 0 ainda e null
matriz[0] = new int[2];
matriz[0][0] = 10;
```

Antes de acessar uma linha que pode ser `null`, ela precisa ser criada:

```java
for (int linha = 0; linha < matriz.length; linha++) {
    if (matriz[linha] == null) {
        matriz[linha] = new int[3];
    }
}
```

## Mais de duas dimensoes

O mesmo conceito pode ser aplicado a tres ou mais dimensoes:

```java
int[][][] cubo = new int[2][3][4];
cubo[0][1][2] = 10;
```

Cada indice representa uma dimensao diferente. Use lacos aninhados para percorrer todas elas:

```java
for (int plano = 0; plano < cubo.length; plano++) {
    for (int linha = 0; linha < cubo[plano].length; linha++) {
        for (int coluna = 0; coluna < cubo[plano][linha].length; coluna++) {
            System.out.println(cubo[plano][linha][coluna]);
        }
    }
}
```

## Comparacao e exibicao

Para exibir uma matriz, use `Arrays.deepToString`:

```java
import java.util.Arrays;

int[][] matriz = {{1, 2}, {3, 4}};
System.out.println(Arrays.deepToString(matriz)); // [[1, 2], [3, 4]]
```

`Arrays.equals` compara apenas uma dimensao. Para comparar arrays aninhados, use `Arrays.deepEquals`:

```java
int[][] primeira = {{1, 2}, {3, 4}};
int[][] segunda = {{1, 2}, {3, 4}};

System.out.println(Arrays.deepEquals(primeira, segunda)); // true
```

Ao acessar uma posicao, todos os indices precisam ser validos. Caso contrario, pode ocorrer `ArrayIndexOutOfBoundsException`; caso uma linha ainda nao tenha sido criada, pode ocorrer `NullPointerException`.