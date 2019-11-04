package design.callcenter.impl;

import design.callcenter.Call;
import design.callcenter.CallStatus;
import design.callcenter.Employee;

public class Associate implements Employee {

	@Override
	public boolean supports(Call call) {

		if(call.getCallPriority() == 0){
			return true;
		}
		return false;
	}

	@Override
	public boolean handleCall(Call call) {
		call.setCallStatus(CallStatus.CALL_FINISHED);
		return true;
	}

}
