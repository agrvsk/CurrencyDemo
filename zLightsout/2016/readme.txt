Using lights-out processing with JBoss.
(revised 14/Apr/05)

(Some of these are temporary until this is properly integrated into the install.)

1. Copy the files from ...eclipse\plugins\com.versata.tl.studio.lightsout_6.3.0.0\xml 
	to C:\Versata\BRE-6.3\<appserver>\Vls\bin.

2. Setup a project in your workspace.
	You need to at least:
		(you can turn off auto-build to save time)
		- create the project,
		- import or build your data model,
		- do a database deployment saving a config file,
			this also generates the dbdeploy.properties & dbdeploy.xml files needed,
		- generate the deployApps.properties file,
			(You can do this by starting the Build -> Applications;
			 select the repository XML file;
			 click Finish;
			 wait for activity in the Console view;
			 click the Terminate (red square) icon;
			 kill the Versata Studio application in the Windows Task Manager.)

3. Edit the lightsout.properties file that you copied to C:\Versata\BRE-6.3\<appserver>\Vls\bin.
	Entries are:
		eclipse.home=<full path>; example: C:/Versata/BRE-6.3/workbench
		workspace.dir=<full path>; example: C:/Versata/BRE-6.3/workbench/workspace
		project=<name>; example: trade6
		check.url=<url for checking for running appserver>; 
			Defaults for standard Versata installations are:
			JBoss: http://localhost:8080/status
			WebLogic: http://<hostname>:2006/console
			WebSphere: http://<hostname>:2004/admin
			WebSphere 6.0: http://localhost:<WC_adminhost port>/ibm/console
			If deploying to other instances of these appservers you may need
			to change the port value.
		db.deploy.config=<full-config-properties-file-name>;
			This is the full name of the config file you define in database deployment,
			format: <config-name>.deployConfig.properties
			(can copy from <workspace>\<project>\conf)
		deploy.mode=<one of ear, exploded, hotDeploy>
			This is an optional property. If it is used it will update the mode property
			in build.properties in earModule/META-INF. This value controls the type of 
			deployment: ear - full EAR deployment, exploded - deploy exploded ear,
			hotDeploy - incremental deploy.
		config.includeInEar=<true|false>
			This is an option property. If you are using XML persistence for admin data,
			setting this property will bundle that data into AdminData.jar and include it
			in the deployed ear. If you omit this property, the data will not be bundled.
			If you are using DAT file persistence, this option has no effect (DAT files
			are never included in the ear). If you set this property and no data files
			exist, lightsout will fail with an appropriate error message.
	FOR WEBSPHERE ONLY:	
		java.bin=<was-home>/java/bin
			WebSphere JDK needed for deploy to WAS but cannot be used for Versata builders.
	FOR WEBLOGIC ONLY
		jdbc.path=C\\\:\\\\bea\\\\weblogic81\\\\server\\\\lib\\\\<jdbc_driver.jar>
			WEbLogic needs to have JDBC driver jar added to the server classpath.
			
4. Open a command prompt at C:\Versata\BRE-6.0\<appserver>\Vls\bin.

5. Enter the command:
	ant -f lightsout.xml

	This will:
	 - start the appserver in a separate window (if not already running);
	 - deploy database tables;
	 - deploy process information;
	 - generate service objects;
	 - generate EJB files;
	 - build HTML & Java apps (only if there is a deployApps.properties file in the project);
	 - (above steps are done without automatic compile)
	 - clean and build the project (java and business logic builders);
	 - build and deploy the ear.

6. When lights-out processing has completed, start the Versata Logic Console
	and set up your dataserver.

7. Test run apps.

8. Note: lightsout turns off autobuild in the accessed workspace. If you open this workspace
	later in workbench and want autobuild you will have to set it back on.
	
The script, lightsout.xml, is modular and has the following main targets (which can be run independently):

	all				(default) Runs the complete lighths out process.
	start-appserver	checks to see if appserver is running;
			if not running, starts appserver in a separate command window;
	gen-props		updates properties files;
	deploy-db		deploys database tables;
	deploy-process	deploys process information;
	prep-ear		runs targets: gen-services, gen-ejb;
	gen-services	generate service objects;
	gen-ejb			generate EJB files;
	build-apps		builds HTML apps if there is a deployApps.properties file;
	prep-deploy		rebuild Lomboz deploy scripts and build properties.
	rebuild-project	clean and rebuild;
	deploy-ear		checks to see if appserver is available, waits if not;
			if does not timeout waiting for appserver, builds and deploys ear.
	stop-appserver	checks to see if appserver is running;
			if running, stops appserver.
	
Note that the db.deploy.config maps data models to data sources. The data source property files
referenced must be available in <workspace>\.metadata\.plugins\com.versata.tl.studio.dbdeploy. 
Other db deploy properties normally entered through the wizard are taken from the existing 
dbdeploy.properties file in the project.

You need the contributed ant task "foreach". This is in tools\ant-contrib\1.0b1\lib\ant-contrib.jar.
This jar should be copied to your ant lib directory.

If you run out of memory you can increase it by setting the ANT_OPTS environment variable:
	e.g. set ANT_OPTS=-Xmx640m

The deployment of java applications use an opensource project ant-jnlp-war, so ensure that all jars in 
\plugins\com.versata.tl.studio.deploy\lib (ant-jnlp-war.jar, velocity-1.4.jar, logkit-1.0.1.jar, 
xpp3_min-1.1.3.4.O.jar, xstream-1.4.4.jar, xmlpull-1.1.3.1.jar...) The easiest workaround is to copy them to your ANT_HOME/lib

