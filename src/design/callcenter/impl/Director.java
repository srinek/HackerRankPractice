package design.callcenter.impl;

import design.callcenter.Call;
import design.callcenter.Employee;

public class Director implements Employee {

	@Override
	public boolean supports(Call call) {

		return true;
	}

	@Override
	public boolean handleCall(Call call) {
		// TODO Auto-generated method stub
		return false;
	}

}
