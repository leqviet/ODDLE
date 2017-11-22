Prepare for running project:
	1/ Create database name "oddle".
	2/ Run sql query in file sql/database.sql on database "oddle".


* Run project on Elipse.
	1/ Load project "WeatherAppBoilerPlate" on Eclipse with Maven plugin.	
	2/ Find class "WeatherAppBoilerPlateApplication" and run it.
Maybe you need run maven command "mvn clean install" before do step 2.
Open a browser to http://localhost:<port number>/list

* Run project with maven command
Go to location "/WeatherAppBoilerPlate" to run command:
	1/ Do maven "mvn clean install".
	2/ Do maven " mvn spring-boot:run"
	
Open a browser to http://localhost:<port number>/list

**** Deploy on Tomcat
	1/ Do maven "mvn clean install".
	2/ Deploy on Tomcat
Open a browser to http://localhost:<port number>/WeatherAppBoilerPlate/list