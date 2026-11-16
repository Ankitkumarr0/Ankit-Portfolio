# Ankit Kumar – Personal Portfolio

A responsive individual portfolio project using HTML5, CSS3, JavaScript, Java Servlet/JSP, JDBC, MySQL and Apache Tomcat 10.1.

## Personal details included
- Name: Ankit Kumar
- Role: Java Full Stack Developer
- Education: B.Tech, CSE, 3rd Year
- College: Greater Noida College
- Location: Greater Noida, India
- Email: ankit519045@gmail.com
- GitHub: https://github.com/Ankitkumarr0

Review every detail before submission and add your own genuine project work and screenshots.

## Requirements
- JDK 17
- Apache Maven
- Apache Tomcat 10.1
- MySQL Server 8.x
- VS Code (Java Extension Pack recommended)

Tomcat 10.1 uses the `jakarta.servlet` package. Do not deploy this project on Tomcat 9 without changing the servlet API.

## 1. Create the database
Open MySQL Workbench, connect to your local MySQL server, open `database/ankit_portfolio.sql`, and execute it.

## 2. Configure database credentials
Set environment variables before starting Tomcat. Example Windows Command Prompt (replace the example password with your own):

```bat
set PORTFOLIO_DB_USER=root
set PORTFOLIO_DB_PASSWORD=YOUR_MYSQL_PASSWORD
set PORTFOLIO_DB_URL=jdbc:mysql://localhost:3306/ankit_portfolio?useSSL=false&serverTimezone=UTC
```

These `set` commands apply only to that Command Prompt window. Start Tomcat from the same window if you use this method. Never commit your real database password to GitHub.

## 3. Build the WAR
Open a terminal in the folder containing `pom.xml` and run:

```bash
mvn clean package
```

The deployable file will be `target/AnkitPortfolio.war`.

## 4. Deploy to Tomcat 10.1
Copy `target/AnkitPortfolio.war` into Tomcat's `webapps` folder. Start Tomcat using `bin/startup.bat`.

Open:

`http://localhost:8080/AnkitPortfolio/`

## 5. Test the contact form
Fill in the name, email and message. After submission, the success page should appear. In MySQL Workbench run:

```sql
USE ankit_portfolio;
SELECT * FROM contacts ORDER BY created_at DESC;
```

A saved row confirms the JDBC/Servlet connection worked.

## Troubleshooting
- `mvn is not recognized`: install Maven and add its `bin` directory to PATH.
- `JAVA_HOME is not defined`: set JAVA_HOME to your JDK 17 installation folder.
- HTTP 404: confirm the WAR is in Tomcat `webapps`, Tomcat is running, and the context path is `/AnkitPortfolio/`.
- Access denied for user: check the environment variables and MySQL password.
- Communications link failure: start MySQL Server and verify port 3306.
- `javax.servlet` errors: this project uses Jakarta Servlet for Tomcat 10.1; use `jakarta.servlet` imports.

## Before submission
1. Replace placeholder content with your own genuine information.
2. Add your own profile photo if desired (do not use someone else's image without permission).
3. Add completed projects only.
4. Test on mobile width and both light/dark themes.
5. Capture screenshots of Home, About, Skills, Projects, Contact, successful form submission, and the database row.
6. Write your own short project report and include the actual screenshots.
