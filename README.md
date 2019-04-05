# CS555 Team Project 2019 Spring

A system that filter GED data according to User Stroy

## Status

[![Build Status](https://travis-ci.org/Shih-Hao-Lo/cs555teamproj2019spring.svg?branch=master)](https://travis-ci.org/Shih-Hao-Lo/cs555teamproj2019spring)

## Usage

* Import the entire repo to IntelliJ IDEA or Eclipse
* Add all files in ./src/lib into project classpath
* Run main.java or JUnit test file in ./src/test_file

## Project Structure

* Main system source code: <br>
  `./src/Mainprogram/main.java` <br>
  This file is GED file handler, it extracts string in GED file and applys User Stories to the GED data <br><br>
* User Story JUnit test source code: <br>
  `./src/test_file/` <br>
  This folder contains each User Story's JUnit test source code <br><br>
* GEDCOM file:<br>
  `./src/MyFamily.ged` <br>
  This file contains GED data, required by main.java <br><br>
* Filtered GED file: <br>
  `./src/MyFamily.ged-out.ged` <br>
  This file is created by running main.java, contains GED data that filtered by User Stories. <br><br>
  
* Output of input test file: (Unknown) <br>
  proj02test.ged-out.ged  (Unknown) <br>
