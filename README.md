## Configuração das Variáveis de Ambiente

1. Crie um arquivo chamado `variables.env` na raiz do projeto.
2. Adicione as seguintes variáveis de ambiente ao arquivo `variables.env`:

    ```env
    ORACLE_PASSWORD='sua_senha'
    ORACLE_URL='sua_url'
    ORACLE_USER='seu_usuario'
    ```

   Substitua `sua_senha`, `sua_url` e `seu_usuario` pelos valores corretos.

## Subindo o Projeto via Docker

Certifique-se de ter o Docker e o Docker Compose instalados em sua máquina.

1. Crie um arquivo chamado `.env` na raiz do projeto.
2. Execute o seguinte comando para construir e iniciar os contêineres do Docker:

    ```bash
    docker-compose up
    ```

O projeto estará acessível em [http://localhost:8080/health-up](http://localhost:8080/health-up).

## Acesso à Documentação

A documentação está disponível no endpoint `http://localhost:8080/health-up/swagger-ui`. Após iniciar o projeto, acesse [http://localhost:8080/health-up/swagger-ui](http://localhost:8080/health-up/swagger-ui) para explorar a documentação da API.
