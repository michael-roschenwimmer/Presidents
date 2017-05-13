<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Presidential</title>
</head>
<body>

	<form action="${filtered = true}">
	Filter by:
	<select>
	<option> party </option>
	<option> name </option>
	<option> 
	</select>
	
	
	</form>
	
	<form action="${tracker = Integer.parseInt(req.getParameter(term))}" >
	Search by term <input type="text" name="term"> <br>
	<input type="submit"/>
	</form>
	
	
		<div id="presPic"> <img src="${pres.pic}"/> </div>
		<div id="presStats">President ${pres.name} | Term:${pres.termNumber} 
		[ ${pres.startYear} - ${pres.endYear} ]</div>
		
		<c:choose>
     <c:when test="${tracker.index +1 != presidents.size}">
     	<form action="">
     	<button type="submit" value="${tracker.next} Next"/>
     	</form>
     </c:when>
     <c:otherwise>
      <button type="submit" disabled>Next</button>
     </c:otherwise>
    </c:choose>
</body>
</html>