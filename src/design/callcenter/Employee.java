package design.callcenter;

public interface Employee {

	
	public boolean supports(Call call);
	
	public boolean handleCall(Call call) throws CallHandleException;
}
