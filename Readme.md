###Personal expenses management application that allows users to track how much money have they spent.
To build and run using IntelliJ IDEA do next steps:
* download and install tomcat(tested on v9)
* open project folder as project in IntelliJ 
* hit add configuration button on the toolbar
* in opened window press + and select TomCat server-> local
* write down TomCat folder path and hit ok button
* on the bottom you will see warning: "No artifacts marked on deployment", hit **fix** button and choose **IATest:war**
* hit ok and then press Run button on the toolbar


* Profit! Server started at localhost:8080/IATest_war/


##MySQL part
#####Application uses database(MySQL), so we need to install and setup it with the parameters:
create user with all privileges for iatest SCHEMA
* username = userIA
* password = 1234
* authenticate type = standart


* port = 3306
* URL = localhost
* Schema name = iatest
####SQL dump(Self-Contained) file is located on root of the project, so you can easily create schema and tables using data import in MySQL Workbench