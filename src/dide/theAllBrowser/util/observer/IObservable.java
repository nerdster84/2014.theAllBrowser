package dide.theAllBrowser.util.observer;

import dide.theAllBrowser.util.observer.Event; 
import dide.theAllBrowser.util.observer.IObserver;

public interface IObservable {
		 void addObserver(IObserver s);
		 void removeObserver(IObserver s);
		 void removeAllObservers();
		 void notifyObservers();
		 void notifyObservers(Event e);
}
