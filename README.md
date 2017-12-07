# STP-Lab-5
[![Build Status](https://travis-ci.org/igorpodosonov/STP-Lab-5.svg?branch=master)](https://travis-ci.org/igorpodosonov/STP-Lab-5)
[![codecov](https://codecov.io/gh/igorpodosonov/STP-Lab-5/branch/master/graph/badge.svg)](https://codecov.io/gh/igorpodosonov/STP-Lab-5)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/7af18625827d4d5085fd453302bed85d)](https://www.codacy.com/app/igorpodosonov/STP-Lab-5?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=igorpodosonov/STP-Lab-5&amp;utm_campaign=Badge_Grade)
[![Codacy Badge](https://api.codacy.com/project/badge/Coverage/7af18625827d4d5085fd453302bed85d)](https://www.codacy.com/app/igorpodosonov/STP-Lab-5?utm_source=github.com&utm_medium=referral&utm_content=igorpodosonov/STP-Lab-5&utm_campaign=Badge_Coverage)
###This repo contatins examples of serealization/deserealization java classes from JSON with different instruments
1. GSON
2. Org.JSON
3. Jackson
###JSON object example:
```
    {
      "movie_name" : "A Clockwork Orange",
      "year" : 1971,
      "director_info" : {
        "name" : "Stanley Kubrick",
        "birth_place" : "New York City",
        "birth_year" : 1928
      },
      "actor_role" : {
        "Michael Bates" : "Chief Guard Barnes",
        "Patrick Magee" : "Mr. Frank Alexander",
        "Warren Clarke" : "Dim",
        "Malcolm McDowell" : "Alex DeLarge"
      }
    }
```
###Result of performance:
```
    ====================================
    Gson Serialize/Deserialize 
     run time: 293 milliseconds, 
     memory usage: 4.625328 megabytes
    ====================================
    ====================================
    Org.Json Serialize/Deserialize 
     run time: 16 milliseconds, 
     memory usage: 0.0 megabytes
    ====================================
    ====================================
    Jackson Serialize/Deserialize 
     run time: 582 milliseconds, 
     memory usage: 12.889152 megabytes
    ====================================
```
