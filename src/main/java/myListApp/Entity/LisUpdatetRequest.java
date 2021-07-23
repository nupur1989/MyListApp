package myListApp.Entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class LisUpdatetRequest {

    String listName;
    String itemName;
}
