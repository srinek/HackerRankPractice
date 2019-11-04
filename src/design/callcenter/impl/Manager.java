package design.callcenter.impl;

import design.callcenter.Call;
import design.callcenter.Employee;

public class Manager implements Employee {

	@Override
	public boolean supports(Call call) {

		if(call.getCallPriority() <= 1){
			return true;
		}
		return false;
	}

	@Override
	public boolean handleCall(Call call) {
		// TODO Auto-generated method stub
		return false;
	}

}
