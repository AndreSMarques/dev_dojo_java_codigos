# Revisao: tipos primitivos, conversao e strings

## Tipos primitivos

Java possui oito tipos primitivos. Eles armazenam valores simples e nao sao objetos:

| Tipo | Tamanho | Valores aproximados ou faixa |
|---|---:|---|
| `byte` | 8 bits | de -128 a 127 |
| `short` | 16 bits | de -32.768 a 32.767 |
| `int` | 32 bits | de -2^31 a 2^31 - 1 |
| `long` | 64 bits | de -2^63 a 2^63 - 1 |
| `float` | 32 bits | ponto flutuante, menor precisao |
| `double` | 64 bits | ponto flutuante, maior precisao |
| `char` | 16 bits | um caractere UTF-16, de `\\u0000` a `\\uffff` |
| `boolean` | nao especificado pela linguagem | `true` ou `false` |

Os tipos inteiros sao `byte`, `short`, `int` e `long`. Os tipos de ponto flutuante sao `float` e `double`. `char` representa uma unidade de codigo UTF-16, e `boolean` representa uma condicao logica.

> Os tamanhos da tabela representam a capacidade definida pela linguagem. A JVM pode usar uma representacao interna diferente, principalmente para variaveis locais e valores temporarios.

## Declaracao e inicializacao

Declarar uma variavel e informar seu tipo e seu nome. Inicializar e atribuir o primeiro valor:

```java
int idade;       // declaracao
idade = 25;      // inicializacao por atribuicao

int ano = 2026;  // declaracao e inicializacao
char inicial = 'J';
boolean aprovado = true;
```

Uma variavel local precisa receber um valor antes de ser lida:

```java
int numero;
// System.out.println(numero); // erro de compilacao
numero = 10;
System.out.println(numero);
```

Variaveis de instancia e atributos estaticos recebem valores padrao quando nao sao inicializados explicitamente. Variaveis locais nao recebem esse valor padrao automaticamente.

### Valores padrao de atributos

- Tipos numericos: `0` ou `0.0`.
- `char`: `\\u0000`.
- `boolean`: `false`.
- Referencias, como `String`: `null`.

## Literais e sufixos

Numeros inteiros sao considerados `int` por padrao. Para indicar um `long`, use `L`:

```java
int numero = 10;
long populacao = 8_000_000_000L;
```

Numeros com ponto decimal sao considerados `double` por padrao. Para um `float`, use `f` ou `F`:

```java
double preco = 19.90;
float taxa = 0.1F;
```

Tambem e possivel usar sublinhados para facilitar a leitura de numeros, desde que eles nao fiquem no inicio, no fim ou junto ao ponto decimal:

```java
int umMilhao = 1_000_000;
```

## Conversao de variaveis

Conversao e a mudanca de um tipo para outro. Ela pode ser implicita ou explicita.

### Conversao implicita: widening

A conversao para um tipo capaz de representar uma faixa maior ocorre automaticamente. Esse processo e chamado de widening conversion:

```java
int idade = 25;
long idadeLong = idade;
float valorFloat = idadeLong;
double valorDouble = valorFloat;
```

A ordem mais comum entre tipos numericos e:

```text
byte -> short -> int -> long -> float -> double
```

Essa ordem e uma simplificacao para estudo. Converter de `long` para `float`, por exemplo, pode perder precisao, mesmo sem exigir casting explicito.

### Conversao explicita: narrowing

Quando o tipo de destino pode nao comportar o valor original, o casting e obrigatorio:

```java
long numeroLong = 10L;
int numeroInt = (int) numeroLong;

double nota = 9.5;
int notaInteira = (int) nota; // resultado: 9
```

O casting de um numero decimal para um tipo inteiro remove a parte fracionaria; ele nao arredonda o valor.

Quando o valor nao cabe no tipo menor, pode ocorrer overflow:

```java
int valor = 130;
byte convertido = (byte) valor; // resultado: -126
```

Por isso, o casting deve ser usado apenas quando a perda de dados for conhecida e aceitavel.

## Casting e promocoes numericas

Casting e a conversao explicita usando o tipo entre parenteses antes do valor:

```java
float resultado = (float) 10.5;
```

Em expressoes aritmeticas, tipos menores que `int`, como `byte`, `short` e `char`, geralmente sao promovidos para `int`:

```java
byte primeiro = 10;
byte segundo = 20;
// byte soma = primeiro + segundo; // erro: a expressao resulta em int
byte soma = (byte) (primeiro + segundo);
```

O operador de atribuicao composto pode fazer uma conversao implicita semelhante ao casting:

```java
byte numero = 10;
numero += 5; // equivalente, neste caso, a numero = (byte) (numero + 5)
```

Ainda assim, e preciso tomar cuidado com overflow.

## Tipos e memoria

Uma visao simplificada ajuda a entender onde os valores ficam:

```text
variavel primitiva local -> valor associado ao frame da thread
objeto String            -> objeto no heap
variavel de referencia   -> referencia para o objeto
```

Essa representacao e conceitual. O compilador e a JVM podem otimizar a forma como os valores sao armazenados. O tamanho em bits dos tipos numericos e garantido pela linguagem, mas o tamanho real de uma referencia ou de um objeto depende da JVM, da arquitetura e das configuracoes.

A classe `String` nao e um tipo primitivo. Uma variavel `String` armazena uma referencia para um objeto, e o objeto possui dados e metadados adicionais. Portanto, nao existe um tamanho fixo simples para qualquer `String`.

## Strings

`String` representa uma sequencia de caracteres e e uma classe da API Java:

```java
String nome = "DevDojo";
String mensagem = new String("Ola");
```

Na maioria dos casos, use um literal de texto. O Java pode reutilizar literais iguais no chamado string pool:

```java
String a = "Java";
String b = "Java";
System.out.println(a == b); // normalmente true: mesma referencia do pool
```

O operador `==` compara referencias quando usado com objetos. Para comparar o conteudo, use `equals`:

```java
String primeiro = "Java";
String segundo = new String("Java");

System.out.println(primeiro == segundo);       // false
System.out.println(primeiro.equals(segundo));  // true
```

Strings sao imutaveis. Metodos como `toUpperCase` e `concat` produzem outra `String`; eles nao alteram o objeto original:

```java
String texto = "java";
String maiusculo = texto.toUpperCase();

System.out.println(texto);      // java
System.out.println(maiusculo);  // JAVA
```

Operacoes frequentes:

```java
String linguagem = "Java";

linguagem.length();            // quantidade de unidades UTF-16
linguagem.charAt(0);           // primeiro char
linguagem.toUpperCase();       // JAVA
linguagem.toLowerCase();       // java
linguagem.contains("av");      // true
linguagem.equals("Java");      // compara conteudo
linguagem.substring(1, 3);     // "av"
```

Para montar uma string com varias alteracoes, `StringBuilder` costuma ser mais apropriado do que concatenar repetidamente dentro de um laco:

```java
StringBuilder builder = new StringBuilder();
builder.append("Java");
builder.append(" ");
builder.append("e");
builder.append(" legal");

String resultado = builder.toString();
```

## Conversao para texto

A concatenacao com uma `String` converte o outro valor para texto:

```java
int idade = 25;
String frase = "Idade: " + idade;
```

Para conversoes explicitas, use metodos como:

```java
int numero = Integer.parseInt("42");
double decimal = Double.parseDouble("3.14");
String texto = String.valueOf(100);
```

`parseInt` e `parseDouble` podem lancar `NumberFormatException` quando o texto nao representa um numero valido.

## Resumo para lembrar

1. Java possui oito tipos primitivos: quatro inteiros, dois de ponto flutuante, `char` e `boolean`.
2. Uma variavel local precisa ser inicializada antes da leitura.
3. O widening geralmente ocorre de forma implicita; o narrowing exige casting.
4. Casting pode remover casas decimais ou causar overflow.
5. `String` e uma classe, nao um tipo primitivo, e seus objetos sao imutaveis.
6. Use `equals` para comparar o conteudo de strings e `==` para comparar referencias.
7. O tamanho de referencias e objetos depende da JVM; os tamanhos numericos definidos pela linguagem sao os da tabela.
