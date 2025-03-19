# R4020 Tests

This directory contains tests for the r4020 package, which includes entity classes and mappers for handling R-4020 events (Retenção de Pessoa Jurídica).

## Test Structure

The tests are organized into the following packages:

- `entity`: Tests for entity classes
  - `builder`: Documentation for builder pattern tests
- `mapper`: Tests for mapper classes

## Entity Tests

Each entity class has a corresponding test class that verifies:

1. **Builder Pattern**: Tests that the builder correctly sets all fields and returns a properly constructed entity
2. **Getters and Setters**: Tests that getters and setters work correctly
3. **equals() and hashCode()**: Tests that equals() and hashCode() methods work correctly, including edge cases

Entity test classes:
- BeneficiarioTest.java
- ContribuinteTest.java
- EndExtTest.java
- EstabelecimentoTest.java
- EventoRetencaoPessoaJuridicaTest.java
- IdeAdvTest.java
- InfoPgtoExtTest.java
- InfoProcJudTest.java
- InfoProcRetTest.java
- PagamentoTest.java
- RetencoesTest.java

## Mapper Tests

The mapper tests verify that the mapper correctly maps XML schema objects to entity objects:

- R4020MapperTest.java: Tests the R4020Mapper class

## Running the Tests

To run all tests:

```bash
mvn test
```

To run a specific test class:

```bash
mvn test -Dtest=BeneficiarioTest
```

To run a specific test method:

```bash
mvn test -Dtest=BeneficiarioTest#testBuilderAndGettersSetters
```

## Test Coverage

The tests cover:
- All entity classes in the r4020.entity package
- The mapper class in the r4020.mapper package
- All methods in these classes, including getters, setters, equals(), hashCode(), and builder methods