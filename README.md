# time-logger-back-end
REST Spring Boot

REST APIs for Logs

##GET
###http://localhost:5000/rest/logs
###Gives all logs of current user

##GET
###http://localhost:5000/rest/logs/101
###Gives log associated with id 101 if current user have it.

##POST
###http://localhost:5000/rest/logs
###adds new log if valid

##PUT
###http://localhost:5000/rest/logs/101
###Updates log associated with id 101 if current user have it.

##DELETE
###http://localhost:5000/rest/logs/101
###Deletes log associated with id 101 if current user have it.
