package com.hcl.test.repository;
import org.springframework.batch.item.ItemProcessor;

import com.hcl.test.dao.Event;
import com.hcl.test.dao.EventDto;
public class EventItemProcessor implements ItemProcessor<Event, EventDto>{

	@Override
	public EventDto process(Event event) throws Exception {
		   System.out.println("Transforming event(s) to eventDTO(s)..");
	        final EventDto eeventDto = new EventDto(event.getEventId(), event.getSiteName(),
	        		event.getCameraName(),event.getCameraId(), event.getProject(),event.getEventTime(),
	        		event.getTerminatedLevel(),event.getEventTag(),event.getAction(),
	        		event.getEventDuration());

	        return eeventDto;
	}

}
