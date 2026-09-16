# Revisao: estruturas de repeticao

Estruturas de repeticao permitem executar um bloco varias vezes enquanto uma condicao for verdadeira ou enquanto houver elementos para processar. Elas tambem sao chamadas de lacos ou loops.

## Anatomia de um laco

Um laco normalmente possui:

1. Uma variavel de controle ou estado inicial.
2. Uma condicao de continuacao.
3. Um bloco de instrucoes.
4. Uma atualizacao que faz o laco avancar para o fim.

```java
int contador = 0;

while (contador < 3) {
    System.out.println(contador);
    contador++;
}
```

Nesse exemplo, a condicao e testada antes de cada repeticao e `contador` e incrementado para evitar que o laco continue indefinidamente.

## `while`

O `while` testa a condicao antes de executar o bloco. Se a condicao ja for falsa, o bloco pode nao ser executado nenhuma vez:

```java
int contador = 1;

while (contador <= 5) {
    System.out.println("Contador: " + contador);
    contador++;
}
```

Use `while` quando a quantidade de repeticoes depender de uma condicao e nao for conhecida antecipadamente.

### Exemplo com uma condicao de parada

```java
int numero = 1;

while (numero != 0) {
    System.out.println("Numero lido: " + numero);
    numero--;
}
```

A condicao precisa ser atualizada dentro do bloco ou por alguma operacao externa. Caso contrario, o laco pode se tornar infinito.

## `do while`

O `do while` executa o bloco primeiro e testa a condicao depois. Por isso, o bloco sempre executa pelo menos uma vez:

```java
int contador = 1;

do {
    System.out.println("Contador: " + contador);
    contador++;
} while (contador <= 5);
```

O ponto e virgula depois da condicao e obrigatorio:

```java
do {
    System.out.println("Executado uma vez");
} while (false);
```

Use `do while` quando a primeira execucao for obrigatoria, como em menus que precisam ser exibidos antes de verificar a opcao escolhida.

## `for`

O `for` concentra inicializacao, condicao e atualizacao na mesma estrutura:

```java
for (int contador = 1; contador <= 5; contador++) {
    System.out.println("Contador: " + contador);
}
```

A execucao segue esta ordem:

1. A inicializacao ocorre uma vez.
2. A condicao e avaliada.
3. O bloco e executado se a condicao for verdadeira.
4. A atualizacao ocorre.
5. A execucao volta para a etapa da condicao.

A variavel declarada na inicializacao existe apenas dentro do `for`:

```java
for (int i = 0; i < 3; i++) {
    System.out.println(i);
}

// i nao existe aqui.
```

### `for` com mais de uma expressao

As partes do `for` podem conter mais de uma expressao, separadas por virgula:

```java
for (int inicio = 0, fim = 3; inicio < fim; inicio++, fim--) {
    System.out.println(inicio + " - " + fim);
}
```

Tambem e possivel omitir partes do cabecalho, mas a condicao e a atualizacao devem ser controladas com cuidado:

```java
int contador = 0;

for (; contador < 3;) {
    System.out.println(contador);
    contador++;
}
```

### `for` para percorrer arrays

Quando o objetivo e visitar todos os elementos de um array, o `for` tradicional usa um indice:

```java
int[] numeros = {10, 20, 30};

for (int indice = 0; indice < numeros.length; indice++) {
    System.out.println(numeros[indice]);
}
```

O limite correto e `numeros.length`, sem parenteses. O ultimo indice valido e `length - 1`.

### `for-each`

O `for-each` percorre os elementos diretamente, sem exigir um indice:

```java
int[] numeros = {10, 20, 30};

for (int numero : numeros) {
    System.out.println(numero);
}
```

Ele e indicado quando o indice nao e necessario. Para alterar um elemento do array pelo indice, use o `for` tradicional.

## `break`

O `break` encerra imediatamente o laco mais proximo e continua a execucao depois dele:

```java
for (int numero = 1; numero <= 10; numero++) {
    if (numero == 5) {
        break;
    }

    System.out.println(numero);
}

System.out.println("Laco encerrado");
```

Nesse exemplo, os valores de `1` a `4` sao exibidos. Quando `numero` vale `5`, o `break` encerra o `for`.

Use `break` quando o resultado ja foi encontrado ou quando uma condicao de parada excepcional foi atingida. Em lacos aninhados, ele encerra apenas o laco mais interno:

```java
for (int linha = 0; linha < 3; linha++) {
    for (int coluna = 0; coluna < 3; coluna++) {
        if (coluna == 1) {
            break;
        }
        System.out.println(linha + ", " + coluna);
    }
}
```

## `continue`

O `continue` ignora o restante da repeticao atual e passa para a proxima iteracao:

```java
for (int numero = 1; numero <= 5; numero++) {
    if (numero % 2 == 0) {
        continue;
    }

    System.out.println(numero);
}
```

Nesse exemplo, apenas os numeros impares sao exibidos.

Em um `for`, o `continue` executa a atualizacao antes de testar a proxima iteracao. Em um `while`, a atualizacao precisa estar em um ponto que ainda sera alcancado; caso contrario, o laco pode ficar infinito:

```java
int contador = 0;

while (contador < 5) {
    contador++;

    if (contador == 3) {
        continue;
    }

    System.out.println(contador);
}
```

## Lacos aninhados

Um laco pode ficar dentro de outro. O laco interno e executado completamente para cada iteracao do laco externo:

```java
for (int linha = 1; linha <= 2; linha++) {
    for (int coluna = 1; coluna <= 3; coluna++) {
        System.out.println("Linha " + linha + ", coluna " + coluna);
    }
}
```

Lacos aninhados sao uteis para matrizes e combinacoes de valores, mas podem aumentar bastante o numero de execucoes. Mantenha a condicao e a atualizacao de cada laco claras.

## Laco infinito

Um laco infinito ocorre quando sua condicao nunca se torna falsa:

```java
while (true) {
    System.out.println("Executando");
    break;
}
```

O uso de `while (true)` pode ser valido quando existe uma saida controlada por `break`, mas deve ser evitado quando esconde uma condicao de parada simples.

Erros comuns que causam loops infinitos:

- esquecer de incrementar ou decrementar a variavel de controle;
- atualizar a variavel na direcao errada;
- usar uma condicao que nunca pode ser falsa;
- usar `continue` antes da atualizacao de um `while`.

## Qual estrutura escolher?

- Use `while` quando a condicao deve ser testada antes e a quantidade de repeticoes for incerta.
- Use `do while` quando o bloco precisar executar pelo menos uma vez.
- Use `for` quando houver uma inicializacao, uma condicao e uma atualizacao bem definidas.
- Use `for-each` quando precisar percorrer todos os elementos sem usar o indice.
- Use `break` para encerrar o laco antes do fim normal.
- Use `continue` para ignorar a iteracao atual e seguir para a proxima.

## Erros comuns

- Esquecer de atualizar a variavel de controle.
- Usar `<=` quando o limite correto seria `<`, causando acesso fora dos limites de um array.
- Confundir `break`, que encerra o laco, com `continue`, que encerra apenas a iteracao atual.
- Colocar um `continue` antes da atualizacao de um `while`.
- Alterar a colecao durante um `for-each` sem usar uma estrategia apropriada.
- Criar lacos aninhados sem perceber o custo de executar todas as combinacoes.
- Esquecer o ponto e virgula no final do `do while`.

## Resumo para lembrar

1. `while` testa a condicao antes da execucao.
2. `do while` executa o bloco pelo menos uma vez.
3. `for` organiza inicializacao, condicao e atualizacao.
4. `for-each` percorre os elementos sem exigir um indice.
5. `break` encerra o laco mais proximo.
6. `continue` pula a iteracao atual.
7. Todo laco precisa de uma forma clara de alcancar o fim.
