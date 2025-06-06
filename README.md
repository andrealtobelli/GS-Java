# AquaRescue - API REST Spring Boot

AquaRescue é uma solução inovadora desenvolvida para mitigar os impactos dos eventos climáticos extremos nas comunidades mais vulneráveis, por meio do monitoramento, previsão e gestão eficiente de dados hidrometeorológicos. Essa aplicação conta com uma API RESTful desenvolvida em Java com Spring Boot, integrando persistência em banco Oracle, autenticação com JWT e documentação via Swagger.

---

## 👥 Desenvolvedores

- Leticia Cristina Dos Santos Passos RM: 555241
- André Rogério Vieira Pavanela Altobelli Antunes RM: 554764
- Enrico Figueiredo Del Guerra RM: 558604

---

## 🌟 Tecnologias Utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- Spring Security + JWT
- Oracle Database
- Swagger/OpenAPI
- Maven
- Deploy em nuvem (ex: Azure ou Render)

---

## ✉️ Objetivo do Projeto

O objetivo do AquaRescue é fornecer uma interface centralizada para coleta, cálculo e previsão de dados meteorológicos, permitindo que ONGs e comunidades acompanhem condições climáticas e tomem decisões com base em dados.

---

## 🔧 Como Rodar o Projeto Localmente

### 1. Requisitos

- Java 17+
- Maven
- Oracle Database (com as tabelas do projeto já criadas)

---

### 5. Acesse o Swagger
* http://localhost:8080/swagger-ui.html

---
# 🔐 Autenticação
### 1. Cadastro de usuário
*POST /usuarios
```
{
  "nome": "leticia",
  "email": "lele@gmail.com",
  "senha": "123456",
  "tipo": "ONG"
}

```
### 2. Login
* POST /login
```
{
  "email": "lele@gmail.com",
  "senha": "123456"
}
```

## 👤 Perfis de Acesso
* COMUM: acesso limitado à visualização de dados e dashboards
* COMUNIDADE: pode registrar dados e acompanhar indicadores
* ONG: perfil com acesso total (criação de comunidades, previsões, cálculos, etc)

## 📚 Estrutura da API
### Controllers
* AuthController.java: login de usuários e geração do token
* UsuarioController.java: cadastro e listagem de usuários
* ComunidadeController.java: cadastro e listagem de comunidades
* DadosMeteorologicosController.java: criação e consulta de dados climáticos
* LogCalculoController.java: registros de cálculo de consumo de água
* PrevisaoController.java: previsões meteorológicas por comunidade

## DTOs
* UsuarioDTO, LoginDTO, ComunidadeDTO, DadosMeteorologicosDTO, LogCalculoDTO, PrevisaoDTO

## Entidades
* Usuario.java, Comunidade.java, DadosMeteorologicos.java, LogCalculo.java, Previsao.java

## Repositórios (Spring Data JPA)
* UsuarioRepository.java
* ComunidadeRepository.java
* DadosMeteorologicosRepository.java
* LogCalculoRepository.java
* PrevisaoRepository.java

## Tratamento Global de Erros
* GlobalExceptionHandler.java: centraliza exceções de validação, recursos não encontrados, e erros de negócio

---

# 📘 Exemplos de Payloads
* Cadastro Comunidade
```
{
  "nome": "A COMUNIDADE",
  "latitude": 0.14000,
  "longitude": 0.1234234,
  "qtHabitantes": 2000
}
```

* Dados Meteorológicos
```
{
  "comunidadeId": 1,
  "dataHora": "2025-06-02T16:40:55.129Z",
  "temperatura": 0.1,
  "umidade": 0.1,
  "ptoOrvalho": 0.1,
  "pressao": 0.1,
  "ventoVeloc": 0.1,
  "ventoDirecao": 0.1,
  "ventoRajada": 0.1,
  "radiacao": 0.1,
  "chuva": 0.1
}
```

* Log de Cálculo
```
{
  "comunidadeId": 1,
  "qtHabitantes": 1073741824,
  "consumoPorPessoa": 0.1,
  "totalVolume": 0.1,
  "dataCalculo": "2025-06-02T16:41:28.620Z"
}
```

* Previsão
```
{
  "comunidadeId": 1,
  "temperatura": 25.0,
  "umidade": 80.0,
  "volumePrevisto": 100.0,
  "dataPrevisao": "2025-06-02T04:26:46"
}
```

# 📑 Documentação da API
* A API está documentada via Swagger e pode ser acessada em:

* http://localhost:8080/swagger-ui.html

# 🎥 Demonstrações
* Demonstração completa: [link para vídeo de até 10 minutos]

# Pitch: [link para vídeo de até 3 minutos]

# 📌 Critérios Atendidos
* API REST com boas práticas
* Banco relacional com Spring Data JPA
* Mapeamento entre entidades (relacionamentos)
* Validação com Bean Validation
* Paginação, ordenação e filtros (em construção)
* Swagger funcionando
* Autenticação com JWT implementada
* Deploy configurado
* Tratamento global de exceções

# 📅 Desenvolvido por
* Equipe AquaRescue - FIAP | Java Advanced 2025





