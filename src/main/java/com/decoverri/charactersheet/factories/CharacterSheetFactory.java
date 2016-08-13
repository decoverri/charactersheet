package com.decoverri.charactersheet.factories;

import com.decoverri.charactersheet.models.Character;
import com.decoverri.charactersheet.models.CharacterSheet;

public class CharacterSheetFactory {

	private CharacterSheet sheet;

	public CharacterSheet createSheetFor(Character character) {
		sheet = new CharacterSheet();
		sheet.setCharacter(character);
		return sheet;
	}

}
