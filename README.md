# AutomacaoApiRegresIn

1 - Introdução:

Esse projeto busca simular cenários de teste de forma automatizada utilizando JUnit e RestAssured, a partir do endpoint GetUserByiD da API pública Regres.in, disponível em: https://reqres.in. A IDE utilizada para o desenvolvimento do projeto foi o Intelij, e as versões do RestAssured e do JUnit foram, respectivamente, 4.3.0 e 4.13. 

2 - Casos e cenários de teste:

Desenvolvi seis cenários de teste em cima do endpoint GetUserById, verificando os códigos de resposta das requisições e o schema retornado, seguindo esta ordem:
- Cenário 1: 
  Utilizar o id (0) e retornar um código de resposta Not Found(404)
  Descrição: Inserir
  Resultado obtido: código de resposta 404
  Resultado esperado: código de resposta 404 + mensagem de erro
  Status: Passed
  Observações: A resposta para essa requisição poderia indicar a razão do código 404, a exemplo de: "Id not registered. no such a thing as "id":0"
  
- Cenário 2:
  Utilizar o id (dimas) e retornar um código de resposta Not Found(404)
  Descrição: Inserir um id alfabético e verificar código de resposta para tal requisição
  Resultado obtido: código de resposta 404
  Resultado esperado: código de resposta 404 + mensagem de erro
  Status: Passed
  Observações: A resposta para essa requisição poderia indicar a razão do código 404, a exemplo de: "Id declared is not an Integer. no such a thing as "id":dimas"
  
- Cenário 3:
  Utilizar um Id inválido (dimas123) e retornar um código de resposta Not Found(404)
  Descrição: Inserir um id alfanumérico e verificar código de resposta para tal requisição
  Resultado obtido: código de resposta 404
  Resultado esperado: código de resposta 404 + mensagem de erro
  Status: Passed
  Observações: A resposta para essa requisição poderia indicar a razão do código 404, a exemplo de: "Id declared is not an Integer. no such a thing as "id":dimas123"
  
- Cenário 4:
  Utilizar o id (12*) e retornar um código de resposta Not Found(404)
  Descrição: Inserir um id contendo um caractere especial e verificar código de resposta para tal requisição
  Resultado obtido: código de resposta 404
  Resultado esperado: código de resposta 404 + mensagem de erro
  Status: Passed
  Observações: A resposta para essa requisição poderia indicar a razão do código 404, a exemplo de: "Id declared is not an Integer. no such a thing as "id":12*"
  
- Cenário 5:
  Utilizar o id (1) e retornar um código de resposta OK(200)
  Descrição: Inserir um id válido e registrado e verificar código de resposta para tal requisição
  Resultado obtido: código de resposta 200 + schema
  Resultado esperado: código de resposta 200 + schema
  Status: Passed
  Observações:
  
- Cenário 6:
  Utilizar o id (13) e retornar um código de resposta Not Found(404)
  Descrição: Inserir um id válido, mas não registrado e verificar código de resposta para tal requisição
  Resultado obtido: código de resposta 404
  Resultado esperado: código de resposta 404 + mensagem de erro
  Status: Passed
  Observações: A resposta para essa requisição poderia indicar a razão do código 404, a exemplo de: "Id declared is not registered. no such a thing as "id":13"
  
3 - Melhorias:
- Muitos endpoints da api não permitem a passagem de parâmetros nas requisições, dificultando a utilização de outros tipos de teste, como os testes de  autorização e dados. Uma melhoria essencial para os testes de api seria permitir a utilização de parâmetros nos verbos POST, PUT e PATCH. 
- Ademais, para o endpoit GetUserById, a única requisição que retorna uma resposta adequada é quando o retorno é um código 200(retornando o schema), contudo. seria interessante que as respostas para as outras requisições apresentassem mensagens de erro, facilitando assim a compreensão do tipo de erro retornado para sua respectiva requisição.
- Por fim, é importante ressaltar que a automação não é totalmente independente, principalmente a validação da rota de usuários, tendo em vista que não é possível cadastrar um novo usuário pelo endpoint disponibilizado no Swagger. Dessa forma, para realizar a validação da rota de Get Users by Id foi necessário utilizar um id de usuário fixo e já existente no banco de dados da API. No caso da API possibilitar um novo cadastro de usuário, uma melhoria para a independência do teste automatizado seria cadastrar um usuário na automação e validar a existência desse usuário previamente cadastrado.
  
