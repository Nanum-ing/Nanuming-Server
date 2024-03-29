package gdsc.nanuming.item.dto.response;

import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ShowItemDetailResponse {

	private Long itemId;
	private Long lockerId;
	private String title;
	private List<String> itemImageUrlList;
	private String category;
	private String nickname;
	private String locationName;
	private String description;
	private boolean isOwner;
	private String createdAt;
	private String updatedAt;

	@Builder
	private ShowItemDetailResponse(Long itemId, Long lockerId, String title, List<String> itemImageUrlList,
		String category, String nickname, String locationName, String description, boolean isOwner, String createdAt,
		String updatedAt) {
		this.itemId = itemId;
		this.lockerId = lockerId;
		this.title = title;
		this.itemImageUrlList = itemImageUrlList;
		this.category = category;
		this.nickname = nickname;
		this.locationName = locationName;
		this.description = description;
		this.isOwner = isOwner;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public static ShowItemDetailResponse of(Long itemId, Long lockerId, String title, List<String> itemImageUrlList,
		String category, String nickname, String locationName, String description, boolean isOwner, String createdAt,
		String updatedAt) {
		return ShowItemDetailResponse.builder()
			.itemId(itemId)
			.lockerId(lockerId)
			.title(title)
			.itemImageUrlList(itemImageUrlList)
			.category(category)
			.nickname(nickname)
			.locationName(locationName)
			.description(description)
			.isOwner(isOwner)
			.createdAt(createdAt)
			.updatedAt(updatedAt)
			.build();
	}

}
