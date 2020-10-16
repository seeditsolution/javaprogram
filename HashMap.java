import java.util.HashMap;
import java.util.Map;
 
public class Hashmap
{
public static void main(String[] args)
{
HashMap<String, Integer> map = new HashMap<>();
print(map);
map.put("abc", 10);
map.put("mno", 30);
map.put("xyz", 20);
 
System.out.println("Size of map is" + map.size());
 
print(map);
if (map.containsKey("abc"))
{
Integer a = map.get("abc");
System.out.println("value for key \"abc\" is:- " + a);
}
map.clear();
print(map);
}
public static void print(Map<String, Integer> map)
{
if (map.isEmpty())
{
System.out.println("map is empty");
}
else
{
System.out.println(map);
}
}
}
On executing the HashMap program, output goes like this:

1
2
3
4
5
map is empty
Size of map is:- 3
{abc=10, xyz=20, mno=30}
value for key "abc" is:- 10
map is empty
