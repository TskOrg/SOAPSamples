package com.tsk.soap.wsclient;

import javax.xml.datatype.XMLGregorianCalendar;

import javax.xml.ws.Holder;
import org.example.echo.service.skeleton.CheckTinPortType;
import org.example.echo.service.skeleton.CheckTinService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SoapConsumptionThruMavenApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoapConsumptionThruMavenApplication.class, args);
		
		
		CheckTinService checkTinService = new CheckTinService();
        CheckTinPortType portType = checkTinService.getPort(CheckTinPortType.class);
        Holder<String> code = new Holder<String>("DE");
        Holder<String> tin = new Holder<String>("12346789");
        Holder<XMLGregorianCalendar> requestDate = new Holder<>();
        Holder<Boolean> validStructure = new Holder<>();
        Holder<Boolean> validSyntax = new Holder<>();
        portType.checkTin(code, tin, requestDate, validStructure, validSyntax);

        System.out.println("requestDate : " + requestDate.value);
        System.out.println("validStructure : " + validStructure.value);
        System.out.println("validSyntax : " + validSyntax.value);
	}
}
