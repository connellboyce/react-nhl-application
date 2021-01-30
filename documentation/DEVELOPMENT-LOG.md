# Development Log

### Create a Persistence Layer for NHL Model
- Created JPA Model for Team
- Create a repository for a Team using Spring Data
- Configured REST base path in application.properties

```shell
spring.data.rest.base-path=/api/v1
```

- Verified Spring Data Rest Endpoint is available at: http://localhost:9090/api/v1

Initial Response from API endpoint:
```json
{
  "_links" : {
    "teams" : {
      "href" : "http://localhost:9090/api/v1/teams{?page,size,sort}",
      "templated" : true
    },
    "profile" : {
      "href" : "http://localhost:9090/api/v1/profile"
    }
  }
}
```