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

# X-road 6 support
X-road 6 is new version which brings major changes to X-road services because it is not backwards compatible with previous versions. For migration period all message protocols are supported which means that for migration period service providers should support multiple message protocols - pre 4.0 and 4.0.

Some useful links about upcoming changes:
* Migration should be done by the following [schedule](https://www.ria.ee/public/x_tee/kaskkiri-X-tee-versiooni-6-juurutamine.pdf)
* Short overview about upcoming changes can be found [here](https://www.ria.ee/public/x_tee/X-tee_v5_ja_v6_erisused.pdf) 
* In-depth X-road new protocol description can be found [here](http://x-road.eu/docs/x-road_message_protocol_v4.0.pdf)

## Upgrades to J-road according to X-road 6
Since now J-road service provider supported only protocol 2.0 style service providers and also most service consumers were implemented for protocol 2.0. So to support upcoming changes/migration J-road has changed significantly as well.

### Service provider
Upgrading to J-road new version as of service provider point view nothing has changed **(as for now/migration period)**. Just update necessary J-road dependencies and you're done. You might consider changing XSD schema namespace but actually X-road protocol 4.0 does not restrict database namespace naming anymore so existing should be fine as well. For in-depth overview how to implement service provider consult with J-road updated example and documentation provided in J-road.

In short changes to service providers are as follows:
* Provider WSDL is generated as expected by protocol 4.0.
* Support for protocol 4.0 messages is added.
* Support for protocol 2.0 messages is maintained (for migration period).

### Service consumer
Upgrading to J-road new version as of consumer point of view lot has changed. Changes to consumers are not backwards compatible to previous protocols (by default) so do expect X-road protocol 4.0+ behavior. Naming convention has changed from XTee to XRoad so try to follow it as well. As of brighter side most currently implemented service consumer should be fine with proper database specific configuration and some minor modifications. To support X-road previous protocols use J-road previous versions. For in-depth overview how to implement consumer consult with J-road updated example and documentation provided in J-road.

In short changes to service consumers are as follows:
* Naming convention has changed from XTee to XRoad - this includes object, configuration, generation etc. naming.
* Support for protocol 4.0 style service consumer generation.
* Support to consumer protocol 4.0 style services.
* Included database specific configuration.

## Things yet to do/figure out
* With the new X-road protocol concept of the service database or "andmekogu" is replace with "subsystem" and they are not the same. What does it actually mean and does it affect current J-road implementation. From consumer point of view if the database services are provided by the same subsystem all should be fine. By provider it seems to make thing even easier.
* Support for X-road meta services according to protocol 4.0. It seems like including service WSDL to security server is sufficient.[X-road meta services description](https://www.ria.ee/public/x_tee/pr-meta_x-road_service_metadata_protocol_2.1.3_Y-743-14.pdf)
* Axis support - is it needed?
* Complete naming convention conversion to XRoad
* Complete update to service consumers according to changes - configuration and implementation if necessary
* While changing provider XSD namespace previous protocols might not work - response will be returned with new namespace. Security servers and J-road consumer/provider does not mind though. Some additional provider response namespace modifying might be needed.
* XTeeHeader/XRoadHeader maps request headers insufficiently for now
* Review to current state
* Tests
* Documentation
* ...


