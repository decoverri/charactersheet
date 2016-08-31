<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta name="viewport" content="width=device-width">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

	<link rel="stylesheet" type="text/css" href="assets/css/general.css">
	<link rel="stylesheet" type="text/css" href="assets/css/personal.css">
	<link rel="stylesheet" type="text/css" href="assets/css/core-attributes.css">
	
	<title>Character Sheet</title>
</head>
<body id="sheet">

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

<section class="core">

	<section class="abilities">
	
		<table>
			<tr>
				<th class="abilities-title">Ability Name</th>
				<th class="abilities-title">Base Value</th>
				<th class="abilities-title">Ability Score</th>
				<th class="abilities-title">Ability Modifier</th>
			</tr>
			
			<c:forEach items="${sheet.abilities}" var="ability" >
				<tr class="ability">
					<td class="ability-data ability-name subbedbox black">
						<span class="subbedbox-content ability-name-short">${ability.shortName}</span>
						<label class="subbedbox-subtitle">${ability.name}</label>
					</td>
					<td class="ability-data borderedbox ability-base-wrap"><input class="ability-base" type="number" value="${ability.value}" v-model="${ability.shortName}Base"></td>
					<td class="ability-data borderedbox">{{${ability.shortName}}}</td>
					<td class="ability-data borderedbox">{{${ability.shortName}Mod}}</td>
				</tr>
			</c:forEach>
		
		</table>
	
	</section>
	
	<section class="hp">
	
		<div class="subbedbox black">
			<span class="subbedbox-content">HP</span>
			<label class="subbedbox-subtitle">Hit Points</label>
		</div>
	
		<div class="borderedbox">
			<div class="borderedbox-title">Total</div>
			<div class="borderedbox-content">${sheet.hpManager.total}</div>
		</div>
	
		<div class="borderedbox">
			<div class="borderedbox-title">Current HP</div>
			<div class="borderedbox-content">${sheet.hpManager.current}</div>
		</div>
	
		<div class="borderedbox">
			<div class="borderedbox-title">Nonlethal Damage</div>
			<div class="borderedbox-content">${sheet.hpManager.nonlethalDamage}</div>
		</div>
	
	</section>
	
	<section class="initiative">
	
		<div class="subbedbox black initiative-title">
			<span class="subbedbox-content">INITIATIVE</span>
			<label class="subbedbox-subtitle">Modifier</label>
		</div>
	
		<div class="sums initiative-bonus">
			<div class="sum sum-total">
				<div class="borderedbox">{{initiative}}</div>
				<div class="sum-subtitle">TOTAL</div>
			</div>
		
			<div class="sum sum-part">
				<div class="borderedbox">{{dexMod}}</div>
				<div class="sum-subtitle">DEX Modifier</div>
			</div>
		
			<div class="sum">
				<div class="borderedbox">0</div>
				<div class="sum-subtitle">MISC Modifier</div>
			</div>
		</div>
	
	</section>
	
	<section class="ac">
	
		<div class="subbedbox black ac-title">
			<span class="subbedbox-content">AC</span>
			<label class="subbedbox-subtitle">Armor Class</label>
		</div>
	
		<div class="sums ac-bonus">
			<div class="sum sum-total">
				<div class="borderedbox">{{ac}}</div>
				<div class="sum-subtitle">TOTAL</div>
			</div>
		
			<div class="sum sum-constant sum-part">
				<div class="sum-constant-content" >10</div>
			</div>
		
			<div class="sum sum-part">
				<div class="borderedbox">10</div>
				<div class="sum-subtitle">Armor Bonus</div>
			</div>
		
			<div class="sum sum-part">
				<div class="borderedbox">3</div>
				<div class="sum-subtitle">Shield Bonus</div>
			</div>
		
			<div class="sum sum-part">
				<div class="borderedbox">{{dexMod}}</div>
				<div class="sum-subtitle">DEX Modifier</div>
			</div>
		
			<div class="sum sum-part">
				<div class="borderedbox">1</div>
				<div class="sum-subtitle">Size Modifier</div>
			</div>
		
			<div class="sum sum-part">
				<div class="borderedbox">0</div>
				<div class="sum-subtitle">Natural Armor</div>
			</div>
		
			<div class="sum sum-part">
				<div class="borderedbox">0</div>
				<div class="sum-subtitle">Deflection Modifier</div>
			</div>
		
			<div class="sum">
				<div class="borderedbox">0</div>
				<div class="sum-subtitle">MISC Modifier</div>
			</div>
		</div>
	
	</section>
	
</section>

<section class="touchAC">

	<div class="subbedbox black initiative-title ac-title">
		<span class="subbedbox-content">TOUCH</span>
		<label class="subbedbox-subtitle">Armor Class</label>
	</div>
	<div class="sums ac-bonus">
		<div class="borderedbox sum">{{touchAc}}</div>
	</div>

	<div class="subbedbox black initiative-title ac-title">
		<span class="subbedbox-content">FLAT-FOOTED</span>
		<label class="subbedbox-subtitle">Armor Class</label>
	</div>
	<div class="sums ac-bonus">
		<div class="borderedbox sum">{{flatfootedAc}}</div>
	</div>

</section>

<section>
	<input type="hidden" value="${sheet.baseAtackBonus}" v-model="bab">

	<div>Base Atack Bonus</div>
	<div>{{bab}}</div>
	
	<div>Melee Bonus</div>
	<div>{{meleeBonus}}</div>
	
	<div>Ranged Bonus</div>
	<div>{{rangedBonus}}</div>
</section>


<script src="assets/js/vue.js"></script>
<script src="assets/js/sheet.js"></script>
</body>
</html>