package numble.challenge.item.controller;

import lombok.RequiredArgsConstructor;
import numble.challenge.domain.model.entity.Item;
import numble.challenge.item.controller.dto.ItemRequestSaveDto;
import numble.challenge.item.controller.dto.ItemRequestUpdateDto;
import numble.challenge.item.controller.dto.ItemResponseDto;
import numble.challenge.item.repository.ItemRepository;
import numble.challenge.item.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @DeleteMapping("/api/item/{Id}")
    public String delete(@PathVariable Long Id) {
        itemService.delete(Id);
        return "redirect:/";
    }

    @GetMapping("/api/items")
    public String findAllItem(Model model) {
        List<ItemResponseDto> items = itemService.findAllItem();
        model.addAttribute("items", items);
        return "item-list";
    }

    @GetMapping("/api/items/{id}")
    public String getItemDetail(@PathVariable Long id, Model model) {
        ItemResponseDto itemResponseDto = itemService.getItemDetail(id);
        model.addAttribute("item", itemResponseDto);
        return "item-detail";
    }
}
