# fotile-grpc-all
one springboot grpc example

# guide

## package or install the client
  you need first  
```
  bash: cd fotile-grp-client/ &&  mvn clean install
```
so that you can use the grpc-client in local, even you has no remote maven repo

## run your application
  just run fotile-grpc-server and fotile-grpc-invoker
  Please note that you need to check the application.yml to ensure that the ports used do not conflict with other currently running applications. 
  Here, the following ports are used: server: 9091, 9092, invoker: 9100.

  
