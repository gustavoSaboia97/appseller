# App Sales

## Executar

Caso queira executar tudo no contexto do docker compose será necessário apenas utilizar o seguinte comando:
`docker compose up`. Adicionar a flag --build caso seja necessário um novo build do projeto.

Caso queira executar apenas a base de dados e rodar de forma externa a aplicação:
`docker compose up mysql`. Desta forma, apenas o banco de dados executará com o Docker e ficará exposto na porta 3306.

## Preenchimento da Base

Os dados da base de dados são carregados a partir dos arquivos no diretorio `./files` .
