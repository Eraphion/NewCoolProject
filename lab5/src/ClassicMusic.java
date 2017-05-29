
public abstract class ClassicMusic extends AbstractMusic 
{
	private String classicEra;
	ClassicMusic()
	{
		
	}
	ClassicMusic(int duration, int creationYear, String name, String classicEra)
	{
		super(duration, creationYear, name);
		this.classicEra = classicEra;
	}
	public String getClassicEra()
	{
		return classicEra;
	}
	public void setClassicEra(String classicEra)
	{
		this.classicEra = classicEra; 
	}
}
