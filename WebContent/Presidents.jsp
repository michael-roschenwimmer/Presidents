<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="master.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Presidential</title>
<link rel="stylesheet" href="master.css">
</head>
<body>
<img src="zapPatriot.gif" alt="zapPatriot" class="zap"/>

	<%-- <form action="something.do" method="post">
	Filter by:
	<select>
	<option> party </option>
	<option> name </option> 
	</select>
	<input type="hidden" name="filter" value="true" />
	<p hidden> ${filtered = true} </p>
	<button type="submit" >Submit</button>
	
	</form> --%>
	
	<%-- <form action="${tracker = Integer.parseInt(req.getParameter(term))}" >
	Search by term <input type="text" name="term"> <br>
	<input type="submit"/>
	</form> --%>
	
		<div id="searchByTerm"> <form action="next.do" method="post">
		<h4> Search by term</h4>
     	<input type="text" name="filterNum" >
     	<button type="submit">Submit</button>
     	</form></div>
		
		
		<br>
		<br>
		
	
     <c:if test="${tracker != 0}">
     	<form action="back.do" method="post">
     	<input type="hidden" name="result" value="-1" />
     	<button type="submit" class="backButton"><img src="backArrow.png" alt="backArrow"/></button>
     	</form>
     </c:if>
     <c:if test="${tracker == 0}">
     	<form action="back.do" method="post">
     	<button type="submit" class="backButton" disabled><img src="backArrow.png" alt="backArrow"/></button>
     	</form>
     </c:if>
     
     <c:if test="${tracker +1 != presidents.size()}">
     <form action="next.do" method="post">
     <input type="hidden" name="result" value="1"/>
     	<button type="submit" class="nextButton"><img src="forwardArrow.png" alt="forwardArrow"/></button>
     	</form>
     </c:if>
     
     <c:if test="${tracker +1 == presidents.size()}">
     	<form action="next.do" method="post">
     	<button type="submit" value="Next" class="nextButton" disabled><img src="forwardArrow.png" alt="forwardArrow"/></button>
     	</form>
     </c:if>
     
		<div id="presPic"> <img src="${president.getPic(pres)}" class="president"/> </div>
		<div id="presStats">President ${pres.name} | Term:${pres.termNumber} 
		[ ${pres.startYear} - ${pres.endYear} ] <br> 
			${pres.funFact} </div>
		
		 
     
    
    
    
     
     
     
     
</body>
</html>