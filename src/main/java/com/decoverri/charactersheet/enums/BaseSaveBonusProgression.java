package com.decoverri.charactersheet.enums;

public enum BaseSaveBonusProgression {

	GOOD {
		@Override
		public int getBonus(int level) {
			if(level < 1 || level > 20){
				throw new IllegalArgumentException("level must be from 1 to 20");
			}
			return (level / 2) + 2;
		}
	}
	,BAD {
		@Override
		public int getBonus(int level) {
			if(level < 1 || level > 20){
				throw new IllegalArgumentException("level must be from 1 to 20");
			}
			return level / 3;
		}
	};
	
	public abstract int getBonus(int level);
}
