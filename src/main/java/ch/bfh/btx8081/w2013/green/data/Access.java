package ch.bfh.btx8081.w2013.green.data;

public class Access extends UserStatus{

	private boolean hasAccess = false;
	private User user;
	
	protected Access(User u) {
		super(u);
		user = u;
		// TODO Auto-generated constructor stub
	}
	
	// TODO
	public boolean hasAccess(User user) {
		
		return hasAccess;
	}
}
