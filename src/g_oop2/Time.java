package g_oop2;

public class Time {

	private int hour;
	private int minute;
	private int second;
	

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		if(0<= hour && hour < 24)
			this.hour = hour;
		if(hour == 24)
			this.hour = 0;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		if(0<= minute && minute < 60)
			this.minute = minute;
		if(minute==60){
			this.minute=0;
			setHour(hour+1);
		}
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		if(0<= second && second < 60)
			this.second = second;
		if(second == 60){
			this.second = 0;
			setMinute( minute + 1);
		}
			
	}

	String getTime(){
		return hour + ":" + minute + ":" + second;
	}
	
	void clock(){
		while(true){
			System.out.println(getTime());
			stop(1000);
			setSecond(second + 1);
		}
	}

	private void stop(int interval){
		try {
			Thread.sleep(interval);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
