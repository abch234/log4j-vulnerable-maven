package com.app.test;

import java.util.concurrent.atomic.AtomicLong;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;

import javax.annotation.Resource;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;
import org.exolab.castor.mapping.Mapping;

import java.io.*;


class BadCastorDeserializationController {
  public doPost1(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException  {
    ByteArrayInputStream isr = new ByteArrayInputStream(req.getParameter("bin"));
    Unmarshaller un = new Unmarshaller();
    // ruleid: castor-deserialization-deepsemgrep
    SomeClass object = (SomeClass)un.unmarshal(isr);
  }

  public okPost1(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException  {
    ByteArrayInputStream isr = new ByteArrayInputStream("hardcoded value");
    Unmarshaller un = new Unmarshaller();
    // ok: castor-deserialization-deepsemgrep
    SomeClass object = (SomeClass)un.unmarshal(isr);
  }

  public notARequest(String objectBin) throws IOException  {
    ByteArrayInputStream isr = new ByteArrayInputStream(objectBin);
    Unmarshaller un = new Unmarshaller();
    // ok: castor-deserialization-deepsemgrep
    SomeClass object = (SomeClass)un.unmarshal(isr);
  }

}


