# Revisao: estruturas condicionais

Estruturas condicionais permitem que o programa escolha quais instrucoes executar de acordo com o resultado de uma expressao booleana ou com o valor de uma expressao.

## Expressao booleana

Uma condicao precisa resultar em `true` ou `false`:

```java
int idade = 20;
boolean maiorDeIdade = idade >= 18;

System.out.println(maiorDeIdade); // true
```

Operadores relacionais comuns:

| Operador | Significado |
|---|---|
| `==` | igual a |
| `!=` | diferente de |
| `>` | maior que |
| `<` | menor que |
| `>=` | maior ou igual a |
| `<=` | menor ou igual a |

Operadores logicos combinam condicoes:

| Operador | Significado |
|---|---|
| `&&` | E: todas as condicoes precisam ser verdadeiras |
| `||` | OU: pelo menos uma condicao precisa ser verdadeira |
| `!` | NAO: inverte o resultado |

```java
int idade = 25;
boolean possuiDocumento = true;

if (idade >= 18 && possuiDocumento) {
    System.out.println("Entrada autorizada");
}
```

Os operadores `&&` e `||` usam avaliacao de curto-circuito. Se o resultado ja puder ser determinado pela primeira condicao, as demais nao serao avaliadas.

## `if`

O `if` executa um bloco apenas quando sua condicao e verdadeira:

```java
int numero = 10;

if (numero > 0) {
    System.out.println("O numero e positivo");
}
```

As chaves sao recomendadas mesmo quando o bloco possui uma unica instrucao. Elas deixam claro quais comandos pertencem a condicao e evitam erros ao adicionar novas linhas.

## `if` e `else`

O `else` define o bloco alternativo, executado quando a condicao do `if` e falsa:

```java
int numero = 7;

if (numero % 2 == 0) {
    System.out.println("Numero par");
} else {
    System.out.println("Numero impar");
}
```

Apenas um dos dois blocos sera executado nesse exemplo.

## `else if`

Use `else if` quando houver varias condicoes mutuamente exclusivas. O Java testa as condicoes de cima para baixo e executa somente o primeiro bloco verdadeiro:

```java
double nota = 8.5;

if (nota >= 9) {
    System.out.println("A");
} else if (nota >= 7) {
    System.out.println("B");
} else if (nota >= 5) {
    System.out.println("C");
} else {
    System.out.println("Reprovado");
}
```

A ordem das condicoes importa. Uma condicao mais abrangente antes de outra mais especifica pode impedir que a segunda seja alcancada:

```java
int idade = 15;

if (idade >= 0) {
    System.out.println("Idade valida");
} else if (idade >= 18) {
    // Nunca sera executado: toda idade >= 18 tambem e >= 0.
    System.out.println("Maior de idade");
}
```

Nesse caso, as condicoes devem ser reorganizadas ou separadas de acordo com a regra desejada.

## `switch`

O `switch` e adequado quando uma expressao precisa ser comparada com varias opcoes fixas:

```java
int dia = 2;

switch (dia) {
    case 1:
        System.out.println("Domingo");
        break;
    case 2:
        System.out.println("Segunda-feira");
        break;
    case 3:
        System.out.println("Terca-feira");
        break;
    default:
        System.out.println("Dia invalido");
}
```

O `case` indica um valor possivel. O `default` e opcional e trata os valores que nao correspondem a nenhum `case`.

### `break` e fall-through

Em um `switch` tradicional, `break` encerra o `switch`. Sem ele, a execucao continua nos proximos `case`, comportamento chamado de fall-through:

```java
char opcao = 'A';

switch (opcao) {
    case 'A':
    case 'a':
        System.out.println("Opcao A");
        break;
    default:
        System.out.println("Outra opcao");
}
```

Nesse exemplo, os dois `case` compartilham o mesmo bloco. O `break` evita que o `default` tambem seja executado.

### Tipos aceitos

O `switch` tradicional pode usar:

- `byte`, `short`, `char` e `int`;
- seus wrappers, como `Integer` e `Character`;
- `String`;
- enumeracoes (`enum`).

Nao e possivel usar diretamente `long`, `float`, `double` ou `boolean` em um `switch` tradicional.

Exemplo com `String`:

```java
String perfil = "ADMIN";

switch (perfil) {
    case "ADMIN":
        System.out.println("Acesso total");
        break;
    case "USER":
        System.out.println("Acesso comum");
        break;
    default:
        System.out.println("Perfil desconhecido");
}
```

Se a expressao for uma referencia `String` nula, o `switch` tradicional gera `NullPointerException`. Valide o valor antes quando `null` for possivel.

## `switch` com seta

Versoes modernas do Java permitem uma sintaxe com `->`. Ela nao exige `break` e evita o fall-through acidental:

```java
int opcao = 1;

switch (opcao) {
    case 1 -> System.out.println("Cadastrar");
    case 2 -> System.out.println("Consultar");
    default -> System.out.println("Opcao invalida");
}
```

Tambem e possivel agrupar valores no mesmo `case`:

```java
int mes = 2;

switch (mes) {
    case 12, 1, 2 -> System.out.println("Verao");
    case 3, 4, 5 -> System.out.println("Outono");
    case 6, 7, 8 -> System.out.println("Inverno");
    case 9, 10, 11 -> System.out.println("Primavera");
    default -> System.out.println("Mes invalido");
}
```

## `switch` como expressao

Um `switch` tambem pode produzir um valor. Use `yield` quando o bloco possuir mais de uma instrucao:

```java
int codigo = 2;

String mensagem = switch (codigo) {
    case 1 -> "Sucesso";
    case 2 -> {
        System.out.println("Processando codigo 2");
        yield "Em processamento";
    }
    default -> "Codigo desconhecido";
};

System.out.println(mensagem);
```

Em uma expressao `switch`, todos os caminhos precisam produzir um valor. Por isso, normalmente e importante incluir um `default` quando os casos nao cobrem todos os valores possiveis.

## `if` ou `switch`?

- Use `if` quando a decisao envolver intervalos, comparacoes, combinacoes logicas ou condicoes diferentes.
- Use `switch` quando uma unica expressao for comparada com varios valores fixos.
- Prefira a sintaxe com seta quando a versao do Java do projeto permitir, pois ela reduz erros de fall-through.

## Erros comuns

- Usar `=` no lugar de `==` em uma comparacao.
- Comparar o conteudo de `String` com `==` em vez de `equals`.
- Esquecer `break` em um `switch` tradicional.
- Colocar uma condicao abrangente antes de uma condicao especifica.
- Esquecer as chaves e criar um `else` associado ao `if` errado.
- Tentar usar `long`, `double` ou `boolean` diretamente em um `switch` tradicional.
- Acessar uma referencia que pode ser `null` dentro de uma condicao sem valida-la.

## Resumo para lembrar

1. `if` executa um bloco quando uma condicao e verdadeira.
2. `else` trata o caminho contrario.
3. `else if` permite testar varias condicoes em ordem.
4. `switch` compara uma expressao com valores fixos.
5. No `switch` tradicional, `break` impede o fall-through.
6. A sintaxe `case ... ->` evita a necessidade de `break`.
7. Um `switch` pode ser uma expressao e retornar um valor.
