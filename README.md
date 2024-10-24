# G1_API_Serratec
* Trabalho final de API Restfull
* [nome do projeto ]**"...."**

## 📑 Índice
* Sobre o projeto
* Tecnologias utilizadas
* Diagrama do banco de dados
* Desenvolvedores

## 📁 Sobre o projeto
- O sistema de e-commerce foi desenvolvido para gerenciar categorias de produtos, clientes, pedidos, funcionários e compras. A aplicação utiliza autenticação JWT para segurança e segue o padrão CRUD (Create, Read, Update, Delete) em suas principais entidades.
  
- O projeto adota uma arquitetura em camadas, com separação clara entre as responsabilidades de controle, serviço e persistência de dados. A comunicação com o banco de dados é feita via Spring Data JPA, e o controle de acesso e autenticação é implementado com JWT. O processo com JWT envolve o Login, onde o usuário envia suas credenciais (ex. email e senha) para um endpoint.  Se autenticado com sucesso, o sistema gera um token JWT e o retorna no corpo da resposta. Todas as requisições subsequentes a endpoints protegidos exigem que o token JWT seja incluído no header.

- A autenticação na aplicação é feita por meio de tokens JWT. O processo envolve:
  -- Login: O usuário envia suas credenciais (ex. email e senha) para um endpoint.
  -- Geração de Token: Se autenticado com sucesso, o sistema gera um token JWT e o retorna no corpo da resposta.
  -- Validação de Token: Todas as requisições subsequentes a endpoints protegidos exigem que o token JWT seja incluído no header Authorization.**(Por enquanto não está solicitando essa solicitação)**

  - Utilizamos o Postman para realizar testes nos endpoints, validando o fluxo de criação e manipulação de dados.

- A documentação da API é gerada automaticamente usando o Swagger (via springdoc-openapi). Acessível por meio do endpoint: [gp1-api](http://localhost:8000/gp1-api/swagger-ui/index.html). A documentação expõe todos os endpoints do CRUD para as classes Cliente, Pedidos, Categoria, Funcionário, e Produtos, com detalhes sobre as operações permitidas (GET, POST, PUT, DELETE).
  
### Exemplos de Endpoints Documentados:

- Cliente-controller:
  
**GET** */clientes: Listar todos os clientes.*

**POST** */clientes/{id} : Criar um novo cliente.*

**PUT** */clientes/{id}: Atualizar um cliente existente.*

**DELETE** */clientes/{id}: Excluir um cliente.*


- Produtos-controller:
  
**GET** */produtos: Listar todos os produtos.*
  
**GET** */produtos/{nome}: Pesquisar um produto*

**POST** */produtos/{id}: Criar um novo produto.*

**PUT** */produtos/{id}: Atualizar um produto existente.*

**DELETE** */produtos/{id}: Excluir um produto.*

  
## 🌐 Tecnologias utilizadas
- [**Maven**:](https://maven.apache.org/)  ferramenta de automação e gerenciamento de build, amplamente utilizada para compilar, testar e organizar projetos, especialmente no ecossistema Spring Boot.
  
- [**Maven Repository**:](https://mvnrepository.com/) repositório central de artefatos, onde bibliotecas e dependências são armazenadas e gerenciadas para projetos Maven.
  
- [**Spring Tool Suite 4 (STS)**:](https://spring.io/tools) IDE baseada no Eclipse, otimizada para facilitar o desenvolvimento de projetos Spring Boot, com funcionalidades que agilizam a criação e o gerenciamento de aplicações Spring.
  
- [**Spring initializr**:](https://start.spring.io/) plataforma online que simplifica a criação de projetos Spring Boot, permitindo a configuração rápida de dependências e componentes iniciais.
  
- [**Postman**:](https://www.postman.com/) ferramenta versátil para testar, documentar e colaborar em APIs REST, com funcionalidades que facilitam o envio de requisições e a análise de respostas.
  
- [**Navegador Web (chrome, opera, edge, ...)**:](https://www.google.pt/intl/pt-PT/chrome/?brand=OZZY&ds_kid=43700080663033655&gad_source=1&gclid=Cj0KCQjw4Oe4BhCcARIsADQ0csl8-GMCaOUfHHPMtjSLtPewrsEcGB6gNSERLbPHeIxSPeOPwYR6sWgaAhUPEALw_wcB&gclsrc=aw.ds) utilizado para testar e validar o comportamento da aplicação web em um ambiente real, acessando interfaces e APIs desenvolvidas.

## 🔁 Diagrama do banco de dados

![gp1api - public](https://github.com/user-attachments/assets/f46d678c-9f17-425d-a0f1-39744c61c59f)


## 🖥️ Desenvolvedores
- [Ana Mattos](https://github.com/AnaMattoss)
- [Eber Cintra](https://github.com/cintra444)
- [Igor André](https://github.com/IgorAPSantos)
- [Gabriel Cruz](https://github.com/gabrielcruz07)
- [Lucas Cardinot](https://github.com/UserCardinot)
- [Luan Souza](https://github.com/LuanSouza7)
  
## E-mail grupo
`gp1apirest@gmail.com`
