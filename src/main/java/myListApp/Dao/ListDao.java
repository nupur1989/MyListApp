package myListApp.Dao;

import myListApp.Entity.MyList;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ListDao {

    Map<String, List<MyList>> inMemoryDB;

    public ListDao(){
        inMemoryDB = new HashMap<>();

        inMemoryDB.put("1", new ArrayList<>());
        inMemoryDB.put("2", new ArrayList<>());
        inMemoryDB.put("3", new ArrayList<>());
    }

    public List<MyList> getListsbyUserId(String userId){

        if(!inMemoryDB.containsKey(userId)){
            return new ArrayList<>();
        }

      List<MyList> mylist =  inMemoryDB.get(userId);
       return mylist;
    }

    public void addList(String userId, List<MyList> myList){
         inMemoryDB.put(userId, myList);
    }
}
