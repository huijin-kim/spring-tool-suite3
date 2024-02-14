package test.com.member;

public interface MemberSQL {

	String INSERT = "insert into member(num,id,pw,name,tel) values(seq_member.nextval,?,?,?,?)";

	String UPDATE = "update member set pw=?,name=?,tel=? where num=?";

	String DELETE = "delete from member where num=?";

	String SELECT_ONE = "select * from member where num=?";
	String LOGIN = "select * from member where id=? and pw=?";

	String SELECT_ALL = "select * from member order by num asc";

	String SEARCHLIST_ID = "select * from member where id like ?";

	String SEARCHLIST_NAME = "select * from member where name like ?";

	String TOTAL_ROWS = "select count(*) total_rows from member";
	String SEARCH_TOTAL_ROWS_ID = "select count(*) total_rows from member  where id like ?";
	String SEARCH_TOTAL_ROWS_NAME = "select count(*) total_rows from member where name like ?";

	String SELECT_ALL_PAGE_BLOCK = "select rnum,num,id ,pw,name,tel "
			+ "from (select rownum rnum,num,id ,pw,name,tel "
			+ "from member "
			+ "order by num asc) "
			+ "where rnum between ? and ?";
	
	String SEARCHLIST_PAGE_BLOCK_ID = "select rnum,num,id ,pw,name,tel "
			+ "from (select rownum rnum,num,id ,pw,name,tel "
			+ "from member "
			+ "where id like ? "
			+ "order by num asc) "
			+ "where rnum between ? and ?";
	String SEARCHLIST_PAGE_BLOCK_NAME = "select rnum,num,id ,pw,name,tel "
			+ "from (select rownum rnum,num,id ,pw,name,tel "
			+ "from member "
			+ "where name like ? "
			+ "order by num asc) "
			+ "where rnum between ? and ?";
	
}
