package design.callcenter.impl;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;

import design.callcenter.Call;
import design.callcenter.CallDriver;
import design.callcenter.CallHandleException;
import design.callcenter.Employee;

public class CallDriverImpl implements CallDriver {

	Queue<Call> priorityQueue = new PriorityBlockingQueue<>();
	Queue<Employee> freeList = new LinkedList<>();
	public volatile boolean keepRunning = true;
	
	public CallDriverImpl(){
		
	}
	
	@Override
	public void addCall(Call call) {
		this.priorityQueue.add(call);
	}

	@Override
	public void addEmployee(Employee employee) {
		freeList.add(employee);
	}

	@Override
	public void startProcess() {
		
		while(keepRunning){
			
			if(!priorityQueue.isEmpty()){
				
				Call call = priorityQueue.poll();
				while(!freeList.isEmpty()){
					Employee employee = freeList.poll();
					if(employee.supports(call)){
						try{
							boolean callHandled = employee.handleCall(call);
							if(!callHandled){
								this.priorityQueue.add(call);
							}
						}
						catch(CallHandleException e){
							this.freeList.add(employee);
						}
					}
					else{
						this.freeList.add(employee);
					}
				}
			}
		}

	}

	@Override
	public void shutDown() {
		this.keepRunning = false;
	}

}
