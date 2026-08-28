# Secure Traffic Violation Logger

Sistema backend desenvolvido em Java para o registro e gerenciamento de infrações de trânsito, aplicando o paradigma de Orientação a Objetos (POO) e persistência de dados em banco relacional (SQLite) de forma segura.

## O Problema que esta ferramenta resolve

Sistemas de trânsito que recebem dados externos (como câmeras OCR que leem placas de veículos) são alvos frequentes de manipulação de dados e ataques de injeção. O objetivo deste projeto é construir o motor de um radar de trânsito que aplique as regras de negócio (cálculo de velocidade e tolerância) e grave as multas no banco de dados com uma arquitetura **Secure by Design**.

## Funcionalidades e Arquitetura

*   **Orientação a Objetos (POO):** Modelagem do domínio utilizando as classes `Radar` e `Infracao`, aplicando os conceitos de encapsulamento para garantir a integridade dos dados na memória.
*   **Persistência Relacional (SQL):** Integração com banco de dados SQLite via JDBC para estruturação automática de tabelas e gravação permanente das infrações.
*   **Segurança contra SQL Injection:** Uso exclusivo da classe `PreparedStatement` do Java para realizar as operações de `INSERT` e `SELECT`. A parametrização das queries garante que o input da placa seja tratado estritamente como texto, mitigando riscos de execução de códigos maliciosos no banco.
*   **Build Automatizado:** Gerenciamento de dependências e execução isolada configurados via **Maven**.

## Tecnologias Utilizadas

*   **Linguagem:** Java 17
*   **Banco de Dados:** SQLite3 (SQL)
*   **Gerenciador de Dependências:** Apache Maven
*   **Conceitos:** POO, JDBC, Segurança Defensiva (Mitigação de SQLi).

## Como executar localmente

1. Certifique-se de ter o Java (JDK) e o Maven instalados.
2. Clone o repositório:
   ```bash
   git clone [https://github.com/christzph/secure-traffic-violation-logger.git](https://github.com/christzph/secure-traffic-violation-logger.git)
   cd secure-traffic-violation-logger
3. Compile e execute o sistema usando o Maven:
    ```bash
   mvn clean compile exec:java
4. O sistema irá simular a passagem de veículos, registrar as infrações no banco de dados (na pasta /db) e gerar um relatório oficial no console.