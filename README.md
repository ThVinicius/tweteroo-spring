# Tweteroo-Spring-Boot

<h1 align="center">
  Tweteroo
</h1>
<div align="center">

<h3>Built With</h3>

  <img src="https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white" height="30px"/>
  <img src="https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white" height="30px"/>

  <!-- Badges source: https://dev.to/envoy_/150-badges-for-github-pnk -->
</div>

<br/>

# Sumário

- [Descrição](#description)
- [Documentação da API](#api-reference)
    - [Rota de autenticação](#authentication-routes)
        - [Acessar o chat](#sign-up)
    - [Rotas dos tweets](#tweets-routes)
        - [Enviar um tweet](#post-tweets)
        - [Buscar todos os tweets](#get-tweets)
        - [Buscar todos os tweets de um usuário](#get-tweets-by-username)
- [Rodar com docker](#run-docker)

<div id='description'/>

# Descrição

Tweteroo é uma API de chat simples.

</br>

## Funções

- Acessar o chat
- Mandar uma mensagem
- Visualizar todas as mensagens enviadas
- Visualizar todas as mesnsagens enviadas de um usário específico.

</br>

<div id='api-reference'/>

# Documentação da API

<div id='authentication-routes'/>

## Rota de autenticação

<div id='sign-up'/>

### Acessar o chat

```http
POST /sign-up
```

<h3>Request:</h3>
Enviar no body da requisição

| Params     | Type     | Description            |
|:-----------|:---------|:-----------------------|
| `username` | `string` | **Required**, **trim** |
| `avatar`   | `string` | **Required**, **trim** |

<h3>Response:</h3>

<h3>Em caso de sucesso:</h3>

- Status code: 201

#

<div id='tweets-routes'/>

## Rotas dos tweets

<div id='post-tweets'/>

### Enviar um tweet

```http
POST /tweets
```

<h3>Request:</h3>
Enviar no body da requisição

| Params     | Type     | Description            |
|:-----------|:---------|:-----------------------|
| `username` | `string` | **Required**, **trim** |
| `tweet`    | `string` | **Required**, **trim** |

<h3>Response:</h3>

<h3>Em caso de erro: </h3>

| Status | Case                   |
|:-------|:-----------------------|
| `404`  | Usuário não encontrado |

<h3>Em caso de sucesso:</h3>

- Status code: 201

#

<div id='get-tweets'/>

### Buscar todos os tweets

```http
GET /tweets
```

<h3>Response:</h3>

<h3>Em caso de sucesso:</h3>

- Status code: 200
- Um array com todos os tweets

```json
[
  {
    "username": "bobesponja",
    "avatar": "https://super.abril.com.br/wp-content/uploads/2020/09/04-09_gato_SITE.jpg?quality=70&strip=info",
    "tweet": "eu amo o hub"
  }
]
```

#

<div id='get-tweets-by-username'/>

### Buscar todos os tweets de um usuário

```http
GET /tweets/{username}
```

<h3>Request:</h3>
Enviar no params da requisição

| Params     | Type     | Description            |
|:-----------|:---------|:-----------------------|
| `username` | `string` | **Required**, **trim** |

<h3>Response:</h3>

<h3>Em caso de erro: </h3>

| Status | Case                   |
|:-------|:-----------------------|
| `404`  | Usuário não encontrado |

<h3>Em caso de sucesso:</h3>

- Status code: 200
- Um array com todos os tweets daquele usuário

```json
[
  {
    "username": "bobesponja",
    "avatar": "https://super.abril.com.br/wp-content/uploads/2020/09/04-09_gato_SITE.jpg?quality=70&strip=info",
    "tweet": "eu amo o hub"
  }
]
```

#

<div id='run-docker'/>

# Rodar com docker

Clone o projeto

```bash
  git clone https://github.com/ThVinicius/tweteroo-spring.git
```

Vá para o diretório do projeto

```bash
  cd tweteroo-spring
```

Faça o build do container

```bash
  docker build -t tweteroo/spring:1.0 .
```

Execute o container

```bash
  docker run -p 8080:8080 tweteroo/spring:1.0
```

Caso queira parar o container basta utilizar o comando `Ctrl + C`

</br>

## Acknowledgements

- [Awesome Badges](https://github.com/Envoy-VC/awesome-badges)

</br>
