class SleepThread{
	static public void sleeper(long mili){
		try{
			Thread.sleep(mili);
		}
		catch(InterruptedException e){
			System.out.println(e);
		}
	}
}