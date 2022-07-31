# movie-info-service
This micro service give details of various items form  starwars movie.It implements a API using REST to manage data from  [swapi](https://swapi.co/).

## Desired Features:


- Search by combination of type and name;
-  offline toggle mode
- displays details for related fields, e.g the films related to the people name which requires another api call
- display the count, type and name
- Api documentation
- CI CD using docker and jenkins



## Reuirements:

This is java maven spring boot project, you need maven and java 11 installed  machine in order to run.
Install DOcker and jenkins for containerizing and creating pipelins.
 For offline mode or in case the api is down the app can response the required data.


## Usage:

### Getting Refquired Details:
Do a GET at /planets?search=name  for offline mode a optional boolean param is provided.
this:   http://localhost:8082/movieInfo/planets?name=C-3PO
Sample Response is:
{
    "type": "planets",
    "count": 1,
    "name": "C-3PO",
    "films": [
        {
            "title": "The Empire Strikes Back",
            "director": "George Lucas"
        }
    ]
}

Do a GET at /planets?search=name  for OFFLINE mode a optional boolean param is provided.
this:   http://localhost:8082/movieInfo/planets?name=C-3PO&offlineMode=true
Sample Response is:
{
    "type": "planets",
    "count": 1,
    "name": "C-3PO",
    "films": [
        {
            "title": "The Empire Strikes Back",
            "director": "George Lucas"
        }
    ]
}
