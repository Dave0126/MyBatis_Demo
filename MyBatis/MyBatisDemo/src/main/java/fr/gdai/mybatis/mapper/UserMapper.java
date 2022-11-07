package fr.gdai.mybatis.mapper;

import fr.gdai.mybatis.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    /*----------------------------- insert -----------------------------*/
    int insertUser(); // 返回受影响的行数
    // 当mapper接口方法的参数是实体类类型参数时
    int insertUserByEntity(User u1);

    /*----------------------------- update -----------------------------*/
    int updateUser();

    /*----------------------------- delete -----------------------------*/
    int deleteUser();

    // 批量删除
    int deleteSomeUsers();

    /*----------------------------- select -----------------------------*/

    // 查询返回单个实体类
    User selectUserById(@Param("id") int id);

    // 根据id查询用户信息，返回值是一个Map集合，而不是是实体类
    Map<String, Object> selectUserByIdToMap(@Param("id") int id);

    // (1) 查询返回多个实例类数组
    List<User> selectAllUser();

    // (2) 查询返回多个Map集合: List<Map<>>
    List<Map<String, Object>> selectAllUserToListMap();

    // (3) 查询返回多个Map集合: Map<Map<>>
    // @MapKey("") 注解可以设置Map的key，将内部的Map中某一个key对应的value 作为外部Map的key
    @MapKey("id")
    Map<String, Map<String, Object>> selectAllUserToMapMap();

    // （单行单列）查询用户信息的总记录数
    int selectUserCount();

    // 根据用户名查询用户信息（单字面量）
    User selectUserByUsername(String username);

    // 验证登陆（两个字面量）
    User selectUserByIdAndPassword(String username, String password);

    // 当mapper接口的方法参数有多个时，我们可以手动将这些参数存储在Map中
    User selectUserByMap(Map<String, Object> map);

    // 使用@Param注解来命名MyBatis自动提供的Map对象的key
    User selectUserByAnnotation(@Param("username") String username,
                                @Param("password") String password);

    // 模糊查询：
    // 模糊查询的SQL语句形如：select * from t_user where name like '%g%';
    // 我们可以看到，在语句中我们需要传入的参数是"g"这个字符串，当我们使用
    //      - #{} 时，在执行SQL语句时会转化为 '%?%'，此时模糊查询的内容就变成了"?"
    //      - ${}，我们应该使用这个占位符， ${} 所转化的字符是 g
    //  - 或者直接使用SQL中的concat()函数，进行字符串拼接
    //  - 或者直接使用 select * from t_user where name like "%"#{}"%"
    List<User> selectUserByNameLike(@Param("username") String name);
}
