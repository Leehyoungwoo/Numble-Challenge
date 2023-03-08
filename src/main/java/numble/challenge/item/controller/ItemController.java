package numble.challenge.item.controller;

import lombok.RequiredArgsConstructor;
import numble.challenge.domain.model.entity.Item;
import numble.challenge.item.controller.dto.ItemRequestSaveDto;
import numble.challenge.item.controller.dto.ItemRequestUpdateDto;
import numble.challenge.item.repository.ItemRepository;
import numble.challenge.item.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;
    private final ItemRepository itemRepository;

    @GetMapping("/api/item/save")
    public String saveForm(Model model) {
        model.addAttribute("item", new Item());
        return "itemSave-form";
    }

    @PostMapping("/api/item/save")
    public String save(@RequestBody ItemRequestSaveDto itemRequestSaveDto) {
        itemService.save(Item.toEntity(itemRequestSaveDto));
        return "redirect:/";
    }

    @GetMapping("/api/item/{id}/update")
    public String updateForm(@PathVariable Long id, Model model) {
        Item item = itemRepository.findById(id).orElse(null);
        model.addAttribute("item", item);
        return "itemUpdate-form";
    }

    @PostMapping("/api/item/{id}/update")
    public String update(@PathVariable Long id, ItemRequestUpdateDto itemRequestUpdateDto) {
        itemService.update(id, itemRequestUpdateDto);
        return "redirect:/";
    }
}
