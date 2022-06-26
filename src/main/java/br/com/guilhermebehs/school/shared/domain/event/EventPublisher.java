package br.com.guilhermebehs.school.shared.domain.event;

import java.util.ArrayList;
import java.util.List;

public class EventPublisher {

    private List<EventListener> listeners = new ArrayList<>();

    public void add(EventListener listener){
        listeners.add(listener);
    }

    public void publish(Event event){
        listeners.forEach(listener -> listener.process(event));
    }

}
