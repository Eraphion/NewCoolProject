
public abstract class ModernMusic extends AbstractMusic
{
	private boolean specialEffects;
	ModernMusic()
	{
		
	}
	ModernMusic(int duration, int creationYear, String name, boolean specialEffects) 
	{
		super(duration, creationYear, name);
		this.specialEffects = specialEffects;
	}
	public boolean hasSpecialEffects()
	{
		return specialEffects;
	}
	public void setSpecialEffects(boolean specialEffects)
	{
		this.specialEffects = specialEffects;
	}
}
