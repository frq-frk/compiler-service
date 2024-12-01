ECHO "Entering create database script"
CREATE DATABASE IF NOT EXISTS db_online_compiler;
USE db_online_compiler;
CREATE USER IF NOT EXISTS 'devuser'@'%' IDENTIFIED BY 'Nightwatch@007';
GRANT ALL PRIVILEGES ON db_online_compiler.* TO 'devuser'@'%';
FLUSH PRIVILEGES;
ECHO "Exiting create database script"
