# Builder Tests

This directory contains tests for the builder pattern implementation in the entity classes.

## Purpose

The builder pattern tests verify that:
1. The builder correctly sets all fields in the entity
2. The build() method returns a properly constructed entity
3. The builder methods are chainable

## Implementation

The builder tests are already included in the entity test classes:
- BeneficiarioTest.java
- BeneficiarioPensaoTest.java
- ContribuinteTest.java
- DeducaoTest.java
- DependenteTest.java
- EstabelecimentoTest.java
- EventoRetencaoPessoaFisicaTest.java
- PagamentoTest.java

Each entity test class includes a `testBuilderAndGettersSetters()` method that tests the builder pattern along with getters and setters.