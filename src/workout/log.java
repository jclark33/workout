package workout;
import java.util.Date;
public class log {
	private cardio[] runs = new cardio[1];
	private int c=0;
	
public log(){
	
}

public void addCardio(String type, String loc, double dist, double dur, Date day, String tim) {
	cardio temp = new cardio();
	temp.logCardio(type, loc, dist, dur, day, tim);
	runs[c] = temp;
	c++;
	cardio[] mid = new cardio[c+1];
	for(int i = 0; i < c; i++){
		mid[i] = runs[i];
	}
	runs = mid;
}

public void printLog() {
	for(int i = 0; i < c; i++) {
		cardio temp = runs[i];
		System.out.println(temp.printCardio());
	}
}

	public static void main(String[] args){
		
		MyFrame f = new MyFrame();

	}

}
