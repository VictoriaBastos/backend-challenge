
# Password Validation Api

## Descrição

>>API web em Java e Springboot que realiza a validação de senhas. 
><br><br>
>A API apresenta um método HTTP POST que recebe as solicitações do cliente e retorna a verificação de validação da senha, sendo essa um boolean true ou false.
><br><br>
>A construção da API apresenta uma interpretação da arquitetura hexagonal, tendo sido dividida em 3 principais camadas: core, port e adaptor.
><br><br>
> As regras de validação de senha foram tratadas como regras de negócio presentes na camada de serviço, no core da aplicação.
><br><br>
>Foram realizados testes de unidade utilizando o framework JUnit e testes no controller da aplicação utilizando o Spring MockMVC.

## Critérios de Validação da Senha:

Considere uma senha sendo válida quando a mesma possuir as seguintes definições:

- Nove ou mais caracteres
- Ao menos 1 dígito
- Ao menos 1 letra minúscula
- Ao menos 1 letra maiúscula
- Ao menos 1 caractere especial
  - Considere como especial os seguintes caracteres: !@#$%^&*()-+
- Não possuir caracteres repetidos dentro do conjunto

Exemplo:  

```c#
IsValid("") // false  
IsValid("aa") // false  
IsValid("ab") // false  
IsValid("AAAbbbCc") // false  
IsValid("AbTp9!foo") // false  
IsValid("AbTp9!foA") // false
IsValid("AbTp9 fok") // false
IsValid("AbTp9!fok") // true
```

> **_Nota:_**  Espaços em branco não devem ser considerados como caracteres válidos.</br>
> _____Letras foram consideradas caracteres diferentes em suas formas maiúscula e minúscula. Ex: A != a



## Estrutura da Aplicação

Vizualização da aplicação organizada em 3 principais camadas: core, port e adaptor.

<img src="./assets/archHex.png">

## Tecnologias Utilizadas
Para executar e fazer alterações no projeto, será necessário instalar:

- JDK
- Maven
- IntelliJ/Eclipse

## Instruções para execução do projeto
- No terminal, faça o clone da aplicação:

``git clone https://github.com/VictoriaBastos/backend-challenge.git``

- Navegue até a pasta raiz do projeto 

``cd PasswordValidation/``

- Para executar a API via linha de comando, execute os seguinte comando Maven:

`` mvn clean install``

``mvn spring-boot:run``



- Você também pode rodar a API utilizando a IDE de sua preferência e executando a classe *Application. 


- Utilize o Postman ou Insominia para chamar os endpoints da API localmente.
  - Local: http://localhost:8080

## Rotas

| Método HTTP | Tipo Rota | Endpoint                               | Descrição                         |
|-------------| --------- |----------------------------------------|-----------------------------------|
| POST        | Pública   | `http://localhost:8080/usuario/senha` | Recebe senha e retorna validação. |     

### Input
A aplicação espera receber uma requisição POST com um json no seguinte formato:

    { 
        "password":"Andy1978#" 
    }

### Output
A aplicação deverá retornar um json contendo um valor booleano:

    {
        "senha validada:": true
    }
<br>
    
    {
        "senha validada:": false
    }

Se a senha for nula a aplicação retorna uma exceção:

    {
        "status": "BAD_REQUEST",
        "message": "Validation failed for argument [0] in public org.springframework.http.ResponseEntity<com.challenge.api.PasswordValidation.adaptor.dto.PasswordDTO> com.challenge.api.PasswordValidation.adaptor.PasswordValidationController.validateUserPassword(com.challenge.api.PasswordValidation.adaptor.dto.PasswordForm): [Field error in object 'passwordForm' on field 'password': rejected value [null]; codes [NotNull.passwordForm.password,NotNull.password,NotNull.java.lang.String,NotNull]; arguments [org.springframework.context.support.DefaultMessageSourceResolvable: codes [passwordForm.password,password]; arguments []; default message [password]]; default message [Password is Null]] ",
        "errors": [
            "password: Password is Null"
        ]
    }




