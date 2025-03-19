# Testes R4010

Este diretório contém testes para o pacote r4010, que inclui classes de entidade e mapeadores para manipulação de eventos R-4010 (Retenção de Pessoa Física).

## Estrutura de Testes

Os testes estão organizados nos seguintes pacotes:

- `entity`: Testes para classes de entidade
  - `builder`: Documentação para testes de padrão builder
- `mapper`: Testes para classes de mapeamento

## Testes de Entidade

Cada classe de entidade possui uma classe de teste correspondente que verifica:

1. **Padrão Builder**: Testa se o builder define corretamente todos os campos e retorna uma entidade construída adequadamente
2. **Getters e Setters**: Testa se os getters e setters funcionam corretamente
3. **equals() e hashCode()**: Testa se os métodos equals() e hashCode() funcionam corretamente, incluindo casos extremos

Classes de teste de entidade:
- BeneficiarioTest.java
- BeneficiarioPensaoTest.java
- ContribuinteTest.java
- DeducaoTest.java
- DependenteTest.java
- EstabelecimentoTest.java
- EventoRetencaoPessoaFisicaTest.java
- PagamentoTest.java

## Testes de Mapeador

Os testes de mapeador verificam se o mapeador mapeia corretamente objetos de esquema XML para objetos de entidade:

- R4010MapperTest.java: Testa a classe R4010Mapper

## Executando os Testes

Para executar todos os testes:

```bash
mvn test
```

Para executar uma classe de teste específica:

```bash
mvn test -Dtest=BeneficiarioTest
```

Para executar um método de teste específico:

```bash
mvn test -Dtest=BeneficiarioTest#testBuilderAndGettersSetters
```

## Cobertura de Testes

Os testes cobrem:
- Todas as classes de entidade no pacote r4010.entity
- A classe de mapeador no pacote r4010.mapper
- Todos os métodos nestas classes, incluindo getters, setters, equals(), hashCode(), e métodos builder
