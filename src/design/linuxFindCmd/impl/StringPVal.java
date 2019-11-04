package design.linuxFindCmd.impl;

import design.linuxFindCmd.PVal;

public class StringPVal implements PVal<String>{

	
	private String val = "";
	
	public StringPVal(String val){
		this.val = val;
	}
	
	public String getVal(){
		return this.val;
	}
}
