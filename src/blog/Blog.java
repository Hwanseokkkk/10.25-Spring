package blog;

import java.util.ArrayList;

public class Blog {
	
	private int blogId; //Java 내에서는 _를 잘 안쓴다. 매핑할 때 blog_Id로 설정해주면 된다~
	private String title;
	private Author author; //Blog하나가 association하나.. 1:1 관계
	private ArrayList<Post> posts; //collection
	
	public Blog(int blogId) { //constructor로 했는데 프라퍼티 없이 정의가 되겠냐?? 해줘야한다.
		this.blogId = blogId;
	}
	
	
}

