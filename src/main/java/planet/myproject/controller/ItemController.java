package planet.myproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import planet.myproject.domain.*;
import planet.myproject.repository.ContentsRepository;
import planet.myproject.repository.ParticipateRepository;
import planet.myproject.service.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class ItemController {

    private final ContentsService contentsService;
    private final ItemService itemService;
    private final ContentsRepository contentsRepository;
    private final MemberService memberService;
    private final ParticipateService participateService;
    private final ParticipateRepository participateRepository;

    @GetMapping("/items/itemList")
    public String itemList(Model model) {
        List<Item> items = itemService.findItems();
        model.addAttribute("items",items);

        return "/items/itemList";
    }

    @GetMapping(value = "/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }


    @GetMapping("/items/new")
    public String createItem(Model model) {

        model.addAttribute("form", new ItemForm());

        List<Contents> contentsList = contentsService.findContents();
        model.addAttribute("contentsList", contentsList);

        return "/items/itemCreateForm";
    }


    /**
     * 아이템 만들기
     */
    @PostMapping(value = "/items/new")
    public String makeItem(ItemForm form,
                           @RequestParam(value = "checkedContents", required=true) List<Integer> checkedArr) {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails) principal).getUsername();

        Item item = new Item();
        ItemContents itemContents = new ItemContents();
        item.setItemName(form.getItemName());
        item.setPeriod(form.getPeriod());
        item.setItemExplanation(form.getItemExplanation());
        item.setMakerId(username);

        int price =0;
        for (int i = 0 ; i < checkedArr.size(); i++){
            Optional<Contents> optionalContents = contentsRepository.findByContentsNum(checkedArr.get(i));
            Contents contents = optionalContents.get();
            price += contents.getContentsPrice();
            item.addItemContents(itemContents.contentsToItemContents(contents));
        }

        item.setItemPrice(price);

        itemService.saveItem(item);

        return "redirect:/items/itemList";
    }

    /**
     * 상품 상세보기
     */
    @GetMapping(value = "/items/details/{itemId}")
    public String itemDetails(@PathVariable("itemId") Long itemId, Model model) {

        //아이템 조회
        Optional<Item> optionalItem = itemService.findById(itemId);
        Item item = optionalItem.get();
        model.addAttribute("item", item);

        //ItemContents 조회
        List<ItemContents> itemContentsList = itemService.findByItemId(itemId);
        List<Contents> contentsList = new ArrayList<>();

        //ItemContents > Contents 변경
        for (int i = 0; i < itemContentsList.size(); i++) {
            Contents contents = itemContentsList.get(i).getContents();
            contentsList.add(contents);
        }

        model.addAttribute("contentsList", contentsList);

        return "/items/itemDetails";
    }

    @PostMapping(value = "/members/{itemId}/join")
    public String participate(@PathVariable("itemId") Long itemId) {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails) principal).getUsername();

        participateService.participate(username, itemId);

        return "redirect:/";
    }



}

