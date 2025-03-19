# Integração EFD-Reinf

Este projeto fornece uma solução de integração para o sistema brasileiro EFD-Reinf (Escrituração Fiscal Digital de Retenções e Outras Informações Fiscais), que faz parte dos requisitos de declaração fiscal digital da Receita Federal do Brasil.

## Visão Geral

A Integração EFD-Reinf é uma aplicação Java EE que facilita a geração, validação, assinatura e transmissão de eventos EFD-Reinf para os sistemas do governo brasileiro. Ela lida com vários tipos de eventos relacionados a informações de retenção de impostos, com foco particular em:

- R-4010: Pagamento a beneficiários pessoa física
- R-4020: Pagamento a beneficiários pessoa jurídica
- R-4040: Pagamento a beneficiários não identificados
- R-4080: Recibo de retenção
- R-4099: Fechamento da DIRF

A aplicação fornece uma solução completa para gerenciar o ciclo de vida dos eventos EFD-Reinf, desde a entrada de dados até o envio e processamento de respostas.

## Tecnologias

- **Java 8**: Linguagem de programação principal
- **Java EE 8**: Framework de aplicação empresarial
- **JBoss EAP 7.4**: Servidor de aplicação
- **PostgreSQL**: Banco de dados para armazenamento de dados de eventos
- **JAXB**: Vinculação XML para manipulação de esquemas e objetos XML
- **MapStruct**: Mapeamento de objetos entre entidades e DTOs
- **PrimeFaces**: Biblioteca de componentes JSF para interface web
- **Apache Santuario (XML Security)**: Para assinaturas digitais
- **Apache HTTP Client**: Para comunicação REST com serviços governamentais
- **JPA/Hibernate**: Para persistência de banco de dados
- **Maven**: Gerenciamento de dependências e build

## Estrutura do Projeto

```
src/
├── main/
│   ├── java/
│   │   └── br/
│   │       └── gov/
│   │           └── receita/
│   │               └── reinf/
│   │                   ├── r4010/         # Tratamento de eventos R-4010
│   │                   ├── r4020/         # Tratamento de eventos R-4020
│   │                   ├── repository/    # Camada de acesso a dados
│   │                   └── util/          # Classes utilitárias
│   └── resources/
│       ├── META-INF/
│       │   └── persistence.xml  # Configuração JPA
│       └── schemas/            # Esquemas XML para eventos EFD-Reinf
└── test/
    ├── java/                  # Classes de teste
    └── resources/             # Recursos de teste
```

## Instruções de Configuração

### Pré-requisitos

- JDK 8
- Maven 3.6+
- JBoss EAP 7.4
- PostgreSQL 12+

### Configuração do Banco de Dados

1. Crie um banco de dados PostgreSQL chamado `reinf_db`
2. Configure o datasource do JBoss conforme descrito em `src/main/resources/jboss-datasource-config.txt`

### Compilando a Aplicação

```bash
mvn clean package
```

Isso irá gerar um arquivo WAR no diretório `target`.

### Implantação

1. Copie o arquivo WAR gerado para o diretório de implantação do JBoss
2. Inicie o JBoss EAP
3. Acesse a aplicação em `http://localhost:8080/efd-reinf-integration`

## Desenvolvimento

O projeto utiliza JAXB para gerar classes Java a partir dos esquemas XML fornecidos pela Receita Federal do Brasil. Essas classes são geradas durante o processo de build e são utilizadas para serializar e desserializar mensagens XML.

MapStruct é utilizado para mapear entre as classes JAXB geradas e as entidades JPA, simplificando a transformação de dados entre as diferentes camadas da aplicação.

## Licença

Este projeto é um software proprietário.

## Contribuição

Por favor, entre em contato com os mantenedores do projeto para obter informações sobre como contribuir para este projeto.
