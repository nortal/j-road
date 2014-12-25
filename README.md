# About J-road
[![Build Status](https://travis-ci.org/nortal/j-road.svg?branch=master)](https://travis-ci.org/nortal/j-road)

J-road is a Java library which simplifies the consumption and creation of Estonian X-road services through code generation and protocol implementation.

The library was initially created for internal use in Webmedia Group AS (now known as Nortal AS), where it is used in all projects requiring X-road functionality.

It consists of two parts: the client, which is used for consuming services from databases created by others and the server, which allows you to create your own databases.

# Features

## General
* Stable and mature - used in production for over two years.
* Actively developed.
* Documented, includes manual with examples.
* Aimed at maximum productivity.

## Consumption
* Automatically generates all boilerplate code from WSDL.
* Allows the developer to concentrate on writing logic, not protocol implementation.
* Implements X-road specification.
* Allows full code re-use for services.
* Includes existing, working implementations for the majority of commonly used X-road services in Estonia.
* Full support for automatic form generation with X-road specific WSDL based labels and descriptions.
* XMLBeans based, very flexible.
* Allows callback-based modifications of all automatically generated XML.
* Attachment support.
* Full support for X-road database name inconsistencies between development/live.

## Creation
* Contract-first style.
* Do not write WSDL, only Schema.
* Automatically generates WSDL from Schema.
* Generates Java classes from Schema.
* Supports multiple XML technologies - JAXB, DOM, Axis and allows you to write your own if needed.
* Supports swaref attachments.
