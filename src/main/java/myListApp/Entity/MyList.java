package myListApp.Entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
@Builder
public class MyList {
    String name;
    List<Item> items;
}
