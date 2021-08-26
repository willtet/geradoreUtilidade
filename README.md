# Geradores para testes

## Request & Response Examples

### API Resources

  - [GET /{version}/cpf/gerar]
  - [GET /{version}/cpf/verificar/[CPF]]
  - [GET /{version}/pessoa/gerar]

### GET /{version}/cpf/gerar

Example: https://gerador-utilidade.herokuapp.com/v1/cpf/gerar

Response body:

    {
        563.762.211-65
    }

### GET /magazines/[id]

Example: https://gerador-utilidade.herokuapp.com/v1/cpf/verificar/56376221165

Response body:

    {
        true
    }



### POST /magazines/[id]/articles

Example: https://gerador-utilidade.herokuapp.com/v1/pessoa/gerar

Request body:

    {
    "nome": "Enzo",
    "sobrenome": "Battaglia",
    "idade": "25",
    "cpf": "606.625.871-03",
    "nascimento": "1996-04-04",
    "sexo": "masculino",
    "estadoCivil": "solteiro",
    "nomeMae": "Allana Vitali Battaglia",
    "email": "60662587103@emailteste.com",
    "senha": "--Senha--",
    "ddd": "11",
    "telefone": ",
    "endereco": {
        "cep": "--CEP--",
        "endereco": "--Endereço--",
        "bairro": "--Bairro--",
        "cidade": "--Cidade--",
        "estado": "--Estado--"
    }
}
