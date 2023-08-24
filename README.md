# CodeVibe
## Car Adverts REST API

Technologies:
- Java
- Spring Boot framework
- Any Database as storage of your choice

Task:
- A RESTful web-service to create, view, modify and delete car adverts. 
## API Reference

#### View all car adverts.
Returns json data for all car adverts.

sortby=[field_name]
 
If sortby query param is not specified, results will be sorted by car advert id. [field_name] is case insensitive.


```http
  GET /car/adverts
  GET /car/adverts?sortby=[field_name]
```

Examples

```java
{
    "id": 88,
    "title": "Title for advert 88",
    "fuelType": "diesel",
    "price": 20000,
    "isNew": false,
    "mileage": 1453,
    "firstRegistration": "2014-05-05"
}

{
    "id": 199,
    "title": "car advert 199",
    "fuelType": "gasoline",
    "price": 19000,
    "isNew": true
}
```

#### View a single car advert

```http
  GET /car/adverts/:id
```
Examples

```java
Code: 200
 
    Content:
 
            {
                "id": 88,
                "title": "Title for advert 88",
                "fuelType": "diesel",
                "price": 20000,
                "isNew": false,
                "mileage": 1453,
                "firstRegistration": "2014-05-05"
             }

Error Response:
 
    Code: 404 (Not found)
 
    Explanation: No car advert with given id was found.

Sample Calls GET /car/adverts/1
```
#### Create a car advert

```http
  POST /car/adverts
```
Examples

```java
{
                "id": 88,
                "title": "Title for advert 88",
                "fuelType": "diesel",
                "price": 20000,
                "isNew": false,
                "mileage": 1453,
                "firstRegistration": "2014-05-05"
             }
 
Success Response:
 
    Code: 201 (Created)
 
    Content:
 
    {
      "id": 88,
      "title": "Title for advert 88",
      "fuelType": "diesel",
      "price": 20000,
      "isNew": false,
      "mileage": 1453,
      "firstRegistration": "2014-05-05"
    }
 
Error Response
 
    Code: 400 (Bad request)
 
    Explanation: This is returned if json is invalid or cannot be parsed.
 
    Code: 422 (Unprocessable entity)
 
    Explanation: Validation failed.
 
    Content:
 
{
    "validation_errors": [
     "Id must be a positive number",
     "Price cannot be negative"
    ]
}
```

#### Modify a car advert

```http
  PUT /car/adverts/:id
```
Examples

```java
{
         "id": 88,
         "title": "Title for advert 88",
         "fuelType": "diesel",
         "price": 9999,
         "isNew": false,
         "mileage": 1453,
         "firstRegistration": "2014-05-05"
      }
 
Success Response:
 
    Code: 200 (Ok)
 
    Content:
 
      {
          "id": 88,
          "title": "Title for advert 88",
          "fuelType": "diesel",
          "price": 9999,
          "isNew": false,
          "mileage": 1453,
          "firstRegistration": "2014-05-05"
       }
 
Error Response
 
    Code: 404 (Not found)
 
    Explanation: This is returned if a car advert with given id is not found.
 
    Code: 400 (Bad request)
 
    Explanation: This is returned if json is invalid or cannot be parsed.
 
    Code: 422 (Unprocessable entity)
 
    Explanation: Validation failed.
 
    Content:
 
{
    "validation_errors": [
     "Id must be a positive number",
     "Price cannot be negative"
    ]
}
```

#### Delete a car advert

```http
  DELETE /car/adverts/:id
```
Examples

```java
Success Response:
 
    Code: 204 (No content)
 
    Content: None
 
Error Response
 
    Code: 404 (Not found)
 
    Explanation: This is returned if a car advert with given id is not found.

```
