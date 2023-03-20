# JAVA TECHNICAL TEST SOLUTION

## START THE APPLICATION

To start the application, you must provide the following environment variables to setup the postgres DB connection:

- POSTGRES_URL (default: `r2dbc:postgresql://localhost:5432/postgres`)
- POSTGRES_USERNAME (default: `postgres`)
- POSTGRES_PASSWORD (default: `password`)

## URLS

The application is running on port 8080 by default, so the Planets and People endpoints are:

- GET: `http://localhost:8080/api/planets?page={pageNumber}` (where pageNumber is an integer)
- GET: `http://localhost:8080/api/planets/{planetId}` (where planetId is and integer)
- GET: `http://localhost:8080/api/people?page={pageNumber}` (where pageNumber is an integer)
- GET: `http://localhost:8080/api/people/{peopleId}` (where peopleId is and integer)

## Description

The application is developed using reactive programming, using webflux, spring data r2dbc for reactive db transactions, and postgres for the db instance.

The GET planets and people by page endpoints send a request to the swapi endpoint to get information. If the page is bigger than 1 then the application will send multiple requests in parallel and receive a flux of pages with information that will be mapped to a list of elements after we get all the required pages.

The GET planets and people by ID will query the DB for existing information first, if this isn't found then it will trigger a request to the swapi endpoint to get the information required, save it to the DB and then return the response.

Finally the responses are mapped to a response entity with  payload and status.