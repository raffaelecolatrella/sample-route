sample-route
===================
La webapp è composta funzionalmente dalle seguenti pagine:

1. La pagina per la visualizzazione delle Country e delle relative Currencies Name:
	> http://localhost:8080/sample-routing-1.0-SNAPSHOT 

2. La pagina di login:
	> http://localhost:8080/sample-routing-1.0-SNAPSHOT/login

3. La pagina di logout
	> http://localhost:8080/sample-routing-1.0-SNAPSHOT/logout

4. ReST API
	> http://localhost:8080/sample-routing-1.0-SNAPSHOT/api 


L'applicazione è stata sviluppata seguendo il modelo MVC quindi sfruttando interamente spring con l'uso dei moduli:
	-Spring Web, 
	-Spring Security, 
	-altri framework/librerie accessorie.

PS: le credenziali per l'accesso sono admin/admin123
	
Build
-------------
Per generare il war è sufficiente lanciare il comando:
> mvn clean install


Ambiente di sviluppo
--------------------

Eclipse Java EE IDE for Web Developers. - Version: Oxygen.1a Release (4.7.1a)

Testato su Apache Tomcat 9.0.2.

