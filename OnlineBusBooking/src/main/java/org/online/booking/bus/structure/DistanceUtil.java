package org.online.booking.bus.structure;

import java.util.Set;

import org.springframework.stereotype.Component;

@Component
public class DistanceUtil {

	private Set<Distance> distanceTree;

	public Set<Distance> getDistanceTree() {
		return distanceTree;
	}

	public void setDistanceTree(Set<Distance> distanceTree) {
		this.distanceTree = distanceTree;
	}

}
