package hello.itemservice.domain.item;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ItemRepository {

    // 키는 id 값은 Item 엔티티
    private static final Map<Long, Item> store = new HashMap<>(); // static
    private static long sequence = 0L; // static (스프링컨테이너에서는 어차피 싱글톤이라 static안써도되는데 안썻을때 new하면 계속 생성됨

    // 저장기능
    public Item save(Item item) {
        // 아이템에 넣으면 시퀀스값증가
        item.setId(++sequence);
        // item의 n번에 item이 들어감
        store.put(item.getId(), item);
        return item;
    }

    // 조회기능
    public Item findById(Long id) {
        return store.get(id);
    }

    // 전체조회
    public List<Item> findAll() {
        // ArrayList를 한번 감싸서 반환하게되면 값을 넣어도 실제 store에는 변함이없게 하기 위해
        return new ArrayList<>(store.values());
    }

    // 아이템 아이디를 넣고 그 아이템과 관련된 update파라미터를 넣으면 업데이트 되도록함
    public void update(Long itemId, Item updateParam) {
        // 업데이트하려면 아이템을 찾아야함
        Item findItem = findById(itemId);
        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());
    }

    // store 다 날리기 (테스트를 위해)
    public void clearStore() {
        store.clear();
    }
}
