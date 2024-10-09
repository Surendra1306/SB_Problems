package com.surendra.entity;

public class ObjToXml {

	
	 public static void main(String args[]) throws Exception {
	      try {
	         XmlMapper xmlMapper = new XmlMapper();
	         Person pojo = new Person();
	         pojo.setFirstName("Raja");
	         pojo.setLastName("Ramesh");
	         pojo.setAddress("Hyderabad");
	         String xml = xmlMapper.writeValueAsString(pojo);
	         System.out.println(xml);
	      } catch(Exception e) {
	         e.printStackTrace();
	      }
	   }
}
