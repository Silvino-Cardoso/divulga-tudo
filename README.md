# Projeto realizado conforme desafio fornecido para processo seletivo  


## 🚀 O problema

A agência Divulga Tudo precisa de um programa para gerenciar os seus anúncios online. O objetivo dos anúncios faz parte de uma campanha nas redes sociais. O sistema de gerenciamento permitirá a gestão do anúncio e o rastreio dos resultados da campanha.

Considere os seguintes critérios fictícios para desenvolver o cadastro de anúncios:

- a cada 100 pessoas que visualizam o anúncio 12 clicam nele.
- a cada 20 pessoas que clicam no anúncio 3 compartilham nas redes sociais.
- cada compartilhamento nas redes sociais gera 40 novas visualizações.
- 30 pessoas visualizam o anúncio original (não compartilhado) a cada R$ 1,00 investido.
- o mesmo anúncio é compartilhado no máximo 4 vezes em sequência

Crie um sistema que permita o cadastro de anúncios. O anúncio deverá conter os seguintes dados:

- nome do anúncio
- cliente
- data de início
- data de término
- investimento por dia


O sistema fornecerá os relatórios de cada anúncio contendo:

- valor total investido
- quantidade máxima de visualizações
- quantidade máxima de cliques
- quantidade máxima de compartilhamentos

Os relatórios poderão ser filtrados por intervalo de tempo e cliente.

### 📋 Pré-requisitos

```
Java 11 
Ide de sua preferência
Navegador
```

### 🔧 Execução

Para acessar a aplicação :

```
Faça o download ( clone )desse repositório
```
```
Abra o projeto com a Ide de preferência ( Intelijj, NetBeans ...)
```
```
Rode a aplicação ( Run application - Classe main AdsApplication.java)
```
```
Após iniciar a aplicação estará disponível no endereço http://localhost:8080/
```
```
O formulário de cadastro de anúncios poderá ser acessado através do botão "Novo anuncio" ou através da URL http://localhost:8080/newad
Todos os campos de cadastro são obrigatórios
```
```
A tabela de anúncios cadastrados, bem como o relatório da quantidade de visualizações e valor investido está disponível no endereço http://localhost:8080/
A pesquisa pode ser realizada por nome do cliente, nome do anúncio, data inicial ou data final
```
```
Para visualizar o banco de dados acessar http://localhost:8080/h2-console ( usuario "sa", senha "" jdbc:h2:mem:testdb )
```


## 🛠️ Aplicação construída com 

* [Java 11](https://www.oracle.com/br/java/technologies/javase-jdk11-downloads.html)
* [Maven](https://maven.apache.org/) 
* [Spring Boot](https://spring.io/projects/spring-boot)
* [Intelijj](https://www.jetbrains.com/pt-br/idea/) 
* [Spring Data JPA](https://spring.io/projects/spring-data-jpa) 
* [H2 Database](https://www.h2database.com/html/main.html)
* [Thymeleaf](https://www.thymeleaf.org/)



## ✒️ Desenvolvido por

* **Silvino Cardoso** - [Silvino Cardoso](https://gist.github.com/Silvino-Cardoso)
