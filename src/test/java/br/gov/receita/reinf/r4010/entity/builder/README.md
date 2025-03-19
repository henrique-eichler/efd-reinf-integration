# Testes de Builder

Este diretório contém testes para a implementação do padrão builder nas classes de entidade.

## Objetivo

Os testes do padrão builder verificam que:
1. O builder define corretamente todos os campos na entidade
2. O método build() retorna uma entidade construída adequadamente
3. Os métodos do builder são encadeáveis

## Implementação

Os testes de builder já estão incluídos nas classes de teste de entidade:
- BeneficiarioTest.java
- BeneficiarioPensaoTest.java
- ContribuinteTest.java
- DeducaoTest.java
- DependenteTest.java
- EstabelecimentoTest.java
- EventoRetencaoPessoaFisicaTest.java
- PagamentoTest.java

Cada classe de teste de entidade inclui um método `testBuilderAndGettersSetters()` que testa o padrão builder junto com getters e setters.
