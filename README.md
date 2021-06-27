# MicroServices

Use Intellij Idea for simplicity  
use spring initializr - https://start.spring.io/ to create spring boot projects  
  
Step 1 - run cloud-config-server & java for zipkin-server.jar (cmd : java -jar zepkin-serv...).  
Step 2 - run service-registry.  
Step 3 - run cloud-gateway.  
Step 4 - run hystrix-dashboard.  
Step 5 - run department-Service.  
Step 6 - run user-service.  


# Demo Data from Postman: 
**Note:- All the Endpoint are from the Cloud-Gateway hence the port 9191 for everything, or else same can be used for 
'post' and 'get' with the specific port of department-service and user-service. But all the dependencies are connected
to the cloud-gateway , And hystrix dashboard is also connecte to the cloud-gateway so hence recommended to use the following EndPoint.


EndPoint :- http://localhost:9191/departments/
          {
            "departmentName":"IT",
            "departmentAddress":"3rd Cross, First Street",
            "departmentCode":"IT-007"
          }
          
EndPoint :- http://localhost:9191/departments/get?id=1

EndPoint :- localhost:9191/users/
            {
              "firstName":"Aakash",
              "lastName":"Niwane",
              "emailId":"xyz@gmail.com",
              "departmentId": "1"
            }

EndPoint :- localhost:9191/users/user?id=1
