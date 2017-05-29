import java.io.Serializable;

public abstract class AbstractMusic  implements Serializable
{
	private int duration;
	private int creationYear;
	private String name;
	AbstractMusic()
	{
		
	}
	AbstractMusic(int duration, int creationYear, String name)
	{
		this.duration = duration;
		this.creationYear = creationYear;
		this.name = name;
	}
 public int getDuration()
 {
	 return duration;
}
public  void setDuration(int duration)
 {
	 this.duration = duration;
 }
public void setDuration(int hours, int minutes, int seconds)
{
	int duration = hours*3600 + minutes*60 + seconds;
	this.duration = duration;
}
public static String ShowDuration(int duration)
{
	String result = "";
	int hours = duration/3600;
	int leftDuration = duration - hours*3600;
	int minutes = leftDuration/60;
	leftDuration -= minutes*60;
	int seconds = leftDuration;
	result += "Hours: " + hours + ", minutes: " + minutes + ", seconds: " + seconds;
	return result;
}
public static int ConvertHMSToDuration(int hours, int minutes, int seconds)
{
	return hours*3600+minutes*60+seconds;
}

public int getCreationYear()
{
	return creationYear;
}
 public void setCreationYear(int creationYear)
{
	this.creationYear = creationYear;
}
 public void setName(String name)
 {
	 this.name = name;
 }
 public String getName()
 {
	 return name;
 }
 abstract String getAdditionalInfo(); 
}
