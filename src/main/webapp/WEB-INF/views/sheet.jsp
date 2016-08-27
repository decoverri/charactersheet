<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="assets/css/sheet.css">

<title>Character Sheet</title>
</head>
<body>

<h1>Pathfinder Character Sheet</h1>

<section class="personal">

	<div class="name personal-item">
		<div>${sheet.name}</div>
		<label class="personal-item-label">Character Name</label>
	</div>

	<div class="player personal-item">
		<div>${sheet.player}</div>
		<label class="personal-item-label">Player</label>
	</div>

	<div class="classes personal-item">
		<c:forEach items="${sheet.classes}" var="baseClass" >
			<div>${baseClass}</div>
		</c:forEach>
		<label class="personal-item-label">Classes</label>
	</div>

	<div class="personal-item-smallWrapper">
		<div class="alignment personal-item">
			<div>${sheet.alignment}</div>
			<label class="personal-item-label">Alignment</label>
		</div>
	
		<div class="race personal-item">
			<div>${sheet.raceName}</div>
			<label class="personal-item-label">Race</label>
		</div>
	
		<div class="size personal-item">
			<div>${sheet.size}</div>
			<label class="personal-item-label">Size</label>
		</div>
	</div>
	
</section>

<table class="abilities">
	<tr>
		<th class="ability ability-title">Ability Name</th>
		<th class="ability ability-title">Score</th>
		<th class="ability ability-title">Modifier</th>
	</tr>
	
	<c:forEach items="${sheet.abilities}" var="ability" >
		<tr>
			<td class="ability ability-name">${ability.shortName}</td>
			<td class="ability ability-value">${ability.value}</td>
			<td class="ability ability-modifier">${ability.formattedModifier}</td>
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

<section>
	<div>Base Atack Bonus</div>
	<div>${sheet.baseAtackBonus}</div>
	
	<div>Melee Bonus</div>
	<div>${sheet.meleeBonus}</div>
	
	<div>Ranged Bonus</div>
	<div>${sheet.rangedBonus}</div>
</section>
<section>
	<div>Initiative</div>
	<div>${sheet.initiative }</div>
</section>

</body>
</html>