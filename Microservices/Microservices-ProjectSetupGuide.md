Using Assignment 7 as a basis (which is the same setup as the WorkOrder Pro Assignment 1) follow below steps to change project details.

1. Change project name using terminal / File explorer.
2. Update `.vscode/launch.json` file for following changes.
  1. Update context path name
  2. Add database configuration with required changes (URL, username & password).
  ```
  "DATABASE_URL": "jdbc:mariadb://host.docker.internal:3306/work_order_pro",
  "DATABASE_USERNAME": "user",
  "DATABASE_PASSWORD": "password",
  "DATABASE_DRIVER": "org.mariadb.jdbc.Driver"
  ```
3. Import / open application in VSCode and make following changes.
	1. Update package name based on group project name.
	2. Update SpringBoot `main` class name based on group project name.
	3. Update following properties in `launch.json` file [name, mainClass, projectName]
	4. Remove exclude tag from main class to enable database configuration for the application [If database running]
