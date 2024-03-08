# spring-jwt-filterchain
A simple project to kickstart your spring boot, jwt and filter chain journey

Note: 
In testing run the application by using any idea of your choice (example VSCode).

In generating a JWT (token) you must use this endpoint and payload

POST localhost:8080/login
{
  "username": "admin"
}

admin is a sample valid user to generate a token

Sample Response:
eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTcxMDc2Njc1M30.z5af1TGBBc8HA9QRDnryuPj9dIrNuNMUQV8sU3O9PlDLkDvm8FYX0ydMZn5uO1Vu1SHKcKSeMXi6hnMDQS9PkQ

You can use the token as a Authorization header in resource server endpoints

GET localhost:8080/service
Header -> Authorization : Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTcxMDc2Njc1M30.z5af1TGBBc8HA9QRDnryuPj9dIrNuNMUQV8sU3O9PlDLkDvm8FYX0ydMZn5uO1Vu1SHKcKSeMXi6hnMDQS9PkQ

Sample Response: Successfully accessing jwt resource

Note:
Refresh tokens are not included in this implementation

