# camel-karaf-noblueprint
Simple Camel Karaf example
Tested on Karaf 4.1.1 on Java 8.

To install prerequisites:

feature:repo-add camel 2.21.0
feature:install camel-scr

After building with mvn install add to karaf with:
bundle:install mvn:examples.mycompany.com/camel-karaf-noblueprint/0.0.1-SNAPSHOT

Then run
log:tail

to see log output from the camel route

