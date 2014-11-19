package dide.theAllBrowser.util.observer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import dide.theAllBrowser.util.observer.IObservable;

public class Observable implements IObservable {

	private List<IObserver> subscribers = new ArrayList<IObserver>(2);
	
	@Override
	public void addObserver(IObserver s) {
		subscribers.add(s);
	}

	@Override
	public void removeObserver(IObserver s) {
		subscribers.remove(s);
	}

	@Override
	public void removeAllObservers() {
		subscribers.clear();
	}

	@Override
	public void notifyObservers() {
		notifyObservers(null);
	}

	@Override
	public void notifyObservers(Event e) {
		for (Iterator<IObserver> iter = subscribers.iterator(); iter.hasNext();) {
			IObserver observer = iter.next();
			observer.update(e);
		}

	}
}
