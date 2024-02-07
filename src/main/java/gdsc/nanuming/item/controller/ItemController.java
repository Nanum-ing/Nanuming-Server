package gdsc.nanuming.item.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gdsc.nanuming.item.service.ItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/item")
@RequiredArgsConstructor
public class ItemController {

	private final ItemService itemService;

}
