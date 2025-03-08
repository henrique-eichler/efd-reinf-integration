# EFD-Reinf Integration

This project provides an integration solution for the Brazilian EFD-Reinf (Escrituração Fiscal Digital de Retenções e Outras Informações Fiscais) system, which is part of the Brazilian Federal Revenue Service (Receita Federal) digital tax reporting requirements.

## Overview

EFD-Reinf Integration is a Java EE application that facilitates the generation, validation, signing, and transmission of EFD-Reinf events to the Brazilian government's systems. It handles various event types related to tax withholding information, particularly focusing on:

- R-4010: Payment to individual beneficiaries (pessoa física)
- R-4020: Payment to legal entity beneficiaries (pessoa jurídica)
- R-4040: Payment to unidentified beneficiaries
- R-4080: Withholding receipt
- R-4099: DIRF closing

The application provides a complete solution for managing the lifecycle of EFD-Reinf events, from data entry to submission and response processing.

## Technologies

- **Java 8**: Core programming language
- **Java EE 8**: Enterprise application framework
- **JBoss EAP 7.4**: Application server
- **PostgreSQL**: Database for storing event data
- **JAXB**: XML binding for handling XML schemas and objects
- **MapStruct**: Object mapping between entities and DTOs
- **PrimeFaces**: JSF component library for the web interface
- **Apache Santuario (XML Security)**: For digital signatures
- **Apache HTTP Client**: For REST communication with government services
- **JPA/Hibernate**: For database persistence
- **Maven**: Build and dependency management

## Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── br/
│   │       └── gov/
│   │           └── receita/
│   │               └── reinf/
│   │                   ├── r4010/         # R-4010 event handling
│   │                   ├── r4020/         # R-4020 event handling
│   │                   ├── repository/    # Data access layer
│   │                   └── util/          # Utility classes
│   └── resources/
│       ├── META-INF/
│       │   └── persistence.xml  # JPA configuration
│       └── schemas/            # XML schemas for EFD-Reinf events
└── test/
    ├── java/                  # Test classes
    └── resources/             # Test resources
```

## Setup Instructions

### Prerequisites

- JDK 8
- Maven 3.6+
- JBoss EAP 7.4
- PostgreSQL 12+

### Database Configuration

1. Create a PostgreSQL database named `reinf_db`
2. Configure the JBoss datasource as described in `src/main/resources/jboss-datasource-config.txt`

### Building the Application

```bash
mvn clean package
```

This will generate a WAR file in the `target` directory.

### Deployment

1. Copy the generated WAR file to the JBoss deployment directory
2. Start JBoss EAP
3. Access the application at `http://localhost:8080/efd-reinf-integration`

## Development

The project uses JAXB to generate Java classes from the XML schemas provided by the Brazilian Federal Revenue Service. These classes are generated during the build process and are used for serializing and deserializing XML messages.

MapStruct is used to map between the generated JAXB classes and the JPA entities, simplifying the transformation of data between the different layers of the application.

## License

This project is proprietary software.

## Contributing

Please contact the project maintainers for information about contributing to this project.