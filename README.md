mvn clean package

mvn clean package -P war

部署到jetty中的时候，将war包重命名成root.war，就可以127.0.0.1:8080/的方式访问，而不用加应用名
