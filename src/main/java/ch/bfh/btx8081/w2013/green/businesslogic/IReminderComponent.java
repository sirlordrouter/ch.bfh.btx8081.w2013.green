package ch.bfh.btx8081.w2013.green.businesslogic;

public interface IReminderComponent {

	public void showAlert(String medicationName);
	
	public void addListener(IReminderComponentListener l);
	
	interface IReminderComponentListener {
		void showAlert(String medicationName);
	}
}
