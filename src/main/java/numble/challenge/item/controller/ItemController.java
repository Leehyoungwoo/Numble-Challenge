package numble.challenge.item.controller;

import lombok.RequiredArgsConstructor;
import numble.challenge.domain.model.entity.Item;
import numble.challenge.item.controller.dto.ItemRequestSaveDto;
import numble.challenge.item.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @PostMapping("/api/item")
    public String save(@RequestBody ItemRequestSaveDto itemRequestSaveDto) {
        itemService.save(Item.toEntity(itemRequestSaveDto));
        return "viewName";
    }
}
