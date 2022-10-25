package myBatis.test.main;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import myBatis.test.dto.User;

public class UserTest {

	public static void main(String[] args) {
		String resource = "myBatis/test/sqlmapconfig/sqlMapConfig.xml";
		Reader reader;
		SqlSession session = null;
		try {
			reader = Resources.getResourceAsReader(resource);
			SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);
			session = sqlMapper.openSession();
			/* insert */
			User user = new User();
			user.setEmail("a@a.com");
			user.setName("a");
			user.setPasswd("apass");
			int result = session.insert("insertUser", user);
			session.commit();
			if (result > 0) {
				System.out.println(user + "입력 성공!!");
			}
			// select(list)
			List<User> list = session.selectList("selectAllUsers");
			for (User eachUser : list) {
				System.out.println(eachUser);
			}
			// delete
//			int result2= session.delete("deleteUser",2);
//			session.commit();
//			if(result2>0) {
//				System.out.println("2번 캇!!!!!!!!!!!!!!!!!!!!!!!!!!");
//			}
			// update
			User user2 = new User();
			user2.setSid(3);
			user2.setEmail("aaa@aaa.com");
			user2.setName("aaa");
			user2.setPasswd("apasaaas");
			int result3 = session.update("updateUser", user2);
			session.commit();
			if (result3 > 0) {
				System.out.println("3번 수정 완료!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
	}
}
