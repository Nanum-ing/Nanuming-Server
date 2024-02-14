package gdsc.nanuming.location.dto.request;

import gdsc.nanuming.common.UserMapPolygon;
import lombok.Getter;

@Getter
public class ShowNearLocationListRequest implements UserMapPolygon {

	private double latitude;
	private double longitude;
	private double latitudeDelta;
	private double longitudeDelta;

}
