# CS555 Team Project 2019 Spring

A system that filters GED data according to User Stroy

## Status

[![Build Status](https://travis-ci.org/Shih-Hao-Lo/cs555teamproj2019spring.svg?branch=master)](https://travis-ci.org/Shih-Hao-Lo/cs555teamproj2019spring)

## Usage

* Import the entire repo to IntelliJ IDEA or Eclipse
* Add all files in `./src/lib` into project classpath
* Compile & Run main.java or JUnit test file in ./src/test_file

## Project Structure

* Main system source code: <br>
  `./src/Mainprogram/main.java` <br>
  This file is GED file handler, it extracts string in GED file and applies User Stories to GED data <br>
* User Stories source code: <br>
  `./src/Mainprogram/sprint2` <br>
  `./src/Mainprogram/sprint3` <br>
  These folders contain User Stories code listed in Sprint plan<br>
* User Story JUnit test source code: <br>
  `./src/test_file/` <br>
  This folder contains each User Story's JUnit test source code <br>
* GEDCOM file:<br>
  `./src/MyFamily.ged` <br>
  This file contains GED data, required by main.java <br>
* Formatted GED data: <br>
  `./src/Table.txt` <br>
  This file contains formatted GED data from `./src/MyFamily.ged`. <br>
  
* Output of input test file: (Unknown) <br>
  proj02test.ged-out.ged  (Unknown) <br>

## Group members:
* Shih-Hao Lo
* Hao-Ping Lin
* Song Xu
* Jiacheng Guo
