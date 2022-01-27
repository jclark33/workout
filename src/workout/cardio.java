package workout;
import java.util.Date;

public class cardio {
	private double time;
	private double dist; String type; 
	private Date day;
	private String location;
	private double pace;
	private String tod;
	public cardio() {	
	}
	public void logCardio(String activity, String where, double mil, double dur, Date date, String tim) {
		time = dur;
		dist = mil;
		type = activity;
		day = date;
		location = where;
		tod = tim;
		pace = time/dist;
	}
	
	
	public String printCardio(){
		String out = new String();
		out = type + ", " + location + ", "+ Double.toString(time) + " minutes, " + Double.toString(dist) + " miles, "+ pace + "pace, " + day.toString() + " " + tod;
		return out;
	}
	
}
