# This is an example API to using [Spring Data JPA](https://pages.github.com/).
## cURL

###### - Get data
```shell
curl --silent --location --request GET 'http://localhost:8080/v1/programming-language?keyword=&sort=language&direction=asc'
```
###### - Insert data
```shell
curl --silent --location --request POST 'http://localhost:8080/v1/programming-language' \
--header 'Content-Type: application/json' \
--data-raw '[
    {
        "language": "Java",
        "keyword": "JAVA"
    },
    {
        "language": "Golang",
        "keyword": "GOLANG"
    },
    {
        "language": "NodeJS",
        "keyword": "NODEJS"
    },
    {
        "language": "Rust",
        "keyword": "RUST"
    }
]'
```
###### - Delete by id
```shell
curl --silent --location --request DELETE 'http://localhost:8080/v1/programming-language/1'
```
###### - Delete (Truncate)
```shell
curl --silent --location --request DELETE 'http://localhost:8080/v1/programming-language'
```