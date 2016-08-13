<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Character Sheet</title>
</head>
<body>

<h1>Pathfinder Character Sheet</h1>

<section class="personal">

	<div class="name">
		<div>Character Name</div>
		<div>${sheet.name}</div>
	</div>

	<div class="alignment">
		<div>Alignment</div>
		<div>${sheet.alignment}</div>
	</div>

	<div class="player">
		<div>Player</div>
		<div>${sheet.player}</div>
	</div>

	<div class="classes">
		<div>Classes</div>
		<c:forEach items="${sheet.classes}" var="baseClass" >
			<div>${baseClass}</div>			
		</c:forEach>
	</div>

	<div>
		<div>Race</div>
		<div>${sheet.raceName}</div>
	</div>

	<div>
		<div>Size</div>
		<div>${sheet.size}</div>
	</div>
	
</section>

<table class="abilities">
	<tr>
		<th>Ability Name</th>
		<th>Score</th>
		<th>Modifier</th>
	</tr>
	
	<c:forEach items="${sheet.abilities}" var="ability" >
		<tr>
			<td>${ability.shortName}</td>
			<td>${ability.value}</td>
			<td>${ability.formattedModifier}</td>
		</tr>
	</c:forEach>

</table>

</body>
</html>