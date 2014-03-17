public class ShowCurrentTime{
	public static void main(String[] args){
		long totalMilliSeconds = System.currentTimeMillis();
		long totalSeconds = totalMilliSeconds/1000;
		long totalMinutes = totalSeconds/60;
		long totalHours = totalMinutes/60;

		long currentSeconds = totalSeconds%60;
		long currentMinutes = totalMinutes%60;
		System.out.println(totalMilliSeconds + " " + totalSeconds + " " + totalMinutes + " " + totalHours);
		long currentHours = totalHours%24;
		System.out.println("Current time is " + currentHours + ":" + currentMinutes + ":" + currentSeconds);
	}
}