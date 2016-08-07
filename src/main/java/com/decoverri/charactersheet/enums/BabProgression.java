package com.decoverri.charactersheet.enums;

public enum BabProgression {

	GOOD{
		@Override
		public int getBab(int level) {
			if(level < 1 || level > 20){
				throw new IllegalArgumentException("level must be from 1 to 20");
			}
			return level;
		}
	},
	MEDIUM {
		@Override
		public int getBab(int level) {
			if(level < 1 || level > 20){
				throw new IllegalArgumentException("level must be from 1 to 20");
			}
			return level * 3/4;
		}
	},
	BAD{
		@Override
		public int getBab(int level) {
			if(level < 1 || level > 20){
				throw new IllegalArgumentException("level must be from 1 to 20");
			}
			return level / 2;
		}
	};
		
	public abstract int getBab(int level);
}
