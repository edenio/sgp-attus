# Projeto de Gerenciamento de Pessoas e Endereços

Este é um projeto de exemplo que demonstra um sistema simples para gerenciar informações de pessoas e seus endereços. O sistema foi desenvolvido em Java com o framework Spring Boot.

## Funcionalidades

O sistema oferece as seguintes funcionalidades:

- Criar, editar e consultar informações de pessoas.
- Criar, editar e consultar endereços associados a uma pessoa.
- Definir um dos endereços como o endereço principal de uma pessoa.

## Tecnologias Utilizadas

O projeto utiliza as seguintes tecnologias:

- Java
- Spring Boot
- Spring Data JPA
- Banco de dados (por exemplo, H2, MySQL, etc.)

## Estrutura do Projeto

O projeto possui a seguinte estrutura de pacotes:

- `com.example`: Pacote raiz do projeto.
  - `controller`: Contém os controladores REST que lidam com as requisições HTTP.
  - `entity`: Contém as entidades de dados, como Pessoa e Endereco.
  - `repository`: Contém as interfaces dos repositórios JPA para acessar os dados no banco de dados.

## Como Executar o Projeto

Para executar o projeto localmente, siga estas etapas:

1. Clone este repositório em sua máquina local.
2. Certifique-se de ter o Java e o Maven instalados em sua máquina.
3. Configure o banco de dados de acordo com as configurações definidas no arquivo `application.yml`.
4. Execute o projeto usando o Maven: `mvn spring-boot:run`.
5. O servidor deverá iniciar e o sistema estará disponível em `http://localhost:8080`.

## Endpoints Disponíveis

O sistema disponibiliza os seguintes endpoints REST:

- `GET /pessoa/{id}`: Consulta uma pessoa pelo ID.
- `POST /pessoa/salvar`: Salva uma nova pessoa.
- `PUT /pessoa/{id}`: Atualiza os dados de uma pessoa.
- `PUT /pessoa/{id}/endereco-principal/{enderecoId}`: Define um endereço como o endereço principal de uma pessoa.

## Collection `Attus.postman_collection.json` dentro da pasta raiz do projeto.
## O diagrama de classes `diagram.yaml` está dentro da pasta raiz do projeto.


