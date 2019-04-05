# CS555 Team Project 2019 Spring

A system that filter GED data according to User Stroy

## Status

[![Build Status](https://travis-ci.org/Shih-Hao-Lo/cs555teamproj2019spring.svg?branch=master)](https://travis-ci.org/Shih-Hao-Lo/cs555teamproj2019spring)

## Usage

* Import the entire repo to IntelliJ IDEA or Eclipse
* Add all files in ./src/lib into project classpath
* Run main.java or JUnit test file in ./src/test_file

## Project Structure

* Main system source code: 
	./src/Mainprogram/main.java
  This file is GED file handler, it extracts string in GED file and applys User Stories to the GED data
 
* User Story JUnit test source code: 
	./src/test_file/
  This folder contains each User Story's JUnit test source code

* GEDCOM file:
	./src/MyFamily.ged
  This file contains GED data, required by main.java

* Filtered GED file:
  ./src/MyFamily.ged-out.ged
  This file is created by running main.java, contains GED data that filtered by User Stories,
  
  
* Output of input test file: (Unknown)
	proj02test.ged-out.ged  (Unknown)
