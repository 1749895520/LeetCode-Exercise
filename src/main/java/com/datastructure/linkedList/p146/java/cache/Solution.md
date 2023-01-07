# p146 LRU 缓存
---

## 缓存

### 代码

```java
public class LRUCache {
    LinkedHashMap<Integer, Integer> cache;
    int capacity;

    public LRUCache(int capacity) {
        cache = new LinkedHashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Integer value = cache.get(key);
            cache.remove(key);
            cache.put(key, value);
            return value;
        }
        return -1;
    }

    public void put(int key, int value) {
        get(key);
        cache.put(key, value);
        if (cache.size() > capacity) {
            Integer removeKey = cache.keySet().iterator().next();
            cache.remove(removeKey);
        }
    }
}
```

### 分析

利用 LinedHashMap 既有双向链表的特性又有哈希表的特性实现 LRU 缓存。
