# kotlin-best-practices
Kotlin - Best Practices

Baseado em:
- [idiomatic-kotlin-best-practices](https://phauer.com/2017/idiomatic-kotlin-best-practices/)
- [kotlin-combating-non-null-assertions](https://medium.com/@igorwojda/kotlin-combating-non-null-assertions-5282d7b97205)

## Programação Funcional
<p>Entre outras vantagens, a programação funcional nos permite reduzir os efeitos colaterais, o que torna nosso código…</p>

- menos sujeito a erros
- mais fácil de entender
- mais fácil de testar
- thread-safe

<p>Em comparação ao Java 8, Kotlin tem um suporte muito melhor para programação funcional:</p>

- Imutabilidade: `val` para variáveis e propriedades, classes de dados imutáveis... `copy()`
- Expressões: Funções de expressão única. `if`, `when` e `try-catch` são expressões. Podemos combinar essas estruturas de controle com outras expressões de forma concisa.
- Tipos de função
- Expressões lambda concisas
- API de coleção do Kotlin

<p>Esses recursos permitem escrever código funcional de maneira segura, concisa e expressiva. Consequentemente, podemos criar funções puras (funções sem efeitos colaterais) com mais facilidade.</p>