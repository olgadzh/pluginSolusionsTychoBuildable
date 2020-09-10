package com.softcom.ide.testpojo;

import org.eclipse.ui.handlers.IHandlerService;
import org.eclipse.ui.services.IServiceLocator;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

//import org.eclipse.core.runtime.ListenerList;
//import org.eclipse.jface.util.IPropertyChangeListener;


public class ServiceSolution {

	private IServiceLocator serviceLocator;
	//private ListenerList<IPropertyChangeListener> listeners = new ListenerList<>(ListenerList.IDENTITY);
	
	public ServiceSolution(IServiceLocator locator) {
		serviceLocator = locator;
		serviceLocator.hasService(IHandlerService.class);
		fillModel();
	}
	
	private Map<Integer, Solution> fillModel() {
		return PopulateSolutions.populateSolutions();
	}
	
	Map<Integer, Solution> solutions = fillModel();
	
	//public void addSolutionsChangeListener(IPropertyChangeListener listener) {
	//	listeners.add(listener);	
	//}
	
	public Collection<Solution> getSolutions() {
		return Collections.unmodifiableCollection(solutions.values());
	}
	
	public void dispose() {
		// we'd save stuff here, maybe, if we cared
		//listeners.clear();
		serviceLocator = null;
	}
}
