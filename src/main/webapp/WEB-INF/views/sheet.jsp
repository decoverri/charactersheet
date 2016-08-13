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

<section>
	<div>Total HP</div>
	<div>${sheet.hpManager.total}</div>

	<div>Current HP</div>
	<div>${sheet.hpManager.current}</div>

	<div>Nonlethal Damage</div>
	<div>${sheet.hpManager.nonlethalDamage}</div>
</section>

<section>
	<div>AC</div>
	<div>${sheet.acManager.ac}</div>
</section>
<section>
	<div>AC - Touch</div>
	<div>${sheet.acManager.touch}</div>
</section>
<section>
	<div>AC - Flat-Footed</div>
	<div>${sheet.acManager.flatFooted}</div>
</section>
</body>
</html>