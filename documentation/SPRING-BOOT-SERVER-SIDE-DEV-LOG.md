# Server-Side Development Log

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

### Preload Team Data
Now that there is a persistence mechanism, we will need to populate the data. One way to do this is to acquire that NHL team data from the internet. Fortunately, I found an API where I call pull this data from.
Also, I found a CDN that holds logo images for each team, I will take advantage of that as well.
- External API for NHL data: https://statsapi.web.nhl.com/api/v1/teams
- Used ConfigurationProperties to pull this URL from application.properties
- Created TeamDateLoader class to preload the data from the external API and save to local repository
  - Utilized RestTemplate for consuming the external API
  - Implemented CommandLineRunner
- Preloading functionality is contained in the following package:
```java
package com.connellboyce.reactnhl.dataloader;
```
- TeamDataLoader normalizes extracted team data to generate logo URLs from  http://loodibee.com
- The teams are the saved to the previously created repository

### Accessing Data
- Once the above is completed, data can be extracted from the API at the following URL:
```http request
http://localhost:9090/api/v1/teams
```
- Our Spring Data API will now provide a hypermedia response:
```json
{
  "_embedded" : {
    "teams" : [ {
      "name" : "New Jersey Devils",
      "abbreviation" : "NJD",
      "logoURL" : "http://loodibee.com/wp-content/uploads/nhl-new-jersey-devils-logo.png",
      "locationName" : "New Jersey",
      "_links" : {
        "self" : {
          "href" : "http://localhost:9090/api/v1/teams/1"
        },
        "team" : {
          "href" : "http://localhost:9090/api/v1/teams/1"
        }
      }
    }, {
      "name" : "New York Islanders",
      "abbreviation" : "NYI",
      "logoURL" : "http://loodibee.com/wp-content/uploads/nhl-new-york-islanders-logo.png",
      "locationName" : "New York",
      "_links" : {
        "self" : {
          "href" : "http://localhost:9090/api/v1/teams/2"
        },
        "team" : {
          "href" : "http://localhost:9090/api/v1/teams/2"
        }
      }

      ...
```