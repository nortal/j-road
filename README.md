# About J-road
J-road is a Java library which simplifies the consumption and creation of Estonian X-road services through code generation and protocol implementation.

The library was initially created for internal use in Webmedia Group AS (now known as Nortal AS), where it is used in all projects requiring X-road functionality.

It consists of two parts: the client, which is used for consuming services from databases created by others and the server, which allows you to create your own databases.

# Features

## General
* Stable and mature - used in production for over two years.
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
* Supports multiple XML technologies - JAXB, DOM and allows you to write your own if needed.
* Supports swaref attachments.
* Provider WSDL is generated as expected by protocol 4.0.
* Support for protocol 4.0 messages is added.

## Things yet to do/figure out
* With the new X-road protocol concept of the service database or "andmekogu" is replace with "subsystem" and they are not the same. What does it actually mean and does it affect current J-road implementation. From consumer point of view if the database services are provided by the same subsystem all should be fine. By provider it seems to make thing even easier.
* Support for X-road meta services according to protocol 4.0. It seems like including service WSDL to security server is sufficient.[X-road meta services description](https://www.ria.ee/public/x_tee/pr-meta_x-road_service_metadata_protocol_2.1.3_Y-743-14.pdf)
* Complete naming convention conversion to XRoad
* Complete update to service consumers according to changes - configuration and implementation if necessary
* While changing provider XSD namespace previous protocols might not work - response will be returned with new namespace. Security servers and J-road consumer/provider does not mind though. Some additional provider response namespace modifying might be needed.
* XTeeHeader/XRoadHeader maps request headers insufficiently for now
* Review to current state
* Tests
* Documentation

# Setting up the project
* You need JDK 17 or higher 
* Toolchains plugin is used so that developer does not need to tune JAVA_HOME. For toolchains plugin to work, jdk should be in a predictable location: ~/.jdks 
* Since artifacts are absent from central. You need to build them first (typegen, common, client-transport, client). The easiest solution is to run install on root and stop once you reach first service in client-service (currently arireg).

# Versioning
* Current versioning patten is X.X.X\[.X\]
  * First number denotes version of message protocol, currently 4
  * Next two numbers denote version of core libraries and retained for legacy purposes
  * 4th (optional) number is needed, when changes are done only to client-library to denote its new version.
* When updating libraries that affect core functionality, increment X.X.X and update versions of all libraries in active use
* When updating client-libraries. X.X.X.X additional 4th number can be used to specify version to indicate that core libraries haven't been changed
