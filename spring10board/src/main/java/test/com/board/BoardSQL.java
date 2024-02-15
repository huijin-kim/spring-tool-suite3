package test.com.board;

public interface BoardSQL {

	String INSERT = "insert into board(num,title,content,writer) values(seq_board.nextval,?,?,?)";

	String UPDATE = "update board set title=?,content=?,writer=?,wdate=sysdate where num=?";

	String DELETE = "delete from board where num=?";

	String SELECT_ONE = "select * from board where num=?";

	String SELECT_ALL = "select * from board order by num desc";

	String SELECT_ALL_PAGE_BLOCK = "select rnum,num,title ,content,writer,wdate "
			+ "from (select rownum rnum,num,title ,content,writer,wdate "
			+ "from board "
			+ "order by num desc) "
			+ "where rnum between ? and ?";
	
	
	String SEARCHLIST_TITLE = "select * from board where title like ? order by num desc";
	
	String SEARCHLIST_CONTENT = "select * from board where content like ? order by num desc";

	String TOTAL_ROWS = "select count(*) total_rows from board";

	String SEARCHLIST_PAGE_BLOCK_TITLE = "select rnum,num,title ,content,writer,wdate "
			+ "from (select rownum rnum,num,title ,content,writer,wdate "
			+ "from board where title like ?"
			+ "order by num desc) "
			+ "where rnum between ? and ?";

	String SEARCHLIST_PAGE_BLOCK_CONTENT = "select rnum,num,title ,content,writer,wdate "
			+ "from (select rownum rnum,num,title ,content,writer,wdate "
			+ "from board where content like ?"
			+ "order by num desc) "
			+ "where rnum between ? and ?";

	String SEARCH_TOTAL_ROWS_TITLE = "select count(*) total_rows from board  where title like ?";

	String SEARCH_TOTAL_ROWS_CONTENT = "select count(*) total_rows from board  where content like ?";
	
}
