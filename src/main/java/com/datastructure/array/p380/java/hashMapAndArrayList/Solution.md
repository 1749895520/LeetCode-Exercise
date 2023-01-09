# p380 O(1) 时间插入、删除和获取随机元素
---

## 哈希表 + 数组

### 代码

```java
public class RandomizedSet {
    ArrayList<Integer> list;
    HashMap<Integer, Integer> map;

    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        Integer i = map.get(val);
        swap(i, list.size() - 1);
        list.remove(list.size() - 1);
        map.remove(val);
        return true;
    }

    private void swap(int i1, int i2) {
        map.put(list.get(i2), i1);
        Integer temp = list.get(i1);
        list.set(i1, list.get(i2));
        list.set(i2, temp);
    }

    public int getRandom() {
        int num = new Random().nextInt(list.size());
        return list.get(num);
    }
}
```

### 分析

无。
