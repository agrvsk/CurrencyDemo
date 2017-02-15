SET CLIENT_HOME=.

SET VERSATA_JARS=lib/vs-tle-client.jar;lib/tl-common.jar;lib/vs-tle-beans-client.jar
SET JBOSS_JARS=lib/jboss-j2ee.jar;lib/jbossall-client.jar
SET WLS_JARS=lib/wlclient.jar
SET APP_JAR=lib/CurrencyDemo.jar
SET CLIENT_JAR=jar/JavaApp.jar
SET LOGGING_JAR=lib/log4j-1.2.8.jar;lib/javaassist.jar

java -cp %VERSATA_JARS%;%APP_JAR%;%CLIENT_JAR%;%LOGGING_JAR%;%WLS_JARS% CurrencyDemo.JavaApp.JavaApp
