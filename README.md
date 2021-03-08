# WebCrawler
A simple web crawler written in Java

This project leverages the jsoup library: https://jsoup.org/

jsoup is a Java library for working with real-world HTML. It provides a very convenient API for fetching URLs and extracting and manipulating data.

The program is limited to one domain so it won't follow links outside the domain.

The program uses recursion by calling the work method "crawl" to traverse
the various pages called. It also caps the number of 
different pages capped at 25 in order for the program to stop and for ease of testing.

The program also uses a fake USER_AGENT so the web server thinks the robot is a normal web browser.

If I had more time, I could have incorporated Cucumber for BDD.
I have started using Cucumber for another project, and it allows
the execution of feature documentation written in business like language.

In order to run the project, After cloning the project, please change to the root of the project and
due the following:
1) change to the master branch: git checkout master
2) create the executable jar: mvn package
3) Then run the jar, in this example the jar is located in: C:\dev\test\WebCrawler\target

java -jar C:\dev\test\WebCrawler\target\WebCrawler-1.0.jar
4) to run tests: mvn test
