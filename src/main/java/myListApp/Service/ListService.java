package myListApp.Service;

import myListApp.Dao.ListDao;
import myListApp.Entity.Item;
import myListApp.Entity.MyList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ListService {
    @Autowired
    ListDao listDao;

    public void createList(String userId, MyList myList){

       if( myList.getItems() == null){
           myList.setItems(new ArrayList<>());
       }
        //fetch user , lists, add new list to it.
        List<MyList> userLists = listDao.getListsbyUserId(userId);

        userLists.add(myList);
        //not needed to explicitly update hashmap stores reference to list object.
       // listDao.addList(userId, userLists);
    }

    public void addItemToAList(String userId,String listName, Item item){

        List<MyList> userLists = listDao.getListsbyUserId(userId);

        //assuming list is present
        for(MyList userList : userLists){

            if(userList.getName().equals(listName)){

                userList.getItems().add(item);
            }
        }
        //not needed to explicitly update hashmap stores reference to list object.
        //listDao.addList(userId, userLists);
    }

    public List<MyList> getLists(String userId){

        return listDao.getListsbyUserId(userId);
    }

    public List<Item> getItemsForAList(String userId, String listName) {

        List<MyList> userLists =  listDao.getListsbyUserId(userId);
        for(MyList userList : userLists){

            if(userList.getName().equals(listName)){
                return userList.getItems();
            }
        }
        return null;
    }

    public List<Item> deleteItem(String userId, String listName, Item item){

        List<MyList> myLists = listDao.getListsbyUserId(userId);
        List<Item> items = null;
        for( MyList myList : myLists){

            if(myList.getName().equals(listName)){

                items = myList.getItems();
                Iterator<Item> it = items.iterator();
                while(it.hasNext()){

                    Item itm = (it.next());
                    if(itm.getName().equals(item.getName()))
                        it.remove();
                }
            }
        }

        listDao.addList(userId, myLists);
        return items;
    }

}
