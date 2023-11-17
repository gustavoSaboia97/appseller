# App Sales

## Executar

Caso queira executar tudo no contexto do docker compose será necessário apenas utilizar o seguinte comando:
`docker compose up`. Adicionar a flag --build caso seja necessário um novo build do projeto.

Caso queira executar apenas a base de dados e rodar de forma externa a aplicação:
`docker compose up mysql`. Desta forma, apenas o banco de dados executará com o Docker e ficará exposto na porta 3306.

Caso queira executar apenas o frontend:
`docker compose up frontend`. Desta forma, apenas o banco de dados executará com o Docker e ficará exposto na porta 3306.

## Preenchimento da Base

Os dados da base de dados são carregados a partir dos arquivos no diretorio `./files` .

## Exibição dos dados

Para acessar o frontend é necessário acessar: http://localhost:8081/
Para acessar o backend é necessário acessar via: http://localhost:8080/

Possíveis rotas frontend:

- / -> Home
- /products -> Contém os dados de produtos
- /sellers -> Contém os dados de vendedores

Possíveis rotas backend:

- /api/sales-info -> Endpoint relacionado a quantidade das entidades
- /api/product -> Endpoint relacionado a produtos
- /api/seller -> Endpoint relacionado a vendedores
