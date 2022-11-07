import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import fr.gdai.mybatis.mapper.DeptMapper;
import fr.gdai.mybatis.mapper.EmpMapper;
import fr.gdai.mybatis.pojo.Emp;
import fr.gdai.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class PageHelperTest {
    @Test
    public void testSelectAllEmpsInPageHelper() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        // 在查询功能之前，开启分页功能，page获取简单分页信息
        Page<Object> page = PageHelper.startPage(1,2);
        List<Emp> result = empMapper.getAllEmp();
        for (Emp e:result) {
            System.out.println(e.toString());
        }
        System.out.println(
                "每页显示" + page.getPageSize() + "条记录" + "\t"
                + "当前页数：" + page.getPageNum() + "\t"
                + "共" + page.getPages() + "页，" + page.getTotal() + "条数据\n");
    }

    @Test
    public void testSelectAllEmpsInPageHelperPageInfo() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        // 在查询功能之前，开启分页功能
        PageHelper.startPage(5,2);
        List<Emp> result = empMapper.getAllEmp();
        // 在查询功能之后，pageInfo获取分页的详细信息
        PageInfo<Emp> pageInfo = new PageInfo<>(result, 5);
        for (Emp e:result) {
            System.out.println(e.toString());
        }
        System.out.println(
                "本页记录数：" + pageInfo.getSize() +"/"+ pageInfo.getPageSize() + "\t"
                + "共" + pageInfo.getPages() + "页，" + pageInfo.getTotal() + "条数据\n"
                + "当前页数：" + pageInfo.getPageNum() + "\t"
                + "是否有上一页：" + pageInfo.isHasPreviousPage() + "\t"
                + "是否有下一页：" + pageInfo.isHasNextPage() + "\t"
                + "导航分页的页码：" + Arrays.toString(pageInfo.getNavigatepageNums()) + "\t");
    }
}
