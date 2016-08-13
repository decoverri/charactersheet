package com.decoverri.charactersheet.enums;

public enum BabProgression {

	GOOD{
		@Override
		public int getBab(int level) {
			validateLevel(level);
			return level;
		}
	},
	MEDIUM {
		@Override
		public int getBab(int level) {
			validateLevel(level);
			return level * 3/4;
		}
	},
	BAD{
		@Override
		public int getBab(int level) {
			validateLevel(level);
			return level / 2;
		}
	};
		
	public abstract int getBab(int level);
	
	private static void validateLevel(int level){
		if(level < 1){
			throw new IllegalArgumentException("level must be greater then 0");
		}
	}
}
