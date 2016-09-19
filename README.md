# eshopper
An e-commerce project offering products such as clothing, accessories and shoes.

## Demo
[Live demo](http://eshopper-online.herokuapp.com) running with Heroku.

## Feature List
* Search and browse through categories, brands and gender
* Temporary shopping cart
* Calculate time and cust of an order by Zip Code
* Basic authentication
* CRUD products
* Image upload
* Statistics for products and customers
* Sales reports
* Communicate with an external payment app

## Techlogoy Stack
*Server-side:*
* Spring Framework – noxml (MVC 4, Security, Test)
* JSP
* JPA 2.0 – Hibernate
* Database (MySQL, Redis)
* Jasper Reports
* Testing (JUnit, Selenium (PhantomJS))
* RESTful API
* Webservice SOAP client (Correios)
* S3 – AWS Integration
* Web Resource Optimizer (htmlcompressor, yuicompressor, wro4j)
* Java8, i18n, Maven 3, SLF4J

*Client-side:*
* Bootstrap 3.x
* jQuery (Design patterns)
* Jasmine Framework

## How to run this application
Open the command line and copy this repository:
```
git clone https://github.com/erickbogarin/eshopper.git
cd eshopper
```

### Running with Docker
```
docker-compose up -d
```
Go to [http://localhost:8080](http://localhost:8080) to see the app

### Manually Deploying
#### Requirement Environment
Make sure the following services are installed and running:
* Apache Tomcat 8
* MySQL
* Redis

#### Setting up the MySQL Database
Create the database
```
CREATE DATABASE eshopper
```
Import the dbinit.sql file
```
 mysql -u <user name> -p<password> eshopper < dbinit.sql
```

#### Deploying on Tomcat
Within the project root folder path, copy the following commands bellow:
```
cd app
mvn package -DskipTests
cp target/e-shopper.war <your-path-to>/tomcat/webapps
service tomcat restart
```
Go to [http://localhost:8080](http://localhost:8080) to see the app

## Notes
#### Configuring the AWS S3 Service (Optional)
* Set YOUR **AWS_ACCES_KEY** and **AWS_SECRET_KEY** ENV variables
* Put your AWS Bucket name at [AmazonServer](app/src/main/java/br/com/eshopper/ecommerce/infra/AmazonSaver.java) configuration file
* Change to AmazonServer as provider at [ProductsController](app/src/main/java/br/com/eshopper/ecommerce/controllers/ProductsController.java) class.

## Credits
E-Shopper Bootstrap Theme by [nopCommerce](http://www.nopcommerce.com/p/1540/e-shopper-bootstrap-theme-free.aspx)






