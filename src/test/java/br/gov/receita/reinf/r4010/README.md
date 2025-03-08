# R4010 Tests

This directory contains tests for the r4010 package, which includes entity classes and mappers for handling R-4010 events (Retenção de Pessoa Física).

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
- BeneficiarioPensaoTest.java
- ContribuinteTest.java
- DeducaoTest.java
- DependenteTest.java
- EstabelecimentoTest.java
- EventoRetencaoPessoaFisicaTest.java
- PagamentoTest.java

## Mapper Tests

The mapper tests verify that the mapper correctly maps XML schema objects to entity objects:

- R4010MapperTest.java: Tests the R4010Mapper class

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
- All entity classes in the r4010.entity package
- The mapper class in the r4010.mapper package
- All methods in these classes, including getters, setters, equals(), hashCode(), and builder methods
