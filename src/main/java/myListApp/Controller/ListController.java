package myListApp.Controller;

import myListApp.Entity.Item;
import myListApp.Entity.LisUpdatetRequest;
import myListApp.Entity.MyList;
import myListApp.Service.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/")
public class ListController {


    @Autowired
    ListService listService;

    @RequestMapping(value= "/list/addList/{userId}", method = RequestMethod.POST)
    public void createList(@PathVariable(value="userId") String userId, @RequestBody MyList myList){

        listService.createList(userId, myList);

    }

    @RequestMapping(value= "/list/addItem/{userId}", method = RequestMethod.POST)
    public void addItemToAList(@PathVariable(value="userId") String userId,
                               @RequestBody LisUpdatetRequest item){


        listService.addItemToAList(userId, item.getListName(), Item.builder().name(item.getItemName()).build());
    }

    @RequestMapping(value= "/list/{userId}", method = RequestMethod.GET)
    public List<MyList> getLists(@PathVariable(value="userId")  String userId){

        return listService.getLists(userId);

    }

    @RequestMapping(value= "/list/items/{userId}/{name}", method = RequestMethod.GET)
    public List<Item> getItemsForAList(@PathVariable(value="userId")  String userId,
                                 @PathVariable(value="name") String name) {

        return listService.getItemsForAList(userId, name);

    }

    //delete item from list
    @RequestMapping(value= "/list/deleteItem/{userId}", method = RequestMethod.POST)
    public List<Item> deleteItem (@PathVariable(value ="userId") String userId, @RequestBody LisUpdatetRequest updateRequest){

        return listService.deleteItem(userId, updateRequest.getListName(), Item.builder().name(updateRequest.getItemName()).build());
    }
}
