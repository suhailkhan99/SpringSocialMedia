package com.cg.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.spring.versioning.Name;
import com.cg.spring.versioning.PersonV1;
import com.cg.spring.versioning.PersonV2;

@RestController
public class VersioningPersonController {

	
//uri versioning
 @GetMapping("/v1/person")
    public PersonV1 getFirstVersionOfPerson() {
	return new PersonV1("Bob Charled");
}
 
 @GetMapping("/v2/person")
 public PersonV2 getSecondVersionOfPerson() {
	return new PersonV2(new Name("Bob","Charle"));
}
 
 //Query param
 @GetMapping(path="/person" ,params="version1")
 public PersonV1 getFirstVersionOfPersonQueryParam() {
	return new PersonV1("Bob Charled");
}
 @GetMapping(path="/person" ,params="version2")
 public PersonV2 getSecondVersionOfPersonQueryParam() {
	return new PersonV2(new Name("bob","charle"));
}
 //using header versioning
 @GetMapping(path="/person/header" ,headers="X-API-VERSION=1")
 public PersonV1 getFirstVersionOfPersonHeader() {
	return new PersonV1("Bob Charled");
}
 @GetMapping(path="/person/header" ,headers="X-API-VERSION=2")
 public PersonV2 getSecondVersionOfPersonHeader() {
	return new PersonV2(new Name("bob","charle"));
	
 }
//using media type (content negotiation or accept header)
@GetMapping(path="/person/accept" ,produces="application/vnd.company.app-v1+json")
	 public PersonV1 getFirstVersionOfPersonMediaType() {
		return new PersonV1("Bob Charled");
	}
	
@GetMapping(path="/person/accept" ,produces="application/vnd.company.app-v2+json")
public PersonV2 getSecondVersionOfPersonMediaType() {
	return new PersonV2(new Name("Bob","charle"));
}
}
